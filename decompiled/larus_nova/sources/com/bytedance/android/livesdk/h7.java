package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class h7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h7 f132629a = null;

    static {
        f132629a = new h7();
    }

    public h7() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_screen_interceptor_view", "公屏容器事件拦截组件控制开关", r100, r100);
    }
}
