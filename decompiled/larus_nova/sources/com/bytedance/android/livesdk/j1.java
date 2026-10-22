package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class j1 extends SettingKey<LiveMemLeakConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j1 f142014a = null;

    static {
        f142014a = new j1();
    }

    public j1() {
        super("live_mem_leak_config", "直播内存泄漏配置", new LiveMemLeakConfig(), new LiveMemLeakConfig());
    }
}
