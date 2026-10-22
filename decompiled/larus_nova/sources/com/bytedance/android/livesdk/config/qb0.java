package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qb0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qb0 f121042a = null;

    static {
        f121042a = new qb0();
    }

    public qb0() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_pre_apply_enable", "观众预申请全量开关", r100, r100);
    }
}
