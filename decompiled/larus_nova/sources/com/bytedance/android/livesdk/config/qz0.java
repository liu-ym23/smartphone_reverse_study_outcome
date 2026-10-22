package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class qz0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qz0 f121094a = null;

    static {
        f121094a = new qz0();
    }

    public qz0() {
        Boolean r100 = Boolean.TRUE;
        super("live_xplay_disallow_parent_intercept_touch_event", "多人场景嘉宾云游戏容器是否禁止父容器拦截TouchEvent", r100, r100, true);
    }
}
