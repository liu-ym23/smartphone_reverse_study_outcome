package com.bytedance.android.shopping.feed.repository.dto;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/PromotionAutoApplyCouponRequestParam;", "Ljava/io/Serializable;", "productId", "", "shopId", "price", "", "marketChannel", "authorId", "secAuthorId", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorId", "()Ljava/lang/String;", "getMarketChannel", "getPrice", "()J", "getProductId", "getSecAuthorId", "getShopId", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionAutoApplyCouponRequestParam implements Serializable {
    private final String authorId;
    private final String marketChannel;
    private final long price;
    private final String productId;
    private final String secAuthorId;
    private final String shopId;

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getMarketChannel() {
        return this.marketChannel;
    }

    public final long getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public PromotionAutoApplyCouponRequestParam(String r100, String r101, long r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, "shopId");
        Intrinsics.checkNotNullParameter(r103, "marketChannel");
        Intrinsics.checkNotNullParameter(r104, "authorId");
        Intrinsics.checkNotNullParameter(r105, "secAuthorId");
        this.productId = r100;
        this.shopId = r101;
        this.price = r102;
        this.marketChannel = r103;
        this.authorId = r104;
        this.secAuthorId = r105;
    }
}
