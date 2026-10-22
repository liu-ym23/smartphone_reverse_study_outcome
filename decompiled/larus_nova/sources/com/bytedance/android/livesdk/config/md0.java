package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class md0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final md0 f120746a = null;

    static {
        f120746a = new md0();
    }

    public md0() {
        Boolean r100 = Boolean.FALSE;
        super("live_nqe_common_params_build_opt", "nqe参数获取优化", r100, r100);
    }
}
