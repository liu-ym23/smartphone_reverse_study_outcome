package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.ReportConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class bf1 extends SSettingKey<ReportConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bf1 f119864a = null;

    static {
        f119864a = new bf1();
    }

    public bf1() {
        super("report_config", "客户端举报配置", new ReportConfig(), new ReportConfig());
    }
}
