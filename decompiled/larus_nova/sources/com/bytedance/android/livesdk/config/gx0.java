package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveViewInflateConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class gx0 extends SSettingKey<LiveViewInflateConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gx0 f120321a = null;

    static {
        f120321a = new gx0();
    }

    public gx0() {
        super("live_view_inflate_opt", "直播内流View预加载", new LiveViewInflateConfig(), new LiveViewInflateConfig());
    }
}
