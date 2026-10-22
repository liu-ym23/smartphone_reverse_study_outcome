package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveCountdownConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class e0 extends SettingKey<LiveCountdownConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f123283a = null;

    static {
        f123283a = new e0();
    }

    public e0() {
        super("live_countdown_config", "内流关播下滑挽留", new LiveCountdownConfig(), new LiveCountdownConfig());
    }
}
