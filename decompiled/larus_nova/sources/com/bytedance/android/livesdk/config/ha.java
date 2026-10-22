package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ha extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ha f120355a = null;

    static {
        f120355a = new ha();
    }

    public ha() {
        super("live_ai_load_more_inhibition", "首个直播间loadMore回调抑制端智能配置", 0, 0, new String[]{"0:不支持端智能接入", "1:支持端智能接入,不使用策略判断", "2:支持端智能接入,使用策略判断"});
    }
}
