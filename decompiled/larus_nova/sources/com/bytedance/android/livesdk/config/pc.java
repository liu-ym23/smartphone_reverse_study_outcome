package com.bytedance.android.livesdk.config;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class pc extends SSettingKey<Map<String, ? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pc f120967a = null;

    static {
        f120967a = new pc();
    }

    public pc() {
        super("live_anchor_report_url_extra_schema_param", "举报主播schema额外参数", new LinkedHashMap(), new LinkedHashMap());
    }
}
