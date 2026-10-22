package com.bytedance.android.live.core.tetris.componentx.schedule;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f65624a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f65625b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f65626c = null;

    static {
        int[] r100 = new int[ComponentSchedulingManager.SchedueType.values().length];
        f65624a = r100;
        ComponentSchedulingManager.SchedueType r101 = ComponentSchedulingManager.SchedueType.TOGETHER;
        r100[r101.ordinal()] = 1;
        ComponentSchedulingManager.SchedueType r102 = ComponentSchedulingManager.SchedueType.INORDER;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[ComponentSchedulingManager.ScenInfo.values().length];
        f65625b = r103;
        r103[ComponentSchedulingManager.ScenInfo.ANCHOR.ordinal()] = 1;
        r103[ComponentSchedulingManager.ScenInfo.AUDIENCE_PORTRAIT.ordinal()] = 2;
        r103[ComponentSchedulingManager.ScenInfo.AUDIENCE_LANDSCAPE.ordinal()] = 3;
        int[] r104 = new int[ComponentSchedulingManager.SchedueType.values().length];
        f65626c = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
    }
}
