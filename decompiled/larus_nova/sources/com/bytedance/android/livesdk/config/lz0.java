package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lz0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lz0 f120719a = null;

    static {
        f120719a = new lz0();
    }

    public lz0() {
        Boolean r100 = Boolean.TRUE;
        super("live_xplay_anchor_crash_resume_enable", "Xplay主播断播续玩能力开关", r100, r100);
    }
}
