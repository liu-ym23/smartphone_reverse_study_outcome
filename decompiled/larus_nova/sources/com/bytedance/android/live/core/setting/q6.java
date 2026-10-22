package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class q6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q6 f65394a = null;

    static {
        f65394a = new q6();
    }

    public q6() {
        Boolean r100 = Boolean.TRUE;
        super("multi_link_fresco_cache_leak_fix", "Fresco私有缓存泄漏修复(Bugfix,不开实验)", r100, r100);
    }
}
