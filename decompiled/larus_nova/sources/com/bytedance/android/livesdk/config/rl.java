package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rl extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rl f121140a = null;

    static {
        f121140a = new rl();
    }

    public rl() {
        Boolean r100 = Boolean.TRUE;
        super("live_commerce_mini_window_start_fix", "兜底修复店铺页进入直播间偶现异常吊起小窗逻辑", r100, r100);
    }
}
