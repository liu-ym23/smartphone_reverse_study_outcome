package com.bytedance.android.live.browser.service;

import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class AnniePerformanceServiceImpl implements m9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f64267a;

    public static final class a implements IStallCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f64268a;

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onBlockReady(long r100, int r101, long r102) {
        }

        public a(Function2 r100) {
            this.f64268a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onFpsReady(double r100, JSONObject r101) {
            Function2 r102 = this.f64268a;
            if (r102 == null) goto L6;
            Unit r103 = (Unit) r102.invoke(Double.valueOf(r100), r101);
            return;
        }
    }

    public final IPerformanceManager H1() {
        return (IPerformanceManager) this.f64267a.getValue();
    }

    public AnniePerformanceServiceImpl() {
        this.f64267a = InfraKotlinExtsKt.mainThreadLazy(AnniePerformanceServiceImpl$hostPerformanceManager$2.INSTANCE);
    }

    @Override // m9.c
    public final double getCpuRate() {
        IPerformanceManager r100 = H1();
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100.getCpuRate();
    }

    @Override // m9.c
    public final double getCpuSpeed() {
        IPerformanceManager r100 = H1();
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100.getCpuSpeed();
    }

    @Override // m9.c
    public final float getTemperature() {
        IPerformanceManager r100 = H1();
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getTemperature();
    }

    @Override // m9.c
    public final void c1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        IPerformanceManager r101 = H1();
        if (r101 == null) goto L6;
        r101.startMonitorFps(r100);
        return;
    }

    @Override // m9.c
    public final void h0(String r100, Function2<? super Double, ? super JSONObject, Unit> r101) {
        IPerformanceManager r102 = H1();
        if (r102 == null) goto L5;
        r102.stopMonitorFps(r100, new a(r101));
    L5:
        IPerformanceManager r103 = H1();
        if (r103 == null) goto L9;
        r103.releaseFpsMonitor(r100);
        return;
    }
}
