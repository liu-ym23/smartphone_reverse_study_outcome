package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/ProductRatio;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "ONERATIOONE", "FOURRATIONTHREE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProductRatio extends Enum<ProductRatio> {
    public static final ProductRatio FOURRATIONTHREE = null;
    public static final ProductRatio ONERATIOONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProductRatio[] f48401a = null;
    private final String type;

    static {
        ProductRatio r100 = new ProductRatio("ONERATIOONE", 0, "101");
        ONERATIOONE = r100;
        ProductRatio r101 = new ProductRatio("FOURRATIONTHREE", 1, BDLocationException.ERROR_UID_IS_EMPTY);
        FOURRATIONTHREE = r101;
        f48401a = new ProductRatio[]{r100, r101};
    }

    public static ProductRatio valueOf(String r100) {
        return (ProductRatio) r27.a.a(ProductRatio.class, r100);
    }

    public static ProductRatio[] values() {
        return (ProductRatio[]) f48401a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public ProductRatio(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
