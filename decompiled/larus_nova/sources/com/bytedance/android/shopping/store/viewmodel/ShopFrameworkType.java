package com.bytedance.android.shopping.store.viewmodel;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/viewmodel/ShopFrameworkType;", "", "", "type", "I", "getType", "()I", EffectConstants.NORMAL, "MIDDLE_TAB", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopFrameworkType extends Enum<ShopFrameworkType> {
    public static final ShopFrameworkType MIDDLE_TAB = null;
    public static final ShopFrameworkType NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShopFrameworkType[] f187012a = null;
    private final int type;

    static {
        ShopFrameworkType r100 = new ShopFrameworkType(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        ShopFrameworkType r101 = new ShopFrameworkType("MIDDLE_TAB", 1, 2);
        MIDDLE_TAB = r101;
        f187012a = new ShopFrameworkType[]{r100, r101};
    }

    public static ShopFrameworkType valueOf(String r100) {
        return (ShopFrameworkType) r27.a.a(ShopFrameworkType.class, r100);
    }

    public static ShopFrameworkType[] values() {
        return (ShopFrameworkType[]) f187012a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ShopFrameworkType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
