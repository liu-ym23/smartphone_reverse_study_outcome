package com.bytedance.android.window.shop.repository.tab.datasource;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/datasource/ShopWindowVODataType;", "", "PIN", EffectConstants.NORMAL, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopWindowVODataType extends Enum<ShopWindowVODataType> {
    public static final ShopWindowVODataType NORMAL = null;
    public static final ShopWindowVODataType PIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShopWindowVODataType[] f189431a = null;

    static {
        ShopWindowVODataType r100 = new ShopWindowVODataType("PIN", 0);
        PIN = r100;
        ShopWindowVODataType r101 = new ShopWindowVODataType(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        f189431a = new ShopWindowVODataType[]{r100, r101};
    }

    public static ShopWindowVODataType valueOf(String r100) {
        return (ShopWindowVODataType) r27.a.a(ShopWindowVODataType.class, r100);
    }

    public static ShopWindowVODataType[] values() {
        return (ShopWindowVODataType[]) f189431a.clone();
    }

    public ShopWindowVODataType(String r100, int r101) {
        super(r100, r101);
    }
}
