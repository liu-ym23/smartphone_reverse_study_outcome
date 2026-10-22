package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class s0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s0 f65404a = null;

    static {
        f65404a = new s0();
    }

    public s0() {
        Boolean r100 = Boolean.TRUE;
        super("live_dynamic_strategy_redpack_term_enable", "是否加载电商红包临态策略", r100, r100);
    }
}
