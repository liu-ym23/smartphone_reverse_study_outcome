package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class y70 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y70 f121661a = null;

    public y70() {
        super("live_mcu_fallback_protect_time", "跨房厅战MCU公共流拉流失败兜底超时时间", 3, 3);
    }

    static {
        f121661a = new y70();
    }
}
