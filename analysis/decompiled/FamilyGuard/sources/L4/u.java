package L4;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static t f3981a;

    /* renamed from: b, reason: collision with root package name */
    public static long f3982b;

    /* renamed from: c, reason: collision with root package name */
    public static final u f3983c = new u();

    private u() {
    }

    public static final void a(t tVar) {
        j4.k.h(tVar, "segment");
        if (tVar.f3979f != null || tVar.f3980g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (tVar.f3977d) {
            return;
        }
        synchronized (f3983c) {
            long j5 = f3982b;
            long j6 = 8192;
            if (j5 + j6 > 65536) {
                return;
            }
            f3982b = j5 + j6;
            tVar.f3979f = f3981a;
            tVar.f3976c = 0;
            tVar.f3975b = 0;
            f3981a = tVar;
            V3.v vVar = V3.v.f5542a;
        }
    }

    public static final t b() {
        synchronized (f3983c) {
            t tVar = f3981a;
            if (tVar == null) {
                return new t();
            }
            f3981a = tVar.f3979f;
            tVar.f3979f = null;
            f3982b -= 8192;
            return tVar;
        }
    }
}
