package p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class o implements d {

    /* renamed from: a, reason: collision with root package name */
    public int f4633a;

    /* renamed from: b, reason: collision with root package name */
    public o.d f4634b;

    /* renamed from: c, reason: collision with root package name */
    public l f4635c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public final g f4636e = new g(this);

    /* renamed from: f, reason: collision with root package name */
    public int f4637f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4638g = false;

    /* renamed from: h, reason: collision with root package name */
    public final f f4639h = new f(this);

    /* renamed from: i, reason: collision with root package name */
    public final f f4640i = new f(this);

    /* renamed from: j, reason: collision with root package name */
    public int f4641j = 1;

    public o(o.d dVar) {
        this.f4634b = dVar;
    }

    public static void b(f fVar, f fVar2, int i8) {
        fVar.f4620l.add(fVar2);
        fVar.f4614f = i8;
        fVar2.f4619k.add(fVar);
    }

    public static f h(o.c cVar) {
        o.c cVar2 = cVar.f4208f;
        if (cVar2 == null) {
            return null;
        }
        o.d dVar = cVar2.d;
        int iA = m.f.a(cVar2.f4207e);
        if (iA == 1) {
            return dVar.d.f4639h;
        }
        if (iA == 2) {
            return dVar.f4219e.f4639h;
        }
        if (iA == 3) {
            return dVar.d.f4640i;
        }
        if (iA == 4) {
            return dVar.f4219e.f4640i;
        }
        if (iA != 5) {
            return null;
        }
        return dVar.f4219e.f4626k;
    }

    public static f i(o.c cVar, int i8) {
        o.c cVar2 = cVar.f4208f;
        if (cVar2 == null) {
            return null;
        }
        o.d dVar = cVar2.d;
        o oVar = i8 == 0 ? dVar.d : dVar.f4219e;
        int iA = m.f.a(cVar2.f4207e);
        if (iA == 1 || iA == 2) {
            return oVar.f4639h;
        }
        if (iA == 3 || iA == 4) {
            return oVar.f4640i;
        }
        return null;
    }

    public final void c(f fVar, f fVar2, int i8, g gVar) {
        fVar.f4620l.add(fVar2);
        fVar.f4620l.add(this.f4636e);
        fVar.f4616h = i8;
        fVar.f4617i = gVar;
        fVar2.f4619k.add(fVar);
        gVar.f4619k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i8, int i9) {
        if (i9 == 0) {
            o.d dVar = this.f4634b;
            int i10 = dVar.f4245u;
            int iMax = Math.max(dVar.f4244t, i8);
            if (i10 > 0) {
                iMax = Math.min(i10, i8);
            }
            if (iMax != i8) {
                return iMax;
            }
        } else {
            o.d dVar2 = this.f4634b;
            int i11 = dVar2.f4248x;
            int iMax2 = Math.max(dVar2.f4247w, i8);
            if (i11 > 0) {
                iMax2 = Math.min(i11, i8);
            }
            if (iMax2 != i8) {
                return iMax2;
            }
        }
        return i8;
    }

    public long j() {
        if (this.f4636e.f4618j) {
            return r2.f4615g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(o.c r12, o.c r13, int r14) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.o.l(o.c, o.c, int):void");
    }
}
