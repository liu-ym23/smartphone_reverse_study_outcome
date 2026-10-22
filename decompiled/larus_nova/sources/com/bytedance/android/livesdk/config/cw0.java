package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class cw0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cw0 f119984a = null;

    static {
        f119984a = new cw0();
    }

    public cw0() {
        Boolean r100 = Boolean.TRUE;
        super("live_usercenter_change_account_trace_enable", "UserCenter账号切换更新currentUser时增加trace", r100, r100);
    }
}
