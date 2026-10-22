package bs3;

import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes14.dex */
public final class j extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f20261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f20262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ws3.l f20263g;

    public j() {
        super("traffic");
        this.f20261e = -1;
        this.f20262f = -1;
        this.f20263g = ws3.l.a.f561030a;
    }

    public final void j(boolean r110) {
        long r100 = this.f20263g.f561029a.f();
        long r101 = this.f20263g.f561029a.c();
        if (this.f20262f > (-1)) goto L5;
    L8:
        this.f20261e = r100;
        this.f20262f = r101;
        return;
    L5:
        if (this.f20261e <= (-1)) goto L8;
        if (r110 == false) goto L8;
        String r111 = vr3.b.e.f556835a.f556824u;
        g(true, r100 - this.f20261e, r111);
        g(false, r101 - this.f20262f, r111);
        goto L8
    }

    @Override // bs3.l
    public final void a(as3.c r100, ms3.a r101) {
        if (r101.f515465b == false) goto L5;
        r100.f16105i += r101.f515470g;
        return;
    L5:
        r100.f16114r += r101.f515470g;
    }

    @Override // bs3.b
    public final void e(boolean r100, boolean r101) {
        if (this.f20237d == false) goto L14;
        j(r101);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L10;
        ps3.b.a(new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L10:
        EnsureManager.ensureNotReachHere(th, "BatteryTrafficStatsImpl");
        return;
    }
}
