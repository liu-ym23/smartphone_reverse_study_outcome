package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityTaskManagerInternalSmtBase {
    protected ActivityTaskManagerService mAtmServices;
    public ActivityTaskManagerServiceSmtBase mAtmsmt;

    public ActivityTaskManagerInternalSmtBase(ActivityTaskManagerService atmServices) {
        this.mAtmsmt = null;
        this.mAtmServices = atmServices;
    }

    public void onPrefetchProcessRemoved(String name, int uid) {
        Object r0 = this.mAtmServices.mGlobalLockWithoutBoost;
        monitor-enter(r0);
        this.mAtmServices.getSmtEx().mPrefetchProcessNames.remove(name, uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onPrefetchProcessAdded(WindowProcessController proc) {
        Object r0 = this.mAtmServices.mGlobalLockWithoutBoost;
        monitor-enter(r0);
        this.mAtmServices.getSmtEx().mPrefetchProcessNames.put(proc.mName, proc.mUid, proc);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public WindowProcessController getPreviousVrProcess() {
        if (this.mAtmsmt != null) goto L6;
        this.mAtmsmt = this.mAtmServices.getSmtEx();
    L6:
        if (this.mAtmsmt != null) goto L10;
        return null;
    L10:
        return this.mAtmsmt.getPreviousVrProcess();
    }
}
