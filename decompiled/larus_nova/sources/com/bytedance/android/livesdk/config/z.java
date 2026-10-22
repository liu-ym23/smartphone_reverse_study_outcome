package com.bytedance.android.livesdk.config;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/z;", "", "", "lynxUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "fallbackUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("fallback_url")
    private final String fallbackUrl;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    public z() {
        this.lynxUrl = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/lynx/douyin_lynx_anchor/template/pages/personal_video_live/template.js";
        this.fallbackUrl = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/lynx/douyin_lynx_anchor/template/pages/personal_video_live/index.html";
    }

    public final String a() {
        return this.fallbackUrl;
    }

    public final String b() {
        return this.lynxUrl;
    }
}
