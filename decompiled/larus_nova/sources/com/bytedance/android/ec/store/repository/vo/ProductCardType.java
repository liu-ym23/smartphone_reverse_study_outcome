package com.bytedance.android.ec.store.repository.vo;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/ProductCardType;", "", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOW", "GOODS_LIST", "GUESS_YOU_LIKE", "CROSS_SHOP_GOTO_SHOP", "CROSS_SHOP_GOTO_DETAIL", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProductCardType extends Enum<ProductCardType> {
    public static final ProductCardType CROSS_SHOP_GOTO_DETAIL = null;
    public static final ProductCardType CROSS_SHOP_GOTO_SHOP = null;
    public static final a Companion = null;
    public static final ProductCardType GOODS_LIST = null;
    public static final ProductCardType GUESS_YOU_LIKE = null;
    public static final ProductCardType UNKNOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProductCardType[] f48400a = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        ProductCardType r100 = new ProductCardType("UNKNOW", 0, -1);
        UNKNOW = r100;
        ProductCardType r101 = new ProductCardType("GOODS_LIST", 1, 0);
        GOODS_LIST = r101;
        ProductCardType r102 = new ProductCardType("GUESS_YOU_LIKE", 2, 1);
        GUESS_YOU_LIKE = r102;
        ProductCardType r103 = new ProductCardType("CROSS_SHOP_GOTO_SHOP", 3, 2);
        CROSS_SHOP_GOTO_SHOP = r103;
        ProductCardType r104 = new ProductCardType("CROSS_SHOP_GOTO_DETAIL", 4, 3);
        CROSS_SHOP_GOTO_DETAIL = r104;
        f48400a = new ProductCardType[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static ProductCardType valueOf(String r100) {
        return (ProductCardType) r27.a.a(ProductCardType.class, r100);
    }

    public static ProductCardType[] values() {
        return (ProductCardType[]) f48400a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ProductCardType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
