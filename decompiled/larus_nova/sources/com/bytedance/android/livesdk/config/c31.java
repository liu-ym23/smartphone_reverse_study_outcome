package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class c31 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c31 f119919a = null;

    static {
        f119919a = new c31();
    }

    public c31() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_pinch_no_move", "修复pinch放大模式双指点击只接收到down和up事件导致的异常bug", r100, r100);
    }
}
