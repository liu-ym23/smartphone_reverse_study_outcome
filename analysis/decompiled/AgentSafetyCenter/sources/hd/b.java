package hd;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final od.l f5468d;

    /* renamed from: e, reason: collision with root package name */
    public static final od.l f5469e;

    /* renamed from: f, reason: collision with root package name */
    public static final od.l f5470f;

    /* renamed from: g, reason: collision with root package name */
    public static final od.l f5471g;

    /* renamed from: h, reason: collision with root package name */
    public static final od.l f5472h;
    public static final od.l i;

    /* renamed from: a, reason: collision with root package name */
    public final od.l f5473a;

    /* renamed from: b, reason: collision with root package name */
    public final od.l f5474b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5475c;

    static {
        od.l lVar = od.l.f9459h;
        f5468d = f8.b.l(":");
        f5469e = f8.b.l(":status");
        f5470f = f8.b.l(":method");
        f5471g = f8.b.l(":path");
        f5472h = f8.b.l(":scheme");
        i = f8.b.l(":authority");
    }

    public b(od.l lVar, od.l lVar2) {
        lVar.getClass();
        lVar2.getClass();
        this.f5473a = lVar;
        this.f5474b = lVar2;
        this.f5475c = lVar2.c() + lVar.c() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return yb.k.a(this.f5473a, bVar.f5473a) && yb.k.a(this.f5474b, bVar.f5474b);
    }

    public final int hashCode() {
        return this.f5474b.hashCode() + (this.f5473a.hashCode() * 31);
    }

    public final String toString() {
        return this.f5473a.p() + ": " + this.f5474b.p();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2) {
        this(f8.b.l(str), f8.b.l(str2));
        str.getClass();
        str2.getClass();
        od.l lVar = od.l.f9459h;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(od.l lVar, String str) {
        this(lVar, f8.b.l(str));
        lVar.getClass();
        str.getClass();
        od.l lVar2 = od.l.f9459h;
    }
}
