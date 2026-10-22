package x2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class n implements d {

    /* renamed from: a, reason: collision with root package name */
    public int f15558a;

    /* renamed from: b, reason: collision with root package name */
    public w2.e f15559b;

    /* renamed from: c, reason: collision with root package name */
    public k f15560c;

    /* renamed from: d, reason: collision with root package name */
    public int f15561d;

    /* renamed from: e, reason: collision with root package name */
    public final f f15562e = new f(this);

    /* renamed from: f, reason: collision with root package name */
    public int f15563f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15564g = false;

    /* renamed from: h, reason: collision with root package name */
    public final e f15565h = new e(this);
    public final e i = new e(this);

    /* renamed from: j, reason: collision with root package name */
    public int f15566j = 1;

    public n(w2.e eVar) {
        this.f15559b = eVar;
    }

    public static void b(e eVar, e eVar2, int i) {
        eVar.f15544l.add(eVar2);
        eVar.f15539f = i;
        eVar2.f15543k.add(eVar);
    }

    public static e h(w2.d dVar) {
        w2.d dVar2 = dVar.f15155f;
        if (dVar2 == null) {
            return null;
        }
        w2.e eVar = dVar2.f15153d;
        int iC = s.f.c(dVar2.f15154e);
        if (iC == 1) {
            return eVar.f15164d.f15565h;
        }
        if (iC == 2) {
            return eVar.f15166e.f15565h;
        }
        if (iC == 3) {
            return eVar.f15164d.i;
        }
        if (iC == 4) {
            return eVar.f15166e.i;
        }
        if (iC != 5) {
            return null;
        }
        return eVar.f15166e.f15550k;
    }

    public static e i(w2.d dVar, int i) {
        w2.d dVar2 = dVar.f15155f;
        if (dVar2 == null) {
            return null;
        }
        w2.e eVar = dVar2.f15153d;
        n nVar = i == 0 ? eVar.f15164d : eVar.f15166e;
        int iC = s.f.c(dVar2.f15154e);
        if (iC == 1 || iC == 2) {
            return nVar.f15565h;
        }
        if (iC == 3 || iC == 4) {
            return nVar.i;
        }
        return null;
    }

    public final void c(e eVar, e eVar2, int i, f fVar) {
        eVar.f15544l.add(eVar2);
        eVar.f15544l.add(this.f15562e);
        eVar.f15541h = i;
        eVar.i = fVar;
        eVar2.f15543k.add(eVar);
        fVar.f15543k.add(eVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i3) {
        w2.e eVar = this.f15559b;
        if (i3 == 0) {
            int i10 = eVar.f15191v;
            int iMax = Math.max(eVar.f15190u, i);
            if (i10 > 0) {
                iMax = Math.min(i10, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            int i11 = eVar.f15194y;
            int iMax2 = Math.max(eVar.f15193x, i);
            if (i11 > 0) {
                iMax2 = Math.min(i11, i);
            }
            if (iMax2 != i) {
                return iMax2;
            }
        }
        return i;
    }

    public long j() {
        if (this.f15562e.f15542j) {
            return r2.f15540g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(w2.d r12, w2.d r13, int r14) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.n.l(w2.d, w2.d, int):void");
    }
}
