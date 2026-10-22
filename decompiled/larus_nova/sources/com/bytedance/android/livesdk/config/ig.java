package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.BigEventAvatarConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ig extends SSettingKey<BigEventAvatarConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ig f120450a = null;

    static {
        f120450a = new ig();
    }

    public ig() {
        super("live_big_event_avatar", "重保Avatar开关", new BigEventAvatarConfig(), new BigEventAvatarConfig());
    }
}
