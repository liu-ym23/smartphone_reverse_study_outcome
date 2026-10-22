package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0016\u0010\u0012\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00138&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00138&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010!\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010'\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001c\u0010*\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001c\u00100\u001a\u00020+8&@&X¦\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00103\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001c\u00106\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u001c\u00109\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u0016\u0010=\u001a\u0004\u0018\u00010:8&X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001e\u0010C\u001a\u0004\u0018\u00010>8&@&X¦\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010G\u001a\u0004\u0018\u00010D8&X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u001e\u0010M\u001a\u0004\u0018\u00010H8&@&X¦\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001e\u0010S\u001a\u0004\u0018\u00010N8&@&X¦\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010V\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\bT\u0010\u001e\"\u0004\bU\u0010 R\u001e\u0010\\\u001a\u0004\u0018\u00010W8&@&X¦\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001e\u0010a\u001a\u0004\u0018\u00010\u000f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001c\u0010d\u001a\u00020+8&@&X¦\u000e¢\u0006\f\u001a\u0004\bb\u0010-\"\u0004\bc\u0010/R\u0014\u0010g\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR$\u0010l\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001e\u0010r\u001a\u0004\u0018\u00010m8&@&X¦\u000e¢\u0006\f\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001c\u0010v\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\bs\u0010f\"\u0004\bt\u0010uR\u0016\u0010x\u001a\u0004\u0018\u00010\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\bw\u0010^R\u0014\u0010z\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\by\u0010\u001eR\u001e\u0010}\u001a\u0004\u0018\u00010\u000f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b{\u0010^\"\u0004\b|\u0010`R\"\u0010\u0083\u0001\u001a\u0004\u0018\u00010~8&@&X¦\u000e¢\u0006\u000f\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001f\u0010\u0086\u0001\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0084\u0001\u0010\u001e\"\u0005\b\u0085\u0001\u0010 R\u001f\u0010\u0089\u0001\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0087\u0001\u0010\u001e\"\u0005\b\u0088\u0001\u0010 R\u0016\u0010\u008b\u0001\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010\u001eR$\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008c\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R$\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0092\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0098\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R(\u0010\u009f\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u009c\u0001\u0018\u00010\u000e8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u009d\u0001\u0010i\"\u0005\b\u009e\u0001\u0010kR\u001f\u0010¢\u0001\u001a\u00020+8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b \u0001\u0010-\"\u0005\b¡\u0001\u0010/R\u001f\u0010¥\u0001\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b£\u0001\u0010\u001e\"\u0005\b¤\u0001\u0010 R\u001f\u0010¦\u0001\u001a\u00020\b8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b¦\u0001\u0010f\"\u0005\b§\u0001\u0010uR\u0016\u0010¨\u0001\u001a\u00020\b8&X¦\u0004¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010fR\u0016\u0010©\u0001\u001a\u00020\b8&X¦\u0004¢\u0006\u0007\u001a\u0005\b©\u0001\u0010fR\u0016\u0010ª\u0001\u001a\u00020\b8&X¦\u0004¢\u0006\u0007\u001a\u0005\bª\u0001\u0010fR\u001f\u0010\u00ad\u0001\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b«\u0001\u0010\u001e\"\u0005\b¬\u0001\u0010 ¨\u0006®\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/o7;", "Lvh7/c;", "Lgm2/d;", "Lgm2/h;", "Lcom/bytedance/android/live/base/model/message/t;", "", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "isLocal", "", "setLocal", "boolean", "setUnKnowGift", "", "", "getToUserIdStrings", "list", "setToUserIdString", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getFromUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setFromUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "fromUser", "getToUser", "setToUser", "toUser", "", "getGiftId", "()J", "setGiftId", "(J)V", "giftId", "getRepeatCount", "setRepeatCount", "repeatCount", "getFanTicketCount", "setFanTicketCount", "fanTicketCount", "getRoomFanTicketCount", "setRoomFanTicketCount", "roomFanTicketCount", "", "getRepeatEnd", "()I", "setRepeatEnd", "(I)V", "repeatEnd", "getComboCount", "setComboCount", "comboCount", "getGroupCount", "setGroupCount", "groupCount", "getGroupId", "setGroupId", "groupId", "Lcom/bytedance/android/livesdk/message/model/zb;", "getTextEffect", "()Lcom/bytedance/android/livesdk/message/model/zb;", "textEffect", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "getPublicAreaCommon", "()Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "setPublicAreaCommon", "(Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;)V", "publicAreaCommon", "Lcom/bytedance/android/livesdk/message/model/m7;", "getGiftPriority", "()Lcom/bytedance/android/livesdk/message/model/m7;", "giftPriority", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "setGift", "(Lcom/bytedance/android/livesdk/gift/model/h1;)V", PbRequest.SwitchType.GIFT, "Lcom/bytedance/android/live/base/model/message/a5;", "getTrayDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setTrayDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "trayDisplayText", "getBannedDisplayEffects", "setBannedDisplayEffects", "bannedDisplayEffects", "Lcom/bytedance/android/livesdk/gift/model/o0;", "getTrayInfo", "()Lcom/bytedance/android/livesdk/gift/model/o0;", "setTrayInfo", "(Lcom/bytedance/android/livesdk/gift/model/o0;)V", "trayInfo", "getDiyItemInfoList", "()Ljava/lang/String;", "setDiyItemInfoList", "(Ljava/lang/String;)V", "diyItemInfoList", "getClientGiftSource", "setClientGiftSource", "clientGiftSource", "getUseRoomMessage", "()Z", "useRoomMessage", "getToUserIds", "()Ljava/util/List;", "setToUserIds", "(Ljava/util/List;)V", "toUserIds", "Lcom/bytedance/android/livesdk/gift/model/c;", "getAssetEffectMixInfo", "()Lcom/bytedance/android/livesdk/gift/model/c;", "setAssetEffectMixInfo", "(Lcom/bytedance/android/livesdk/gift/model/c;)V", "assetEffectMixInfo", "getDisplayForSelf", "setDisplayForSelf", "(Z)V", "displayForSelf", "getInteractGiftInfo", "interactGiftInfo", "getTotalCount", "totalCount", "getTraceId", "setTraceId", "traceId", "Lcom/bytedance/android/livesdk/gift/model/a1;", "getAnchorGift", "()Lcom/bytedance/android/livesdk/gift/model/a1;", "setAnchorGift", "(Lcom/bytedance/android/livesdk/gift/model/a1;)V", "anchorGift", "getSendGiftTime", "setSendGiftTime", "sendGiftTime", "getForceDisplayEffects", "setForceDisplayEffects", "forceDisplayEffects", "getEffectDisplayTs", "effectDisplayTs", "Lcom/bytedance/android/livesdk/gift/model/j3;", "getSendTogetherInfo", "()Lcom/bytedance/android/livesdk/gift/model/j3;", "setSendTogetherInfo", "(Lcom/bytedance/android/livesdk/gift/model/j3;)V", "sendTogetherInfo", "Lcom/bytedance/android/livesdk/gift/model/w;", "getExtraEffectInfo", "()Lcom/bytedance/android/livesdk/gift/model/w;", "setExtraEffectInfo", "(Lcom/bytedance/android/livesdk/gift/model/w;)V", "extraEffectInfo", "Lcom/bytedance/android/livesdk/message/model/zj;", "getRoomHotInfo", "()Lcom/bytedance/android/livesdk/message/model/zj;", "roomHotInfo", "Lcom/bytedance/android/livesdk/gift/model/n3;", "getSeriesGiftData", "setSeriesGiftData", "seriesGiftData", "getMultiSendEffectLevel", "setMultiSendEffectLevel", "multiSendEffectLevel", "getCount", "setCount", "count", "isUrgent", "setUrgent", "isBannedInTray", "isBannedInChat", "isBannedInEffect", "getTotalMoney", "setTotalMoney", "totalMoney", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o7 extends vh7.c<o7>, gm2.d, gm2.h, com.bytedance.android.live.base.model.message.t, yh6.c {
    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    com.bytedance.android.livesdk.gift.model.a1 getAnchorGift();

    com.bytedance.android.livesdk.gift.model.c getAssetEffectMixInfo();

    long getBannedDisplayEffects();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getBaseMessage();

    int getClientGiftSource();

    long getComboCount();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    long getCount();

    @Override // tlc.d
    /* synthetic */ long getDelayDispatchMs();

    boolean getDisplayForSelf();

    String getDiyItemInfoList();

    long getEffectDisplayTs();

    com.bytedance.android.livesdk.gift.model.w getExtraEffectInfo();

    long getFanTicketCount();

    long getForceDisplayEffects();

    IBaseUser getFromUser();

    @Override // tlc.d
    /* synthetic */ int getGeneralMessageType();

    com.bytedance.android.livesdk.gift.model.h1 getGift();

    /* synthetic */ m7 getGiftIMPriority();

    long getGiftId();

    m7 getGiftPriority();

    /* synthetic */ long getGiftTimeStamp();

    long getGroupCount();

    long getGroupId();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getHttpSendTime();

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    /* synthetic */ int getIntType();

    String getInteractGiftInfo();

    /* synthetic */ long getLocalTimestamp();

    @Override // gm2.d, com.bytedance.android.livesdk.message.model.k6
    /* synthetic */ String getLogId();

    /* synthetic */ Map<Integer, Long> getMaps();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ Map<String, String> getMessageExtra();

    @Override // tlc.d
    /* synthetic */ int getMessageFrom();

    @Override // tlc.d
    /* synthetic */ long getMessageId();

    @Override // tlc.d
    /* synthetic */ String getMessageMethod();

    int getMultiSendEffectLevel();

    /* synthetic */ int getPriority();

    /* synthetic */ String getPriorityInfo();

    IPublicAreaCommon getPublicAreaCommon();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    long getRepeatCount();

    int getRepeatEnd();

    long getRoomFanTicketCount();

    zj getRoomHotInfo();

    @Override // tlc.d
    /* synthetic */ long getRoomId();

    /* synthetic */ boolean getRtcRoomMessageIsExpire();

    long getSendGiftTime();

    com.bytedance.android.livesdk.gift.model.j3 getSendTogetherInfo();

    List<com.bytedance.android.livesdk.gift.model.n3> getSeriesGiftData();

    zb getTextEffect();

    /* synthetic */ long getTimeStamp();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    IBaseUser getToUser();

    List<String> getToUserIdStrings();

    List<String> getToUserIds();

    long getTotalCount();

    long getTotalMoney();

    String getTraceId();

    com.bytedance.android.live.base.model.message.a5 getTrayDisplayText();

    com.bytedance.android.livesdk.gift.model.o0 getTrayInfo();

    boolean getUseRoomMessage();

    @Override // xlc.b
    /* synthetic */ String getWRDSKey();

    @Override // xlc.b
    /* synthetic */ String getWRDSSubKey();

    @Override // xlc.b
    /* synthetic */ long getWRDSVersion();

    boolean isBannedInChat();

    boolean isBannedInEffect();

    boolean isBannedInTray();

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

    /* synthetic */ boolean isLocal();

    /* synthetic */ boolean isRtcRoomMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    boolean isUrgent();

    @Override // xlc.b
    /* synthetic */ boolean isWRDSMessage();

    @Override // tlc.d
    /* synthetic */ boolean needMonitor();

    void setAnchorGift(com.bytedance.android.livesdk.gift.model.a1 r100);

    void setAssetEffectMixInfo(com.bytedance.android.livesdk.gift.model.c r100);

    void setBannedDisplayEffects(long r100);

    /* synthetic */ void setBaseMessage(com.bytedance.android.live.base.model.message.m0 r100);

    void setClientGiftSource(int r100);

    void setComboCount(long r100);

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    @Override // tlc.d
    /* synthetic */ void setConsumeTime(long r100);

    void setCount(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeEndTime(long r100);

    @Override // tlc.d
    /* synthetic */ void setDecodeStartTime(long r100);

    void setDisplayForSelf(boolean r100);

    void setDiyItemInfoList(String r100);

    @Override // tlc.d
    /* synthetic */ void setEnqueueDispatchTime(long r100);

    void setExtraEffectInfo(com.bytedance.android.livesdk.gift.model.w r100);

    void setFanTicketCount(long r100);

    void setForceDisplayEffects(long r100);

    void setFromUser(IBaseUser r100);

    void setGift(com.bytedance.android.livesdk.gift.model.h1 r100);

    void setGiftId(long r100);

    /* synthetic */ void setGiftTimeStamp(long r100);

    void setGroupCount(long r100);

    void setGroupId(long r100);

    @Override // tlc.d
    /* synthetic */ void setHttpSendTime(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setIsFirstHistoryMessage(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsFromFirstRequest(boolean r100);

    @Override // tlc.d
    /* synthetic */ void setIsInsert(boolean r100);

    void setLocal(boolean r100);

    /* synthetic */ void setLocalInsertMsg(boolean r100);

    /* synthetic */ void setLogId(String r100);

    /* synthetic */ void setMaps(Map<Integer, Long> r100);

    @Override // tlc.d
    /* synthetic */ void setMessageMethod(String r100);

    void setMultiSendEffectLevel(int r100);

    void setPublicAreaCommon(IPublicAreaCommon r100);

    @Override // tlc.d
    /* synthetic */ void setReceiveTime(long r100);

    void setRepeatCount(long r100);

    void setRepeatEnd(int r100);

    void setRoomFanTicketCount(long r100);

    /* synthetic */ void setRtcRoomMessage(boolean r100);

    /* synthetic */ void setRtcRoomMessageIsExpire(boolean r100);

    void setSendGiftTime(long r100);

    void setSendTogetherInfo(com.bytedance.android.livesdk.gift.model.j3 r100);

    void setSeriesGiftData(List<? extends com.bytedance.android.livesdk.gift.model.n3> r100);

    /* synthetic */ void setTimeStamp(long r100);

    /* synthetic */ void setTimeStampMap(int r100, long r101);

    void setToUser(IBaseUser r100);

    void setToUserIdString(List<String> r100);

    void setToUserIds(List<String> r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r100);

    void setTotalMoney(long r100);

    void setTraceId(String r100);

    void setTrayDisplayText(com.bytedance.android.live.base.model.message.a5 r100);

    void setTrayInfo(com.bytedance.android.livesdk.gift.model.o0 r100);

    void setUnKnowGift(boolean r100);

    void setUrgent(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSMessage(boolean r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSSubKey(String r100);

    @Override // xlc.b
    /* synthetic */ void setWRDSVersion(long r100);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
