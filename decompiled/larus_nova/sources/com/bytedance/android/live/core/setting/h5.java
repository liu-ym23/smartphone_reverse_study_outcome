package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class h5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h5 f65316a = null;

    static {
        f65316a = new h5();
    }

    public h5() {
        Boolean r100 = Boolean.FALSE;
        super("live_smart_observer_config", "直播smartSDK清理Observer优化", r100, r100);
    }
}
