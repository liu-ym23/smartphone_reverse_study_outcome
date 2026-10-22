package com.android.server.wm;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.SystemClock;
import android.view.Display;
import com.android.server.SysOptBridge;
import com.android.server.am.ProcessRecord;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityRecordSmtBase extends ConfigurationContainerSysEx {
    public String launchedFromPackage;
    public int launchedFromUid;
    public ActivityRecord mActivityRecord;
    private DisplayManager mDisplayManager;
    public int mSysLaunchType;
    private WindowProcessControllerSmtBase mWpcSmt;
    protected IActivityRecordOptEx optEx;
    public boolean pauseTimeout;
    public long pauseTimeoutBegin;
    public int perfActivityBoostCanRelease;

    public void reportPauseTimeoutEventIfNeeded(ActivityTaskManagerService atms) {
        if (this.pauseTimeout == true) goto L5;
    L9:
        this.pauseTimeout = false;
        this.pauseTimeoutBegin = 0;
        return;
    L5:
        if (this.pauseTimeoutBegin == 0) goto L9;
        if (atms.mContext == null) goto L9;
        long duration = SystemClock.elapsedRealtime() - this.pauseTimeoutBegin;
        SysOptBridge.getFactory().getPauseTimeoutDataUpload().updatePauseTimeoutEvent(this.mActivityRecord.mActivityComponent.getPackageName(), this.mActivityRecord.mActivityComponent.getClassName(), duration);
        goto L9
    }

    public String getActivityComponent() {
        if (this.mActivityRecord != null) goto L5;
        return "";
    L5:
        if (this.mActivityRecord.mActivityComponent != null) goto L7;
        return "";
    L7:
        return this.mActivityRecord.mActivityComponent.flattenToShortString();
    }

    public String getActivityComponentComplete() {
        if (this.mActivityRecord != null) goto L5;
        return "";
    L5:
        if (this.mActivityRecord.intent != null) goto L7;
        return "";
    L7:
        if (this.mActivityRecord.intent.getComponent() != null) goto L9;
        return "";
    L9:
        return this.mActivityRecord.intent.getComponent().toShortString();
    }

    public Display getDisplay(int displayId, Context context) {
        if (this.mDisplayManager != null) goto L6;
        this.mDisplayManager = (DisplayManager) context.getSystemService("display");
    L6:
        if (this.mDisplayManager != null) goto L8;
        return null;
    L8:
        return this.mDisplayManager.getDisplay(displayId);
    }

    public void setLaunchSource(int sourceUid, String sourcePackageName) {
        this.launchedFromUid = sourceUid;
        this.launchedFromPackage = sourcePackageName;
    }

    public WindowProcessControllerSmtBase getProcessControllerSmt() {
        if (this.mWpcSmt == null) goto L7;
        return this.mWpcSmt;
    L7:
        if (this.mActivityRecord == null) goto L12;
        WindowProcessController app = this.mActivityRecord.app;
        if (app == null) goto L12;
        this.mWpcSmt = app.getWPCSmtEx();
    L12:
        return this.mWpcSmt;
    }

    public void stopPkgIfMarked() {
        if (this.mActivityRecord != null) goto L5;
        return;
    L5:
        if (this.mActivityRecord.info != null) goto L7;
        return;
    L7:
        if (this.mActivityRecord.info.applicationInfo == null) goto L12;
        SysOptBridge.getFactory().getSingle3DApp().stopMarkedPkg(this.mActivityRecord.packageName, this.mActivityRecord.getUid(), this.mActivityRecord);
        return;
    }

    public boolean isRecordStateAfterStop() {
        if (this.mActivityRecord.mState != ActivityRecord.State.STOPPED) goto L5;
    L12:
        return true;
    L5:
        if (this.mActivityRecord.mState == ActivityRecord.State.FINISHING) goto L12;
        if (this.mActivityRecord.mState == ActivityRecord.State.DESTROYING) goto L12;
        if (this.mActivityRecord.mState == ActivityRecord.State.DESTROYED) goto L12;
        return false;
    }

    public ActivityRecordSmtBase(ActivityRecord record) {
        super(record);
        this.mSysLaunchType = 0;
        this.pauseTimeoutBegin = 0;
        this.pauseTimeout = false;
        this.perfActivityBoostCanRelease = 1;
        this.launchedFromUid = 0;
        this.launchedFromPackage = null;
        this.mWpcSmt = null;
        this.mActivityRecord = record;
        this.optEx = SysOptBridge.getFactory().createActivityRecordOptEx(record);
    }

    public boolean isPrefetchApp() {
        if (this.mActivityRecord.app != null) goto L5;
        return false;
    L5:
        return ((ProcessRecord) this.mActivityRecord.app.mOwner).getSmtEx().isPrefetch;
    }
}
