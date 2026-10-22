package ba;

import f8.q0;
import i8.r0;
import java.util.List;
import v9.e0;
import v9.i0;
import v9.x0;

/* loaded from: classes.dex */
public final class m implements f {

    /* renamed from: b, reason: collision with root package name */
    public static final m f1614b = new m(0);

    /* renamed from: c, reason: collision with root package name */
    public static final m f1615c = new m(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1616a;

    public /* synthetic */ m(int i2) {
        this.f1616a = i2;
    }

    @Override // ba.f
    public final String a(q8.e eVar) {
        switch (this.f1616a) {
        }
        return e.invoke(this, eVar);
    }

    @Override // ba.f
    public final boolean b(f8.t tVar) {
        v9.z zVarQ;
        switch (this.f1616a) {
            case 0:
                r0 r0Var = (r0) tVar.x0().get(1);
                s9.d dVar = c8.l.f2022d;
                q7.k.d(r0Var, "secondParameter");
                f8.z zVarJ = l9.d.j(r0Var);
                dVar.getClass();
                f8.e eVarD = f8.v.d(zVarJ, c8.m.Q);
                if (eVarD == null) {
                    zVarQ = null;
                } else {
                    i0.f10557g.getClass();
                    i0 i0Var = i0.f10558h;
                    List parameters = eVarD.h().getParameters();
                    q7.k.d(parameters, "kPropertyClass.typeConstructor.parameters");
                    Object objF1 = d7.r.f1(parameters);
                    q7.k.d(objF1, "kPropertyClass.typeConstructor.parameters.single()");
                    zVarQ = v9.d.q(i0Var, eVarD, a.a.S(new e0((q0) objF1)));
                }
                if (zVarQ == null) {
                    return false;
                }
                v9.v type = r0Var.getType();
                q7.k.d(type, "secondParameter.type");
                return w9.e.f10930a.b(zVarQ, x0.g(type, false));
            default:
                List<r0> listX0 = tVar.x0();
                q7.k.d(listX0, "functionDescriptor.valueParameters");
                if (!listX0.isEmpty()) {
                    for (r0 r0Var2 : listX0) {
                        q7.k.d(r0Var2, "it");
                        if (l9.d.a(r0Var2) || r0Var2.f4849o != null) {
                            return false;
                        }
                    }
                }
                return true;
        }
    }

    @Override // ba.f
    public final String getDescription() {
        switch (this.f1616a) {
            case 0:
                return "second parameter must be of type KProperty<*> or its supertype";
            default:
                return "should not have varargs or parameters with default values";
        }
    }
}
