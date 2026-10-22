package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.depend.model.live.StrategyRoomFeatureConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class b3 extends SettingKey<StrategyRoomFeatureConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b3 f104232a = null;

    static {
        f104232a = new b3();
    }

    public b3() {
        super("live_strategy_room_feature_config", "策略实时房间特征配置", new StrategyRoomFeatureConfig(), new StrategyRoomFeatureConfig());
    }
}
