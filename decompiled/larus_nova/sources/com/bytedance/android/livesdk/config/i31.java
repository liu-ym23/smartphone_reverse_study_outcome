package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/i31;", "", "", "darkSchema", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "lightSchema", "b", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i31 {

    @SerializedName("live_follow_moment_dark_theme_schema")
    private final String darkSchema;

    @SerializedName("live_follow_moment_light_theme_schema")
    private final String lightSchema;

    public i31() {
        this.darkSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fdouyin_lynx_live_dynamic%2Ftemplate%2Fpages%2Flive_dynamic%2Ftemplate.js%3Fweb_bg_color%3D%2523161823%26status_bar_color%3Dwhite&type=fullscreen&hide_nav_bar=1&trans_status_bar=1";
        this.lightSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fdouyin_lynx_live_dynamic%2Ftemplate%2Fpages%2Flive_dynamic%2Ftemplate.js%3Fweb_bg_color%3D%2523ffffff%26status_bar_color%3Dblack&type=fullscreen&hide_nav_bar=1&trans_status_bar=1";
    }

    public final String a() {
        return this.darkSchema;
    }

    public final String b() {
        return this.lightSchema;
    }
}
