package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class r6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r6 f65402a = null;

    static {
        f65402a = new r6();
    }

    public r6() {
        Boolean r100 = Boolean.TRUE;
        super("multi_link_fresco_cache_leak_opt", "Fresco私有缓存泄漏优化(优化,开实验)", r100, r100);
    }
}
