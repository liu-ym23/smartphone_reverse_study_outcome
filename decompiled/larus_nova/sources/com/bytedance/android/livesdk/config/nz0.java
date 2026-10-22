package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nz0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nz0 f120871a = null;

    static {
        f120871a = new nz0();
    }

    public nz0() {
        Boolean r100 = Boolean.FALSE;
        super("live_xplay_audience_wtn_pull_stream_enable", "Xplay观众侧启动wtn拉流开关", r100, r100);
    }
}
