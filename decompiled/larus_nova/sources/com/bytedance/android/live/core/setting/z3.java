package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class z3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z3 f65470a = null;

    static {
        f65470a = new z3();
    }

    public z3() {
        Boolean r100 = Boolean.TRUE;
        super("live_preload_api_check_room_init", "判断init", r100, r100, true);
    }
}
