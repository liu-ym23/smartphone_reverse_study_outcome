package com.bytedance.android.live.platformplayer.init;

import android.os.Debug;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import i60.e;
import java.util.HashMap;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f85504a;

    public c() {
        this.f85504a = "LivePlayerMonitorService";
    }

    public final Map<String, Long> a(boolean r100, boolean r101) {
        Map<String, Long> r102 = null;
        if (r100 == true) goto L10;
        if (r101 == true) goto L10;
    L14:
        e = e;
    L22:
        ALogger.e(this.f85504a, e);
        return r102;
    L6:
        if (((IPerformanceManager) k.n(IPerformanceManager.class)).getPssTotal() < 0) goto L10;
        HashMap r103 = new HashMap();     // Catch: Exception -> L14
        r103.put("mem_pss_total", Long.valueOf(((IPerformanceManager) k.n(IPerformanceManager.class)).getPssTotal()));     // Catch: Exception -> L20
        r103.put("mem_pss_dalvik", Long.valueOf(((IPerformanceManager) k.n(IPerformanceManager.class)).getPssDalvik()));     // Catch: Exception -> L20
        r102 = r103;
    L20:
        e = e;
        r102 = r103;
    L10:
        if (r102 != null) goto L16;
        IHostPerformanceMonitor r104 = TTMiddlewareLiveSDK.hostMiddlewareService().hostPerformanceMonitor();     // Catch: Exception -> L14
        if (r104 == null) goto L16;
        r102 = r104.getMemory();     // Catch: Exception -> L14
    L16:
        if (r102 != null) goto L28;
        r103 = new HashMap();     // Catch: Exception -> L14
        SettingKey<Boolean> r105 = e.f488351a;     // Catch: Exception -> L20
        Debug.MemoryInfo r106 = new Debug.MemoryInfo();     // Catch: Exception -> L20
        Debug.getMemoryInfo(r106);     // Catch: Exception -> L20
        r103.put("mem_pss_total", Long.valueOf(r106.getTotalPss()));     // Catch: Exception -> L20
        Debug.MemoryInfo r107 = new Debug.MemoryInfo();     // Catch: Exception -> L20
        Debug.getMemoryInfo(r107);     // Catch: Exception -> L20
        r103.put("mem_pss_dalvik", Long.valueOf(r107.dalvikPss));     // Catch: Exception -> L20
        return r103;
    L28:
        return r102;
    }
}
