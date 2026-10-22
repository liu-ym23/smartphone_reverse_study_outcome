package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class b80 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b80 f119848a = null;

    static {
        f119848a = new b80();
    }

    public b80() {
        Boolean r100 = Boolean.FALSE;
        super("live_mdns_monitor_localip", "mdns trace 上报局域网ip", r100, r100);
    }
}
