package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.FirstScreenOptConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class aw extends SSettingKey<FirstScreenOptConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aw f119823a = null;

    static {
        f119823a = new aw();
    }

    public aw() {
        super("live_first_screen_opt", "首屏组件加载优化", new FirstScreenOptConfig(), new FirstScreenOptConfig());
    }
}
