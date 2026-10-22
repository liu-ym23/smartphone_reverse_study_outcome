package com.android.server.logcat;

import android.app.ActivityManagerInternal;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.ILogd;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.logcat.ILogcatManagerService;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.app.ILogAccessDialogCallback;
import com.android.internal.util.ArrayUtils;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.policy.EventLogTags;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public final class LogcatManagerService extends SystemService {
    private static final boolean DEBUG = false;
    public static final String EXTRA_CALLBACK = "EXTRA_CALLBACK";
    private static final int MSG_APPROVE_LOG_ACCESS = 1;
    private static final int MSG_DECLINE_LOG_ACCESS = 2;
    private static final int MSG_LOG_ACCESS_FINISHED = 3;
    private static final int MSG_LOG_ACCESS_REQUESTED = 0;
    private static final int MSG_LOG_ACCESS_STATUS_EXPIRED = 5;
    private static final int MSG_PENDING_TIMEOUT = 4;
    static final int PENDING_CONFIRMATION_TIMEOUT_MILLIS = 0;
    private static final int STATUS_APPROVED = 2;
    private static final int STATUS_DECLINED = 3;
    static final int STATUS_EXPIRATION_TIMEOUT_MILLIS = 60000;
    private static final int STATUS_NEW_REQUEST = 0;
    private static final int STATUS_PENDING = 1;
    private static final String TAG = "LogcatManagerService";
    private static final String TARGET_ACTIVITY_NAME = "com.android.systemui.logcat.LogAccessDialogActivity";
    private static final String TARGET_PACKAGE_NAME = "com.android.systemui";
    private final Map<LogAccessClient, Integer> mActiveLogAccessCount;
    private ActivityManagerInternal mActivityManagerInternal;
    private final BinderService mBinderService;
    private final Supplier<Long> mClock;
    private final Context mContext;
    private final LogAccessDialogCallback mDialogCallback;
    private final Handler mHandler;
    private final Injector mInjector;
    private final Map<LogAccessClient, LogAccessStatus> mLogAccessStatus;
    private ILogd mLogdService;

    private final class BinderService extends ILogcatManagerService.Stub {
        final /* synthetic */ LogcatManagerService this$0;

        /* synthetic */ BinderService(LogcatManagerService r1, LogcatManagerServiceIA r2) {
            this(r1);
        }

        private BinderService(LogcatManagerService r1) {
            this.this$0 = r1;
        }

        public void startThread(int uid, int gid, int pid, int fd) {
            LogAccessRequest logAccessRequest = new LogAccessRequest(uid, gid, pid, fd, null);
            Message msg = LogcatManagerService.m5495$$Nest$fgetmHandler(this.this$0).obtainMessage(0, logAccessRequest);
            LogcatManagerService.m5495$$Nest$fgetmHandler(this.this$0).sendMessageAtTime(msg, ((Long) LogcatManagerService.m5494$$Nest$fgetmClock(this.this$0).get()).longValue());
        }

        public void finishThread(int uid, int gid, int pid, int fd) {
            LogAccessRequest logAccessRequest = new LogAccessRequest(uid, gid, pid, fd, null);
            Message msg = LogcatManagerService.m5495$$Nest$fgetmHandler(this.this$0).obtainMessage(3, logAccessRequest);
            LogcatManagerService.m5495$$Nest$fgetmHandler(this.this$0).sendMessageAtTime(msg, ((Long) LogcatManagerService.m5494$$Nest$fgetmClock(this.this$0).get()).longValue());
        }
    }

    static class Injector {
        Injector() {
        }

        protected Supplier<Long> createClock() {
            return new LogcatManagerService$Injector$$ExternalSyntheticLambda0();
        }

        protected Looper getLooper() {
            return Looper.getMainLooper();
        }

        protected ILogd getLogdService() {
            return ILogd.Stub.asInterface(ServiceManager.getService("logd"));
        }
    }

    private static final class LogAccessClient {
        final String mPackageName;
        final int mUid;

        LogAccessClient(int uid, String packageName) {
            this.mUid = uid;
            this.mPackageName = packageName;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof LogAccessClient) == true) goto L8;
            return false;
        L8:
            LogAccessClient that = (LogAccessClient) o;
            if (this.mUid != that.mUid) goto L14;
            if (Objects.equals(this.mPackageName, that.mPackageName) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mUid), this.mPackageName});
        }

        public String toString() {
            return "LogAccessClient{mUid=" + this.mUid + ", mPackageName=" + this.mPackageName + '}';
        }
    }

    final class LogAccessDialogCallback extends ILogAccessDialogCallback.Stub {
        final /* synthetic */ LogcatManagerService this$0;

        LogAccessDialogCallback(LogcatManagerService this$0) {
            this.this$0 = this$0;
        }

        public void approveAccessForClient(int uid, String packageName) {
            LogAccessClient client = new LogAccessClient(uid, packageName);
            Message msg = LogcatManagerService.m5495$$Nest$fgetmHandler(this.this$0).obtainMessage(1, client);
            LogcatManagerService.m5495$$Nest$fgetmHandler(this.this$0).sendMessageAtTime(msg, ((Long) LogcatManagerService.m5494$$Nest$fgetmClock(this.this$0).get()).longValue());
        }

        public void declineAccessForClient(int uid, String packageName) {
            LogAccessClient client = new LogAccessClient(uid, packageName);
            Message msg = LogcatManagerService.m5495$$Nest$fgetmHandler(this.this$0).obtainMessage(2, client);
            LogcatManagerService.m5495$$Nest$fgetmHandler(this.this$0).sendMessageAtTime(msg, ((Long) LogcatManagerService.m5494$$Nest$fgetmClock(this.this$0).get()).longValue());
        }
    }

    private static final class LogAccessRequest {
        final int mFd;
        final int mGid;
        final int mPid;
        final int mUid;

        /* synthetic */ LogAccessRequest(int r1, int r2, int r3, int r4, LogcatManagerServiceIA r5) {
            this(r1, r2, r3, r4);
        }

        private LogAccessRequest(int uid, int gid, int pid, int fd) {
            this.mUid = uid;
            this.mGid = gid;
            this.mPid = pid;
            this.mFd = fd;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof LogAccessRequest) == true) goto L8;
            return false;
        L8:
            LogAccessRequest that = (LogAccessRequest) o;
            if (this.mUid != that.mUid) goto L18;
            if (this.mGid != that.mGid) goto L18;
            if (this.mPid != that.mPid) goto L18;
            if (this.mFd != that.mFd) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mUid), Integer.valueOf(this.mGid), Integer.valueOf(this.mPid), Integer.valueOf(this.mFd)});
        }

        public String toString() {
            return "LogAccessRequest{mUid=" + this.mUid + ", mGid=" + this.mGid + ", mPid=" + this.mPid + ", mFd=" + this.mFd + '}';
        }
    }

    private static class LogAccessRequestHandler extends Handler {
        private final LogcatManagerService mService;

        LogAccessRequestHandler(Looper looper, LogcatManagerService service) {
            super(looper);
            this.mService = service;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L10;
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L7;
                case 4: goto L6;
                case 5: goto L5;
                default: goto L17;
            };
        L5:
            LogAccessClient client = (LogAccessClient) msg.obj;
            this.mService.onAccessStatusExpired(client);
            return;
        L6:
            LogAccessClient client2 = (LogAccessClient) msg.obj;
            this.mService.onPendingTimeoutExpired(client2);
            return;
        L7:
            LogAccessRequest request = (LogAccessRequest) msg.obj;
            this.mService.onLogAccessFinished(request);
            return;
        L8:
            LogAccessClient client3 = (LogAccessClient) msg.obj;
            this.mService.onAccessDeclinedForClient(client3);
            return;
        L9:
            LogAccessClient client4 = (LogAccessClient) msg.obj;
            this.mService.onAccessApprovedForClient(client4);
            return;
        L10:
            LogAccessRequest request2 = (LogAccessRequest) msg.obj;
            this.mService.onLogAccessRequested(request2);
            return;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogAccessRequestStatus {
    }

    private static final class LogAccessStatus {
        final List<LogAccessRequest> mPendingRequests;
        int mStatus;

        /* synthetic */ LogAccessStatus(LogcatManagerServiceIA r1) {
            this();
        }

        private LogAccessStatus() {
            this.mStatus = 0;
            this.mPendingRequests = new ArrayList();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m5494$$Nest$fgetmClock(LogcatManagerService r0) {
        return r0.mClock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m5495$$Nest$fgetmHandler(LogcatManagerService r0) {
        return r0.mHandler;
    }

    static {
        if (Build.IS_DEBUGGABLE == false) goto L5;
        int r0 = EventLogTags.SCREEN_TOGGLED;
    L6:
        PENDING_CONFIRMATION_TIMEOUT_MILLIS = r0;
        return;
    L5:
        r0 = 400000;
        goto L6
    }

    private ILogd getLogdService() {
        if (this.mLogdService != null) goto L6;
        this.mLogdService = this.mInjector.getLogdService();
    L6:
        return this.mLogdService;
    }

    public LogcatManagerService(Context context) {
        this(context, new Injector());
    }

    public LogcatManagerService(Context context, Injector injector) {
        super(context);
        this.mLogAccessStatus = new ArrayMap();
        this.mActiveLogAccessCount = new ArrayMap();
        this.mContext = context;
        this.mInjector = injector;
        this.mClock = injector.createClock();
        this.mBinderService = new BinderService(this, null);
        this.mDialogCallback = new LogAccessDialogCallback(this);
        this.mHandler = new LogAccessRequestHandler(injector.getLooper(), this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);     // Catch: Throwable -> L4
        publishBinderService("logcat", this.mBinderService);     // Catch: Throwable -> L4
        return;
    L4:
        t = move-exception;
        Slog.e(TAG, "Could not start the LogcatManagerService.", t);
    }

    LogAccessDialogCallback getDialogCallback() {
        return this.mDialogCallback;
    }

    ILogcatManagerService getBinderService() {
        return this.mBinderService;
    }

    private LogAccessClient getClientForRequest(LogAccessRequest request) {
        String packageName = getPackageName(request);
        if (packageName != null) goto L7;
        return null;
    L7:
        return new LogAccessClient(request.mUid, packageName);
    }

    private String getPackageName(LogAccessRequest request) {
        PackageManager pm = this.mContext.getPackageManager();
        if (pm != null) goto L6;
        Slog.e(TAG, "PackageManager is null, declining the logd access");
        return null;
    L6:
        String[] packageNames = pm.getPackagesForUid(request.mUid);
        if (ArrayUtils.isEmpty(packageNames) == false) goto L11;
        Slog.e(TAG, "Unknown calling package name, declining the logd access");
        return null;
    L11:
        if (this.mActivityManagerInternal == null) goto L23;
        int pid = request.mPid;
        String packageName = this.mActivityManagerInternal.getPackageNameByPid(pid);
    L13:
        if (packageName == null) goto L17;
        if (ArrayUtils.contains(packageNames, packageName) == false) goto L17;
    L19:
        if (packageName == null) goto L23;
        if (ArrayUtils.contains(packageNames, packageName) == false) goto L23;
        return packageName;
    L17:
        if (pid == (-1)) goto L19;
        pid = Process.getParentPid(pid);
        packageName = this.mActivityManagerInternal.getPackageNameByPid(pid);
    L23:
        Arrays.sort(packageNames);
        String firstPackageName = packageNames[0];
        if (firstPackageName != null) goto L26;
    L29:
        Slog.e(TAG, "Unknown calling package name, declining the logd access");
        return null;
    L26:
        if (firstPackageName.isEmpty() == true) goto L29;
        return firstPackageName;
    }

    void onLogAccessRequested(LogAccessRequest request) {
        LogAccessClient client = getClientForRequest(request);
        if (client != null) goto L6;
        declineRequest(request);
        return;
    L6:
        LogAccessStatus logAccessStatus = this.mLogAccessStatus.get(client);
        if (logAccessStatus != null) goto L10;
        logAccessStatus = new LogAccessStatus(null);
        this.mLogAccessStatus.put(client, logAccessStatus);
    L10:
        switch(logAccessStatus.mStatus) {
            case 0: goto L16;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            default: goto L20;
        };
    L12:
        declineRequest(request);
        return;
    L13:
        approveRequest(client, request);
        return;
    L14:
        logAccessStatus.mPendingRequests.add(request);
        return;
    L16:
        logAccessStatus.mPendingRequests.add(request);
        processNewLogAccessRequest(client);
        return;
    }

    private boolean shouldShowConfirmationDialog(LogAccessClient client) {
        int procState = this.mActivityManagerInternal.getUidProcessState(client.mUid);
        if (procState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private void processNewLogAccessRequest(LogAccessClient client) {
        if (this.mActivityManagerInternal.getInstrumentationSourceUid(client.mUid) == (-1)) goto L5;
        boolean isInstrumented = true;
    L6:
        if (isInstrumented == false) goto L10;
        onAccessApprovedForClient(client);
        return;
    L10:
        if (shouldShowConfirmationDialog(client) == true) goto L13;
        onAccessDeclinedForClient(client);
        return;
    L13:
        LogAccessStatus logAccessStatus = this.mLogAccessStatus.get(client);
        logAccessStatus.mStatus = 1;
        this.mHandler.sendMessageAtTime(this.mHandler.obtainMessage(4, client), this.mClock.get().longValue() + ((long) PENDING_CONFIRMATION_TIMEOUT_MILLIS));
        Intent mIntent = createIntent(client);
        mIntent.setFlags(268435456);
        mIntent.setComponent(new ComponentName("com.android.systemui", TARGET_ACTIVITY_NAME));
        this.mContext.startActivityAsUser(mIntent, UserHandle.SYSTEM);
        return;
    L5:
        isInstrumented = false;
        goto L6
    }

    void onAccessApprovedForClient(LogAccessClient client) {
        scheduleStatusExpiry(client);
        LogAccessStatus logAccessStatus = this.mLogAccessStatus.get(client);
        if (logAccessStatus == null) goto L11;
        Iterator<LogAccessRequest> r1 = logAccessStatus.mPendingRequests.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        LogAccessRequest request = r1.next();
        approveRequest(client, request);
        goto L6
    L8:
        logAccessStatus.mStatus = 2;
        logAccessStatus.mPendingRequests.clear();
        return;
    }

    void onAccessDeclinedForClient(LogAccessClient client) {
        scheduleStatusExpiry(client);
        LogAccessStatus logAccessStatus = this.mLogAccessStatus.get(client);
        if (logAccessStatus == null) goto L11;
        Iterator<LogAccessRequest> r1 = logAccessStatus.mPendingRequests.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        LogAccessRequest request = r1.next();
        declineRequest(request);
        goto L6
    L8:
        logAccessStatus.mStatus = 3;
        logAccessStatus.mPendingRequests.clear();
        return;
    }

    private void scheduleStatusExpiry(LogAccessClient client) {
        this.mHandler.removeMessages(4, client);
        this.mHandler.removeMessages(5, client);
        this.mHandler.sendMessageAtTime(this.mHandler.obtainMessage(5, client), this.mClock.get().longValue() + 60000);
    }

    void onPendingTimeoutExpired(LogAccessClient client) {
        LogAccessStatus logAccessStatus = this.mLogAccessStatus.get(client);
        if (logAccessStatus != null) goto L5;
        return;
    L5:
        if (logAccessStatus.mStatus != 1) goto L9;
        onAccessDeclinedForClient(client);
        return;
    }

    void onAccessStatusExpired(LogAccessClient client) {
        this.mLogAccessStatus.remove(client);
    }

    void onLogAccessFinished(LogAccessRequest request) {
        LogAccessClient client = getClientForRequest(request);
        int activeCount = this.mActiveLogAccessCount.getOrDefault(client, 1).intValue() - 1;
        if (activeCount != 0) goto L5;
        this.mActiveLogAccessCount.remove(client);
        return;
    L5:
        this.mActiveLogAccessCount.put(client, Integer.valueOf(activeCount));
    }

    private void approveRequest(LogAccessClient client, LogAccessRequest request) {
        getLogdService().approve(request.mUid, request.mGid, request.mPid, request.mFd);     // Catch: RemoteException -> L5 DeadObjectException -> L7
    L9:
        Integer activeCount = this.mActiveLogAccessCount.getOrDefault(client, 0);     // Catch: RemoteException -> L5
        this.mActiveLogAccessCount.put(client, Integer.valueOf(activeCount.intValue() + 1));     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Fails to call remote functions", e);
        return;
    L8:
        Slog.w(TAG, "Logd connection no longer valid while approving, trying once more.");     // Catch: RemoteException -> L5
        this.mLogdService = null;     // Catch: RemoteException -> L5
        getLogdService().approve(request.mUid, request.mGid, request.mPid, request.mFd);     // Catch: RemoteException -> L5
        goto L9
    }

    private void declineRequest(LogAccessRequest request) {
        getLogdService().decline(request.mUid, request.mGid, request.mPid, request.mFd);     // Catch: RemoteException -> L5 DeadObjectException -> L7
    L12:
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Fails to call remote functions", e);
        return;
    L8:
        Slog.w(TAG, "Logd connection no longer valid while declining, trying once more.");     // Catch: RemoteException -> L5
        this.mLogdService = null;     // Catch: RemoteException -> L5
        getLogdService().decline(request.mUid, request.mGid, request.mPid, request.mFd);     // Catch: RemoteException -> L5
        goto L12
    }

    public Intent createIntent(LogAccessClient client) {
        Intent intent = new Intent();
        intent.setFlags(268468224);
        intent.putExtra("android.intent.extra.PACKAGE_NAME", client.mPackageName);
        intent.putExtra("android.intent.extra.UID", client.mUid);
        intent.putExtra(EXTRA_CALLBACK, this.mDialogCallback.asBinder());
        return intent;
    }
}
