package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f150780a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f150781b = null;

    static {
        int[] r100 = new int[HotAtmosphereHelperV2.CountState.values().length];
        f150780a = r100;
        HotAtmosphereHelperV2.CountState r101 = HotAtmosphereHelperV2.CountState.FINISHED;
        r100[r101.ordinal()] = 1;
        HotAtmosphereHelperV2.CountState r102 = HotAtmosphereHelperV2.CountState.IN_PROGRESS;
        r100[r102.ordinal()] = 2;
        HotAtmosphereHelperV2.CountState r103 = HotAtmosphereHelperV2.CountState.NOT_START;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[HotAtmosphereHelperV2.CountState.values().length];
        f150781b = r104;
        r104[r103.ordinal()] = 1;
        r104[r101.ordinal()] = 2;
        r104[r102.ordinal()] = 3;
    }
}
