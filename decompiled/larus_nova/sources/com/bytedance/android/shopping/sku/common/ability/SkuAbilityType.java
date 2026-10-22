package com.bytedance.android.shopping.sku.common.ability;

import com.bytedance.android.ec.model.response.ECPromotion;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/ability/SkuAbilityType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SKU", "BUYNOW", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkuAbilityType extends Enum<SkuAbilityType> {
    public static final SkuAbilityType BUYNOW = null;
    public static final SkuAbilityType SKU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkuAbilityType[] f182611a = null;
    private final String value;

    static {
        SkuAbilityType r100 = new SkuAbilityType("SKU", 0, ECPromotion.SKU);
        SKU = r100;
        SkuAbilityType r101 = new SkuAbilityType("BUYNOW", 1, "ultimate_buy");
        BUYNOW = r101;
        f182611a = new SkuAbilityType[]{r100, r101};
    }

    public static SkuAbilityType valueOf(String r100) {
        return (SkuAbilityType) r27.a.a(SkuAbilityType.class, r100);
    }

    public static SkuAbilityType[] values() {
        return (SkuAbilityType[]) f182611a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public SkuAbilityType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
