package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.RadioSpeakingUpdateTimeConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class c4 extends SSettingKey<RadioSpeakingUpdateTimeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c4 f65272a = null;

    static {
        f65272a = new c4();
    }

    public c4() {
        super("live_radio_speaking_update_interval_time_config", "电台说话状态更新时间间隔配置", new RadioSpeakingUpdateTimeConfig(), new RadioSpeakingUpdateTimeConfig());
    }
}
