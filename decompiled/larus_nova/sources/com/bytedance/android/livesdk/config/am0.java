package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class am0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final am0 f119804a = null;

    static {
        f119804a = new am0();
    }

    public am0() {
        Boolean r100 = Boolean.FALSE;
        super("live_real_time_chorus_concert_first_frame_visible_enable", "实时合唱演唱会首帧渲染回调可见性设置", r100, r100);
    }
}
