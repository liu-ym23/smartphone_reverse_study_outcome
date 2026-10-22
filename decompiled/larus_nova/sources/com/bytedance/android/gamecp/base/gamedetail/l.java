package com.bytedance.android.gamecp.base.gamedetail;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f51615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f51616b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f51617c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f51618d = null;

    static {
        int[] r100 = new int[AudienceReverseBtnConfig.State.values().length];
        f51615a = r100;
        AudienceReverseBtnConfig.State r101 = AudienceReverseBtnConfig.State.IMMEDIATE_RESERVE;
        r100[r101.ordinal()] = 1;
        AudienceReverseBtnConfig.State r102 = AudienceReverseBtnConfig.State.IMMEDIATE_RESERVE_HAS_PACKAGE;
        r100[r102.ordinal()] = 2;
        AudienceReverseBtnConfig.State r103 = AudienceReverseBtnConfig.State.RESERVE;
        r100[r103.ordinal()] = 3;
        AudienceReverseBtnConfig.State r104 = AudienceReverseBtnConfig.State.CANCEL_RESERVE;
        r100[r104.ordinal()] = 4;
        AudienceReverseBtnConfig.State r105 = AudienceReverseBtnConfig.State.CANCEL_RESERVE_CARD;
        r100[r105.ordinal()] = 5;
        int[] r106 = new int[AudienceReverseBtnConfig.State.values().length];
        f51616b = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r104.ordinal()] = 4;
        r106[r105.ordinal()] = 5;
        int[] r107 = new int[AudienceReverseBtnConfig.State.values().length];
        f51617c = r107;
        r107[r101.ordinal()] = 1;
        r107[r102.ordinal()] = 2;
        r107[r104.ordinal()] = 3;
        r107[r103.ordinal()] = 4;
        int[] r108 = new int[AudienceReverseBtnConfig.State.values().length];
        f51618d = r108;
        r108[r101.ordinal()] = 1;
        r108[r102.ordinal()] = 2;
        r108[r104.ordinal()] = 3;
        r108[r103.ordinal()] = 4;
    }
}
