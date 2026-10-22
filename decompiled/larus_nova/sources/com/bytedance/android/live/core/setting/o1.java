package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.setting.LiveFragmentLeakConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class o1 extends SSettingKey<LiveFragmentLeakConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o1 f65372a = null;

    static {
        f65372a = new o1();
    }

    public o1() {
        super("live_fragment_leak_config", "直播fragment泄漏修复", new LiveFragmentLeakConfig(), new LiveFragmentLeakConfig());
    }
}
