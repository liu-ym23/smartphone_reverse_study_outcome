package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.depend.model.live.StrategyInitConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class z2 extends SettingKey<StrategyInitConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z2 f162560a = null;

    static {
        f162560a = new z2();
    }

    public z2() {
        super("live_strategy_init_config", "直播策略SDK初始化配置", new StrategyInitConfig(), new StrategyInitConfig());
    }
}
