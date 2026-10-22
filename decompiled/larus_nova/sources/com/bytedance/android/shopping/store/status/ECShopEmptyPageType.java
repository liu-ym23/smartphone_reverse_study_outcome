package com.bytedance.android.shopping.store.status;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/status/ECShopEmptyPageType;", "", "CLASSIFICATION", "SEARCH_RESULT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECShopEmptyPageType extends Enum<ECShopEmptyPageType> {
    public static final ECShopEmptyPageType CLASSIFICATION = null;
    public static final ECShopEmptyPageType SEARCH_RESULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECShopEmptyPageType[] f186428a = null;

    static {
        ECShopEmptyPageType r100 = new ECShopEmptyPageType("CLASSIFICATION", 0);
        CLASSIFICATION = r100;
        ECShopEmptyPageType r101 = new ECShopEmptyPageType("SEARCH_RESULT", 1);
        SEARCH_RESULT = r101;
        f186428a = new ECShopEmptyPageType[]{r100, r101};
    }

    public static ECShopEmptyPageType valueOf(String r100) {
        return (ECShopEmptyPageType) r27.a.a(ECShopEmptyPageType.class, r100);
    }

    public static ECShopEmptyPageType[] values() {
        return (ECShopEmptyPageType[]) f186428a.clone();
    }

    public ECShopEmptyPageType(String r100, int r101) {
        super(r100, r101);
    }
}
