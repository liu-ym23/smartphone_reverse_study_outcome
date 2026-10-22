package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class o5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o5 f65376a = null;

    static {
        f65376a = new o5();
    }

    public o5() {
        Boolean r100 = Boolean.FALSE;
        super("live_useless_log_opt", "移除耗时的无用日志", r100, r100);
    }
}
