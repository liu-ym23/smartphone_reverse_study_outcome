package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class c4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c4 f119920a = null;

    static {
        f119920a = new c4();
    }

    public c4() {
        Boolean r100 = Boolean.TRUE;
        super("enable_pb_prefetch_shrink", "启用 Protobuf Prefetch", r100, r100);
    }
}
