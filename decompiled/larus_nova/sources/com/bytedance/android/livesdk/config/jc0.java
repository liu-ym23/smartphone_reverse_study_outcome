package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jc0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jc0 f120514a = null;

    static {
        f120514a = new jc0();
    }

    public jc0() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_scene_inner_draw_preload_handle_mem_leak", "多人场景预览流内流预加载布局优化-处理内存泄漏", r100, r100);
    }
}
