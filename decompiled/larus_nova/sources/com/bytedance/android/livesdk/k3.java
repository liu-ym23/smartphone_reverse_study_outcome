package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdk.config.ti1;

/* JADX INFO: loaded from: classes7.dex */
public final class k3 extends SSettingKey<ti1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k3 f142264a = null;

    static {
        k3 r100 = new k3();
        f142264a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public k3() {
        super("live_vboost_opt", "vboost性能加速优化", new ti1(), new ti1());
    }
}
