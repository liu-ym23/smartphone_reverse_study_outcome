package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class x5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x5 f65456a = null;

    static {
        f65456a = new x5();
    }

    public x5() {
        Boolean r100 = Boolean.TRUE;
        super("live_vs_fix_multi_camera_camera_ticket", "竖屏子机位打开主机位购票入口失败", r100, r100);
    }
}
