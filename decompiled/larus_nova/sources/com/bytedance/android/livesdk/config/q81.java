package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class q81 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q81 f121035a = null;

    static {
        f121035a = new q81();
    }

    public q81() {
        Boolean r100 = Boolean.TRUE;
        super("live_tb_fix_add_view_error", "toolbar架构修复添加view出错", r100, r100);
    }
}
