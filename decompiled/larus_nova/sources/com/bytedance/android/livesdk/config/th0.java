package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class th0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final th0 f121300a = null;

    static {
        f121300a = new th0();
    }

    public th0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_update_is_engine_on_enable", "兜底修复聊天室嘉宾侧提前进房badcase导致的crash", r100, r100);
    }
}
