package com.bytedance.apm6.memory;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.memory.config.MemoryConfig;
import com.bytedance.apm6.memory.monitorable.MemoryPerfDataEvent;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.log.Logger;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
class MemoryStatistics {
    private long lastBlockingGcCount;
    private long lastGcBlockingGcTime;
    private long lastGcCount;
    private long lastGcTime;

    private static class InnerHolder {
        private static final MemoryStatistics instance = null;

        private InnerHolder() {
        }

        static /* synthetic */ MemoryStatistics access$000() {
            return instance;
        }

        static {
            instance = new MemoryStatistics();
        }
    }

    MemoryStatistics() {
    }

    public static MemoryStatistics getInstance() {
        return InnerHolder.access$000();
    }

    void init() {
        getGcCount();
        getGcTime();
        getBlockingGcCount();
        getBlockingGcTime();
    }

    MemoryPerfDataEvent collectWithConfig(MemoryConfig r33) {
        Debug.MemoryInfo r1 = getMemoryInfo();
        if (r1 != null) goto L5;
        return null;
    L5:
        long r19 = getDalvikUsedSize(r1);
        if (r19 >= 0) goto L8;
        return null;
    L8:
        ActivityLifecycleService r2 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        long r13 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double r25 = getJavaUsedMemoryRate(r13);
        long r4 = getGcCount();
        long r6 = getGcTime();
        long r8 = getBlockingGcCount();
        long r10 = getBlockingGcTime();
        boolean r12 = !r2.isForeground();
        long r21 = ((long) r1.nativePss) * 1024;
        long r17 = 1024 * ((long) r1.getTotalPss());
        long r3 = getGraphics(r1);
        long r23 = getVmSize();
        if (r25 <= r33.memoryTopCheckThreshold()) goto L11;
        boolean r27 = true;
    L13:
        return new MemoryPerfDataEvent(r4, r6, r8, r10, r12, r21, r17, r13, r19, r3, r23, r25, r27, r33.isRealTimeMemEnable());
    L11:
        r27 = false;
        goto L13
    }

    private long getDalvikUsedSize(Debug.MemoryInfo r3) {
        return ((long) r3.dalvikPss) * 1024;
    }

    private long getGcCount() {
        long r0 = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_COUNT));
        long r2 = r0 - this.lastGcCount;
        this.lastGcCount = r0;
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d("APM-Memory", "gcCount:" + r0);
    L5:
        return r2;
    }

    private long getGcTime() {
        long r0 = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_TIME));
        long r2 = r0 - this.lastGcTime;
        this.lastGcTime = r0;
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d("APM-Memory", "gcTime:" + this.lastGcTime);
    L5:
        return r2;
    }

    private long getBlockingGcCount() {
        long r0 = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_COUNT));
        long r2 = r0 - this.lastBlockingGcCount;
        this.lastBlockingGcCount = r0;
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d("APM-Memory", "blockingGcCount:" + this.lastBlockingGcCount);
    L5:
        return r2;
    }

    private long getBlockingGcTime() {
        long r0 = Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_TIME));
        long r2 = r0 - this.lastGcBlockingGcTime;
        this.lastGcBlockingGcTime = r0;
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d("APM-Memory", "blockingGcTime:" + this.lastGcBlockingGcTime);
    L5:
        return r2;
    }

    private double getJavaUsedMemoryRate(long r3) {
        if (r3 > 0) goto L5;
        return -1.0d;
    L5:
        return new BigDecimal(r3).divide(new BigDecimal(Runtime.getRuntime().maxMemory()), 4, 4).doubleValue();
    }

    private long getGraphics(Debug.MemoryInfo r3) {
        String r2 = r3.getMemoryStat(PerfConsts.GRAPHICS_MEM);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return ((long) Integer.parseInt(r2)) * 1024;
    L7:
        e = move-exception;
        Logger.e("APM-Memory", "getGraphics", e);
        e.printStackTrace();
        return -1;
    L13:
        return -1;
    }

    private long getVmSize() {
        long r0 = Tools.getVmSize() * 1024;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return -1;
    }

    public static Debug.MemoryInfo getMemoryInfo() {
        if (ApmContext.getContext() != null) goto L11;
        return null;
    L11:
        ActivityManager r0 = (ActivityManager) ApmContext.getContext().getSystemService("activity");     // Catch: Exception -> L10
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.getProcessMemoryInfo(new int[]{Process.myPid()})[0];
    L10:
        return null;
    }
}
