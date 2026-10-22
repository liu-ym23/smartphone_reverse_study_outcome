package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class mk extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mk f120763a = null;

    static {
        f120763a = new mk();
    }

    public mk() {
        Boolean r100 = Boolean.TRUE;
        super("live_chorus_unload_rts", "合唱场景不加载RTS", r100, r100);
    }
}
