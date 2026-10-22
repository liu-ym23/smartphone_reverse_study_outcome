package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/z0;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "topicSchema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z0 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String topicSchema;

    public z0() {
        this.topicSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Fdynamic_operation_topic%2Ftemplate.js";
    }

    public final boolean a() {
        return this.enable;
    }

    public final String b() {
        return this.topicSchema;
    }
}
