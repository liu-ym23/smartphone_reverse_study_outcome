package com.bytedance.android.live.browser.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements x8.d {
    public a() {
    }

    @Override // x8.d
    public final void e(String r100, Throwable r110) {
        ALogger.e(r100, r110);
        if (r110 == null) goto L6;
        String r111 = r110.getMessage();
        if (r111 == null) goto L6;
    L7:
        JSONObject r101 = new JSONObject();
        r101.put("tag", r100);
        Unit r102 = Unit.INSTANCE;
        y50.i.m(ILiveHybridMonitor.ContainerType.ANNIE, null, null, "AnnieEnv.registerService#e(tag: String?, throwable: Throwable?)", 1, r111, r101, 6);
        return;
    L6:
        r111 = "";
        goto L7
    }

    @Override // x8.d
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        HybridLogger r102 = HybridLogger.f246343a;
        if (HybridLogger.c(r100, r101, LogLevel.I) == false) goto L5;
        return;
    L5:
        ALogger.i(r100, r101);
    }

    @Override // x8.d
    public final void e(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "msg");
        ALogger.e(r110, r111);
        JSONObject r100 = new JSONObject();
        r100.put("tag", r110);
        Unit r112 = Unit.INSTANCE;
        y50.i.m(ILiveHybridMonitor.ContainerType.ANNIE, null, null, "AnnieEnv.registerService#e(tag: String, msg: String)", 1, r111, r100, 6);
    }
}
