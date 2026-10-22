package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.EnterRoomFrameworkConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class gu extends SSettingKey<EnterRoomFrameworkConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gu f120314a = null;

    static {
        f120314a = new gu();
    }

    public gu() {
        super("live_enter_room_container_config", "是否使用新的进房架构", new EnterRoomFrameworkConfig(), new EnterRoomFrameworkConfig(), true);
    }
}
