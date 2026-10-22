package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class i80 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i80 f120430a = null;

    static {
        f120430a = new i80();
    }

    public i80() {
        Boolean r100 = Boolean.FALSE;
        super("live_merge_monitor_degrade_config", "埋点聚拢性能降级", r100, r100);
    }
}
