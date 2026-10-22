package e1;

import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.stats.IBatteryStats;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements IBatteryStats {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f19238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f19239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f19241d;

    public b(String r10) {
        this.f19240c = r10;
        this.f19241d = w0.c.F();
        this.f19238a = ActivityLifeObserver.getInstance().isForeground();
        this.f19239b = BatteryUtils.e(w0.c.g());
    }

    public abstract void a(boolean r10, boolean r11);

    public boolean b() {
        return this.f19241d;
    }

    public void c(boolean r11, long r12, String r14) {
        if (r12 < 0) goto L5;
        d1.a.h().l(new p1.a(r11, System.currentTimeMillis(), this.f19240c, this.f19239b, r12, r14));
        return;
    L5:
        if (w0.c.B() == false) goto L7;
        s1.c.d(s1.b.f24484b, new String[]{"AbsBatteryValueStats value error: " + r12 + " type:" + this.f19240c});
    L7:
        s1.a.d(Constants.TAG_BATTERY, "AbsBatteryValueStats value error: " + r12 + " type:" + this.f19240c);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean r10) {
        a(this.f19238a, r10);
        this.f19238a = false;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onChargeStatusChange(boolean r10, boolean r11) {
        a(this.f19238a, r11);
        this.f19239b = r10;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean r10) {
        a(this.f19238a, r10);
        this.f19238a = true;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onTimer(boolean r10) {
        a(this.f19238a, r10);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void startSceneMonitor(String r10, boolean r11) {
        a(this.f19238a, r11);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void stopSceneMonitor(String r10, boolean r11) {
        a(this.f19238a, r11);
    }
}
