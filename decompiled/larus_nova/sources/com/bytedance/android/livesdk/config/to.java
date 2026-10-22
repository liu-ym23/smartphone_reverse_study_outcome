package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.DnsOptimizeConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class to extends SSettingKey<DnsOptimizeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final to f121314a = null;

    static {
        f121314a = new to();
    }

    public to() {
        super("live_dns_optimize_config", "DNS优化配置", new DnsOptimizeConfig(), new DnsOptimizeConfig());
    }
}
