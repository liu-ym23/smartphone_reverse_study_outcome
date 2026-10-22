package com.bytedance.android.livesdk.announce;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    @SerializedName("all_group_list")
    List<AnnouncementFanGroupInfo> allGroupList;

    @SerializedName("appointment_list")
    List<AnnouncementInfo> announcementInfos;

    @SerializedName("available")
    Boolean available;

    @SerializedName("ban_toast")
    String banToast;

    @SerializedName("ban_type_v2")
    String banTypeV2;

    @SerializedName("banned_status")
    int bannedStatus;

    @SerializedName("live_room_appointment_sticker")
    public boolean enableAnchorAutoShowSticker;

    @SerializedName("create_page_top_hint")
    public e hint;

    @SerializedName("question_url")
    String questionUrl;

    @SerializedName("red_packets")
    public List<RedPacket> redPackets;

    @SerializedName("show_red_packet")
    public boolean showRedPacket;

    @SerializedName("unperformance_detail_url")
    String unperFormanceDetailUrl;

    public a() {
        this.hint = null;
        this.showRedPacket = false;
        this.redPackets = null;
        this.enableAnchorAutoShowSticker = false;
    }

    public final List<AnnouncementInfo> a() {
        return this.announcementInfos;
    }
}
