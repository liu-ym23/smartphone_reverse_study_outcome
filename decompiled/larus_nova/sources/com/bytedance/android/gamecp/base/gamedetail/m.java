package com.bytedance.android.gamecp.base.gamedetail;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f51630a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f51631b = null;

    static {
        int[] r100 = new int[AudienceReverseBtnConfig.State.values().length];
        f51630a = r100;
        r100[AudienceReverseBtnConfig.State.IMMEDIATE_RESERVE.ordinal()] = 1;
        AudienceReverseBtnConfig.State r101 = AudienceReverseBtnConfig.State.IMMEDIATE_RESERVE_HAS_PACKAGE;
        r100[r101.ordinal()] = 2;
        r100[AudienceReverseBtnConfig.State.CANCEL_RESERVE.ordinal()] = 3;
        r100[AudienceReverseBtnConfig.State.CANCEL_RESERVE_CARD.ordinal()] = 4;
        r100[AudienceReverseBtnConfig.State.RESERVE.ordinal()] = 5;
        int[] r102 = new int[AudienceReverseBtnConfig.State.values().length];
        f51631b = r102;
        r102[r101.ordinal()] = 1;
    }
}
