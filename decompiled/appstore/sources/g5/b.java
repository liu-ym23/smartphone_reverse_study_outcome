package g5;

import android.util.Pair;
import com.bytedance.monitor.collector.AbsMonitor;
import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.MonitorType;
import com.bytedance.monitor.collector.PerfMonitorManager;

/* JADX INFO: loaded from: classes.dex */
public class b extends AbsMonitor {
    public b(int r10) {
        super(r10, MonitorType.ATRACE_MONITOR);
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair a() {
    L8:
        return null;
    L4:
        if (PerfMonitorManager.f7820t == true) goto L6;
        return null;
    L6:
        return new Pair(this.f7705a, g());
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair b(long r10, long r11) {
    L8:
        return null;
    L4:
        if (PerfMonitorManager.f7820t == true) goto L6;
        return null;
    L6:
        return new Pair(this.f7705a, h(r10, r11));
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void f(int r10) {
    }

    public final String g() {
        if (PerfMonitorManager.f7820t == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtrace();
    }

    public final String h(long r10, long r11) {
        if (PerfMonitorManager.f7820t == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtraceRange(r10, r11);
    }

    public void i(long r10) {
        if (PerfMonitorManager.f7820t == true) goto L5;
        return;
    L5:
        MonitorJni.doEnableAtrace(this.f7707c, r10);     // Catch: Throwable -> L7
        return;
    }
}
