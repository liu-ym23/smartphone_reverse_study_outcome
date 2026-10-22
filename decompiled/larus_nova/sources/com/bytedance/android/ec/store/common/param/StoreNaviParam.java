package com.bytedance.android.ec.store.common.param;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/store/common/param/StoreNaviParam;", "Ljava/io/Serializable;", "()V", "productShopEntry", "", "getProductShopEntry", "()Z", "setProductShopEntry", "(Z)V", "shopProductCount", "", "getShopProductCount", "()Ljava/lang/Integer;", "setShopProductCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "shopUrl", "", "getShopUrl", "()Ljava/lang/String;", "setShopUrl", "(Ljava/lang/String;)V", "sourceProductId", "getSourceProductId", "setSourceProductId", "copyFrom", "", "other", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreNaviParam implements Serializable {
    private boolean productShopEntry;
    private Integer shopProductCount;
    private String shopUrl;
    private String sourceProductId;

    public StoreNaviParam() {
    }

    public final boolean getProductShopEntry() {
        return this.productShopEntry;
    }

    public final Integer getShopProductCount() {
        return this.shopProductCount;
    }

    public final String getShopUrl() {
        return this.shopUrl;
    }

    public final String getSourceProductId() {
        return this.sourceProductId;
    }

    public final void copyFrom(StoreNaviParam r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        this.sourceProductId = r100.sourceProductId;
        this.productShopEntry = r100.productShopEntry;
        this.shopProductCount = r100.shopProductCount;
        this.shopUrl = r100.shopUrl;
    }

    public final void setProductShopEntry(boolean r100) {
        this.productShopEntry = r100;
    }

    public final void setShopProductCount(Integer r100) {
        this.shopProductCount = r100;
    }

    public final void setShopUrl(String r100) {
        this.shopUrl = r100;
    }

    public final void setSourceProductId(String r100) {
        this.sourceProductId = r100;
    }
}
