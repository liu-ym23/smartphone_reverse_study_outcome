package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class r81 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r81 f121112a = null;

    static {
        f121112a = new r81();
    }

    public r81() {
        Boolean r100 = Boolean.TRUE;
        super("live_tb_opt_view_cache", "toolbar架构优化view缓存", r100, r100);
    }
}
