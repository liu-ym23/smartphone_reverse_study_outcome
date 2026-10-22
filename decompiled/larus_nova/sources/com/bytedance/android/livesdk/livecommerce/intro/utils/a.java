package com.bytedance.android.livesdk.livecommerce.intro.utils;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f148517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f148518b = null;

    static {
        int[] r100 = new int[IntroAuctionAtmosphereHelper.CountState.values().length];
        f148517a = r100;
        IntroAuctionAtmosphereHelper.CountState r101 = IntroAuctionAtmosphereHelper.CountState.FINISHED;
        r100[r101.ordinal()] = 1;
        IntroAuctionAtmosphereHelper.CountState r102 = IntroAuctionAtmosphereHelper.CountState.IN_PROGRESS;
        r100[r102.ordinal()] = 2;
        IntroAuctionAtmosphereHelper.CountState r103 = IntroAuctionAtmosphereHelper.CountState.NOT_START;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[IntroAuctionAtmosphereHelper.CountState.values().length];
        f148518b = r104;
        r104[r103.ordinal()] = 1;
        r104[r101.ordinal()] = 2;
        r104[r102.ordinal()] = 3;
    }
}
