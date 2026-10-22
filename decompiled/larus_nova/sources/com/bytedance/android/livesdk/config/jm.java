package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jm extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jm f120536a = null;

    static {
        f120536a = new jm();
    }

    public jm() {
        Boolean r100 = Boolean.TRUE;
        super("live_core_single_view_mode_for_anchor_stream_switch_enable", "重保场景是否支持开启单View模式", r100, r100);
    }
}
