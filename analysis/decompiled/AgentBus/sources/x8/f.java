package x8;

import m.x;
import w7.e0;
import z8.b0;

/* loaded from: classes.dex */
public final class f implements t9.j {

    /* renamed from: f, reason: collision with root package name */
    public final m9.b f11258f;

    /* renamed from: g, reason: collision with root package name */
    public final m9.b f11259g;

    /* renamed from: h, reason: collision with root package name */
    public final k8.c f11260h;

    public f(k8.c cVar, b0 b0Var, d9.g gVar, int i2) {
        q7.k.e(cVar, "kotlinClass");
        q7.k.e(b0Var, "packageProto");
        q7.k.e(gVar, "nameResolver");
        x.t(i2, "abiStability");
        m9.b bVarB = m9.b.b(l8.d.a(cVar.f5652a));
        gb.h hVar = cVar.f5653b;
        m9.b bVarD = null;
        String str = ((y8.a) hVar.f4053c) != y8.a.MULTIFILE_CLASS_PART ? null : (String) hVar.f4058h;
        if (str != null && str.length() > 0) {
            bVarD = m9.b.d(str);
        }
        this.f11258f = bVarB;
        this.f11259g = bVarD;
        this.f11260h = cVar;
        f9.n nVar = c9.l.f2174m;
        q7.k.d(nVar, "packageModuleName");
        Integer num = (Integer) e0.A(b0Var, nVar);
        if (num != null) {
            gVar.getString(num.intValue());
        }
    }

    public final e9.b a() {
        e9.c cVar;
        m9.b bVar = this.f11258f;
        String str = bVar.f6454a;
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf == -1) {
            cVar = e9.c.f3187c;
            if (cVar == null) {
                m9.b.a(7);
                throw null;
            }
        } else {
            cVar = new e9.c(str.substring(0, iLastIndexOf).replace('/', '.'));
        }
        String strE = bVar.e();
        q7.k.d(strE, "className.internalName");
        return new e9.b(cVar, e9.f.e(ga.k.G0('/', strE, strE)));
    }

    @Override // t9.j
    public final String j() {
        return "Class '" + a().b().b() + '\'';
    }

    public final String toString() {
        return f.class.getSimpleName() + ": " + this.f11258f;
    }
}
