package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class t60 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t60 f121274a = null;

    static {
        f121274a = new t60();
    }

    public t60() {
        Boolean r100 = Boolean.FALSE;
        super("live_link_sdk_enable_frame_buffer_pool", "LiveLinkSDK开启FrameBuffer池", r100, r100);
    }
}
