package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pu extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pu f121007a = null;

    static {
        f121007a = new pu();
    }

    public pu() {
        Boolean r100 = Boolean.FALSE;
        super("live_enter_room_trace_v2", "进退房trace日志", r100, r100, true);
    }
}
