package com.android.server.wm;

import com.android.server.am.SysMonitorSvcBridge;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityRecordMonitorEx {
    public IActivityLaunchTimeStatistics launchTimeStatistics;
    private ActivityRecord mActivityRecord;

    public ActivityRecordMonitorEx(ActivityRecord activityRecord) {
        this.mActivityRecord = activityRecord;
        this.launchTimeStatistics = SysMonitorSvcBridge.getFactory().getActivityLaunchTimeStatistics(activityRecord);
    }
}
