package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class td1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final td1 f121290a = null;

    static {
        f121290a = new td1();
    }

    public td1() {
        Boolean r100 = Boolean.FALSE;
        super("prefetch_read_all_local_config_files", "遍历本地所有 channel 下的 configurations", r100, r100);
    }
}
