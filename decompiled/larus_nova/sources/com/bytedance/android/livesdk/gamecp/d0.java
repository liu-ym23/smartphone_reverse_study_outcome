package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveMonitorService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d0 implements ILiveMonitorService {
    public d0() {
    }

    @Override // com.bytedance.android.livesdkapi.service.gamecp.ILiveMonitorService
    public final Double getCpuRate() {
        IPerformanceManager r100 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return Double.valueOf(r100.getCpuRate());
    }

    @Override // com.bytedance.android.livesdkapi.service.gamecp.ILiveMonitorService
    public final Double getGpuUsed() {
        IPerformanceManager r100 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return Double.valueOf(r100.getGpuUsed());
    }

    @Override // com.bytedance.android.livesdkapi.service.gamecp.ILiveMonitorService
    public final Float getTemperature() {
        IPerformanceManager r100 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return Float.valueOf(r100.getTemperature());
    }

    @Override // com.bytedance.android.livesdkapi.service.gamecp.ILiveMonitorService
    public final void onModuleStop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        IPerformanceManager r101 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r101 == null) goto L6;
        r101.onModuleStop(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.gamecp.ILiveMonitorService
    public final void onModuleStart(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "extra");
        IPerformanceManager r102 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r102 == null) goto L6;
        r102.onModuleStart(r100, r101);
        return;
    }
}
