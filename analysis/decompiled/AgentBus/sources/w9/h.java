package w9;

import f8.x;
import v9.l0;
import v9.m0;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final x f10934a = new x("KotlinTypeRefiner", 0);

    public static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
            case 4:
                objArr[0] = "b";
                break;
            case 2:
            case 7:
                objArr[0] = "typeCheckingProcedure";
                break;
            case 3:
            default:
                objArr[0] = "a";
                break;
            case 5:
            case 10:
                objArr[0] = "subtype";
                break;
            case 6:
            case 11:
                objArr[0] = "supertype";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 9:
                objArr[0] = "typeProjection";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch (i2) {
            case 3:
            case 4:
                objArr[2] = "assertEqualTypeConstructors";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "assertSubtype";
                break;
            case 8:
            case 9:
                objArr[2] = "capture";
                break;
            case 10:
            case 11:
                objArr[2] = "noCorrespondingSupertype";
                break;
            default:
                objArr[2] = "assertEqualTypes";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static l0 b(boolean z4, boolean z10, c cVar, f fVar, int i2) {
        if ((i2 & 2) != 0) {
            z10 = true;
        }
        boolean z11 = z10;
        if ((i2 & 4) != 0) {
            cVar = f.f10932g;
        }
        c cVar2 = cVar;
        if ((i2 & 8) != 0) {
            fVar = f.f10931f;
        }
        q7.k.e(cVar2, "typeSystemContext");
        return new l0(z4, z11, cVar2, fVar, g.f10933a);
    }

    public static final String c(m0 m0Var) {
        StringBuilder sb2 = new StringBuilder();
        d(sb2, "type: " + m0Var);
        d(sb2, "hashCode: " + m0Var.hashCode());
        d(sb2, "javaClass: " + m0Var.getClass().getCanonicalName());
        for (f8.j jVarC = m0Var.c(); jVarC != null; jVarC = jVarC.p()) {
            d(sb2, "fqName: ".concat(g9.g.f3939c.x(jVarC)));
            d(sb2, "javaClass: " + jVarC.getClass().getCanonicalName());
        }
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final void d(StringBuilder sb2, String str) {
        q7.k.e(str, "<this>");
        sb2.append(str);
        sb2.append('\n');
    }
}
