package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ct extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ct f119977a = null;

    static {
        f119977a = new ct();
    }

    public ct() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_shorttouch_term_strategy", "短触临态策略展示开关", r100, r100, false);
    }
}
