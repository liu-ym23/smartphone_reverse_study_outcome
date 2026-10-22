package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface m1 extends vh7.c<m1>, t, h0, u3 {
    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ boolean canPin();

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

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ Map getBuriedPoint();

    @Override // com.bytedance.android.live.base.model.message.h0
    /* synthetic */ String getChatContent();

    @Override // com.bytedance.android.live.base.model.message.h0
    /* synthetic */ IBaseUser getChatUserInfo();

    /* synthetic */ IPublicAreaCommon getCommonArea();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getHttpSendTime();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    com.bytedance.android.live.base.model.data.m getItemStyle();

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

    @Override // com.bytedance.android.live.base.model.message.h0, com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ long getPinBaseMessageId();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ long getPinCommenterId();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ long getPinMessageShowArea();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ IBaseUser getPinUser();

    /* synthetic */ int getPriority();

    IPublicAreaCommon getPublicAreaCommon();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    @Override // com.bytedance.android.live.base.model.message.h0, com.bytedance.android.live.base.model.message.x3
    /* synthetic */ a5 getRichText();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    a5 getShareText();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    Map<String, String> getTrackingParams();

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

    void setItemStyle(com.bytedance.android.live.base.model.data.m r100);

    /* synthetic */ void setLocalInsertMsg(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setMessageMethod(String r100);

    void setPublicAreaCommon(IPublicAreaCommon r100);

    @Override // tlc.d
    /* synthetic */ void setReceiveTime(long r100);

    void setShareText(a5 r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r100);

    void setTrackingParams(Map<String, String> r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSMessage(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSSubKey(String r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSVersion(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
