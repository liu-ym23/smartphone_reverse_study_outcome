package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class h6 extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h6 f132628a = null;

    static {
        f132628a = new h6();
    }

    public h6() {
        super("live_mark_user_operate_freq", "标记用户按钮的的点击间隔", 3000L, 3000L);
    }
}
