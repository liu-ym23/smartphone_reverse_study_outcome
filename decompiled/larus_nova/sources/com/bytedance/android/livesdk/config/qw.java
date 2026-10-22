package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qw f121087a = null;

    static {
        f121087a = new qw();
    }

    public qw() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_new_stream_ready_status_error", "修复音画链路ready的状态异常", r100, r100);
    }
}
