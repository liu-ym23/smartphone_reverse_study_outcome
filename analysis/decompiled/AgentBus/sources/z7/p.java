package z7;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class p extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11929g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s f11930h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(s sVar, int i2) {
        super(0);
        this.f11929g = i2;
        this.f11930h = sVar;
    }

    @Override // p7.a
    public final Object c() {
        int i2;
        Type[] lowerBounds;
        int i10 = this.f11929g;
        int i11 = 0;
        s sVar = this.f11930h;
        switch (i10) {
            case 0:
                int size = (sVar.o() ? 1 : 0) + sVar.getParameters().size();
                int size2 = (sVar.getParameters().size() + 31) / 32;
                Object[] objArr = new Object[size + size2 + 1];
                Iterator it = sVar.getParameters().iterator();
                while (it.hasNext()) {
                    u0 u0Var = (u0) ((w7.m) it.next());
                    boolean zJ = u0Var.j();
                    int i12 = u0Var.f11963g;
                    if (zJ) {
                        m1 m1VarC = u0Var.c();
                        e9.c cVar = x1.f11989a;
                        v9.v vVar = m1VarC.f11908f;
                        if (vVar == null || !h9.h.c(vVar)) {
                            objArr[i12] = x1.e(n7.m.v(u0Var.c()));
                        }
                    }
                    if (u0Var.u()) {
                        objArr[i12] = s.x(u0Var.c());
                    }
                }
                for (int i13 = 0; i13 < size2; i13++) {
                    objArr[size + i13] = 0;
                }
                return objArr;
            case 1:
                return x1.d(sVar.B());
            case 2:
                f8.c cVarB = sVar.B();
                ArrayList arrayList = new ArrayList();
                if (sVar.D()) {
                    i2 = 0;
                } else {
                    i8.v vVarG = x1.g(cVarB);
                    if (vVarG != null) {
                        arrayList.add(new u0(sVar, 0, w7.l.f10870f, new q(vVarG, 0)));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    i8.v vVarI = cVarB.I();
                    if (vVarI != null) {
                        arrayList.add(new u0(sVar, i2, w7.l.f10871g, new q(vVarI, 1)));
                        i2++;
                    }
                }
                int size3 = cVarB.x0().size();
                while (i11 < size3) {
                    arrayList.add(new u0(sVar, i2, w7.l.f10872h, new r(cVarB, i11)));
                    i11++;
                    i2++;
                }
                if (sVar.C() && (cVarB instanceof q8.a) && arrayList.size() > 1) {
                    d7.w.C0(arrayList, new m4.i0(5));
                }
                arrayList.trimToSize();
                return arrayList;
            case 3:
                Type type = null;
                if (sVar.o()) {
                    Object objX0 = d7.r.X0(sVar.y().i());
                    ParameterizedType parameterizedType = objX0 instanceof ParameterizedType ? (ParameterizedType) objX0 : null;
                    if (q7.k.a(parameterizedType != null ? parameterizedType.getRawType() : null, g7.d.class)) {
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        q7.k.d(actualTypeArguments, "continuationType.actualTypeArguments");
                        Object objR0 = d7.n.r0(actualTypeArguments);
                        WildcardType wildcardType = objR0 instanceof WildcardType ? (WildcardType) objR0 : null;
                        if (wildcardType != null && (lowerBounds = wildcardType.getLowerBounds()) != null) {
                            type = (Type) d7.n.g0(lowerBounds);
                        }
                    }
                }
                return type == null ? sVar.y().f() : type;
            case 4:
                v9.v vVarF = sVar.B().f();
                q7.k.b(vVarF);
                return new m1(vVarF, new p(sVar, 3));
            default:
                List<f8.q0> typeParameters = sVar.B().getTypeParameters();
                q7.k.d(typeParameters, "descriptor.typeParameters");
                ArrayList arrayList2 = new ArrayList(d7.t.A0(typeParameters, 10));
                for (f8.q0 q0Var : typeParameters) {
                    q7.k.d(q0Var, "descriptor");
                    arrayList2.add(new n1(sVar, q0Var));
                }
                return arrayList2;
        }
    }
}
