package com.bytedance.android.livesdk.config;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class va1 extends SSettingKey<Map<String, ? extends Map<String, ? extends Object>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final va1 f121433a = null;

    static {
        f121433a = new va1();
    }

    public va1() {
        super("multi_link_sr_config", "多人场景超分配置", MapsKt.mapOf(TuplesKt.to("default", MapsKt.mapOf(TuplesKt.to("default", "default")))), MapsKt.mapOf(TuplesKt.to("default", MapsKt.mapOf(TuplesKt.to("default", "default")))));
    }
}
