package com.bytedance.android.shopping.api.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;", "Ljava/io/Serializable;", "showInternalFeedProduct", "", "promotionLogId", "", "shopId", "(ZLjava/lang/String;Ljava/lang/String;)V", "getPromotionLogId", "()Ljava/lang/String;", "setPromotionLogId", "(Ljava/lang/String;)V", "getShopId", "getShowInternalFeedProduct", "()Z", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECAnchorV3ExtraData implements Serializable {
    private String promotionLogId;
    private final String shopId;
    private final boolean showInternalFeedProduct;

    public ECAnchorV3ExtraData() {
        this(false, null, null, 7, null);
    }

    public final String getPromotionLogId() {
        return this.promotionLogId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShowInternalFeedProduct() {
        return this.showInternalFeedProduct;
    }

    public final void setPromotionLogId(String r100) {
        this.promotionLogId = r100;
    }

    public ECAnchorV3ExtraData(boolean r100, String r101, String r102) {
        this.showInternalFeedProduct = r100;
        this.promotionLogId = r101;
        this.shopId = r102;
    }

    public /* synthetic */ ECAnchorV3ExtraData(boolean r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
