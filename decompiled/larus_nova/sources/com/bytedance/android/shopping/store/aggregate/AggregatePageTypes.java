package com.bytedance.android.shopping.store.aggregate;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/AggregatePageTypes;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "FULL_DISCOUNT", "CLASSIFICATION", "FOLLOW_COUPON", "LIVE_STORE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AggregatePageTypes extends Enum<AggregatePageTypes> {
    public static final AggregatePageTypes CLASSIFICATION = null;
    public static final AggregatePageTypes FOLLOW_COUPON = null;
    public static final AggregatePageTypes FULL_DISCOUNT = null;
    public static final AggregatePageTypes LIVE_STORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AggregatePageTypes[] f183347a = null;
    private final String type;

    static {
        AggregatePageTypes r100 = new AggregatePageTypes("FULL_DISCOUNT", 0, "1");
        FULL_DISCOUNT = r100;
        AggregatePageTypes r101 = new AggregatePageTypes("CLASSIFICATION", 1, "2");
        CLASSIFICATION = r101;
        AggregatePageTypes r102 = new AggregatePageTypes("FOLLOW_COUPON", 2, "3");
        FOLLOW_COUPON = r102;
        AggregatePageTypes r103 = new AggregatePageTypes("LIVE_STORE", 3, "4");
        LIVE_STORE = r103;
        f183347a = new AggregatePageTypes[]{r100, r101, r102, r103};
    }

    public static AggregatePageTypes valueOf(String r100) {
        return (AggregatePageTypes) r27.a.a(AggregatePageTypes.class, r100);
    }

    public static AggregatePageTypes[] values() {
        return (AggregatePageTypes[]) f183347a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public AggregatePageTypes(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
