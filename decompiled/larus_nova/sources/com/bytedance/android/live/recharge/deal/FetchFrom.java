package com.bytedance.android.live.recharge.deal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/FetchFrom;", "", "", "value", "I", "getValue", "()I", "Unknown", "LiveRoom", "RechargePanel", "PreFetch", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FetchFrom extends Enum<FetchFrom> {
    public static final FetchFrom LiveRoom = null;
    public static final FetchFrom PreFetch = null;
    public static final FetchFrom RechargePanel = null;
    public static final FetchFrom Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FetchFrom[] f89692a = null;
    private final int value;

    static {
        FetchFrom r100 = new FetchFrom("Unknown", 0, 0);
        Unknown = r100;
        FetchFrom r101 = new FetchFrom("LiveRoom", 1, 1);
        LiveRoom = r101;
        FetchFrom r102 = new FetchFrom("RechargePanel", 2, 2);
        RechargePanel = r102;
        FetchFrom r103 = new FetchFrom("PreFetch", 3, 4);
        PreFetch = r103;
        f89692a = new FetchFrom[]{r100, r101, r102, r103};
    }

    public static FetchFrom valueOf(String r100) {
        return (FetchFrom) r27.a.a(FetchFrom.class, r100);
    }

    public static FetchFrom[] values() {
        return (FetchFrom[]) f89692a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public FetchFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
