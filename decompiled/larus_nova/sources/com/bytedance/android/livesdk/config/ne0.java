package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveOptRecommendHintConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ne0 extends SSettingKey<LiveOptRecommendHintConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ne0 f120826a = null;

    static {
        f120826a = new ne0();
    }

    public ne0() {
        super("live_optimize_recommend_tip", "直播间优化推荐使用提示", new LiveOptRecommendHintConfig(), new LiveOptRecommendHintConfig());
    }
}
