package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.DynamicDSRConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class r2 extends SSettingKey<DynamicDSRConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r2 f121099a = null;

    static {
        f121099a = new r2();
    }

    public r2() {
        super("dynamic_dsr_config", "动态控制超分是否生效", new DynamicDSRConfig(), new DynamicDSRConfig());
    }
}
