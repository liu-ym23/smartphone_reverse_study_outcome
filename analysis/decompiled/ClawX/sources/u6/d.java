package u6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {
    public static final c7.i d;

    /* renamed from: e, reason: collision with root package name */
    public static final c7.i f5679e;

    /* renamed from: f, reason: collision with root package name */
    public static final c7.i f5680f;

    /* renamed from: g, reason: collision with root package name */
    public static final c7.i f5681g;

    /* renamed from: h, reason: collision with root package name */
    public static final c7.i f5682h;

    /* renamed from: i, reason: collision with root package name */
    public static final c7.i f5683i;

    /* renamed from: a, reason: collision with root package name */
    public final c7.i f5684a;

    /* renamed from: b, reason: collision with root package name */
    public final c7.i f5685b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5686c;

    static {
        c7.i iVar = c7.i.d;
        d = t1.f.f(":");
        f5679e = t1.f.f(":status");
        f5680f = t1.f.f(":method");
        f5681g = t1.f.f(":path");
        f5682h = t1.f.f(":scheme");
        f5683i = t1.f.f(":authority");
    }

    public d(c7.i name, c7.i value) {
        kotlin.jvm.internal.p.e(name, "name");
        kotlin.jvm.internal.p.e(value, "value");
        this.f5684a = name;
        this.f5685b = value;
        this.f5686c = value.c() + name.c() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return kotlin.jvm.internal.p.a(this.f5684a, dVar.f5684a) && kotlin.jvm.internal.p.a(this.f5685b, dVar.f5685b);
    }

    public final int hashCode() {
        return this.f5685b.hashCode() + (this.f5684a.hashCode() * 31);
    }

    public final String toString() {
        return this.f5684a.l() + ": " + this.f5685b.l();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(String str, String str2) {
        this(t1.f.f(str), t1.f.f(str2));
        c7.i iVar = c7.i.d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(c7.i name, String value) {
        this(name, t1.f.f(value));
        kotlin.jvm.internal.p.e(name, "name");
        kotlin.jvm.internal.p.e(value, "value");
        c7.i iVar = c7.i.d;
    }
}
