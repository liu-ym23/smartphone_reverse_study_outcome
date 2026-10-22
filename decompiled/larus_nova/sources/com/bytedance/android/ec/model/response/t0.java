package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R(\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b4\u0010\u000bR\u001c\u00106\u001a\u0004\u0018\u0001058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u0001058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u00107\u001a\u0004\b;\u00109R$\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/bytedance/android/ec/model/response/t0;", "", "", "statusCode", "I", "getStatusCode", "()I", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentDTO;", "comments", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "hasMore", "Z", "c", "()Z", "noticeDesc", "e", "noticePosition", "Ljava/lang/Integer;", "getNoticePosition", "()Ljava/lang/Integer;", "", "totalCount", "J", "getTotalCount", "()J", "Lcom/bytedance/android/ec/model/response/f;", "extra", "Lcom/bytedance/android/ec/model/response/f;", "getExtra", "()Lcom/bytedance/android/ec/model/response/f;", "meanlessCount", "d", "Lcom/bytedance/android/ec/model/response/f1;", "surveyV2", "Lcom/bytedance/android/ec/model/response/f1;", "f", "()Lcom/bytedance/android/ec/model/response/f1;", "", "extraInfo", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "shopSlogan", "getShopSlogan", "Lcom/bytedance/android/ec/model/response/LynxCellData;", "commentAiSummaryData", "Lcom/bytedance/android/ec/model/response/LynxCellData;", "getCommentAiSummaryData", "()Lcom/bytedance/android/ec/model/response/LynxCellData;", "commentNpsData", "getCommentNpsData", "Lcom/bytedance/android/ec/model/response/NoticePopUp;", "noticePopUp", "Lcom/bytedance/android/ec/model/response/NoticePopUp;", "getNoticePopUp", "()Lcom/bytedance/android/ec/model/response/NoticePopUp;", "setNoticePopUp", "(Lcom/bytedance/android/ec/model/response/NoticePopUp;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class t0 {

    @SerializedName("ai_info")
    private final LynxCellData commentAiSummaryData;

    @SerializedName("nps_info")
    private final LynxCellData commentNpsData;

    @SerializedName("comments")
    private final List<PromotionProductCommentDTO> comments;

    @SerializedName("extra")
    private final f extra;

    @SerializedName("extraInfo")
    private final Map<String, String> extraInfo;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("meaningless_count")
    private final int meanlessCount;

    @SerializedName("notice_desc")
    private final String noticeDesc;

    @SerializedName("notice_pop_up")
    private NoticePopUp noticePopUp;

    @SerializedName("notice_position")
    private final Integer noticePosition;

    @SerializedName("slogan")
    private final String shopSlogan;

    @SerializedName("status_code")
    private final int statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    @SerializedName("survey_v2")
    private final f1 surveyV2;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    private final long totalCount;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t0) == false) goto L36;
        t0 r101 = (t0) r100;
        if (this.statusCode == r101.statusCode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.comments, r101.comments) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r101.hasMore) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.noticeDesc, r101.noticeDesc) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.noticePosition, r101.noticePosition) == true) goto L18;
        return false;
    L18:
        if (this.totalCount == r101.totalCount) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L22;
        return false;
    L22:
        if (this.meanlessCount == r101.meanlessCount) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.surveyV2, r101.surveyV2) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.shopSlogan, r101.shopSlogan) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.commentAiSummaryData, r101.commentAiSummaryData) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.commentNpsData, r101.commentNpsData) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.noticePopUp, r101.noticePopUp) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public final int hashCode() {
        int r100 = this.statusCode * 31;
        String r101 = this.statusMsg;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        List<PromotionProductCommentDTO> r105 = this.comments;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.hasMore;
        ?? r109 = r108;
        if (r108 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.noticeDesc;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.noticePosition;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        long r116 = this.totalCount;
        int r117 = (((r113 + r115) * 31) + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        f r118 = this.extra;
        if (r118 == null) goto L24;
        int r119 = r118.hashCode();
    L25:
        int r120 = (((r117 + r119) * 31) + this.meanlessCount) * 31;
        f1 r121 = this.surveyV2;
        if (r121 == null) goto L28;
        int r122 = r121.hashCode();
    L29:
        int r123 = (r120 + r122) * 31;
        Map<String, String> r124 = this.extraInfo;
        if (r124 == null) goto L32;
        int r125 = r124.hashCode();
    L33:
        int r126 = (r123 + r125) * 31;
        String r127 = this.shopSlogan;
        if (r127 == null) goto L36;
        int r128 = r127.hashCode();
    L37:
        int r129 = (r126 + r128) * 31;
        LynxCellData r130 = this.commentAiSummaryData;
        if (r130 == null) goto L40;
        int r131 = r130.hashCode();
    L41:
        int r132 = (r129 + r131) * 31;
        LynxCellData r133 = this.commentNpsData;
        if (r133 == null) goto L44;
        int r134 = r133.hashCode();
    L45:
        int r135 = (r132 + r134) * 31;
        NoticePopUp r136 = this.noticePopUp;
        if (r136 == null) goto L49;
        r102 = r136.hashCode();
    L49:
        return r135 + r102;
    L44:
        r134 = 0;
        goto L45
    L40:
        r131 = 0;
        goto L41
    L36:
        r128 = 0;
        goto L37
    L32:
        r125 = 0;
        goto L33
    L28:
        r122 = 0;
        goto L29
    L24:
        r119 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "PromotionCommentsDTO(statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", comments=" + this.comments + ", hasMore=" + this.hasMore + ", noticeDesc=" + this.noticeDesc + ", noticePosition=" + this.noticePosition + ", totalCount=" + this.totalCount + ", extra=" + this.extra + ", meanlessCount=" + this.meanlessCount + ", surveyV2=" + this.surveyV2 + ", extraInfo=" + this.extraInfo + ", shopSlogan=" + this.shopSlogan + ", commentAiSummaryData=" + this.commentAiSummaryData + ", commentNpsData=" + this.commentNpsData + ", noticePopUp=" + this.noticePopUp + ")";
    }

    public final List<PromotionProductCommentDTO> a() {
        return this.comments;
    }

    public final Map<String, String> b() {
        return this.extraInfo;
    }

    public final boolean c() {
        return this.hasMore;
    }

    public final int d() {
        return this.meanlessCount;
    }

    public final String e() {
        return this.noticeDesc;
    }

    public final f1 f() {
        return this.surveyV2;
    }
}
