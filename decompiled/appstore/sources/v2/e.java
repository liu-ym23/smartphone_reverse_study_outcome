package v2;

import com.bytedance.monitor.collector.PerfMonitorManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static double a() {
        long r10 = System.currentTimeMillis();
        long r11 = PerfMonitorManager.o().c();
        Thread.sleep(360);     // Catch: InterruptedException -> L6
    L5:
        return (((PerfMonitorManager.o().c() - r11) * 1000.0d) / (System.currentTimeMillis() - r10)) / com.bytedance.apm.util.b.h(100);
    }
}
