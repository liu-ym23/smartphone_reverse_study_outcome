package com.bytedance.android.gamecp.base.gamedetail;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f51536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f51537b = null;

    static {
        int[] r100 = new int[AudienceReserveSmallBtnConfig.State.values().length];
        f51536a = r100;
        AudienceReserveSmallBtnConfig.State r101 = AudienceReserveSmallBtnConfig.State.RESERVE;
        r100[r101.ordinal()] = 1;
        AudienceReserveSmallBtnConfig.State r102 = AudienceReserveSmallBtnConfig.State.CANCEL_RESERVE;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[AudienceReserveSmallBtnConfig.State.values().length];
        f51537b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
