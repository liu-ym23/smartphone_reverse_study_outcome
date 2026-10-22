package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class sd1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sd1 f121201a = null;

    static {
        f121201a = new sd1();
    }

    public sd1() {
        Boolean r100 = Boolean.TRUE;
        super("prefetch_disable_local_storage", "prefetch 是否禁用本地 storage", r100, r100);
    }
}
