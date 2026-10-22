package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.LiveRealNameOptConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class m7 extends SSettingKey<LiveRealNameOptConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m7 f153490a = null;

    static {
        f153490a = new m7();
    }

    public m7() {
        super("live_real_name_opt_config", "一证多号送礼实名拦截优化", new LiveRealNameOptConfig(), new LiveRealNameOptConfig());
    }
}
