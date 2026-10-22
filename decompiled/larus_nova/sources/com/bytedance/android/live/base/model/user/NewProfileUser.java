package com.bytedance.android.live.base.model.user;

import android.text.TextUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class NewProfileUser extends FlexModelBase<b0> implements b0 {

    @SerializedName("account_stats")
    public AccountStats accountStats;

    @SerializedName("action_config")
    public List<ActionConfig> actionConfig;

    @SerializedName("action_configs")
    public ActionConfigs actionConfigs;

    @SerializedName("activity_badges")
    public ActivityBadges activityBadges;

    @SerializedName("admin_info")
    public AdminInfo adminInfo;

    @SerializedName("adversary_authorization_info")
    public int adversaryAuthorizationInfo;

    @SerializedName("AnchorAudienceRelationInfo")
    public String anchorAudienceRelationInfo;

    @SerializedName("broadcast_config")
    public p anchorLiveConfig;

    @SerializedName(ActivityVO.APPOINTMENT)
    public Appointment appointment;

    @SerializedName("authorization_info")
    public int authorizationInfo;

    @SerializedName("base_info")
    public BaseProfileInfo baseProfileInfo;

    @SerializedName("basic_area")
    public ProfileBasicArea basicArea;

    @SerializedName("consumer_centre_info")
    ConsumerCentreInfo consumerCentreInfo;

    @SerializedName("contributor")
    public Contributor contributor;

    @SerializedName("dress_suit_info")
    DressSuitInfo dressSuitInfo;

    @SerializedName("dress_visitor_info")
    public DressVisitorInfo dressVisitorInfo;

    @SerializedName("ecom_card_dsl")
    public DslTemplate ecomBottomCardDsl;

    @SerializedName("ecom_info")
    public EcomInfo ecomInfo;

    @SerializedName(PbRequest.SwitchType.FANS_CLUB)
    public ProfileFansClub fansClub;

    @SerializedName("fans_group_info")
    public u fansGroupInfo;

    @SerializedName("follow_info")
    public c0 followInfo;
    private boolean fromOtherIntercomRoom;

    @SerializedName("gift_exhibition_banner")
    public ProfileGiftExhibitionBanner giftExhibitionBanner;

    @IgnoreProtoFieldCheck
    @SerializedName("gift_exhibition_home_stats")
    public GiftExhibitionHomeStats giftExhibitionInfo;

    @SerializedName("grade")
    public py.k grade;

    @SerializedName("group_info")
    public GroupInfo groupInfo;

    @SerializedName("high_score_song_info")
    public ProfileHighScoreSong highScoreSong;

    @SerializedName("honor_wall_ui")
    public HonorWallUi honorWallUi;

    @SerializedName("honor_wall_v2")
    public HonorWallV2 honorWallV2;

    @SerializedName("industry_certification")
    public x industryCertification;

    @IgnoreProtoFieldCheck
    @SerializedName("industry_certification_profile")
    public y industryCertificationProfile;

    @SerializedName("is_muted")
    public boolean isMuted;

    @SerializedName("live_agent_info")
    public LiveAgentInfo liveAgentInfo;

    @SerializedName("live_anchor_rank_honor")
    public LiveAnchorRankHonor liveAnchorRankHonor;

    @SerializedName("authentication_info")
    public py.c mAuthenticationInfo;

    @SerializedName("profile_skin")
    public ProfileSkin mProfileSkin;

    @SerializedName(ComplianceResult.JsonKey.AUTH_INFO)
    public NewAuthenticationInfo newAuthInfo;

    @SerializedName("open_area")
    public ProfileOpenArea openArea;

    @SerializedName("own_room")
    public ProfileOwnRoom ownRoom;

    @SerializedName("potential_customer_info")
    public ProfilePotentialCustomerInfo potentialCustomerInfo;

    @SerializedName("profile_setting")
    public ProfileSetting profileSetting;

    @SerializedName("profile_style_params")
    ProfileStyleParams profileStyleParams;

    @SerializedName("profile_tag_content")
    public List<ProfileTagContent> profileTagContents;

    @SerializedName("profile_tag_switch")
    public long profileTagSwitch;

    @SerializedName("shop_entrance")
    public ShopEntrance shopEntrance;

    @SerializedName("shop_fans_club")
    public ProfileFansClub shopFansClub;

    @SerializedName("subscribe_info")
    public SubscribeInfo subscribeInfo;

    @SerializedName("upper_area")
    public ProfileUpperArea upperArea;

    @SerializedName("white_category_cert")
    public WhiteCategoryCert whiteCategoryCert;

    public NewProfileUser() {
        super(b0.class);
        this.baseProfileInfo = new BaseProfileInfo();
    }

    public boolean canJumpToLiveRoom() {
        ProfileOwnRoom r100 = this.ownRoom;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.canJumpToLiveRoom() == true) goto L8;
        return false;
    }

    public long getBusinessAreaVersion() {
        ProfileOpenArea r100 = this.openArea;
        if (r100 != null) goto L7;
        return 2;
    L7:
        return r100.businessAreaVersion;
    }

    public String getDisplayName() {
        c0 r100 = this.followInfo;
        if (r100 != null) goto L5;
    L8:
        BaseProfileInfo r101 = this.baseProfileInfo;
        if (r101 != null) goto L11;
        return null;
    L11:
        if (TextUtils.isEmpty(r101.remarkName) == true) goto L15;
        return this.baseProfileInfo.remarkName;
    L15:
        return this.baseProfileInfo.nickName;
    L5:
        if (TextUtils.isEmpty(r100.getRemarkName()) == true) goto L8;
        return this.followInfo.getRemarkName();
    }

    public long getLiveRoomId() {
        ProfileOwnRoom r100 = this.ownRoom;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getId();
    }

    public boolean isEnterpriseVerify() {
        py.c r100 = this.mAuthenticationInfo;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.getEnterpriseVerifyReason()) == true) goto L7;
        return true;
    }

    public boolean isFollowed() {
        c0 r100 = this.followInfo;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getFollowStatus() != 2) goto L8;
    L9:
        return true;
    L8:
        if (this.followInfo.getFollowStatus() == 3) goto L9;
        return false;
    }

    public boolean isFollowing() {
        c0 r100 = this.followInfo;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getFollowStatus() != 2) goto L8;
    L9:
        return true;
    L8:
        if (this.followInfo.getFollowStatus() == 1) goto L9;
        return false;
    }

    public boolean isPersonVerify() {
        py.c r100 = this.mAuthenticationInfo;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.getCustomVerify()) == true) goto L7;
        return true;
    }

    public boolean isVcdContentAuthorized() {
        if ((this.authorizationInfo & 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean useStandardTag() {
        if (this.profileTagSwitch != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public ProfileGiftExhibitionBanner getGiftExhibitionBannerData() {
        if (useStandardHonorWallV3() == false) goto L13;
        ProfileOpenArea r100 = this.openArea;
        if (r100 == null) goto L11;
        ProfileBusinessArea r101 = r100.businessAreaV3;
        if (r101 == null) goto L11;
        return r101.exhibitionBanner;
    L11:
        return this.giftExhibitionBanner;
    L13:
        return this.giftExhibitionBanner;
    }

    public List<HonorWallElement> getHonourWallData() {
        if (useStandardHonorWallV3() == false) goto L10;
        ProfileOpenArea r100 = this.openArea;
        if (r100 == null) goto L14;
        ProfileBusinessArea r101 = r100.businessAreaV3;
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.bottomElementList;
    L14:
        return null;
    L10:
        HonorWallV2 r102 = this.honorWallV2;
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102.honorWallElement;
    }

    public boolean useStandardHonorWallV3() {
        if (getBusinessAreaVersion() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public Appointment getAppointment() {
        return this.appointment;
    }

    @Override // com.bytedance.android.live.base.model.user.b0
    public k getBaseProfileInfo() {
        return this.baseProfileInfo;
    }

    public ConsumerCentreInfo getConsumerCentreInfo() {
        return this.consumerCentreInfo;
    }

    public DressSuitInfo getDressSuitInfo() {
        return this.dressSuitInfo;
    }

    public EcomInfo getEcomInfo() {
        return this.ecomInfo;
    }

    @Override // com.bytedance.android.live.base.model.user.b0
    public c0 getFollowInfo() {
        return this.followInfo;
    }

    public x getIndustryCertification() {
        return this.industryCertification;
    }

    public LiveAgentInfo getLiveAgentInfo() {
        return this.liveAgentInfo;
    }

    public ProfileSetting getProfileSetting() {
        return this.profileSetting;
    }

    public ProfileStyleParams getProfileStyleParams() {
        return this.profileStyleParams;
    }

    public boolean isFromOtherIntercomRoom() {
        return this.fromOtherIntercomRoom;
    }

    @Override // com.bytedance.android.live.base.model.user.b0
    public boolean isMuted() {
        return this.isMuted;
    }

    public void setFollowStatus(int r100) {
        c0 r101 = this.followInfo;
        if (r101 == null) goto L6;
        r101.setFollowStatus(r100);
        return;
    }

    public void setFromOtherIntercomRoom(boolean r100) {
        this.fromOtherIntercomRoom = r100;
    }

    public void setIndustryCertification(x r100) {
        this.industryCertification = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.b0
    public void setMuted(boolean r100) {
        this.isMuted = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.b0
    public void translateAwemeUserBaseProfileInfo(k r100) {
        BaseProfileInfo r101 = new BaseProfileInfo();
        r101.nickName = r100.getNickname();
        r101.idStr = r100.getIdStr();
        r101.secUid = r100.getSecUid();
        this.baseProfileInfo = r101;
    }
}
