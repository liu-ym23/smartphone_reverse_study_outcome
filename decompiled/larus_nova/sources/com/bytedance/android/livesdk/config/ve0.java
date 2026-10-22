package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ve0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ve0 f121443a = null;

    static {
        f121443a = new ve0();
    }

    public ve0() {
        Boolean r100 = Boolean.TRUE;
        super("live_outside_small_window_enable", "站外悬浮小窗开关", r100, r100);
    }
}
