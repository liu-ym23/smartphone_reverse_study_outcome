package com.bytedance.android.livehostapi.business.depend.share;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.base.model.commerce.DouPlusEntry;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeCorrelationSeasonInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeShare;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.SeasonBriefInfo;
import com.bytedance.android.livesdkapi.depend.model.report.ReportReason;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import py.k;

/* JADX INFO: loaded from: classes7.dex */
public class ShareParams implements IShareParams {
    private static final int SEASON_STATUS_OVER = 2;
    private static final int SEASON_STATUS_UNKNOWN = 0;
    private static final int SEASON_STATUS_UPDATE = 1;
    private static final int SHARE_STATUS_LATEST = 3;
    private static final int SHARE_STATUS_OVER = 2;
    private static final int SHARE_STATUS_UNKNOWN = 0;
    private static final int SHARE_STATUS_UPDATE = 1;
    private HashMap<String, String> activityInfo;
    private k avatarLarge;
    private List<UrlModel> avatarList;
    private k avatarMedium;
    private k avatarThumb;
    private boolean banCopyLinkToastWhenDirectType;
    private ArrayList<String> blackUidList;
    private String broadcastRedPacketSchema;
    private long cameraId;
    private IBaseStreamUrl cameraStreamUrl;
    private int cameraType;
    private long channelId;
    private ShareOutsideDialogParam commandDialogParam;
    private k cover;
    private String coverBottom;
    private String coverMask;
    private String coverMaskForMsg;
    private String coverTop;
    private String currentPeriod;
    private String description;
    private String displayId;
    private DouPlusEntry douPlusEntry;
    private boolean enableLandscapeOpt;
    private boolean enableLandscapePlayerOpt;
    private boolean enableMatchRoomDialogAnim;
    private boolean enablePoster;
    private boolean enablePromotion;
    private boolean enableScreenShot;
    private String enterFrom;
    private String enterMethod;
    private Episode episode;
    private long episodeId;
    private String episodePreviewText;
    private int episodeRecordType;
    private int episodeStage;
    private int episodeSubType;
    private int episodeType;
    private int episodeUpdateStatus;
    private HashMap<String, String> extraParams;
    private Bundle extras;
    private List fansGroups;
    private boolean hideDim;
    private boolean imHalfChatFragmentEnable;
    private Map<String, Map<String, Object>> imUserExtra;
    private String imageUrl;
    private long inviteId;
    private boolean isAnchor;
    private boolean isFastShareInPK;
    private boolean isFriendPrivate;
    private boolean isHalfScreen;
    private boolean isMergeVS;
    private boolean isMultiCamera;
    private boolean isNeedShareToDiary;
    private boolean isNewLiveChannel;
    private boolean isSubCamera;
    private boolean isSubScribeRoom;
    private boolean launchOnly;
    private String lifeExtraInfo;
    private Map<String, String> liveCommonShareParams;
    private WeakReference<ILivePlayerClient> livePlayerClient;
    private LiveWebShareParams liveWebShareParams;
    private String localPath;
    private HashMap<String, String> logExtraParams;
    private String logV3ActionType;
    private Map<String, String> logV3Params;
    private Bundle loginBundle;
    private String loginEnterFrom;
    private LiveQrCodeConfig mLiveQrCodeConfig;
    private long mReportObjectId;
    private String mReportObjectIdStr;
    private long mReportOwnerId;
    private String mReportOwnerIdStr;
    private long matchId;
    private String matchTitle;
    private boolean needVisibilityLimit;
    private String ownerEncryptedIdStr;
    private String ownerId;
    private String ownerIdStr;
    private String ownerName;
    private String ownerSecUid;
    private int paidStatus;
    private int paidType;
    private String pkDefaultInputText;
    private long pkId;
    private String pkTopTitle;
    private String platform;
    private List<ReportReason> reasonList;
    private String requestId;
    private IRoom room;
    private long roomId;
    private String roomMemberCountStr;
    private String roomTitle;
    private String screenshotImageUrl;
    private String shareConfigId;
    private IShareDialogListener shareDialogListener;
    private String shareEnterFrom;
    private String shareEnterMethod;
    private SharePublishParam sharePublishParam;
    private ShareScene shareScene;
    private String shareSceneConfigName;
    private ShareSubScene shareSubScene;
    private long shortId;
    private boolean showVipIM;
    private boolean showVipIMRedDot;
    private long startShareTime;
    private String subScribePaidStatus;
    private String title;
    private long toRoomId;
    private String url;
    private long userId;
    private String userIdStr;
    private String vid;
    private String vipIMUri;
    private IVSPosterClickListener vsPosterClickListener;
    private Map<String, String> vsRoomLog;
    private String vsSceneSource;
    private HashMap<String, String> whiteUidMap;

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.share.ShareParams$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private String actionType;
        private HashMap<String, String> activityInfo;
        private k avatarLarge;
        private List<UrlModel> avatarList;
        private k avatarMedium;
        private k avatarThumb;
        public boolean banCopyLinkToastWhenDirectType;
        private ArrayList<String> blackUidList;
        private String broadcastRedPacketSchema;
        private long channelId;
        private String clickFrom;
        private ShareOutsideDialogParam commandDialogParams;
        private k cover;
        private String coverBottom;
        private String coverMask;
        private String coverMaskForMsg;
        private String coverTop;
        private IVSCameraInfo currentCameraInfo;
        private String currentPeriod;
        private String description;
        private String displayId;
        private DouPlusEntry douPlusEntry;
        private boolean enableLandscapeOpt;
        private boolean enableLandscapePlayerOpt;
        private boolean enableMatchRoomDialogAnim;
        private boolean enablePoster;
        private boolean enablePromotion;
        private boolean enableScreenShot;
        private String enterFrom;
        private String enterMethod;
        private Episode episode;
        private long episodeId;
        private String episodePreviewText;
        private int episodeRecordType;
        private int episodeStage;
        private int episodeSubType;
        private int episodeType;
        private int episodeUpdateStatus;
        private HashMap<String, String> extraParams;
        private Bundle extras;
        private List fansGroups;
        public boolean getPosterWhenDirectType;
        private boolean hideDim;
        private boolean imHalfChatFragmentEnable;
        private Map<String, Map<String, Object>> imUserExtra;
        private String imageUrl;
        private long inviteId;
        private boolean isAnchor;
        private boolean isFastShareInPk;
        private boolean isFriendPrivate;
        private boolean isFromMoreMixShare;
        private boolean isHalfScreen;
        private boolean isMergeVS;
        private boolean isMultiCamera;
        private boolean isNeedShareToDiary;
        private boolean isNewLiveChannel;
        private boolean isSubCamera;
        private boolean isSubScribeRoom;
        private boolean launchOnly;
        private String lifeActionType;
        private String lifeEnterFromMerge;
        private String lifeEnterMethod;
        private String lifeFromUserId;
        private String lifeShareId;
        private HashMap<String, String> liveCommonShareParams;
        private WeakReference<ILivePlayerClient> livePlayerClient;
        private LiveWebShareParams liveWebShareParams;
        private String localPath;
        private HashMap<String, String> logExtraParams;
        private String logV3ActionType;
        private Map<String, String> logV3Params;
        private Bundle loginBundle;
        private String loginEnterFrom;
        private LiveQrCodeConfig mLiveQrCodeConfig;
        private long mReportObjectId;
        private String mReportObjectIdStr;
        private long mReportOwnerId;
        private String mReportOwnerIdStr;
        private String matchTitle;
        private int morePanelShareType;
        private boolean needVisibilityLimit;
        private String ownerEncryptedIdStr;
        private String ownerId;
        private String ownerIdStr;
        private String ownerName;
        private String ownerSecUid;
        private int paidStatus;
        private int paidType;
        private String pkDefaultInputText;
        private long pkId;
        private String pkTopTitle;
        private String platform;
        private List<ReportReason> reasonList;
        private String requestId;
        private IRoom room;
        private long roomId;
        private String roomMemberCountStr;
        private String roomTitle;
        private String screenshotImageUrl;
        private String shareConfigId;
        private IShareDialogListener shareDialogListener;
        private IShareDirectTypeCallback shareDirectTypeCallback;
        private String shareEnterFrom;
        private String shareEnterMethod;
        private SharePublishParam sharePublishParam;
        private ShareScene shareScene;
        private String shareSceneConfigName;
        private ShareSubScene shareSubScene;
        private long shortId;
        private boolean showVipIM;
        private boolean showVipIMRedDot;
        private long startShareTime;
        private String subScribePaidStatus;
        private String title;
        private long toRoomId;
        private String url;
        private long userId;
        private String userIdStr;
        private String vid;
        private String vipIMUri;
        private Map<String, String> vsRoomLog;
        private String vsSceneSource;
        private HashMap<String, String> whiteUidMap;

        public Builder setLaunchOnly() {
            this.launchOnly = true;
            return this;
        }

        public ShareParams build() {
            return new ShareParams(this, null);
        }

        public Bundle getExtras() {
            if (this.extras != null) goto L6;
            this.extras = new Bundle();
        L6:
            return this.extras;
        }

        public ILivePlayerClient getLivePlayerClient() {
            WeakReference<ILivePlayerClient> r100 = this.livePlayerClient;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get();
        }

        public SharePublishParam getSharePublishParam() {
            if (this.sharePublishParam != null) goto L6;
            this.sharePublishParam = new SharePublishParam();
        L6:
            return this.sharePublishParam;
        }

        private Builder() {
            this.url = "";
            this.title = "";
            this.roomTitle = "";
            this.description = "";
            this.imageUrl = "";
            this.localPath = "";
            this.shareSubScene = ShareSubScene.Unknown;
            this.isFastShareInPk = false;
            this.coverTop = "";
            this.coverBottom = "";
            this.coverMask = "";
            this.pkTopTitle = "";
            this.pkDefaultInputText = "";
            this.coverMaskForMsg = "";
            this.enableMatchRoomDialogAnim = false;
            this.enableLandscapePlayerOpt = false;
            this.enableLandscapeOpt = false;
            this.isNeedShareToDiary = false;
            this.enableScreenShot = true;
            this.needVisibilityLimit = false;
            this.morePanelShareType = -1;
            this.clickFrom = "";
            this.shareDirectTypeCallback = null;
            this.getPosterWhenDirectType = false;
            this.banCopyLinkToastWhenDirectType = false;
            this.imHalfChatFragmentEnable = true;
            this.isSubCamera = false;
            this.isMultiCamera = false;
        }

        public boolean enableScreenShot() {
            return this.enableScreenShot;
        }

        public String getClickFrom() {
            return this.clickFrom;
        }

        public IVSCameraInfo getCurrentCameraInfo() {
            return this.currentCameraInfo;
        }

        public HashMap<String, String> getExtraParams() {
            return this.extraParams;
        }

        public String getLifeShareId() {
            return this.lifeShareId;
        }

        public LiveWebShareParams getLiveWebShareParams() {
            return this.liveWebShareParams;
        }

        public HashMap<String, String> getLogExtraParams() {
            return this.logExtraParams;
        }

        public int getMoreShareType() {
            return this.morePanelShareType;
        }

        public String getRequestId() {
            return this.requestId;
        }

        public IShareDirectTypeCallback getShareDirectTypeCallback() {
            return this.shareDirectTypeCallback;
        }

        public boolean isBanCopyLinkToastWhenDirectType() {
            return this.banCopyLinkToastWhenDirectType;
        }

        public boolean isFromMoreMixShare() {
            return this.isFromMoreMixShare;
        }

        public boolean isGetPosterWhenDirectType() {
            return this.getPosterWhenDirectType;
        }

        public boolean isNeedShareToDiary() {
            return this.isNeedShareToDiary;
        }

        public boolean isSubCamera() {
            return this.isSubCamera;
        }

        private Builder(IRoom r100) {
            this.url = "";
            this.title = "";
            this.roomTitle = "";
            this.description = "";
            this.imageUrl = "";
            this.localPath = "";
            this.shareSubScene = ShareSubScene.Unknown;
            this.isFastShareInPk = false;
            this.coverTop = "";
            this.coverBottom = "";
            this.coverMask = "";
            this.pkTopTitle = "";
            this.pkDefaultInputText = "";
            this.coverMaskForMsg = "";
            this.enableMatchRoomDialogAnim = false;
            this.enableLandscapePlayerOpt = false;
            this.enableLandscapeOpt = false;
            this.isNeedShareToDiary = false;
            this.enableScreenShot = true;
            this.needVisibilityLimit = false;
            this.morePanelShareType = -1;
            this.clickFrom = "";
            this.shareDirectTypeCallback = null;
            this.getPosterWhenDirectType = false;
            this.banCopyLinkToastWhenDirectType = false;
            this.imHalfChatFragmentEnable = true;
            this.isSubCamera = false;
            this.isMultiCamera = false;
            this.roomId = r100.getId();
            this.cover = r100.getCover();
            this.requestId = r100.getRequestId();
            this.url = r100.getShareUrl();
            this.title = r100.getTitle();
            this.room = r100;
            this.roomTitle = r100.getTitle();
            IPaidLiveData r101 = r100.getPaidLiveData();
            if (r101 == null) goto L5;
            this.paidType = r101.getPaidType();
            this.paidStatus = r101.getViewRight();
            this.isSubScribeRoom = r100.isPaidSubscribeRoom();
            this.subScribePaidStatus = r101.getSubscribeRoomWatchStatus();
        L5:
            this.isMergeVS = r100.isMergeVSRoom();
            if (r100.getEpisodeExtra() != null) goto L8;
        L10:
            IBaseUser r102 = r100.getOwner();
            if (r102 == null) goto L13;
            this.ownerId = r102.getIdString();
            this.ownerIdStr = r102.getIdString();
            this.ownerEncryptedIdStr = r102.getEncryptedId();
            this.shortId = r102.getShortId();
            this.displayId = r102.getDisplayId();
            this.avatarThumb = r102.getAvatarThumbKt();
            this.avatarMedium = r102.getAvatarMedium();
            this.avatarLarge = r102.getAvatarLarge();
            this.ownerName = r102.getNickName();
            this.displayId = r102.getDisplayId();
            this.ownerSecUid = r102.getCastSecUid();
        L13:
            String r103 = r100.getLifeShareId();
            this.lifeShareId = r103;
            if (TextUtils.isEmpty(r103) == false) goto L16;
            return;
        L16:
            if (this.activityInfo != null) goto L18;
            this.activityInfo = new HashMap();
        L18:
            this.activityInfo.put("life_share_id", this.lifeShareId);
            return;
        L8:
            if (r100.getEpisodeExtra().getMod() == null) goto L10;
            this.episodeStage = r100.getEpisodeExtra().getMod().getEpisodeStage();
            goto L10
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.platform;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.title;
        }

        public static /* synthetic */ String access$1000(Builder r100) {
            return r100.ownerIdStr;
        }

        public static /* synthetic */ boolean access$10000(Builder r100) {
            return r100.isNeedShareToDiary;
        }

        public static /* synthetic */ boolean access$10100(Builder r100) {
            return r100.enableScreenShot;
        }

        public static /* synthetic */ SharePublishParam access$10200(Builder r100) {
            return r100.sharePublishParam;
        }

        public static /* synthetic */ Bundle access$10300(Builder r100) {
            return r100.loginBundle;
        }

        public static /* synthetic */ String access$10400(Builder r100) {
            return r100.loginEnterFrom;
        }

        public static /* synthetic */ String access$10500(Builder r100) {
            return r100.matchTitle;
        }

        public static /* synthetic */ IVSCameraInfo access$10600(Builder r100) {
            return r100.currentCameraInfo;
        }

        public static /* synthetic */ boolean access$10700(Builder r100) {
            return r100.isSubCamera;
        }

        public static /* synthetic */ boolean access$10800(Builder r100) {
            return r100.isMultiCamera;
        }

        public static /* synthetic */ long access$10900(Builder r100) {
            return r100.startShareTime;
        }

        public static /* synthetic */ long access$1100(Builder r100) {
            return r100.shortId;
        }

        public static /* synthetic */ boolean access$11000(Builder r100) {
            return r100.imHalfChatFragmentEnable;
        }

        public static /* synthetic */ String access$11100(Builder r100) {
            return r100.lifeShareId;
        }

        public static /* synthetic */ String access$11200(Builder r100) {
            return r100.actionType;
        }

        public static /* synthetic */ String access$11300(Builder r100) {
            return r100.lifeFromUserId;
        }

        public static /* synthetic */ String access$11400(Builder r100) {
            return r100.lifeEnterFromMerge;
        }

        public static /* synthetic */ String access$11500(Builder r100) {
            return r100.lifeEnterMethod;
        }

        public static /* synthetic */ String access$11600(Builder r100) {
            return r100.lifeActionType;
        }

        public static /* synthetic */ k access$1200(Builder r100) {
            return r100.avatarThumb;
        }

        public static /* synthetic */ k access$1300(Builder r100) {
            return r100.avatarMedium;
        }

        public static /* synthetic */ k access$1400(Builder r100) {
            return r100.avatarLarge;
        }

        public static /* synthetic */ k access$1500(Builder r100) {
            return r100.cover;
        }

        public static /* synthetic */ String access$1600(Builder r100) {
            return r100.ownerName;
        }

        public static /* synthetic */ boolean access$1700(Builder r100) {
            return r100.isAnchor;
        }

        public static /* synthetic */ String access$1800(Builder r100) {
            return r100.requestId;
        }

        public static /* synthetic */ String access$1900(Builder r100) {
            return r100.logV3ActionType;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.description;
        }

        public static /* synthetic */ List access$2000(Builder r100) {
            return r100.reasonList;
        }

        public static /* synthetic */ IRoom access$2100(Builder r100) {
            return r100.room;
        }

        public static /* synthetic */ Map access$2200(Builder r100) {
            return r100.logV3Params;
        }

        public static /* synthetic */ String access$2300(Builder r100) {
            return r100.displayId;
        }

        public static /* synthetic */ String access$2400(Builder r100) {
            return r100.vid;
        }

        public static /* synthetic */ long access$2500(Builder r100) {
            return r100.mReportObjectId;
        }

        public static /* synthetic */ long access$2600(Builder r100) {
            return r100.mReportOwnerId;
        }

        public static /* synthetic */ String access$2700(Builder r100) {
            return r100.mReportObjectIdStr;
        }

        public static /* synthetic */ Episode access$2800(Builder r100) {
            return r100.episode;
        }

        public static /* synthetic */ String access$2900(Builder r100) {
            return r100.mReportOwnerIdStr;
        }

        public static /* synthetic */ String access$300(Builder r100) {
            return r100.imageUrl;
        }

        public static /* synthetic */ String access$3000(Builder r100) {
            return r100.ownerEncryptedIdStr;
        }

        public static /* synthetic */ DouPlusEntry access$3100(Builder r100) {
            return r100.douPlusEntry;
        }

        public static /* synthetic */ String access$3200(Builder r100) {
            return r100.ownerSecUid;
        }

        public static /* synthetic */ boolean access$3300(Builder r100) {
            return r100.launchOnly;
        }

        public static /* synthetic */ String access$3400(Builder r100) {
            return r100.roomMemberCountStr;
        }

        public static /* synthetic */ boolean access$3500(Builder r100) {
            return r100.enablePromotion;
        }

        public static /* synthetic */ ShareScene access$3600(Builder r100) {
            return r100.shareScene;
        }

        public static /* synthetic */ String access$3700(Builder r100) {
            return r100.shareConfigId;
        }

        public static /* synthetic */ ShareSubScene access$3800(Builder r100) {
            return r100.shareSubScene;
        }

        public static /* synthetic */ String access$3900(Builder r100) {
            return r100.shareSceneConfigName;
        }

        public static /* synthetic */ String access$400(Builder r100) {
            return r100.url;
        }

        public static /* synthetic */ HashMap access$4000(Builder r100) {
            return r100.extraParams;
        }

        public static /* synthetic */ HashMap access$4100(Builder r100) {
            return r100.liveCommonShareParams;
        }

        public static /* synthetic */ Map access$4200(Builder r100) {
            return r100.imUserExtra;
        }

        public static /* synthetic */ HashMap access$4300(Builder r100) {
            return r100.logExtraParams;
        }

        public static /* synthetic */ HashMap access$4400(Builder r100) {
            return r100.activityInfo;
        }

        public static /* synthetic */ ShareOutsideDialogParam access$4500(Builder r100) {
            return r100.commandDialogParams;
        }

        public static /* synthetic */ boolean access$4600(Builder r100) {
            return r100.showVipIM;
        }

        public static /* synthetic */ String access$4700(Builder r100) {
            return r100.vipIMUri;
        }

        public static /* synthetic */ boolean access$4800(Builder r100) {
            return r100.showVipIMRedDot;
        }

        public static /* synthetic */ LiveWebShareParams access$4900(Builder r100) {
            return r100.liveWebShareParams;
        }

        public static /* synthetic */ String access$500(Builder r100) {
            return r100.localPath;
        }

        public static /* synthetic */ IShareDialogListener access$5000(Builder r100) {
            return r100.shareDialogListener;
        }

        public static /* synthetic */ boolean access$5100(Builder r100) {
            return r100.hideDim;
        }

        public static /* synthetic */ boolean access$5200(Builder r100) {
            return r100.isFastShareInPk;
        }

        public static /* synthetic */ String access$5300(Builder r100) {
            return r100.coverTop;
        }

        public static /* synthetic */ String access$5400(Builder r100) {
            return r100.coverBottom;
        }

        public static /* synthetic */ String access$5500(Builder r100) {
            return r100.coverMask;
        }

        public static /* synthetic */ String access$5600(Builder r100) {
            return r100.pkDefaultInputText;
        }

        public static /* synthetic */ String access$5700(Builder r100) {
            return r100.coverMaskForMsg;
        }

        public static /* synthetic */ boolean access$5800(Builder r100) {
            return r100.enableMatchRoomDialogAnim;
        }

        public static /* synthetic */ long access$5900(Builder r100) {
            return r100.pkId;
        }

        public static /* synthetic */ long access$600(Builder r100) {
            return r100.roomId;
        }

        public static /* synthetic */ long access$6000(Builder r100) {
            return r100.toRoomId;
        }

        public static /* synthetic */ String access$6100(Builder r100) {
            return r100.broadcastRedPacketSchema;
        }

        public static /* synthetic */ long access$6200(Builder r100) {
            return r100.channelId;
        }

        public static /* synthetic */ String access$6300(Builder r100) {
            return r100.pkTopTitle;
        }

        public static /* synthetic */ String access$6400(Builder r100) {
            return r100.roomTitle;
        }

        public static /* synthetic */ List access$6500(Builder r100) {
            return r100.fansGroups;
        }

        public static /* synthetic */ boolean access$6600(Builder r100) {
            return r100.enablePoster;
        }

        public static /* synthetic */ Bundle access$6700(Builder r100) {
            return r100.extras;
        }

        public static /* synthetic */ long access$6800(Builder r100) {
            return r100.episodeId;
        }

        public static /* synthetic */ int access$6900(Builder r100) {
            return r100.episodeStage;
        }

        public static /* synthetic */ String access$700(Builder r100) {
            return r100.ownerId;
        }

        public static /* synthetic */ int access$7000(Builder r100) {
            return r100.episodeSubType;
        }

        public static /* synthetic */ int access$7100(Builder r100) {
            return r100.episodeType;
        }

        public static /* synthetic */ String access$7200(Builder r100) {
            return r100.currentPeriod;
        }

        public static /* synthetic */ String access$7300(Builder r100) {
            return r100.vsSceneSource;
        }

        public static /* synthetic */ int access$7400(Builder r100) {
            return r100.episodeUpdateStatus;
        }

        public static /* synthetic */ boolean access$7500(Builder r100) {
            return r100.enableLandscapePlayerOpt;
        }

        public static /* synthetic */ boolean access$7600(Builder r100) {
            return r100.enableLandscapeOpt;
        }

        public static /* synthetic */ String access$7700(Builder r100) {
            return r100.episodePreviewText;
        }

        public static /* synthetic */ int access$7800(Builder r100) {
            return r100.episodeRecordType;
        }

        public static /* synthetic */ Map access$7900(Builder r100) {
            return r100.vsRoomLog;
        }

        public static /* synthetic */ long access$800(Builder r100) {
            return r100.userId;
        }

        public static /* synthetic */ List access$8000(Builder r100) {
            return r100.avatarList;
        }

        public static /* synthetic */ String access$8100(Builder r100) {
            return r100.screenshotImageUrl;
        }

        public static /* synthetic */ String access$8200(Builder r100) {
            return r100.enterFrom;
        }

        public static /* synthetic */ String access$8300(Builder r100) {
            return r100.enterMethod;
        }

        public static /* synthetic */ String access$8400(Builder r100) {
            return r100.shareEnterMethod;
        }

        public static /* synthetic */ String access$8500(Builder r100) {
            return r100.shareEnterFrom;
        }

        public static /* synthetic */ int access$8600(Builder r100) {
            return r100.paidType;
        }

        public static /* synthetic */ boolean access$8700(Builder r100) {
            return r100.isSubScribeRoom;
        }

        public static /* synthetic */ int access$8800(Builder r100) {
            return r100.paidStatus;
        }

        public static /* synthetic */ String access$8900(Builder r100) {
            return r100.subScribePaidStatus;
        }

        public static /* synthetic */ String access$900(Builder r100) {
            return r100.userIdStr;
        }

        public static /* synthetic */ boolean access$9000(Builder r100) {
            return r100.needVisibilityLimit;
        }

        public static /* synthetic */ boolean access$9100(Builder r100) {
            return r100.isFriendPrivate;
        }

        public static /* synthetic */ HashMap access$9200(Builder r100) {
            return r100.whiteUidMap;
        }

        public static /* synthetic */ long access$9300(Builder r100) {
            return r100.inviteId;
        }

        public static /* synthetic */ boolean access$9400(Builder r100) {
            return r100.isNewLiveChannel;
        }

        public static /* synthetic */ ArrayList access$9500(Builder r100) {
            return r100.blackUidList;
        }

        public static /* synthetic */ boolean access$9600(Builder r100) {
            return r100.isMergeVS;
        }

        public static /* synthetic */ LiveQrCodeConfig access$9700(Builder r100) {
            return r100.mLiveQrCodeConfig;
        }

        public static /* synthetic */ boolean access$9800(Builder r100) {
            return r100.isHalfScreen;
        }

        public static /* synthetic */ WeakReference access$9900(Builder r100) {
            return r100.livePlayerClient;
        }

        public Builder setActionType(String r100) {
            this.actionType = r100;
            return this;
        }

        public Builder setActivityInfo(HashMap<String, String> r100) {
            this.activityInfo = r100;
            return this;
        }

        public Builder setAnchor(boolean r100) {
            this.isAnchor = r100;
            return this;
        }

        public Builder setAvatarList(List<UrlModel> r100) {
            this.avatarList = r100;
            return this;
        }

        public Builder setBanCopyLinkToastWhenDirectType(boolean r100) {
            this.banCopyLinkToastWhenDirectType = r100;
            return this;
        }

        public Builder setBlackUidList(ArrayList<String> r100) {
            this.blackUidList = r100;
            return this;
        }

        public Builder setBroadcastRedPacketSchema(String r100) {
            this.broadcastRedPacketSchema = r100;
            return this;
        }

        public Builder setChannelId(long r100) {
            this.channelId = r100;
            return this;
        }

        public void setClickFrom(String r100) {
            this.clickFrom = r100;
        }

        public Builder setCover(k r100) {
            this.cover = r100;
            return this;
        }

        public Builder setCoverBottom(String r100) {
            this.coverBottom = r100;
            return this;
        }

        public Builder setCoverMask(String r100) {
            this.coverMask = r100;
            return this;
        }

        public Builder setCoverMaskForMsg(String r100) {
            this.coverMaskForMsg = r100;
            return this;
        }

        public Builder setCoverTop(String r100) {
            this.coverTop = r100;
            return this;
        }

        public Builder setCurrentCameraInfo(IVSCameraInfo r100) {
            this.currentCameraInfo = r100;
            return this;
        }

        public Builder setCurrentPeriod(String r100) {
            this.currentPeriod = r100;
            return this;
        }

        public Builder setCustomCommandDialogParam(ShareOutsideDialogParam r100) {
            this.commandDialogParams = r100;
            return this;
        }

        public Builder setDescription(String r100) {
            this.description = r100;
            return this;
        }

        public Builder setDouPlusEntry(DouPlusEntry r100) {
            this.douPlusEntry = r100;
            return this;
        }

        public Builder setEnableLandscapeOpt(boolean r100) {
            this.enableLandscapeOpt = r100;
            return this;
        }

        public Builder setEnableLandscapePlayerOpt(boolean r100) {
            this.enableLandscapePlayerOpt = r100;
            return this;
        }

        public Builder setEnableMatchRoomDialogAnim(boolean r100) {
            this.enableMatchRoomDialogAnim = r100;
            return this;
        }

        public Builder setEnablePoster(boolean r100) {
            this.enablePoster = r100;
            return this;
        }

        public Builder setEnablePromotion(boolean r100) {
            this.enablePromotion = r100;
            return this;
        }

        public Builder setEnableScreenShot(boolean r100) {
            this.enableScreenShot = r100;
            return this;
        }

        public Builder setEnterFrom(String r100) {
            this.enterFrom = r100;
            return this;
        }

        public Builder setEnterMethod(String r100) {
            this.enterMethod = r100;
            return this;
        }

        public Builder setEpisodeId(long r100) {
            this.episodeId = r100;
            return this;
        }

        public Builder setEpisodeRecordType(int r100) {
            this.episodeRecordType = r100;
            return this;
        }

        public Builder setEpisodeStage(int r100) {
            this.episodeStage = r100;
            return this;
        }

        public Builder setEpisodeSubType(int r100) {
            this.episodeSubType = r100;
            return this;
        }

        public Builder setEpisodeType(int r100) {
            this.episodeType = r100;
            return this;
        }

        public Builder setExtraParams(HashMap<String, String> r100) {
            this.extraParams = r100;
            return this;
        }

        public Builder setFansGroups(List r100) {
            this.fansGroups = r100;
            return this;
        }

        public Builder setFriendPrivate(boolean r100) {
            this.isFriendPrivate = r100;
            return this;
        }

        public Builder setFromMoreMixShare(boolean r100) {
            this.isFromMoreMixShare = r100;
            return this;
        }

        public Builder setGetPosterWhenDirectType(boolean r100) {
            this.getPosterWhenDirectType = r100;
            return this;
        }

        public Builder setHideDim(boolean r100) {
            this.hideDim = r100;
            return this;
        }

        public void setIMUserExtra(Map<String, Map<String, Object>> r100) {
            this.imUserExtra = r100;
        }

        public Builder setImHalfChatFragmentEnable(boolean r100) {
            this.imHalfChatFragmentEnable = r100;
            return this;
        }

        public Builder setImageUrl(String r100) {
            this.imageUrl = r100;
            return this;
        }

        public Builder setInviteId(long r100) {
            this.inviteId = r100;
            return this;
        }

        public Builder setIsFastShareInPk(boolean r100) {
            this.isFastShareInPk = r100;
            return this;
        }

        public Builder setIsHalfScreen(boolean r100) {
            this.isHalfScreen = r100;
            return this;
        }

        public Builder setIsMergeVS(boolean r100) {
            this.isMergeVS = r100;
            return this;
        }

        public Builder setIsNewLiveChannel(boolean r100) {
            this.isNewLiveChannel = r100;
            return this;
        }

        public Builder setLifeActionType(String r100) {
            this.lifeActionType = r100;
            return this;
        }

        public Builder setLifeEnterFromMerge(String r100) {
            this.lifeEnterFromMerge = r100;
            return this;
        }

        public Builder setLifeEnterMethod(String r100) {
            this.lifeEnterMethod = r100;
            return this;
        }

        public Builder setLifeFromUserId(String r100) {
            this.lifeFromUserId = r100;
            return this;
        }

        public void setLifeShareId(String r100) {
            this.lifeShareId = r100;
        }

        public void setLiveCommonShareParams(HashMap<String, String> r100) {
            this.liveCommonShareParams = r100;
        }

        public Builder setLivePlayerClient(ILivePlayerClient r100) {
            this.livePlayerClient = new WeakReference(r100);
            return this;
        }

        public Builder setLiveQrCodeConfig(LiveQrCodeConfig r100) {
            this.mLiveQrCodeConfig = r100;
            return this;
        }

        public Builder setLiveWebShareParams(LiveWebShareParams r100) {
            this.liveWebShareParams = r100;
            return this;
        }

        public Builder setLocalFilePath(String r100) {
            this.localPath = r100;
            return this;
        }

        public Builder setLogExtraParams(HashMap<String, String> r100) {
            this.logExtraParams = r100;
            return this;
        }

        public Builder setLogV3ActionType(String r100) {
            this.logV3ActionType = r100;
            return this;
        }

        public Builder setLogV3Params(Map<String, String> r100) {
            this.logV3Params = r100;
            return this;
        }

        public Builder setLoginBundle(Bundle r100) {
            this.loginBundle = r100;
            return this;
        }

        public Builder setLoginEnterFrom(String r100) {
            this.loginEnterFrom = r100;
            return this;
        }

        public Builder setMatchTitle(String r100) {
            this.matchTitle = r100;
            return this;
        }

        public Builder setMoreShareType(int r100) {
            this.morePanelShareType = r100;
            return this;
        }

        public Builder setMultiCamera(boolean r100) {
            this.isMultiCamera = r100;
            return this;
        }

        public Builder setNeedShareToDiary(boolean r100) {
            this.isNeedShareToDiary = r100;
            return this;
        }

        public Builder setNeedVisibilityLimit(boolean r100) {
            this.needVisibilityLimit = r100;
            return this;
        }

        public Builder setOwenerSecUid(String r100) {
            this.ownerSecUid = r100;
            return this;
        }

        public Builder setPkDefaultInputText(String r100) {
            this.pkDefaultInputText = r100;
            return this;
        }

        public Builder setPkId(long r100) {
            this.pkId = r100;
            return this;
        }

        public Builder setPkTopTitle(String r100) {
            this.pkTopTitle = r100;
            return this;
        }

        public Builder setPlatform(String r100) {
            this.platform = r100;
            return this;
        }

        public Builder setReason(List<ReportReason> r100) {
            this.reasonList = r100;
            return this;
        }

        public void setReportObjectId(long r100) {
            this.mReportObjectId = r100;
            this.mReportObjectIdStr = String.valueOf(r100);
        }

        public void setReportObjectIdStr(String r100) {
            this.mReportObjectIdStr = r100;
        }

        public void setReportOwnerId(long r100) {
            this.mReportOwnerId = r100;
            this.mReportOwnerIdStr = String.valueOf(r100);
        }

        public void setReportOwnerIdStr(String r100) {
            this.mReportOwnerIdStr = r100;
        }

        public void setRequestId(String r100) {
            this.requestId = r100;
        }

        public Builder setRoom(IRoom r100) {
            this.room = r100;
            return this;
        }

        public void setRoomId(long r100) {
            this.roomId = r100;
        }

        public Builder setRoomIdWithChain(long r100) {
            this.roomId = r100;
            return this;
        }

        public Builder setRoomMemberCountStr(String r100) {
            this.roomMemberCountStr = r100;
            return this;
        }

        public Builder setScreenshotImageUrl(String r100) {
            this.screenshotImageUrl = r100;
            return this;
        }

        public Builder setShareConfigId(String r100) {
            this.shareConfigId = r100;
            return this;
        }

        public Builder setShareDialogListener(IShareDialogListener r100) {
            this.shareDialogListener = r100;
            return this;
        }

        public Builder setShareDirectTypeCallback(IShareDirectTypeCallback r100) {
            this.shareDirectTypeCallback = r100;
            return this;
        }

        public Builder setShareEnterFrom(String r100) {
            this.shareEnterFrom = r100;
            return this;
        }

        public Builder setShareEnterMethod(String r100) {
            this.shareEnterMethod = r100;
            return this;
        }

        public Builder setSharePublishParam(SharePublishParam r100) {
            this.sharePublishParam = r100;
            return this;
        }

        public void setShareScene(ShareScene r100) {
            this.shareScene = r100;
        }

        public Builder setShareSceneConfigName(String r100) {
            this.shareSceneConfigName = r100;
            return this;
        }

        public Builder setShareSubScene(ShareSubScene r100) {
            this.shareSubScene = r100;
            return this;
        }

        public Builder setShowVipIM(boolean r100) {
            this.showVipIM = r100;
            return this;
        }

        public Builder setShowVipIMRedDot(boolean r100) {
            this.showVipIMRedDot = r100;
            return this;
        }

        public Builder setStartShareTime(long r100) {
            this.startShareTime = r100;
            return this;
        }

        public Builder setSubCamera(boolean r100) {
            this.isSubCamera = r100;
            return this;
        }

        public Builder setTitle(String r100) {
            this.title = r100;
            return this;
        }

        public Builder setToRoomId(long r100) {
            this.toRoomId = r100;
            return this;
        }

        public Builder setUrl(String r100) {
            this.url = r100;
            return this;
        }

        public Builder setUserId(String r100) {
            n0.d();
            this.userId = 0;
            this.userIdStr = r100;
            return this;
        }

        public Builder setVSRoomLog(Map<String, String> r100) {
            this.vsRoomLog = r100;
            return this;
        }

        public Builder setVSSceneSource(String r100) {
            this.vsSceneSource = r100;
            return this;
        }

        public Builder setVid(String r100) {
            this.vid = r100;
            return this;
        }

        public Builder setVipIMUri(String r100) {
            this.vipIMUri = r100;
            return this;
        }

        public Builder setWhiteUidMap(HashMap<String, String> r100) {
            this.whiteUidMap = r100;
            return this;
        }

        private Builder(Episode r100) {
            this.url = "";
            this.title = "";
            this.roomTitle = "";
            this.description = "";
            this.imageUrl = "";
            this.localPath = "";
            this.shareSubScene = ShareSubScene.Unknown;
            this.isFastShareInPk = false;
            this.coverTop = "";
            this.coverBottom = "";
            this.coverMask = "";
            this.pkTopTitle = "";
            this.pkDefaultInputText = "";
            this.coverMaskForMsg = "";
            this.enableMatchRoomDialogAnim = false;
            this.enableLandscapePlayerOpt = false;
            this.enableLandscapeOpt = false;
            this.isNeedShareToDiary = false;
            this.enableScreenShot = true;
            this.needVisibilityLimit = false;
            this.morePanelShareType = -1;
            this.clickFrom = "";
            this.shareDirectTypeCallback = null;
            this.getPosterWhenDirectType = false;
            this.banCopyLinkToastWhenDirectType = false;
            this.imHalfChatFragmentEnable = true;
            this.isSubCamera = false;
            this.isMultiCamera = false;
            this.episode = r100;
            this.episodeId = r100.getIdExt();
            this.cover = r100.cover();
            this.requestId = r100.getRequestId();
            EpisodeShare r101 = r100.share;
            if (r101 == null) goto L5;
            this.url = r101.shareUrl;
        L5:
            this.title = r100.title();
            EpisodeMod r102 = r100.episodeMod;
            if (r102 == null) goto L8;
            this.currentPeriod = r100.currentPeriod;
            this.episodeStage = r102.episodeStage;
            this.episodeRecordType = r102.episodeRecordType;
            this.episodeType = r102.episodeType;
            this.episodeSubType = r102.episodeSubType;
        L8:
            EpisodeCorrelationSeasonInfo r103 = r100.episodeCorrelationSeasonInfo;
            if (r103 == null) goto L14;
            SeasonBriefInfo r104 = r103.seasonBriefInfo;
            if (r104 == null) goto L14;
            this.episodePreviewText = r104.getPreviewText();
        L14:
            if (r100.getPeriod() == ((int) r100.getLatestPeriod())) goto L16;
        L18:
            this.episodeUpdateStatus = r100.seasonUpdateStatus;
        L19:
            IBaseUser r105 = r100.getOwner();
            if (r105 == null) goto L23;
            this.ownerId = r105.getIdString();
            this.ownerIdStr = r105.getIdString();
            this.ownerEncryptedIdStr = r105.getEncryptedId();
            this.shortId = r105.getShortId();
            this.displayId = r105.getDisplayId();
            this.avatarThumb = r105.getAvatarThumbKt();
            this.avatarMedium = r105.getAvatarMedium();
            this.avatarLarge = r105.getAvatarLarge();
            this.ownerName = r105.getNickName();
            this.displayId = r105.getDisplayId();
            this.ownerSecUid = r105.getCastSecUid();
            return;
        L23:
            return;
        L16:
            if (r100.getSeasonUpdateStatus() != 1) goto L18;
            this.episodeUpdateStatus = 3;
            goto L19
        }

        public Builder setLivePlayerClient(WeakReference<ILivePlayerClient> r100) {
            this.livePlayerClient = r100;
            return this;
        }

        public Builder setUserId(long r100) {
            this.userId = r100;
            this.userIdStr = String.valueOf(r100);
            return this;
        }

        private Builder(IBaseUser r100) {
            this.url = "";
            this.title = "";
            this.roomTitle = "";
            this.description = "";
            this.imageUrl = "";
            this.localPath = "";
            this.shareSubScene = ShareSubScene.Unknown;
            this.isFastShareInPk = false;
            this.coverTop = "";
            this.coverBottom = "";
            this.coverMask = "";
            this.pkTopTitle = "";
            this.pkDefaultInputText = "";
            this.coverMaskForMsg = "";
            this.enableMatchRoomDialogAnim = false;
            this.enableLandscapePlayerOpt = false;
            this.enableLandscapeOpt = false;
            this.isNeedShareToDiary = false;
            this.enableScreenShot = true;
            this.needVisibilityLimit = false;
            this.morePanelShareType = -1;
            this.clickFrom = "";
            this.shareDirectTypeCallback = null;
            this.getPosterWhenDirectType = false;
            this.banCopyLinkToastWhenDirectType = false;
            this.imHalfChatFragmentEnable = true;
            this.isSubCamera = false;
            this.isMultiCamera = false;
            if (r100 == null) goto L6;
            this.ownerId = r100.getIdString();
            this.ownerIdStr = r100.getIdString();
            this.ownerEncryptedIdStr = r100.getEncryptedId();
            this.shortId = r100.getShortId();
            this.displayId = r100.getDisplayId();
            this.avatarThumb = r100.getAvatarThumbKt();
            this.avatarMedium = r100.getAvatarMedium();
            this.avatarLarge = r100.getAvatarLarge();
            this.ownerName = r100.getNickName();
            this.displayId = r100.getDisplayId();
            this.ownerSecUid = r100.getCastSecUid();
            return;
        }

        private Builder(ShareScene r100) {
            this.url = "";
            this.title = "";
            this.roomTitle = "";
            this.description = "";
            this.imageUrl = "";
            this.localPath = "";
            this.shareSubScene = ShareSubScene.Unknown;
            this.isFastShareInPk = false;
            this.coverTop = "";
            this.coverBottom = "";
            this.coverMask = "";
            this.pkTopTitle = "";
            this.pkDefaultInputText = "";
            this.coverMaskForMsg = "";
            this.enableMatchRoomDialogAnim = false;
            this.enableLandscapePlayerOpt = false;
            this.enableLandscapeOpt = false;
            this.isNeedShareToDiary = false;
            this.enableScreenShot = true;
            this.needVisibilityLimit = false;
            this.morePanelShareType = -1;
            this.clickFrom = "";
            this.shareDirectTypeCallback = null;
            this.getPosterWhenDirectType = false;
            this.banCopyLinkToastWhenDirectType = false;
            this.imHalfChatFragmentEnable = true;
            this.isSubCamera = false;
            this.isMultiCamera = false;
            this.shareScene = r100;
        }

        private Builder(String r100) {
            this.url = "";
            this.title = "";
            this.roomTitle = "";
            this.description = "";
            this.imageUrl = "";
            this.localPath = "";
            this.shareSubScene = ShareSubScene.Unknown;
            this.isFastShareInPk = false;
            this.coverTop = "";
            this.coverBottom = "";
            this.coverMask = "";
            this.pkTopTitle = "";
            this.pkDefaultInputText = "";
            this.coverMaskForMsg = "";
            this.enableMatchRoomDialogAnim = false;
            this.enableLandscapePlayerOpt = false;
            this.enableLandscapeOpt = false;
            this.isNeedShareToDiary = false;
            this.enableScreenShot = true;
            this.needVisibilityLimit = false;
            this.morePanelShareType = -1;
            this.clickFrom = "";
            this.shareDirectTypeCallback = null;
            this.getPosterWhenDirectType = false;
            this.banCopyLinkToastWhenDirectType = false;
            this.imHalfChatFragmentEnable = true;
            this.isSubCamera = false;
            this.isMultiCamera = false;
            this.localPath = r100;
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        private Builder(Episode r100, Boolean r101) {
            this.url = "";
            this.title = "";
            this.roomTitle = "";
            this.description = "";
            this.imageUrl = "";
            this.localPath = "";
            this.shareSubScene = ShareSubScene.Unknown;
            this.isFastShareInPk = false;
            this.coverTop = "";
            this.coverBottom = "";
            this.coverMask = "";
            this.pkTopTitle = "";
            this.pkDefaultInputText = "";
            this.coverMaskForMsg = "";
            this.enableMatchRoomDialogAnim = false;
            this.enableLandscapePlayerOpt = false;
            this.enableLandscapeOpt = false;
            this.isNeedShareToDiary = false;
            this.enableScreenShot = true;
            this.needVisibilityLimit = false;
            this.morePanelShareType = -1;
            this.clickFrom = "";
            this.shareDirectTypeCallback = null;
            this.getPosterWhenDirectType = false;
            this.banCopyLinkToastWhenDirectType = false;
            this.imHalfChatFragmentEnable = true;
            this.isSubCamera = false;
            this.isMultiCamera = false;
            if (r100 != null) goto L5;
            return;
        L5:
            this.episode = r100;
            this.episodeId = r100.getIdExt();
            this.cover = r100.cover();
            this.roomId = r100.roomId;
            this.requestId = r100.getRequestId();
            EpisodeShare r102 = r100.share;
            if (r102 == null) goto L8;
            this.url = r102.shareUrl;
            this.description = r102.userShareText;
        L8:
            this.enterFrom = ILiveRoomPlayFragmentConstant.EXTRA_REPLAY_SHARE_ENTER_FROM;
            this.title = r100.title();
            EpisodeMod r103 = r100.episodeMod;
            if (r103 == null) goto L14;
            this.currentPeriod = r100.currentPeriod;
            int r104 = r103.episodeStage;
            this.episodeStage = r104;
            if (r104 != 4) goto L13;
            this.shareScene = ShareScene.REPLAY;
            this.shareConfigId = "15820";
        L13:
            this.episodeRecordType = r103.episodeRecordType;
            this.episodeType = r103.episodeType;
            this.episodeSubType = r103.episodeSubType;
        L14:
            EpisodeCorrelationSeasonInfo r105 = r100.episodeCorrelationSeasonInfo;
            if (r105 == null) goto L20;
            SeasonBriefInfo r106 = r105.seasonBriefInfo;
            if (r106 == null) goto L20;
            this.episodePreviewText = r106.getPreviewText();
        L20:
            if (r100.period == ((int) r100.latestPeriod)) goto L22;
        L24:
            this.episodeUpdateStatus = r100.seasonUpdateStatus;
        L25:
            IBaseUser r107 = r100.getOwner();
            if (r107 == null) goto L29;
            this.ownerId = r107.getIdString();
            this.ownerIdStr = r107.getIdString();
            this.ownerEncryptedIdStr = r107.getEncryptedId();
            this.shortId = r107.getShortId();
            this.displayId = r107.getDisplayId();
            this.avatarThumb = r107.getAvatarThumbKt();
            this.avatarMedium = r107.getAvatarMedium();
            this.avatarLarge = r107.getAvatarLarge();
            this.ownerName = r107.getNickName();
            this.displayId = r107.getDisplayId();
            this.ownerSecUid = r107.getCastSecUid();
            return;
        L29:
            return;
        L22:
            if (r100.seasonUpdateStatus != 1) goto L24;
            this.episodeUpdateStatus = 3;
            goto L25
        }

        public Builder setUrl(String r100, Map<String, String> r101) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return this;
        L5:
            UrlBuilder r102 = new UrlBuilder(r100);
            if (r101 == null) goto L11;
            Iterator<String> r103 = r101.keySet().iterator();
        L9:
            if (r103.hasNext() == false) goto L11;
            String r104 = r103.next();
            r102.addParam(r104, r101.get(r104));
        L11:
            this.url = r102.build();
            return this;
        }

        private Builder(String r100, String r101) {
            this.url = "";
            this.title = "";
            this.roomTitle = "";
            this.description = "";
            this.imageUrl = "";
            this.localPath = "";
            this.shareSubScene = ShareSubScene.Unknown;
            this.isFastShareInPk = false;
            this.coverTop = "";
            this.coverBottom = "";
            this.coverMask = "";
            this.pkTopTitle = "";
            this.pkDefaultInputText = "";
            this.coverMaskForMsg = "";
            this.enableMatchRoomDialogAnim = false;
            this.enableLandscapePlayerOpt = false;
            this.enableLandscapeOpt = false;
            this.isNeedShareToDiary = false;
            this.enableScreenShot = true;
            this.needVisibilityLimit = false;
            this.morePanelShareType = -1;
            this.clickFrom = "";
            this.shareDirectTypeCallback = null;
            this.getPosterWhenDirectType = false;
            this.banCopyLinkToastWhenDirectType = false;
            this.imHalfChatFragmentEnable = true;
            this.isSubCamera = false;
            this.isMultiCamera = false;
            this.mReportObjectId = d5.c(r100);
            n0.d();
            this.mReportOwnerId = 0;
            this.mReportObjectIdStr = String.valueOf(r100);
            this.mReportOwnerIdStr = String.valueOf(r101);
        }

        private Builder(long r100, long r101) {
            this.url = "";
            this.title = "";
            this.roomTitle = "";
            this.description = "";
            this.imageUrl = "";
            this.localPath = "";
            this.shareSubScene = ShareSubScene.Unknown;
            this.isFastShareInPk = false;
            this.coverTop = "";
            this.coverBottom = "";
            this.coverMask = "";
            this.pkTopTitle = "";
            this.pkDefaultInputText = "";
            this.coverMaskForMsg = "";
            this.enableMatchRoomDialogAnim = false;
            this.enableLandscapePlayerOpt = false;
            this.enableLandscapeOpt = false;
            this.isNeedShareToDiary = false;
            this.enableScreenShot = true;
            this.needVisibilityLimit = false;
            this.morePanelShareType = -1;
            this.clickFrom = "";
            this.shareDirectTypeCallback = null;
            this.getPosterWhenDirectType = false;
            this.banCopyLinkToastWhenDirectType = false;
            this.imHalfChatFragmentEnable = true;
            this.isSubCamera = false;
            this.isMultiCamera = false;
            this.mReportObjectId = r100;
            this.mReportOwnerId = r101;
            this.mReportObjectIdStr = String.valueOf(r100);
            this.mReportOwnerIdStr = String.valueOf(r101);
        }

        public /* synthetic */ Builder(IBaseUser r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Builder(ShareScene r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Builder(IRoom r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Builder(Episode r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Builder(long r100, long r101, AnonymousClass1 r102) {
            this(r100, r101);
        }

        public /* synthetic */ Builder(Episode r100, Boolean r101, AnonymousClass1 r102) {
            this(r100, r101);
        }

        public /* synthetic */ Builder(String r100, String r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public HashMap<String, String> getActivityInfo() {
        if (this.activityInfo != null) goto L6;
        this.activityInfo = new HashMap();
    L6:
        return this.activityInfo;
    }

    public ShareOutsideDialogParam getCommandShareParams() {
        if (this.commandDialogParam != null) goto L6;
        this.commandDialogParam = new ShareOutsideDialogParam();
    L6:
        return this.commandDialogParam;
    }

    public DouPlusEntry getDouPlusEntry() {
        DouPlusEntry r100 = this.douPlusEntry;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return DouPlusEntry.defaultOne();
    }

    public HashMap<String, String> getExtraParams() {
        if (this.extraParams != null) goto L6;
        this.extraParams = new HashMap();
    L6:
        return this.extraParams;
    }

    public Bundle getExtras() {
        Bundle r100 = this.extras;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new Bundle();
    }

    public ILivePlayerClient getLivePlayerClient() {
        WeakReference<ILivePlayerClient> r100 = this.livePlayerClient;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public HashMap<String, String> getLogExtraParams() {
        if (this.logExtraParams != null) goto L6;
        this.logExtraParams = new HashMap();
    L6:
        return this.logExtraParams;
    }

    public String getOwnerId() {
        String r100 = this.ownerId;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getOwnerIdStr() {
        String r100 = this.ownerIdStr;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public SharePublishParam getSharePublishParam() {
        if (this.sharePublishParam != null) goto L6;
        this.sharePublishParam = new SharePublishParam();
    L6:
        return this.sharePublishParam;
    }

    public String toString() {
        return "ShareParams{platform='" + this.platform + "', userIdStr=" + this.userIdStr + ", roomId=" + this.roomId + ", ownerId=" + this.ownerId + ", ownerIdStr='" + this.ownerIdStr + "', ownerEncryptedIdStr='" + this.ownerEncryptedIdStr + "', shortId=" + this.shortId + ", displayId='" + this.displayId + "', avatarThumb=" + this.avatarThumb + ", avatarMedium=" + this.avatarMedium + ", avatarLarge=" + this.avatarLarge + ", cover=" + this.cover + ", ownerName='" + this.ownerName + "', url='" + this.url + "', title='" + this.title + "', roomTitle='" + this.roomTitle + "', description='" + this.description + "', imageUrl='" + this.imageUrl + "', localPath='" + this.localPath + "', isAnchor=" + this.isAnchor + ", requestId='" + this.requestId + "', logV3ActionType='" + this.logV3ActionType + "', douPlusEntry=" + this.douPlusEntry + ", vid='" + this.vid + "', ownerSecUid='" + this.ownerSecUid + "', launchOnly=" + this.launchOnly + ", enablePromotion=" + this.enablePromotion + ", showVipIM=" + this.showVipIM + ", vipIMUri='" + this.vipIMUri + "', showVipIMRedDot=" + this.showVipIMRedDot + ", fansGroups=" + this.fansGroups + ", enablePoster=" + this.enablePoster + ", logV3Params=" + this.logV3Params + ", mReportObjectId=" + this.mReportObjectId + ", mReportOwnerId=" + this.mReportOwnerId + ", reasonList=" + this.reasonList + ", room=" + this.room + ", shareScene=" + this.shareScene + ", shareSubScene=" + this.shareSubScene + ", extraParams=" + this.extraParams + ", logExtraParams=" + this.logExtraParams + ", activityInfo=" + this.activityInfo + ", commandDialogParam=" + this.commandDialogParam + ", sharePublishParam=" + this.sharePublishParam + ", shareConfigId=" + this.shareConfigId + ", shareSceneConfigName=" + this.shareSceneConfigName + ", roomMemberCountStr='" + this.roomMemberCountStr + "', shareDialogListener=" + this.shareDialogListener + ", hideDim=" + this.hideDim + ", isFastShareInPK=" + this.isFastShareInPK + ", coverTop='" + this.coverTop + "', coverBottom='" + this.coverBottom + "', coverMask='" + this.coverMask + "', pkTopTitle='" + this.pkTopTitle + "', pkDefaultInputText='" + this.pkDefaultInputText + "', coverMaskForMsg='" + this.coverMaskForMsg + "', enableMatchRoomDialogAnim=" + this.enableMatchRoomDialogAnim + ", pkId=" + this.pkId + ", channelId=" + this.channelId + ", toRoomId=" + this.toRoomId + ", liveWebShareParams=" + this.liveWebShareParams + ", extras=" + this.extras + ", episodeId=" + this.episodeId + ", episodeStage=" + this.episodeStage + ", episodeRecordType=" + this.episodeRecordType + ", episodeSubType=" + this.episodeSubType + ", episodeType=" + this.episodeType + ", paidType=" + this.paidType + ", paidStatus=" + this.paidStatus + ", subScribePaidStatus=" + this.subScribePaidStatus + ", isSubScribeRoom=" + this.isSubScribeRoom + ", currentPeriod='" + this.currentPeriod + "', vsRoomLog=" + this.vsRoomLog + ", avatarList=" + this.avatarList + ",inviteId=" + this.inviteId + ", screenshotImageUrl='" + this.screenshotImageUrl + "', enterFrom='" + this.enterFrom + "', needVisibilityLimit=" + this.needVisibilityLimit + ", isFriendPrivate=" + this.isFriendPrivate + ", whiteUidMap=" + this.whiteUidMap + ", blackUidList=" + this.blackUidList + ", isMergeVS=" + this.isMergeVS + ", mLiveQrCodeConfig=" + this.mLiveQrCodeConfig + '}';
    }

    public boolean enableScreenShot() {
        return this.enableScreenShot;
    }

    public k getAvatarLarge() {
        return this.avatarLarge;
    }

    public List<UrlModel> getAvatarList() {
        return this.avatarList;
    }

    public k getAvatarMedium() {
        return this.avatarMedium;
    }

    public k getAvatarThumb() {
        return this.avatarThumb;
    }

    public ArrayList<String> getBlackUidList() {
        return this.blackUidList;
    }

    public String getBroadcastRedPacketSchema() {
        return this.broadcastRedPacketSchema;
    }

    public long getCameraId() {
        return this.cameraId;
    }

    public IBaseStreamUrl getCameraStreamUrl() {
        return this.cameraStreamUrl;
    }

    public int getCameraType() {
        return this.cameraType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public k getCover() {
        return this.cover;
    }

    public String getCoverBottom() {
        return this.coverBottom;
    }

    public String getCoverMask() {
        return this.coverMask;
    }

    public String getCoverMaskForMsg() {
        return this.coverMaskForMsg;
    }

    public String getCoverTop() {
        return this.coverTop;
    }

    public String getCurrentPeriod() {
        return this.currentPeriod;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareParams
    public String getDescription() {
        return this.description;
    }

    public String getDisplayId() {
        return this.displayId;
    }

    public String getEnterFrom() {
        return this.enterFrom;
    }

    public String getEnterMethod() {
        return this.enterMethod;
    }

    public Episode getEpisode() {
        return this.episode;
    }

    public long getEpisodeId() {
        return this.episodeId;
    }

    public String getEpisodePreviewText() {
        return this.episodePreviewText;
    }

    public int getEpisodeRecordType() {
        return this.episodeRecordType;
    }

    public int getEpisodeStage() {
        return this.episodeStage;
    }

    public int getEpisodeSubType() {
        return this.episodeSubType;
    }

    public int getEpisodeType() {
        return this.episodeType;
    }

    public int getEpisodeUpdateStatus() {
        return this.episodeUpdateStatus;
    }

    public List getFansGroups() {
        return this.fansGroups;
    }

    public boolean getImHalfChatFragmentEnable() {
        return this.imHalfChatFragmentEnable;
    }

    public Map<String, Map<String, Object>> getImUserExtra() {
        return this.imUserExtra;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareParams
    public String getImageUrl() {
        return this.imageUrl;
    }

    public long getInviteId() {
        return this.inviteId;
    }

    public String getLifeExtraInfo() {
        return this.lifeExtraInfo;
    }

    public Map<String, String> getLiveCommonShareParams() {
        return this.liveCommonShareParams;
    }

    public LiveQrCodeConfig getLiveQrCodeConfig() {
        return this.mLiveQrCodeConfig;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareParams
    public LiveWebShareParams getLiveWebShareParams() {
        return this.liveWebShareParams;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getLogV3ActionType() {
        return this.logV3ActionType;
    }

    public Map<String, String> getLogV3Params() {
        return this.logV3Params;
    }

    public Bundle getLoginBundle() {
        return this.loginBundle;
    }

    public String getLoginEnterFrom() {
        return this.loginEnterFrom;
    }

    public long getMatchIdId() {
        return this.matchId;
    }

    public String getMatchTitle() {
        return this.matchTitle;
    }

    public String getOwnerEncryptedIdStr() {
        return this.ownerEncryptedIdStr;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getOwnerSecUid() {
        return this.ownerSecUid;
    }

    public int getPaidStatus() {
        return this.paidStatus;
    }

    public int getPaidType() {
        return this.paidType;
    }

    public String getPkDefaultInputText() {
        return this.pkDefaultInputText;
    }

    public long getPkId() {
        return this.pkId;
    }

    public String getPkTopTitle() {
        return this.pkTopTitle;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareParams
    public String getPlatform() {
        return this.platform;
    }

    public List<ReportReason> getReasonList() {
        return this.reasonList;
    }

    public long getReportObjectId() {
        return this.mReportObjectId;
    }

    public String getReportObjectIdStr() {
        return this.mReportObjectIdStr;
    }

    public long getReportOwnerId() {
        return this.mReportOwnerId;
    }

    public String getReportOwnerIdStr() {
        return this.mReportOwnerIdStr;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public IRoom getRoom() {
        return this.room;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getRoomMemberCountStr() {
        return this.roomMemberCountStr;
    }

    public String getRoomTitle() {
        return this.roomTitle;
    }

    public String getScreenshotImageUrl() {
        return this.screenshotImageUrl;
    }

    public String getShareConfigId() {
        return this.shareConfigId;
    }

    public IShareDialogListener getShareDialogListener() {
        return this.shareDialogListener;
    }

    public String getShareEnterFrom() {
        return this.shareEnterFrom;
    }

    public String getShareEnterMethod() {
        return this.shareEnterMethod;
    }

    public ShareScene getShareScene() {
        return this.shareScene;
    }

    public String getShareSceneConfigName() {
        return this.shareSceneConfigName;
    }

    public ShareSubScene getShareSubScene() {
        return this.shareSubScene;
    }

    public long getShortId() {
        return this.shortId;
    }

    public boolean getShowVipIM() {
        return this.showVipIM;
    }

    public boolean getShowVipIMRedDot() {
        return this.showVipIMRedDot;
    }

    public long getStartShareTime() {
        return this.startShareTime;
    }

    public String getSubScribePaidStatus() {
        return this.subScribePaidStatus;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareParams
    public String getTitle() {
        return this.title;
    }

    public long getToRoomId() {
        return this.toRoomId;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IShareParams
    public String getUrl() {
        return this.url;
    }

    public String getUserIdStr() {
        return this.userIdStr;
    }

    public String getVid() {
        return this.vid;
    }

    public String getVipIMUri() {
        return this.vipIMUri;
    }

    public IVSPosterClickListener getVsPosterClickListener() {
        return this.vsPosterClickListener;
    }

    public Map<String, String> getVsRoomLog() {
        return this.vsRoomLog;
    }

    public String getVsSceneSource() {
        return this.vsSceneSource;
    }

    public HashMap<String, String> getWhiteUidMap() {
        return this.whiteUidMap;
    }

    public boolean isAnchor() {
        return this.isAnchor;
    }

    public boolean isBanCopyLinkToastWhenDirectType() {
        return this.banCopyLinkToastWhenDirectType;
    }

    public boolean isEnableLandscapeOpt() {
        return this.enableLandscapeOpt;
    }

    public boolean isEnableLandscapePlayerOpt() {
        return this.enableLandscapePlayerOpt;
    }

    public boolean isEnableMatchRoomDialogAnim() {
        return this.enableMatchRoomDialogAnim;
    }

    public boolean isEnablePoster() {
        return this.enablePoster;
    }

    public boolean isEnablePromotion() {
        return this.enablePromotion;
    }

    public boolean isFastShareInPK() {
        return this.isFastShareInPK;
    }

    public boolean isFriendPrivate() {
        return this.isFriendPrivate;
    }

    public boolean isHalfScreen() {
        return this.isHalfScreen;
    }

    public boolean isHideDim() {
        return this.hideDim;
    }

    public boolean isLaunchOnly() {
        return this.launchOnly;
    }

    public boolean isMergeVS() {
        return this.isMergeVS;
    }

    public boolean isMultiCamera() {
        return this.isMultiCamera;
    }

    public boolean isNeedShareToDiary() {
        return this.isNeedShareToDiary;
    }

    public boolean isNeedVisibilityLimit() {
        return this.needVisibilityLimit;
    }

    public boolean isNewLiveChannel() {
        return this.isNewLiveChannel;
    }

    public boolean isSubCamera() {
        return this.isSubCamera;
    }

    public boolean isSubScribeRoom() {
        return this.isSubScribeRoom;
    }

    private ShareParams(Builder r100) {
        this.needVisibilityLimit = false;
        this.isSubCamera = false;
        this.isMultiCamera = false;
        this.matchId = 0;
        this.cameraType = 0;
        this.imHalfChatFragmentEnable = true;
        this.banCopyLinkToastWhenDirectType = false;
        this.vsPosterClickListener = null;
        this.platform = Builder.access$000(r100);
        this.title = Builder.access$100(r100);
        this.description = Builder.access$200(r100);
        this.imageUrl = Builder.access$300(r100);
        this.url = Builder.access$400(r100);
        this.localPath = Builder.access$500(r100);
        this.roomId = Builder.access$600(r100);
        this.ownerId = Builder.access$700(r100);
        this.userId = Builder.access$800(r100);
        this.userIdStr = Builder.access$900(r100);
        this.ownerIdStr = Builder.access$1000(r100);
        this.shortId = Builder.access$1100(r100);
        this.avatarThumb = Builder.access$1200(r100);
        this.avatarMedium = Builder.access$1300(r100);
        this.avatarLarge = Builder.access$1400(r100);
        this.cover = Builder.access$1500(r100);
        this.ownerName = Builder.access$1600(r100);
        this.isAnchor = Builder.access$1700(r100);
        this.requestId = Builder.access$1800(r100);
        this.logV3ActionType = Builder.access$1900(r100);
        this.reasonList = Builder.access$2000(r100);
        this.room = Builder.access$2100(r100);
        this.logV3Params = Builder.access$2200(r100);
        this.displayId = Builder.access$2300(r100);
        this.vid = Builder.access$2400(r100);
        this.mReportObjectId = Builder.access$2500(r100);
        this.mReportOwnerId = Builder.access$2600(r100);
        this.mReportObjectIdStr = Builder.access$2700(r100);
        this.episode = Builder.access$2800(r100);
        this.mReportOwnerIdStr = Builder.access$2900(r100);
        this.ownerEncryptedIdStr = Builder.access$3000(r100);
        this.douPlusEntry = Builder.access$3100(r100);
        this.ownerSecUid = Builder.access$3200(r100);
        this.launchOnly = Builder.access$3300(r100);
        this.roomMemberCountStr = Builder.access$3400(r100);
        this.enablePromotion = Builder.access$3500(r100);
        this.shareScene = Builder.access$3600(r100);
        this.shareConfigId = Builder.access$3700(r100);
        this.shareSubScene = Builder.access$3800(r100);
        this.shareSceneConfigName = Builder.access$3900(r100);
        this.shareConfigId = Builder.access$3700(r100);
        this.extraParams = Builder.access$4000(r100);
        this.liveCommonShareParams = Builder.access$4100(r100);
        this.imUserExtra = Builder.access$4200(r100);
        this.logExtraParams = Builder.access$4300(r100);
        this.activityInfo = Builder.access$4400(r100);
        this.commandDialogParam = Builder.access$4500(r100);
        this.showVipIM = Builder.access$4600(r100);
        this.vipIMUri = Builder.access$4700(r100);
        this.showVipIMRedDot = Builder.access$4800(r100);
        this.liveWebShareParams = Builder.access$4900(r100);
        this.shareDialogListener = Builder.access$5000(r100);
        this.hideDim = Builder.access$5100(r100);
        this.isFastShareInPK = Builder.access$5200(r100);
        this.coverTop = Builder.access$5300(r100);
        this.coverBottom = Builder.access$5400(r100);
        this.coverMask = Builder.access$5500(r100);
        this.pkDefaultInputText = Builder.access$5600(r100);
        this.coverMaskForMsg = Builder.access$5700(r100);
        this.enableMatchRoomDialogAnim = Builder.access$5800(r100);
        this.pkId = Builder.access$5900(r100);
        this.toRoomId = Builder.access$6000(r100);
        this.broadcastRedPacketSchema = Builder.access$6100(r100);
        this.channelId = Builder.access$6200(r100);
        this.pkTopTitle = Builder.access$6300(r100);
        this.roomTitle = Builder.access$6400(r100);
        this.fansGroups = Builder.access$6500(r100);
        this.enablePoster = Builder.access$6600(r100);
        this.extras = Builder.access$6700(r100);
        this.episodeId = Builder.access$6800(r100);
        this.episodeStage = Builder.access$6900(r100);
        this.episodeSubType = Builder.access$7000(r100);
        this.episodeType = Builder.access$7100(r100);
        this.currentPeriod = Builder.access$7200(r100);
        this.vsSceneSource = Builder.access$7300(r100);
        this.episodeUpdateStatus = Builder.access$7400(r100);
        this.enableLandscapePlayerOpt = Builder.access$7500(r100);
        this.enableLandscapeOpt = Builder.access$7600(r100);
        this.episodePreviewText = Builder.access$7700(r100);
        this.episodeRecordType = Builder.access$7800(r100);
        this.vsRoomLog = Builder.access$7900(r100);
        this.avatarList = Builder.access$8000(r100);
        this.screenshotImageUrl = Builder.access$8100(r100);
        this.enterFrom = Builder.access$8200(r100);
        this.enterMethod = Builder.access$8300(r100);
        this.shareEnterMethod = Builder.access$8400(r100);
        this.shareEnterFrom = Builder.access$8500(r100);
        this.paidType = Builder.access$8600(r100);
        this.isSubScribeRoom = Builder.access$8700(r100);
        this.paidStatus = Builder.access$8800(r100);
        this.subScribePaidStatus = Builder.access$8900(r100);
        this.needVisibilityLimit = Builder.access$9000(r100);
        this.isFriendPrivate = Builder.access$9100(r100);
        this.whiteUidMap = Builder.access$9200(r100);
        this.inviteId = Builder.access$9300(r100);
        this.isNewLiveChannel = Builder.access$9400(r100);
        this.blackUidList = Builder.access$9500(r100);
        this.isMergeVS = Builder.access$9600(r100);
        this.mLiveQrCodeConfig = Builder.access$9700(r100);
        this.isHalfScreen = Builder.access$9800(r100);
        this.livePlayerClient = Builder.access$9900(r100);
        this.isNeedShareToDiary = Builder.access$10000(r100);
        this.enableScreenShot = Builder.access$10100(r100);
        this.sharePublishParam = Builder.access$10200(r100);
        this.loginBundle = Builder.access$10300(r100);
        this.loginEnterFrom = Builder.access$10400(r100);
        this.matchTitle = Builder.access$10500(r100);
        IVSCameraInfo r101 = Builder.access$10600(r100);
        this.isSubCamera = Builder.access$10700(r100);
        this.isMultiCamera = Builder.access$10800(r100);
        this.startShareTime = Builder.access$10900(r100);
        this.imHalfChatFragmentEnable = Builder.access$11000(r100);
        this.banCopyLinkToastWhenDirectType = r100.banCopyLinkToastWhenDirectType;
        if (r101 == null) goto L14;
        k r102 = r101.getCover();
        k r103 = r101.getVerticalCover();
        String r104 = r101.getTitle();
        if (r102 == null) goto L7;
        this.cover = r102;
    L10:
        if (TextUtils.isEmpty(r104) == true) goto L12;
        this.title = r104;
    L12:
        this.cameraType = r101.getCameraType();
        this.cameraId = r101.getCameraId();
        this.cameraStreamUrl = r101.getStreamUrl();
        this.matchId = r101.getMatchId();
        goto L14
    L7:
        if (r103 == null) goto L10;
        this.cover = r103;
    L14:
        if (isMultiCamera() != true) goto L17;
        this.shareConfigId = "19469";
    L17:
        if (this.extraParams != null) goto L19;
        this.extraParams = new HashMap();
    L19:
        this.extraParams.put(VSConstants.VS_CAMERA_ID, this.cameraId + "");
        this.extraParams.put(VSConstants.VS_MATCH_ID, this.matchId + "");
        this.extraParams.put("camera_type", this.cameraType + "");
        this.lifeExtraInfo = getLifeExtraInfo(r100);
    }

    public static Builder buildShareScene(ShareScene r100) {
        return new Builder(r100, null);
    }

    public static Builder buildUponEpisode(Episode r100) {
        return new Builder(r100, null);
    }

    public static Builder buildUponReplay(Episode r100) {
        return new Builder(r100, Boolean.TRUE, null);
    }

    public static Builder buildUponRoom(IRoom r100) {
        return new Builder(r100, null);
    }

    public static Builder buildUponUser(IBaseUser r100) {
        return new Builder(r100, null);
    }

    private String getLifeExtraInfo(Builder r100) {
        if (TextUtils.isEmpty(Builder.access$11100(r100)) == false) goto L6;
        return null;
    L6:
        JSONObject r101 = new JSONObject();
        String r102 = Builder.access$8500(r100);
        String r103 = Builder.access$8300(r100);
        String r104 = Builder.access$11200(r100);
        String r105 = Builder.access$11300(r100);
        if (TextUtils.isEmpty(r102) == false) goto L10;
        r102 = Builder.access$11400(r100);
    L10:
        if (TextUtils.isEmpty(r103) == false) goto L13;
        r103 = Builder.access$11500(r100);
    L13:
        if (TextUtils.isEmpty(r104) == false) goto L16;
        r104 = Builder.access$11600(r100);
    L16:
        if (TextUtils.isEmpty(r105) == false) goto L24;
        r105 = Builder.access$900(r100);
    L24:
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L21
        r106.put("life_share_id", Builder.access$11100(r100));     // Catch: JSONException -> L21
        r106.put("from_user_id", r105);     // Catch: JSONException -> L21
        r106.put("enter_from", "livebroadcasting");     // Catch: JSONException -> L21
        r106.put("room_id", String.valueOf(Builder.access$600(r100)));     // Catch: JSONException -> L21
        r106.put("enter_from_merge", r102);     // Catch: JSONException -> L21
        r106.put("enter_method", r103);     // Catch: JSONException -> L21
        r106.put("action_type", r104);     // Catch: JSONException -> L21
        r101.put("life_share_ext", r106);     // Catch: JSONException -> L21
        return r101.toString();
    L21:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void setCameraId(long r100) {
        this.cameraId = r100;
    }

    public void setCameraStreamUrl(IBaseStreamUrl r100) {
        this.cameraStreamUrl = r100;
    }

    public void setCameraType(int r100) {
        this.cameraType = r100;
    }

    public void setDisplayId(String r100) {
        this.displayId = r100;
    }

    public void setLifeExtraInfo(String r100) {
        this.lifeExtraInfo = r100;
    }

    public void setLiveCommonShareParams(Map<String, String> r100) {
        this.liveCommonShareParams = r100;
    }

    public void setLivePlayerClient(ILivePlayerClient r100) {
        this.livePlayerClient = new WeakReference(r100);
    }

    public void setLiveQrCodeConfig(LiveQrCodeConfig r100) {
        this.mLiveQrCodeConfig = r100;
    }

    public void setMatchTitle(String r100) {
        this.matchTitle = r100;
    }

    public void setOwnerEncryptedIdStr(String r100) {
        this.ownerEncryptedIdStr = r100;
    }

    public void setReportObjectIdStr(String r100) {
        this.mReportObjectIdStr = r100;
    }

    public void setReportOwnerIdStr(String r100) {
        this.mReportOwnerIdStr = r100;
    }

    public void setRequestId(String r100) {
        this.requestId = r100;
    }

    public void setShareEnterMethod(String r100) {
        this.shareEnterMethod = r100;
    }

    public void setSubCamera(boolean r100) {
        this.isSubCamera = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setVsPosterClickListener(IVSPosterClickListener r100) {
        this.vsPosterClickListener = r100;
    }

    public /* synthetic */ ShareParams(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static Builder buildUponParams(long r100, long r101) {
        return new Builder(r100, r101, null);
    }

    public static Builder buildUponParams(String r100, String r101) {
        return new Builder(r100, r101, null);
    }
}
