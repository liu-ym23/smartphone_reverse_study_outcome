package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.LiveInteractActingConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class z1 extends SSettingKey<LiveInteractActingConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z1 f65468a = null;

    static {
        f65468a = new z1();
    }

    public z1() {
        super("live_interact_acting_bussiness_config", "互动演绎玩法配置", new LiveInteractActingConfig(), new LiveInteractActingConfig());
    }
}
