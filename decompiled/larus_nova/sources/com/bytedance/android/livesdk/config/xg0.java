package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xg0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xg0 f121602a = null;

    static {
        f121602a = new xg0();
    }

    public xg0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_audience_reset_by_pull_state_enable", "观众端依赖拉流时机触发状态重置", r100, r100);
    }
}
