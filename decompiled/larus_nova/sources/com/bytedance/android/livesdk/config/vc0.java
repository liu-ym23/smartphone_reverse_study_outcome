package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vc0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vc0 f121438a = null;

    static {
        f121438a = new vc0();
    }

    public vc0() {
        Boolean r100 = Boolean.TRUE;
        super("live_new_inroom_share_schema_enable", "是否使用迁移后的分享schema处理", r100, r100);
    }
}
