package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zg0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zg0 f121764a = null;

    static {
        f121764a = new zg0();
    }

    public zg0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_guest_consume_anchor_first_remote_video_frame_async", "是否允许嘉宾侧异步消费主播侧首帧", r100, r100);
    }
}
