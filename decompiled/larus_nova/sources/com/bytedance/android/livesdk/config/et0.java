package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class et0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final et0 f120153a = null;

    static {
        f120153a = new et0();
    }

    public et0() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_interact_effect_opt", "开播互动特效佩戴链路优化", r100, r100);
    }
}
