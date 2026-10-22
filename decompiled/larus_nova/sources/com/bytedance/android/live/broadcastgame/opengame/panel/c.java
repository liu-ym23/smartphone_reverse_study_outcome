package com.bytedance.android.live.broadcastgame.opengame.panel;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f60676a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f60677b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f60678c = null;

    static {
        int[] r100 = new int[PanelType.values().length];
        f60676a = r100;
        PanelType r101 = PanelType.PANEL_TYPE_PORTRAIT;
        r100[r101.ordinal()] = 1;
        PanelType r102 = PanelType.PANEL_TYPE_X_SCREEN;
        r100[r102.ordinal()] = 2;
        PanelType r103 = PanelType.PANEL_TYPE_X_SCREEN_LOW;
        r100[r103.ordinal()] = 3;
        PanelType r104 = PanelType.PANEL_TYPE_LANDSCAPE;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[PanelType.values().length];
        f60677b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        r105[r104.ordinal()] = 4;
        int[] r106 = new int[PanelType.values().length];
        f60678c = r106;
        r106[r104.ordinal()] = 1;
        r106[r101.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r102.ordinal()] = 4;
    }
}
