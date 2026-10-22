package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class j0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f142013a = null;

    static {
        f142013a = new j0();
    }

    public j0() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_annie_init_fix", "是否开启电商直播容器初始化修复", r100, r100);
    }
}
