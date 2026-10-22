package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class k1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k1 f120568a = null;

    static {
        f120568a = new k1();
    }

    public k1() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_clear_screen_before_all_comp_load", "修复在组件未加载完成前就进行清屏导致ui展示有问题的bug", r100, r100);
    }
}
