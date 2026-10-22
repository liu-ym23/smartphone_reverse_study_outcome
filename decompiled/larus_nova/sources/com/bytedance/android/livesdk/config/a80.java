package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class a80 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a80 f119770a = null;

    static {
        f119770a = new a80();
    }

    public a80() {
        Boolean r100 = Boolean.FALSE;
        super("live_mcu_test_fall_back", "跨房厅战公共流超时回退跨房流测试", r100, r100);
    }
}
