package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class qx extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qx f121089a = null;

    static {
        f121089a = new qx();
    }

    public qx() {
        Boolean r100 = Boolean.FALSE;
        super("live_game_cp_render_opt", "小手柄全屏渲染优化", r100, r100);
    }
}
