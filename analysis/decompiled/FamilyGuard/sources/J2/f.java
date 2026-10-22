package J2;

import j4.k;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final c f3221a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3222b;

    /* renamed from: c, reason: collision with root package name */
    private final Throwable f3223c;

    public f(c cVar, String str, Throwable th) {
        k.g(cVar, "level");
        k.g(str, "message");
        this.f3221a = cVar;
        this.f3222b = str;
        this.f3223c = th;
    }

    public final Throwable a() {
        return this.f3223c;
    }

    public final c b() {
        return this.f3221a;
    }

    public final String c() {
        return this.f3222b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f3221a == fVar.f3221a && k.b(this.f3222b, fVar.f3222b) && k.b(this.f3223c, fVar.f3223c);
    }

    public int hashCode() {
        int iHashCode = ((this.f3221a.hashCode() * 31) + this.f3222b.hashCode()) * 31;
        Throwable th = this.f3223c;
        return iHashCode + (th == null ? 0 : th.hashCode());
    }

    public String toString() {
        return "MotionKitError(level=" + this.f3221a + ", message=" + this.f3222b + ", cause=" + this.f3223c + ")";
    }
}
