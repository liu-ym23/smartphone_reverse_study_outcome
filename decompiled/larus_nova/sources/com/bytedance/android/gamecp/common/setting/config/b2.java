package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/b2;", "", "", "loginRemindSchema", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "steamLoginSchema", "b", ce.f26391f, "steamCookieDomain", "getSteamCookieDomain", "e", "steamCookieLoginKey", "getSteamCookieLoginKey", "f", "cookiesPublicKey", "getCookiesPublicKey", "c", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b2 {

    @SerializedName("cookies_public_key")
    private String cookiesPublicKey;

    @SerializedName("login_remind_schema")
    private String loginRemindSchema;

    @SerializedName("steam_cookie_domain")
    private String steamCookieDomain;

    @SerializedName("steam_cookie_login_key")
    private String steamCookieLoginKey;

    @SerializedName("steam_login_schema")
    private String steamLoginSchema;

    public final void c() {
        this.cookiesPublicKey = "LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUF2cTR2ajNIZHk4N2xYTGVDT1hYeQp0U25oWjZRTDh5WkRrbHMzZmVuZU9WelpXdlFzS2h3Z0tBWERhK3FFaCtRRXJqOG1SUnJXZ1prKzE4OUlBbnJZClArY1FmS2xQYnZjNGJ3L29zQ1VjUWN5RGdveUVwWDhFQ1NPTjMzMXpyTlNSWEFsYnREeGcxalFKWElvS3VVcTIKR1IzM1lrTGIyVmdoZ3I5TjBqbGJNVlZjc1VmRjl6TE43QzVUNVJTSmxrcVU4UzYzMEZ3NHV5MEtUNFRkYVhHTQpGZXN1bHBWZ0cvVmFNdE1IUVpmK2ZBWlVMcmRLZjAwd1dKd2hwN0Z1WFVVL2Q1ckZrL280bzNlOTVkUjN2bGJjCmcrYkJzVS9xMkRCOEQ5aVd2dzQ0UXhCQitGUW1PNm9EVUlSMElBSE15VWk2SmR5UFRiSlNlYlpoQnlsL3MraUcKK1FJREFRQUIKLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0t";
    }

    public final void d() {
        this.loginRemindSchema = "sslocal://webcast_lynxview?type=popup&bdhm_bid=game_promote_tools_lynx&gravity=bottom&height_percent=100&pull_down_indicator_not_show=1&abandon_coordinate=0&horizontal_width=395&window_floating=0&settings_keys=douyin_game_lynx_params_check&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fgame_priority_normal3_lynx_douyin%2Fpages%2Frelated_service_login_page%2Ftemplate.js%3F&mask_alpha=0.3&pull_down_close=0&add_safe_area_height=1&width_percent=100&disable_url_handle=1&top_level=1&business_type=gamecp_group&enable_latch=1&enable_font_scale=1&service_type=steam&web_bg_color=%2300000080&radius=0";
    }

    public final void e() {
        this.steamCookieDomain = "store.steampowered.com";
    }

    public final void f() {
        this.steamCookieLoginKey = "steamLoginSecure";
    }

    public final void g() {
        this.steamLoginSchema = "sslocal://webcast_webview?type=fullscreen&gamecp_biz=steamwish&url=https%3A%2F%2Fstore.steampowered.com%2Flogin&nav_bar_color=%23191919&title_color=%23D1D1D1&hide_loading=0";
    }

    public b2() {
        this.loginRemindSchema = "";
        this.steamLoginSchema = "";
        this.steamCookieDomain = "";
        this.steamCookieLoginKey = "";
        this.cookiesPublicKey = "";
    }

    public final String a() {
        return this.loginRemindSchema;
    }

    public final String b() {
        return this.steamLoginSchema;
    }
}
