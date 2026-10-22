package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jg extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jg f120523a = null;

    static {
        f120523a = new jg();
    }

    public jg() {
        Boolean r100 = Boolean.TRUE;
        super("live_big_event_enable_local", "重保事件本地开关", r100, r100);
    }
}
