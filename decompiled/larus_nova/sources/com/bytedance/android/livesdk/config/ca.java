package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.config.ai.LiveAIConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ca extends SSettingKey<LiveAIConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ca f119930a = null;

    static {
        f119930a = new ca();
    }

    public ca() {
        super(LiveInitSettingKeys.LIVE_AI_CONFIG, "Client AI配置", new LiveAIConfig(), new LiveAIConfig());
    }
}
