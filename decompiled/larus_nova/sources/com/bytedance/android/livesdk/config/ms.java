package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ms extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ms f120779a = null;

    static {
        f120779a = new ms();
    }

    public ms() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_object_accelerated_opt", "直播大对象创建加速", r100, r100);
    }
}
