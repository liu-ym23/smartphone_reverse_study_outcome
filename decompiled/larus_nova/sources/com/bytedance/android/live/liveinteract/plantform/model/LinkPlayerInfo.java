package com.bytedance.android.live.liveinteract.plantform.model;

import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.ListUserExtra;
import com.bytedance.android.live.liveinteract.multianchor.model.MicDress;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.UserHighScoreSongTag;
import com.bytedance.android.livesdk.message.model.fc;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MatchEffect;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class LinkPlayerInfo extends FlexModelBase<ILinkPlayerInfoBridge> implements com.bytedance.android.live.liveinteract.plantform.base.h, Cloneable, ILinkPlayerInfoBridge {
    public static final int INTERACTING_STATE_OFFLINE = 1;
    public static final int INTERACTING_STATE_ONLINE = 0;
    public static final int INTERESTED_TYPE_FOLLOWER = 3;
    public static final int INTERESTED_TYPE_MUTUAL = 1;
    public static final int INTERESTED_TYPE_RECENT_LINKED = 2;
    public static final int INTERESTED_TYPE_UNKNOWN = 0;
    public static final int INVITEE_TYPE_FANS = 3;
    public static final int INVITEE_TYPE_MUTUAL = 2;
    public static final int INVITEE_TYPE_NONE = 0;
    public static final int INVITEE_TYPE_ROOM_AUDIENCE = 1;
    public static final int KICK_OUT_FROM_GAME = 2;
    public static final int KICK_OUT_FROM_PANEL = 1;
    public static final int LINK_STATUS_FINISHED = 3;
    public static final int LINK_STATUS_LINKED = 2;
    public static final int LINK_STATUS_UNKNOWN = 0;
    public static final int LINK_STATUS_WAITING = 1;
    public static final int LINK_TYPE_AUDIO = 2;
    public static final int LINK_TYPE_DIGIT_AVATAR = 3;
    public static final int LINK_TYPE_UNKNOWN = 0;
    public static final int LINK_TYPE_VIDEO = 1;
    private static final int MAX_NAME_LENGTH = 6;
    public static final int MC_STATUS_KTV_HOST = 1;
    public static final int MC_STATUS_NOTHING = 0;
    public static final int ROLE_TYPE_LEADER = 1;
    public static final int ROLE_TYPE_PLAYER = 2;
    public static final int ROLE_TYPE_UNKNOWN = 0;
    public static final int SILENCE_BY_ANCHOR = 2;
    public static final int SILENCE_BY_GAME = 4;
    public static final int SILENCE_BY_SELF = 1;
    public static final int SILENCE_PASSIVE = 3;
    public static final int SILENCE_UNKONWN = -1;
    public static final int UNSILENCE = 0;
    public static final int USER_FROM_TYPE_BY_LINKED_USER = 4;
    public static final int USER_FROM_TYPE_KTV_ADD_SONG = 2;
    public static final int USER_FROM_TYPE_KTV_GRAB_SONG = 3;
    public static final int USER_FROM_TYPE_NONE = 0;
    public static final int USER_FROM_TYPE_NORMAL = 1;
    public transient String activeName;

    @SerializedName("add_price_time_ms")
    public long addPriceTime;
    public int aiGuestType;

    @IgnoreProtoFieldCheck
    @SerializedName("already_invited")
    public boolean alreadyInvited;

    @SerializedName("app_id")
    public long appId;

    @SerializedName(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE)
    public int applyTypeNew;
    public transient String buttonText;

    @SerializedName("chorus_guest_status")
    public long chorusGuestStatus;

    @IgnoreProtoFieldCheck
    @SerializedName("client_ui_position")
    private int clientUIPosition;

    @SerializedName("client_version")
    public long clientVersion;
    public transient String cornerMarkUrl;

    @SerializedName("device_platform")
    public String devicePlatform;

    @SerializedName("event_info")
    public ListUserEventInfo eventInfo;

    @SerializedName("fuzzy_fan_ticket")
    public String fuzzyFanTicket;

    @SerializedName("interested_type")
    public int[] interestedType;

    @SerializedName("invite_list_user_info")
    public InviteListUserInfo inviteListUserInfo;

    @SerializedName("invitee_type")
    public int inviteeType;

    @SerializedName("is_active")
    public boolean isActive;

    @SerializedName("is_add_price")
    public boolean isAddPrice;
    public boolean isAnchorPlayer;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS)
    public boolean isAnonymous;
    public transient boolean isBackground;

    @IgnoreProtoFieldCheck
    @SerializedName("is_enlarged")
    public boolean isEnlarged;
    public transient boolean isHasApplied;
    public transient boolean isHasInvited;

    @SerializedName("host_permission")
    public boolean isHost;
    public transient boolean isInWaitingList;
    public transient boolean isInviting;
    public boolean isMicHidden;
    public transient boolean isOpenSendGift;
    public Boolean isPaidUserLeave;
    public transient boolean isSelfBackground;
    public transient boolean isSelfPreOn;

    @SerializedName("join_teamfight_info")
    public TeamFightJoinTeamInfo joinTeamFightInfo;
    public transient long kSongUid;

    @IgnoreProtoFieldCheck
    @SerializedName("last_active_time_ms")
    public long lastActiveTimeMillis;

    @SerializedName("last_invited_time_ms")
    public long lastInvitedTimeMillis;

    @SerializedName("link_duration")
    public int linkDuration;

    @SerializedName("linked_list_user_info")
    public LinkedListUserInfo linkedListUserInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("linkmic_2d_avatar")
    public Linkmic2DAvatar linkmic2DAvatar;

    @SerializedName("list_user_from_type")
    public int listUserFromType;

    @IgnoreProtoFieldCheck
    @SerializedName("list_user_role")
    public int listUserRole;

    @SerializedName("list_user_type")
    public int listUserType;

    @SerializedName("location")
    public String location;
    public transient int mApplyType;
    public transient CityEffect mCityEffect;

    @SerializedName("fan_ticket")
    public long mFanTicket;
    public transient String mFanTicketDisplayStr;
    public transient boolean mHasExposed;

    @SerializedName("linkmic_id_str")
    public String mInteractIdStr;
    private transient int mInteractingState;

    @SerializedName("invitor")
    public IBaseUser mInvitor;
    public transient boolean mIsJoinUser;
    public transient boolean mIsLinkRoomUser;
    public transient long mLinkRoomId;

    @SerializedName("link_status")
    public int mLinkStatus;

    @SerializedName("link_type")
    public int mLinkType;

    @IgnoreProtoFieldCheck
    @SerializedName("linkmic_unique_id")
    public String mLinkmicUniqueIdStr;
    public transient MatchEffect mMatchEffect;

    @SerializedName("modify_time")
    public long mModifyTime;

    @SerializedName("role_type")
    public int mRoleType;
    public transient int mRoomLinkSilenceStatus;
    public transient boolean mShowCityEffect;

    @SerializedName("user")
    public IBaseUser mUser;

    @SerializedName("mc_status")
    public long mcStatus;
    public int mediaType;
    public MicDress micDress;

    @SerializedName("mic_pos_tag_info")
    public MicPosTagInfo micPosTagInfo;

    @SerializedName("modify_time_in_nano")
    public long modifyTimeInNano;

    @IgnoreProtoFieldCheck
    @SerializedName("order_song_count")
    public long orderedSongCount;
    public long originLinkType;
    public Map.Entry<Long, ? extends g2> otherRoomInfo;
    public transient boolean outOfDate;
    public long paidAmount;
    public long paidCount;

    @SerializedName("payed_money")
    public int paidMoney;
    public int positionType;

    @SerializedName("rank")
    public long rank;
    public long selfDisciplineDuration;
    public long selfDisciplineTargetDuration;

    @SerializedName("silence_status")
    public int silenceStatus;

    @SerializedName("song_list")
    public List<KtvMusic> songList;
    public int stats;

    @SerializedName("tag")
    public ListUserTag tag;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    public List<ListTag> tags;
    public transient int talkState;
    public int themedCompetitionRole;

    @IgnoreProtoFieldCheck
    @SerializedName("high_score_song_tag")
    public UserHighScoreSongTag userHighScoreSongTag;

    @SerializedName("user_position")
    public int userPosition;

    @SerializedName("user_relation_type")
    public long userRelationType;
    public transient int verifyStatus;

    @SerializedName("waiting_list_user_info")
    public WaitingListUserInfo waitingListUserInfo;

    public static final enum McStatus extends Enum<McStatus> {
        public static final McStatus KTV_HOST = null;
        public static final McStatus UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ McStatus[] f77224a = null;

        static {
            McStatus r100 = new McStatus("UNKNOWN", 0);
            UNKNOWN = r100;
            McStatus r101 = new McStatus("KTV_HOST", 1);
            KTV_HOST = r101;
            f77224a = new McStatus[]{r100, r101};
        }

        public static McStatus[] values() {
            return (McStatus[]) f77224a.clone();
        }

        public static McStatus valueOf(String r100) {
            return (McStatus) r27.a.a(McStatus.class, r100);
        }

        public McStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isSelfPreOn() {
        return false;
    }

    public LinkPlayerInfo() {
        super(ILinkPlayerInfoBridge.class);
        this.mFanTicketDisplayStr = "0";
        this.lastActiveTimeMillis = -1;
        this.lastInvitedTimeMillis = -1;
        this.isAddPrice = false;
        this.addPriceTime = 0;
        this.isPaidUserLeave = Boolean.FALSE;
        this.clientUIPosition = Integer.MIN_VALUE;
        this.kSongUid = 0;
        this.rank = 0;
        this.mInteractingState = 0;
    }

    private String getUserId() {
        IBaseUser r100 = this.mUser;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUserId();
    }

    public LinkPlayerInfo copy() {
        LinkPlayerInfo r100 = new LinkPlayerInfo();
        r100.setFanTicket(getFanTicket());
        r100.mFanTicketDisplayStr = this.mFanTicketDisplayStr;
        r100.mInteractIdStr = this.mInteractIdStr;
        r100.mLinkmicUniqueIdStr = this.mLinkmicUniqueIdStr;
        r100.setUser(getUser());
        r100.setModifyTime(getModifyTime());
        r100.setLinkStatus(getLinkStatus());
        r100.setLinkType(getLinkType());
        r100.setRoleType(getRoleType());
        r100.listUserRole = this.listUserRole;
        r100.paidMoney = this.paidMoney;
        r100.linkDuration = this.linkDuration;
        r100.userPosition = this.userPosition;
        r100.silenceStatus = this.silenceStatus;
        r100.location = this.location;
        r100.modifyTimeInNano = this.modifyTimeInNano;
        r100.talkState = this.talkState;
        r100.isOpenSendGift = this.isOpenSendGift;
        r100.isHasInvited = this.isHasInvited;
        r100.isHasApplied = this.isHasApplied;
        r100.isHost = this.isHost;
        r100.mediaType = this.mediaType;
        r100.cornerMarkUrl = this.cornerMarkUrl;
        r100.clientVersion = this.clientVersion;
        r100.appId = this.appId;
        r100.devicePlatform = this.devicePlatform;
        r100.mApplyType = this.mApplyType;
        r100.applyTypeNew = this.applyTypeNew;
        r100.linkedListUserInfo = this.linkedListUserInfo;
        r100.isBackground = this.isBackground;
        r100.isSelfBackground = this.isSelfBackground;
        r100.mMatchEffect = this.mMatchEffect;
        r100.mCityEffect = this.mCityEffect;
        r100.mShowCityEffect = this.mShowCityEffect;
        r100.mIsJoinUser = this.mIsJoinUser;
        r100.micDress = this.micDress;
        r100.isEnlarged = this.isEnlarged;
        r100.linkmic2DAvatar = this.linkmic2DAvatar;
        r100.chorusGuestStatus = this.chorusGuestStatus;
        r100.originLinkType = this.originLinkType;
        r100.selfDisciplineDuration = this.selfDisciplineDuration;
        r100.selfDisciplineTargetDuration = this.selfDisciplineTargetDuration;
        r100.themedCompetitionRole = this.themedCompetitionRole;
        r100.waitingListUserInfo = this.waitingListUserInfo;
        r100.rank = this.rank;
        r100.paidCount = this.paidCount;
        r100.stats = this.stats;
        r100.mcStatus = this.mcStatus;
        r100.mIsLinkRoomUser = this.mIsLinkRoomUser;
        r100.mLinkRoomId = this.mLinkRoomId;
        r100.mRoomLinkSilenceStatus = this.mRoomLinkSilenceStatus;
        r100.isAnonymous = this.isAnonymous;
        r100.micPosTagInfo = this.micPosTagInfo;
        r100.userHighScoreSongTag = this.userHighScoreSongTag;
        r100.isPaidUserLeave = this.isPaidUserLeave;
        return r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getClientUIPosition() {
        int r100 = this.clientUIPosition;
        if (r100 == Integer.MIN_VALUE) goto L5;
        return r100;
    L5:
        return this.userPosition;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getExpectLeaveTime() {
        LinkedListUserInfo r100 = this.linkedListUserInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.expectLeaveTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getJoinChannelTime() {
        LinkedListUserInfo r100 = this.linkedListUserInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.joinChannelTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public Long getKSongUid() {
        return Long.valueOf(this.kSongUid);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getLinkDuration() {
        return this.linkDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getLinkMicPosTagType() {
        MicPosTagInfo r100 = this.micPosTagInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getTagType();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getPaidLinkCurrentTime() {
        LinkedListUserInfo r100 = this.linkedListUserInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.currentTime;
    }

    public String getRelationship() {
        IBaseUser r100 = this.mUser;
        if (r100 != null) goto L5;
        return "null";
    L5:
        return r100.getRelationship();
    }

    public String getTopR() {
        long r100 = this.rank;
        if (r100 != 1) goto L6;
        return "top1";
    L6:
        if (r100 != 2) goto L9;
        return "top2";
    L9:
        if (r100 != 3) goto L11;
        return "top3";
    L11:
        return "null";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getUserPosition() {
        int r100 = this.clientUIPosition;
        if (r100 == Integer.MIN_VALUE) goto L6;
        return r100;
    L6:
        return this.userPosition;
    }

    public boolean hasSpecialRadioEffect() {
        MicDress r100 = this.micDress;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.voiceWave == null) goto L7;
        return true;
    }

    public boolean isKtvHost() {
        if (this.mcStatus != McStatus.KTV_HOST.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isPaidUserLeave() {
        return this.isPaidUserLeave.booleanValue();
    }

    public boolean isTalking() {
        if (this.talkState <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public /* bridge */ /* synthetic */ ICityEffect getCityEffect() {
        return getCityEffect();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public /* bridge */ /* synthetic */ i getInviteListUserInfo() {
        return getInviteListUserInfo();
    }

    public String toString() {
        if (getUser() == null) goto L5;
        String r100 = getUser().getNickName();
        String r101 = getUser().getIdString();
    L7:
        return "LinkPlayerInfo{mInteractIdStr='" + this.mInteractIdStr + "'mLinkmicUniqueIdStr='" + this.mLinkmicUniqueIdStr + "'nickName='" + r100 + "'id=" + r101 + "position='" + this.userPosition + "'mediaType='" + this.mediaType + "'mLinkType='" + this.mLinkType + "'isBackground='" + this.isBackground + "'}";
    L5:
        r100 = "";
        r101 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getActiveName() {
        return this.activeName;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getAddPriceTime() {
        return this.addPriceTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getAiGuestType() {
        return this.aiGuestType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean getAlreadyInvited() {
        return this.alreadyInvited;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getAppId() {
        return this.appId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getApplyType() {
        return this.mApplyType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getApplyTypeNew() {
        return this.applyTypeNew;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public IBaseUser getBaseUser() {
        return this.mUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getButtonText() {
        return this.buttonText;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getChorusGuestStatus() {
        return this.chorusGuestStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getClientVersion() {
        return this.clientVersion;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getCornerMarkUrl() {
        return this.cornerMarkUrl;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getDevicePlatform() {
        return this.devicePlatform;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public c0 getEventInfo() {
        return this.eventInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getFanTicket() {
        return this.mFanTicket;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getFanTicketDisplayStr() {
        return this.mFanTicketDisplayStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getFuzzyFanTicket() {
        return this.fuzzyFanTicket;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getInteractId() {
        return this.mInteractIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getInteractingState() {
        return this.mInteractingState;
    }

    public int[] getInterestedType() {
        return this.interestedType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getInviteeType() {
        return this.inviteeType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public IBaseUser getInvitor() {
        return this.mInvitor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public j0 getJoinTeamFightInfo() {
        return this.joinTeamFightInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getLastActiveTimeMillis() {
        return this.lastActiveTimeMillis;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getLastInvitedTimeMillis() {
        return this.lastInvitedTimeMillis;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getLinkMicUniqueIdStr() {
        return this.mLinkmicUniqueIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getLinkRoomId() {
        return this.mLinkRoomId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getLinkStatus() {
        return this.mLinkStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getLinkType() {
        return this.mLinkType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public o getLinkedListUserInfo() {
        return this.linkedListUserInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public Linkmic2DAvatar getLinkmic2DAvatar() {
        return this.linkmic2DAvatar;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getListUserFromType() {
        return this.listUserFromType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getListUserRole() {
        return this.listUserRole;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getListUserType() {
        return this.listUserType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getLocation() {
        return this.location;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getMFanTicket() {
        return this.mFanTicket;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getMInteractIdStr() {
        return this.mInteractIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public IBaseUser getMInvitor() {
        return this.mInvitor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean getMIsJoinUser() {
        return this.mIsJoinUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getMLinkMicUniqueIdStr() {
        return this.mLinkmicUniqueIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getMLinkStatus() {
        return this.mLinkStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getMLinkType() {
        return this.mLinkType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getMModifyTime() {
        return this.mModifyTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getMRoleType() {
        return this.mRoleType;
    }

    public IBaseUser getMUser() {
        return this.mUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public IMatchEffect getMatchEffect() {
        return this.mMatchEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getMcStatus() {
        return this.mcStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getMediaType() {
        return this.mediaType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public kd1.b getMicDress() {
        return this.micDress;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public g0 getMicPosTagInfo() {
        return this.micPosTagInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getModifyTime() {
        return this.mModifyTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getModifyTimeInNano() {
        return this.modifyTimeInNano;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getOrderedSongCount() {
        return this.orderedSongCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getOriginLinkType() {
        return this.originLinkType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public Map.Entry<Long, g2> getOtherRoomInfo() {
        return this.otherRoomInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getPaidAmount() {
        return this.paidAmount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getPaidCount() {
        return this.paidCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getPaidMoney() {
        return this.paidMoney;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getPositionType() {
        return this.positionType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getRank() {
        return this.rank;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getRoleType() {
        return this.mRoleType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getRoomLinkSilenceStatus() {
        return this.mRoomLinkSilenceStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getSelfDisciplineDuration() {
        return this.selfDisciplineDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getSelfDisciplineDurationTime() {
        return this.selfDisciplineDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getSelfDisciplineTargetDuration() {
        return this.selfDisciplineTargetDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean getShowCityEffect() {
        return this.mShowCityEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getSilenceStatus() {
        return this.silenceStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public List<KtvMusic> getSongList() {
        return this.songList;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getStats() {
        return this.stats;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public ListUserTag getTag() {
        return this.tag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public List<v> getTags() {
        return this.tags;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getTalkState() {
        return this.talkState;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getThemedCompetitionRole() {
        return this.themedCompetitionRole;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public IBaseUser getUser() {
        return this.mUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public fc getUserHighScoreSongTag() {
        return this.userHighScoreSongTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getUserPositionFlex() {
        return this.userPosition;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getUserRelationType() {
        return this.userRelationType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getVerifyStatus() {
        return this.verifyStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public o0 getWaitingListUserInfo() {
        return this.waitingListUserInfo;
    }

    public int getmApplyType() {
        return this.mApplyType;
    }

    public CityEffect getmCityEffect() {
        return this.mCityEffect;
    }

    public long getmFanTicket() {
        return this.mFanTicket;
    }

    public String getmFanTicketDisplayStr() {
        return this.mFanTicketDisplayStr;
    }

    public String getmInteractIdStr() {
        return this.mInteractIdStr;
    }

    public int getmInteractingState() {
        return this.mInteractingState;
    }

    public IBaseUser getmInvitor() {
        return this.mInvitor;
    }

    public int getmLinkType() {
        return this.mLinkType;
    }

    public MatchEffect getmMatchEffect() {
        return this.mMatchEffect;
    }

    public long getmModifyTime() {
        return this.mModifyTime;
    }

    public int getmRoleType() {
        return this.mRoleType;
    }

    public IBaseUser getmUser() {
        return this.mUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isAddPrice() {
        return this.isAddPrice;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isAlreadyInvited() {
        return this.alreadyInvited;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isAnchorPlayer() {
        return this.isAnchorPlayer;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isBackground() {
        return this.isBackground;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isEnlarged() {
        return this.isEnlarged;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isHasApplied() {
        return this.isHasApplied;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isHasExposed() {
        return this.mHasExposed;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isHasInvited() {
        return this.isHasInvited;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isHost() {
        return this.isHost;
    }

    public boolean isInWaitingList() {
        return this.isInWaitingList;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isInviting() {
        return this.isInviting;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isIsAddPrice() {
        return this.isAddPrice;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isIsAnonymous() {
        return this.isAnonymous;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isIsEnlarged() {
        return this.isEnlarged;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isIsHost() {
        return this.isHost;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isLinkRoomUser() {
        return this.mIsLinkRoomUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isMicHidden() {
        return this.isMicHidden;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isOpenSendGift() {
        return this.isOpenSendGift;
    }

    public boolean isOutOfDate() {
        return this.outOfDate;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isSelfBackground() {
        return this.isSelfBackground;
    }

    public boolean ismHasExposed() {
        return this.mHasExposed;
    }

    public boolean ismIsJoinUser() {
        return this.mIsJoinUser;
    }

    public boolean ismIsLinkRoomUser() {
        return this.mIsLinkRoomUser;
    }

    public boolean ismShowCityEffect() {
        return this.mShowCityEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public CityEffect getCityEffect() {
        return this.mCityEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public InviteListUserInfo getInviteListUserInfo() {
        return this.inviteListUserInfo;
    }

    public static String getUserNameWithCut(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() > 6) goto L7;
        return r100;
    L7:
        return r100.subSequence(0, 5) + "...";
    }

    public boolean isEnlargePlayer(long r100) {
        IBaseUser r101 = this.mUser;
        if (r101 != null) goto L5;
        return false;
    L5:
        return TextUtils.equals(r101.getIdString(), String.valueOf(r100));
    }

    public boolean isEqual(LinkPlayerInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if (this.mFanTicket == r100.mFanTicket) goto L11;
        return false;
    L11:
        if (TextUtils.equals(this.mFanTicketDisplayStr, r100.mFanTicketDisplayStr) == false) goto L201;
        IBaseUser r101 = this.mUser;
        if (r101 != null) goto L15;
        return false;
    L15:
        if (r101.equals(r100.mUser) == false) goto L203;
        IBaseUser r102 = this.mInvitor;
        if (r102 == null) goto L19;
    L20:
        if (r102 != null) goto L22;
        return false;
    L22:
        if (r102.equals(r100.mInvitor) == true) goto L24;
        return false;
    L24:
        if (this.mModifyTime == r100.mModifyTime) goto L26;
        return false;
    L26:
        if (this.mLinkStatus == r100.mLinkStatus) goto L28;
        return false;
    L28:
        if (this.mLinkType == r100.mLinkType) goto L30;
        return false;
    L30:
        if (this.mRoleType == r100.mRoleType) goto L32;
        return false;
    L32:
        if (this.paidMoney == r100.paidMoney) goto L34;
        return false;
    L34:
        if (this.linkDuration == r100.linkDuration) goto L36;
        return false;
    L36:
        if (this.userPosition == r100.userPosition) goto L38;
        return false;
    L38:
        if (this.silenceStatus == r100.silenceStatus) goto L40;
        return false;
    L40:
        if (TextUtils.equals(this.mInteractIdStr, r100.mInteractIdStr) == true) goto L42;
        return false;
    L42:
        if (TextUtils.equals(this.mLinkmicUniqueIdStr, r100.mLinkmicUniqueIdStr) == true) goto L44;
        return false;
    L44:
        if (TextUtils.equals(this.location, r100.location) == true) goto L46;
        return false;
    L46:
        if (this.userRelationType == r100.userRelationType) goto L48;
        return false;
    L48:
        if (this.modifyTimeInNano == r100.modifyTimeInNano) goto L50;
        return false;
    L50:
        if (this.isHost != r100.isHost) goto L219;
        List<KtvMusic> r103 = this.songList;
        if (r103 == null) goto L54;
    L55:
        if (r103 != null) goto L57;
        return false;
    L57:
        if (isSameKtvMusic(r100.songList) == true) goto L59;
        return false;
    L59:
        if (this.orderedSongCount == r100.orderedSongCount) goto L61;
        return false;
    L61:
        if (this.isActive == r100.isActive) goto L63;
        return false;
    L63:
        if (this.lastActiveTimeMillis == r100.lastActiveTimeMillis) goto L65;
        return false;
    L65:
        if (this.lastInvitedTimeMillis == r100.lastInvitedTimeMillis) goto L67;
        return false;
    L67:
        if (this.isAddPrice == r100.isAddPrice) goto L69;
        return false;
    L69:
        if (this.addPriceTime != r100.addPriceTime) goto L227;
        TeamFightJoinTeamInfo r104 = this.joinTeamFightInfo;
        if (r104 == null) goto L73;
    L74:
        if (r104 != null) goto L76;
        return false;
    L76:
        if (r104.equals(r100.joinTeamFightInfo) == true) goto L78;
        return false;
    L78:
        if (this.listUserType == r100.listUserType) goto L80;
        return false;
    L80:
        if (this.listUserFromType != r100.listUserFromType) goto L231;
        WaitingListUserInfo r105 = this.waitingListUserInfo;
        if (r105 == null) goto L84;
    L85:
        if (r105 != null) goto L87;
        return false;
    L87:
        if (r105.equals(r100.waitingListUserInfo) == true) goto L89;
        return false;
    L89:
        if (this.mcStatus != r100.mcStatus) goto L234;
        InviteListUserInfo r106 = this.inviteListUserInfo;
        if (r106 == null) goto L93;
    L94:
        if (r106 != null) goto L96;
        return false;
    L96:
        if (r106.equals(r100.inviteListUserInfo) == false) goto L236;
    L97:
        LinkedListUserInfo r107 = this.linkedListUserInfo;
        if (r107 == null) goto L100;
    L101:
        if (r107 != null) goto L103;
        return false;
    L103:
        if (r107.same(r100.linkedListUserInfo) == true) goto L105;
        return false;
    L105:
        if (this.listUserRole == r100.listUserRole) goto L107;
        return false;
    L107:
        if (TextUtils.equals(this.fuzzyFanTicket, r100.fuzzyFanTicket) == false) goto L240;
        MicPosTagInfo r108 = this.micPosTagInfo;
        if (r108 == null) goto L111;
    L112:
        if (r108 != null) goto L114;
        return false;
    L114:
        if (r108.equals(r100.micPosTagInfo) == true) goto L116;
        return false;
    L116:
        if (this.isSelfPreOn != r100.isSelfPreOn) goto L243;
        MicDress r109 = this.micDress;
        if (r109 == null) goto L120;
    L121:
        if (r109 != null) goto L123;
        return false;
    L123:
        if (r109.isEqual(r100.micDress) == true) goto L125;
        return false;
    L125:
        if (this.paidCount == r100.paidCount) goto L127;
        return false;
    L127:
        if (this.selfDisciplineDuration == r100.selfDisciplineDuration) goto L129;
        return false;
    L129:
        if (this.selfDisciplineTargetDuration == r100.selfDisciplineTargetDuration) goto L131;
        return false;
    L131:
        if (this.isPaidUserLeave == r100.isPaidUserLeave) goto L133;
        return false;
    L133:
        if (this.paidAmount == r100.paidAmount) goto L135;
        return false;
    L135:
        if (this.isBackground == r100.isBackground) goto L137;
        return false;
    L137:
        if (this.isSelfBackground == r100.isSelfBackground) goto L139;
        return false;
    L139:
        if (this.isEnlarged == r100.isEnlarged) goto L141;
        return false;
    L141:
        if (this.isAnonymous == r100.isAnonymous) goto L143;
        return false;
    L143:
        if (this.talkState == r100.talkState) goto L145;
        return false;
    L145:
        if (this.mediaType == r100.mediaType) goto L147;
        return false;
    L147:
        if (this.stats == r100.stats) goto L149;
        return false;
    L149:
        if (TextUtils.equals(this.activeName, r100.activeName) == true) goto L151;
        return false;
    L151:
        if (this.verifyStatus == r100.verifyStatus) goto L153;
        return false;
    L153:
        if (this.isInviting == r100.isInviting) goto L155;
        return false;
    L155:
        if (this.isOpenSendGift == r100.isOpenSendGift) goto L157;
        return false;
    L157:
        if (this.isHasInvited == r100.isHasInvited) goto L159;
        return false;
    L159:
        if (this.isHasApplied == r100.isHasApplied) goto L161;
        return false;
    L161:
        if (this.mApplyType == r100.mApplyType) goto L163;
        return false;
    L163:
        if (this.applyTypeNew != r100.applyTypeNew) goto L265;
        MatchEffect r110 = this.mMatchEffect;
        if (r110 == null) goto L167;
    L168:
        if (r110 != null) goto L170;
        return false;
    L170:
        if (r110.equals(r100.mMatchEffect) == false) goto L267;
    L171:
        CityEffect r111 = this.mCityEffect;
        if (r111 == null) goto L174;
    L175:
        if (r111 != null) goto L177;
        return false;
    L177:
        if (r111.equals(r100.mCityEffect) == true) goto L179;
        return false;
    L179:
        if (this.mShowCityEffect == r100.mShowCityEffect) goto L181;
        return false;
    L181:
        if (this.mIsJoinUser == r100.mIsJoinUser) goto L183;
        return false;
    L183:
        if (this.mHasExposed == r100.mHasExposed) goto L185;
        return false;
    L185:
        if (this.mIsLinkRoomUser == r100.mIsLinkRoomUser) goto L187;
        return false;
    L187:
        if (this.mLinkRoomId == r100.mLinkRoomId) goto L189;
        return false;
    L189:
        if (this.mRoomLinkSilenceStatus == r100.mRoomLinkSilenceStatus) goto L191;
        return false;
    L191:
        if (this.clientVersion == r100.clientVersion) goto L193;
        return false;
    L193:
        if (this.appId == r100.appId) goto L195;
        return false;
    L195:
        if (TextUtils.equals(this.devicePlatform, r100.devicePlatform) == true) goto L197;
        return false;
    L197:
        if (this.rank != r100.rank) goto L279;
        return true;
    L279:
        return false;
    L174:
        if (r100.mCityEffect == null) goto L179;
    L267:
        return false;
    L167:
        if (r100.mMatchEffect == null) goto L171;
    L265:
        return false;
    L120:
        if (r100.micDress == null) goto L125;
    L243:
        return false;
    L111:
        if (r100.micPosTagInfo == null) goto L116;
    L240:
        return false;
    L100:
        if (r100.linkedListUserInfo == null) goto L105;
    L236:
        return false;
    L93:
        if (r100.inviteListUserInfo == null) goto L97;
    L234:
        return false;
    L84:
        if (r100.waitingListUserInfo == null) goto L89;
    L231:
        return false;
    L73:
        if (r100.joinTeamFightInfo == null) goto L78;
    L227:
        return false;
    L54:
        if (r100.songList == null) goto L59;
    L219:
        return false;
    L19:
        if (r100.mInvitor == null) goto L24;
    L203:
        return false;
    L201:
        return false;
    }

    public boolean isSameKtvMusic(List<KtvMusic> r100) {
        List<KtvMusic> r101 = this.songList;
        if (r101 != null) goto L7;
        if (r100 != null) goto L7;
        return true;
    L7:
        if (r101 == null) goto L18;
        if (r100 == null) goto L18;
        int r102 = 0;
    L12:
        if (r102 >= this.songList.size()) goto L17;
        if (((KtvMusic) ListProtector.get(this.songList, r102)).isSameKtvMusic((KtvMusic) ListProtector.get(r100, r102)) == false) goto L15;
        r102 = r102 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    public void setActive(boolean r100) {
        this.isActive = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setActiveName(String r100) {
        this.activeName = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAddPrice(boolean r100) {
        this.isAddPrice = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAddPriceTime(long r100) {
        this.addPriceTime = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAiGuestType(int r100) {
        this.aiGuestType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAlreadyInvited(boolean r100) {
        this.alreadyInvited = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAnchorPlayer(boolean r100) {
        this.isAnchorPlayer = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAnonymous(boolean r100) {
        this.isAnonymous = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAppId(long r100) {
        this.appId = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setApplyType(int r100) {
        this.mApplyType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setApplyTypeNew(int r100) {
        this.applyTypeNew = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setBackground(boolean r100) {
        this.isBackground = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setButtonText(String r100) {
        this.buttonText = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setChorusGuestStatus(long r100) {
        this.chorusGuestStatus = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setCityEffect(ICityEffect r100) {
        this.mCityEffect = (CityEffect) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setClientUIPosition(int r100) {
        this.clientUIPosition = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setClientVersion(long r100) {
        this.clientVersion = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setCornerMarkUrl(String r100) {
        this.cornerMarkUrl = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setDevicePlatform(String r100) {
        this.devicePlatform = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setEnlarged(boolean r100) {
        this.isEnlarged = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setEventInfo(c0 r100) {
        this.eventInfo = (ListUserEventInfo) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setFanTicket(long r100) {
        this.mFanTicket = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setFanTicketDisplayStr(String r100) {
        this.mFanTicketDisplayStr = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setFuzzyFanTicket(String r100) {
        this.fuzzyFanTicket = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setHasApplied(boolean r100) {
        this.isHasApplied = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setHasExposed(boolean r100) {
        this.mHasExposed = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setHasInvited(boolean r100) {
        this.isHasInvited = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setHost(boolean r100) {
        this.isHost = r100;
    }

    public void setInWaitingList(boolean r100) {
        this.isInWaitingList = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setInteractId(String r100) {
        this.mInteractIdStr = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setInteractingState(int r100) {
        this.mInteractingState = r100;
    }

    public void setInterestedType(int[] r100) {
        this.interestedType = r100;
    }

    public void setInviteListUserInfo(InviteListUserInfo r100) {
        this.inviteListUserInfo = r100;
    }

    public void setInviteeType(int r100) {
        this.inviteeType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setInviting(boolean r100) {
        this.isInviting = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setInvitor(IBaseUser r100) {
        this.mInvitor = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setJoinTeamFightInfo(j0 r100) {
        this.joinTeamFightInfo = (TeamFightJoinTeamInfo) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setKSongUid(Long r100) {
        this.kSongUid = r100.longValue();
    }

    public void setLastActiveTimeMillis(long r100) {
        this.lastActiveTimeMillis = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLastInvitedTimeMillis(long r100) {
        this.lastInvitedTimeMillis = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkDuration(long r100) {
        this.linkDuration = (int) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkMicUniqueIdStr(String r100) {
        this.mLinkmicUniqueIdStr = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkRoomId(long r100) {
        this.mLinkRoomId = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkRoomUser(boolean r100) {
        this.mIsLinkRoomUser = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkStatus(int r100) {
        this.mLinkStatus = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkType(int r100) {
        this.mLinkType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkedListUserInfo(o r100) {
        this.linkedListUserInfo = (LinkedListUserInfo) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkmic2DAvatar(Linkmic2DAvatar r100) {
        this.linkmic2DAvatar = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setListUserFromType(int r100) {
        this.listUserFromType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setListUserRole(int r100) {
        this.listUserRole = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setListUserType(int r100) {
        this.listUserType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLocation(String r100) {
        this.location = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMInteractIdStr(String r100) {
        this.mInteractIdStr = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMIsJoinUser(boolean r100) {
        this.mIsJoinUser = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMLinkMicUniqueIdStr(String r100) {
        this.mLinkmicUniqueIdStr = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMLinkStatus(int r100) {
        this.mLinkStatus = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMatchEffect(IMatchEffect r100) {
        this.mMatchEffect = (MatchEffect) r100;
    }

    public void setMcStatus(int r100) {
        this.mcStatus = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMediaType(int r100) {
        this.mediaType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMicDress(kd1.b r100) {
        this.micDress = (MicDress) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMicHidden(boolean r100) {
        this.isMicHidden = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMicPosTagInfo(g0 r100) {
        this.micPosTagInfo = (MicPosTagInfo) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setModifyTime(long r100) {
        this.mModifyTime = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setModifyTimeInNano(long r100) {
        this.modifyTimeInNano = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setOpenSendGift(boolean r100) {
        this.isOpenSendGift = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setOrderedSongCount(long r100) {
        this.orderedSongCount = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setOriginLinkType(long r100) {
        this.originLinkType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setOtherRoomInfo(Map.Entry<Long, ? extends g2> r100) {
        this.otherRoomInfo = r100;
    }

    public void setOutOfDate(boolean r100) {
        this.outOfDate = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setPaidAmount(long r100) {
        this.paidAmount = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setPaidCount(long r100) {
        this.paidCount = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setPaidMoney(int r100) {
        this.paidMoney = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setPaidUserLeave(boolean r100) {
        this.isPaidUserLeave = Boolean.valueOf(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setPositionType(int r100) {
        this.positionType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setRank(long r100) {
        this.rank = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setRoleType(int r100) {
        this.mRoleType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setRoomLinkSilenceStatus(int r100) {
        this.mRoomLinkSilenceStatus = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSelfBackground(boolean r100) {
        this.isSelfBackground = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSelfDisciplineDuration(long r100) {
        this.selfDisciplineDuration = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSelfDisciplineDurationTime(long r100) {
        this.selfDisciplineDuration = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSelfDisciplineTargetDuration(long r100) {
        this.selfDisciplineTargetDuration = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSelfPreOn(boolean r100) {
        this.isSelfPreOn = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setShowCityEffect(boolean r100) {
        this.mShowCityEffect = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSilenceStatus(int r100) {
        this.silenceStatus = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSongList(List<KtvMusic> r100) {
        this.songList = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setStats(int r100) {
        this.stats = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setTag(ListUserTag r100) {
        this.tag = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setTags(List<? extends v> r100) {
        this.tags = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setTalkState(int r100) {
        this.talkState = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setThemedCompetitionRole(int r100) {
        this.themedCompetitionRole = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setUser(IBaseUser r100) {
        this.mUser = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setUserHighScoreSongTag(fc r100) {
        this.userHighScoreSongTag = (UserHighScoreSongTag) r100;
    }

    public void setUserPosition(long r100) {
        this.userPosition = (int) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setUserPositionFlex(int r100) {
        this.userPosition = r100;
    }

    public void setUserRelationType(long r100) {
        this.userRelationType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setVerifyStatus(int r100) {
        this.verifyStatus = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setWaitingListUserInfo(o0 r100) {
        this.waitingListUserInfo = (WaitingListUserInfo) r100;
    }

    public void setmApplyType(int r100) {
        this.mApplyType = r100;
    }

    public void setmCityEffect(CityEffect r100) {
        this.mCityEffect = r100;
    }

    public void setmFanTicket(long r100) {
        this.mFanTicket = r100;
    }

    public void setmFanTicketDisplayStr(String r100) {
        this.mFanTicketDisplayStr = r100;
    }

    public void setmHasExposed(boolean r100) {
        this.mHasExposed = r100;
    }

    public void setmInteractIdStr(String r100) {
        this.mInteractIdStr = r100;
    }

    public void setmInteractingState(int r100) {
        this.mInteractingState = r100;
    }

    public void setmInvitor(IBaseUser r100) {
        this.mInvitor = r100;
    }

    public void setmIsJoinUser(boolean r100) {
        this.mIsJoinUser = r100;
    }

    public void setmIsLinkRoomUser(boolean r100) {
        this.mIsLinkRoomUser = r100;
    }

    public void setmLinkType(int r100) {
        this.mLinkType = r100;
    }

    public void setmMatchEffect(MatchEffect r100) {
        this.mMatchEffect = r100;
    }

    public void setmModifyTime(long r100) {
        this.mModifyTime = r100;
    }

    public void setmRoleType(int r100) {
        this.mRoleType = r100;
    }

    public void setmShowCityEffect(boolean r100) {
        this.mShowCityEffect = r100;
    }

    public void setmUser(IBaseUser r100) {
        this.mUser = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void update(ILinkPlayerInfoBridge r100) {
        if ((r100 instanceof LinkPlayerInfo) == false) goto L14;
        LinkPlayerInfo r101 = (LinkPlayerInfo) r100;
        if (r101 != null) goto L7;
        return;
    L7:
        if (TextUtils.equals(this.mUser.getIdString(), r101.mUser.getIdString()) == false) goto L16;
        this.mFanTicket = r101.mFanTicket;
        this.mFanTicketDisplayStr = r101.mFanTicketDisplayStr;
        this.mUser = r101.mUser;
        long r102 = r101.mModifyTime;
        if (r102 <= this.mModifyTime) goto L12;
        this.mModifyTime = r102;
    L12:
        this.mLinkStatus = r101.mLinkStatus;
        this.mLinkType = r101.mLinkType;
        this.mRoleType = r101.mRoleType;
        this.listUserRole = r101.listUserRole;
        this.paidMoney = r101.paidMoney;
        this.paidCount = r101.paidCount;
        this.linkedListUserInfo = r101.linkedListUserInfo;
        this.micDress = r101.micDress;
        this.isEnlarged = r101.isEnlarged;
        this.linkmic2DAvatar = r101.linkmic2DAvatar;
        this.chorusGuestStatus = r101.chorusGuestStatus;
        this.selfDisciplineDuration = r101.selfDisciplineDuration;
        this.selfDisciplineTargetDuration = r101.selfDisciplineTargetDuration;
        this.themedCompetitionRole = r101.themedCompetitionRole;
        this.waitingListUserInfo = r101.waitingListUserInfo;
        this.rank = r101.rank;
        this.silenceStatus = r101.silenceStatus;
        this.mIsLinkRoomUser = r101.mIsLinkRoomUser;
        this.mLinkRoomId = r101.mLinkRoomId;
        this.mRoomLinkSilenceStatus = r101.mRoomLinkSilenceStatus;
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isEqual(ILinkPlayerInfoBridge r100) {
        return isEqual((LinkPlayerInfo) r100);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMcStatus(long r100) {
        this.mcStatus = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setUserPosition(int r100) {
        this.userPosition = r100;
    }

    public void update(LinkPlayerInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.equals(this.mUser.getIdString(), r100.mUser.getIdString()) == false) goto L12;
        this.mFanTicket = r100.mFanTicket;
        this.mFanTicketDisplayStr = r100.mFanTicketDisplayStr;
        this.mUser = r100.mUser;
        long r101 = r100.mModifyTime;
        if (r101 <= this.mModifyTime) goto L9;
        this.mModifyTime = r101;
    L9:
        this.mLinkStatus = r100.mLinkStatus;
        this.mLinkType = r100.mLinkType;
        this.mRoleType = r100.mRoleType;
        this.listUserRole = r100.listUserRole;
        this.paidMoney = r100.paidMoney;
        this.paidCount = r100.paidCount;
        this.linkedListUserInfo = r100.linkedListUserInfo;
        this.micDress = r100.micDress;
        this.isEnlarged = r100.isEnlarged;
        this.linkmic2DAvatar = r100.linkmic2DAvatar;
        this.chorusGuestStatus = r100.chorusGuestStatus;
        this.selfDisciplineDuration = r100.selfDisciplineDuration;
        this.selfDisciplineTargetDuration = r100.selfDisciplineTargetDuration;
        this.themedCompetitionRole = r100.themedCompetitionRole;
        this.waitingListUserInfo = r100.waitingListUserInfo;
        this.rank = r100.rank;
        this.silenceStatus = r100.silenceStatus;
        this.mIsLinkRoomUser = r100.mIsLinkRoomUser;
        this.mLinkRoomId = r100.mLinkRoomId;
        this.mRoomLinkSilenceStatus = r100.mRoomLinkSilenceStatus;
        return;
    }

    public void updateByLinkUser(com.bytedance.android.livesdk.link.model.bridge.k r100, ListUserExtra r101) {
        this.mUser = r100.getUser();
        this.mInteractIdStr = r100.getLinkMicIdStr();
        this.mLinkStatus = r100.getStatus();
        this.userPosition = r100.getUserPosition();
        this.silenceStatus = r100.getSilenceStatus();
        this.mModifyTime = r100.getModifyTime();
        this.mRoleType = r100.getRoleType();
        this.mLinkType = r100.getLinkType();
        this.mediaType = r100.getApplyType();
        boolean r102 = true;
        if (r100.isBackground() != 1) goto L5;
        boolean r103 = true;
    L6:
        this.isBackground = r103;
        if (r100.getContent() == null) goto L12;
        if (r100.getContent().getLinkMicAudienceContent() == null) goto L12;
        this.linkmic2DAvatar = r100.getContent().getLinkMicAudienceContent().getLinkmic2DAvatar();
    L12:
        if (r100.getContent() != null) goto L14;
    L18:
        r102 = false;
    L19:
        this.isEnlarged = r102;
        if (r100.getContent() != null) goto L22;
    L24:
        if (r101 == null) goto L27;
        this.mFanTicket = r101.fanTicket;
        this.listUserRole = r101.listUserRole;
        this.linkedListUserInfo = LinkedListUserInfo.copy(r101.joinChannelTime, r101.expectLeaveTime, r101.currentTime);
        return;
    L27:
        return;
    L22:
        if (r100.getContent().getLinkMicAudienceContent() == null) goto L24;
        this.selfDisciplineDuration = r100.getContent().getLinkMicAudienceContent().getSelfDisciplineDurationTime();
        this.selfDisciplineTargetDuration = r100.getContent().getLinkMicAudienceContent().getSelfDisciplineDurationTime();
        this.themedCompetitionRole = r100.getContent().getLinkMicAudienceContent().getThemedCompetitionRole();
        this.chorusGuestStatus = r100.getContent().getLinkMicAudienceContent().getChorusGuestStatus();
        goto L24
    L14:
        if (r100.getContent().getLinkMicAudienceContent() == null) goto L18;
        if (r100.getContent().getLinkMicAudienceContent().isEnlarged() == false) goto L18;
    L5:
        r103 = false;
        goto L6
    }
}
