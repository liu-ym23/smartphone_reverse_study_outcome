package e1;

import com.bytedance.apm.battery.config.BatteryTypeInf;

/* JADX INFO: loaded from: classes.dex */
public class h extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f19258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f19259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y1.f f19260g;

    public h() {
        super(BatteryTypeInf.BATTERY_PACKETS);
        this.f19258e = -1;
        this.f19259f = -1;
        this.f19260g = y1.f.e();
    }

    @Override // e1.b
    public void a(boolean r10, boolean r11) {
        if (b() == false) goto L14;
        d(r11);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (w0.c.B() == false) goto L10;
        s1.c.d(s1.b.f24484b, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L10:
        i6.a.d(th, "BatteryPacketsStatsImpl");
        return;
    }

    public final void d(boolean r10) {
        long r11 = this.f19260g.d();
        long r12 = this.f19260g.b();
        if (this.f19259f > (-1)) goto L5;
    L8:
        this.f19258e = r11;
        this.f19259f = r12;
        return;
    L5:
        if (this.f19258e <= (-1)) goto L8;
        if (r10 == false) goto L8;
        String r13 = y0.a.E().D();
        c(true, r11 - this.f19258e, r13);
        c(false, r12 - this.f19259f, r13);
        goto L8
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(d1.b r10, p1.a r11) {
        if (r11.k() == false) goto L5;
        r10.q(r11.a());
        return;
    L5:
        r10.g(r11.a());
    }
}
