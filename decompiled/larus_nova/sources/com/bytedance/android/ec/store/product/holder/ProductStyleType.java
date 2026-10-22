package com.bytedance.android.ec.store.product.holder;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/store/product/holder/ProductStyleType;", "", "", "type", "I", "getType", "()I", EffectConstants.NORMAL, "LITE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProductStyleType extends Enum<ProductStyleType> {
    public static final ProductStyleType LITE = null;
    public static final ProductStyleType NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProductStyleType[] f48293a = null;
    private final int type;

    static {
        ProductStyleType r100 = new ProductStyleType(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        ProductStyleType r101 = new ProductStyleType("LITE", 1, 1);
        LITE = r101;
        f48293a = new ProductStyleType[]{r100, r101};
    }

    public static ProductStyleType valueOf(String r100) {
        return (ProductStyleType) a.a(ProductStyleType.class, r100);
    }

    public static ProductStyleType[] values() {
        return (ProductStyleType[]) f48293a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ProductStyleType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
