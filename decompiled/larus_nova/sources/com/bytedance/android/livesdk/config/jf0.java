package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jf0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jf0 f120521a = null;

    static {
        f120521a = new jf0();
    }

    public jf0() {
        super("live_paid_room_change_to_scope", "付费直播迁移至scope", Boolean.FALSE, Boolean.TRUE);
    }
}
