package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model.LiveMemCacheConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class u1 extends SSettingKey<LiveMemCacheConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u1 f158611a = null;

    static {
        f158611a = new u1();
    }

    public u1() {
        super("live_perf_mem_cache_config", "直播缓存配置", new LiveMemCacheConfig(), LiveMemCacheConfig.Companion.getDEBUG_CONFIG());
    }
}
