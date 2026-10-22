package com.bytedance.android.shopping.anchorv3.commentv2.api;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.LynxCellData;
import com.bytedance.android.ec.model.response.NoticePopUp;
import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductSkuStruct;
import com.bytedance.android.ec.model.response.c0;
import com.bytedance.android.ec.model.response.f1;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bj\u0010kR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR*\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000b\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010O\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010J\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR0\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010R8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Y\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010\u000b\u001a\u0004\bZ\u0010\r\"\u0004\b[\u0010\u000fR$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010d\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010i¨\u0006l"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/api/CommentResponse;", "Ljava/io/Serializable;", "", "statusCode", "I", "getStatusCode", "()I", "setStatusCode", "(I)V", "", a.KEY_STATUS_MSG, "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "setStatusMsg", "(Ljava/lang/String;)V", "Lcom/bytedance/android/shopping/anchorv3/commentv2/api/SliceCellData;", "tabInfo", "Lcom/bytedance/android/shopping/anchorv3/commentv2/api/SliceCellData;", "getTabInfo", "()Lcom/bytedance/android/shopping/anchorv3/commentv2/api/SliceCellData;", "setTabInfo", "(Lcom/bytedance/android/shopping/anchorv3/commentv2/api/SliceCellData;)V", "", "Lcom/bytedance/android/ec/model/response/c0;", "extendTags", "Ljava/util/List;", "getExtendTags", "()Ljava/util/List;", "setExtendTags", "(Ljava/util/List;)V", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductSkuStruct;", "skuInfo", "getSkuInfo", "setSkuInfo", "productName", "getProductName", "setProductName", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentDTO;", "comments", "getComments", "setComments", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "noticeDesc", "getNoticeDesc", "setNoticeDesc", "noticePosition", "Ljava/lang/Integer;", "getNoticePosition", "()Ljava/lang/Integer;", "setNoticePosition", "(Ljava/lang/Integer;)V", "", "totalCount", "J", "getTotalCount", "()J", "setTotalCount", "(J)V", "Lcom/bytedance/android/ec/model/response/f1;", "surveyV2", "Lcom/bytedance/android/ec/model/response/f1;", "getSurveyV2", "()Lcom/bytedance/android/ec/model/response/f1;", "setSurveyV2", "(Lcom/bytedance/android/ec/model/response/f1;)V", "Lcom/bytedance/android/ec/model/response/LynxCellData;", "commentAiSummaryData", "Lcom/bytedance/android/ec/model/response/LynxCellData;", "getCommentAiSummaryData", "()Lcom/bytedance/android/ec/model/response/LynxCellData;", "setCommentAiSummaryData", "(Lcom/bytedance/android/ec/model/response/LynxCellData;)V", "commentNpsData", "getCommentNpsData", "setCommentNpsData", "", "extraInfo", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "setExtraInfo", "(Ljava/util/Map;)V", "shopSlogan", "getShopSlogan", "setShopSlogan", "Lcom/bytedance/android/ec/model/response/NoticePopUp;", "noticePopUp", "Lcom/bytedance/android/ec/model/response/NoticePopUp;", "getNoticePopUp", "()Lcom/bytedance/android/ec/model/response/NoticePopUp;", "setNoticePopUp", "(Lcom/bytedance/android/ec/model/response/NoticePopUp;)V", "Lcom/bytedance/android/shopping/anchorv3/commentv2/api/ToastData;", "toastData", "Lcom/bytedance/android/shopping/anchorv3/commentv2/api/ToastData;", "getToastData", "()Lcom/bytedance/android/shopping/anchorv3/commentv2/api/ToastData;", "setToastData", "(Lcom/bytedance/android/shopping/anchorv3/commentv2/api/ToastData;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentResponse implements Serializable {

    @SerializedName("ai_info")
    private LynxCellData commentAiSummaryData;

    @SerializedName("nps_info")
    private LynxCellData commentNpsData;

    @SerializedName("comments")
    private List<PromotionProductCommentDTO> comments;

    @SerializedName("extend_tags")
    private List<c0> extendTags;

    @SerializedName("extraInfo")
    private Map<String, String> extraInfo;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("notice_desc")
    private String noticeDesc;

    @SerializedName("notice_pop_up")
    private NoticePopUp noticePopUp;

    @SerializedName("notice_position")
    private Integer noticePosition;

    @SerializedName("product_name")
    private String productName;

    @SerializedName("slogan")
    private String shopSlogan;

    @SerializedName("sku_info")
    private List<PromotionProductSkuStruct> skuInfo;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("status_msg")
    private String statusMsg;

    @SerializedName("survey_v2")
    private f1 surveyV2;

    @SerializedName("tab_info")
    private SliceCellData tabInfo;

    @SerializedName("toast_data")
    private ToastData toastData;

    @SerializedName(a.KEY_TOTAL_COUNT)
    private long totalCount;

    public CommentResponse() {
    }

    public final LynxCellData getCommentAiSummaryData() {
        return this.commentAiSummaryData;
    }

    public final LynxCellData getCommentNpsData() {
        return this.commentNpsData;
    }

    public final List<PromotionProductCommentDTO> getComments() {
        return this.comments;
    }

    public final List<c0> getExtendTags() {
        return this.extendTags;
    }

    public final Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNoticeDesc() {
        return this.noticeDesc;
    }

    public final NoticePopUp getNoticePopUp() {
        return this.noticePopUp;
    }

    public final Integer getNoticePosition() {
        return this.noticePosition;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final String getShopSlogan() {
        return this.shopSlogan;
    }

    public final List<PromotionProductSkuStruct> getSkuInfo() {
        return this.skuInfo;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final f1 getSurveyV2() {
        return this.surveyV2;
    }

    public final SliceCellData getTabInfo() {
        return this.tabInfo;
    }

    public final ToastData getToastData() {
        return this.toastData;
    }

    public final long getTotalCount() {
        return this.totalCount;
    }

    public final void setCommentAiSummaryData(LynxCellData r100) {
        this.commentAiSummaryData = r100;
    }

    public final void setCommentNpsData(LynxCellData r100) {
        this.commentNpsData = r100;
    }

    public final void setComments(List<PromotionProductCommentDTO> r100) {
        this.comments = r100;
    }

    public final void setExtendTags(List<c0> r100) {
        this.extendTags = r100;
    }

    public final void setExtraInfo(Map<String, String> r100) {
        this.extraInfo = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setNoticeDesc(String r100) {
        this.noticeDesc = r100;
    }

    public final void setNoticePopUp(NoticePopUp r100) {
        this.noticePopUp = r100;
    }

    public final void setNoticePosition(Integer r100) {
        this.noticePosition = r100;
    }

    public final void setProductName(String r100) {
        this.productName = r100;
    }

    public final void setShopSlogan(String r100) {
        this.shopSlogan = r100;
    }

    public final void setSkuInfo(List<PromotionProductSkuStruct> r100) {
        this.skuInfo = r100;
    }

    public final void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public final void setStatusMsg(String r100) {
        this.statusMsg = r100;
    }

    public final void setSurveyV2(f1 r100) {
        this.surveyV2 = r100;
    }

    public final void setTabInfo(SliceCellData r100) {
        this.tabInfo = r100;
    }

    public final void setToastData(ToastData r100) {
        this.toastData = r100;
    }

    public final void setTotalCount(long r100) {
        this.totalCount = r100;
    }
}
