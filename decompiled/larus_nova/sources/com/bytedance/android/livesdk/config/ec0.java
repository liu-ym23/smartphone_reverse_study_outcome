package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ec0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ec0 f120115a = null;

    static {
        f120115a = new ec0();
    }

    public ec0() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_pub_stream_fall_back_protect", "跨房厅战公共流回退到跨房流后，首帧回调到来不再mute跨房流", r100, r100);
    }
}
