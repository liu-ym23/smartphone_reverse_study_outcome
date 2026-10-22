package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class h3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h3 f65314a = null;

    static {
        f65314a = new h3();
    }

    public h3() {
        Boolean r100 = Boolean.FALSE;
        super("live_not_depend_lucky_sdk", "直播容器不依赖激励SDK", r100, r100);
    }
}
