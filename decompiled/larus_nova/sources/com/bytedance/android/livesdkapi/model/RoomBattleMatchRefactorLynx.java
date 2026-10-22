package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/RoomBattleMatchRefactorLynx;", "", "enabled", "", "teamContributionPanelUrl", "", "teamContributionPanelSchema", "roomBattleMainPanelUrl", "roomBattleMainPanelSchema", "searchPanelUrl", "searchPanelSchema", "receiverPanelUrl", "receiverPanelSchema", "settingPanelUrl", "settingPanelSchema", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomBattleMatchRefactorLynx {
    public static final Companion Companion = null;

    @SerializedName("enable_use_lynx")
    public boolean enabled;

    @SerializedName("receiver_panel_schema")
    public String receiverPanelSchema;

    @SerializedName("receiver_panel_url")
    public String receiverPanelUrl;

    @SerializedName("room_battle_main_panel_schema")
    public String roomBattleMainPanelSchema;

    @SerializedName("room_battle_main_panel_url")
    public String roomBattleMainPanelUrl;

    @SerializedName("search_panel_schema")
    public String searchPanelSchema;

    @SerializedName("search_panel_url")
    public String searchPanelUrl;

    @SerializedName("setting_panel_schema")
    public String settingPanelSchema;

    @SerializedName("setting_panel_url")
    public String settingPanelUrl;

    @SerializedName("team_contribute_panel_schema")
    public String teamContributionPanelSchema;

    @SerializedName("team_contribute_panel_url")
    public String teamContributionPanelUrl;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/RoomBattleMatchRefactorLynx$Companion;", "", "()V", "defaultConfig", "Lcom/bytedance/android/livesdkapi/model/RoomBattleMatchRefactorLynx;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public final RoomBattleMatchRefactorLynx defaultConfig() {
            return new RoomBattleMatchRefactorLynx(true, "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_douyin/pages/team_fight_contribute_panel/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D", "sslocal://webcast_lynxview?type=popup&gravity=bottom&type=popup&height_percent=60&radius=20", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_douyin/pages/room_battle_main/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D", "sslocal://webcast_lynxview?type=popup&gravity=bottom&type=popup&height_percent=60&disable_back_press=1&enable_latch=1&radius=0&disable_input_scroll=1", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_douyin/pages/room_battle_search_panel/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&business_type=livelinkmic&business_group=livelinkmic", "sslocal://webcast_lynxview?type=popup&gravity=bottom&type=popup&height_percent=60&radius=20&disable_input_scroll=1", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_douyin/pages/room_battle_receiver_panel/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&business_type=livelinkmic&business_group=livelinkmic", "sslocal://webcast_lynxview?type=popup&gravity=bottom&type=popup&height_percent=100&radius=20&enable_latch=1", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_douyin/pages/room_battle_settings/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&business_type=livelinkmic&business_group=livelinkmic", "sslocal://webcast_lynxview?type=popup&gravity=bottom&mask_alpha=0.4&height_percent=60&enable_latch=1&disable_input_scroll=1&load_taro=0");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RoomBattleMatchRefactorLynx() {
        this(false, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public RoomBattleMatchRefactorLynx(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, "teamContributionPanelUrl");
        Intrinsics.checkNotNullParameter(r102, "teamContributionPanelSchema");
        Intrinsics.checkNotNullParameter(r103, "roomBattleMainPanelUrl");
        Intrinsics.checkNotNullParameter(r104, "roomBattleMainPanelSchema");
        Intrinsics.checkNotNullParameter(r105, "searchPanelUrl");
        Intrinsics.checkNotNullParameter(r106, "searchPanelSchema");
        Intrinsics.checkNotNullParameter(r107, "receiverPanelUrl");
        Intrinsics.checkNotNullParameter(r110, "receiverPanelSchema");
        Intrinsics.checkNotNullParameter(r111, "settingPanelUrl");
        Intrinsics.checkNotNullParameter(r112, "settingPanelSchema");
        this.enabled = r100;
        this.teamContributionPanelUrl = r101;
        this.teamContributionPanelSchema = r102;
        this.roomBattleMainPanelUrl = r103;
        this.roomBattleMainPanelSchema = r104;
        this.searchPanelUrl = r105;
        this.searchPanelSchema = r106;
        this.receiverPanelUrl = r107;
        this.receiverPanelSchema = r110;
        this.settingPanelUrl = r111;
        this.settingPanelSchema = r112;
    }

    public /* synthetic */ RoomBattleMatchRefactorLynx(boolean r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212, String r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 1) == 0) goto L5;
        boolean r100 = true;
    L6:
        String r101 = "";
        if ((r214 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = "";
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = "";
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r101 = r213;
    L46:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r117, r118, r101);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
