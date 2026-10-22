package com.bytedance.android.livesdk.chatroom.event;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.livesdk.message.model.vh;
import com.bytedance.android.livesdk.utils.d5;
import java.util.HashMap;
import java.util.Map;
import tlc.d;
import zg1.r;
import zg1.u;

/* JADX INFO: loaded from: classes7.dex */
public class UserProfileEvent {
    public static final String CLICK_POS_COMMENT = "comment_area";
    public static final String DATA_TYPE_ANCHOR_AUDIENCE_INTERACT_GAME = "data_type_anchor_audience_interact_game";
    public static final String DATA_TYPE_CARD_ANCHOR = "data_card_anchor";
    public static final String DATA_TYPE_CARD_AUDIENCE = "data_card_audience";
    public static final String DATA_TYPE_CARD_BARRAGE = "data_card_barrage";
    public static final String DATA_TYPE_CARD_GUEST_LINK = "data_card_guest_link";
    public static final String DATA_TYPE_CARD_HOURLY_RANK = "data_card_hourly_rank";
    public static final String DATA_TYPE_CARD_INCOME_INFO = "data_card_incomeinfo";
    public static final String DATA_TYPE_CARD_LINKED_ANCHOR = "data_card_linked_anchor";
    public static final String DATA_TYPE_CARD_LINKED_AUDIENCE = "data_card_linked_audience";
    public static final String DATA_TYPE_CARD_LINKED_AUDIENCE_MULTIAUDIENCE = "data_card_linked_audience_mutiaudience";
    public static final String DATA_TYPE_CARD_LINKER_RANK = "data_type_card_linker_rank";
    public static final String DATA_TYPE_CARD_PK_ANCHOR = "data_card_pk_anchor";
    public static final String DATA_TYPE_CARD_SEND_GIFT_INFO = "data_card_sendgiftinfo";
    public static final String DATA_TYPE_HOME_PAGE_HOT = "homepage_hot";
    public static final String DATA_TYPE_KEEP_PRESS = "keep_press";
    public static final String DATA_TYPE_MORE = "more";
    public static final String LIVESTORE_SETTING = "livestore_setting";
    public static final String POSITION_ANCHOR_AUDIENCE_INTERACT_GAME_PANEL = "game_panel";
    public static final String POSITION_AUDIO_CHAT = "audio_chat_message";
    public static final String POSITION_ENTER_EFFECT = "enter_effect";
    public static final String POSITION_GIFT_TRAY = "gift_tray_head_portrait";
    public static final String POSITION_GUEST_LINK = "guest_link";
    public static final String POSITION_LINKED_ANCHOR = "linked_anchor";
    public static final String POSITION_LINKED_ANCHOR_MANAGE_SETTING = "connection_manage_setting";
    public static final String POSITION_LINKED_AUDIENCE = "pk_linked_audience";
    public static final String POSITION_LINKED_AUDIENCE_MULTIAUDIENCE = "linked_audience_multiaudience";
    public static final String POSITION_MY_LIVE = "my_live_entrance";
    public static final String POSITION_NONE = "NONE";
    public static final String POSITION_OPEN_EFFECT = "package_open_effect";
    public static final String POSITION_OPEN_TOP_LEFT_ANCHOR = "live_open_top_left_anchor";
    public static final String POSITION_PK_HISTORY_RECORD = "pk_history";
    public static final String POSITION_PK_LINKED_ANCHOR = "pk_linked_anchor";
    public static final String POSITION_PK_RIGHT_ANCHOR = "live_pk_right_anchor";
    public static final String POSITION_PROFILE_GROUP_MEMBER = "profile_group_member";
    public static final String POSITION_RED_PACKET = "redpackage";
    public static final String POSITION_ROOM_INTRO = "room_intro";
    public static final String POSITION_SCREEN_LIVE_ANCHOR = "screen_live_anchor";
    public static final String POSITION_SINGLE_ROOM_RANK = "single_room_rank";
    public static final String POSITION_TOP_SINGLE_ROOM_RANK = "top_single_room_rank";
    public static final String SOURCE_ANCHOR_AVATAR = "anchor_profile";
    public static final String SOURCE_BARRAGE = "live_barrage";
    public static final String SOURCE_COMMENT = "personal_profile";
    public static final String SOURCE_NONE_LINK_PK = "anchor_none_link_pk";
    public static final String SOURCE_PLAYER_EXTRACE_RENDER_DESC = "player_extra_render";
    public static final String SOURCE_ROOM_CHANNEL = "room_channel_panel";
    public static final String SOURCE_ROOM_CHANNEL_LINK = "room_channel_link";
    public static final String SOURCE_SUIT_TRANSITION = "50";
    public static final String SOURCE_VSTOPIC = "vs_record_video";
    public static final String SOURCE_VSTOPIC_HEAD = "discussion_official_profile_card";
    public String enterMethod;
    public HashMap<String, String> extraFollowParams;
    private Map<String, String> extraProfileClickUserLog;
    private Map<String, String> extraProfileShowLog;
    private boolean fallbackFromLynx;
    public boolean forceHideDynamicComponent;
    public boolean forceNoRotate;
    public boolean forceShowProfile;
    public boolean forceShowRoomEntrance;
    public boolean forceShowToast;
    public int fromRoomChannelType;
    public String interactLogLabel;
    private boolean intercomHideUserCard;
    public boolean isAnonymous;
    private boolean isForceSecret;
    public boolean isFromInteractEmojiPanel;
    private boolean isFromOtherIntercomRoom;
    public boolean isFromRecommendDialog;
    public int isFromUserNickname;
    private boolean isShortVideoAuthor;
    private boolean isSkipExistPanelCheck;
    private boolean isSkipPrivacyCheck;
    public String ksongToUserType;
    public String ksongUserType;
    public String ktvChallengePlayerType;
    public r mChannelLinkReportModel;
    public d mClickFromMessage;
    public String mClickUserPosition;
    public u mCommentReportModel;
    public String mEventModule;
    public String mReportSource;
    public String mReportTypeForLog;
    public String mSource;
    public String mUserStatus;
    public int mysteryMan;
    public int order;
    public vh originRoomInfo;
    private String reportObject;
    public String reportType;
    public String requestPage;
    public String secUserId;
    public boolean showSendGift;
    public String toCommentCategory;
    public String toDiscussionBoardCommentId;
    public String unionId;
    public IBaseUser user;
    private long userId;
    private String userIdStr;
    public String userSecId;
    public String vsFollowPosition;
    public String wearId;

    public Long getCommentMsgId() {
        u r100 = this.mCommentReportModel;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r100.a());
    }

    public String getTargetUid() {
        IBaseUser r100 = this.user;
        if (r100 == null) goto L7;
        return r100.getIdString();
    L7:
        return getUserIdStr();
    }

    public String getUserIdStr() {
        return n0.e(Long.valueOf(this.userId), this.userIdStr);
    }

    public boolean showProfileInfoCard() {
        if (TextUtils.equals(POSITION_LINKED_AUDIENCE, getClickUserPosition()) == false) goto L5;
    L12:
        return true;
    L5:
        if (TextUtils.equals(POSITION_LINKED_ANCHOR, getClickUserPosition()) == true) goto L12;
        if (TextUtils.equals(POSITION_PK_LINKED_ANCHOR, getClickUserPosition()) == true) goto L12;
        if (TextUtils.equals(POSITION_LINKED_AUDIENCE_MULTIAUDIENCE, getClickUserPosition()) == true) goto L12;
        return false;
    }

    public String getClickUserPosition() {
        return this.mClickUserPosition;
    }

    public HashMap<String, String> getExtraFollowParams() {
        return this.extraFollowParams;
    }

    public Map<String, String> getExtraProfileClickUserLog() {
        return this.extraProfileClickUserLog;
    }

    public Map<String, String> getExtraProfileShowLog() {
        return this.extraProfileShowLog;
    }

    public String getKsongToUserType() {
        return this.ksongToUserType;
    }

    public String getKsongUserType() {
        return this.ksongUserType;
    }

    public int getOrder() {
        return this.order;
    }

    public String getReportObject() {
        return this.reportObject;
    }

    public boolean getShowSendGift() {
        return this.showSendGift;
    }

    public String getVsFollowPosition() {
        return this.vsFollowPosition;
    }

    public boolean isFallbackFromLynx() {
        return this.fallbackFromLynx;
    }

    public boolean isForceSecret() {
        return this.isForceSecret;
    }

    public boolean isFromOtherIntercomRoom() {
        return this.isFromOtherIntercomRoom;
    }

    public boolean isIntercomHideUserCard() {
        return this.intercomHideUserCard;
    }

    public boolean isShortVideoAuthor() {
        return this.isShortVideoAuthor;
    }

    public boolean isSkipExistPanelCheck() {
        return this.isSkipExistPanelCheck;
    }

    public boolean isSkipPrivacyCheck() {
        return this.isSkipPrivacyCheck;
    }

    public UserProfileEvent(IBaseUser r100) {
        this.userSecId = "";
        this.forceShowToast = false;
        this.forceHideDynamicComponent = false;
        this.originRoomInfo = null;
        this.order = -1;
        this.showSendGift = false;
        this.vsFollowPosition = "";
        this.forceNoRotate = false;
        this.wearId = "";
        this.toCommentCategory = "";
        this.toDiscussionBoardCommentId = "";
        this.requestPage = "";
        this.reportType = "";
        this.forceShowRoomEntrance = false;
        this.enterMethod = "personal_detail";
        this.isForceSecret = false;
        this.forceShowProfile = false;
        this.isFromInteractEmojiPanel = false;
        this.ktvChallengePlayerType = null;
        this.isSkipPrivacyCheck = false;
        this.isSkipExistPanelCheck = false;
        this.fromRoomChannelType = 0;
        this.reportObject = null;
        if (r100 == null) goto L7;
        this.user = r100;
        this.secUserId = r100.getCastSecUid();
        return;
    L7:
        throw new RuntimeException("mUser cannot be null!");
    }

    public UserProfileEvent setClickUserPosition(String r100) {
        this.mClickUserPosition = r100;
        return this;
    }

    public void setEventModule(String r100) {
        this.mEventModule = r100;
    }

    public void setExtraFollowParams(HashMap<String, String> r100) {
        this.extraFollowParams = r100;
    }

    public void setFallbackFromLynx(boolean r100) {
        this.fallbackFromLynx = r100;
    }

    public void setForceSecret(boolean r100) {
        this.isForceSecret = r100;
    }

    public UserProfileEvent setFromInteractEmojiPanel(boolean r100) {
        this.isFromInteractEmojiPanel = r100;
        return this;
    }

    public void setFromOtherIntercomRoom(boolean r100) {
        this.isFromOtherIntercomRoom = r100;
    }

    public void setIntercomHideUserCard(boolean r100) {
        this.intercomHideUserCard = r100;
    }

    public void setKsongToUserType(String r100) {
        this.ksongToUserType = r100;
    }

    public void setKsongUserType(String r100) {
        this.ksongUserType = r100;
    }

    public UserProfileEvent setKtvChallengePlayerType(String r100) {
        this.ktvChallengePlayerType = r100;
        return this;
    }

    public void setOrder(int r100) {
        this.order = r100;
    }

    public void setReportObject(String r100) {
        this.reportObject = r100;
    }

    public UserProfileEvent setReportSource(String r100) {
        this.mReportSource = r100;
        return this;
    }

    public UserProfileEvent setReportType(String r100) {
        this.mReportTypeForLog = r100;
        return this;
    }

    public void setShortVideoAuthor(boolean r100) {
        this.isShortVideoAuthor = r100;
    }

    public UserProfileEvent setShowSendGift(boolean r100) {
        this.showSendGift = r100;
        return this;
    }

    public void setSkipExistPanelCheck(boolean r100) {
        this.isSkipExistPanelCheck = r100;
    }

    public void setSkipPrivacyCheck(boolean r100) {
        this.isSkipPrivacyCheck = r100;
    }

    public void setVsFollowPosition(String r100) {
        this.vsFollowPosition = r100;
    }

    public UserProfileEvent(String r100) {
        this.userSecId = "";
        this.forceShowToast = false;
        this.forceHideDynamicComponent = false;
        this.originRoomInfo = null;
        this.order = -1;
        this.showSendGift = false;
        this.vsFollowPosition = "";
        this.forceNoRotate = false;
        this.wearId = "";
        this.toCommentCategory = "";
        this.toDiscussionBoardCommentId = "";
        this.requestPage = "";
        this.reportType = "";
        this.forceShowRoomEntrance = false;
        this.enterMethod = "personal_detail";
        this.isForceSecret = false;
        this.forceShowProfile = false;
        this.isFromInteractEmojiPanel = false;
        this.ktvChallengePlayerType = null;
        this.isSkipPrivacyCheck = false;
        this.isSkipExistPanelCheck = false;
        this.fromRoomChannelType = 0;
        this.reportObject = null;
        this.userIdStr = r100;
        this.userId = d5.c(r100);
    }

    public UserProfileEvent(IBaseUser r100, String r101) {
        this(r100);
        this.interactLogLabel = r101;
    }

    public void addProfileClickUserExtraLog(String r100, String r101) {
        if (r100 == null) goto L10;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.extraProfileClickUserLog != null) goto L8;
        this.extraProfileClickUserLog = new HashMap();
    L8:
        this.extraProfileClickUserLog.put(r100, r101);
        return;
    }

    public void addProfileShowExtraLog(String r100, String r101) {
        if (r100 == null) goto L10;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.extraProfileShowLog != null) goto L8;
        this.extraProfileShowLog = new HashMap();
    L8:
        this.extraProfileShowLog.put(r100, r101);
        return;
    }
}
