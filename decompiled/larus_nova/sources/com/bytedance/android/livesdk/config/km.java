package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class km extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final km f120613a = null;

    static {
        f120613a = new km();
    }

    public km() {
        Boolean r100 = Boolean.TRUE;
        super("live_core_single_view_mode_switch", "RTC是否开启单View模式", r100, r100);
    }
}
