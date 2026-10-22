package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.recommendAnonymous.LiveRecommendAnonymousConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class jm0 extends SSettingKey<LiveRecommendAnonymousConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jm0 f120537a = null;

    static {
        f120537a = new jm0();
    }

    public jm0() {
        super("live_recommend_anonymous_opt_config", "面板+预览流标签推荐给朋友优化", new LiveRecommendAnonymousConfig(), new LiveRecommendAnonymousConfig());
    }
}
