package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class pa1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pa1 f120964a = null;

    static {
        f120964a = new pa1();
    }

    public pa1() {
        Boolean r100 = Boolean.TRUE;
        super("multi_link_enter_room_log_extra_params", "多人场景进房埋点上报链路细节耗时", r100, r100);
    }
}
