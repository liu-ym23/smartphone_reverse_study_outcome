package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class oq0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final oq0 f120925a = null;

    static {
        f120925a = new oq0();
    }

    public oq0() {
        Boolean r100 = Boolean.TRUE;
        super("live_screen_cast_load_opt", "正在投屏时，提高投屏组件加载优先级", r100, r100, true);
    }
}
