package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class e1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e1 f123284a = null;

    static {
        f123284a = new e1();
    }

    public e1() {
        Boolean r100 = Boolean.TRUE;
        super("live_link_widget_load_opt", "直播连屏等待 revenue index 就绪再启动", r100, r100);
    }
}
