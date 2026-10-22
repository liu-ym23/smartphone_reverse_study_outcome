package com.android.server.attention;

import android.R;
import android.app.ActivityThread;
import android.attention.AttentionManagerInternal;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.hardware.SensorPrivacyManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.service.attention.IAttentionCallback;
import android.service.attention.IAttentionService;
import android.service.attention.IProximityUpdateCallback;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.ISmtResourceControl;
import com.android.server.SystemService;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.job.controllers.JobStatus;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class AttentionManagerService extends SystemService {
    protected static final int ATTENTION_CACHE_BUFFER_SIZE = 5;
    private static final long CONNECTION_TTL_MILLIS = 60000;
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_SERVICE_ENABLED = true;
    static final long DEFAULT_STALE_AFTER_MILLIS = 1000;
    static final String KEY_SERVICE_ENABLED = "service_enabled";
    static final String KEY_STALE_AFTER_MILLIS = "stale_after_millis";
    private static final String LOG_TAG = "AttentionManagerService";
    private static final long SERVICE_BINDING_WAIT_MILLIS = 1000;
    private static String sTestAttentionServicePackage;
    private AttentionCheckCacheBuffer mAttentionCheckCacheBuffer;
    private AttentionHandler mAttentionHandler;
    private boolean mBinding;
    ComponentName mComponentName;
    private final AttentionServiceConnection mConnection;
    private final Context mContext;
    AttentionCheck mCurrentAttentionCheck;
    ProximityUpdate mCurrentProximityUpdate;
    boolean mIsProximityEnabled;
    boolean mIsServiceEnabled;
    private final Object mLock;
    private final PowerManager mPowerManager;
    private final SensorPrivacyManager mPrivacyManager;
    protected IAttentionService mService;
    private CountDownLatch mServiceBindingLatch;
    long mStaleAfterMillis;

    static final class AttentionCheck {
        private final AttentionManagerInternal.AttentionCallbackInternal mCallbackInternal;
        private final IAttentionCallback mIAttentionCallback;
        private boolean mIsDispatched;
        private boolean mIsFulfilled;

        /* JADX INFO: renamed from: -$$Nest$fgetmCallbackInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ AttentionManagerInternal.AttentionCallbackInternal m1907$$Nest$fgetmCallbackInternal(AttentionCheck r0) {
            return r0.mCallbackInternal;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIAttentionCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ IAttentionCallback m1908$$Nest$fgetmIAttentionCallback(AttentionCheck r0) {
            return r0.mIAttentionCallback;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsDispatched, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1909$$Nest$fgetmIsDispatched(AttentionCheck r0) {
            return r0.mIsDispatched;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsFulfilled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1910$$Nest$fgetmIsFulfilled(AttentionCheck r0) {
            return r0.mIsFulfilled;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIsDispatched, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1911$$Nest$fputmIsDispatched(AttentionCheck r0, boolean r1) {
            r0.mIsDispatched = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIsFulfilled, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1912$$Nest$fputmIsFulfilled(AttentionCheck r0, boolean r1) {
            r0.mIsFulfilled = r1;
        }

        AttentionCheck(final AttentionManagerInternal.AttentionCallbackInternal callbackInternal, final AttentionManagerService service) {
            this.mCallbackInternal = callbackInternal;
            this.mIAttentionCallback = new AnonymousClass1(this, callbackInternal, service);
        }

        void cancelInternal() {
            this.mIsFulfilled = true;
            this.mCallbackInternal.onFailure(3);
        }

        void dump(IndentingPrintWriter ipw) {
            ipw.increaseIndent();
            ipw.println("is dispatched=" + this.mIsDispatched);
            ipw.println("is fulfilled:=" + this.mIsFulfilled);
            ipw.decreaseIndent();
        }
    }

    protected static final class AttentionCheckCache {
        private final long mLastComputed;
        private final int mResult;
        private final long mTimestamp;

        /* JADX INFO: renamed from: -$$Nest$fgetmLastComputed, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m1913$$Nest$fgetmLastComputed(AttentionCheckCache r2) {
            return r2.mLastComputed;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmResult, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1914$$Nest$fgetmResult(AttentionCheckCache r0) {
            return r0.mResult;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTimestamp, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m1915$$Nest$fgetmTimestamp(AttentionCheckCache r2) {
            return r2.mTimestamp;
        }

        AttentionCheckCache(long lastComputed, int result, long timestamp) {
            this.mLastComputed = lastComputed;
            this.mResult = result;
            this.mTimestamp = timestamp;
        }
    }

    protected static final class AttentionCheckCacheBuffer {
        private final AttentionCheckCache[] mQueue;
        private int mSize;
        private int mStartIndex;

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1916$$Nest$mdump(AttentionCheckCacheBuffer r0, IndentingPrintWriter r1) {
            r0.dump(r1);
        }

        AttentionCheckCacheBuffer() {
            this.mQueue = new AttentionCheckCache[5];
            this.mStartIndex = 0;
            this.mSize = 0;
        }

        public AttentionCheckCache getLast() {
            int lastIdx = ((this.mStartIndex + this.mSize) - 1) % 5;
            if (this.mSize != 0) goto L6;
            return null;
        L6:
            return this.mQueue[lastIdx];
        }

        public void add(AttentionCheckCache cache) {
            int nextIndex = (this.mStartIndex + this.mSize) % 5;
            this.mQueue[nextIndex] = cache;
            if (this.mSize != 5) goto L5;
            this.mStartIndex++;
            return;
        L5:
            this.mSize++;
        }

        public AttentionCheckCache get(int offset) {
            if (offset < this.mSize) goto L6;
            return null;
        L6:
            return this.mQueue[(this.mStartIndex + offset) % 5];
        }

        private void dump(IndentingPrintWriter ipw) {
            ipw.println("attention check cache:");
            int i = 0;
        L4:
            if (i >= this.mSize) goto L10;
            AttentionCheckCache cache = get(i);
            if (cache == null) goto L8;
            ipw.increaseIndent();
            ipw.println("timestamp=" + AttentionCheckCache.m1915$$Nest$fgetmTimestamp(cache));
            ipw.println("result=" + AttentionCheckCache.m1914$$Nest$fgetmResult(cache));
            ipw.decreaseIndent();
        L8:
            i = i + 1;
            goto L4
        }
    }

    protected class AttentionHandler extends Handler {
        private static final int ATTENTION_CHECK_TIMEOUT = 2;
        private static final int CHECK_CONNECTION_EXPIRATION = 1;
        final /* synthetic */ AttentionManagerService this$0;

        AttentionHandler(AttentionManagerService this$0) {
            this.this$0 = this$0;
            super(Looper.myLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L13;
                case 2: goto L5;
                default: goto L26;
            };
        L5:
            Object r0 = AttentionManagerService.m1897$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.cancel();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            Object r1 = AttentionManagerService.m1897$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            AttentionManagerService.m1902$$Nest$mcancelAndUnbindLocked(this.this$0);     // Catch: Throwable -> L18
            monitor-exit(r1);     // Catch: Throwable -> L18
            return;
        L18:
            th = move-exception;
            throw th;
        }
    }

    private final class AttentionManagerServiceShellCommand extends ShellCommand {
        final TestableAttentionCallbackInternal mTestableAttentionCallback;
        final TestableProximityUpdateCallbackInternal mTestableProximityUpdateCallback;
        final /* synthetic */ AttentionManagerService this$0;

        class TestableAttentionCallbackInternal extends AttentionManagerInternal.AttentionCallbackInternal {
            private int mLastCallbackCode;

            TestableAttentionCallbackInternal(AttentionManagerServiceShellCommand this$1) {
                this.mLastCallbackCode = -1;
            }

            public void onSuccess(int result, long timestamp) {
                this.mLastCallbackCode = result;
            }

            public void onFailure(int error) {
                this.mLastCallbackCode = error;
            }

            public void reset() {
                this.mLastCallbackCode = -1;
            }

            public int getLastCallbackCode() {
                return this.mLastCallbackCode;
            }
        }

        class TestableProximityUpdateCallbackInternal implements AttentionManagerInternal.ProximityUpdateCallbackInternal {
            private double mLastCallbackCode;

            TestableProximityUpdateCallbackInternal(AttentionManagerServiceShellCommand this$1) {
                this.mLastCallbackCode = -1.0d;
            }

            public void onProximityUpdate(double distance) {
                this.mLastCallbackCode = distance;
            }

            public void reset() {
                this.mLastCallbackCode = -1.0d;
            }

            public double getLastCallbackCode() {
                return this.mLastCallbackCode;
            }
        }

        /* synthetic */ AttentionManagerServiceShellCommand(AttentionManagerService r1, AttentionManagerServiceIA r2) {
            this(r1);
        }

        private AttentionManagerServiceShellCommand(AttentionManagerService r1) {
            this.this$0 = r1;
            this.mTestableAttentionCallback = new TestableAttentionCallbackInternal(this);
            this.mTestableProximityUpdateCallback = new TestableProximityUpdateCallbackInternal(this);
        }

        public int onCommand(String cmd) {
            if (cmd == null) goto L4;
            PrintWriter err = getErrPrintWriter();
            byte r3 = 0;
            switch(cmd.hashCode()) {
                case -1208709968: goto L27;
                case -1002424240: goto L24;
                case -415045819: goto L21;
                case 3045982: goto L18;
                case 1048378748: goto L15;
                case 1193447472: goto L10;
                default: goto L29;
            };     // Catch: IllegalArgumentException -> L12
        L29:
            byte r2 = -1;
        L30:
            switch(r2) {
                case 0: goto L69;
                case 1: goto L41;
                case 2: goto L40;
                case 3: goto L38;
                case 4: goto L36;
                case 5: goto L34;
                default: goto L32;
            };     // Catch: IllegalArgumentException -> L12
        L41:
            String r4 = getNextArgRequired();     // Catch: IllegalArgumentException -> L12
            switch(r4.hashCode()) {
                case -1571871954: goto L54;
                case 685821932: goto L51;
                case 763077136: goto L48;
                case 1485997302: goto L45;
                default: goto L56;
            };     // Catch: IllegalArgumentException -> L12
        L56:
            r3 = -1;
        L57:
            switch(r3) {
                case 0: goto L67;
                case 1: goto L65;
                case 2: goto L63;
                case 3: goto L61;
                default: goto L59;
            };     // Catch: IllegalArgumentException -> L12
        L59:
            throw new IllegalArgumentException("Invalid argument");     // Catch: IllegalArgumentException -> L12
        L61:
            return cmdCallOnStopProximityUpdates();
        L63:
            return cmdCallOnStartProximityUpdates();
        L65:
            return cmdCallCancelAttention();
        L67:
            return cmdCallCheckAttention();
        L45:
            if (r4.equals("checkAttention") == false) goto L56;
        L48:
            if (r4.equals("cancelCheckAttention") == false) goto L56;
            r3 = 1;
            goto L57
        L51:
            if (r4.equals("onStopProximityUpdates") == false) goto L56;
            r3 = 3;
            goto L57
        L54:
            if (r4.equals("onStartProximityUpdates") == false) goto L56;
            r3 = 2;
            goto L57
        L32:
            return handleDefaultCommands(cmd);
        L34:
            return cmdGetLastTestProximityUpdateCallbackCode();
        L36:
            return cmdGetLastTestCallbackCode();
        L38:
            return cmdClearTestableAttentionService();
        L40:
            return cmdSetTestableAttentionService(getNextArgRequired());
        L69:
            return cmdResolveAttentionServiceComponent();
        L10:
            if (cmd.equals("clearTestableAttentionService") == false) goto L29;
            r2 = 3;
            goto L30
        L15:
            if (cmd.equals("getLastTestProximityUpdateCallbackCode") == false) goto L29;
            r2 = 5;
            goto L30
        L18:
            if (cmd.equals("call") == false) goto L29;
            r2 = 1;
            goto L30
        L21:
            if (cmd.equals("setTestableAttentionService") == false) goto L29;
            r2 = 2;
            goto L30
        L24:
            if (cmd.equals("getAttentionServiceComponent") == false) goto L29;
            r2 = 0;
            goto L30
        L27:
            if (cmd.equals("getLastTestCallbackCode") == false) goto L29;
            r2 = 4;
        L12:
            e = move-exception;
            err.println("Error: " + e.getMessage());
            return -1;
        L4:
            return handleDefaultCommands(cmd);
        }

        private int cmdSetTestableAttentionService(String testingServicePackage) {
            PrintWriter out = getOutPrintWriter();
            String r2 = "false";
            if (TextUtils.isEmpty(testingServicePackage) == false) goto L5;
            out.println("false");
            return 0;
        L5:
            AttentionManagerService.m1905$$Nest$sfputsTestAttentionServicePackage(testingServicePackage);
            resetStates();
            if (this.this$0.mComponentName == null) goto L8;
            r2 = "true";
        L8:
            out.println(r2);
            return 0;
        }

        private int cmdClearTestableAttentionService() {
            AttentionManagerService.m1905$$Nest$sfputsTestAttentionServicePackage("");
            this.mTestableAttentionCallback.reset();
            this.mTestableProximityUpdateCallback.reset();
            resetStates();
            return 0;
        }

        private int cmdCallCheckAttention() {
            PrintWriter out = getOutPrintWriter();
            boolean calledSuccessfully = this.this$0.checkAttention(ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME, this.mTestableAttentionCallback);
            if (calledSuccessfully == false) goto L5;
            String r2 = "true";
        L6:
            out.println(r2);
            return 0;
        L5:
            r2 = "false";
            goto L6
        }

        private int cmdCallCancelAttention() {
            PrintWriter out = getOutPrintWriter();
            this.this$0.cancelAttentionCheck(this.mTestableAttentionCallback);
            out.println("true");
            return 0;
        }

        private int cmdCallOnStartProximityUpdates() {
            PrintWriter out = getOutPrintWriter();
            boolean calledSuccessfully = this.this$0.onStartProximityUpdates(this.mTestableProximityUpdateCallback);
            if (calledSuccessfully == false) goto L5;
            String r2 = "true";
        L6:
            out.println(r2);
            return 0;
        L5:
            r2 = "false";
            goto L6
        }

        private int cmdCallOnStopProximityUpdates() {
            PrintWriter out = getOutPrintWriter();
            this.this$0.onStopProximityUpdates(this.mTestableProximityUpdateCallback);
            out.println("true");
            return 0;
        }

        private int cmdResolveAttentionServiceComponent() {
            PrintWriter out = getOutPrintWriter();
            ComponentName resolvedComponent = AttentionManagerService.m1906$$Nest$smresolveAttentionService(AttentionManagerService.m1896$$Nest$fgetmContext(this.this$0));
            if (resolvedComponent == null) goto L5;
            String r2 = resolvedComponent.flattenToShortString();
        L6:
            out.println(r2);
            return 0;
        L5:
            r2 = "";
            goto L6
        }

        private int cmdGetLastTestCallbackCode() {
            PrintWriter out = getOutPrintWriter();
            out.println(this.mTestableAttentionCallback.getLastCallbackCode());
            return 0;
        }

        private int cmdGetLastTestProximityUpdateCallbackCode() {
            PrintWriter out = getOutPrintWriter();
            out.println(this.mTestableProximityUpdateCallback.getLastCallbackCode());
            return 0;
        }

        private void resetStates() {
            Object r0 = AttentionManagerService.m1897$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.mCurrentProximityUpdate = null;     // Catch: Throwable -> L8
            AttentionManagerService.m1902$$Nest$mcancelAndUnbindLocked(this.this$0);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            AttentionManagerService r1 = this.this$0;
            r1.mComponentName = AttentionManagerService.m1906$$Nest$smresolveAttentionService(AttentionManagerService.m1896$$Nest$fgetmContext(this.this$0));
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void onHelp() {
            PrintWriter out = getOutPrintWriter();
            out.println("Attention commands: ");
            out.println("  setTestableAttentionService <service_package>: Bind to a custom implementation of attention service");
            out.println("  ---<service_package>:");
            out.println("       := Package containing the Attention Service implementation to bind to");
            out.println("  ---returns:");
            out.println("       := true, if was bound successfully");
            out.println("       := false, if was not bound successfully");
            out.println("  clearTestableAttentionService: Undo custom bindings. Revert to previous behavior");
            out.println("  getAttentionServiceComponent: Get the current service component string");
            out.println("  ---returns:");
            out.println("       := If valid, the component string (in shorten form) for the currently bound service.");
            out.println("       := else, empty string");
            out.println("  call checkAttention: Calls check attention");
            out.println("  ---returns:");
            out.println("       := true, if the call was successfully dispatched to the service implementation. (to see the result, call getLastTestCallbackCode)");
            out.println("       := false, otherwise");
            out.println("  call cancelCheckAttention: Cancels check attention");
            out.println("  call onStartProximityUpdates: Calls onStartProximityUpdates");
            out.println("  ---returns:");
            out.println("       := true, if the request was successfully dispatched to the service implementation. (to see the result, call getLastTestProximityUpdateCallbackCode)");
            out.println("       := false, otherwise");
            out.println("  call onStopProximityUpdates: Cancels proximity updates");
            out.println("  getLastTestCallbackCode");
            out.println("  ---returns:");
            out.println("       := An integer, representing the last callback code received from the bounded implementation. If none, it will return -1");
            out.println("  getLastTestProximityUpdateCallbackCode");
            out.println("  ---returns:");
            out.println("       := A double, representing the last proximity value received from the bounded implementation. If none, it will return -1.0");
        }
    }

    private class AttentionServiceConnection implements ServiceConnection {
        final /* synthetic */ AttentionManagerService this$0;

        /* synthetic */ AttentionServiceConnection(AttentionManagerService r1, AttentionManagerServiceIA r2) {
            this(r1);
        }

        private AttentionServiceConnection(AttentionManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            init(IAttentionService.Stub.asInterface(service));
            AttentionManagerService.m1898$$Nest$fgetmServiceBindingLatch(this.this$0).countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            cleanupService();
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName name) {
            cleanupService();
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName name) {
            cleanupService();
        }

        void cleanupService() {
            init(null);
            AttentionManagerService.m1900$$Nest$fputmServiceBindingLatch(this.this$0, new CountDownLatch(1));
        }

        private void init(IAttentionService service) {
            Object r0 = AttentionManagerService.m1897$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.mService = service;     // Catch: Throwable -> L7
            AttentionManagerService.m1899$$Nest$fputmBinding(this.this$0, false);     // Catch: Throwable -> L7
            AttentionManagerService.m1904$$Nest$mhandlePendingCallbackLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private final class BinderService extends Binder {
        AttentionManagerServiceShellCommand mAttentionManagerServiceShellCommand;
        final /* synthetic */ AttentionManagerService this$0;

        /* synthetic */ BinderService(AttentionManagerService r1, AttentionManagerServiceIA r2) {
            this(r1);
        }

        private BinderService(AttentionManagerService r3) {
            this.this$0 = r3;
            this.mAttentionManagerServiceShellCommand = new AttentionManagerServiceShellCommand(this.this$0, null);
        }

        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            this.mAttentionManagerServiceShellCommand.exec(this, in, out, err, args, callback, resultReceiver);
        }

        @Override // android.os.Binder
        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(AttentionManagerService.m1896$$Nest$fgetmContext(this.this$0), AttentionManagerService.LOG_TAG, pw) == true) goto L5;
            return;
        L5:
            AttentionManagerService.m1903$$Nest$mdumpInternal(this.this$0, new IndentingPrintWriter(pw, "  "));
        }
    }

    private final class LocalService extends AttentionManagerInternal {
        final /* synthetic */ AttentionManagerService this$0;

        /* synthetic */ LocalService(AttentionManagerService r1, AttentionManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(AttentionManagerService r1) {
            this.this$0 = r1;
        }

        public boolean isAttentionServiceSupported() {
            return this.this$0.mIsServiceEnabled;
        }

        public boolean isProximitySupported() {
            return this.this$0.mIsProximityEnabled;
        }

        public boolean checkAttention(long timeout, AttentionManagerInternal.AttentionCallbackInternal callbackInternal) {
            return this.this$0.checkAttention(timeout, callbackInternal);
        }

        public void cancelAttentionCheck(AttentionManagerInternal.AttentionCallbackInternal callbackInternal) {
            this.this$0.cancelAttentionCheck(callbackInternal);
        }

        public boolean onStartProximityUpdates(AttentionManagerInternal.ProximityUpdateCallbackInternal callback) {
            return this.this$0.onStartProximityUpdates(callback);
        }

        public void onStopProximityUpdates(AttentionManagerInternal.ProximityUpdateCallbackInternal callback) {
            this.this$0.onStopProximityUpdates(callback);
        }
    }

    final class ProximityUpdate {
        private final AttentionManagerInternal.ProximityUpdateCallbackInternal mCallbackInternal;
        private final IProximityUpdateCallback mIProximityUpdateCallback;
        private boolean mStartedUpdates;
        final /* synthetic */ AttentionManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmCallbackInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ AttentionManagerInternal.ProximityUpdateCallbackInternal m1917$$Nest$fgetmCallbackInternal(ProximityUpdate r0) {
            return r0.mCallbackInternal;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIProximityUpdateCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ IProximityUpdateCallback m1918$$Nest$fgetmIProximityUpdateCallback(ProximityUpdate r0) {
            return r0.mIProximityUpdateCallback;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStartedUpdates, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1919$$Nest$fgetmStartedUpdates(ProximityUpdate r0) {
            return r0.mStartedUpdates;
        }

        ProximityUpdate(final AttentionManagerService this$0, AttentionManagerInternal.ProximityUpdateCallbackInternal callbackInternal) {
            this.this$0 = this$0;
            this.mCallbackInternal = callbackInternal;
            this.mIProximityUpdateCallback = new AnonymousClass1(this, this$0);
        }

        boolean startUpdates() {
            Object r0 = AttentionManagerService.m1897$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mStartedUpdates == false) goto L12;
            Slog.w(AttentionManagerService.LOG_TAG, "Already registered to a proximity service.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L12:
            if (this.this$0.mService != null) goto L26;
            Slog.w(AttentionManagerService.LOG_TAG, "There is no service bound. Proximity update request rejected.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L26:
            this.this$0.mService.onStartProximityUpdates(this.mIProximityUpdateCallback);     // Catch: Throwable -> L9 RemoteException -> L19
            this.mStartedUpdates = true;     // Catch: Throwable -> L9 RemoteException -> L19
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L19:
            e = move-exception;
            Slog.e(AttentionManagerService.LOG_TAG, "Cannot call into the AttentionService", e);     // Catch: Throwable -> L9
            return false;
        }

        void cancelUpdates() {
            Object r0 = AttentionManagerService.m1897$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mStartedUpdates == true) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (this.this$0.mService != null) goto L21;
            this.mStartedUpdates = false;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L21:
            this.this$0.mService.onStopProximityUpdates();     // Catch: Throwable -> L11 RemoteException -> L15
            this.mStartedUpdates = false;     // Catch: Throwable -> L11 RemoteException -> L15
        L15:
            e = move-exception;
            Slog.e(AttentionManagerService.LOG_TAG, "Cannot call into the AttentionService", e);     // Catch: Throwable -> L11
            goto L17
        }

        void dump(IndentingPrintWriter ipw) {
            ipw.increaseIndent();
            ipw.println("is StartedUpdates=" + this.mStartedUpdates);
            ipw.decreaseIndent();
        }
    }

    private final class ScreenStateReceiver extends BroadcastReceiver {
        final /* synthetic */ AttentionManagerService this$0;

        /* synthetic */ ScreenStateReceiver(AttentionManagerService r1, AttentionManagerServiceIA r2) {
            this(r1);
        }

        private ScreenStateReceiver(AttentionManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) == false) goto L12;
            Object r0 = AttentionManagerService.m1897$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            AttentionManagerService.m1902$$Nest$mcancelAndUnbindLocked(this.this$0);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$RvjZTBFTVfII2iNvPS-irqdvQOQ, reason: not valid java name */
    public static /* synthetic */ void m1894$r8$lambda$RvjZTBFTVfII2iNvPSirqdvQOQ(AttentionManagerService r0) {
        r0.lambda$bindLocked$2();
    }

    public static /* synthetic */ void $r8$lambda$UrIatsIB4OD2lVsYi16ivNoGLGc(AttentionManagerService r0) {
        r0.lambda$cancelAndUnbindLocked$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$stSyn7hlhd9--CC5JwSH3kztHgI, reason: not valid java name */
    public static /* synthetic */ void m1895$r8$lambda$stSyn7hlhd9CC5JwSH3kztHgI(AttentionManagerService r0, DeviceConfig.Properties r1) {
        r0.lambda$onBootPhase$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m1896$$Nest$fgetmContext(AttentionManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1897$$Nest$fgetmLock(AttentionManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceBindingLatch, reason: not valid java name */
    static /* bridge */ /* synthetic */ CountDownLatch m1898$$Nest$fgetmServiceBindingLatch(AttentionManagerService r0) {
        return r0.mServiceBindingLatch;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBinding, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1899$$Nest$fputmBinding(AttentionManagerService r0, boolean r1) {
        r0.mBinding = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmServiceBindingLatch, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1900$$Nest$fputmServiceBindingLatch(AttentionManagerService r0, CountDownLatch r1) {
        r0.mServiceBindingLatch = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mappendResultToAttentionCacheBuffer, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1901$$Nest$mappendResultToAttentionCacheBuffer(AttentionManagerService r0, AttentionCheckCache r1) {
        r0.appendResultToAttentionCacheBuffer(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelAndUnbindLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1902$$Nest$mcancelAndUnbindLocked(AttentionManagerService r0) {
        r0.cancelAndUnbindLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1903$$Nest$mdumpInternal(AttentionManagerService r0, IndentingPrintWriter r1) {
        r0.dumpInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePendingCallbackLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1904$$Nest$mhandlePendingCallbackLocked(AttentionManagerService r0) {
        r0.handlePendingCallbackLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$sfputsTestAttentionServicePackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1905$$Nest$sfputsTestAttentionServicePackage(String r0) {
        sTestAttentionServicePackage = r0;
    }

    /* JADX INFO: renamed from: -$$Nest$smresolveAttentionService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m1906$$Nest$smresolveAttentionService(Context r0) {
        return resolveAttentionService(r0);
    }

    public AttentionManagerService(Context context) {
        this(context, (PowerManager) context.getSystemService("power"), new Object(), null);
        this.mAttentionHandler = new AttentionHandler(this);
    }

    AttentionManagerService(Context context, PowerManager powerManager, Object lock, AttentionHandler handler) {
        super(context);
        this.mConnection = new AttentionServiceConnection(this, null);
        context.getClass();
        this.mContext = context;
        this.mPowerManager = powerManager;
        this.mLock = lock;
        this.mAttentionHandler = handler;
        this.mPrivacyManager = SensorPrivacyManager.getInstance(context);
        this.mServiceBindingLatch = new CountDownLatch(1);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        this.mContext.registerReceiver(new ScreenStateReceiver(this, null), new IntentFilter("android.intent.action.SCREEN_OFF"));
        readValuesFromDeviceConfig();
        DeviceConfig.addOnPropertiesChangedListener("attention_manager_service", ActivityThread.currentApplication().getMainExecutor(), new AttentionManagerService$$ExternalSyntheticLambda0(this));
        this.mIsProximityEnabled = this.mContext.getResources().getBoolean(R.bool.config_enableServerNotificationEffectsForAutomotive);
        Slog.i(LOG_TAG, "mIsProximityEnabled is: " + this.mIsProximityEnabled);
        return;
    }

    private /* synthetic */ void lambda$onBootPhase$0(DeviceConfig.Properties properties) {
        onDeviceConfigChange(properties.getKeyset());
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        AttentionManagerServiceIA r1 = null;
        publishBinderService("attention", new BinderService(this, r1));
        publishLocalService(AttentionManagerInternal.class, new LocalService(this, r1));
    }

    public static boolean isServiceConfigured(Context context) {
        return !TextUtils.isEmpty(getServiceConfigPackage(context));
    }

    protected boolean isServiceAvailable() {
        if (this.mComponentName != null) goto L6;
        this.mComponentName = resolveAttentionService(this.mContext);
    L6:
        if (this.mComponentName == null) goto L8;
        return true;
    L8:
        return false;
    }

    private boolean getIsServiceEnabled() {
        return DeviceConfig.getBoolean("attention_manager_service", KEY_SERVICE_ENABLED, true);
    }

    protected long getStaleAfterMillis() {
        long millis = DeviceConfig.getLong("attention_manager_service", KEY_STALE_AFTER_MILLIS, 1000);
        if (millis >= 0) goto L5;
    L8:
        Slog.w(LOG_TAG, "Bad flag value supplied for: stale_after_millis");
        return 1000;
    L5:
        if (millis > JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY) goto L8;
        return millis;
    }

    private void onDeviceConfigChange(Set<String> keys) {
        Iterator<String> r0 = keys.iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        String key = r0.next();
        switch(key.hashCode()) {
            case -337803025: goto L12;
            case 1914663863: goto L9;
            default: goto L14;
        };
    L14:
        byte r2 = -1;
    L15:
        switch(r2) {
            case 0: goto L17;
            case 1: goto L17;
            default: goto L16;
        };
    L16:
        Slog.i(LOG_TAG, "Ignoring change on " + key);
        goto L4
    L17:
        readValuesFromDeviceConfig();
        return;
    L9:
        if (key.equals(KEY_SERVICE_ENABLED) == false) goto L14;
        r2 = 0;
        goto L15
    L12:
        if (key.equals(KEY_STALE_AFTER_MILLIS) == false) goto L14;
        r2 = 1;
        goto L15
    }

    private void readValuesFromDeviceConfig() {
        this.mIsServiceEnabled = getIsServiceEnabled();
        this.mStaleAfterMillis = getStaleAfterMillis();
        Slog.i(LOG_TAG, "readValuesFromDeviceConfig():\nmIsServiceEnabled=" + this.mIsServiceEnabled + "\nmStaleAfterMillis=" + this.mStaleAfterMillis);
    }

    boolean checkAttention(long timeout, AttentionManagerInternal.AttentionCallbackInternal callbackInternal) {
        callbackInternal.getClass();
        if (this.mIsServiceEnabled == true) goto L7;
        Slog.w(LOG_TAG, "Trying to call checkAttention() on an unsupported device.");
        return false;
    L7:
        if (isServiceAvailable() == true) goto L11;
        Slog.w(LOG_TAG, "Service is not available at this moment.");
        return false;
    L11:
        if (this.mPrivacyManager.isSensorPrivacyEnabled(2) == false) goto L15;
        Slog.w(LOG_TAG, "Camera is locked by a toggle.");
        return false;
    L15:
        if (this.mPowerManager.isInteractive() == true) goto L17;
    L62:
        return false;
    L17:
        if (this.mPowerManager.isPowerSaveMode() == true) goto L62;
        Object r0 = this.mLock;
        monitor-enter(r0);
        freeIfInactiveLocked();     // Catch: Throwable -> L59
        bindLocked();     // Catch: Throwable -> L59
        monitor-exit(r0);     // Catch: Throwable -> L59
        long now = SystemClock.uptimeMillis();
        awaitServiceBinding(Math.min(1000, timeout));
        Object r4 = this.mLock;
        monitor-enter(r4);
    L36:
        th = move-exception;
        throw th;
    L26:
        if (this.mAttentionCheckCacheBuffer != null) goto L28;
        AttentionCheckCache cache = null;
    L30:
        if (cache == null) goto L39;
        if (now >= (AttentionCheckCache.m1913$$Nest$fgetmLastComputed(cache) + this.mStaleAfterMillis)) goto L39;
        callbackInternal.onSuccess(AttentionCheckCache.m1914$$Nest$fgetmResult(cache), AttentionCheckCache.m1915$$Nest$fgetmTimestamp(cache));     // Catch: Throwable -> L36
        monitor-exit(r4);     // Catch: Throwable -> L36
        return true;
    L39:
        if (this.mCurrentAttentionCheck != null) goto L41;
    L46:
        this.mCurrentAttentionCheck = new AttentionCheck(callbackInternal, this);     // Catch: Throwable -> L36
        if (this.mService != null) goto L64;
    L55:
        monitor-exit(r4);     // Catch: Throwable -> L36
        return true;
    L64:
        cancelAfterTimeoutLocked(BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS + timeout);     // Catch: Throwable -> L36 RemoteException -> L51
        this.mService.checkAttention(AttentionCheck.m1908$$Nest$fgetmIAttentionCallback(this.mCurrentAttentionCheck));     // Catch: Throwable -> L36 RemoteException -> L51
        AttentionCheck.m1911$$Nest$fputmIsDispatched(this.mCurrentAttentionCheck, true);     // Catch: Throwable -> L36 RemoteException -> L51
    L52:
        Slog.e(LOG_TAG, "Cannot call into the AttentionService");     // Catch: Throwable -> L36
        return false;
    L41:
        if (AttentionCheck.m1909$$Nest$fgetmIsDispatched(this.mCurrentAttentionCheck) == true) goto L43;
    L44:
        monitor-exit(r4);     // Catch: Throwable -> L36
        return false;
    L43:
        if (AttentionCheck.m1910$$Nest$fgetmIsFulfilled(this.mCurrentAttentionCheck) == true) goto L46;
    L28:
        cache = this.mAttentionCheckCacheBuffer.getLast();     // Catch: Throwable -> L36
    L59:
        th = move-exception;
        throw th;
    }

    void cancelAttentionCheck(AttentionManagerInternal.AttentionCallbackInternal callbackInternal) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (AttentionCheck.m1907$$Nest$fgetmCallbackInternal(this.mCurrentAttentionCheck).equals(callbackInternal) == true) goto L11;
        Slog.w(LOG_TAG, "Cannot cancel a non-current request");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        cancel();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    boolean onStartProximityUpdates(AttentionManagerInternal.ProximityUpdateCallbackInternal callbackInternal) {
        callbackInternal.getClass();
        if (this.mIsProximityEnabled == true) goto L7;
        Slog.w(LOG_TAG, "Trying to call onProximityUpdate() on an unsupported device.");
        return false;
    L7:
        if (isServiceAvailable() == true) goto L11;
        Slog.w(LOG_TAG, "Service is not available at this moment.");
        return false;
    L11:
        if (this.mPowerManager.isInteractive() == true) goto L14;
        Slog.w(LOG_TAG, "Proximity Service is unavailable during screen off at this moment.");
        return false;
    L14:
        Object r0 = this.mLock;
        monitor-enter(r0);
        freeIfInactiveLocked();     // Catch: Throwable -> L40
        bindLocked();     // Catch: Throwable -> L40
        monitor-exit(r0);     // Catch: Throwable -> L40
        awaitServiceBinding(1000);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L30:
        th = move-exception;
        throw th;
    L21:
        if (this.mCurrentProximityUpdate != null) goto L23;
    L35:
        this.mCurrentProximityUpdate = new ProximityUpdate(this, callbackInternal);     // Catch: Throwable -> L30
        boolean r1 = this.mCurrentProximityUpdate.startUpdates();     // Catch: Throwable -> L30
        monitor-exit(r2);     // Catch: Throwable -> L30
        return r1;
    L23:
        if (ProximityUpdate.m1919$$Nest$fgetmStartedUpdates(this.mCurrentProximityUpdate) == false) goto L35;
        if (ProximityUpdate.m1917$$Nest$fgetmCallbackInternal(this.mCurrentProximityUpdate) != callbackInternal) goto L32;
        Slog.w(LOG_TAG, "Provided callback is already registered. Skipping.");     // Catch: Throwable -> L30
        monitor-exit(r2);     // Catch: Throwable -> L30
        return true;
    L32:
        Slog.w(LOG_TAG, "New proximity update cannot be processed because there is already an ongoing update");     // Catch: Throwable -> L30
        monitor-exit(r2);     // Catch: Throwable -> L30
        return false;
    L40:
        th = move-exception;
        throw th;
    }

    void onStopProximityUpdates(AttentionManagerInternal.ProximityUpdateCallbackInternal callbackInternal) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentProximityUpdate != null) goto L7;
    L16:
        Slog.w(LOG_TAG, "Cannot stop a non-current callback");     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (ProximityUpdate.m1917$$Nest$fgetmCallbackInternal(this.mCurrentProximityUpdate).equals(callbackInternal) == false) goto L16;
        if (ProximityUpdate.m1919$$Nest$fgetmStartedUpdates(this.mCurrentProximityUpdate) == false) goto L16;
        this.mCurrentProximityUpdate.cancelUpdates();     // Catch: Throwable -> L14
        this.mCurrentProximityUpdate = null;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    protected void freeIfInactiveLocked() {
        this.mAttentionHandler.removeMessages(1);
        this.mAttentionHandler.sendEmptyMessageDelayed(1, 60000);
    }

    private void cancelAfterTimeoutLocked(long timeout) {
        this.mAttentionHandler.sendEmptyMessageDelayed(2, timeout);
    }

    private static String getServiceConfigPackage(Context context) {
        return context.getPackageManager().getAttentionServicePackageName();
    }

    private void awaitServiceBinding(long millis) {
        this.mServiceBindingLatch.await(millis, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(LOG_TAG, "Interrupted while waiting to bind Attention Service.", e);
    }

    private static ComponentName resolveAttentionService(Context context) {
        String serviceConfigPackage = getServiceConfigPackage(context);
        int flags = 1048576;
        if (TextUtils.isEmpty(sTestAttentionServicePackage) == true) goto L6;
        String resolvedPackage = sTestAttentionServicePackage;
        flags = 128;
    L8:
        Intent intent = new Intent("android.service.attention.AttentionService").setPackage(resolvedPackage);
        ResolveInfo resolveInfo = context.getPackageManager().resolveService(intent, flags);
        if (resolveInfo != null) goto L11;
    L19:
        Slog.wtf(LOG_TAG, String.format("Service %s not found in package %s", new Object[]{"android.service.attention.AttentionService", serviceConfigPackage}));
        return null;
    L11:
        if (resolveInfo.serviceInfo == null) goto L19;
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        String permission = serviceInfo.permission;
        if ("android.permission.BIND_ATTENTION_SERVICE".equals(permission) == true) goto L16;
        Slog.e(LOG_TAG, String.format("Service %s should require %s permission. Found %s permission", new Object[]{serviceInfo.getComponentName(), "android.permission.BIND_ATTENTION_SERVICE", serviceInfo.permission}));
        return null;
    L16:
        return serviceInfo.getComponentName();
    L6:
        if (TextUtils.isEmpty(serviceConfigPackage) == true) goto L21;
        resolvedPackage = serviceConfigPackage;
        goto L8
    L21:
        return null;
    }

    private void dumpInternal(IndentingPrintWriter ipw) {
        ipw.println("Attention Manager Service (dumpsys attention) state:\n");
        ipw.println("isServiceEnabled=" + this.mIsServiceEnabled);
        ipw.println("mIsProximityEnabled=" + this.mIsProximityEnabled);
        ipw.println("mStaleAfterMillis=" + this.mStaleAfterMillis);
        ipw.println("AttentionServicePackageName=" + getServiceConfigPackage(this.mContext));
        ipw.println("Resolved component:");
        if (this.mComponentName == null) goto L5;
        ipw.increaseIndent();
        ipw.println("Component=" + this.mComponentName.getPackageName());
        ipw.println("Class=" + this.mComponentName.getClassName());
        ipw.decreaseIndent();
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        ipw.println("binding=" + this.mBinding);     // Catch: Throwable -> L10
        ipw.println("current attention check:");     // Catch: Throwable -> L10
        if (this.mCurrentAttentionCheck == null) goto L13;
        this.mCurrentAttentionCheck.dump(ipw);     // Catch: Throwable -> L10
    L13:
        if (this.mAttentionCheckCacheBuffer == null) goto L16;
        AttentionCheckCacheBuffer.m1916$$Nest$mdump(this.mAttentionCheckCacheBuffer, ipw);     // Catch: Throwable -> L10
    L16:
        if (this.mCurrentProximityUpdate == null) goto L18;
        this.mCurrentProximityUpdate.dump(ipw);     // Catch: Throwable -> L10
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void appendResultToAttentionCacheBuffer(AttentionCheckCache cache) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAttentionCheckCacheBuffer != null) goto L9;
        this.mAttentionCheckCacheBuffer = new AttentionCheckCacheBuffer();     // Catch: Throwable -> L7
    L9:
        this.mAttentionCheckCacheBuffer.add(cache);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void handlePendingCallbackLocked() {
        if (this.mCurrentAttentionCheck == null) goto L14;
        if (AttentionCheck.m1909$$Nest$fgetmIsDispatched(this.mCurrentAttentionCheck) == true) goto L14;
        if (this.mService != null) goto L27;
        AttentionCheck.m1907$$Nest$fgetmCallbackInternal(this.mCurrentAttentionCheck).onFailure(2);
        goto L14
    L27:
        this.mService.checkAttention(AttentionCheck.m1908$$Nest$fgetmIAttentionCallback(this.mCurrentAttentionCheck));     // Catch: RemoteException -> L10
        AttentionCheck.m1911$$Nest$fputmIsDispatched(this.mCurrentAttentionCheck, true);     // Catch: RemoteException -> L10
    L11:
        Slog.e(LOG_TAG, "Cannot call into the AttentionService");
    L14:
        if (this.mCurrentProximityUpdate != null) goto L16;
        return;
    L16:
        if (ProximityUpdate.m1919$$Nest$fgetmStartedUpdates(this.mCurrentProximityUpdate) == true) goto L18;
        return;
    L18:
        if (this.mService != null) goto L25;
        this.mCurrentProximityUpdate.cancelUpdates();
        this.mCurrentProximityUpdate = null;
        return;
    L25:
        this.mService.onStartProximityUpdates(ProximityUpdate.m1918$$Nest$fgetmIProximityUpdateCallback(this.mCurrentProximityUpdate));     // Catch: RemoteException -> L21
        return;
    L21:
        e = move-exception;
        Slog.e(LOG_TAG, "Cannot call into the AttentionService", e);
    }

    void cancel() {
        if (AttentionCheck.m1910$$Nest$fgetmIsFulfilled(this.mCurrentAttentionCheck) == false) goto L6;
        return;
    L6:
        if (this.mService != null) goto L14;
        this.mCurrentAttentionCheck.cancelInternal();
        return;
    L14:
        this.mService.cancelAttentionCheck(AttentionCheck.m1908$$Nest$fgetmIAttentionCallback(this.mCurrentAttentionCheck));     // Catch: RemoteException -> L11
        return;
    L12:
        Slog.e(LOG_TAG, "Unable to cancel attention check");
        this.mCurrentAttentionCheck.cancelInternal();
    }

    private void cancelAndUnbindLocked() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentAttentionCheck == null) goto L10;
        cancel();     // Catch: Throwable -> L7
    L10:
        if (this.mCurrentProximityUpdate == null) goto L13;
        this.mCurrentProximityUpdate.cancelUpdates();     // Catch: Throwable -> L7
    L13:
        if (this.mService != null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L16:
        this.mAttentionHandler.post(new AttentionManagerService$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L7
        this.mConnection.cleanupService();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private /* synthetic */ void lambda$cancelAndUnbindLocked$1() {
        this.mContext.unbindService(this.mConnection);
    }

    private void bindLocked() {
        if (this.mBinding == false) goto L5;
        return;
    L5:
        if (this.mService != null) goto L10;
        this.mBinding = true;
        this.mAttentionHandler.post(new AttentionManagerService$$ExternalSyntheticLambda1(this));
        return;
    }

    private /* synthetic */ void lambda$bindLocked$2() {
        Intent serviceIntent = new Intent("android.service.attention.AttentionService").setComponent(this.mComponentName);
        this.mContext.bindServiceAsUser(serviceIntent, this.mConnection, 67112961, UserHandle.CURRENT);
    }
}
