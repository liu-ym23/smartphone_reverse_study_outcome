package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveHandleRoomOptimizeConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class u5 extends SettingKey<LiveHandleRoomOptimizeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u5 f158615a = null;

    static {
        f158615a = new u5();
    }

    public u5() {
        super("live_handle_room_json_optimize_config", "handle room json 优化", new LiveHandleRoomOptimizeConfig(), new LiveHandleRoomOptimizeConfig());
    }
}
