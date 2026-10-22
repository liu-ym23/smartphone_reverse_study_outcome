package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ti extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ti f121301a = null;

    static {
        f121301a = new ti();
    }

    public ti() {
        Boolean r100 = Boolean.TRUE;
        super("live_bundle_opt_switch", "直播间bundle优化开关", r100, r100, true);
    }
}
