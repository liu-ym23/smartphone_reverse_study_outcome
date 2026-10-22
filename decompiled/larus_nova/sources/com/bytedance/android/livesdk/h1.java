package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class h1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h1 f132623a = null;

    static {
        f132623a = new h1();
    }

    public h1() {
        Boolean r100 = Boolean.FALSE;
        super("live_mdns_js_event_mock", "mdns发现JSB能力mock event", r100, r100);
    }
}
