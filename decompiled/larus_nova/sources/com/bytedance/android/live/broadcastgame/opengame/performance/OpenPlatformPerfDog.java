package com.bytedance.android.live.broadcastgame.opengame.performance;

import android.os.Build;
import com.bytedance.android.live.broadcastgame.e0;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livesdk.config.ge0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenPlatformPerfDog implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f60690a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f60691b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f60692c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f60693d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f60694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f60695f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f60696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile float f60697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile float f60698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile int f60699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile float f60700k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile float f60701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile long f60702m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.utils.c f60703n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Disposable f60704o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final OpenPlatformPerfDog f60705p = null;

    public OpenPlatformPerfDog() {
    }

    @Override // com.bytedance.android.live.broadcastgame.e0
    public final float c() {
        LocalTestManager.a(new Class[]{wy.a.class});
        if (Build.VERSION.SDK_INT < 26) goto L11;
        IHostPerformanceMonitor r100 = (IHostPerformanceMonitor) f60695f.getValue();
        if (r100 == null) goto L19;
        Map<String, Double> r101 = r100.getCpuRate();
        if (r101 == null) goto L19;
        Double r102 = r101.get("cpu_speed");
        if (r102 == null) goto L19;
        double r103 = r102.doubleValue();
    L21:
        return (float) r103;
    L19:
        return -1.0f;
    L11:
        IHostPerformanceMonitor r104 = (IHostPerformanceMonitor) f60695f.getValue();
        if (r104 == null) goto L19;
        Map<String, Double> r105 = r104.getCpuRate();
        if (r105 == null) goto L19;
        Double r106 = r105.get("cpu_rate");
        if (r106 == null) goto L19;
        r103 = r106.doubleValue();
        goto L21
    }

    static {
        f60705p = new OpenPlatformPerfDog();
        f60690a = LazyKt.lazy(OpenPlatformPerfDog$ENCODE_FPS_THRESHOLD$2.INSTANCE);
        f60691b = LazyKt.lazy(OpenPlatformPerfDog$STUTTER_RATE_THRESHOLD$2.INSTANCE);
        f60692c = LazyKt.lazy(OpenPlatformPerfDog$BATTERY_TEMPERATURE_THRESHOLD$2.INSTANCE);
        f60693d = 2;
        f60695f = LazyKt.lazy(OpenPlatformPerfDog$mPerformanceMonitor$2.INSTANCE);
        f60703n = new com.bytedance.android.livesdk.utils.c(ge0.f120274a.getValue().f(), 1);
    }

    @Override // com.bytedance.android.live.broadcastgame.e0
    public final float a() {
        IHostPerformanceMonitor r100 = (IHostPerformanceMonitor) f60695f.getValue();
        if (r100 == null) goto L9;
        Map<String, Long> r101 = r100.getMemory();
        if (r101 == null) goto L9;
        Long r102 = r101.get("mem_pss_total");
        if (r102 == null) goto L9;
        return r102.longValue() / 1048576;
    L9:
        return -1.0f;
    }

    @Override // com.bytedance.android.live.broadcastgame.e0
    public final int b() {
        return (int) ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).getStreamRenderFps();
    }

    @Override // com.bytedance.android.live.broadcastgame.e0
    public final float d() {
        return ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).getTemperature();
    }

    @Override // com.bytedance.android.live.broadcastgame.e0
    public final float getUIStallRate() {
        float r100 = ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).getUIStallRate();
        if (r100 >= 0) goto L6;
        return 0.0f;
    L6:
        return r100;
    }
}
