package ms.bd.c;

/* JADX INFO: loaded from: classes4.dex */
public final class b2 extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f39462a;

    public b2() {
    }

    static /* synthetic */ long a(b2 r2) {
        return r2.f39462a;
    }

    @Override // ms.bd.c.t0
    public final Boolean a(long r1) {
        this.f39462a = r1;
        a2 r2 = new a2(this);
        monitor-enter(this);
        com.bytedance.frameworks.baselib.network.http.g.a(r2);     // Catch: Throwable -> L8
        monitor-exit(this);
        return Boolean.TRUE;
    L8:
        th = move-exception;
        throw th;
    }

    public final void finalize() {
        com.bytedance.mobsec.matrix.a.a(50331650, 0, this.f39462a, null, null);
        com.bytedance.mobsec.matrix.a.a(100663298, 0, this.f39462a, null, null);
        this.f39462a = -1;
        super.finalize();
    }
}
