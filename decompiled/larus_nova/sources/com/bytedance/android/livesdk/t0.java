package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.LiveHeapOptConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class t0 extends SSettingKey<LiveHeapOptConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f158503a = null;

    static {
        f158503a = new t0();
    }

    public t0() {
        super("live_heap_opt_config", "直播堆优化配置", new LiveHeapOptConfig(), new LiveHeapOptConfig());
    }
}
