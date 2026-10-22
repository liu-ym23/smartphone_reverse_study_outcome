package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveRoomCreateConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class co0 extends SettingKey<LiveRoomCreateConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final co0 f119968a = null;

    static {
        f119968a = new co0();
    }

    public co0() {
        super("live_room_create_opt", "直播建房流程优化", new LiveRoomCreateConfig(), new LiveRoomCreateConfig(), true);
    }
}
