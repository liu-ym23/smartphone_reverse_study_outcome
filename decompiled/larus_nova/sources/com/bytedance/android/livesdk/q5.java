package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class q5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q5 f156878a = null;

    static {
        f156878a = new q5();
    }

    public q5() {
        Boolean r100 = Boolean.TRUE;
        super("live_game_promote_preload_opt_enable", "游戏联运判断是否优化判断逻辑", r100, r100);
    }
}
