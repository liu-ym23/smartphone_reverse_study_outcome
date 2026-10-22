package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveInnerViewPagerConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class c20 extends SSettingKey<LiveInnerViewPagerConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c20 f119917a = null;

    static {
        f119917a = new c20();
    }

    public c20() {
        super("live_inner_viewpager_opt_config", "内流LiveVerticalViewPager优化", new LiveInnerViewPagerConfig(), new LiveInnerViewPagerConfig());
    }
}
