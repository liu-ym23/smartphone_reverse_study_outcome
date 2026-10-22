package e1;

import com.bytedance.apm.battery.stats.IBatteryStats;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements IBatteryStats {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f19243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f19244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f19245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConcurrentHashMap f19246e;

    public c(String r10) {
        this.f19246e = new ConcurrentHashMap();
        this.f19242a = r10;
        this.f19244c = ActivityLifeObserver.getInstance().isForeground();
        this.f19243b = System.currentTimeMillis();
        this.f19245d = BatteryUtils.e(w0.c.g());
    }

    public abstract void a(f1.b r10, long r11, long r12);

    public String b() {
        return this.f19242a;
    }

    public void c(long r10, long r11, boolean r12) {
        Iterator r13 = this.f19246e.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L19;
        f1.b r14 = (f1.b) ((Map.Entry) r13.next()).getValue();
        long r15 = r14.f19439b;
        if (0 >= r15) goto L11;
        if (r15 >= r14.f19438a) goto L11;
        r13.remove();
    L11:
        if (0 >= r15) goto L16;
        if (r15 >= r10) goto L16;
        r13.remove();
    L16:
        if (r11 < r14.f19438a) goto L4;
        a(r14, r10, r11);
        goto L4
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean r10) {
        this.f19244c = false;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean r10) {
        this.f19244c = true;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onTimer(boolean r10) {
        long r11 = System.currentTimeMillis();
        if (this.f19246e.size() == 0) goto L5;
        c(this.f19243b, r11, r10);
    L5:
        this.f19243b = r11;
    }
}
