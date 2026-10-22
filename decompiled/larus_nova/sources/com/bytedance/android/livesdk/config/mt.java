package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class mt extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mt f120781a = null;

    static {
        f120781a = new mt();
    }

    public mt() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_visibility_scope_share", "主播是否启用可见范围分享限制", r100, r100);
    }
}
