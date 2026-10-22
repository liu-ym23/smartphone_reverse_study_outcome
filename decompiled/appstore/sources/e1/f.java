package e1;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f19256e;

    public f() {
        super(BatteryTypeInf.BATTERY_CPU_ACTIVE);
        this.f19256e = 0;
    }

    @Override // e1.b
    public void a(boolean r10, boolean r11) {
        long r12 = com.bytedance.apm.util.b.a();
        long r13 = this.f19256e;
        if (r13 <= 0) goto L9;
        if (r11 == false) goto L9;
        long r14 = r12 - r13;
        if (r14 <= 0) goto L8;
        c(r10, r14, y0.a.E().D());
        goto L9
    L8:
        s1.a.d(Constants.TAG_BATTERY, "CPU Value:" + r14);
    L9:
        this.f19256e = r12;
    }

    public final long d() {
        return com.bytedance.apm.util.b.h(100);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(d1.b r10, p1.a r11) {
        if (r11.k() == false) goto L5;
        r10.l((long) ((r11.a() / d()) * 1000.0d));
        return;
    L5:
        r10.b((long) ((r11.a() / d()) * 1000.0d));
    }
}
