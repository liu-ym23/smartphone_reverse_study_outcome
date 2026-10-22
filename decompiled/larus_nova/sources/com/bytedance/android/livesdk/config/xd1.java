package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/xd1;", "", "", "ticketSellUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setTicketSellUrl", "(Ljava/lang/String;)V", "homeUrl", "getHomeUrl", "setHomeUrl", "ticketExplainUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setTicketExplainUrl", "directCreateUrl", "getDirectCreateUrl", "setDirectCreateUrl", "noPermissionUrl", "getNoPermissionUrl", "setNoPermissionUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class xd1 {

    @SerializedName("paid_live_simplify_url")
    private String directCreateUrl;

    @SerializedName("paid_live_home_url")
    private String homeUrl;

    @SerializedName("paid_live_no_permission_url")
    private String noPermissionUrl;

    @SerializedName("paid_live_ticket_explain_url")
    private String ticketExplainUrl;

    @SerializedName("paid_live_ticket_sell_url")
    private String ticketSellUrl;

    public xd1() {
        this.ticketSellUrl = "";
        this.homeUrl = "";
        this.ticketExplainUrl = "";
        this.directCreateUrl = "sslocal://webcast_webview?type=fullscreen&status_bar_color=black&hide_nav_bar=1&hide_status_bar=1&status_bar_bg_color=%2300000000&web_bg_color=%23FFFFFFFF&height_percent=100&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Fh5%2Fcommunity_payroom_h5_douyin%2Ftemplate%2Fpages%2Fcreate_pay_live_simplify.html";
        this.noPermissionUrl = "sslocal://webcast_webview?type=fullscreen&status_bar_color=black&hide_nav_bar=1&hide_status_bar=1&status_bar_bg_color=%2300000000&web_bg_color=%23FFFFFFFF&height_percent=100&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Fh5%2Fcommunity_payroom_h5_douyin%2Ftemplate%2Fpages%2Fpay_live_no_permission.html";
    }

    public final String a() {
        return this.ticketExplainUrl;
    }

    public final String b() {
        return this.ticketSellUrl;
    }
}
