package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class l1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l1 f120645a = null;

    static {
        f120645a = new l1();
    }

    public l1() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_cs_consume_ps_click", "忽略此次点击公屏清屏", r100, r100);
    }
}
