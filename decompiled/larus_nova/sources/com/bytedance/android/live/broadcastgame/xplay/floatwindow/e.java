package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f62153a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f62154b = null;

    static {
        int[] r100 = new int[XplayFloatWindowView.ViewState.values().length];
        f62153a = r100;
        XplayFloatWindowView.ViewState r101 = XplayFloatWindowView.ViewState.InteractiveExpanded;
        r100[r101.ordinal()] = 1;
        XplayFloatWindowView.ViewState r102 = XplayFloatWindowView.ViewState.InteractiveCollapsed;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[XplayFloatWindowView.ViewState.values().length];
        f62154b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
        r103[XplayFloatWindowView.ViewState.NonInteractive.ordinal()] = 3;
    }
}
