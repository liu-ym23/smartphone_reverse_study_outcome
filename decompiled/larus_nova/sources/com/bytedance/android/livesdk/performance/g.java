package com.bytedance.android.livesdk.performance;

import android.app.Activity;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<Activity> f154605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f154606b;

    public static void a(String r100, String r101, boolean r110) {
        IHostPerformanceMonitor r102 = TTLiveSDK.hostService().hostPerformanceMonitor();
        if (r102 == null) goto L19;
        Map<String, Long> r103 = r102.getMemory();
        HashMap r104 = new HashMap(r103.size() + 2);
        Iterator<Map.Entry<String, Long>> r105 = r103.entrySet().iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        Map.Entry<String, Long> r106 = r105.next();
        r104.put(r106.getKey(), String.valueOf(r106.getValue().longValue() / 1048576.0d));
        goto L7
    L9:
        if (r100 == null) goto L11;
        r104.put("enter_from_merge", r100);
    L11:
        if (r101 == null) goto L13;
        r104.put("enter_method", r101);
    L13:
        if (r110 == false) goto L15;
        String r107 = "1";
    L16:
        r104.put(IPerformanceManager.Params.is_anchor, r107);
        r104.put(IPerformanceManager.Params.landscape_scene, String.valueOf(LandscapeLiveMonitor.getLandscapeScene()));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_performance_monitor_enter_live_mem", r104, new Object[0]);
        return;
    L15:
        r107 = "0";
        goto L16
    }
}
