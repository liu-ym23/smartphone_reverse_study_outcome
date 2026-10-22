package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class uh0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uh0 f121374a = null;

    static {
        f121374a = new uh0();
    }

    public uh0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pk_update_list_enable", "是否允许兜底更新用户列表", r100, r100);
    }
}
