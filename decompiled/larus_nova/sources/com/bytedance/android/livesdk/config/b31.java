package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class b31 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b31 f119840a = null;

    static {
        f119840a = new b31();
    }

    public b31() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_short_touch_forbidden", "修复短触区管控能力开关", r100, r100);
    }
}
