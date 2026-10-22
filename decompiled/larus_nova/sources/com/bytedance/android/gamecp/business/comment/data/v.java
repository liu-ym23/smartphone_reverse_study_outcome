package com.bytedance.android.gamecp.business.comment.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/v;", "", "", "gameId", "Ljava/lang/String;", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "D", "", "submitTime", "J", "evaluationId", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("evaluation_id")
    public String evaluationId;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    public double score;

    @SerializedName("submit_time")
    public long submitTime;

    public v() {
        this.gameId = "";
        this.evaluationId = "";
    }
}
