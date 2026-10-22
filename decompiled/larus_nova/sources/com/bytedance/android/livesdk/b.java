package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f104228a = null;

    static {
        f104228a = new b();
    }

    public b() {
        Boolean r100 = Boolean.TRUE;
        super("common_interceptor_lite_crash_config", "抖lite下拦截器调用静态函数崩溃修复", r100, r100);
    }
}
