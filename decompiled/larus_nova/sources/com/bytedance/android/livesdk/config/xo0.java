package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class xo0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xo0 f121621a = null;

    static {
        f121621a = new xo0();
    }

    public xo0() {
        Boolean r100 = Boolean.FALSE;
        super("live_room_notify_render_opt", "全站广播渲染优化", r100, r100);
    }
}
