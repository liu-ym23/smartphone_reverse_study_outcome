package c6;

import c7.r;
import i8.a0;
import i8.x;
import v9.z;

/* loaded from: classes.dex */
public final class i implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1948f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1949g;

    public /* synthetic */ i(int i2, Object obj) {
        this.f1948f = i2;
        this.f1949g = obj;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        long j2;
        switch (this.f1948f) {
            case 0:
                eb.i iVar = ((nb.g) this.f1949g).f6956g;
                q7.k.b(iVar);
                iVar.e();
                return r.f1986a;
            case 1:
                e9.f fVar = (e9.f) obj;
                a0 a0VarK = ((c8.h) this.f1949g).k();
                e9.c cVar = c8.n.f2066k;
                o9.j jVar = ((x) a0VarK.z(cVar)).f4900l;
                if (jVar == null) {
                    c8.h.a(11);
                    throw null;
                }
                f8.g gVarB = jVar.b(fVar, n8.c.f6877f);
                if (gVarB == null) {
                    throw new AssertionError("Built-in class " + cVar.c(fVar) + " is not found");
                }
                if (gVarB instanceof f8.e) {
                    return (f8.e) gVarB;
                }
                throw new AssertionError("Must be a class descriptor " + fVar + ", but was " + gVarB);
            case 2:
                i8.a aVar = (i8.a) this.f1949g;
                ((w9.g) obj).getClass();
                return (z) aVar.f4737g.f4748g.c();
            case 3:
                ia.m mVar = (ia.m) this.f1949g;
                r rVar = r.f1986a;
                mVar.resumeWith(rVar);
                return rVar;
            case 4:
                l0.k kVar = (l0.k) obj;
                synchronized (l0.m.f5774c) {
                    j2 = l0.m.f5776e;
                    l0.m.f5776e = 1 + j2;
                }
                return new l0.e(j2, kVar, (p7.k) this.f1949g);
            default:
                f8.c cVar2 = (f8.c) obj;
                if (cVar2 == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'descriptor' of kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1.invoke must not be null");
                }
                ((p8.a) this.f1949g).f8500b.a(cVar2);
                return r.f1986a;
        }
    }
}
