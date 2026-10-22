package com.bytedance.android.livesdk.revenue.service.performance;

import android.view.Window;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.scope.o;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements c, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IPerformanceManager f157425a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final float F3() {
        return this.f157425a.getUIStallRate();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final double getCpuRate() {
        return this.f157425a.getCpuRate();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final int getCurrentMusicVolume() {
        return this.f157425a.getCurrentMusicVolume();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final float getFps() {
        return this.f157425a.getFps();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final float getFrameIntervalMillis() {
        return this.f157425a.getFrameIntervalMillis();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final double getGpuUsed() {
        return this.f157425a.getGpuUsed();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final int getMaxMusicVolume() {
        return this.f157425a.getMaxMusicVolume();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final long getPssTotal() {
        return this.f157425a.getPssTotal();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final float getTemperature() {
        return this.f157425a.getTemperature();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final double ql() {
        return this.f157425a.getBatteryCurrent();
    }

    public h() {
        this.f157425a = (IPerformanceManager) k.n(IPerformanceManager.class);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final void monitorPerformance(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f157425a.monitorPerformance(r100);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final void onModuleStop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f157425a.onModuleStop(r100);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final void releaseFpsMonitor(String r100) {
        Intrinsics.checkNotNullParameter("open_gift_panel", "scene");
        this.f157425a.releaseFpsMonitor("open_gift_panel");
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final void onModuleStart(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.f157425a.onModuleStart(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final void startMonitorFps(String r100, Window r101) {
        Intrinsics.checkNotNullParameter("open_gift_panel", "scene");
        this.f157425a.startMonitorFps("open_gift_panel", r101);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.c
    public final void stopMonitorFps(String r100, IStallCallback r101) {
        Intrinsics.checkNotNullParameter("open_gift_panel", "scene");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f157425a.stopMonitorFps("open_gift_panel", r101);
    }
}
