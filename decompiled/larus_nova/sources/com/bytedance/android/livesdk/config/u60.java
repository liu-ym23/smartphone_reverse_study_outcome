package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class u60 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u60 f121348a = null;

    static {
        f121348a = new u60();
    }

    public u60() {
        Boolean r100 = Boolean.FALSE;
        super("live_link_sdk_enable_texture_buffer_pool", "LiveLinkSDK开启Texture池", r100, r100);
    }
}
