package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductQuestionStruct;", "Ljava/io/Serializable;", "questionId", "", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "jumpUrl", "", "questionContent", "answerCount", "(JLcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;J)V", "getAnswerCount", "()J", "getImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getJumpUrl", "()Ljava/lang/String;", "getQuestionContent", "getQuestionId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductQuestionStruct implements Serializable {

    @SerializedName("answer_count")
    private final long answerCount;

    @SerializedName("image")
    private final ECUrlModel image;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("question_content")
    private final String questionContent;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID)
    private final long questionId;

    public PromotionProductQuestionStruct() {
        this(0, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ PromotionProductQuestionStruct copy$default(PromotionProductQuestionStruct r100, long r101, ECUrlModel r110, String r111, String r112, long r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        long r102 = r100.questionId;
    L7:
        if ((r114 & 2) == 0) goto L9;
        ECUrlModel r103 = r100.image;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = r100.jumpUrl;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = r100.questionContent;
    L19:
        if ((r114 & 16) == 0) goto L21;
        long r106 = r100.answerCount;
    L23:
        return r100.copy(r102, r103, r104, r105, r106);
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public final long component1() {
        return this.questionId;
    }

    public final ECUrlModel component2() {
        return this.image;
    }

    public final String component3() {
        return this.jumpUrl;
    }

    public final String component4() {
        return this.questionContent;
    }

    public final long component5() {
        return this.answerCount;
    }

    public final PromotionProductQuestionStruct copy(long r110, ECUrlModel r111, String r112, String r113, long r114) {
        return new PromotionProductQuestionStruct(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionProductQuestionStruct) == false) goto L16;
        PromotionProductQuestionStruct r101 = (PromotionProductQuestionStruct) r100;
        if (this.questionId == r101.questionId) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.questionContent, r101.questionContent) == true) goto L14;
        return false;
    L14:
        if (this.answerCount == r101.answerCount) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        long r100 = this.questionId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        ECUrlModel r102 = this.image;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.jumpUrl;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.questionContent;
        if (r109 == null) goto L13;
        r103 = r109.hashCode();
    L13:
        int r110 = (r108 + r103) * 31;
        long r111 = this.answerCount;
        return r110 + ((int) (r111 ^ (r111 >>> 32)));
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "PromotionProductQuestionStruct(questionId=" + this.questionId + ", image=" + this.image + ", jumpUrl=" + this.jumpUrl + ", questionContent=" + this.questionContent + ", answerCount=" + this.answerCount + ")";
    }

    public final long getAnswerCount() {
        return this.answerCount;
    }

    public final ECUrlModel getImage() {
        return this.image;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getQuestionContent() {
        return this.questionContent;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    public PromotionProductQuestionStruct(long r100, ECUrlModel r101, String r102, String r103, long r104) {
        this.questionId = r100;
        this.image = r101;
        this.jumpUrl = r102;
        this.questionContent = r103;
        this.answerCount = r104;
    }

    public /* synthetic */ PromotionProductQuestionStruct(long r100, ECUrlModel r101, String r110, String r111, long r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        long r102 = 0;
    L7:
        if ((r113 & 2) == 0) goto L9;
        ECUrlModel r115 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r113 & 16) == 0) goto L21;
        long r116 = 0;
    L22:
        this(r102, r115, r103, r104, r116);
        return;
    L21:
        r116 = r112;
        goto L22
    L17:
        r104 = r111;
        goto L19
    L13:
        r103 = r110;
        goto L15
    L9:
        r115 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
