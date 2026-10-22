package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\b¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/config/f51;", "", "", "roomBottomLynx", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setRoomBottomLynx", "(Ljava/lang/String;)V", "roomBottomWeb", "f", "setRoomBottomWeb", "", "roomBottomShowDuration", "J", "getRoomBottomShowDuration", "()J", "setRoomBottomShowDuration", "(J)V", "publicScreenLynx", "b", "setPublicScreenLynx", "publicScreenWeb", "d", "setPublicScreenWeb", "publicScreenShowDuration", "c", "setPublicScreenShowDuration", "previewBottomShowDuration", "getPreviewBottomShowDuration", "setPreviewBottomShowDuration", "previewBottomComponentShowDuration", "getPreviewBottomComponentShowDuration", "setPreviewBottomComponentShowDuration", "", "roomBottomBarWithIcon", "Z", "getRoomBottomBarWithIcon", "()Z", "setRoomBottomBarWithIcon", "(Z)V", "roomCommonLynxUrl", com.amap.api.col.s.ce.f26391f, "setRoomCommonLynxUrl", "previewComboUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setPreviewComboUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f51 {

    @SerializedName("preview_bottom_component_show_duration")
    private long previewBottomComponentShowDuration;

    @SerializedName("preview_bottom_bar_show_duration")
    private long previewBottomShowDuration;

    @SerializedName("preview_feedback_combo_url")
    private String previewComboUrl;

    @SerializedName("public_screen_lynx_url")
    private String publicScreenLynx;

    @SerializedName("public_screen_show_duration")
    private long publicScreenShowDuration;

    @SerializedName("public_screen_web_url")
    private String publicScreenWeb;

    @SerializedName("room_bottom_bar_with_icon")
    private boolean roomBottomBarWithIcon;

    @SerializedName("room_bottom_lynx_url")
    private String roomBottomLynx;

    @SerializedName("room_bottom_show_duration")
    private long roomBottomShowDuration;

    @SerializedName("room_bottom_web_url")
    private String roomBottomWeb;

    @SerializedName("room_common_lynx_url")
    private String roomCommonLynxUrl;

    public f51() {
        this.roomBottomLynx = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/community_feedback_lynx_douyin/pages/bottom_feedback/template.js";
        this.roomBottomWeb = "";
        this.roomBottomShowDuration = 30;
        this.publicScreenLynx = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/community_feedback_lynx_douyin/pages/discuss_feedback/template.js";
        this.publicScreenWeb = "";
        this.publicScreenShowDuration = 30;
        this.previewBottomShowDuration = 30;
        this.previewBottomComponentShowDuration = 30;
        this.roomCommonLynxUrl = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/lynx/douyin_lynx_community/template/pages/question_nairefeed/template.js";
        this.previewComboUrl = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/community_feedback_lynx_douyin/pages/question_naire/template.js";
    }

    public final String a() {
        return this.previewComboUrl;
    }

    public final String b() {
        return this.publicScreenLynx;
    }

    public final long c() {
        return this.publicScreenShowDuration;
    }

    public final String d() {
        return this.publicScreenWeb;
    }

    public final String e() {
        return this.roomBottomLynx;
    }

    public final String f() {
        return this.roomBottomWeb;
    }

    public final String g() {
        return this.roomCommonLynxUrl;
    }
}
