package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class w0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f160649a = null;

    static {
        f160649a = new w0();
    }

    public w0() {
        Boolean r100 = Boolean.TRUE;
        super("live_inject_roi2_params", "是否注入直播roi2参数", r100, r100);
    }
}
