package hb;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final ob.k f4256d;

    /* renamed from: e, reason: collision with root package name */
    public static final ob.k f4257e;

    /* renamed from: f, reason: collision with root package name */
    public static final ob.k f4258f;

    /* renamed from: g, reason: collision with root package name */
    public static final ob.k f4259g;

    /* renamed from: h, reason: collision with root package name */
    public static final ob.k f4260h;

    /* renamed from: i, reason: collision with root package name */
    public static final ob.k f4261i;

    /* renamed from: a, reason: collision with root package name */
    public final ob.k f4262a;

    /* renamed from: b, reason: collision with root package name */
    public final ob.k f4263b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4264c;

    static {
        ob.k kVar = ob.k.f7997i;
        f4256d = h4.n.j(":");
        f4257e = h4.n.j(":status");
        f4258f = h4.n.j(":method");
        f4259g = h4.n.j(":path");
        f4260h = h4.n.j(":scheme");
        f4261i = h4.n.j(":authority");
    }

    public b(ob.k kVar, ob.k kVar2) {
        q7.k.e(kVar, "name");
        q7.k.e(kVar2, "value");
        this.f4262a = kVar;
        this.f4263b = kVar2;
        this.f4264c = kVar2.d() + kVar.d() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return q7.k.a(this.f4262a, bVar.f4262a) && q7.k.a(this.f4263b, bVar.f4263b);
    }

    public final int hashCode() {
        return this.f4263b.hashCode() + (this.f4262a.hashCode() * 31);
    }

    public final String toString() {
        return this.f4262a.r() + ": " + this.f4263b.r();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2) {
        this(h4.n.j(str), h4.n.j(str2));
        q7.k.e(str, "name");
        q7.k.e(str2, "value");
        ob.k kVar = ob.k.f7997i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(ob.k kVar, String str) {
        this(kVar, h4.n.j(str));
        q7.k.e(kVar, "name");
        q7.k.e(str, "value");
        ob.k kVar2 = ob.k.f7997i;
    }
}
