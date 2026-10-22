package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pr0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pr0 f121002a = null;

    static {
        f121002a = new pr0();
    }

    public pr0() {
        Boolean r100 = Boolean.FALSE;
        super("live_setting_by_lazy_opt", "是否开启settings读取by lazy + 缓存优化", r100, r100);
    }
}
