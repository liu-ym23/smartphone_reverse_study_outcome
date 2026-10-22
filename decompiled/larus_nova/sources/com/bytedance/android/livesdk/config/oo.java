package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class oo extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final oo f120920a = null;

    static {
        f120920a = new oo();
    }

    public oo() {
        Boolean r100 = Boolean.FALSE;
        super("live_dispatcher_schema_enable", "协议化调用框架启用的开关", r100, r100);
    }
}
