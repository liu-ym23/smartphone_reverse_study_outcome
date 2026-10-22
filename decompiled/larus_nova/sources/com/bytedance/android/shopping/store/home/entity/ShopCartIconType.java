package com.bytedance.android.shopping.store.home.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopCartIconType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "RED", "DEFAULT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopCartIconType extends Enum<ShopCartIconType> {
    public static final ShopCartIconType DEFAULT = null;
    public static final ShopCartIconType RED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShopCartIconType[] f183640a = null;
    private final String type;

    static {
        ShopCartIconType r100 = new ShopCartIconType("RED", 0, "red");
        RED = r100;
        ShopCartIconType r101 = new ShopCartIconType("DEFAULT", 1, "default");
        DEFAULT = r101;
        f183640a = new ShopCartIconType[]{r100, r101};
    }

    public static ShopCartIconType valueOf(String r100) {
        return (ShopCartIconType) r27.a.a(ShopCartIconType.class, r100);
    }

    public static ShopCartIconType[] values() {
        return (ShopCartIconType[]) f183640a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public ShopCartIconType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
