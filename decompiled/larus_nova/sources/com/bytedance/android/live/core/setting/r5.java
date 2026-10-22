package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class r5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r5 f65401a = null;

    static {
        f65401a = new r5();
    }

    public r5() {
        Boolean r100 = Boolean.FALSE;
        super("live_use_component_strategy_in_portrait", "直播组件是否接入动态策略(竖屏)", r100, r100, false);
    }
}
