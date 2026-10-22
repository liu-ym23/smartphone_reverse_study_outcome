package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class o3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o3 f154126a = null;

    static {
        f154126a = new o3();
    }

    public o3() {
        Boolean r100 = Boolean.TRUE;
        super("live_vs_sei_pinch_relayout_fix", "节目直播SEI 刷新播放器导致手指放大效果闪烁失效", r100, r100);
    }
}
