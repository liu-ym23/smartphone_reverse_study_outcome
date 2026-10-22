package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class sk extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sk f121234a = null;

    static {
        f121234a = new sk();
    }

    public sk() {
        Boolean r100 = Boolean.FALSE;
        super("live_clean_mode_use_new_close_button", "清屏模式下是否使用的关闭按钮样式", r100, r100);
    }
}
