package v;

import d2.l;
import ib.k;
import s1.h0;
import s1.o;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public String f10233a;

    /* renamed from: b, reason: collision with root package name */
    public h0 f10234b;

    /* renamed from: c, reason: collision with root package name */
    public v1.d f10235c;

    /* renamed from: d, reason: collision with root package name */
    public int f10236d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10237e;

    /* renamed from: f, reason: collision with root package name */
    public int f10238f;

    /* renamed from: g, reason: collision with root package name */
    public int f10239g;

    /* renamed from: i, reason: collision with root package name */
    public d2.c f10241i;

    /* renamed from: j, reason: collision with root package name */
    public s1.a f10242j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10243k;

    /* renamed from: m, reason: collision with root package name */
    public b f10245m;

    /* renamed from: n, reason: collision with root package name */
    public o f10246n;

    /* renamed from: o, reason: collision with root package name */
    public l f10247o;

    /* renamed from: h, reason: collision with root package name */
    public long f10240h = a.f10221a;

    /* renamed from: l, reason: collision with root package name */
    public long f10244l = k.a(0, 0);

    /* renamed from: p, reason: collision with root package name */
    public long f10248p = d2.b.g(0, 0, 0, 0);

    public d(String str, h0 h0Var, v1.d dVar, int i2, boolean z4, int i10, int i11) {
        this.f10233a = str;
        this.f10234b = h0Var;
        this.f10235c = dVar;
        this.f10236d = i2;
        this.f10237e = z4;
        this.f10238f = i10;
        this.f10239g = i11;
    }

    public final void a() {
        this.f10242j = null;
        this.f10246n = null;
        this.f10247o = null;
        this.f10248p = d2.b.g(0, 0, 0, 0);
        this.f10244l = k.a(0, 0);
        this.f10243k = false;
    }

    public final void b(d2.c cVar) {
        long jA;
        d2.c cVar2 = this.f10241i;
        if (cVar != null) {
            int i2 = a.f10222b;
            jA = a.a(cVar.c(), cVar.j());
        } else {
            jA = a.f10221a;
        }
        if (cVar2 == null) {
            this.f10241i = cVar;
            this.f10240h = jA;
        } else if (cVar == null || this.f10240h != jA) {
            this.f10241i = cVar;
            this.f10240h = jA;
            a();
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ParagraphLayoutCache(paragraph=");
        sb2.append(this.f10242j != null ? "<paragraph>" : "null");
        sb2.append(", lastDensity=");
        long j2 = this.f10240h;
        int i2 = a.f10222b;
        sb2.append((Object) ("InlineDensity(density=" + Float.intBitsToFloat((int) (j2 >> 32)) + ", fontScale=" + Float.intBitsToFloat((int) (j2 & 4294967295L)) + ')'));
        sb2.append(')');
        return sb2.toString();
    }
}
