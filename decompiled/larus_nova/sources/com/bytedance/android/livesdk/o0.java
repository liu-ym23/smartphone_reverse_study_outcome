package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class o0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f154123a = null;

    static {
        f154123a = new o0();
    }

    public o0() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_use_annie_for_create_browser_fragment", "是否允许createBrowserFragment接口强制使用新容器", r100, r100, true);
    }
}
