package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMockStrategyDescriptorLoadConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class p2 extends SSettingKey<LiveMockStrategyDescriptorLoadConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p2 f65381a = null;

    static {
        f65381a = new p2();
    }

    public p2() {
        super("live_mock_component_strategy_detail", "组件加载策略配置本地mock策略数据", new LiveMockStrategyDescriptorLoadConfig(), new LiveMockStrategyDescriptorLoadConfig(), true);
    }
}
