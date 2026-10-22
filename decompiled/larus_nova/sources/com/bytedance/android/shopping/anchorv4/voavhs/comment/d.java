package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001a\u0010(\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0012R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u0010+R\u001c\u00104\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b9\u00107R\u001c\u0010:\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/d;", "", "", "commentCount", "J", "c", "()J", "commentId", "d", "storeCommentCount", OfficeSDKRequestTag.KEY_NEW_USER, "buyerShowCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "", "buyerShowIdList", "Ljava/util/List;", "b", "()Ljava/util/List;", "commentTagSentiments", "h", "commentTagNum", "f", "commentTagRealNum", ce.f26391f, "commentTagName", "e", "commentTagsCount", RXScreenCaptureService.KEY_INDEX, "storeCommentTagSentiments", "r", "storeCommentTagNum", "p", "storeCommentTagRealNum", "q", "storeCommentTagName", "o", "storeCommentTagsCount", "s", "", "questionNum", "I", "m", "()I", "questionIdList", "l", "userCommentLevel", "Ljava/lang/Long;", "t", "()Ljava/lang/Long;", "kolAllVideoCnt", ce.f26395j, "videoGroupType", "Ljava/lang/String;", "u", "()Ljava/lang/String;", "productCommentModule", ce.f26396k, "withSameComment", "Ljava/lang/Integer;", BaseSwitches.V, "()Ljava/lang/Integer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("buyer_show_count")
    private final long buyerShowCount;

    @SerializedName("buyer_show_id_list")
    private final List<String> buyerShowIdList;

    @SerializedName("comment_count")
    private final long commentCount;

    @SerializedName("comment_id")
    private final long commentId;

    @SerializedName("comment_tag_name")
    private final List<String> commentTagName;

    @SerializedName("comment_tag_num")
    private final List<String> commentTagNum;

    @SerializedName("comment_tag_real_num")
    private final List<String> commentTagRealNum;

    @SerializedName("comment_tag_sentiments")
    private final List<String> commentTagSentiments;

    @SerializedName("comment_tags_count")
    private final long commentTagsCount;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_KOL_ALL_VIDEO_CNT)
    private final int kolAllVideoCnt;

    @SerializedName("product_comment_module")
    private final String productCommentModule;

    @SerializedName("question_id_list")
    private final List<Long> questionIdList;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_QUESTION_NUM)
    private final int questionNum;

    @SerializedName("store_comment_count")
    private final long storeCommentCount;

    @SerializedName("store_comment_tag_name")
    private final List<String> storeCommentTagName;

    @SerializedName("store_comment_tag_num")
    private final List<String> storeCommentTagNum;

    @SerializedName("store_comment_tag_real_num")
    private final List<String> storeCommentTagRealNum;

    @SerializedName("store_comment_tag_sentiments")
    private final List<String> storeCommentTagSentiments;

    @SerializedName("store_comment_tags_count")
    private final long storeCommentTagsCount;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK)
    private final Long userCommentLevel;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_VIDEO_GROUP_TYPE)
    private final String videoGroupType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_WITH_SAME_COMMENT)
    private final Integer withSameComment;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L50;
        d r101 = (d) r100;
        if (this.commentCount == r101.commentCount) goto L8;
        return false;
    L8:
        if (this.commentId == r101.commentId) goto L10;
        return false;
    L10:
        if (this.storeCommentCount == r101.storeCommentCount) goto L12;
        return false;
    L12:
        if (this.buyerShowCount == r101.buyerShowCount) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.buyerShowIdList, r101.buyerShowIdList) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.commentTagSentiments, r101.commentTagSentiments) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.commentTagNum, r101.commentTagNum) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.commentTagRealNum, r101.commentTagRealNum) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.commentTagName, r101.commentTagName) == true) goto L24;
        return false;
    L24:
        if (this.commentTagsCount == r101.commentTagsCount) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.storeCommentTagSentiments, r101.storeCommentTagSentiments) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.storeCommentTagNum, r101.storeCommentTagNum) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.storeCommentTagRealNum, r101.storeCommentTagRealNum) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.storeCommentTagName, r101.storeCommentTagName) == true) goto L34;
        return false;
    L34:
        if (this.storeCommentTagsCount == r101.storeCommentTagsCount) goto L36;
        return false;
    L36:
        if (this.questionNum == r101.questionNum) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.questionIdList, r101.questionIdList) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.userCommentLevel, r101.userCommentLevel) == true) goto L42;
        return false;
    L42:
        if (this.kolAllVideoCnt == r101.kolAllVideoCnt) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.videoGroupType, r101.videoGroupType) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.productCommentModule, r101.productCommentModule) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.withSameComment, r101.withSameComment) == true) goto L76;
        return false;
    L76:
        return true;
    L50:
        return false;
    }

    public final int hashCode() {
        long r100 = this.commentCount;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.commentId;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.storeCommentCount;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.buyerShowCount;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        List<String> r108 = this.buyerShowIdList;
        int r109 = 0;
        if (r108 == null) goto L5;
        int r110 = r108.hashCode();
    L6:
        int r111 = (r107 + r110) * 31;
        List<String> r112 = this.commentTagSentiments;
        if (r112 == null) goto L9;
        int r113 = r112.hashCode();
    L10:
        int r114 = (r111 + r113) * 31;
        List<String> r115 = this.commentTagNum;
        if (r115 == null) goto L13;
        int r116 = r115.hashCode();
    L14:
        int r117 = (r114 + r116) * 31;
        List<String> r118 = this.commentTagRealNum;
        if (r118 == null) goto L17;
        int r119 = r118.hashCode();
    L18:
        int r120 = (r117 + r119) * 31;
        List<String> r121 = this.commentTagName;
        if (r121 == null) goto L21;
        int r122 = r121.hashCode();
    L22:
        long r123 = this.commentTagsCount;
        int r124 = (((r120 + r122) * 31) + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        List<String> r125 = this.storeCommentTagSentiments;
        if (r125 == null) goto L25;
        int r126 = r125.hashCode();
    L26:
        int r127 = (r124 + r126) * 31;
        List<String> r128 = this.storeCommentTagNum;
        if (r128 == null) goto L29;
        int r129 = r128.hashCode();
    L30:
        int r130 = (r127 + r129) * 31;
        List<String> r131 = this.storeCommentTagRealNum;
        if (r131 == null) goto L33;
        int r132 = r131.hashCode();
    L34:
        int r133 = (r130 + r132) * 31;
        List<String> r134 = this.storeCommentTagName;
        if (r134 == null) goto L37;
        int r135 = r134.hashCode();
    L38:
        long r136 = this.storeCommentTagsCount;
        int r137 = (((((r133 + r135) * 31) + ((int) (r136 ^ (r136 >>> 32)))) * 31) + this.questionNum) * 31;
        List<Long> r138 = this.questionIdList;
        if (r138 == null) goto L41;
        int r139 = r138.hashCode();
    L42:
        int r140 = (r137 + r139) * 31;
        Long r141 = this.userCommentLevel;
        if (r141 == null) goto L45;
        int r142 = r141.hashCode();
    L46:
        int r143 = (((r140 + r142) * 31) + this.kolAllVideoCnt) * 31;
        String r144 = this.videoGroupType;
        if (r144 == null) goto L49;
        int r145 = r144.hashCode();
    L50:
        int r146 = (r143 + r145) * 31;
        String r147 = this.productCommentModule;
        if (r147 == null) goto L53;
        int r148 = r147.hashCode();
    L54:
        int r149 = (r146 + r148) * 31;
        Integer r150 = this.withSameComment;
        if (r150 == null) goto L58;
        r109 = r150.hashCode();
    L58:
        return r149 + r109;
    L53:
        r148 = 0;
        goto L54
    L49:
        r145 = 0;
        goto L50
    L45:
        r142 = 0;
        goto L46
    L41:
        r139 = 0;
        goto L42
    L37:
        r135 = 0;
        goto L38
    L33:
        r132 = 0;
        goto L34
    L29:
        r129 = 0;
        goto L30
    L25:
        r126 = 0;
        goto L26
    L21:
        r122 = 0;
        goto L22
    L17:
        r119 = 0;
        goto L18
    L13:
        r116 = 0;
        goto L14
    L9:
        r113 = 0;
        goto L10
    L5:
        r110 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4CommentTrackMeta(commentCount=" + this.commentCount + ", commentId=" + this.commentId + ", storeCommentCount=" + this.storeCommentCount + ", buyerShowCount=" + this.buyerShowCount + ", buyerShowIdList=" + this.buyerShowIdList + ", commentTagSentiments=" + this.commentTagSentiments + ", commentTagNum=" + this.commentTagNum + ", commentTagRealNum=" + this.commentTagRealNum + ", commentTagName=" + this.commentTagName + ", commentTagsCount=" + this.commentTagsCount + ", storeCommentTagSentiments=" + this.storeCommentTagSentiments + ", storeCommentTagNum=" + this.storeCommentTagNum + ", storeCommentTagRealNum=" + this.storeCommentTagRealNum + ", storeCommentTagName=" + this.storeCommentTagName + ", storeCommentTagsCount=" + this.storeCommentTagsCount + ", questionNum=" + this.questionNum + ", questionIdList=" + this.questionIdList + ", userCommentLevel=" + this.userCommentLevel + ", kolAllVideoCnt=" + this.kolAllVideoCnt + ", videoGroupType=" + this.videoGroupType + ", productCommentModule=" + this.productCommentModule + ", withSameComment=" + this.withSameComment + ")";
    }

    public d() {
        this.commentCount = 0;
        this.commentId = 0;
        this.storeCommentCount = 0;
        this.buyerShowCount = 0;
        this.buyerShowIdList = null;
        this.commentTagSentiments = null;
        this.commentTagNum = null;
        this.commentTagRealNum = null;
        this.commentTagName = null;
        this.commentTagsCount = 0;
        this.storeCommentTagSentiments = null;
        this.storeCommentTagNum = null;
        this.storeCommentTagRealNum = null;
        this.storeCommentTagName = null;
        this.storeCommentTagsCount = 0;
        this.questionNum = 0;
        this.questionIdList = null;
        this.userCommentLevel = null;
        this.kolAllVideoCnt = 0;
        this.videoGroupType = null;
        this.productCommentModule = null;
        this.withSameComment = null;
    }

    public final long a() {
        return this.buyerShowCount;
    }

    public final List<String> b() {
        return this.buyerShowIdList;
    }

    public final long c() {
        return this.commentCount;
    }

    public final long d() {
        return this.commentId;
    }

    public final List<String> e() {
        return this.commentTagName;
    }

    public final List<String> f() {
        return this.commentTagNum;
    }

    public final List<String> g() {
        return this.commentTagRealNum;
    }

    public final List<String> h() {
        return this.commentTagSentiments;
    }

    public final long i() {
        return this.commentTagsCount;
    }

    public final int j() {
        return this.kolAllVideoCnt;
    }

    public final String k() {
        return this.productCommentModule;
    }

    public final List<Long> l() {
        return this.questionIdList;
    }

    public final int m() {
        return this.questionNum;
    }

    public final long n() {
        return this.storeCommentCount;
    }

    public final List<String> o() {
        return this.storeCommentTagName;
    }

    public final List<String> p() {
        return this.storeCommentTagNum;
    }

    public final List<String> q() {
        return this.storeCommentTagRealNum;
    }

    public final List<String> r() {
        return this.storeCommentTagSentiments;
    }

    public final long s() {
        return this.storeCommentTagsCount;
    }

    public final Long t() {
        return this.userCommentLevel;
    }

    public final String u() {
        return this.videoGroupType;
    }

    public final Integer v() {
        return this.withSameComment;
    }
}
