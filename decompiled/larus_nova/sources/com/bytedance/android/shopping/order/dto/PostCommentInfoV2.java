package com.bytedance.android.shopping.order.dto;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\b/\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\"\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\"\u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\"\u0010/\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR\"\u00102\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR\"\u00104\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b4\u0010(\"\u0004\b5\u0010*R\"\u00106\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b6\u0010(\"\u0004\b7\u0010*R \u00108\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0013\"\u0004\b:\u0010\u0015R,\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R \u0010A\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0013\"\u0004\bC\u0010\u0015R \u0010D\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0013\"\u0004\bF\u0010\u0015R,\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010>\"\u0004\bI\u0010@R&\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0007\"\u0004\bL\u0010\tR \u0010M\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0013\"\u0004\bO\u0010\u0015R&\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0007\"\u0004\bR\u0010\tR\"\u0010S\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bT\u0010\r\"\u0004\bU\u0010\u000fR\"\u0010V\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bW\u0010\r\"\u0004\bX\u0010\u000fR\"\u0010Y\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bZ\u0010\r\"\u0004\b[\u0010\u000fR \u0010\\\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0013\"\u0004\b^\u0010\u0015R,\u0010_\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010>\"\u0004\ba\u0010@R,\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010>\"\u0004\bd\u0010@R&\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0007\"\u0004\bg\u0010\tR\"\u0010h\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bi\u0010\r\"\u0004\bj\u0010\u000f¨\u0006k"}, d2 = {"Lcom/bytedance/android/shopping/order/dto/PostCommentInfoV2;", "Ljava/io/Serializable;", "()V", "awemeVideos", "", "", "getAwemeVideos", "()Ljava/util/List;", "setAwemeVideos", "(Ljava/util/List;)V", "commentType", "", "getCommentType", "()Ljava/lang/Long;", "setCommentType", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "content", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "contentCount", "getContentCount", "setContentCount", "customChoice", "Lcom/bytedance/android/shopping/order/dto/CustomChoice;", "getCustomChoice", "()Lcom/bytedance/android/shopping/order/dto/CustomChoice;", "setCustomChoice", "(Lcom/bytedance/android/shopping/order/dto/CustomChoice;)V", "emotionalJudgeRank", "getEmotionalJudgeRank", "setEmotionalJudgeRank", "emotionalJudgeScore", "getEmotionalJudgeScore", "setEmotionalJudgeScore", "fromReasonSelect", "", "getFromReasonSelect", "()Ljava/lang/Boolean;", "setFromReasonSelect", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "hintsTags", "getHintsTags", "setHintsTags", "hintsType", "getHintsType", "setHintsType", "isAnonymous", "setAnonymous", "isAsyncMotivate", "setAsyncMotivate", "isShowOrder", "setShowOrder", "logMap", "getLogMap", "setLogMap", "musics", "", "getMusics", "()Ljava/util/Map;", "setMusics", "(Ljava/util/Map;)V", "orderId", "getOrderId", "setOrderId", "parentId", "getParentId", "setParentId", "photoUris", "getPhotoUris", "setPhotoUris", "photos", "getPhotos", "setPhotos", "productId", "getProductId", "setProductId", "productImg", "getProductImg", "setProductImg", "rankGood", "getRankGood", "setRankGood", "rankLogistic", "getRankLogistic", "setRankLogistic", "rankShop", "getRankShop", "setRankShop", "showOrderActivityStatus", "getShowOrderActivityStatus", "setShowOrderActivityStatus", "useAiFeature", "getUseAiFeature", "setUseAiFeature", "useFeature", "getUseFeature", "setUseFeature", "videos", "getVideos", "setVideos", "writeNum", "getWriteNum", "setWriteNum", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PostCommentInfoV2 implements Serializable {

    @SerializedName("aweme_videos")
    private List<String> awemeVideos;

    @SerializedName(a.KEY_COMMENT_TYPE)
    private Long commentType;

    @SerializedName("content")
    private String content;

    @SerializedName("content_count")
    private Long contentCount;

    @SerializedName("custom_choice")
    private CustomChoice customChoice;

    @SerializedName("emotional_judge_rank")
    private Long emotionalJudgeRank;

    @SerializedName("emotional_judge_score")
    private Long emotionalJudgeScore;

    @SerializedName("from_reason_select")
    private Boolean fromReasonSelect;

    @SerializedName("hints_tags")
    private String hintsTags;

    @SerializedName("hints_type")
    private Long hintsType;

    @SerializedName("anonymous")
    private Long isAnonymous;

    @SerializedName("is_async_motivate")
    private Boolean isAsyncMotivate;

    @SerializedName("is_show_order")
    private Boolean isShowOrder;

    @SerializedName("log_map")
    private String logMap;

    @SerializedName("musics")
    private Map<String, String> musics;

    @SerializedName("order_id")
    private String orderId;

    @SerializedName("parent_id")
    private String parentId;

    @SerializedName("photo_uris")
    private Map<String, String> photoUris;

    @SerializedName("photos")
    private List<String> photos;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("product_img")
    private List<String> productImg;

    @SerializedName("rank_good")
    private Long rankGood;

    @SerializedName("rank_logistic")
    private Long rankLogistic;

    @SerializedName("rank_shop")
    private Long rankShop;

    @SerializedName("show_order_activity_status")
    private String showOrderActivityStatus;

    @SerializedName("use_ai_feature")
    private Map<String, String> useAiFeature;

    @SerializedName("use_feature")
    private Map<String, String> useFeature;

    @SerializedName("videos")
    private List<String> videos;

    @SerializedName("write_num")
    private Long writeNum;

    public PostCommentInfoV2() {
        this.fromReasonSelect = Boolean.FALSE;
    }

    public final List<String> getAwemeVideos() {
        return this.awemeVideos;
    }

    public final Long getCommentType() {
        return this.commentType;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getContentCount() {
        return this.contentCount;
    }

    public final CustomChoice getCustomChoice() {
        return this.customChoice;
    }

    public final Long getEmotionalJudgeRank() {
        return this.emotionalJudgeRank;
    }

    public final Long getEmotionalJudgeScore() {
        return this.emotionalJudgeScore;
    }

    public final Boolean getFromReasonSelect() {
        return this.fromReasonSelect;
    }

    public final String getHintsTags() {
        return this.hintsTags;
    }

    public final Long getHintsType() {
        return this.hintsType;
    }

    public final String getLogMap() {
        return this.logMap;
    }

    public final Map<String, String> getMusics() {
        return this.musics;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final Map<String, String> getPhotoUris() {
        return this.photoUris;
    }

    public final List<String> getPhotos() {
        return this.photos;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final List<String> getProductImg() {
        return this.productImg;
    }

    public final Long getRankGood() {
        return this.rankGood;
    }

    public final Long getRankLogistic() {
        return this.rankLogistic;
    }

    public final Long getRankShop() {
        return this.rankShop;
    }

    public final String getShowOrderActivityStatus() {
        return this.showOrderActivityStatus;
    }

    public final Map<String, String> getUseAiFeature() {
        return this.useAiFeature;
    }

    public final Map<String, String> getUseFeature() {
        return this.useFeature;
    }

    public final List<String> getVideos() {
        return this.videos;
    }

    public final Long getWriteNum() {
        return this.writeNum;
    }

    public final Long isAnonymous() {
        return this.isAnonymous;
    }

    public final Boolean isAsyncMotivate() {
        return this.isAsyncMotivate;
    }

    public final Boolean isShowOrder() {
        return this.isShowOrder;
    }

    public final void setAnonymous(Long r100) {
        this.isAnonymous = r100;
    }

    public final void setAsyncMotivate(Boolean r100) {
        this.isAsyncMotivate = r100;
    }

    public final void setAwemeVideos(List<String> r100) {
        this.awemeVideos = r100;
    }

    public final void setCommentType(Long r100) {
        this.commentType = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setContentCount(Long r100) {
        this.contentCount = r100;
    }

    public final void setCustomChoice(CustomChoice r100) {
        this.customChoice = r100;
    }

    public final void setEmotionalJudgeRank(Long r100) {
        this.emotionalJudgeRank = r100;
    }

    public final void setEmotionalJudgeScore(Long r100) {
        this.emotionalJudgeScore = r100;
    }

    public final void setFromReasonSelect(Boolean r100) {
        this.fromReasonSelect = r100;
    }

    public final void setHintsTags(String r100) {
        this.hintsTags = r100;
    }

    public final void setHintsType(Long r100) {
        this.hintsType = r100;
    }

    public final void setLogMap(String r100) {
        this.logMap = r100;
    }

    public final void setMusics(Map<String, String> r100) {
        this.musics = r100;
    }

    public final void setOrderId(String r100) {
        this.orderId = r100;
    }

    public final void setParentId(String r100) {
        this.parentId = r100;
    }

    public final void setPhotoUris(Map<String, String> r100) {
        this.photoUris = r100;
    }

    public final void setPhotos(List<String> r100) {
        this.photos = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setProductImg(List<String> r100) {
        this.productImg = r100;
    }

    public final void setRankGood(Long r100) {
        this.rankGood = r100;
    }

    public final void setRankLogistic(Long r100) {
        this.rankLogistic = r100;
    }

    public final void setRankShop(Long r100) {
        this.rankShop = r100;
    }

    public final void setShowOrder(Boolean r100) {
        this.isShowOrder = r100;
    }

    public final void setShowOrderActivityStatus(String r100) {
        this.showOrderActivityStatus = r100;
    }

    public final void setUseAiFeature(Map<String, String> r100) {
        this.useAiFeature = r100;
    }

    public final void setUseFeature(Map<String, String> r100) {
        this.useFeature = r100;
    }

    public final void setVideos(List<String> r100) {
        this.videos = r100;
    }

    public final void setWriteNum(Long r100) {
        this.writeNum = r100;
    }
}
