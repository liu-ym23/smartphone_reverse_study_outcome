package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class u7 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u7 f158617a = null;

    static {
        f158617a = new u7();
    }

    public u7() {
        Boolean r100 = Boolean.TRUE;
        super("live_stream_enable_sei_sign", "是否启用SEI帧签名", r100, r100);
    }
}
