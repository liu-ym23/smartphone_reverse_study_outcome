package com.bytedance.android.live.core.performance;

import android.os.Handler;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import i60.e;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class CpuSampler extends BaseSampler<Double> {
    public CpuSampler() {
        throw null;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a() {
        IHostPerformanceMonitor r100 = TTMiddlewareLiveSDK.hostMiddlewareService().hostPerformanceMonitor();     // Catch: Exception -> L13
        if (r100 == null) goto L15;
        Map<String, Double> r101 = r100.getCpuRate();     // Catch: Exception -> L13
        if (r101 == null) goto L15;
        if (r101.containsKey("cpu_rate") == false) goto L15;
        if (r101.get("cpu_rate") == null) goto L15;
        double r102 = r101.get("cpu_rate").doubleValue();     // Catch: Exception -> L13
    L17:
        if (r102 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
    L24:
        this.f65104c.add((T) Double.valueOf(r102));
        Handler r103 = this.f65103b;
        if (r103 == null) goto L30;
        r103.postDelayed(this, this.f65102a);
        return;
    L30:
        return;
    L19:
        if (i60.a.c() == true) goto L21;
    L23:
        r102 = i60.a.d();
        goto L24
    L21:
        if (e.f488351a.getValue().booleanValue() == false) goto L23;
        r102 = i60.a.b();
    L15:
        r102 = -1.0d;
    L13:
        e = move-exception;
        ALogger.e("CpuSampler", e);
        goto L15
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
