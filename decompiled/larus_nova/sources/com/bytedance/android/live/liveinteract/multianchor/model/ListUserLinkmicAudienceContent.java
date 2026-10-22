package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ListUserLinkmicAudienceContent extends FlexModelBase<l1> implements l1 {

    @SerializedName("ai_guest_type")
    public int aiGuestType;

    @SerializedName("chorus_guest_status")
    public long chorusGuestStatus;

    @SerializedName("extra")
    public String extra;

    @IgnoreProtoFieldCheck
    @SerializedName("in_waiting_list")
    public boolean isInWaitingList;

    @SerializedName("is_mic_hidden")
    public boolean isMicHidden;

    @IgnoreProtoFieldCheck
    @SerializedName("linkmic_2d_avatar")
    public Linkmic2DAvatar linkmic2DAvatar;

    @SerializedName("app_id")
    public long mAppId;

    @SerializedName("client_version")
    public long mClientVersion;

    @SerializedName("current_time")
    public long mCurrentTime;

    @SerializedName("device_platform")
    public String mDevicePlatform;

    @SerializedName("expected_leave_time")
    public long mExpectLeaveTime;

    @SerializedName("fan_ticket")
    public long mFanTicket;

    @SerializedName("fan_ticket_fuzzy_str")
    public String mFanTicketFuzzyStr;

    @SerializedName("fan_ticket_real_str")
    public String mFanTicketRealStr;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS)
    public boolean mIsAnonymous;

    @SerializedName("is_enlarged")
    public boolean mIsEnlarged;

    @SerializedName("host_permission")
    public boolean mIsHost;

    @SerializedName("join_channel_time")
    public long mJoinChannelTime;

    @SerializedName("list_user_role")
    public int mListUserRole;

    @SerializedName("paid_count")
    public long mPaidCount;

    @SerializedName("self_discipline_duration")
    public long mSelfDisciplineDurationTime;

    @SerializedName("mic_dress")
    public MicDress micDress;

    @SerializedName("origin_link_type")
    public long originLinkType;

    @SerializedName("rank_contributor_ids")
    public List<Long> rankUserIds;

    @SerializedName("rank_contributor_open_ids")
    public List<String> rankUserOpenIds;

    @SerializedName("self_discipline_start_time_ms")
    public long selfDisciplineStartTime;

    @SerializedName("self_discripline_target_duration")
    public long selfDisciplineTargetDuration;

    @SerializedName("themed_competition_role")
    public int themedCompetitionRole;

    public ListUserLinkmicAudienceContent() {
        super(l1.class);
    }

    public List<String> getRankUserIdStrList() {
        List<String> r100 = this.rankUserOpenIds;
        int r101 = n0.f58945a;
        o0.f58946a.getClass();
        return o0.a.h(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public int getAiGuestType() {
        return this.aiGuestType;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getAppId() {
        return this.mAppId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getChorusGuestStatus() {
        return this.chorusGuestStatus;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getClientVersion() {
        return this.mClientVersion;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getCurrentTime() {
        return this.mCurrentTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public String getDevicePlatform() {
        return this.mDevicePlatform;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getExpectLeaveTime() {
        return this.mExpectLeaveTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getFanTicket() {
        return this.mFanTicket;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public String getFanTicketFuzzyStr() {
        return this.mFanTicketFuzzyStr;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public String getFanTicketRealStr() {
        return this.mFanTicketRealStr;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getJoinChannelTime() {
        return this.mJoinChannelTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public Linkmic2DAvatar getLinkmic2DAvatar() {
        return this.linkmic2DAvatar;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public int getListUserRole() {
        return this.mListUserRole;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public kd1.b getMicDress() {
        return this.micDress;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getOriginLinkType() {
        return this.originLinkType;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getPaidCount() {
        return this.mPaidCount;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getSelfDisciplineDurationTime() {
        return this.mSelfDisciplineDurationTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getSelfDisciplineStartTime() {
        return this.selfDisciplineStartTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public long getSelfDisciplineTargetDuration() {
        return this.selfDisciplineTargetDuration;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public int getThemedCompetitionRole() {
        return this.themedCompetitionRole;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public boolean isAnonymous() {
        return this.mIsAnonymous;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public boolean isEnlarged() {
        return this.mIsEnlarged;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public boolean isHost() {
        return this.mIsHost;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public boolean isMicHidden() {
        return this.isMicHidden;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setAiGuestType(int r100) {
        this.aiGuestType = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setAppId(long r100) {
        this.mAppId = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setChorusGuestStatus(long r100) {
        this.chorusGuestStatus = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setClientVersion(long r100) {
        this.mClientVersion = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setCurrentTime(long r100) {
        this.mCurrentTime = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setDevicePlatform(String r100) {
        this.mDevicePlatform = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setExpectLeaveTime(long r100) {
        this.mExpectLeaveTime = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setFanTicket(long r100) {
        this.mFanTicket = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setFanTicketFuzzyStr(String r100) {
        this.mFanTicketFuzzyStr = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setFanTicketRealStr(String r100) {
        this.mFanTicketRealStr = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setHost(boolean r100) {
        this.mIsHost = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setJoinChannelTime(long r100) {
        this.mJoinChannelTime = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setLinkmic2DAvatar(Linkmic2DAvatar r100) {
        this.linkmic2DAvatar = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setListUserRole(int r100) {
        this.mListUserRole = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setMicDress(kd1.b r100) {
        this.micDress = (MicDress) r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setMicHidden(boolean r100) {
        this.isMicHidden = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setOriginLinkType(long r100) {
        this.originLinkType = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setSelfDisciplineDurationTime(long r100) {
        this.mSelfDisciplineDurationTime = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setSelfDisciplineTargetDuration(long r100) {
        this.selfDisciplineTargetDuration = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.l1
    public void setThemedCompetitionRole(int r100) {
        this.themedCompetitionRole = r100;
    }
}
