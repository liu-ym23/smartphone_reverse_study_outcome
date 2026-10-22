package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class v7 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v7 f159245a = null;

    static {
        f159245a = new v7();
    }

    public v7() {
        Boolean r100 = Boolean.TRUE;
        super("live_stream_log_with_app_state", "livestream日志补充app_state", r100, r100);
    }
}
