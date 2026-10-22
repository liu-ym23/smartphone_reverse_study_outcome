package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class a3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a3 f102994a = null;

    static {
        f102994a = new a3();
    }

    public a3() {
        Boolean r100 = Boolean.FALSE;
        super("live_strategy_log_only_debug", "策略日志仅在debug打开", r100, r100);
    }
}
