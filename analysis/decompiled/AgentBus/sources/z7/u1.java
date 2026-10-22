package z7;

import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public abstract class u1 {

    /* renamed from: a, reason: collision with root package name */
    public static final g9.g f11967a = g9.g.f3939c;

    public static void a(f8.c cVar, StringBuilder sb2) {
        i8.v vVarG = x1.g(cVar);
        i8.v vVarI = cVar.I();
        if (vVarG != null) {
            sb2.append(d(vVarG.getType()));
            sb2.append(".");
        }
        boolean z4 = (vVarG == null || vVarI == null) ? false : true;
        if (z4) {
            sb2.append("(");
        }
        if (vVarI != null) {
            sb2.append(d(vVarI.getType()));
            sb2.append(".");
        }
        if (z4) {
            sb2.append(")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String b(f8.t tVar) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fun ");
        a(tVar, sb2);
        e9.f name = ((i8.m) tVar).getName();
        q7.k.d(name, "descriptor.name");
        sb2.append(f11967a.P(name, true));
        List listX0 = tVar.x0();
        q7.k.d(listX0, "descriptor.valueParameters");
        d7.r.T0(listX0, sb2, ", ", "(", ")", b.f11844q, 48);
        sb2.append(": ");
        v9.v vVarF = tVar.f();
        q7.k.b(vVarF);
        sb2.append(d(vVarF));
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static String c(f8.l0 l0Var) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(l0Var.F() ? "var " : "val ");
        a(l0Var, sb2);
        e9.f name = l0Var.getName();
        q7.k.d(name, "descriptor.name");
        sb2.append(f11967a.P(name, true));
        sb2.append(": ");
        v9.v type = l0Var.getType();
        q7.k.d(type, "descriptor.type");
        sb2.append(d(type));
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static String d(v9.v vVar) {
        q7.k.e(vVar, "type");
        return f11967a.Z(vVar);
    }
}
