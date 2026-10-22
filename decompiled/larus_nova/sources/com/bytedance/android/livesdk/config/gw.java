package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gw f120318a = null;

    static {
        f120318a = new gw();
    }

    public gw() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_crash_observer_leak", "crash时上报退房信息内存泄漏fix", r100, r100, true);
    }
}
