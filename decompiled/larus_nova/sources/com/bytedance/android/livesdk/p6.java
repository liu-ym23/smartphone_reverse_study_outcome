package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class p6 extends SettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p6 f154194a = null;

    static {
        f154194a = new p6();
    }

    public p6() {
        super("live_ntp_server_url", "", "对时使用的 NTP 服务器地址");
    }
}
