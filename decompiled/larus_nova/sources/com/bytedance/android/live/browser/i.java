package com.bytedance.android.live.browser;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements com.bytedance.android.annie.monitor.lynx.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f62640a;

    @Override // com.bytedance.android.annie.monitor.lynx.b
    public final AnnieNGInitHelper$createMonitorProvider$1$providerFpsMonitor$1 a() {
        return new AnnieNGInitHelper$createMonitorProvider$1$providerFpsMonitor$1(this);
    }

    @Override // com.bytedance.android.annie.monitor.lynx.b
    public final Map<String, String> b() {
        return MapsKt.mapOf(TuplesKt.to("webcast_sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b())));
    }

    public i(w r100) {
        this.f62640a = r100;
    }
}
