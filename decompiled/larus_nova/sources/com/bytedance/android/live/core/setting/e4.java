package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class e4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e4 f65289a = null;

    static {
        f65289a = new e4();
    }

    public e4() {
        Boolean r100 = Boolean.TRUE;
        super("webcast_redirect_url_remove_auth_header", "redirect重定向规则接口去除 Authorization header", r100, r100);
    }
}
