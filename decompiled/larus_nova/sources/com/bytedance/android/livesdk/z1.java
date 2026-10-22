package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.PlayerInterceptReportConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class z1 extends SettingKey<PlayerInterceptReportConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z1 f162559a = null;

    static {
        f162559a = new z1();
    }

    public z1() {
        super("live_player_intercept_report_config", "播放器拦截上报", new PlayerInterceptReportConfig(), new PlayerInterceptReportConfig());
    }
}
