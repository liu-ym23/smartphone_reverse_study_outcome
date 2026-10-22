package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ih0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ih0 f120454a = null;

    static {
        f120454a = new ih0();
    }

    public ih0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_opt_crop_for_pc_after_measure", "PC横屏PK画面在player layout后再强制处理crop", r100, r100);
    }
}
