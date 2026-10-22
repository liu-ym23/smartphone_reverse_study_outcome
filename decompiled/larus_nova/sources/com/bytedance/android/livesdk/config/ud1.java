package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.PreConnectConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ud1 extends SSettingKey<PreConnectConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ud1 f121364a = null;

    static {
        f121364a = new ud1();
    }

    public ud1() {
        super("live_preconnect_config", "内流预建联配置", new PreConnectConfig(), new PreConnectConfig());
    }
}
