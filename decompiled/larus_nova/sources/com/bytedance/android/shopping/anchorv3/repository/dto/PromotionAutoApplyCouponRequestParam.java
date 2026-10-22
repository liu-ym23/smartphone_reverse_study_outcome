package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionAutoApplyCouponRequestParam;", "Ljava/io/Serializable;", "productId", "", "shopId", "price", "", "marketChannel", "authorId", "secAuthorId", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAuthorId", "()Ljava/lang/String;", "getChannelId", "getChannelType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMarketChannel", "getPrice", "()J", "getProductId", "getSecAuthorId", "getShopId", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionAutoApplyCouponRequestParam implements Serializable {
    private final String authorId;
    private final String channelId;
    private final Integer channelType;
    private final String marketChannel;
    private final long price;
    private final String productId;
    private final String secAuthorId;
    private final String shopId;

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
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

    public PromotionAutoApplyCouponRequestParam(String r100, String r101, long r102, String r103, String r104, String r105, String r106, Integer r110) {
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
        this.channelId = r106;
        this.channelType = r110;
    }

    public /* synthetic */ PromotionAutoApplyCouponRequestParam(String r110, String r111, long r112, String r113, String r114, String r210, String r211, Integer r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 64) == 0) goto L5;
        String r115 = null;
    L7:
        if ((r213 & 128) == 0) goto L9;
        Integer r116 = null;
    L10:
        this(r110, r111, r112, r113, r114, r210, r115, r116);
        return;
    L9:
        r116 = r212;
        goto L10
    L5:
        r115 = r211;
        goto L7
    }
}
