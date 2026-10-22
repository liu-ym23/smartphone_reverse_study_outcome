package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class p5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p5 f154193a = null;

    static {
        f154193a = new p5();
    }

    public p5() {
        super("live_game_promote_preload_enter_card", "游戏联运是否启用接口预加载", Boolean.FALSE, Boolean.TRUE);
    }
}
