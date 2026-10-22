package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AdventureLynxPanelConfig;", "", "enabled", "", "guidePanelSchema", "", "guidePanelUrl", "startPanelSchema", "startPanelUrl", "invitePanelSchema", "invitePanelUrl", "closePanelSchema", "closePanelUrl", "mainSceneSchema", "mainSceneUrl", "joinTimeoutDuration", "", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AdventureLynxPanelConfig {
    public static final Companion Companion = null;

    @SerializedName("close_panel_schema")
    public String closePanelSchema;

    @SerializedName("close_panel_url")
    public String closePanelUrl;

    @SerializedName("enabled")
    public boolean enabled;

    @SerializedName("guide_panel_schema")
    public String guidePanelSchema;

    @SerializedName("guide_panel_url")
    public String guidePanelUrl;

    @SerializedName("invite_panel_schema")
    public String invitePanelSchema;

    @SerializedName("invite_panel_url")
    public String invitePanelUrl;

    @SerializedName("join_timeout_duration")
    public long joinTimeoutDuration;

    @SerializedName("main_scene_schema")
    public String mainSceneSchema;

    @SerializedName("main_scene_url")
    public String mainSceneUrl;

    @SerializedName("start_panel_schema")
    public String startPanelSchema;

    @SerializedName("start_panel_url")
    public String startPanelUrl;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AdventureLynxPanelConfig$Companion;", "", "()V", "defaultConfig", "Lcom/bytedance/android/livesdkapi/model/AdventureLynxPanelConfig;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public final AdventureLynxPanelConfig defaultConfig() {
            return new AdventureLynxPanelConfig(true, "sslocal://webcast_lynxview?type=popup&gravity=bottom&type=popup&height=460", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_dynamic_adventure_lynx_douyin/pages/guide_panel/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D", "sslocal://webcast_lynxview?type=popup&gravity=bottom&type=popup&height_percent=60", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_dynamic_adventure_lynx_douyin/pages/start_panel/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D", "sslocal://webcast_lynxview?type=popup&gravity=bottom&type=popup&height=460", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_dynamic_adventure_lynx_douyin/pages/invite_panel/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D", "sslocal://webcast_lynxview?gravity=bottom&type=popup&height_percent=30&url=", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_dynamic_adventure_lynx_douyin/pages/close_panel/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D", "sslocal://webcast_lynxview?type=popup&hide_nav_bar=1&gravity=bottom&height_percent=100", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_dynamic_adventure_lynx_douyin/pages/main_scene/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D", 10);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AdventureLynxPanelConfig() {
        this(false, null, null, null, null, null, null, null, null, null, null, 0, UnixStat.PERM_MASK, null);
    }

    public AdventureLynxPanelConfig(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, long r113) {
        Intrinsics.checkNotNullParameter(r101, "guidePanelSchema");
        Intrinsics.checkNotNullParameter(r102, "guidePanelUrl");
        Intrinsics.checkNotNullParameter(r103, "startPanelSchema");
        Intrinsics.checkNotNullParameter(r104, "startPanelUrl");
        Intrinsics.checkNotNullParameter(r105, "invitePanelSchema");
        Intrinsics.checkNotNullParameter(r106, "invitePanelUrl");
        Intrinsics.checkNotNullParameter(r107, "closePanelSchema");
        Intrinsics.checkNotNullParameter(r110, "closePanelUrl");
        Intrinsics.checkNotNullParameter(r111, "mainSceneSchema");
        Intrinsics.checkNotNullParameter(r112, "mainSceneUrl");
        this.enabled = r100;
        this.guidePanelSchema = r101;
        this.guidePanelUrl = r102;
        this.startPanelSchema = r103;
        this.startPanelUrl = r104;
        this.invitePanelSchema = r105;
        this.invitePanelUrl = r106;
        this.closePanelSchema = r107;
        this.closePanelUrl = r110;
        this.mainSceneSchema = r111;
        this.mainSceneUrl = r112;
        this.joinTimeoutDuration = r113;
    }

    public /* synthetic */ AdventureLynxPanelConfig(boolean r110, String r111, String r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, long r216, int r217, DefaultConstructorMarker r218) {
        if ((r217 & 1) == 0) goto L5;
        boolean r100 = true;
    L6:
        String r101 = "";
        if ((r217 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r217 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r217 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r217 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r217 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r217 & 256) == 0) goto L37;
        String r115 = "";
    L39:
        if ((r217 & 512) == 0) goto L41;
        String r116 = "";
    L43:
        if ((r217 & 1024) != 0) goto L47;
        r101 = r215;
    L47:
        if ((r217 & 2048) == 0) goto L49;
        long r117 = 10;
    L50:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r115, r116, r101, r117);
        return;
    L49:
        r117 = r216;
        goto L50
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
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
