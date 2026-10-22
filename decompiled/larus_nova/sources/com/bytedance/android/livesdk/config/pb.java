package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pb extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pb f120965a = null;

    static {
        f120965a = new pb();
    }

    public pb() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_enable_monitor_merge", "主播侧埋点聚合上报", r100, r100);
    }
}
