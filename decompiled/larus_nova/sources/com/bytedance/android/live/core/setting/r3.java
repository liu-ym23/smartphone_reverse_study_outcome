package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class r3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r3 f65399a = null;

    static {
        f65399a = new r3();
    }

    public r3() {
        super("live_performance_miss_fix", "直播性能埋点丢失修复", Boolean.FALSE, Boolean.TRUE);
    }
}
