package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class o6 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o6 f154129a = null;

    static {
        f154129a = new o6();
    }

    public o6() {
        Boolean r100 = Boolean.TRUE;
        super("live_no_create_delay_runnable_when_refresh", "toolbar刷新时未注册不重新创建runnable", r100, r100);
    }
}
