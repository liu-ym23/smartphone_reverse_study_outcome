package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ActivityDisplaySmtBase {
    protected static final long mAcquirePerfLastInterval = 300;
    protected static long mAcquirePerfLockLastTime = 0;
    protected static final int mAcquirePerfMaxTimes = 200;
    protected static int mAcquirePerfTimes;
    protected static boolean mPrintSwitch;
    protected ActivityTaskManagerService mTaskService;

    static {
        mAcquirePerfLockLastTime = 0;
        mAcquirePerfTimes = 0;
        mPrintSwitch = true;
    }

    public ActivityDisplaySmtBase(ActivityTaskManagerService service) {
        this.mTaskService = service;
    }

    void setColdLaunchFlag(ActivityTaskManagerService mTaskService, ActivityRecord r) {
        mTaskService.getSmtEx().setIsColdLaunch(true);
        r.info.applicationInfo.getSysEx().bytedanceFlag |= 16;
    }
}
