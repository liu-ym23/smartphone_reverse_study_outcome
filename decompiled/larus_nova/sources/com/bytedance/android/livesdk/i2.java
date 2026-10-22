package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class i2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i2 f132639a = null;

    static {
        f132639a = new i2();
    }

    public i2() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_strategy_sdk_setting_cache_optimize", "拉流策略SDKcache缓存优化", r100, r100);
    }
}
