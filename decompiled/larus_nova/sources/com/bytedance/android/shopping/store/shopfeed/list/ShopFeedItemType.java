package com.bytedance.android.shopping.store.shopfeed.list;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedItemType;", "", "", "typeValue", "I", "getTypeValue", "()I", "LYNX_CARD", "SLICE_CARD", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopFeedItemType extends Enum<ShopFeedItemType> {
    public static final ShopFeedItemType LYNX_CARD = null;
    public static final ShopFeedItemType SLICE_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShopFeedItemType[] f186197a = null;
    private final int typeValue;

    static {
        ShopFeedItemType r100 = new ShopFeedItemType("LYNX_CARD", 0, 1);
        LYNX_CARD = r100;
        ShopFeedItemType r101 = new ShopFeedItemType("SLICE_CARD", 1, 2);
        SLICE_CARD = r101;
        f186197a = new ShopFeedItemType[]{r100, r101};
    }

    public static ShopFeedItemType valueOf(String r100) {
        return (ShopFeedItemType) r27.a.a(ShopFeedItemType.class, r100);
    }

    public static ShopFeedItemType[] values() {
        return (ShopFeedItemType[]) f186197a.clone();
    }

    public final int getTypeValue() {
        return this.typeValue;
    }

    public ShopFeedItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
