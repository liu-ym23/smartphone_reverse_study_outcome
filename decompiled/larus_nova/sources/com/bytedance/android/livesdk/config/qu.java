package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.WeakRoomConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class qu extends SSettingKey<WeakRoomConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qu f121083a = null;

    static {
        f121083a = new qu();
    }

    public qu() {
        super("live_enter_room_weak_fix", "一些内存泄露问题修复", new WeakRoomConfig(), new WeakRoomConfig(), true);
    }
}
