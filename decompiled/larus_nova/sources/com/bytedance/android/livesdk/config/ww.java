package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ww extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ww f121557a = null;

    static {
        f121557a = new ww();
    }

    public ww() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_start_room_context_error", "修复StartRoom时Context为null的问题", r100, r100, true);
    }
}
