package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class d2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d2 f65279a = null;

    static {
        f65279a = new d2();
    }

    public d2() {
        Boolean r100 = Boolean.TRUE;
        super("live_jato_change_opt", "将 JatoOptFrameLayout 改为 VisibilityProxy 的端上兜底开关", r100, r100);
    }
}
