package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class b1 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b1 f119835a = null;

    static {
        f119835a = new b1();
    }

    public b1() {
        super(LiveInitSettingKeys.CJ_SCHEMA_RISK_INFO_HOSTS, "财经拼接risk_info支持的host", new ArrayList(), new ArrayList());
    }
}
