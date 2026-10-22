package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class a9 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a9 f102999a = null;

    static {
        f102999a = new a9();
    }

    public a9() {
        super("monitor_async_report", "monitor异步上传", Boolean.FALSE, Boolean.TRUE);
    }
}
