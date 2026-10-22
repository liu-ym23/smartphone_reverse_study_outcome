package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class j9 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j9 f120506a = null;

    static {
        f120506a = new j9();
    }

    public j9() {
        Boolean r100 = Boolean.TRUE;
        super("link_intercept_disposed_rooms", "拦截已停止的房间的连麦初始化过程（风险控制用）", r100, r100);
    }
}
