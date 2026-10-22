package b8;

import h8.InterfaceC1507O;
import h8.InterfaceC1520c;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.KParameter$Kind;
import s8.InterfaceC1920a;

/* renamed from: b8.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0855p implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2049a;
    public final AbstractC0857s b;

    public /* synthetic */ C0855p(AbstractC0857s abstractC0857s, int i) {
        this.f2049a = i;
        this.b = abstractC0857s;
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [C7.f, java.lang.Object] */
    @Override // S7.a
    public final Object invoke() {
        int i;
        int iH;
        Type[] lowerBounds;
        int i6 = this.f2049a;
        Type type = null;
        int i10 = 0;
        z = false;
        boolean z10 = false;
        int i11 = 1;
        AbstractC0857s abstractC0857s = this.b;
        switch (i6) {
            case 0:
                return v0.d(abstractC0857s.g());
            case 1:
                InterfaceC1520c interfaceC1520cG = abstractC0857s.g();
                ArrayList arrayList = new ArrayList();
                if (abstractC0857s.n()) {
                    i = 0;
                } else {
                    k8.u uVarG = v0.g(interfaceC1520cG);
                    if (uVarG != null) {
                        arrayList.add(new S(abstractC0857s, 0, KParameter$Kind.f4930a, new C0856q(uVarG, 0)));
                        i = 1;
                    } else {
                        i = 0;
                    }
                    k8.u uVarI = interfaceC1520cG.I();
                    if (uVarI != null) {
                        arrayList.add(new S(abstractC0857s, i, KParameter$Kind.b, new C0856q(uVarI, 1)));
                        i++;
                    }
                }
                int size = interfaceC1520cG.x().size();
                while (i10 < size) {
                    arrayList.add(new S(abstractC0857s, i, KParameter$Kind.c, new r(interfaceC1520cG, i10)));
                    i10++;
                    i++;
                }
                if (abstractC0857s.i() && (interfaceC1520cG instanceof InterfaceC1920a) && arrayList.size() > 1) {
                    D7.z.d0(new C0845f(i11), arrayList);
                }
                arrayList.trimToSize();
                return arrayList;
            case 2:
                X8.w returnType = abstractC0857s.g().getReturnType();
                kotlin.jvm.internal.k.c(returnType);
                return new l0(returnType, new C0855p(abstractC0857s, 6));
            case 3:
                List typeParameters = abstractC0857s.g().getTypeParameters();
                kotlin.jvm.internal.k.e(typeParameters, "getTypeParameters(...)");
                List<InterfaceC1507O> list = typeParameters;
                ArrayList arrayList2 = new ArrayList(D7.w.c0(list, 10));
                for (InterfaceC1507O interfaceC1507O : list) {
                    kotlin.jvm.internal.k.c(interfaceC1507O);
                    arrayList2.add(new m0(abstractC0857s, interfaceC1507O));
                }
                return arrayList2;
            case 4:
                List<Z7.n> parameters = abstractC0857s.getParameters();
                int size2 = (abstractC0857s.isSuspend() ? 1 : 0) + parameters.size();
                if (((Boolean) abstractC0857s.f.getF4884a()).booleanValue()) {
                    iH = 0;
                    for (Z7.n nVar : parameters) {
                        iH += ((S) nVar).c == KParameter$Kind.c ? abstractC0857s.h(nVar) : 0;
                    }
                } else {
                    List list2 = parameters;
                    if ((list2 instanceof Collection) && list2.isEmpty()) {
                        iH = 0;
                    } else {
                        Iterator it = list2.iterator();
                        iH = 0;
                        while (it.hasNext()) {
                            if (((S) ((Z7.n) it.next())).c == KParameter$Kind.c && (iH = iH + 1) < 0) {
                                H4.o.W();
                                throw null;
                            }
                        }
                    }
                }
                int i12 = (iH + 31) / 32;
                Object[] objArr = new Object[size2 + i12 + 1];
                Iterator it2 = parameters.iterator();
                while (it2.hasNext()) {
                    S s5 = (S) ((Z7.n) it2.next());
                    boolean zE = s5.e();
                    int i13 = s5.b;
                    if (zE) {
                        l0 l0VarD = s5.d();
                        G8.c cVar = v0.f2060a;
                        X8.w wVar = l0VarD.f2046a;
                        if (wVar == null || !J8.g.c(wVar)) {
                            l0 l0VarD2 = s5.d();
                            p0 p0Var = l0VarD2.b;
                            Type typeB = p0Var != null ? (Type) p0Var.invoke() : null;
                            if (typeB == null) {
                                typeB = p0Var != null ? (Type) p0Var.invoke() : null;
                                if (typeB == null) {
                                    typeB = kotlin.reflect.b.b(l0VarD2, false);
                                }
                            }
                            objArr[i13] = v0.e(typeB);
                        }
                    }
                    if (s5.f()) {
                        objArr[i13] = AbstractC0857s.b(s5.d());
                    }
                }
                for (int i14 = 0; i14 < i12; i14++) {
                    objArr[size2 + i14] = 0;
                }
                return objArr;
            case 5:
                List parameters2 = abstractC0857s.getParameters();
                if (!(parameters2 instanceof Collection) || !parameters2.isEmpty()) {
                    Iterator it3 = parameters2.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (v0.h(((S) ((Z7.n) it3.next())).d())) {
                                z10 = true;
                            }
                        }
                    }
                }
                return Boolean.valueOf(z10);
            default:
                if (abstractC0857s.isSuspend()) {
                    Object objL0 = D7.v.L0(abstractC0857s.d().a());
                    ParameterizedType parameterizedType = objL0 instanceof ParameterizedType ? (ParameterizedType) objL0 : null;
                    if (kotlin.jvm.internal.k.b(parameterizedType != null ? parameterizedType.getRawType() : null, H7.c.class)) {
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        kotlin.jvm.internal.k.e(actualTypeArguments, "getActualTypeArguments(...)");
                        Object objA0 = D7.q.A0(actualTypeArguments);
                        WildcardType wildcardType = objA0 instanceof WildcardType ? (WildcardType) objA0 : null;
                        if (wildcardType != null && (lowerBounds = wildcardType.getLowerBounds()) != null) {
                            type = (Type) D7.q.k0(lowerBounds);
                        }
                    }
                }
                return type == null ? abstractC0857s.d().getReturnType() : type;
        }
    }
}
