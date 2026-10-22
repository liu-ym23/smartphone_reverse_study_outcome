package com.bytedance.android.shopping.anchorv4.ai;

/* JADX INFO: loaded from: classes12.dex */
public final /* synthetic */ class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f165693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f165694b = null;

    static {
        int[] r100 = new int[MockAIChatWindowState.values().length];
        f165693a = r100;
        MockAIChatWindowState r101 = MockAIChatWindowState.COLLAPSED;
        r100[r101.ordinal()] = 1;
        MockAIChatWindowState r102 = MockAIChatWindowState.EXPANDED;
        r100[r102.ordinal()] = 2;
        MockAIChatWindowState r103 = MockAIChatWindowState.THINKING;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[MockAIChatWindowState.values().length];
        f165694b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}
