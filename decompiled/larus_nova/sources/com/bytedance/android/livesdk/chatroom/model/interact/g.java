package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/g;", "Lvh7/c;", "", "getPairId", "()J", "pairId", "", "getPairIdStr", "()Ljava/lang/String;", "pairIdStr", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k;", "getFromUser", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/k;", "fromUser", "getToUser", "toUser", "getScore", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getNextStageScore", "nextStageScore", "getStageId", "stageId", "Lcom/bytedance/android/livesdk/chatroom/model/interact/j;", "getStageInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/j;", "stageInfo", "", "getPairStatus", "()I", "pairStatus", "getCallStatus", "callStatus", "getCallerUserIdString", "callerUserIdString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g extends vh7.c<g> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "call_status")
    int getCallStatus();

    String getCallerUserIdString();

    @FieldName(name = "from_user")
    k getFromUser();

    @FieldName(name = "next_stage_score")
    long getNextStageScore();

    @FieldName(name = "pair_id")
    long getPairId();

    @FieldName(name = "pair_id_str")
    String getPairIdStr();

    @FieldName(name = "pair_status")
    int getPairStatus();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_SCORE)
    long getScore();

    @FieldName(name = "stage_id")
    long getStageId();

    @FieldName(name = "stage_info")
    j getStageInfo();

    @FieldName(name = "to_user")
    k getToUser();
}
