package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public abstract class ScreenRefreshRateInternal {
    public abstract void addFpsChangeListener(FpsChangeListener r1);

    public abstract String getTpReportRate(boolean r1);

    public abstract void noteDualOsSwitch(boolean r1);

    public abstract void noteHoldScreenWindowPkg(String r1);

    public abstract void noteIMEShowing();

    public abstract void noteKeyGestureBackEvent();

    public abstract void notePackageInterpState(String r1, int r2);

    public abstract void noteScreenState(int r1);

    public abstract void noteScreenStateFromDummySleep(int r1);

    public abstract void noteShowOrHideSoftInputMethod(boolean r1);

    public abstract void noteSwipeStart();

    public abstract void noteTGPAGameStarted(String r1);

    public abstract void setFpsByPush(String r1);

    public abstract void setFpsByTGPA(String r1, int r2);

    public abstract boolean writeReportRateNode(String r1, boolean r2);

    public ScreenRefreshRateInternal() {
    }
}
