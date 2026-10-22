package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pc0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pc0 f120968a = null;

    static {
        f120968a = new pc0();
    }

    public pc0() {
        Boolean r100 = Boolean.FALSE;
        super("live_network_request_test_force_json", "强制 gift/list 使用 json", r100, r100);
    }
}
