package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.TimeConsumingFuncOpt;

/* JADX INFO: loaded from: classes8.dex */
public final class pu0 extends SettingKey<TimeConsumingFuncOpt> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pu0 f121008a = null;

    static {
        f121008a = new pu0();
    }

    public pu0() {
        super("live_time_consuming_func_opt", "慢函数治理", new TimeConsumingFuncOpt(), new TimeConsumingFuncOpt());
    }
}
