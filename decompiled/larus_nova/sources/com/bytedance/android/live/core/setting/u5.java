package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class u5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u5 f65425a = null;

    static {
        f65425a = new u5();
    }

    public u5() {
        Boolean r100 = Boolean.FALSE;
        super("live_voice_banlance_degrade_config", "音量均衡性能降级", r100, r100);
    }
}
