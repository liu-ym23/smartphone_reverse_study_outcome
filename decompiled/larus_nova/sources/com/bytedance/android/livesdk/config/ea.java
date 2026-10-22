package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveDynamicSRConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ea extends SSettingKey<LiveDynamicSRConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ea f120109a = null;

    static {
        f120109a = new ea();
    }

    public ea() {
        super("live_ai_dynamic_sr", "直播动态超分配置", new LiveDynamicSRConfig(), new LiveDynamicSRConfig());
    }
}
