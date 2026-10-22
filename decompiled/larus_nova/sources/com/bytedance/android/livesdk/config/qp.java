package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.DSConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class qp extends SSettingKey<DSConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qp f121073a = null;

    static {
        f121073a = new qp();
    }

    public qp() {
        super("live_ds_guide_animation_config", "ds 直播间公屏区引导动画", new DSConfig(), new DSConfig());
    }
}
