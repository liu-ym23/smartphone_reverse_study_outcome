package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface k0 extends vh7.c<k0>, h0, t, x3, q3, u3 {
    public static final int CHAT_MESSAGE_ACTION_TYPE = 1;
    public static final int INDIVIUAL_CHAT_PRIORITY_HIGH = 80;
    public static final int INDIVIUAL_CHAT_PRIORITY_LOW = 30;
    public static final int INDIVIUAL_CHAT_PRIORITY_MIDDLE = 50;
    public static final int INDIVIUAL_CHAT_PRIORITY_UNKNOWN = 0;
    public static final int PRIORITY_LEVEL_HIGH = 2;
    public static final int PRIORITY_LEVEL_LOW = 0;
    public static final int PRIORITY_LEVEL_MIDDLE = 1;
    public static final long SOURCE_LOTTERY = 9;
    public static final long SOURCE_SUPER_LOTTERY = 10;
    public static final long SOURCE_TOPIC = 13;
    public static final int TAG_HOT_CHAT = 1;
    public static final int TAG_UNKNOWN = 0;

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

    long getAgreeMsgId();

    py.k getBackground();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ m0 getBaseMessage();

    @Override // com.bytedance.android.live.base.model.message.q3
    /* bridge */ /* synthetic */ Map getBuriedPoint();

    @Override // com.bytedance.android.live.base.model.message.h0
    /* synthetic */ String getChatContent();

    long getChatId();

    long getChatSource();

    @Override // com.bytedance.android.live.base.model.message.h0
    /* synthetic */ IBaseUser getChatUserInfo();

    /* synthetic */ IPublicAreaCommon getCommonArea();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    String getContent();

    int getContentSelfSeeStatus();

    long getDanmakuReceiveTime();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    long getEventTime();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    py.k getGiftImage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getHttpSendTime();

    long getHttpSuccessTimestamps();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    q1 getLandscapeAreaCommon();

    /* synthetic */ long getLocalTimestamp();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ Map<String, String> getMessageExtra();

    @Override // tlc.d
    /* synthetic */ int getMessageFrom();

    @Override // tlc.d
    /* synthetic */ long getMessageId();

    /* synthetic */ MessageIdentity getMessageIdentity();

    @Override // com.bytedance.android.live.base.model.message.q3, tlc.d
    /* synthetic */ String getMessageMethod();

    String getMsgId();

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

    int getPriorityLevel();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    a5 getRichDisplayText();

    @Override // com.bytedance.android.live.base.model.message.h0, com.bytedance.android.live.base.model.message.x3
    /* synthetic */ a5 getRichText();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    @Override // com.bytedance.android.live.base.model.message.x3
    /* synthetic */ j4 getSelfFakeRichContent();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    @Override // com.bytedance.android.live.base.model.message.u3
    /* synthetic */ IBaseUser getUserInMessage();

    IBaseUser getUserInfo();

    py.k getUserLabel();

    @Override // xlc.b
    /* synthetic */ String getWRDSKey();

    @Override // xlc.b
    /* synthetic */ String getWRDSSubKey();

    @Override // xlc.b
    /* synthetic */ long getWRDSVersion();

    int individualChatPriority();

    boolean intercomHideUserCard();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isCurrentRoom(long r100);

    boolean isFirstFetchShowMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFirstHistoryMessage();

    @Override // tlc.d
    /* synthetic */ boolean isFromFirstRequest();

    @Override // com.bytedance.android.live.base.model.message.t
    boolean isFromOtherIntercomRoom();

    @Override // tlc.d
    /* synthetic */ boolean isGlobalMessage();

    boolean isHighPriority();

    boolean isHotChat();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isInsert();

    boolean isLowPriority();

    void isSelfClickSend(boolean r100);

    boolean isSelfClickSend();

    boolean isSelfSendFake();

    boolean isSendReview();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    boolean isVisibleToSender();

    @Override // xlc.b
    /* synthetic */ boolean isWRDSMessage();

    @Override // tlc.d
    /* synthetic */ boolean needMonitor();

    void setBackground(py.k r100);

    /* synthetic */ void setBaseMessage(m0 r100);

    void setChatId(long r100);

    @Override // tlc.d
    /* synthetic */ void setConsumeTime(long r100);

    void setContent(String r100);

    void setContentSelfSeeStatus(int r100);

    void setDanmakuReceiveTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeEndTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeStartTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setEnqueueDispatchTime(long r100);

    void setFirstFetchShowMessage(boolean r100);

    void setFullScreenTextColor(String r100);

    void setGiftImage(py.k r100);

    @Override // tlc.d
    /* synthetic */ void setHttpSendTime(long r100);

    void setHttpSuccessTimestamps(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setIsFirstHistoryMessage(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsInsert(boolean r100);

    void setLandscapeAreaCommon(q1 r100);

    /* synthetic */ void setLocalInsertMsg(boolean r100);

    /* synthetic */ void setMessageIdentity(MessageIdentity r100);

    @Override // tlc.d
    /* synthetic */ void setMessageMethod(String r100);

    void setMsgId(String r100);

    void setPublicAreaCommon(IPublicAreaCommon r100);

    @Override // tlc.d
    /* synthetic */ void setReceiveTime(long r100);

    void setRichDisplayText(a5 r100);

    @Override // com.bytedance.android.live.base.model.message.x3
    /* synthetic */ void setSelfFakeRichContent(j4 r100);

    void setSelfSendFake(boolean r100);

    void setStartSendTime(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r100);

    void setUserInfo(IBaseUser r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSMessage(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSSubKey(String r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSVersion(long r100);

    long startSendTime();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
