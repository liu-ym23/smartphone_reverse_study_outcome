package x;

import java.util.List;
import java.util.Map;
import s1.g0;
import u.f0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final n f15439a;

    /* renamed from: b, reason: collision with root package name */
    public int f15440b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15441c;

    /* renamed from: d, reason: collision with root package name */
    public float f15442d;

    /* renamed from: e, reason: collision with root package name */
    public final float f15443e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f15444f;

    /* renamed from: g, reason: collision with root package name */
    public final kc.t f15445g;

    /* renamed from: h, reason: collision with root package name */
    public final o2.c f15446h;
    public final long i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f15447j;

    /* renamed from: k, reason: collision with root package name */
    public final int f15448k;

    /* renamed from: l, reason: collision with root package name */
    public final int f15449l;

    /* renamed from: m, reason: collision with root package name */
    public final int f15450m;

    /* renamed from: n, reason: collision with root package name */
    public final f0 f15451n;

    /* renamed from: o, reason: collision with root package name */
    public final int f15452o;

    /* renamed from: p, reason: collision with root package name */
    public final int f15453p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ g0 f15454q;

    public m(n nVar, int i, boolean z10, float f5, g0 g0Var, float f10, boolean z11, kc.t tVar, o2.c cVar, long j10, List list, int i3, int i10, int i11, f0 f0Var, int i12, int i13) {
        this.f15439a = nVar;
        this.f15440b = i;
        this.f15441c = z10;
        this.f15442d = f5;
        this.f15443e = f10;
        this.f15444f = z11;
        this.f15445g = tVar;
        this.f15446h = cVar;
        this.i = j10;
        this.f15447j = list;
        this.f15448k = i3;
        this.f15449l = i10;
        this.f15450m = i11;
        this.f15451n = f0Var;
        this.f15452o = i12;
        this.f15453p = i13;
        this.f15454q = g0Var;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    public final boolean a(int i, boolean z10) {
        n nVar;
        if (!this.f15444f) {
            ?? r02 = this.f15447j;
            if (!r02.isEmpty() && (nVar = this.f15439a) != null) {
                int i3 = nVar.f15465l;
                int i10 = this.f15440b - i;
                if (i10 >= 0 && i10 < i3) {
                    n nVar2 = (n) kb.l.w0(r02);
                    n nVar3 = (n) kb.l.C0(r02);
                    nVar2.getClass();
                    nVar3.getClass();
                    int i11 = nVar2.f15463j;
                    int i12 = this.f15449l;
                    int i13 = this.f15448k;
                    if (i >= 0 ? Math.min(i13 - i11, i12 - nVar3.f15463j) > i : Math.min((i11 + nVar2.f15465l) - i13, (nVar3.f15463j + nVar3.f15465l) - i12) > (-i)) {
                        this.f15440b -= i;
                        int size = r02.size();
                        for (int i14 = 0; i14 < size; i14++) {
                            n nVar4 = (n) r02.get(i14);
                            int[] iArr = nVar4.f15468o;
                            nVar4.f15463j += i;
                            int length = iArr.length;
                            for (int i15 = 0; i15 < length; i15++) {
                                if (i15 % 2 == 1) {
                                    iArr[i15] = iArr[i15] + i;
                                }
                            }
                            if (z10) {
                                int size2 = nVar4.f15456b.size();
                                for (int i16 = 0; i16 < size2; i16++) {
                                    w2.c.d(nVar4.i.f915a.g(nVar4.f15461g));
                                }
                            }
                        }
                        this.f15442d = i;
                        if (!this.f15441c && i > 0) {
                            this.f15441c = true;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // s1.g0
    public final Map b() {
        return this.f15454q.b();
    }

    @Override // s1.g0
    public final void c() {
        this.f15454q.c();
    }

    @Override // s1.g0
    public final int d() {
        return this.f15454q.d();
    }

    @Override // s1.g0
    public final int e() {
        return this.f15454q.e();
    }

    @Override // s1.g0
    public final xb.l f() {
        return this.f15454q.f();
    }
}
