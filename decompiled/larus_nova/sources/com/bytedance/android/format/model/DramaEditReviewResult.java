package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/format/model/DramaEditReviewResult;", "Ljava/io/Serializable;", "()V", "chapterReviewList", "", "Lcom/bytedance/android/format/model/ReviewResult;", "getChapterReviewList", "()Ljava/util/List;", "setChapterReviewList", "(Ljava/util/List;)V", "isPass", "", "()Ljava/lang/Boolean;", "setPass", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "openReview", "getOpenReview", "()Lcom/bytedance/android/format/model/ReviewResult;", "setOpenReview", "(Lcom/bytedance/android/format/model/ReviewResult;)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DramaEditReviewResult implements Serializable {

    @SerializedName("chapter_review_list")
    private List<ReviewResult> chapterReviewList;

    @SerializedName("isPass")
    private Boolean isPass;

    @SerializedName("open")
    private ReviewResult openReview;

    public DramaEditReviewResult() {
    }

    public final List<ReviewResult> getChapterReviewList() {
        return this.chapterReviewList;
    }

    public final ReviewResult getOpenReview() {
        return this.openReview;
    }

    public final Boolean isPass() {
        return this.isPass;
    }

    public final void setChapterReviewList(List<ReviewResult> r100) {
        this.chapterReviewList = r100;
    }

    public final void setOpenReview(ReviewResult r100) {
        this.openReview = r100;
    }

    public final void setPass(Boolean r100) {
        this.isPass = r100;
    }
}
