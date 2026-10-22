package com.bytedance.android.livesdk.config;

import com.ss.android.downloadlib.addownload.AdQuickAppManager;

/* JADX INFO: loaded from: classes8.dex */
public final class p80 extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p80 f120958a = null;

    static {
        f120958a = new p80();
    }

    public p80() {
        Long r100 = Long.valueOf(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        super("live_message_max_total_dispatch_time", "消息分发最大可用时间", r100, r100);
    }
}
