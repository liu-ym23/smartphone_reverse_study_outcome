package com.bytedance.android.livesdk.gift.platform.core.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/GiftTransactionReqCount;", "", "", "value", "I", "getValue", "()I", "TransactionBlock", "TransactionNull", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GiftTransactionReqCount extends Enum<GiftTransactionReqCount> {
    public static final GiftTransactionReqCount TransactionBlock = null;
    public static final GiftTransactionReqCount TransactionNull = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftTransactionReqCount[] f130825a = null;
    private final int value;

    static {
        GiftTransactionReqCount r100 = new GiftTransactionReqCount("TransactionBlock", 0, -1);
        TransactionBlock = r100;
        GiftTransactionReqCount r101 = new GiftTransactionReqCount("TransactionNull", 1, -2);
        TransactionNull = r101;
        f130825a = new GiftTransactionReqCount[]{r100, r101};
    }

    public static GiftTransactionReqCount valueOf(String r100) {
        return (GiftTransactionReqCount) r27.a.a(GiftTransactionReqCount.class, r100);
    }

    public static GiftTransactionReqCount[] values() {
        return (GiftTransactionReqCount[]) f130825a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public GiftTransactionReqCount(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
