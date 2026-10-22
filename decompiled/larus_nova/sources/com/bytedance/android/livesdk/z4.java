package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class z4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z4 f162562a = null;

    static {
        f162562a = new z4();
    }

    public z4() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_exit_room_log", "是否上报退房埋点", r100, r100, true);
    }
}
