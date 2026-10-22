package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\rBG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fR\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayModeLynxPanelConfig;", "", "enable", "", "guestBattleSchema", "", "guestBattleUrl", "guestBattleOpenPanelUrl", "crossRoomSchema", "crossRoomUrl", "roomHistorySchema", "roomHistoryUrl", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PlayModeLynxPanelConfig {
    public static final Companion Companion = null;

    @SerializedName("room_battle_schema")
    public String crossRoomSchema;

    @SerializedName("room_battle_url")
    public String crossRoomUrl;

    @SerializedName("enabled")
    public boolean enable;

    @SerializedName("guest_battle_open_panel_url")
    public String guestBattleOpenPanelUrl;

    @SerializedName("guest_battle_schema")
    public String guestBattleSchema;

    @SerializedName("guest_battle_url")
    public String guestBattleUrl;

    @SerializedName("room_history_schema")
    public String roomHistorySchema;

    @SerializedName("room_history_url")
    public String roomHistoryUrl;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayModeLynxPanelConfig$Companion;", "", "()V", "defaultConfig", "Lcom/bytedance/android/livesdkapi/model/PlayModeLynxPanelConfig;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public final PlayModeLynxPanelConfig defaultConfig() {
            return new PlayModeLynxPanelConfig(true, "sslocal://webcast_lynxview?type=popup&gravity=bottom&business_type=guest_battle_panel&url=", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_douyin/pages/guest_battle_settings/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&business_type=guest_battle_panel", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_douyin/pages/guest_battle_open_panel/template.js", "sslocal://webcast_lynxview?business_type=livelinkmic&url=", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_douyin/pages/room_battle_settings/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D", "sslocal://webcast_lynxview?business_type=livelinkmic&url=", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_douyin/pages/room_battle_history/template.js");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PlayModeLynxPanelConfig(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r101, "guestBattleSchema");
        Intrinsics.checkNotNullParameter(r102, "guestBattleUrl");
        Intrinsics.checkNotNullParameter(r103, "guestBattleOpenPanelUrl");
        Intrinsics.checkNotNullParameter(r104, "crossRoomSchema");
        Intrinsics.checkNotNullParameter(r105, "crossRoomUrl");
        Intrinsics.checkNotNullParameter(r106, "roomHistorySchema");
        Intrinsics.checkNotNullParameter(r107, "roomHistoryUrl");
        this.enable = r100;
        this.guestBattleSchema = r101;
        this.guestBattleUrl = r102;
        this.guestBattleOpenPanelUrl = r103;
        this.crossRoomSchema = r104;
        this.crossRoomUrl = r105;
        this.roomHistorySchema = r106;
        this.roomHistoryUrl = r107;
    }

    public /* synthetic */ PlayModeLynxPanelConfig(boolean r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        boolean r100 = true;
    L6:
        this(r100, r111, r112, r113, r114, r115, r116, r117);
        return;
    L5:
        r100 = r110;
        goto L6
    }
}
