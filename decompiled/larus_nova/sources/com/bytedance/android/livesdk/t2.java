package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class t2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t2 f158505a = null;

    static {
        f158505a = new t2();
    }

    public t2() {
        Boolean r100 = Boolean.TRUE;
        super("live_search_keep_perf_opt", "搜索入口性能优化", r100, r100);
    }
}
