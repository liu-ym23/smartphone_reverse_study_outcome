package c0;

import d2.l0;
import d2.s;
import o2.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public String f2118a;

    /* renamed from: b, reason: collision with root package name */
    public l0 f2119b;

    /* renamed from: c, reason: collision with root package name */
    public g2.d f2120c;

    /* renamed from: d, reason: collision with root package name */
    public int f2121d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2122e;

    /* renamed from: f, reason: collision with root package name */
    public int f2123f;

    /* renamed from: g, reason: collision with root package name */
    public int f2124g;
    public o2.c i;

    /* renamed from: j, reason: collision with root package name */
    public d2.a f2126j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2127k;

    /* renamed from: m, reason: collision with root package name */
    public b f2129m;

    /* renamed from: n, reason: collision with root package name */
    public s f2130n;

    /* renamed from: o, reason: collision with root package name */
    public l f2131o;

    /* renamed from: h, reason: collision with root package name */
    public long f2125h = a.f2093a;

    /* renamed from: l, reason: collision with root package name */
    public long f2128l = ac.a.b(0, 0);

    /* renamed from: p, reason: collision with root package name */
    public long f2132p = o2.b.g(0, 0, 0, 0);

    public e(String str, l0 l0Var, g2.d dVar, int i, boolean z10, int i3, int i10) {
        this.f2118a = str;
        this.f2119b = l0Var;
        this.f2120c = dVar;
        this.f2121d = i;
        this.f2122e = z10;
        this.f2123f = i3;
        this.f2124g = i10;
    }

    public final void a() {
        this.f2126j = null;
        this.f2130n = null;
        this.f2131o = null;
        this.f2132p = o2.b.g(0, 0, 0, 0);
        this.f2128l = ac.a.b(0, 0);
        this.f2127k = false;
    }

    public final void b(o2.c cVar) {
        long jA;
        o2.c cVar2 = this.i;
        if (cVar != null) {
            int i = a.f2094b;
            jA = a.a(cVar.a(), cVar.T());
        } else {
            jA = a.f2093a;
        }
        if (cVar2 == null) {
            this.i = cVar;
            this.f2125h = jA;
        } else if (cVar == null || this.f2125h != jA) {
            this.i = cVar;
            this.f2125h = jA;
            a();
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ParagraphLayoutCache(paragraph=");
        sb2.append(this.f2126j != null ? "<paragraph>" : "null");
        sb2.append(", lastDensity=");
        long j10 = this.f2125h;
        int i = a.f2094b;
        sb2.append((Object) ("InlineDensity(density=" + Float.intBitsToFloat((int) (j10 >> 32)) + ", fontScale=" + Float.intBitsToFloat((int) (j10 & 4294967295L)) + ')'));
        sb2.append(')');
        return sb2.toString();
    }
}
