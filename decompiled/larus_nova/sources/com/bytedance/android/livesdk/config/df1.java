package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class df1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final df1 f120029a = null;

    static {
        f120029a = new df1();
    }

    public df1() {
        Boolean r100 = Boolean.TRUE;
        super("live_core_reset_params_leave_channel", "下麦时重置LiveCore参数新方式", r100, r100);
    }
}
