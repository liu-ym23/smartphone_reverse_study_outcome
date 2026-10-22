package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class uq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uq f121393a = null;

    static {
        f121393a = new uq();
    }

    public uq() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_apply_permission_dialog", "是否收敛连麦申请权限开关到独立dialog", r100, r100);
    }
}
