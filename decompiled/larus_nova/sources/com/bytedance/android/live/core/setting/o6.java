package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class o6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o6 f65377a = null;

    static {
        f65377a = new o6();
    }

    public o6() {
        Boolean r100 = Boolean.TRUE;
        super("multi_link_audience_enter_room_use_preivew_player_position_opt", "多人场景观众预览流进房使用预览流布局参数提前刷新房间内播放器布局", r100, r100);
    }
}
