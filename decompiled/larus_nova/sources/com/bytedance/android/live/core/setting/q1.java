package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.performance.fwatchdog.LiveFWatchDogV2Config;

/* JADX INFO: loaded from: classes45.dex */
public final class q1 extends SSettingKey<LiveFWatchDogV2Config> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q1 f65389a = null;

    static {
        f65389a = new q1();
    }

    public q1() {
        super("live_fwatch_dog_v2_config", "fwatchdogV2配置", new LiveFWatchDogV2Config(), new LiveFWatchDogV2Config());
    }
}
