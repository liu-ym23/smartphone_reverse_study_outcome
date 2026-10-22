package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dc1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dc1 f120022a = null;

    static {
        f120022a = new dc1();
    }

    public dc1() {
        Boolean r100 = Boolean.TRUE;
        super("not_rotate_screen_when_viewpager_scroll", "在VertialViewPager处于滑动状态时不旋转屏幕", r100, r100);
    }
}
