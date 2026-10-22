package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class op extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final op f120922a = null;

    public op() {
        super("live_draw_loadmore_config", "内流loadmore请求时机优化", 1, 3);
    }

    static {
        f120922a = new op();
    }
}
