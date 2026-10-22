package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xp0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xp0 f121623a = null;

    static {
        f121623a = new xp0();
    }

    public xp0() {
        Boolean r100 = Boolean.TRUE;
        super("live_schema_reenter_fix", "跳转直播间后重复进房问题修复", r100, r100);
    }
}
