package z7;

import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public final class u0 implements w7.m {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f11961k;

    /* renamed from: f, reason: collision with root package name */
    public final s f11962f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11963g;

    /* renamed from: h, reason: collision with root package name */
    public final w7.l f11964h;

    /* renamed from: i, reason: collision with root package name */
    public final q1 f11965i;

    /* renamed from: j, reason: collision with root package name */
    public final q1 f11966j = s1.l(null, new t0(this, 0));

    static {
        q7.x xVar = q7.w.f8821a;
        f11961k = new w7.t[]{xVar.f(new q7.p(xVar.b(u0.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), xVar.f(new q7.p(xVar.b(u0.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public u0(s sVar, int i2, w7.l lVar, p7.a aVar) {
        this.f11962f = sVar;
        this.f11963g = i2;
        this.f11964h = lVar;
        this.f11965i = s1.l(null, aVar);
    }

    public final f8.j0 a() {
        w7.t tVar = f11961k[0];
        Object objC = this.f11965i.c();
        q7.k.d(objC, "<get-descriptor>(...)");
        return (f8.j0) objC;
    }

    public final m1 c() {
        v9.v type = a().getType();
        q7.k.d(type, "descriptor.type");
        return new m1(type, new t0(this, 1));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return q7.k.a(this.f11962f, u0Var.f11962f) && this.f11963g == u0Var.f11963g;
    }

    public final String getName() {
        f8.j0 j0VarA = a();
        i8.r0 r0Var = j0VarA instanceof i8.r0 ? (i8.r0) j0VarA : null;
        if (r0Var != null && !r0Var.p().O()) {
            e9.f name = r0Var.getName();
            q7.k.d(name, "valueParameter.name");
            if (!name.f3198g) {
                return name.b();
            }
        }
        return null;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11963g) + (this.f11962f.hashCode() * 31);
    }

    public final boolean j() {
        f8.j0 j0VarA = a();
        i8.r0 r0Var = j0VarA instanceof i8.r0 ? (i8.r0) j0VarA : null;
        if (r0Var != null) {
            return l9.d.a(r0Var);
        }
        return false;
    }

    public final String toString() throws IOException {
        String strB;
        g9.g gVar = u1.f11967a;
        StringBuilder sb2 = new StringBuilder();
        int iOrdinal = this.f11964h.ordinal();
        if (iOrdinal == 0) {
            sb2.append("instance parameter");
        } else if (iOrdinal == 1) {
            sb2.append("extension receiver parameter");
        } else if (iOrdinal == 2) {
            sb2.append("parameter #" + this.f11963g + ' ' + getName());
        }
        sb2.append(" of ");
        f8.c cVarB = this.f11962f.B();
        if (cVarB instanceof f8.l0) {
            strB = u1.c((f8.l0) cVarB);
        } else {
            if (!(cVarB instanceof f8.t)) {
                throw new IllegalStateException(("Illegal callable: " + cVarB).toString());
            }
            strB = u1.b((f8.t) cVarB);
        }
        sb2.append(strB);
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final boolean u() {
        f8.j0 j0VarA = a();
        return (j0VarA instanceof i8.r0) && ((i8.r0) j0VarA).f4849o != null;
    }

    @Override // w7.b
    public final List w() {
        w7.t tVar = f11961k[1];
        Object objC = this.f11966j.c();
        q7.k.d(objC, "<get-annotations>(...)");
        return (List) objC;
    }
}
