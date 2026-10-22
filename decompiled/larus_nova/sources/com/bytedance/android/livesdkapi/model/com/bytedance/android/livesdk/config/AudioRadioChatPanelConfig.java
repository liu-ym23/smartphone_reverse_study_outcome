package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/AudioRadioChatPanelConfig;", "", "()V", "preapplyPanelSchema", "", "getPreapplyPanelSchema", "()Ljava/lang/String;", "selectModePanelSchema", "getSelectModePanelSchema", "selectModePanelUrl", "getSelectModePanelUrl", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioRadioChatPanelConfig {

    @SerializedName("preapply_panel_schema")
    private final String preapplyPanelSchema;

    @SerializedName("select_mode_panel_schema")
    private final String selectModePanelSchema;

    @SerializedName("select_mode_panel_url")
    private final String selectModePanelUrl;

    public AudioRadioChatPanelConfig() {
        this.preapplyPanelSchema = "sslocal://webcast_lynxview?&type=popup&gravity=bottom&hide_loading=0&show_error=1&radius=12&height=484&enable_latch=1&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Flinkmic_recommend_room_douyin%2Fpages%2Fprepare_apply_panel%2Ftemplate.js%3FinitialProps%3D%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D%26business_type%3Dlivelinkmic%26business_group%3Dlivelinkmic";
        this.selectModePanelSchema = "sslocal://webcast_lynxview?type=popup&gravity=bottom&hide_loading=0&show_error=1&enable_latch=1&&mask_alpha=0&height=520&width_percent=100&horizontal_width_percent=100";
        this.selectModePanelUrl = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/linkmic_recommend_room_douyin/pages/multi_link_mode_select/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    }

    public final String getPreapplyPanelSchema() {
        return this.preapplyPanelSchema;
    }

    public final String getSelectModePanelSchema() {
        return this.selectModePanelSchema;
    }

    public final String getSelectModePanelUrl() {
        return this.selectModePanelUrl;
    }
}
