package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ws extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ws f121549a = null;

    static {
        f121549a = new ws();
    }

    public ws() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_schema_pre_reqeust", "schema进房请求流数据", r100, r100);
    }
}
