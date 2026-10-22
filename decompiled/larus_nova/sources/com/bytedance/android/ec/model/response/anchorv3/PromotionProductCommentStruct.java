package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b$\u0010\u0016R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\fR\u0018\u0010(\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0010R\u001a\u0010*\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b-\u0010\u0016R\u001a\u0010.\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b/\u0010\u0016R\u001a\u00100\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b1\u0010\u0016R\u001a\u00102\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b3\u0010\u0016R\u001a\u00104\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b5\u0010\u001bR\u0018\u00106\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0010R\u0018\u00108\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0010R\u001e\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\fR\u0018\u0010=\u001a\u0004\u0018\u00010>8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u001a\u0010A\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\bB\u0010\u0016R\u0018\u0010C\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0010R\u001a\u0010E\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\bF\u0010\u0016R\u001e\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\f¨\u0006J"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentStruct;", "Ljava/io/Serializable;", "()V", "appId", "", "getAppId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "appends", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentAppendStruct;", "getAppends", "()Ljava/util/List;", "commentTime", "", "getCommentTime", "()Ljava/lang/String;", "content", "getContent", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "liked", "", "getLiked", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "likes", "getLikes", "orderId", "getOrderId", "origContent", "getOrigContent", "parentId", "getParentId", "photos", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentPhotoStruct;", "getPhotos", "posterUrl", "getPosterUrl", "productId", "getProductId", "rank", "getRank", "rankLogistic", "getRankLogistic", "rankProduct", "getRankProduct", "rankShop", "getRankShop", "recommend", "getRecommend", "shopReply", "getShopReply", ECPromotion.SKU, "getSku", PromotionProductPrivilegesStruct.TAGS, "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentTagsStruct;", "getTags", "userAvatar", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getUserAvatar", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "userId", "getUserId", "userName", "getUserName", "userType", "getUserType", "videos", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;", "getVideos", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductCommentStruct implements Serializable {

    @SerializedName("app_id")
    private final Integer appId;

    @SerializedName("appends")
    private final List<PromotionProductCommentAppendStruct> appends;

    @SerializedName("comment_time")
    private final String commentTime;

    @SerializedName("content")
    private final String content;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final Long f47939id;

    @SerializedName("liked")
    private final Boolean liked;

    @SerializedName("likes")
    private final Long likes;

    @SerializedName("order_id")
    private final Long orderId;

    @SerializedName("orig_content")
    private final String origContent;

    @SerializedName("parent_id")
    private final Long parentId;

    @SerializedName("photos")
    private final List<PromotionProductCommentPhotoStruct> photos;

    @SerializedName("poster_url")
    private final String posterUrl;

    @SerializedName("product_id")
    private final Long productId;

    @SerializedName("rank")
    private final Long rank;

    @SerializedName("rank_logistic")
    private final Long rankLogistic;

    @SerializedName("rank_product")
    private final Long rankProduct;

    @SerializedName("rank_shop")
    private final Long rankShop;

    @SerializedName("recommend")
    private final Boolean recommend;

    @SerializedName("shop_reply")
    private final String shopReply;

    @SerializedName(ECPromotion.SKU)
    private final String sku;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<PromotionProductCommentTagsStruct> tags;

    @SerializedName("user_avatar")
    private final ECUrlModel userAvatar;

    @SerializedName("user_id")
    private final Long userId;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final String userName;

    @SerializedName("user_type")
    private final Long userType;

    @SerializedName("videos")
    private final List<PromotionVideoInfo> videos;

    public PromotionProductCommentStruct() {
    }

    public final Integer getAppId() {
        return this.appId;
    }

    public final List<PromotionProductCommentAppendStruct> getAppends() {
        return this.appends;
    }

    public final String getCommentTime() {
        return this.commentTime;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getId() {
        return this.f47939id;
    }

    public final Boolean getLiked() {
        return this.liked;
    }

    public final Long getLikes() {
        return this.likes;
    }

    public final Long getOrderId() {
        return this.orderId;
    }

    public final String getOrigContent() {
        return this.origContent;
    }

    public final Long getParentId() {
        return this.parentId;
    }

    public final List<PromotionProductCommentPhotoStruct> getPhotos() {
        return this.photos;
    }

    public final String getPosterUrl() {
        return this.posterUrl;
    }

    public final Long getProductId() {
        return this.productId;
    }

    public final Long getRank() {
        return this.rank;
    }

    public final Long getRankLogistic() {
        return this.rankLogistic;
    }

    public final Long getRankProduct() {
        return this.rankProduct;
    }

    public final Long getRankShop() {
        return this.rankShop;
    }

    public final Boolean getRecommend() {
        return this.recommend;
    }

    public final String getShopReply() {
        return this.shopReply;
    }

    public final String getSku() {
        return this.sku;
    }

    public final List<PromotionProductCommentTagsStruct> getTags() {
        return this.tags;
    }

    public final ECUrlModel getUserAvatar() {
        return this.userAvatar;
    }

    public final Long getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final Long getUserType() {
        return this.userType;
    }

    public final List<PromotionVideoInfo> getVideos() {
        return this.videos;
    }
}
