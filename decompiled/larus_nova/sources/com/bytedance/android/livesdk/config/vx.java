package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.GameGuessPredictorConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class vx extends SSettingKey<GameGuessPredictorConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vx f121484a = null;

    static {
        f121484a = new vx();
    }

    public vx() {
        super("live_prophet_config", "游戏竞猜预言家玩法配置开关及跳转SCHEMA", new GameGuessPredictorConfig(), new GameGuessPredictorConfig());
    }
}
