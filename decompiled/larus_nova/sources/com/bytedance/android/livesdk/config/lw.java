package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lw f120712a = null;

    static {
        f120712a = new lw();
    }

    public lw() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_float_window_jsb_show", "修复直播小窗jsb获取展示状态不准确的问题", r100, r100);
    }
}
