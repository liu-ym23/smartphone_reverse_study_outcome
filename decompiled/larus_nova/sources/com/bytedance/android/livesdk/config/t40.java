package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class t40 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t40 f121272a = null;

    static {
        f121272a = new t40();
    }

    public t40() {
        Boolean r100 = Boolean.TRUE;
        super("live_ktv_old_challenge_delay_load_enable", "旧版演唱挑战观众端延迟加载", r100, r100);
    }
}
