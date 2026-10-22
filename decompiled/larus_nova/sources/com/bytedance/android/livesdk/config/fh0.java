package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fh0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fh0 f120203a = null;

    static {
        f120203a = new fh0();
    }

    public fh0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_interact_audience_permission_guarantor_enable", "PK中观众连线音视频权限释放白名单页面机制开关", r100, r100);
    }
}
