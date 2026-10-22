package com.bytedance.android.shopping.store.home.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopMarketingScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CART_UPDATE", "VIEW_UPDATE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopMarketingScene extends Enum<ShopMarketingScene> {
    public static final ShopMarketingScene CART_UPDATE = null;
    public static final ShopMarketingScene VIEW_UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShopMarketingScene[] f183643a = null;
    private final String value;

    static {
        ShopMarketingScene r100 = new ShopMarketingScene("CART_UPDATE", 0, "cart_update");
        CART_UPDATE = r100;
        ShopMarketingScene r101 = new ShopMarketingScene("VIEW_UPDATE", 1, "view_update");
        VIEW_UPDATE = r101;
        f183643a = new ShopMarketingScene[]{r100, r101};
    }

    public static ShopMarketingScene valueOf(String r100) {
        return (ShopMarketingScene) r27.a.a(ShopMarketingScene.class, r100);
    }

    public static ShopMarketingScene[] values() {
        return (ShopMarketingScene[]) f183643a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ShopMarketingScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
