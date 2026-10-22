package com.bytedance.android.livesdkapi.depend.model.live.abs;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdk.strategy.a;
import com.bytedance.android.livesdkapi.depend.model.DesireInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ActivityRoomSkinInfo;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.CommentaryRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IEcomData;
import com.bytedance.android.livesdkapi.depend.model.live.IExtension;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveHashTagInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IPSSelectedMessageInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRelevantRecommendation;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAppearance;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.RoomInteractData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.toolbar.RoomStreamDataObject;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import py.r;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0002H&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001c\u001a\u00020\u0007H&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0012H&J\n\u0010 \u001a\u0004\u0018\u00010\u0012H&J\b\u0010!\u001a\u00020\rH&J\b\u0010\"\u001a\u00020\u0012H&J\n\u0010#\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$H&J\n\u0010&\u001a\u0004\u0018\u00010\u0012H&J\b\u0010'\u001a\u00020\u0007H&J\b\u0010(\u001a\u00020\u0007H&J\b\u0010)\u001a\u00020\u0012H&J\b\u0010*\u001a\u00020\u0002H&J\n\u0010,\u001a\u0004\u0018\u00010+H&J\b\u0010-\u001a\u00020\u0007H&J\n\u0010/\u001a\u0004\u0018\u00010.H&J\n\u00100\u001a\u0004\u0018\u00010\u0012H&J\b\u00101\u001a\u00020\u0012H&J\n\u00102\u001a\u0004\u0018\u00010\u0012H&J\b\u00103\u001a\u00020\u0002H&J\u0016\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u000104H&J\n\u00106\u001a\u0004\u0018\u00010\u0012H&J\n\u00108\u001a\u0004\u0018\u000107H&J\b\u00109\u001a\u000207H&J\n\u0010:\u001a\u0004\u0018\u000107H&J\n\u0010<\u001a\u0004\u0018\u00010;H&J\n\u0010>\u001a\u0004\u0018\u00010=H&J\n\u0010?\u001a\u0004\u0018\u00010\u0014H&J\n\u0010A\u001a\u0004\u0018\u00010@H&J\n\u0010B\u001a\u0004\u0018\u00010@H&J\b\u0010C\u001a\u00020\u0007H&J\n\u0010E\u001a\u0004\u0018\u00010DH&J\u0012\u0010G\u001a\u00020\u00052\b\u0010F\u001a\u0004\u0018\u00010DH&J\u0016\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u000104H&J\b\u0010I\u001a\u00020\u0007H&J\b\u0010J\u001a\u00020\u0007H&J\b\u0010K\u001a\u00020\u0007H&J\b\u0010L\u001a\u00020\u0007H&J\u0010\u0010N\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0012H&J\b\u0010O\u001a\u00020\rH&J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\rH&J\u0010\u0010S\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010RH&J\b\u0010T\u001a\u00020\u0002H&J\n\u0010U\u001a\u0004\u0018\u00010\u0012H&J\b\u0010V\u001a\u00020\rH&J\n\u0010W\u001a\u0004\u0018\u00010\u0012H&J\b\u0010X\u001a\u00020\rH&J\u0012\u0010Z\u001a\u0004\u0018\u00010\u00122\u0006\u0010Y\u001a\u00020\u0012H&J\u0018\u0010]\u001a\u00020\u00052\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010$H&J\u0010\u0010^\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010$H&J\b\u0010_\u001a\u00020\u0007H&J\b\u0010`\u001a\u00020\u0007H&J\b\u0010a\u001a\u00020\u0007H&J\n\u0010b\u001a\u0004\u0018\u00010\u0012H&J\n\u0010c\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010e\u001a\u00020\u00052\b\u0010d\u001a\u0004\u0018\u00010\u0012H&J\n\u0010g\u001a\u0004\u0018\u00010fH&J\b\u0010h\u001a\u00020\u0007H&J\n\u0010j\u001a\u0004\u0018\u00010iH&J\n\u0010l\u001a\u0004\u0018\u00010kH&J\n\u0010n\u001a\u0004\u0018\u00010mH&J\u0012\u0010p\u001a\u00020\u00052\b\u0010o\u001a\u0004\u0018\u00010mH&J\n\u0010r\u001a\u0004\u0018\u00010qH&J\n\u0010t\u001a\u0004\u0018\u00010sH&J\n\u0010u\u001a\u0004\u0018\u00010\u0012H&J\b\u0010v\u001a\u00020\u0007H&J\b\u0010w\u001a\u00020\u0007H&J\u0012\u0010y\u001a\u00020\u00052\b\u0010x\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010{\u001a\u00020\u00052\b\u0010z\u001a\u0004\u0018\u00010\u0012H&J\n\u0010|\u001a\u0004\u0018\u00010\u0012H&J\b\u0010}\u001a\u00020\u0007H&J\b\u0010~\u001a\u00020\rH&J\b\u0010\u007f\u001a\u00020\rH&J\t\u0010\u0080\u0001\u001a\u00020\rH&J\t\u0010\u0081\u0001\u001a\u00020\rH&J\f\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u0001H&J\t\u0010\u0084\u0001\u001a\u00020\u0007H&J\t\u0010\u0085\u0001\u001a\u00020\u0007H&J\u000b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0012H&J\u0014\u0010\u0088\u0001\u001a\u00020\u00052\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0012H&J\t\u0010\u0089\u0001\u001a\u00020\u0007H&J\u0012\u0010\u008b\u0001\u001a\u00020\u00052\u0007\u0010\u008a\u0001\u001a\u00020\u0007H&J\u0014\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001d\u0010\u008f\u0001\u001a\u00020\u00052\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\t\u0010\u0091\u0001\u001a\u00020\rH&J\u0011\u0010\u0092\u0001\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\rH&J\u000b\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0012H&J\u0013\u0010\u0094\u0001\u001a\u00020\u00052\b\u0010P\u001a\u0004\u0018\u00010\u0012H&J\f\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u0001H&J\f\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u0001H&J\f\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u0001H&J\f\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u0001H&J\f\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u0001H&J\u0015\u0010 \u0001\u001a\u00020\u00052\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009d\u0001H&J\f\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u0001H&J\f\u0010¤\u0001\u001a\u0005\u0018\u00010£\u0001H&J\f\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u0001H&J\f\u0010¨\u0001\u001a\u0005\u0018\u00010§\u0001H&J\t\u0010©\u0001\u001a\u00020\u0007H&J\f\u0010«\u0001\u001a\u0005\u0018\u00010ª\u0001H&J\t\u0010¬\u0001\u001a\u00020\u0002H&J\t\u0010\u00ad\u0001\u001a\u00020\u0002H&¨\u0006®\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/abs/IRoomEx;", "", "", "getId", "id", "", "setId", "", "isReplay", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "getStreamType", "init", "getRoomId", "", "getMosaicStatusFlex", "allowGift", "isLandscape", "isEnableChat", "", "getAnchorId", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getOwner", "owner", "setOwner", "getBaseOwner", "setBaseOwner", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "getRoomAuthStatus", "isSofaRoom", "getMultiStreamData", "getMultiStreamDataFromPool", "getMultiStreamDefaultQualitySdkKey", "getDefaultQualityStrategy", "getVRType", "getRequestId", "getDygamePromoteInstanceId", "", "getStrategyFeatWhitelist", "getCoverUrl", "isPaidRoom", "isPaidSubscribeRoom", "getLog_pb", "getLandscapeCommentStyle", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPSSelectedMessageInfo;", "getPSSelectedMessageInfo", "isTemplateEnable", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfo;", "getEpisodeComponentData", "isEcomCart", "getOwnerUserIdString", "getClientVersion", "getStartTimeFlex", "", "getAnchorAbMapFlex", "getRoomRevenueOpenGameAppId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "getStreamUrlExtra", "getStreamUrlExtraSafely", "getStreamUrlExtraSafelyFlex", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAppearance;", "getAppearanceFlex", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRelevantRecommendation;", "getRelevantRecommendationFlex", "authorFlex", "Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;", "getExtensionFlex", "getExtension", "isVrRoom", "Lcom/bytedance/android/livesdk/chatroom/model/interact/j0;", "getLinkInitResult", "result", "setLinkInitResult", "getAnchorABMap", "hasValidImInfo", "isVsLive", "isUnionLiveRoom", "isUnionLiveInfoNotNull", "targetId", "isGuestAnchor", "isGameRoom", "type", "addGameStickerType", "", "getGameStickerTypes", "getGameTagId", "getLifeShareId", "getCompoundSceneType", "getCompoundStreamData", "getLinkMicScene", "key", "getAnchorAbValue", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomStampInfo;", "liveRoomStampInfos", "setLiveRoomStampsInfo", "getRoomStamps", "isVideoCameraVersion", "isGameCPRoom", "isLifeLocal", "getAudienceType", "getEnterLogId", "logId", "setEnterLogId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomOthersData;", "getRoomOthers", "isSupportCamera", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPublicScreenSpeedConfig;", "getPublicScreenSpeedConfig", "Lpy/r;", "getRoomIntroLabel", "Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/RoomStreamDataObject;", "getRoomStreamDataObject", "roomStreamDataObject", "setRoomStreamDataObject", "Lcom/bytedance/android/livesdk/strategy/a;", "getAdStrategyFeatures", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveHashTagInfo;", "getLiveHashTagInfo", "getOfficialChannelUidString", "isVipRoom", "isCompoundScene", "logPb", "setLog_pb", "requestId", "setRequestId", "buildPullUrl", "isPullUrlValid", "getGiftMessageStyle", "getFansMessageStyle", "getShareMessageStyle", "getFollowMessageStyle", "Lcom/bytedance/android/livesdkapi/depend/model/live/IOfficialChannelInfo;", "getOfficialChannelInfo", "isPrivatePlay", "isVirtualLive", "getLiveReason", "reason", "setLiveReason", "isFromRecommendCard", "enable", "setIsFromRecommendCard", "getInitTime", "()Ljava/lang/Long;", "time", "setInitTime", "(Ljava/lang/Long;)V", "getPullType", "setPullType", "getSourceType", "setSourceType", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig;", "getShortTermIndicatorConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/CommentaryRoomInfo;", "getCommentaryRoomInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomExtra;", "getExtra", "Lcom/bytedance/android/livesdkapi/depend/model/live/OfficialChannelExtraInfo;", "getOfficialChannelExtraInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorTabLabel;", "getAnchorTabLabel", "label", "setAnchorTabLabel", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomInteractData;", "getRoomInteractData", "Lcom/bytedance/android/livesdkapi/depend/model/DesireInfo;", "getDesireInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/ActivityRoomSkinInfo;", "getActivityRoomSkinInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameData;", "getGameData", "isEcomNew", "Lcom/bytedance/android/livesdkapi/depend/model/live/IEcomData;", "getEcomData", "getRoomLayoutKmp", "getLiveRoomModeKmp", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomEx {
    void addGameStickerType(int r100);

    boolean allowGift();

    IBaseUser authorFlex();

    String buildPullUrl();

    ActivityRoomSkinInfo getActivityRoomSkinInfo();

    a getAdStrategyFeatures();

    Map<String, String> getAnchorABMap();

    Map<String, String> getAnchorAbMapFlex();

    String getAnchorAbValue(String r100);

    String getAnchorId();

    AnchorTabLabel getAnchorTabLabel();

    IRoomAppearance getAppearanceFlex();

    String getAudienceType();

    IBaseUser getBaseOwner();

    String getClientVersion();

    CommentaryRoomInfo getCommentaryRoomInfo();

    int getCompoundSceneType();

    String getCompoundStreamData();

    String getCoverUrl();

    String getDefaultQualityStrategy();

    DesireInfo getDesireInfo();

    String getDygamePromoteInstanceId();

    IEcomData getEcomData();

    String getEnterLogId();

    IEpisodeExtraInfo getEpisodeComponentData();

    IExtension getExtension();

    IExtension getExtensionFlex();

    RoomExtra getExtra();

    int getFansMessageStyle();

    int getFollowMessageStyle();

    IRoomGameData getGameData();

    Set<Integer> getGameStickerTypes();

    long getGameTagId();

    int getGiftMessageStyle();

    long getId();

    Long getInitTime();

    long getLandscapeCommentStyle();

    String getLifeShareId();

    j0 getLinkInitResult();

    int getLinkMicScene();

    ILiveHashTagInfo getLiveHashTagInfo();

    String getLiveReason();

    long getLiveRoomModeKmp();

    String getLog_pb();

    int getMosaicStatusFlex();

    String getMultiStreamData();

    String getMultiStreamDataFromPool();

    String getMultiStreamDefaultQualitySdkKey();

    OfficialChannelExtraInfo getOfficialChannelExtraInfo();

    IOfficialChannelInfo getOfficialChannelInfo();

    String getOfficialChannelUidString();

    IBaseUser getOwner();

    String getOwnerUserIdString();

    IPSSelectedMessageInfo getPSSelectedMessageInfo();

    IPublicScreenSpeedConfig getPublicScreenSpeedConfig();

    int getPullType();

    IRelevantRecommendation getRelevantRecommendationFlex();

    String getRequestId();

    IRoomAuthStatus getRoomAuthStatus();

    long getRoomId();

    RoomInteractData getRoomInteractData();

    r getRoomIntroLabel();

    long getRoomLayoutKmp();

    IRoomOthersData getRoomOthers();

    String getRoomRevenueOpenGameAppId();

    List<RoomStampInfo> getRoomStamps();

    RoomStreamDataObject getRoomStreamDataObject();

    int getShareMessageStyle();

    ShortTermIndicatorConfig getShortTermIndicatorConfig();

    String getSourceType();

    long getStartTimeFlex();

    List<String> getStrategyFeatWhitelist();

    LiveMode getStreamType();

    IStreamUrlExtra getStreamUrlExtra();

    IStreamUrlExtra getStreamUrlExtraSafely();

    IStreamUrlExtra getStreamUrlExtraSafelyFlex();

    int getVRType();

    boolean hasValidImInfo();

    void init();

    boolean isCompoundScene();

    String isEcomCart();

    boolean isEcomNew();

    boolean isEnableChat(boolean r100);

    boolean isFromRecommendCard();

    boolean isGameCPRoom();

    int isGameRoom();

    boolean isGuestAnchor(String r100);

    boolean isLifeLocal();

    boolean isPaidRoom();

    boolean isPaidSubscribeRoom();

    boolean isPrivatePlay();

    boolean isPullUrlValid();

    boolean isReplay();

    boolean isSofaRoom();

    boolean isSupportCamera();

    boolean isTemplateEnable();

    boolean isUnionLiveInfoNotNull();

    boolean isUnionLiveRoom();

    boolean isVideoCameraVersion();

    boolean isVipRoom();

    boolean isVirtualLive();

    boolean isVrRoom();

    boolean isVsLive();

    void setAnchorTabLabel(AnchorTabLabel r100);

    void setBaseOwner(IBaseUser r100);

    void setEnterLogId(String r100);

    void setId(long r100);

    void setInitTime(Long r100);

    void setIsFromRecommendCard(boolean r100);

    void setLinkInitResult(j0 r100);

    void setLiveReason(String r100);

    void setLiveRoomStampsInfo(List<RoomStampInfo> r100);

    void setLog_pb(String r100);

    void setOwner(IBaseUser r100);

    void setPullType(int r100);

    void setRequestId(String r100);

    void setRoomStreamDataObject(RoomStreamDataObject r100);

    void setSourceType(String r100);
}
