package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public abstract class FpsDetectManagerInternal {
    public abstract void QuickFlipsDetect(boolean r1);

    public abstract long[] getFlips();

    public abstract long getFps();

    public abstract long getQuickFlips();

    public abstract void refreshRateDropped(boolean r1);

    public abstract void startFlipsDetect(boolean r1);

    public FpsDetectManagerInternal() {
    }
}
