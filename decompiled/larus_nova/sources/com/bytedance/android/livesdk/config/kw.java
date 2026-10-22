package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class kw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kw f120633a = null;

    static {
        f120633a = new kw();
    }

    public kw() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_end_room_with_init", "init状态执行退房问题修复", r100, r100, true);
    }
}
