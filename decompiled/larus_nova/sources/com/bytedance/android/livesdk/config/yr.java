package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class yr extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yr f121710a = null;

    static {
        f121710a = new yr();
    }

    public yr() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_instant_cpu_rate", "是否允许CPU瞬时采集", r100, r100);
    }
}
