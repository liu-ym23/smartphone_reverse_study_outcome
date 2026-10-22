package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dn0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dn0 f120051a = null;

    static {
        f120051a = new dn0();
    }

    public dn0() {
        Boolean r100 = Boolean.TRUE;
        super("live_reset_dynamic_from_audience", "在LinkMultiControlWidget中重置dynamicFromAudience", r100, r100, true);
    }
}
