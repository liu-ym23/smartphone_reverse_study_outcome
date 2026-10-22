package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.IRoomMessageExtra;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u00032\u00020\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\u0013\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u0014\u0010 \u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0016R\u0016\u0010$\u001a\u0004\u0018\u00010!8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/base/model/message/c4;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/t;", "Lcom/bytedance/android/live/base/model/message/q3;", "Lcom/bytedance/android/live/base/model/message/u3;", "", "getBizScene", "()Ljava/lang/String;", "setBizScene", "(Ljava/lang/String;)V", "bizScene", "getContent", "setContent", "content", "", "getRoomMessageType", "()I", "setRoomMessageType", "(I)V", "roomMessageType", "", "getSystemTopMsg", "()Z", "setSystemTopMsg", "(Z)V", "systemTopMsg", "getForcedGuarantee", "setForcedGuarantee", "forcedGuarantee", "getSupprotLandscape", "setSupprotLandscape", "supprotLandscape", "isGiftTypeMessage", "Lcom/bytedance/android/livesdkapi/message/IRoomMessageExtra;", "getRoomMessageExtra", "()Lcom/bytedance/android/livesdkapi/message/IRoomMessageExtra;", "roomMessageExtra", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c4 extends vh7.c<c4>, t, q3, u3 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.live.base.model.message.q3
    /* synthetic */ boolean canPin();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ m0 getBaseMessage();

    String getBizScene();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* synthetic */ Map<String, String> getBuriedPoint();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    String getContent();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    boolean getForcedGuarantee();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getHttpSendTime();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    /* synthetic */ long getLocalTimestamp();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ Map<String, String> getMessageExtra();

    @Override // tlc.d
    /* synthetic */ int getMessageFrom();

    @Override // tlc.d
    /* synthetic */ long getMessageId();

    @Override // tlc.d
    /* synthetic */ String getMessageMethod();

    @Override // com.bytedance.android.live.base.model.message.u3
    /* synthetic */ IPublicAreaCommon getOrInitPublicAreaCommon();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* synthetic */ long getPinBaseMessageId();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* synthetic */ long getPinCommenterId();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* synthetic */ long getPinMessageShowArea();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* synthetic */ IBaseUser getPinUser();

    /* synthetic */ int getPriority();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    IRoomMessageExtra getRoomMessageExtra();

    int getRoomMessageType();

    boolean getSupprotLandscape();

    boolean getSystemTopMsg();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    @Override // com.bytedance.android.live.base.model.message.u3
    /* synthetic */ IBaseUser getUserInMessage();

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

    boolean isGiftTypeMessage();

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

    /* synthetic */ void setBaseMessage(m0 r100);

    void setBizScene(String r100);

    @Override // tlc.d
    /* synthetic */ void setConsumeTime(long r100);

    void setContent(String r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeEndTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeStartTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setEnqueueDispatchTime(long r100);

    void setForcedGuarantee(boolean r100);

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

    void setRoomMessageType(int r100);

    void setSupprotLandscape(boolean r100);

    void setSystemTopMsg(boolean r100);

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
