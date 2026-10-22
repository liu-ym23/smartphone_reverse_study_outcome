package com.bytedance.android.livesdk.config;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class q9 extends SSettingKey<Map<String, ? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q9 f121036a = null;

    static {
        f121036a = new q9();
    }

    public q9() {
        super("live_accurate_experiment_mapper", "精准实验key映射", new LinkedHashMap(), new LinkedHashMap());
    }
}
