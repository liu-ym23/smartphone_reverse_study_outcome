package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class wr0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wr0 f121548a = null;

    static {
        f121548a = new wr0();
    }

    public wr0() {
        Boolean r100 = Boolean.TRUE;
        super("live_share_schema_fallback_top_activity_enable", "分享schema当context无效时fallback到topActivity", r100, r100);
    }
}
