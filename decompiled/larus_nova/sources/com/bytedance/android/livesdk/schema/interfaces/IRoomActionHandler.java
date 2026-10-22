package com.bytedance.android.livesdk.schema.interfaces;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public interface IRoomActionHandler<T extends BaseSchemaModel> extends IBaseSchemaHandler<T> {

    public static class Params {
        public String activeTag;
        public String adDataParams;
        public String adEnterExtraParams;
        public String adLiveParams;
        public HashMap adLogExtra;
        public String adSchemaEnterTime;
        public String adxCoinTaskInfo;
        public String aggregateBannerId;
        public String aggregateColumnTitle;
        public String anchorId;
        public String anchorType;
        public String appId;
        public String applySource;
        public int applyType;
        public Long appointmentId;
        public Boolean autoEnter;
        public String autoLinkMic;
        public String autoLinkMicFromType;
        public String autoLinkMicFromUid;
        public boolean backHostActivity;
        public String backRoom;
        public String backUrl;
        public String businessExtra;
        public String businessLiveParams;
        public String businessParams;
        public long cameraId;
        public boolean checkLiveLiteExtraBundle;
        public String cleanRoomAfterEnter;
        public String clickOrder;
        public String collectionId;
        public String commentId;
        public String contentType;
        public String couponToken;
        public String cpsTrack;
        public String csjHostBack;
        public String csjHostIcon;
        public String csjHostName;
        public boolean disableSliding;
        public String distributeUserId;
        public String drawUrl;
        public String dynamicFeedId;
        public String ecomLiveParams;
        public String enableCastLogin;
        public String enableFeedDrawer;
        public String enterComponent;
        public String enterFrom;
        public String enterFromMerge;
        public String enterFromModule;
        public Bundle enterLiveBundle;
        public Bundle enterLiveExtra;
        public String enterLiveSource;
        public String enterMethod;
        public Integer enterRoomNum;
        public int enterRoomType;
        public String entranceForm;
        public String eventParams;
        public String eventType;
        public String extraParams;
        public String fansClubGuideMsg;
        public String fansClubGuideSource;
        public String feedExtraParams;
        public int feedItemType;
        public String finishDetailActivity;
        public boolean forceNewActivityWhenJumpRoom;
        public String fromPushRoomId;
        public String fromRequestId;
        public String fromSecUid;
        public String fromUserId;
        public String giftId;
        public String giftPageType;
        public String giftPanelType;
        public String homepage_hot_scene;
        public String host;
        public String ignoreLinkMic;
        public String imChannelInviteId;
        public String imTrackerExtra;
        public boolean isAdCoin;
        public String isAppLogin;
        public String isCacheBubble;
        public int isClickMiniWindow;
        public String isDynamicPreview;
        public Integer isEnterFromOtherChannel;
        public String isFromCoinTask;
        private int isFromDrawer;
        public Boolean isFromPreview;
        public boolean isFromXTab;
        public String isGuessInstant;
        public String isInnerFromDrawer;
        public String isJointRoom;
        public String isMedia;
        public boolean isPickTop;
        public Integer isPluginInstall;
        public Integer isPluginLoad;
        public String isQuickInvite;
        public boolean isRoomHasPrefetch;
        public String issueId;
        public String itemType;
        public String jointAnchorId;
        public long latestWatchTime;
        public String lifeRefluxInfo;
        public String lifeShareRefluxInfo;
        public String linkMicFloatHint;
        public String linkUserId;
        public String linkmicParams;
        public String liveAdType;
        public String liveAdsParams;
        public int liveAfterSecondsTrackClick;
        public String liveApplyQcpxParams;
        public String liveCommonShareParams;
        public String liveReason;
        public String liveRecommend;
        public boolean liveReenterRoom;
        public HashMap liveRoomExtra;
        public Long liveRoomMode;
        public String liveShortTouchParams;
        public String localLifeEnvParams;
        public String localLifeParams;
        public Bundle logExtras;
        public String logPb;
        public String mEnterLiveAdType;
        public String mIesKey;
        public String mIsOtherChannel;
        public String magic3ActivityId;
        public String magic3Comptype;
        public String magic3Source;
        public long matchId;
        public String message;
        public String messageI18n;
        public String msgType;
        public Long multiTabSelectTabId;
        public String myPausedLivingRoomId;
        public String myPausedLivingRoomStreamId;
        public String nationalTaskSchema;
        public boolean openFansClubGuide;
        public boolean openFollowGuide;
        public boolean openGiftPanel;
        public boolean openLiveDrawer;
        public boolean openPickProfilePanel;
        public boolean openPropPanel;
        public boolean openShowListPage;
        public String operationBannerOrder;
        public String operationType;
        public int orientation;
        private String originEnterFrom;
        private String originEnterMethod;
        public String originSchema;
        public String originVid;
        public boolean paidRoom;
        public String pangleSchemeParams;
        public String platform;
        public Long pluginLoadTime;
        public String popType;
        public String popularBoxId;
        public long portalId;
        public String prePullStreamData;
        public String previousPage;
        public String publicMissionBundle;
        public String pushContent;
        public String pushCreateTimeToNow;
        public String pushSource;
        public String pushTitle;
        public String pushType;
        public String qcRedPacket;
        public String replyAction;
        public String reqParams;
        public String requestFeedOnce;
        public String requestId;
        public String requestPage;
        public String resolution;
        public Room room;
        public long roomId;
        public long[] roomIds;
        public String roomLayout;
        public int roomStaySendClickDelay;
        public String roomType;
        public String schema;
        public String searchId;
        public String searchParams;
        public String searchResultId;
        public String searchType;
        public Long seekTime;
        public Boolean sendAdClickEvent;
        public String shareFromRoomId;
        public String sharePlatForm;
        public boolean sharePlayer;
        public String sharePullStreamData;
        public String shareUserId;
        public String shopGuideId;
        public boolean smoothEnter;
        public String source;
        public String sourceBtmToken;
        public String sourceKey;
        public String specialParams;
        public String tabId;
        public int tabIndex;
        public String tagIds;
        public String templateId;
        public String tokenForm;
        public String topMessageType;
        public Long tryEnterRoomTime;
        public int[] typeList;
        public String useMultiRoomProvider;
        public long userFrom;
        public String videoId;
        public String vsEnterType;
        public String widgetEnterType;
        public boolean withOutRoomId;
        public String xiguaUid;

        public Params() {
            this.isClickMiniWindow = -1;
            this.orientation = -1;
            this.enterRoomType = -1;
            this.feedItemType = 1;
            this.sendAdClickEvent = Boolean.FALSE;
            this.multiTabSelectTabId = 0L;
            this.seekTime = 0L;
            this.requestFeedOnce = "0";
            this.cameraId = 0;
            this.sharePlatForm = "";
            this.sharePlayer = false;
            this.smoothEnter = false;
            this.forceNewActivityWhenJumpRoom = false;
            this.isFromDrawer = 0;
        }

        public String getOriginEnterFrom() {
            return this.originEnterFrom;
        }

        public String getOriginEnterMethod() {
            return this.originEnterMethod;
        }

        public int isFromDrawer() {
            return this.isFromDrawer;
        }

        public Params setActiveTag(String r100) {
            this.activeTag = r100;
            return this;
        }

        public Params setAdDataParams(String r100) {
            this.adDataParams = r100;
            return this;
        }

        public Params setAdEnterExtraParams(String r100) {
            this.adEnterExtraParams = r100;
            return this;
        }

        public Params setAdLiveParams(String r100) {
            this.adLiveParams = r100;
            return this;
        }

        public Params setAdLogExtra(HashMap r100) {
            this.adLogExtra = r100;
            return this;
        }

        public Params setAdSchemaEnterTime(String r100) {
            this.adSchemaEnterTime = r100;
            return this;
        }

        public Params setAdxCoinTaskInfo(String r100) {
            this.adxCoinTaskInfo = r100;
            return this;
        }

        public Params setAggregateBannerId(String r100) {
            this.aggregateBannerId = r100;
            return this;
        }

        public Params setAggregateColumnTitle(String r100) {
            this.aggregateColumnTitle = r100;
            return this;
        }

        public Params setAnchorId(String r100) {
            this.anchorId = r100;
            return this;
        }

        public Params setAnchorType(String r100) {
            this.anchorType = r100;
            return this;
        }

        public Params setAppId(String r100) {
            this.appId = r100;
            return this;
        }

        public Params setAppLogin(String r100) {
            this.isAppLogin = r100;
            return this;
        }

        public Params setApplySource(String r100) {
            this.applySource = r100;
            return this;
        }

        public Params setApplyType(int r100) {
            this.applyType = r100;
            return this;
        }

        public Params setAppointmentId(Long r100) {
            this.appointmentId = r100;
            return this;
        }

        public Params setAutoEnter(Boolean r100) {
            this.autoEnter = r100;
            return this;
        }

        public Params setAutoLinkMic(boolean r100) {
            if (r100 == false) goto L4;
            String r101 = "true";
        L5:
            this.autoLinkMic = r101;
            return this;
        L4:
            r101 = "false";
            goto L5
        }

        public Params setAutoLinkMicFromType(String r100) {
            this.autoLinkMicFromType = r100;
            return this;
        }

        public Params setAutoLinkMicFromUid(String r100) {
            this.autoLinkMicFromUid = r100;
            return this;
        }

        public Params setBackHostActivity(String r100) {
            this.backHostActivity = "1".equals(r100);
            return this;
        }

        public Params setBackRoom(String r100) {
            this.backRoom = r100;
            return this;
        }

        public Params setBackUrl(String r100) {
            this.backUrl = r100;
            return this;
        }

        public Params setBusinessExtra(String r100) {
            this.businessExtra = r100;
            return this;
        }

        public Params setBusinessLiveParams(String r100) {
            this.businessLiveParams = r100;
            return this;
        }

        public Params setBusinessParams(String r100) {
            this.businessParams = r100;
            return this;
        }

        public Params setCameraId(long r100) {
            this.cameraId = r100;
            return this;
        }

        public Params setCheckLiveLiteExtraBundle(boolean r100) {
            this.checkLiveLiteExtraBundle = r100;
            return this;
        }

        public Params setCleanRoomAfterEnter(String r100) {
            this.cleanRoomAfterEnter = r100;
            return this;
        }

        public Params setClickOrder(String r100) {
            this.clickOrder = r100;
            return this;
        }

        public Params setCollectionId(String r100) {
            this.collectionId = r100;
            return this;
        }

        public Params setCommentId(String r100) {
            this.commentId = r100;
            return this;
        }

        public Params setContentType(String r100) {
            this.contentType = r100;
            return this;
        }

        public Params setCouponToken(String r100) {
            this.couponToken = r100;
            return this;
        }

        public Params setCpsTrack(String r100) {
            this.cpsTrack = r100;
            return this;
        }

        public Params setCsjHostBack(String r100) {
            this.csjHostBack = r100;
            return this;
        }

        public Params setCsjHostIcon(String r100) {
            this.csjHostIcon = r100;
            return this;
        }

        public Params setCsjHostName(String r100) {
            this.csjHostName = r100;
            return this;
        }

        public Params setDisableSliding(boolean r100) {
            this.disableSliding = r100;
            return this;
        }

        public Params setDistributeUserId(String r100) {
            this.distributeUserId = r100;
            return this;
        }

        public Params setDrawUrls(String r100) {
            this.drawUrl = r100;
            return this;
        }

        public Params setDynamicFeedId(String r100) {
            this.dynamicFeedId = r100;
            return this;
        }

        public Params setECOMParams(String r100) {
            this.specialParams = r100;
            return this;
        }

        public Params setEcomLiveParams(String r100) {
            this.ecomLiveParams = r100;
            return this;
        }

        public Params setEnableCastLogin(String r100) {
            this.enableCastLogin = r100;
            return this;
        }

        public Params setEnableFeedDrawer(String r100) {
            this.enableFeedDrawer = r100;
            return this;
        }

        public Params setEnterComponent(String r100) {
            this.enterComponent = r100;
            return this;
        }

        public Params setEnterFrom(String r100) {
            this.enterFrom = r100;
            return this;
        }

        public Params setEnterFromMerge(String r100) {
            this.enterFromMerge = r100;
            return this;
        }

        public Params setEnterFromModule(String r100) {
            this.enterFromModule = r100;
            return this;
        }

        public Params setEnterLiveAdType(String r100) {
            this.mEnterLiveAdType = r100;
            return this;
        }

        public Params setEnterLiveBundle(Bundle r100) {
            this.enterLiveBundle = r100;
            return this;
        }

        public Params setEnterLiveExtra(Bundle r100) {
            this.enterLiveExtra = r100;
            return this;
        }

        public Params setEnterLiveSource(String r100) {
            this.enterLiveSource = r100;
            return this;
        }

        public Params setEnterMethod(String r100) {
            this.enterMethod = r100;
            return this;
        }

        public Params setEnterRoomNum(Integer r100) {
            this.enterRoomNum = r100;
            return this;
        }

        public Params setEnterRoomType(int r100) {
            this.enterRoomType = r100;
            return this;
        }

        public Params setEntranceForm(String r100) {
            this.entranceForm = r100;
            return this;
        }

        public Params setEventParams(String r100) {
            this.eventParams = r100;
            return this;
        }

        public Params setEventType(String r100) {
            this.eventType = r100;
            return this;
        }

        public Params setExtraParams(String r100) {
            this.extraParams = r100;
            return this;
        }

        public Params setFansClubGuideMsg(String r100) {
            this.fansClubGuideMsg = r100;
            return this;
        }

        public Params setFansClubGuideSource(String r100) {
            this.fansClubGuideSource = r100;
            return this;
        }

        public Params setFeedExtraParams(String r100) {
            this.feedExtraParams = r100;
            return this;
        }

        public Params setFeedItemType(int r100) {
            this.feedItemType = r100;
            return this;
        }

        public Params setFinishDetailActivity(String r100) {
            this.finishDetailActivity = r100;
            return this;
        }

        public Params setForceNewActivityWhenJumpRoom(boolean r100) {
            this.forceNewActivityWhenJumpRoom = r100;
            return this;
        }

        public Params setFromDrawer(int r100) {
            this.isFromDrawer = r100;
            return this;
        }

        public Params setFromRequestId(String r100) {
            this.fromRequestId = r100;
            return this;
        }

        public Params setFromSecUid(String r100) {
            this.fromSecUid = r100;
            return this;
        }

        public Params setFromUserId(String r100) {
            this.fromUserId = r100;
            return this;
        }

        public Params setGiftId(String r100) {
            this.giftId = r100;
            return this;
        }

        public Params setGiftPageType(String r100) {
            this.giftPageType = r100;
            return this;
        }

        public Params setGiftPanelType(String r100) {
            this.giftPanelType = r100;
            return this;
        }

        public Params setHomePageHotScene(String r100) {
            this.homepage_hot_scene = r100;
            return this;
        }

        public Params setHost(String r100) {
            this.host = r100;
            return this;
        }

        public Params setIesKey(String r100) {
            this.mIesKey = r100;
            return this;
        }

        public Params setIgonreLinkMic(boolean r100) {
            if (r100 == false) goto L4;
            String r101 = "true";
        L5:
            this.ignoreLinkMic = r101;
            return this;
        L4:
            r101 = "false";
            goto L5
        }

        public Params setImChannelInviteId(String r100) {
            this.imChannelInviteId = r100;
            return this;
        }

        public Params setImTrackerExtra(String r100) {
            this.imTrackerExtra = r100;
            return this;
        }

        public Params setIsAdCoin(boolean r100) {
            this.isAdCoin = r100;
            return this;
        }

        public Params setIsCacheBubble(String r100) {
            this.isCacheBubble = r100;
            return this;
        }

        public Params setIsClickMiniWindow(int r100) {
            this.isClickMiniWindow = r100;
            return this;
        }

        public Params setIsDynamicPreview(String r100) {
            this.isDynamicPreview = r100;
            return this;
        }

        public Params setIsEnterFromOtherChannel(Integer r100) {
            this.isEnterFromOtherChannel = r100;
            return this;
        }

        public Params setIsFromCoinTask(String r100) {
            this.isFromCoinTask = r100;
            return this;
        }

        public Params setIsFromPreview(Boolean r100) {
            this.isFromPreview = r100;
            return this;
        }

        public Params setIsFromXTab(boolean r100) {
            this.isFromXTab = r100;
            return this;
        }

        public Params setIsGuessInstant(String r100) {
            this.isGuessInstant = r100;
            return this;
        }

        public Params setIsInnerFromDrawer(String r100) {
            this.isInnerFromDrawer = r100;
            return this;
        }

        public Params setIsJointRoom(String r100) {
            this.isJointRoom = r100;
            return this;
        }

        public Params setIsMedia(String r100) {
            this.isMedia = r100;
            return this;
        }

        public Params setIsOtherChannel(String r100) {
            this.mIsOtherChannel = r100;
            return this;
        }

        public Params setIsPluginInstall(Integer r100) {
            this.isPluginInstall = r100;
            return this;
        }

        public Params setIsPluginLoad(Integer r100) {
            this.isPluginLoad = r100;
            return this;
        }

        public Params setIsRoomHasPrefetch(boolean r100) {
            this.isRoomHasPrefetch = r100;
            return this;
        }

        public Params setIssueId(String r100) {
            this.issueId = r100;
            return this;
        }

        public Params setItemType(String r100) {
            this.itemType = r100;
            return this;
        }

        public Params setJointAnchorId(String r100) {
            this.jointAnchorId = r100;
            return this;
        }

        public Params setLatestWatchTime(long r100) {
            this.latestWatchTime = r100;
            return this;
        }

        public Params setLifeRefluxInfo(String r100) {
            this.lifeRefluxInfo = r100;
            return this;
        }

        public Params setLifeShareRefluxInfo(String r100) {
            this.lifeShareRefluxInfo = r100;
            return this;
        }

        public Params setLinkMicFloatHint(String r100) {
            this.linkMicFloatHint = r100;
            return this;
        }

        public Params setLinkUserId(String r100) {
            this.linkUserId = r100;
            return this;
        }

        public Params setLinkmicParams(String r100) {
            this.linkmicParams = r100;
            return this;
        }

        public Params setLiveAdType(String r100) {
            this.liveAdType = r100;
            return this;
        }

        public Params setLiveAdsParams(String r100) {
            this.liveAdsParams = r100;
            return this;
        }

        public Params setLiveApplyQcpxParams(String r100) {
            this.liveApplyQcpxParams = r100;
            return this;
        }

        public Params setLiveCommonShareParams(String r100) {
            this.liveCommonShareParams = r100;
            return this;
        }

        public Params setLiveReason(String r100) {
            this.liveReason = r100;
            return this;
        }

        public Params setLiveRecommend(String r100) {
            this.liveRecommend = r100;
            return this;
        }

        public Params setLiveReenterRoom(boolean r100) {
            this.liveReenterRoom = r100;
            return this;
        }

        public Params setLiveRoomExtra(HashMap r100) {
            this.liveRoomExtra = r100;
            return this;
        }

        public Params setLiveRoomMode(Long r100) {
            this.liveRoomMode = r100;
            return this;
        }

        public Params setLiveShortTouchParams(String r100) {
            this.liveShortTouchParams = r100;
            return this;
        }

        public Params setLocalLifeEnvParams(String r100) {
            this.localLifeEnvParams = r100;
            return this;
        }

        public Params setLocalLifeParams(String r100) {
            this.localLifeParams = r100;
            return this;
        }

        public Params setLogExtras(Bundle r100) {
            this.logExtras = r100;
            return this;
        }

        public Params setLogPb(String r100) {
            this.logPb = r100;
            return this;
        }

        public Params setMagic3ActivityId(String r100) {
            this.magic3ActivityId = r100;
            return this;
        }

        public Params setMagic3Comptype(String r100) {
            this.magic3Comptype = r100;
            return this;
        }

        public Params setMagic3Source(String r100) {
            this.magic3Source = r100;
            return this;
        }

        public Params setMatchId(long r100) {
            this.matchId = r100;
            return this;
        }

        public Params setMessage(String r100) {
            this.message = r100;
            return this;
        }

        public Params setMessageI18n(String r100) {
            this.messageI18n = r100;
            return this;
        }

        public Params setMsgType(String r100) {
            this.msgType = r100;
            return this;
        }

        public Params setMultiTabSelectTabId(Long r100) {
            this.multiTabSelectTabId = r100;
            return this;
        }

        public Params setMyPausedLivingRoomId(String r100) {
            this.myPausedLivingRoomId = r100;
            return this;
        }

        public Params setMyPausedLivingRoomStreamId(String r100) {
            this.myPausedLivingRoomStreamId = r100;
            return this;
        }

        public Params setNationalTaskSchema(String r100) {
            this.nationalTaskSchema = r100;
            return this;
        }

        public Params setOpenFansClubGuide(boolean r100) {
            this.openFansClubGuide = r100;
            return this;
        }

        public Params setOpenFollowGuide(boolean r100) {
            this.openFollowGuide = r100;
            return this;
        }

        public Params setOpenGiftPanel(boolean r100) {
            this.openGiftPanel = r100;
            return this;
        }

        public Params setOpenLiveDrawer(boolean r100) {
            this.openLiveDrawer = r100;
            return this;
        }

        public Params setOpenPropPanel(boolean r100) {
            this.openPropPanel = r100;
            return this;
        }

        public Params setOpenShowListPage(boolean r100) {
            this.openShowListPage = r100;
            return this;
        }

        public Params setOperationBannerOrder(String r100) {
            this.operationBannerOrder = r100;
            return this;
        }

        public Params setOperationType(String r100) {
            this.operationType = r100;
            return this;
        }

        public Params setOrientation(int r100) {
            this.orientation = r100;
            return this;
        }

        public Params setOriginEnterFrom(String r100) {
            this.originEnterFrom = r100;
            return this;
        }

        public Params setOriginEnterMethod(String r100) {
            this.originEnterMethod = r100;
            return this;
        }

        public Params setOriginSchema(String r100) {
            this.originSchema = r100;
            return this;
        }

        public Params setOriginVid(String r100) {
            this.originVid = r100;
            return this;
        }

        public Params setPaidRoom(boolean r100) {
            this.paidRoom = r100;
            return this;
        }

        public Params setPangleSchemeParams(String r100) {
            this.pangleSchemeParams = r100;
            return this;
        }

        public Params setPlatform(String r100) {
            this.platform = r100;
            return this;
        }

        public Params setPluginLoadTime(Long r100) {
            this.pluginLoadTime = r100;
            return this;
        }

        public Params setPopType(String r100) {
            this.popType = r100;
            return this;
        }

        public Params setPopularBoxId(String r100) {
            this.popularBoxId = r100;
            return this;
        }

        public Params setPrePullStreamData(String r100) {
            if (TextUtils.isEmpty(r100) == true) goto L5;
            this.prePullStreamData = r100;
        L5:
            return this;
        }

        public Params setPreviousPage(String r100) {
            this.previousPage = r100;
            return this;
        }

        public Params setPublicMission(String r100) {
            this.publicMissionBundle = r100;
            return this;
        }

        public Params setPushContent(String r100) {
            this.pushContent = r100;
            return this;
        }

        public Params setPushCreateTimeToNow(String r100) {
            this.pushCreateTimeToNow = r100;
            return this;
        }

        public Params setPushSource(String r100) {
            this.pushSource = r100;
            return this;
        }

        public Params setPushTitle(String r100) {
            this.pushTitle = r100;
            return this;
        }

        public Params setPushType(String r100) {
            this.pushType = r100;
            return this;
        }

        public Params setQcRedPacket(String r100) {
            this.qcRedPacket = r100;
            return this;
        }

        public Params setQuickInvite(String r100) {
            this.isQuickInvite = r100;
            return this;
        }

        public Params setReplayAction(String r100) {
            this.replyAction = r100;
            return this;
        }

        public Params setReqParams(String r100) {
            this.reqParams = r100;
            return this;
        }

        public Params setRequestFeedOnce(String r100) {
            this.requestFeedOnce = r100;
            return this;
        }

        public Params setRequestId(String r100) {
            this.requestId = r100;
            return this;
        }

        public Params setRequestPage(String r100) {
            this.requestPage = r100;
            return this;
        }

        public Params setResolution(String r100) {
            if (TextUtils.isEmpty(r100) == true) goto L5;
            this.resolution = r100;
        L5:
            return this;
        }

        public Params setRoom(Room r100) {
            this.room = r100;
            return this;
        }

        public Params setRoomId(long r100) {
            this.roomId = r100;
            return this;
        }

        public Params setRoomIds(long[] r100) {
            this.roomIds = r100;
            return this;
        }

        public Params setRoomLayout(String r100) {
            this.roomLayout = r100;
            return this;
        }

        public Params setRoomStaySendClickDelay(int r100) {
            this.roomStaySendClickDelay = r100;
            return this;
        }

        public Params setRoomType(String r100) {
            this.roomType = r100;
            return this;
        }

        public Params setSchema(String r100) {
            this.schema = r100;
            return this;
        }

        public Params setSearchId(String r100) {
            this.searchId = r100;
            return this;
        }

        public Params setSearchParams(String r100) {
            this.searchParams = r100;
            return this;
        }

        public Params setSearchResultId(String r100) {
            this.searchResultId = r100;
            return this;
        }

        public Params setSearchType(String r100) {
            this.searchType = r100;
            return this;
        }

        public Params setSeekTime(Long r100) {
            this.seekTime = r100;
            return this;
        }

        public Params setSendAdClickEvent(Boolean r100) {
            this.sendAdClickEvent = r100;
            return this;
        }

        public Params setShareFromRoomId(String r100) {
            this.shareFromRoomId = r100;
            return this;
        }

        public Params setSharePlatForm(String r100) {
            this.sharePlatForm = r100;
            return this;
        }

        public Params setSharePlayer(boolean r100) {
            this.sharePlayer = r100;
            return this;
        }

        public Params setSharePullStreamData(String r100) {
            this.sharePullStreamData = r100;
            return this;
        }

        public Params setShareUserId(String r100) {
            this.shareUserId = r100;
            return this;
        }

        public Params setShopGuideId(String r100) {
            this.shopGuideId = r100;
            return this;
        }

        public Params setSmoothEnter(Boolean r100) {
            this.smoothEnter = r100.booleanValue();
            return this;
        }

        public Params setSource(String r100) {
            this.source = r100;
            return this;
        }

        public Params setSourceBtmToken(String r100) {
            this.sourceBtmToken = r100;
            return this;
        }

        public Params setSourceKey(String r100) {
            this.sourceKey = r100;
            return this;
        }

        public Params setTabId(String r100) {
            this.tabId = r100;
            return this;
        }

        public Params setTabIndex(int r100) {
            this.tabIndex = r100;
            return this;
        }

        public Params setTagIds(String r100) {
            this.tagIds = r100;
            return this;
        }

        public Params setTemplateId(String r100) {
            this.templateId = r100;
            return this;
        }

        public Params setTokenForm(String r100) {
            this.tokenForm = r100;
            return this;
        }

        public Params setTopMsgType(String r100) {
            this.topMessageType = r100;
            return this;
        }

        public Params setTryEnterRoomTime(Long r100) {
            this.tryEnterRoomTime = r100;
            return this;
        }

        public Params setTypeList(int[] r100) {
            this.typeList = r100;
            return this;
        }

        public Params setUseMultiRoomProvider(String r100) {
            this.useMultiRoomProvider = r100;
            return this;
        }

        public Params setUserFrom(long r100) {
            this.userFrom = r100;
            return this;
        }

        public Params setVSEnterType(String r100) {
            this.vsEnterType = r100;
            return this;
        }

        public Params setVideoId(String r100) {
            this.videoId = r100;
            return this;
        }

        public Params setWidgetEnterType(String r100) {
            this.widgetEnterType = r100;
            return this;
        }

        public Params setXiguaUid(String r100) {
            this.xiguaUid = r100;
            return this;
        }

        public Params setOpenPickProfilePanel(boolean r100, boolean r101) {
            this.openPickProfilePanel = r100;
            this.isPickTop = r101;
            return this;
        }
    }

    boolean handleEnterRoom(Context r100, Params r101, T r102);
}
