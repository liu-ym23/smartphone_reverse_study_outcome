package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/format/model/GetAiPlayDramaGenerateResultResponseData;", "Ljava/io/Serializable;", "()V", "dramaEditReviewResult", "Lcom/bytedance/android/format/model/DramaEditReviewResult;", "getDramaEditReviewResult", "()Lcom/bytedance/android/format/model/DramaEditReviewResult;", "setDramaEditReviewResult", "(Lcom/bytedance/android/format/model/DramaEditReviewResult;)V", "playId", "", "getPlayId", "()Ljava/lang/String;", "setPlayId", "(Ljava/lang/String;)V", "status", "", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "waitTimeSecs", "getWaitTimeSecs", "setWaitTimeSecs", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetAiPlayDramaGenerateResultResponseData implements Serializable {

    @SerializedName("drama_edit_review_result")
    private DramaEditReviewResult dramaEditReviewResult;
    private String playId;

    @SerializedName("drama_edit_status")
    private Integer status;

    @SerializedName("next_req_wait_time_s")
    private Integer waitTimeSecs;

    public GetAiPlayDramaGenerateResultResponseData() {
        this.waitTimeSecs = 2;
    }

    public final DramaEditReviewResult getDramaEditReviewResult() {
        return this.dramaEditReviewResult;
    }

    public final String getPlayId() {
        return this.playId;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Integer getWaitTimeSecs() {
        return this.waitTimeSecs;
    }

    public final void setDramaEditReviewResult(DramaEditReviewResult r100) {
        this.dramaEditReviewResult = r100;
    }

    public final void setPlayId(String r100) {
        this.playId = r100;
    }

    public final void setStatus(Integer r100) {
        this.status = r100;
    }

    public final void setWaitTimeSecs(Integer r100) {
        this.waitTimeSecs = r100;
    }
}
