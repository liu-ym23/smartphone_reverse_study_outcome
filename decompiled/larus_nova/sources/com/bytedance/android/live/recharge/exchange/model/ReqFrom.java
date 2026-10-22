package com.bytedance.android.live.recharge.exchange.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/model/ReqFrom;", "", "", "value", "I", "getValue", "()I", "UnKnown", "TaskCenter", "GiftPanel", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReqFrom extends Enum<ReqFrom> {
    public static final ReqFrom GiftPanel = null;
    public static final ReqFrom TaskCenter = null;
    public static final ReqFrom UnKnown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReqFrom[] f89858a = null;
    private final int value;

    static {
        ReqFrom r100 = new ReqFrom("UnKnown", 0, 0);
        UnKnown = r100;
        ReqFrom r101 = new ReqFrom("TaskCenter", 1, 1);
        TaskCenter = r101;
        ReqFrom r102 = new ReqFrom("GiftPanel", 2, 2);
        GiftPanel = r102;
        f89858a = new ReqFrom[]{r100, r101, r102};
    }

    public static ReqFrom valueOf(String r100) {
        return (ReqFrom) r27.a.a(ReqFrom.class, r100);
    }

    public static ReqFrom[] values() {
        return (ReqFrom[]) f89858a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ReqFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
