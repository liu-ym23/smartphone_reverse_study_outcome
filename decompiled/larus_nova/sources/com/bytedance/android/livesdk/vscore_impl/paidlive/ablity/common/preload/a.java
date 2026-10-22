package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.preload;

import com.bytedance.android.livesdk.vscore_api.paidlive.ability.common.PaidPreloadDataType;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f160218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f160219b = null;

    static {
        int[] r100 = new int[PaidPreloadDataType.values().length];
        f160218a = r100;
        PaidPreloadDataType r101 = PaidPreloadDataType.BUY_PANEL;
        r100[r101.ordinal()] = 1;
        int[] r102 = new int[PaidPreloadDataType.values().length];
        f160219b = r102;
        r102[r101.ordinal()] = 1;
    }
}
