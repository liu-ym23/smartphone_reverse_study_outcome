package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pp0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pp0 f120998a = null;

    static {
        f120998a = new pp0();
    }

    public pp0() {
        Boolean r100 = Boolean.TRUE;
        super("live_safe_create_live_core_client", "临时: 保护LiveClientClient被创建多次的情况", r100, r100);
    }
}
