package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class b30 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b30 f119839a = null;

    static {
        f119839a = new b30();
    }

    public b30() {
        Boolean r100 = Boolean.FALSE;
        super("live_anchor_enable_interact_panel_count_limit", "互动工具是否支持多开", r100, r100);
    }
}
