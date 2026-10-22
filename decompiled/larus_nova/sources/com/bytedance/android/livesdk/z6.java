package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class z6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z6 f162563a = null;

    static {
        f162563a = new z6();
    }

    public z6() {
        Boolean r100 = Boolean.TRUE;
        super("live_process_yuv_opt_enable", "420yuv旋转数据不处理", r100, r100);
    }
}
