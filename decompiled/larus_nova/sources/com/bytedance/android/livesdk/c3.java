package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.depend.model.live.StrategyV3Config;

/* JADX INFO: loaded from: classes7.dex */
public final class c3 extends SettingKey<StrategyV3Config> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c3 f104412a = null;

    static {
        f104412a = new c3();
    }

    public c3() {
        super("live_strategy_v3_config", "直播策略V3配置", new StrategyV3Config(), new StrategyV3Config());
    }
}
