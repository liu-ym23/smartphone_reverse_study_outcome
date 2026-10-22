package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fs extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fs f120227a = null;

    static {
        f120227a = new fs();
    }

    public fs() {
        Boolean r100 = Boolean.TRUE;
        super("enable_lynx_list_fps_monitor", "lynx列表fps监控是否打开", r100, r100);
    }
}
