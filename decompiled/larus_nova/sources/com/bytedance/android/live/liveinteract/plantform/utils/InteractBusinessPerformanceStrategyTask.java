package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyMonitor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes46.dex */
public class InteractBusinessPerformanceStrategyTask extends BasePerformanceStrategyTask {
    private final List<WeakReference<com.bytedance.android.livesdk.a>> degradeStrategyList;
    public boolean isInit;

    private String getLevelStr(int r100) {
        if (r100 != 1) goto L7;
        return "serious";
    L7:
        if (r100 != 2) goto L10;
        return "critical";
    L10:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask
    public boolean onTriggerEnhance(int r100, Map<String, String> r101, IPerformanceStrategyMonitor r102) {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask
    public void onTriggerOrigin(Map<String, String> r100, IPerformanceStrategyMonitor r101) {
    }

    public void init() {
        if (this.isInit == true) goto L9;
        IPerformanceStrategyManager r100 = (IPerformanceStrategyManager) jc1.k.f(IPerformanceStrategyManager.class);
        if (r100 == null) goto L7;
        r100.registerPerformanceStrategyTask(300, this);
    L7:
        this.isInit = true;
        return;
    }

    public InteractBusinessPerformanceStrategyTask() {
        this.degradeStrategyList = new CopyOnWriteArrayList();
        this.isInit = false;
    }

    public void addBusinessDegradeStrategy(com.bytedance.android.livesdk.a r100) {
        this.degradeStrategyList.add(new WeakReference(r100));
    }

    public void onDownGradeInfo(boolean r100, int r101) {
        HashMap r102 = new HashMap();
        r102.put("degrade_level", getLevelStr(r101));
        Iterator<WeakReference<com.bytedance.android.livesdk.a>> r103 = this.degradeStrategyList.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.a r104 = r103.next().get();
        if (r104 == null) goto L4;
        ALogger.w("LiveDegradeManager", "onDownGradeInfo" + r101);
        com.bytedance.android.livesdk.a.f102981g = r101;
        r104.a(r101);
        if (r104.f102984b == false) goto L4;
        r102.put("scene", r104.f102988f.a());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_performance_monitor_biz_degrade", r102, new Object[]{com.bytedance.android.livesdk.log.filter.y.class});
        goto L4
    L10:
        HashMap r105 = new HashMap();
        r105.put("degrade_level", getLevelStr(r101));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_performance_monitor_degrade_notify", r105, new Object[]{com.bytedance.android.livesdk.log.filter.y.class});
    }

    public void resetBusinessDegradeStrategy(int r100, String r101) {
        Iterator<WeakReference<com.bytedance.android.livesdk.a>> r102 = this.degradeStrategyList.iterator();
    L4:
        if (r102.hasNext() == false) goto L17;
        com.bytedance.android.livesdk.a r103 = r102.next().get();
        if (r103 == null) goto L4;
        List<Integer> r104 = r103.f102988f.c();
        if (r104 == null) goto L4;
        if (r104.isEmpty() == true) goto L4;
        if (r104.contains(Integer.valueOf(r100)) == false) goto L4;
        if (r101 == null) goto L16;
        if (r103.f102988f.a().equals(r101) == false) goto L4;
    L16:
        r103.f102984b = false;
        r103.f102985c = 0;
        goto L4
    }

    public boolean onDownGradeInfo(int r100, Map<String, String> r101, IPerformanceStrategyMonitor r102) {
        HashMap r103 = new HashMap();
        r103.put("degrade_level", getLevelStr(r100));
        Iterator<WeakReference<com.bytedance.android.livesdk.a>> r104 = this.degradeStrategyList.iterator();
        boolean r105 = false;
    L4:
        if (r104.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.a r106 = r104.next().get();
        if (r106 == null) goto L4;
        ALogger.w("LiveDegradeManager", "onDownGradeInfo" + r100);
        com.bytedance.android.livesdk.a.f102981g = r100;
        r106.a(r100);
        if (r106.f102984b == false) goto L4;
        r103.put("scene", r106.f102988f.a());
        r102.updatePerformanceExecuteMonitor(r103, r100);
        r105 = true;
        goto L4
    L10:
        HashMap r107 = new HashMap();
        r107.put("degrade_level", getLevelStr(r100));
        r102.updatePerformanceNotifyMonitor(r107, r100);
        return r105;
    }

    @Override // com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask
    public boolean onTriggerDegrade(int r100, Map<String, String> r101, IPerformanceStrategyMonitor r102) {
        onDownGradeInfo(r100, r101, r102);
        return false;
    }
}
