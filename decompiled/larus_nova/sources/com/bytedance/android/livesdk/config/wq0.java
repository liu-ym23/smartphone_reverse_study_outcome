package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wq0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wq0 f121546a = null;

    static {
        f121546a = new wq0();
    }

    public wq0() {
        Boolean r100 = Boolean.TRUE;
        super("live_sdk_cast_screen_gain_url_from_stream_info", "投屏url从streaminfo中获取", r100, r100);
    }
}
