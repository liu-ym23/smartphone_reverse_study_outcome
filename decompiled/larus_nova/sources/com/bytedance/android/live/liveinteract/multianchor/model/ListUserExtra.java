package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ListUserExtra extends FlexModelBase<c> implements c {

    @SerializedName("app_id")
    public long appId;

    @SerializedName("client_version")
    public long clientVersion;

    @SerializedName("current_time")
    public long currentTime;

    @SerializedName("device_platform")
    public String devicePlatform;

    @SerializedName("expected_leave_time")
    public long expectLeaveTime;

    @SerializedName("fan_ticket")
    public long fanTicket;

    @SerializedName("fan_ticket_fuzzy_str")
    public String fanTicketFuzzyStr;

    @SerializedName("fan_ticket_real_str")
    public String fanTicketRealStr;

    @SerializedName("host_permission")
    public boolean isHost;

    @SerializedName("join_channel_time")
    public long joinChannelTime;

    @SerializedName("list_user_role")
    public int listUserRole;

    @SerializedName("rank_contributor_open_ids")
    List<String> rankContributorOpenIds;

    @SerializedName("rank_contributor_ids")
    public List<Long> rankUserIds;

    public ListUserExtra() {
        super(c.class);
    }

    public List<String> getRankUserIdStrList() {
        List<String> r100 = this.rankContributorOpenIds;
        int r101 = n0.f58945a;
        o0.f58946a.getClass();
        return o0.a.h(r100);
    }

    public String toString() {
        return "ListUserExtra{fanTicket=" + this.fanTicket + ", isHost=" + this.isHost + ", joinChannelTime=" + this.joinChannelTime + ", expectLeaveTime=" + this.expectLeaveTime + ", currentTime=" + this.currentTime + '}';
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    public long getAppId() {
        return this.appId;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    public long getClientVersion() {
        return this.clientVersion;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    public long getCurrentTime() {
        return this.currentTime;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    public String getDevicePlatform() {
        return this.devicePlatform;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    public long getExpectLeaveTime() {
        return this.expectLeaveTime;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    public long getFanTicket() {
        return this.fanTicket;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    public String getFanTicketFuzzyStr() {
        return this.fanTicketFuzzyStr;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    public String getFanTicketRealStr() {
        return this.fanTicketRealStr;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    public long getJoinChannelTime() {
        return this.joinChannelTime;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    public int getListUserRole() {
        return this.listUserRole;
    }

    public List<Long> getRankUserIds() {
        return this.rankUserIds;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.c
    public boolean isHost() {
        return this.isHost;
    }
}
