package com.android.server.am;

import android.app.IApplicationThread;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class ApplicationThreadDeferred extends IApplicationThread.Delegator {
    private static final int CLEAR_DNS_CACHE = 0;
    private static final int NOTIFICATION_COUNT = 4;
    private static final int SCHEDULE_LOW_MEMORY = 2;
    static final String TAG = "ActivityManager";
    private static final int UPDATE_HTTP_PROXY = 3;
    private static final int UPDATE_TIME_ZONE = 1;
    private final IApplicationThread mBase;
    private final boolean mDefer;
    private final Object mLock;
    private final Operation[] mOperations;
    private boolean mPaused;
    private final boolean[] mPending;

    @Retention(RetentionPolicy.SOURCE)
    private @interface NotificationType {
    }

    private interface Operation {
        void run() throws RemoteException;
    }

    /* JADX INFO: renamed from: $r8$lambda$EyFIl9oQearTD0bqYtkIdp-2aEw, reason: not valid java name */
    public static /* synthetic */ void m1387$r8$lambda$EyFIl9oQearTD0bqYtkIdp2aEw(ApplicationThreadDeferred r0) {
        r0.lambda$new$3();
    }

    public static /* synthetic */ void $r8$lambda$PP7wSw0gGLmO6hi1tOkPocTG8v8(ApplicationThreadDeferred r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$_AjVZez4200DRB8oUj9lSUVdMXo(ApplicationThreadDeferred r0) {
        r0.lambda$new$2();
    }

    public static /* synthetic */ void $r8$lambda$pzCGrkeFAdnodnDYXv9us5vUB_A(ApplicationThreadDeferred r0) {
        r0.lambda$new$1();
    }

    private static boolean deferBindersWhenPaused() {
        return true;
    }

    public ApplicationThreadDeferred(IApplicationThread thread, boolean defer) {
        super(thread);
        this.mLock = new Object();
        this.mPaused = false;
        this.mOperations = new Operation[4];
        this.mPending = new boolean[4];
        this.mBase = thread;
        this.mDefer = defer;
        this.mOperations[0] = new ApplicationThreadDeferred$$ExternalSyntheticLambda0(this);
        this.mOperations[1] = new ApplicationThreadDeferred$$ExternalSyntheticLambda1(this);
        this.mOperations[2] = new ApplicationThreadDeferred$$ExternalSyntheticLambda2(this);
        this.mOperations[3] = new ApplicationThreadDeferred$$ExternalSyntheticLambda3(this);
    }

    private /* synthetic */ void lambda$new$0() throws RemoteException {
        super.clearDnsCache();
    }

    private /* synthetic */ void lambda$new$1() throws RemoteException {
        super.updateTimeZone();
    }

    private /* synthetic */ void lambda$new$2() throws RemoteException {
        super.scheduleLowMemory();
    }

    private /* synthetic */ void lambda$new$3() throws RemoteException {
        super.updateHttpProxy();
    }

    public ApplicationThreadDeferred(IApplicationThread thread) {
        this(thread, deferBindersWhenPaused());
    }

    public IBinder asBinder() {
        return this.mBase.asBinder();
    }

    void onProcessPaused() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPaused = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void onProcessUnpaused() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPaused = false;     // Catch: Throwable -> L21
        int i = 0;
    L31:
    L13:
        th = move-exception;
        Arrays.fill(this.mPending, false);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L8:
        if (i >= this.mOperations.length) goto L19;
        if (this.mPending[i] == false) goto L17;
        this.mOperations[i].run();     // Catch: Throwable -> L13 RemoteException -> L15
    L17:
        i = i + 1;
        goto L31
    L19:
        Arrays.fill(this.mPending, false);     // Catch: Throwable -> L21
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L25:
        Arrays.fill(this.mPending, false);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    void onProcessPausedCancelled() {
        onProcessUnpaused();
    }

    private void execute(int tag) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mPaused == true) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.mOperations[tag].run();
        return;
    L7:
        if (this.mDefer == false) goto L13;
        this.mPending[tag] = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void clearDnsCache() throws RemoteException {
        execute(0);
    }

    public void updateTimeZone() throws RemoteException {
        execute(1);
    }

    public void scheduleLowMemory() throws RemoteException {
        execute(2);
    }

    public void updateHttpProxy() throws RemoteException {
        execute(3);
    }
}
