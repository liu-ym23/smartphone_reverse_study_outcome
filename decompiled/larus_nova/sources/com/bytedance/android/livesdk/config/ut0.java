package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveSchemeSecurityConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ut0 extends SSettingKey<LiveSchemeSecurityConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ut0 f121400a = null;

    static {
        f121400a = new ut0();
    }

    public ut0() {
        super("live_subscheme_security_config", "二级Scheme安全校验配置", new LiveSchemeSecurityConfig(), new LiveSchemeSecurityConfig());
    }
}
