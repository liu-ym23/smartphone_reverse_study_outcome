package u8;

import a.AbstractC0291a;
import h8.C1531n;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import i8.C1559e;
import i8.C1560f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k8.C1640i;
import k8.Q;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import q8.AbstractC1841n;
import t8.C2024a;
import t8.C2026c;
import t8.InterfaceC2028e;
import v8.C2065a;
import y8.C2140c;

/* loaded from: classes4.dex */
public final class k implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6727a = 1;
    public final K1.a b;
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a c;

    public k(K1.a aVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a aVar2) {
        this.b = aVar;
        this.c = aVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v14, types: [C7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22, types: [kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a] */
    /* JADX WARN: Type inference failed for: r1v27, types: [kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a] */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v8, types: [k8.i, k8.t, s8.b] */
    @Override // S7.a
    public final Object invoke() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a aVar;
        ?? arrayList;
        Object obj;
        ?? r1;
        Pair pair;
        List listD;
        switch (this.f6727a) {
            case 0:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a aVar2 = this.c;
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a aVar3 = aVar2.o;
                K1.a aVar4 = aVar2.b;
                InterfaceC1522e interfaceC1522e = aVar2.n;
                Collection<n8.k> collectionB = aVar3.b();
                ArrayList arrayList2 = new ArrayList(collectionB.size());
                for (n8.k kVar : collectionB) {
                    C2026c c2026cG = AbstractC0291a.G(aVar4, kVar);
                    C2024a c2024a = (C2024a) aVar4.f903a;
                    s8.b bVarI1 = s8.b.i1(interfaceC1522e, c2026cG, false, c2024a.f6671j.b(kVar));
                    K1.a aVar5 = new K1.a(c2024a, new D9.t(aVar4, bVarI1, kVar, interfaceC1522e.h().size()), (C7.f) aVar4.c);
                    Constructor constructor = kVar.f5360a;
                    Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                    kotlin.jvm.internal.k.c(genericParameterTypes);
                    if (genericParameterTypes.length == 0) {
                        listD = EmptyList.f4893a;
                    } else {
                        Class declaringClass = constructor.getDeclaringClass();
                        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
                            genericParameterTypes = (Type[]) D7.q.d0(genericParameterTypes, 1, genericParameterTypes.length);
                        }
                        Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                        if (parameterAnnotations.length < genericParameterTypes.length) {
                            throw new IllegalStateException("Illegal generic signature: " + constructor);
                        }
                        if (parameterAnnotations.length > genericParameterTypes.length) {
                            parameterAnnotations = (Annotation[][]) D7.q.d0(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
                        }
                        listD = kVar.d(genericParameterTypes, parameterAnnotations, constructor.isVarArgs());
                    }
                    C4.a aVarT = z.t(aVar5, bVarI1, listD);
                    List listH = interfaceC1522e.h();
                    kotlin.jvm.internal.k.e(listH, "getDeclaredTypeParameters(...)");
                    List list = listH;
                    ArrayList typeParameters = kVar.getTypeParameters();
                    ArrayList arrayList3 = new ArrayList(D7.w.c0(typeParameters, 10));
                    Iterator it = typeParameters.iterator();
                    while (it.hasNext()) {
                        InterfaceC1507O interfaceC1507OA = ((InterfaceC2028e) aVar5.b).a((n8.v) it.next());
                        kotlin.jvm.internal.k.c(interfaceC1507OA);
                        arrayList3.add(interfaceC1507OA);
                    }
                    bVarI1.g1((List) aVarT.c, U7.a.X(kVar.e()), D7.v.Q0(arrayList3, list));
                    bVarI1.Z0(false);
                    bVarI1.a1(aVarT.b);
                    bVarI1.b1(interfaceC1522e.g());
                    ((C2024a) aVar5.f903a).g.getClass();
                    arrayList2.add(bVarI1);
                }
                boolean zH = aVar3.h();
                Class cls = aVar3.f4985a;
                K1.a aVar6 = this.b;
                C1559e c1559e = C1560f.f4611a;
                if (zH) {
                    s8.b bVarI12 = s8.b.i1(interfaceC1522e, c1559e, true, ((C2024a) aVar4.f903a).f6671j.b(aVar3));
                    ArrayList arrayListG = aVar3.g();
                    ArrayList arrayList4 = new ArrayList(arrayListG.size());
                    C2065a c2065aO0 = M.a.o0(TypeUsage.b, false, null, 6);
                    Iterator it2 = arrayListG.iterator();
                    int i = 0;
                    while (it2.hasNext()) {
                        n8.t tVar = (n8.t) it2.next();
                        arrayList4.add(new Q(bVarI12, null, i, c1559e, tVar.c(), ((A5.c) aVar4.e).C(tVar.f(), c2065aO0), false, false, false, null, ((C2024a) aVar4.f903a).f6671j.b(tVar)));
                        i++;
                        aVar2 = aVar2;
                    }
                    aVar = aVar2;
                    bVarI12.a1(false);
                    C1531n PROTECTED_AND_PACKAGE = interfaceC1522e.getVisibility();
                    kotlin.jvm.internal.k.e(PROTECTED_AND_PACKAGE, "getVisibility(...)");
                    if (PROTECTED_AND_PACKAGE.equals(AbstractC1841n.b)) {
                        PROTECTED_AND_PACKAGE = AbstractC1841n.c;
                        kotlin.jvm.internal.k.e(PROTECTED_AND_PACKAGE, "PROTECTED_AND_PACKAGE");
                    }
                    bVarI12.f1(arrayList4, PROTECTED_AND_PACKAGE);
                    bVarI12.Z0(false);
                    bVarI12.b1(interfaceC1522e.g());
                    String strT = com.stepos.ability.task.executor.e.t(bVarI12, 2);
                    if (arrayList2.isEmpty()) {
                        arrayList2.add(bVarI12);
                        ((C2024a) aVar6.f903a).g.getClass();
                    } else {
                        Iterator it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            if (com.stepos.ability.task.executor.e.t((C1640i) it3.next(), 2).equals(strT)) {
                            }
                        }
                        arrayList2.add(bVarI12);
                        ((C2024a) aVar6.f903a).g.getClass();
                    }
                } else {
                    aVar = aVar2;
                }
                ((O8.a) ((C2024a) aVar6.f903a).f6678x).a(interfaceC1522e, arrayList2, aVar6);
                C2140c c2140c = ((C2024a) aVar6.f903a).f6673r;
                boolean zIsEmpty = arrayList2.isEmpty();
                Collection collectionO = arrayList2;
                if (zIsEmpty) {
                    boolean zIsAnnotation = cls.isAnnotation();
                    if (!cls.isInterface()) {
                        aVar3.getClass();
                    }
                    if (zIsAnnotation) {
                        C2024a c2024a2 = (C2024a) aVar4.f903a;
                        A5.c cVar = (A5.c) aVar4.e;
                        ?? I12 = s8.b.i1(interfaceC1522e, c1559e, true, c2024a2.f6671j.b(aVar3));
                        if (zIsAnnotation) {
                            Collection collectionE = aVar3.e();
                            arrayList = new ArrayList(collectionE.size());
                            C2065a c2065aO02 = M.a.o0(TypeUsage.b, true, null, 6);
                            ArrayList arrayList5 = new ArrayList();
                            ArrayList arrayList6 = new ArrayList();
                            for (Object obj2 : collectionE) {
                                if (kotlin.jvm.internal.k.b(((n8.q) obj2).c(), q8.u.b)) {
                                    arrayList5.add(obj2);
                                } else {
                                    arrayList6.add(obj2);
                                }
                            }
                            arrayList5.size();
                            n8.q qVar = (n8.q) D7.v.C0(arrayList5);
                            if (qVar != null) {
                                n8.u uVarF = qVar.f();
                                if (uVarF instanceof n8.h) {
                                    n8.h hVar = (n8.h) uVarF;
                                    pair = new Pair(cVar.B(hVar, c2065aO02, true), cVar.C(hVar.b, c2065aO02));
                                } else {
                                    pair = new Pair(cVar.C(uVarF, c2065aO02), null);
                                }
                                ?? r12 = aVar;
                                r12.u(arrayList, I12, 0, qVar, (X8.w) pair.f4886a, (X8.w) pair.b);
                                r1 = r12;
                            } else {
                                r1 = aVar;
                            }
                            int i6 = qVar != null ? 1 : 0;
                            Iterator it4 = arrayList6.iterator();
                            int i10 = 0;
                            while (it4.hasNext()) {
                                n8.q qVar2 = (n8.q) it4.next();
                                r1.u(arrayList, I12, i10 + i6, qVar2, cVar.C(qVar2.f(), c2065aO02), null);
                                i10++;
                            }
                        } else {
                            arrayList = Collections.EMPTY_LIST;
                        }
                        I12.a1(false);
                        C1531n PROTECTED_AND_PACKAGE2 = interfaceC1522e.getVisibility();
                        kotlin.jvm.internal.k.e(PROTECTED_AND_PACKAGE2, "getVisibility(...)");
                        if (PROTECTED_AND_PACKAGE2.equals(AbstractC1841n.b)) {
                            PROTECTED_AND_PACKAGE2 = AbstractC1841n.c;
                            kotlin.jvm.internal.k.e(PROTECTED_AND_PACKAGE2, "PROTECTED_AND_PACKAGE");
                        }
                        I12.f1(arrayList, PROTECTED_AND_PACKAGE2);
                        I12.Z0(true);
                        I12.b1(interfaceC1522e.g());
                        ((C2024a) aVar4.f903a).g.getClass();
                        obj = I12;
                    } else {
                        obj = null;
                    }
                    collectionO = H4.o.O(obj);
                }
                return D7.v.f1(c2140c.e(aVar6, collectionO));
            default:
                K1.a aVar7 = this.b;
                return D7.v.j1(((O8.a) ((C2024a) aVar7.f903a).f6678x).f(this.c.n, aVar7));
        }
    }

    public k(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a aVar, K1.a aVar2) {
        this.c = aVar;
        this.b = aVar2;
    }
}
