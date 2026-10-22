package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class PermissionResult {
    private static final String[] AUTH_TYPES = null;
    public static final int GIFT_SETTING_CLOSE_ACCOUNT = 2;
    public static final int GIFT_SETTING_CLOSE_ALL = 3;
    public static final int GIFT_SETTING_OPEN = 1;
    public static final int GIFT_SETTING_OPEN_ECOM = 6;
    public static final int PERMISSION_CLOSE = 0;
    public static final int PERMISSION_MINI_APP = 4;
    public static final int PERMISSION_OPEN = 1;

    @SerializedName("announcement")
    public AnnouncementInfo announcementInfo;

    @SerializedName("authentication_type")
    public int authType;

    @SerializedName("broadcast_config")
    public ScheduledSettingInfo broadcastConfig;

    @SerializedName("buy_subscribe_switch")
    public int canBuyVIP;

    @SerializedName("shop_playback")
    public boolean commerceReplay;

    @SerializedName("shop_request_explain")
    public boolean commerceRequestExplain;

    @SerializedName("show_gift_setting_switch")
    private int giftSettingSwitch;

    @SerializedName("group_chat")
    public int groupChat;

    @SerializedName("highlight")
    private int highlight;

    @SerializedName("live_commercial")
    public boolean liveCommercial;

    @SerializedName("play_back")
    private int playBack;

    @SerializedName("realtime_playback")
    public boolean realTimePlayback;

    @SerializedName("record")
    private int record;

    @SerializedName("last_room")
    public LastRoomInfo roomInfo;

    @SerializedName("show_live_life_entry")
    public int showGroupPurchaseEntry;

    @SerializedName("stamps")
    public List<Integer> stamps;

    @SerializedName("welfare_info")
    public WelfarePermissionInfo welfarePermissionInfo;

    public PermissionResult() {
    }

    public static boolean isGiftSettingSwitchDisplay(int r100) {
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 6) goto L10;
        return false;
    L10:
        return true;
    }

    static {
        AUTH_TYPES = new String[]{"others", "enterprise"};
    }

    public String getAuthTypeExcludeDefault() {
        int r100 = this.authType;
        if (r100 <= 0) goto L9;
        String[] r101 = AUTH_TYPES;
        if (r100 < r101.length) goto L8;
        return null;
    L8:
        return r101[r100];
    L9:
        return null;
    }

    public String getAuthTypeStr() {
        int r100 = this.authType;
        if (r100 < 0) goto L9;
        String[] r101 = AUTH_TYPES;
        if (r100 < r101.length) goto L8;
        return null;
    L8:
        return r101[r100];
    L9:
        return null;
    }

    public boolean hasLastRoomInfo() {
        LastRoomInfo r100 = this.roomInfo;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L7;
        return true;
    }

    public boolean hasMiniAppPermission() {
        List<Integer> r100 = this.stamps;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains(4) == false) goto L7;
        return true;
    }

    public boolean hasSettingPermission() {
        if (this.playBack == 0) goto L5;
    L10:
        return true;
    L5:
        if (this.record != 0) goto L10;
        if (this.broadcastConfig != null) goto L10;
        return false;
    }

    public boolean shouldShowGroupPurchaseEntry() {
        if (this.showGroupPurchaseEntry == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "PermissionResult{playBack=" + this.playBack + ", record=" + this.record + ", highlight=" + this.highlight + ", broadcastConfig=" + this.broadcastConfig + ", roomInfo=" + this.roomInfo + ", liveCommercial=" + this.liveCommercial + ", commerceReplay=" + this.commerceReplay + ", commerceRequestExplain=" + this.commerceRequestExplain + ", stamps=" + this.stamps + ", groupChat=" + this.groupChat + ", giftSettingSwitch=" + this.giftSettingSwitch + ", authType=" + this.authType + ", announcementInfo=" + this.announcementInfo + ", welfarePermissionInfo=" + this.welfarePermissionInfo + ", canBuyVIP=" + this.canBuyVIP + ", showGroupPurchaseEntry=" + this.showGroupPurchaseEntry + '}';
    }

    public int getGiftSettingSwitch() {
        return this.giftSettingSwitch;
    }

    public int getHighlight() {
        return this.highlight;
    }

    public int getPlayBack() {
        return this.playBack;
    }

    public int getRecord() {
        return this.record;
    }

    public boolean hasCommercialPermission() {
        return this.liveCommercial;
    }

    public void setGiftSettingSwitch(int r100) {
        this.giftSettingSwitch = r100;
    }

    public void setHighlight(int r100) {
        this.highlight = r100;
    }

    public void setPlayBack(int r100) {
        this.playBack = r100;
    }

    public void setRecord(int r100) {
        this.record = r100;
    }
}
