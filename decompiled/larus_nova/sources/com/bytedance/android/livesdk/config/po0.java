package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveRoomMemoryOptConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class po0 extends SSettingKey<LiveRoomMemoryOptConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final po0 f120996a = null;

    static {
        f120996a = new po0();
    }

    public po0() {
        super("live_room_memory_opt", "直播内存治理优化", new LiveRoomMemoryOptConfig(), new LiveRoomMemoryOptConfig());
    }
}
