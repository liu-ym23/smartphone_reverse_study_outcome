package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hv0 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hv0 f120407a = null;

    static {
        f120407a = new hv0();
    }

    public hv0() {
        super("live_trace_decode_error_max_count", "消息Trace解析失败上报数量限制", 15, 15);
    }
}
