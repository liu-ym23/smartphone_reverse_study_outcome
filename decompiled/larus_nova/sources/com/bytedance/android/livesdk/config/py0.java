package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class py0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final py0 f121016a = null;

    static {
        f121016a = new py0();
    }

    public py0() {
        Boolean r100 = Boolean.TRUE;
        super("live_welfare_click_debounce_enable", "公益卡片点击debounce优化", r100, r100);
    }
}
