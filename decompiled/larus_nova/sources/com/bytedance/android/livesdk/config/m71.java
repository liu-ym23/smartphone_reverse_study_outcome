package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/m71;", "", "Lcom/bytedance/android/livesdk/config/s91;", "realTimeChorusRankList", "Lcom/bytedance/android/livesdk/config/s91;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/config/s91;", "setRealTimeChorusRankList", "(Lcom/bytedance/android/livesdk/config/s91;)V", "realTimeChorusEducationPage", "getRealTimeChorusEducationPage", "setRealTimeChorusEducationPage", "liveRealTimeChorusRankList", "getLiveRealTimeChorusRankList", "setLiveRealTimeChorusRankList", "realTimeChorusSetting", "b", "setRealTimeChorusSetting", "realTimeChorusTuningPanel", "c", "setRealTimeChorusTuningPanel", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m71 {

    @SerializedName("live_real_time_chorus_rank_list")
    private s91 liveRealTimeChorusRankList;

    @SerializedName("real_time_chorus_education_page")
    private s91 realTimeChorusEducationPage;

    @SerializedName("real_time_chorus_midi_rank_list")
    private s91 realTimeChorusRankList;

    @SerializedName("live_real_time_chorus_setting")
    private s91 realTimeChorusSetting;

    @SerializedName("live_real_time_chorus_tuning_panel")
    private s91 realTimeChorusTuningPanel;

    public m71() {
        s91 r100 = new s91(0);
        r100.c("sslocal://webcast_lynxview?type=popup&gravity=bottom&type=popup&rate_height=480&height_percent=64&horizontal_height_percent=64&width_percent=100&horizontal_width_percent=100&url=");
        r100.d("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_ktv_lynx_douyin/pages/realtimechorus_rank_list/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D");
        Unit r101 = Unit.INSTANCE;
        this.realTimeChorusRankList = r100;
        s91 r102 = new s91(0);
        r102.c("sslocal://webcast_lynxview?type=popup&rate_height=429&mask_alpha=0.38&gravity=bottom&type=popup&height=429&width_percent=100&horizontal_width_percent=100&url=");
        r102.d("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_ktv_lynx_douyin/pages/realtimechorus_education_page/template.js?initialProps%3D%5B%22current_room%22%2C%22current_user%22%2C%22linkmic%22%2C%22setting%3Alive_real_time_chorus_max_user_count%22%5D");
        this.realTimeChorusEducationPage = r102;
        s91 r103 = new s91(0);
        r103.c("sslocal://webcast_lynxview?type=popup&rate_height=480&gravity=bottom&height_percent=64&horizontal_height_percent=64&width_percent=100&horizontal_width_percent=100&url=");
        r103.d("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_ktv_lynx_douyin/pages/live_realtimechorus_rank_list/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D");
        this.liveRealTimeChorusRankList = r103;
        s91 r104 = new s91(0);
        r104.c("sslocal://webcast_lynxview?type=popup&rate_height=480&gravity=bottom&height_percent=64&horizontal_height_percent=64&width_percent=100&android_soft_input_mode=48&horizontal_width_percent=100&url=");
        r104.d("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_ktv_lynx_douyin/pages/chorus_setting/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D");
        this.realTimeChorusSetting = r104;
        s91 r105 = new s91(0);
        r105.c("sslocal://webcast_lynxview?rate_height=500&type=popup&gravity=bottom&width_percent=100&android_soft_input_mode=48&horizontal_width_percent=100&url=");
        r105.d("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/real_time_chorus_lynx_douyin/pages/tuning_panel_page/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&business_type=livelinkmic&business_group=livelinkmic");
        this.realTimeChorusTuningPanel = r105;
    }

    public final s91 a() {
        return this.realTimeChorusRankList;
    }

    public final s91 b() {
        return this.realTimeChorusSetting;
    }

    public final s91 c() {
        return this.realTimeChorusTuningPanel;
    }
}
