package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ga1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ga1 f120264a = null;

    static {
        f120264a = new ga1();
    }

    public ga1() {
        Boolean r100 = Boolean.FALSE;
        super("live_multi_linker_backup_stream_disable", "多人主播连线主备流开关", r100, r100);
    }
}
