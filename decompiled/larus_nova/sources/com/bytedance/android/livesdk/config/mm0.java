package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveRecommendToFriendSuccessConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class mm0 extends SSettingKey<LiveRecommendToFriendSuccessConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mm0 f120768a = null;

    static {
        f120768a = new mm0();
    }

    public mm0() {
        super("live_recommend_to_friend_success_config", "推荐成功后配置", new LiveRecommendToFriendSuccessConfig(), new LiveRecommendToFriendSuccessConfig());
    }
}
