package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductQAStruct;", "Ljava/io/Serializable;", "totalCount", "", "questions", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductQuestionStruct;", "jumpUrl", "", "(JLjava/util/List;Ljava/lang/String;)V", "getJumpUrl", "()Ljava/lang/String;", "getQuestions", "()Ljava/util/List;", "getTotalCount", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductQAStruct implements Serializable {

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("questions")
    private final List<PromotionProductQuestionStruct> questions;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    private final long totalCount;

    public PromotionProductQAStruct() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionProductQAStruct copy$default(PromotionProductQAStruct r100, long r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.totalCount;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.questions;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.jumpUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final long component1() {
        return this.totalCount;
    }

    public final List<PromotionProductQuestionStruct> component2() {
        return this.questions;
    }

    public final String component3() {
        return this.jumpUrl;
    }

    public final PromotionProductQAStruct copy(long r100, List<PromotionProductQuestionStruct> r101, String r102) {
        return new PromotionProductQAStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionProductQAStruct) == false) goto L12;
        PromotionProductQAStruct r101 = (PromotionProductQAStruct) r100;
        if (this.totalCount == r101.totalCount) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.questions, r101.questions) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        long r100 = this.totalCount;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<PromotionProductQuestionStruct> r102 = this.questions;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.jumpUrl;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return r105 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "PromotionProductQAStruct(totalCount=" + this.totalCount + ", questions=" + this.questions + ", jumpUrl=" + this.jumpUrl + ")";
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final List<PromotionProductQuestionStruct> getQuestions() {
        return this.questions;
    }

    public final long getTotalCount() {
        return this.totalCount;
    }

    public PromotionProductQAStruct(long r100, List<PromotionProductQuestionStruct> r101, String r102) {
        this.totalCount = r100;
        this.questions = r101;
        this.jumpUrl = r102;
    }

    public /* synthetic */ PromotionProductQAStruct(long r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
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
