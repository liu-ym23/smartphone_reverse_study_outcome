package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u001e\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u001e\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\u00108gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001a8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001a8gX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001cR\u0016\u0010#\u001a\u0004\u0018\u00010\u001a8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001cR\u0016\u0010%\u001a\u0004\u0018\u00010\u001a8gX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR\u0016\u0010'\u001a\u0004\u0018\u00010\u001a8gX¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001cR\u0016\u0010)\u001a\u0004\u0018\u00010\u001a8gX¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001cR\u0016\u0010+\u001a\u0004\u0018\u00010\u001a8gX¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001c¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/j;", "Lvh7/c;", "", "getStageId", "()J", "stageId", "", "getStageName", "()Ljava/lang/String;", "stageName", "getStageLowerLimitScore", "stageLowerLimitScore", "", "getStageLowerLimitScoreList", "()Ljava/util/List;", "stageLowerLimitScoreList", "", "getButtonStatus", "()I", "buttonStatus", "getStageCallDuration", "stageCallDuration", "getStageCallDurationList", "stageCallDurationList", "getStageType", "stageType", "Lpy/k;", "getProcessBarTrackImage", "()Lpy/k;", "processBarTrackImage", "getProcessBarImage", "processBarImage", "getProcessBarDotImage", "processBarDotImage", "getProcessBarHeaderImage", "processBarHeaderImage", "getProcessBarBubbleImage", "processBarBubbleImage", "getProcessBarBubbleHeaderImage", "processBarBubbleHeaderImage", "getStageBackgroundImage", "stageBackgroundImage", "getAvatarBgImage", "avatarBgImage", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j extends vh7.c<j> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "paired_user_avatar_bg")
    py.k getAvatarBgImage();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS)
    int getButtonStatus();

    @FieldName(name = "process_bar_bubble_header_image")
    py.k getProcessBarBubbleHeaderImage();

    @FieldName(name = "process_bar_bubble_image")
    py.k getProcessBarBubbleImage();

    @FieldName(name = "process_bar_dot_image")
    py.k getProcessBarDotImage();

    @FieldName(name = "process_bar_header_image")
    py.k getProcessBarHeaderImage();

    @FieldName(name = "process_bar_image")
    py.k getProcessBarImage();

    @FieldName(name = "process_bar_track_image")
    py.k getProcessBarTrackImage();

    @FieldName(name = "stage_background")
    py.k getStageBackgroundImage();

    @FieldName(name = "stage_call_duration")
    long getStageCallDuration();

    @FieldName(name = "stage_call_duration_list")
    List<Long> getStageCallDurationList();

    @FieldName(name = "stage_id")
    long getStageId();

    @FieldName(name = "stage_lower_limit_score")
    long getStageLowerLimitScore();

    @FieldName(name = "stage_lower_limit_score_list")
    List<Long> getStageLowerLimitScoreList();

    @FieldName(name = "stage_name")
    String getStageName();

    @FieldName(name = "stage_type")
    int getStageType();
}
