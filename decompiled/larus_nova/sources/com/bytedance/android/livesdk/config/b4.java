package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class b4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b4 f119841a = null;

    static {
        f119841a = new b4();
    }

    public b4() {
        Boolean r100 = Boolean.TRUE;
        super("enable_pb_prefetch", "启用 Protobuf Prefetch", r100, r100);
    }
}
