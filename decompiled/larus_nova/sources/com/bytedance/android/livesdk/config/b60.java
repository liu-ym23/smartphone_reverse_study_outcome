package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiLinkBaseDegradeConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class b60 extends SSettingKey<MultiLinkBaseDegradeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b60 f119845a = null;

    static {
        f119845a = new b60();
    }

    public b60() {
        super("live_performance_degrade_base", "多人基础性能降级", new MultiLinkBaseDegradeConfig(), new MultiLinkBaseDegradeConfig());
    }
}
