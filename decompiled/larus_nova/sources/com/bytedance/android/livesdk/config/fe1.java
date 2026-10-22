package com.bytedance.android.livesdk.config;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/fe1;", "", "", "lynxUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "lynxScheme", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class fe1 {

    @SerializedName("lynx_scheme")
    private final String lynxScheme;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    public fe1() {
        this.lynxUrl = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_douyin/pages/playmode_select/template.js";
        this.lynxScheme = "sslocal://webcast_lynxview?type=popup&gravity=bottom&hide_loading=0&show_error=1&radius=12&height=484&web_bg_color=%23FFFFFF&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&loader_name=forest";
    }

    public final String a() {
        return this.lynxScheme;
    }

    public final String b() {
        return this.lynxUrl;
    }
}
