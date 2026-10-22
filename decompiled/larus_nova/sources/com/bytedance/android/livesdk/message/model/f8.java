package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0014\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0012\u0010\u0005R\u001a\u0010\u0017\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0015\u0010\u0005R\u001a\u0010\u001a\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u0018\u0010\u0005R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0007\u001a\u0004\b\u001f\u0010\u001cR\u001c\u0010&\u001a\u0004\u0018\u00010\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0007\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/f8;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/t;", "", "getChallengeId", "()J", "getChallengeId$annotations", "()V", "challengeId", "getStatus", "getStatus$annotations", "status", "getCurrentScore", "getCurrentScore$annotations", "currentScore", "getTargetScore", "getTargetScore$annotations", "targetScore", "getCountdown", "getCountdown$annotations", "countdown", "getTargetDuration", "getTargetDuration$annotations", "targetDuration", "getDurationIncrement", "getDurationIncrement$annotations", "durationIncrement", "getGift_type", "()Ljava/lang/Long;", "getGift_type$annotations", "gift_type", "getEmoji_location", "getEmoji_location$annotations", "emoji_location", "", "getKtvChallengeType", "()Ljava/lang/Integer;", "getKtvChallengeType$annotations", "ktvChallengeType", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f8 extends vh7.c<f8>, com.bytedance.android.live.base.model.message.t {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getBaseMessage();

    @FieldName(name = "challenge_id")
    long getChallengeId();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    @FieldName(name = "countdown_second")
    long getCountdown();

    @FieldName(name = "current_score")
    long getCurrentScore();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    @FieldName(name = "increment_duration_second")
    long getDurationIncrement();

    @FieldName(name = "emoji_location")
    Long getEmoji_location();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    @FieldName(name = "gift_type")
    Long getGift_type();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getHttpSendTime();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    @FieldName(name = "ktv_challenge_type")
    Integer getKtvChallengeType();

    /* synthetic */ long getLocalTimestamp();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ Map<String, String> getMessageExtra();

    @Override // tlc.d
    /* synthetic */ int getMessageFrom();

    @Override // tlc.d
    /* synthetic */ long getMessageId();

    @Override // tlc.d
    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    @FieldName(name = "status")
    long getStatus();

    @FieldName(name = "target_duration_second")
    long getTargetDuration();

    @FieldName(name = "target_score")
    long getTargetScore();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    @Override // xlc.b
    /* synthetic */ String getWRDSKey();

    @Override // xlc.b
    /* synthetic */ String getWRDSSubKey();

    @Override // xlc.b
    /* synthetic */ long getWRDSVersion();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isCurrentRoom(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFirstHistoryMessage();

    @Override // tlc.d
    /* synthetic */ boolean isFromFirstRequest();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFromOtherIntercomRoom();

    @Override // tlc.d
    /* synthetic */ boolean isGlobalMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isInsert();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    @Override // xlc.b
    /* synthetic */ boolean isWRDSMessage();

    @Override // tlc.d
    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setBaseMessage(com.bytedance.android.live.base.model.message.m0 r100);

    @Override // tlc.d
    /* synthetic */ void setConsumeTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeEndTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeStartTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setEnqueueDispatchTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setHttpSendTime(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setIsFirstHistoryMessage(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsInsert(boolean r100);

    /* synthetic */ void setLocalInsertMsg(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setMessageMethod(String r100);

    @Override // tlc.d
    /* synthetic */ void setReceiveTime(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSMessage(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSSubKey(String r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSVersion(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
