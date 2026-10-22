package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class uw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uw f121405a = null;

    static {
        f121405a = new uw();
    }

    public uw() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_service_exception_anr", "修复service找不到导致的ANR", r100, r100);
    }
}
