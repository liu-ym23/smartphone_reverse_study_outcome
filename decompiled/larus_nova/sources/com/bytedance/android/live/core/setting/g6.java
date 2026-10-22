package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class g6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g6 f65308a = null;

    static {
        f65308a = new g6();
    }

    public g6() {
        Boolean r100 = Boolean.TRUE;
        super("live_stream_auto_adapter_leak_fix", "StreamAutoAdapterService内存泄漏修改", r100, r100);
    }
}
