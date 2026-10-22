package e1;

/* JADX INFO: loaded from: classes.dex */
public class j extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f19267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f19268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y1.f f19269g;

    public j() {
        super("traffic");
        this.f19267e = -1;
        this.f19268f = -1;
        this.f19269g = y1.f.e();
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
        i6.a.d(th, "BatteryTrafficStatsImpl");
        return;
    }

    public final void d(boolean r10) {
        long r11 = this.f19269g.c();
        long r12 = this.f19269g.a();
        if (this.f19268f > (-1)) goto L5;
    L8:
        this.f19267e = r11;
        this.f19268f = r12;
        return;
    L5:
        if (this.f19267e <= (-1)) goto L8;
        if (r10 == false) goto L8;
        String r13 = y0.a.E().D();
        c(true, r11 - this.f19267e, r13);
        c(false, r12 - this.f19268f, r13);
        goto L8
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(d1.b r10, p1.a r11) {
        if (r11.k() == false) goto L5;
        r10.p(r11.a());
        return;
    L5:
        r10.f(r11.a());
    }
}
