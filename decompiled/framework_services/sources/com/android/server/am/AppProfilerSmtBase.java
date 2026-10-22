package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public class AppProfilerSmtBase {
    long mCachedPss;
    long mTotalEGL;
    long mTotalPss;

    public AppProfilerSmtBase() {
        this.mCachedPss = 0;
        this.mTotalPss = 0;
        this.mTotalEGL = 0;
    }

    void collectCachedPss(ProcessRecord app) {
        if (app.getSmtEx().memoryInfo == null) goto L5;
        long egl = app.getSmtEx().memoryInfo.getOtherPss(14);
        long pss = app.getSmtEx().memoryInfo.getTotalPss();
    L6:
        int oomAdj = app.mState.getSetAdjWithServices();
        if (oomAdj < 900) goto L9;
        this.mCachedPss += pss;
    L9:
        this.mTotalPss += pss;
        this.mTotalEGL += egl;
        return;
    L5:
        egl = app.getSmtEx().mEGL;
        pss = app.getSmtEx().mPss;
        goto L6
    }

    void collectCachedPss(long pss, long egl, int oomAdj, boolean javaProcess) {
        if (javaProcess == true) goto L4;
    L6:
        this.mTotalPss += pss;
        this.mTotalEGL += egl;
        return;
    L4:
        if (oomAdj < 900) goto L6;
        this.mCachedPss += pss;
        goto L6
    }

    public void executeMemoryStrategyPss(String processName, int pid, long pss, int oomAdj) {
        SysMonitorSvcBridge.getFactory().getMemoryStrategy().executeMemoryStrategyPss(processName, pid, pss, oomAdj);
    }

    public void executeMemoryStrategyRss(String processName, int pid, long rss, int oomAdj) {
        SysMonitorSvcBridge.getFactory().getMemoryStrategy().executeMemoryStrategyRss(processName, pid, rss, oomAdj);
    }

    void resetProcStatsCollectData() {
        this.mTotalPss = 0;
        this.mCachedPss = 0;
        this.mTotalEGL = 0;
    }
}
