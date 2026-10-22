package com.bytedance.android.shopping.store.home.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/home/api/ShopType;", "", "", "type", "I", "getType", "()I", "WHITE_BRAND", "RED_MAN", "DEFAULT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopType extends Enum<ShopType> {
    public static final ShopType DEFAULT = null;
    public static final ShopType RED_MAN = null;
    public static final ShopType WHITE_BRAND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShopType[] f183601a = null;
    private final int type;

    static {
        ShopType r100 = new ShopType("WHITE_BRAND", 0, 3);
        WHITE_BRAND = r100;
        ShopType r101 = new ShopType("RED_MAN", 1, 4);
        RED_MAN = r101;
        ShopType r102 = new ShopType("DEFAULT", 2, 0);
        DEFAULT = r102;
        f183601a = new ShopType[]{r100, r101, r102};
    }

    public static ShopType valueOf(String r100) {
        return (ShopType) r27.a.a(ShopType.class, r100);
    }

    public static ShopType[] values() {
        return (ShopType[]) f183601a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ShopType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
