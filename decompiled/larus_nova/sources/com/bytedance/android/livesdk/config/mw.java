package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class mw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mw f120787a = null;

    static {
        f120787a = new mw();
    }

    public mw() {
        super("live_fix_float_window_notification", "修复小窗播放通知不展示问题", Boolean.FALSE, Boolean.TRUE);
    }
}
