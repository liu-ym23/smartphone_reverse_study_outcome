package com.android.server.utils;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Slog;
import com.android.server.input.KeyboardMetricsCollector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ManagedApplicationService {
    private static final int MAX_RETRY_COUNT = 4;
    private static final long MAX_RETRY_DURATION_MS = 16000;
    private static final long MIN_RETRY_DURATION_MS = 2000;
    public static final int RETRY_BEST_EFFORT = 3;
    public static final int RETRY_FOREVER = 1;
    public static final int RETRY_NEVER = 2;
    private static final long RETRY_RESET_TIME_MS = 64000;
    private final String TAG;
    private IInterface mBoundInterface;
    private final BinderChecker mChecker;
    private final int mClientLabel;
    private final ComponentName mComponent;
    private ServiceConnection mConnection;
    private final Context mContext;
    private final EventCallback mEventCb;
    private final Handler mHandler;
    private final boolean mIsImportant;
    private long mLastRetryTimeMs;
    private final Object mLock;
    private long mNextRetryDurationMs;
    private PendingEvent mPendingEvent;
    private int mRetryCount;
    private final Runnable mRetryRunnable;
    private final int mRetryType;
    private boolean mRetrying;
    private final String mSettingsAction;
    private final int mUserId;

    /* JADX INFO: renamed from: com.android.server.utils.ManagedApplicationService$1, reason: invalid class name */
    class AnonymousClass1 implements ServiceConnection {
        final /* synthetic */ ManagedApplicationService this$0;

        public static /* synthetic */ void $r8$lambda$7MELvM0vq4LGKRe09YLQWWpeVvo(AnonymousClass1 r0, long r1) {
            r0.lambda$onBindingDied$0(r1);
        }

        public static /* synthetic */ void $r8$lambda$NjxY_yaPjB2SqaS8Lf0D3g9qkws(AnonymousClass1 r0, long r1) {
            r0.lambda$onServiceConnected$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$kZsdL6_A5MAyFTNpxnceGbwfUQY(AnonymousClass1 r0, long r1) {
            r0.lambda$onServiceDisconnected$2(r1);
        }

        AnonymousClass1(ManagedApplicationService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            final long timestamp = System.currentTimeMillis();
            Slog.w(ManagedApplicationService.m9256$$Nest$fgetTAG(this.this$0), "Service binding died: " + componentName);
            Object r2 = ManagedApplicationService.m9263$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (ManagedApplicationService.m9260$$Nest$fgetmConnection(this.this$0) == this) goto L10;
            monitor-exit(r2);     // Catch: Throwable -> L8
            return;
        L10:
            ManagedApplicationService.m9262$$Nest$fgetmHandler(this.this$0).post(new ManagedApplicationService$1$$ExternalSyntheticLambda2(this, timestamp));     // Catch: Throwable -> L8
            ManagedApplicationService.m9265$$Nest$fputmBoundInterface(this.this$0, null);     // Catch: Throwable -> L8
            ManagedApplicationService.m9267$$Nest$mstartRetriesLocked(this.this$0);     // Catch: Throwable -> L8
            monitor-exit(r2);     // Catch: Throwable -> L8
        }

        private /* synthetic */ void lambda$onBindingDied$0(long timestamp) {
            ManagedApplicationService.m9261$$Nest$fgetmEventCb(this.this$0).onServiceEvent(new LogEvent(timestamp, ManagedApplicationService.m9259$$Nest$fgetmComponent(this.this$0), 3));
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            final long timestamp = System.currentTimeMillis();
            Slog.i(ManagedApplicationService.m9256$$Nest$fgetTAG(this.this$0), "Service connected: " + componentName);
            IInterface iface = null;
            PendingEvent pendingEvent = null;
            Object r4 = ManagedApplicationService.m9263$$Nest$fgetmLock(this.this$0);
            monitor-enter(r4);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (ManagedApplicationService.m9260$$Nest$fgetmConnection(this.this$0) == this) goto L10;
            monitor-exit(r4);     // Catch: Throwable -> L8
            return;
        L10:
            ManagedApplicationService.m9262$$Nest$fgetmHandler(this.this$0).post(new ManagedApplicationService$1$$ExternalSyntheticLambda0(this, timestamp));     // Catch: Throwable -> L8
            ManagedApplicationService.m9268$$Nest$mstopRetriesLocked(this.this$0);     // Catch: Throwable -> L8
            ManagedApplicationService.m9265$$Nest$fputmBoundInterface(this.this$0, null);     // Catch: Throwable -> L8
            if (ManagedApplicationService.m9258$$Nest$fgetmChecker(this.this$0) == null) goto L18;
            ManagedApplicationService.m9265$$Nest$fputmBoundInterface(this.this$0, ManagedApplicationService.m9258$$Nest$fgetmChecker(this.this$0).asInterface(iBinder));     // Catch: Throwable -> L8
            if (ManagedApplicationService.m9258$$Nest$fgetmChecker(this.this$0).checkType(ManagedApplicationService.m9257$$Nest$fgetmBoundInterface(this.this$0)) == true) goto L17;
            ManagedApplicationService.m9265$$Nest$fputmBoundInterface(this.this$0, null);     // Catch: Throwable -> L8
            Slog.w(ManagedApplicationService.m9256$$Nest$fgetTAG(this.this$0), "Invalid binder from " + componentName);     // Catch: Throwable -> L8
            ManagedApplicationService.m9267$$Nest$mstartRetriesLocked(this.this$0);     // Catch: Throwable -> L8
            monitor-exit(r4);     // Catch: Throwable -> L8
            return;
        L17:
            iface = ManagedApplicationService.m9257$$Nest$fgetmBoundInterface(this.this$0);     // Catch: Throwable -> L8
            pendingEvent = ManagedApplicationService.m9264$$Nest$fgetmPendingEvent(this.this$0);     // Catch: Throwable -> L8
            ManagedApplicationService.m9266$$Nest$fputmPendingEvent(this.this$0, null);     // Catch: Throwable -> L8
        L18:
            monitor-exit(r4);     // Catch: Throwable -> L8
            if (iface == null) goto L31;
            if (pendingEvent == null) goto L32;
            pendingEvent.runEvent(iface);     // Catch: Throwable -> L23
            return;
        L23:
            ex = move-exception;
            Slog.e(ManagedApplicationService.m9256$$Nest$fgetTAG(this.this$0), "Received exception from user service: ", ex);
            ManagedApplicationService.m9267$$Nest$mstartRetriesLocked(this.this$0);
            return;
        L32:
            return;
        }

        private /* synthetic */ void lambda$onServiceConnected$1(long timestamp) {
            ManagedApplicationService.m9261$$Nest$fgetmEventCb(this.this$0).onServiceEvent(new LogEvent(timestamp, ManagedApplicationService.m9259$$Nest$fgetmComponent(this.this$0), 1));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            final long timestamp = System.currentTimeMillis();
            Slog.w(ManagedApplicationService.m9256$$Nest$fgetTAG(this.this$0), "Service disconnected: " + componentName);
            Object r2 = ManagedApplicationService.m9263$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (ManagedApplicationService.m9260$$Nest$fgetmConnection(this.this$0) == this) goto L10;
            monitor-exit(r2);     // Catch: Throwable -> L8
            return;
        L10:
            ManagedApplicationService.m9262$$Nest$fgetmHandler(this.this$0).post(new ManagedApplicationService$1$$ExternalSyntheticLambda1(this, timestamp));     // Catch: Throwable -> L8
            ManagedApplicationService.m9265$$Nest$fputmBoundInterface(this.this$0, null);     // Catch: Throwable -> L8
            ManagedApplicationService.m9267$$Nest$mstartRetriesLocked(this.this$0);     // Catch: Throwable -> L8
            monitor-exit(r2);     // Catch: Throwable -> L8
        }

        private /* synthetic */ void lambda$onServiceDisconnected$2(long timestamp) {
            ManagedApplicationService.m9261$$Nest$fgetmEventCb(this.this$0).onServiceEvent(new LogEvent(timestamp, ManagedApplicationService.m9259$$Nest$fgetmComponent(this.this$0), 2));
        }
    }

    public interface BinderChecker {
        IInterface asInterface(IBinder r1);

        boolean checkType(IInterface r1);
    }

    public interface EventCallback {
        void onServiceEvent(LogEvent r1);
    }

    public static class LogEvent implements LogFormattable {
        public static final int EVENT_BINDING_DIED = 3;
        public static final int EVENT_CONNECTED = 1;
        public static final int EVENT_DISCONNECTED = 2;
        public static final int EVENT_STOPPED_PERMANENTLY = 4;
        public final ComponentName component;
        public final int event;
        public final long timestamp;

        public LogEvent(long timestamp, ComponentName component, int event) {
            this.timestamp = timestamp;
            this.component = component;
            this.event = event;
        }

        @Override // com.android.server.utils.ManagedApplicationService.LogFormattable
        public String toLogString(SimpleDateFormat dateFormat) {
            StringBuilder r0 = new StringBuilder();
            r0.append(dateFormat.format(new Date(this.timestamp)));
            r0.append("   ");
            r0.append(eventToString(this.event));
            r0.append(" Managed Service: ");
            if (this.component != null) goto L5;
            String r1 = KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG;
        L6:
            r0.append(r1);
            return r0.toString();
        L5:
            r1 = this.component.flattenToString();
            goto L6
        }

        public static String eventToString(int event) {
            switch(event) {
                case 1: goto L11;
                case 2: goto L9;
                case 3: goto L7;
                case 4: goto L5;
                default: goto L3;
            };
        L3:
            return "Unknown Event Occurred";
        L5:
            return "Permanently Stopped";
        L7:
            return "Binding Died For";
        L9:
            return "Disconnected";
        L11:
            return "Connected";
        }
    }

    public interface LogFormattable {
        String toLogString(SimpleDateFormat r1);
    }

    public interface PendingEvent {
        void runEvent(IInterface r1) throws RemoteException;
    }

    /* JADX INFO: renamed from: $r8$lambda$QhsE-AD_A0tDzWuqt_zOz38LVSU, reason: not valid java name */
    public static /* synthetic */ void m9255$r8$lambda$QhsEAD_A0tDzWuqt_zOz38LVSU(ManagedApplicationService r0) {
        r0.doRetry();
    }

    public static /* synthetic */ void $r8$lambda$gU1eWn1rWxSyCvKsTTzfraHkL0Y(ManagedApplicationService r0, long r1) {
        r0.lambda$checkAndDeliverServiceDiedCbLocked$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9256$$Nest$fgetTAG(ManagedApplicationService r0) {
        return r0.TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBoundInterface, reason: not valid java name */
    static /* bridge */ /* synthetic */ IInterface m9257$$Nest$fgetmBoundInterface(ManagedApplicationService r0) {
        return r0.mBoundInterface;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmChecker, reason: not valid java name */
    static /* bridge */ /* synthetic */ BinderChecker m9258$$Nest$fgetmChecker(ManagedApplicationService r0) {
        return r0.mChecker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmComponent, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m9259$$Nest$fgetmComponent(ManagedApplicationService r0) {
        return r0.mComponent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ ServiceConnection m9260$$Nest$fgetmConnection(ManagedApplicationService r0) {
        return r0.mConnection;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEventCb, reason: not valid java name */
    static /* bridge */ /* synthetic */ EventCallback m9261$$Nest$fgetmEventCb(ManagedApplicationService r0) {
        return r0.mEventCb;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m9262$$Nest$fgetmHandler(ManagedApplicationService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9263$$Nest$fgetmLock(ManagedApplicationService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ PendingEvent m9264$$Nest$fgetmPendingEvent(ManagedApplicationService r0) {
        return r0.mPendingEvent;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBoundInterface, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9265$$Nest$fputmBoundInterface(ManagedApplicationService r0, IInterface r1) {
        r0.mBoundInterface = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPendingEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9266$$Nest$fputmPendingEvent(ManagedApplicationService r0, PendingEvent r1) {
        r0.mPendingEvent = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mstartRetriesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9267$$Nest$mstartRetriesLocked(ManagedApplicationService r0) {
        r0.startRetriesLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopRetriesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9268$$Nest$mstopRetriesLocked(ManagedApplicationService r0) {
        r0.stopRetriesLocked();
    }

    private ManagedApplicationService(Context context, ComponentName component, int userId, int clientLabel, String settingsAction, BinderChecker binderChecker, boolean isImportant, int retryType, Handler handler, EventCallback eventCallback) {
        this.TAG = getClass().getSimpleName();
        this.mRetryRunnable = new ManagedApplicationService$$ExternalSyntheticLambda0(this);
        this.mLock = new Object();
        this.mNextRetryDurationMs = 2000;
        this.mContext = context;
        this.mComponent = component;
        this.mUserId = userId;
        this.mClientLabel = clientLabel;
        this.mSettingsAction = settingsAction;
        this.mChecker = binderChecker;
        this.mIsImportant = isImportant;
        this.mRetryType = retryType;
        this.mHandler = handler;
        this.mEventCb = eventCallback;
    }

    public static ManagedApplicationService build(Context context, ComponentName component, int userId, int clientLabel, String settingsAction, BinderChecker binderChecker, boolean isImportant, int retryType, Handler handler, EventCallback eventCallback) {
        return new ManagedApplicationService(context, component, userId, clientLabel, settingsAction, binderChecker, isImportant, retryType, handler, eventCallback);
    }

    public int getUserId() {
        return this.mUserId;
    }

    public ComponentName getComponent() {
        return this.mComponent;
    }

    public boolean disconnectIfNotMatching(ComponentName componentName, int userId) {
        if (matches(componentName, userId) == false) goto L6;
        return false;
    L6:
        disconnect();
        return true;
    }

    public void sendEvent(PendingEvent event) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IInterface iface = this.mBoundInterface;     // Catch: Throwable -> L7
        if (iface != null) goto L9;
        this.mPendingEvent = event;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        if (iface == null) goto L22;
        event.runEvent(iface);     // Catch: Throwable -> L13
        return;
    L13:
        ex = move-exception;
        Slog.e(this.TAG, "Received exception from user service: ", ex);
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void disconnect() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnection != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L8
        this.mConnection = null;     // Catch: Throwable -> L8
        this.mBoundInterface = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void connect() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            android.content.ServiceConnection r1 = r7.mConnection     // Catch: java.lang.Throwable -> L9
            if (r1 == 0) goto Lc
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
            return
        L9:
            r1 = move-exception
            goto L95
        Lc:
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Throwable -> L9
            r1.<init>()     // Catch: java.lang.Throwable -> L9
            android.content.ComponentName r2 = r7.mComponent     // Catch: java.lang.Throwable -> L9
            android.content.Intent r1 = r1.setComponent(r2)     // Catch: java.lang.Throwable -> L9
            int r2 = r7.mClientLabel     // Catch: java.lang.Throwable -> L9
            if (r2 == 0) goto L22
            java.lang.String r2 = "android.intent.extra.client_label"
            int r3 = r7.mClientLabel     // Catch: java.lang.Throwable -> L9
            r1.putExtra(r2, r3)     // Catch: java.lang.Throwable -> L9
        L22:
            java.lang.String r2 = r7.mSettingsAction     // Catch: java.lang.Throwable -> L9
            if (r2 == 0) goto L3b
            java.lang.String r2 = "android.intent.extra.client_intent"
            android.content.Context r3 = r7.mContext     // Catch: java.lang.Throwable -> L9
            android.content.Intent r4 = new android.content.Intent     // Catch: java.lang.Throwable -> L9
            java.lang.String r5 = r7.mSettingsAction     // Catch: java.lang.Throwable -> L9
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L9
            r5 = 0
            r6 = 67108864(0x4000000, float:1.5046328E-36)
            android.app.PendingIntent r3 = android.app.PendingIntent.getActivity(r3, r5, r4, r6)     // Catch: java.lang.Throwable -> L9
            r1.putExtra(r2, r3)     // Catch: java.lang.Throwable -> L9
        L3b:
            com.android.server.utils.ManagedApplicationService$1 r2 = new com.android.server.utils.ManagedApplicationService$1     // Catch: java.lang.Throwable -> L9
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L9
            r7.mConnection = r2     // Catch: java.lang.Throwable -> L9
            r2 = 67108865(0x4000001, float:1.504633E-36)
            boolean r3 = r7.mIsImportant     // Catch: java.lang.Throwable -> L9
            if (r3 == 0) goto L4b
            r2 = r2 | 64
        L4b:
            android.content.Context r3 = r7.mContext     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            android.content.ServiceConnection r4 = r7.mConnection     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            android.os.UserHandle r5 = new android.os.UserHandle     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            int r6 = r7.mUserId     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            boolean r3 = r3.bindServiceAsUser(r1, r4, r2, r5)     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            if (r3 != 0) goto L78
            java.lang.String r3 = r7.TAG     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            r4.<init>()     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            java.lang.String r5 = "Unable to bind service: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            r4.append(r1)     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            android.util.Slog.w(r3, r4)     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            r7.startRetriesLocked()     // Catch: java.lang.Throwable -> L9 java.lang.SecurityException -> L76
            goto L78
        L76:
            r3 = move-exception
            goto L79
        L78:
            goto L93
        L79:
            java.lang.String r4 = r7.TAG     // Catch: java.lang.Throwable -> L9
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9
            r5.<init>()     // Catch: java.lang.Throwable -> L9
            java.lang.String r6 = "Unable to bind service: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L9
            r5.append(r1)     // Catch: java.lang.Throwable -> L9
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L9
            android.util.Slog.w(r4, r5, r3)     // Catch: java.lang.Throwable -> L9
            r7.startRetriesLocked()     // Catch: java.lang.Throwable -> L9
        L93:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
            return
        L95:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.utils.ManagedApplicationService.connect():void");
    }

    private boolean matches(ComponentName component, int userId) {
        if (Objects.equals(this.mComponent, component) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mUserId != userId) goto L7;
        return true;
    }

    private void startRetriesLocked() {
        if (checkAndDeliverServiceDiedCbLocked() == false) goto L7;
        disconnect();
        return;
    L7:
        if (this.mRetrying == false) goto L9;
        return;
    L9:
        this.mRetrying = true;
        queueRetryLocked();
    }

    private void stopRetriesLocked() {
        this.mRetrying = false;
        this.mHandler.removeCallbacks(this.mRetryRunnable);
    }

    private void queueRetryLocked() {
        long now = SystemClock.uptimeMillis();
        if ((now - this.mLastRetryTimeMs) <= RETRY_RESET_TIME_MS) goto L5;
        this.mNextRetryDurationMs = 2000;
        this.mRetryCount = 0;
    L5:
        this.mLastRetryTimeMs = now;
        this.mHandler.postDelayed(this.mRetryRunnable, this.mNextRetryDurationMs);
        this.mNextRetryDurationMs = Math.min(this.mNextRetryDurationMs * 2, MAX_RETRY_DURATION_MS);
        this.mRetryCount++;
    }

    private boolean checkAndDeliverServiceDiedCbLocked() {
        if (this.mRetryType != 2) goto L5;
    L11:
        Slog.e(this.TAG, "Service " + this.mComponent + " has died too much, not retrying.");
        if (this.mEventCb == null) goto L17;
        final long timestamp = System.currentTimeMillis();
        this.mHandler.post(new ManagedApplicationService$$ExternalSyntheticLambda1(this, timestamp));
        return true;
    L17:
        return true;
    L5:
        if (this.mRetryType == 3) goto L7;
        return false;
    L7:
        if (this.mRetryCount >= 4) goto L11;
        return false;
    }

    private /* synthetic */ void lambda$checkAndDeliverServiceDiedCbLocked$0(long timestamp) {
        this.mEventCb.onServiceEvent(new LogEvent(timestamp, this.mComponent, 4));
    }

    private void doRetry() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnection != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mRetrying == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        Slog.i(this.TAG, "Attempting to reconnect " + this.mComponent + "...");     // Catch: Throwable -> L8
        disconnect();     // Catch: Throwable -> L8
        if (checkAndDeliverServiceDiedCbLocked() == false) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L18:
        queueRetryLocked();     // Catch: Throwable -> L8
        connect();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }
}
