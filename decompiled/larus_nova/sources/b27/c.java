package b27;

import android.util.Pair;
import com.bytedance.monitor.collector.AbsMonitor;
import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.MonitorType;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends AbsMonitor {
    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final Pair<String, ?> a() {
    L12:
        return null;
    L4:
        if (com.bytedance.monitor.collector.c.f265641j == true) goto L6;
        return null;
    L6:
        String r100 = this.f265559a;     // Catch: Throwable -> L12
        if (com.bytedance.monitor.collector.c.f265641j == true) goto L9;
        String r101 = null;
    L10:
        return new Pair(r100, r101);
    L9:
        r101 = MonitorJni.doDumpAtrace();     // Catch: Throwable -> L12
        goto L10
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final void d(int r100) {
    }

    public c(int r100) {
        super(r100, MonitorType.ATRACE_MONITOR);
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final Pair<String, ?> b(long r100, long r101) {
    L12:
        return null;
    L4:
        if (com.bytedance.monitor.collector.c.f265641j == true) goto L6;
        return null;
    L6:
        String r102 = this.f265559a;     // Catch: Throwable -> L12
        if (com.bytedance.monitor.collector.c.f265641j == true) goto L9;
        String r103 = null;
    L10:
        return new Pair(r102, r103);
    L9:
        r103 = MonitorJni.doDumpAtraceRange(r100, r101);     // Catch: Throwable -> L12
        goto L10
    }
}
