package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vm extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vm f121462a = null;

    static {
        f121462a = new vm();
    }

    public vm() {
        Boolean r100 = Boolean.TRUE;
        super("live_decoration_safe_area_optimize_enable", "直播间贴纸安全区优化是否开启", r100, r100);
    }
}
