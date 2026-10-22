package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hq f120396a = null;

    static {
        f120396a = new hq();
    }

    public hq() {
        Boolean r100 = Boolean.TRUE;
        super("live_ec_enable_saas_downgrade_old_live_annie_fragment", "SaaS ec是否降级最老的Annie容器", r100, r100);
    }
}
