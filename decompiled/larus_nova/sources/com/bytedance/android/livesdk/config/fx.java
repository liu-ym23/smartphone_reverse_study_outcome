package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.FlyingStarBroadcastConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class fx extends SSettingKey<FlyingStarBroadcastConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fx f120237a = null;

    static {
        f120237a = new fx();
    }

    public fx() {
        super("flyingstar_broadcast_config", "飞星 - 主播侧配置", new FlyingStarBroadcastConfig(), new FlyingStarBroadcastConfig());
    }
}
