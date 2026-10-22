package s8;

import f8.q0;
import i8.r0;
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

/* loaded from: classes.dex */
public final class n extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9583g = 1;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a3.b f9584h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ p f9585i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(a3.b bVar, p pVar) {
        super(0);
        this.f9584h = bVar;
        this.f9585i = pVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [c7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [s8.p] */
    /* JADX WARN: Type inference failed for: r1v28, types: [s8.p] */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v12, types: [i8.i, i8.u, q8.b] */
    @Override // p7.a
    public final Object c() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        p pVar;
        ?? arrayList;
        Object obj;
        ?? r12;
        c7.j jVar;
        List listD;
        switch (this.f9583g) {
            case 0:
                p pVar2 = this.f9585i;
                l8.o oVar = pVar2.f9589o;
                a3.b bVar = pVar2.f9518b;
                f8.e eVar = pVar2.f9588n;
                Constructor<?>[] declaredConstructors = oVar.f5878a.getDeclaredConstructors();
                q7.k.d(declaredConstructors, "klass.declaredConstructors");
                boolean z4 = false;
                List<l8.r> listV0 = fa.l.v0(fa.l.t0(new fa.f(d7.n.T(declaredConstructors), false, l8.j.f5873n), l8.k.f5874n));
                ArrayList arrayList2 = new ArrayList(listV0.size());
                for (l8.r rVar : listV0) {
                    r8.d dVarX = n7.o.x(bVar, rVar);
                    r8.a aVar = (r8.a) bVar.f162f;
                    q8.b bVarX0 = q8.b.X0(eVar, dVarX, z4, aVar.f9011j.c(rVar));
                    a3.b bVar2 = new a3.b(aVar, new g3.e(bVar, bVarX0, rVar, eVar.s().size()), bVar.f164h);
                    Constructor constructor = rVar.f5882a;
                    Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                    q7.k.d(genericParameterTypes, "types");
                    if (genericParameterTypes.length == 0) {
                        listD = d7.z.f2978f;
                    } else {
                        Class declaringClass = constructor.getDeclaringClass();
                        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
                            genericParameterTypes = (Type[]) d7.n.c0(genericParameterTypes, 1, genericParameterTypes.length);
                        }
                        Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                        if (parameterAnnotations.length < genericParameterTypes.length) {
                            throw new IllegalStateException("Illegal generic signature: " + constructor);
                        }
                        if (parameterAnnotations.length > genericParameterTypes.length) {
                            parameterAnnotations = (Annotation[][]) d7.n.c0(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
                        }
                        listD = rVar.d(genericParameterTypes, parameterAnnotations, constructor.isVarArgs());
                    }
                    a7.c cVarU = a0.u(bVar2, bVarX0, listD);
                    List listS = eVar.s();
                    q7.k.d(listS, "classDescriptor.declaredTypeParameters");
                    ArrayList typeParameters = rVar.getTypeParameters();
                    ArrayList arrayList3 = new ArrayList(d7.t.A0(typeParameters, 10));
                    Iterator it = typeParameters.iterator();
                    while (it.hasNext()) {
                        q0 q0VarA = ((r8.f) bVar2.f163g).a((l8.c0) it.next());
                        q7.k.b(q0VarA);
                        arrayList3.add(q0VarA);
                    }
                    bVarX0.V0((List) cVarU.f409c, n7.a.B(rVar.e()), d7.r.c1(listS, arrayList3));
                    bVarX0.O0(false);
                    bVarX0.P0(cVarU.f408b);
                    bVarX0.Q0(eVar.k());
                    ((r8.a) bVar2.f162f).f9008g.getClass();
                    arrayList2.add(bVarX0);
                    z4 = false;
                }
                boolean zF = oVar.f();
                Class cls = oVar.f5878a;
                g8.g gVar = g8.h.f3888a;
                a3.b bVar3 = this.f9584h;
                if (zF) {
                    q8.b bVarX02 = q8.b.X0(eVar, gVar, true, ((r8.a) bVar.f162f).f9011j.c(oVar));
                    ArrayList arrayListE = oVar.e();
                    ArrayList arrayList4 = new ArrayList(arrayListE.size());
                    pVar = pVar2;
                    t8.a aVarX = n7.b.x(2, false, null, 6);
                    Iterator it2 = arrayListE.iterator();
                    int i2 = 0;
                    while (it2.hasNext()) {
                        l8.a0 a0Var = (l8.a0) it2.next();
                        arrayList4.add(new r0(bVarX02, null, i2, gVar, a0Var.c(), ((i5.l) bVar.f166j).R(a0Var.f(), aVarX), false, false, false, null, ((r8.a) bVar.f162f).f9011j.c(a0Var)));
                        i2++;
                    }
                    bVarX02.P0(false);
                    f8.n nVarC = eVar.c();
                    q7.k.d(nVarC, "classDescriptor.visibility");
                    if (nVarC.equals(o8.o.f7836b)) {
                        nVarC = o8.o.f7837c;
                        q7.k.d(nVarC, "PROTECTED_AND_PACKAGE");
                    }
                    bVarX02.U0(arrayList4, nVarC);
                    bVarX02.O0(false);
                    bVarX02.Q0(eVar.k());
                    int i10 = 2;
                    String strM = nb.i.m(bVarX02, 2);
                    if (arrayList2.isEmpty()) {
                        arrayList2.add(bVarX02);
                        ((r8.a) bVar3.f162f).f9008g.getClass();
                    } else {
                        Iterator it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            if (!nb.i.m((i8.i) it3.next(), i10).equals(strM)) {
                                i10 = 2;
                            }
                        }
                        arrayList2.add(bVarX02);
                        ((r8.a) bVar3.f162f).f9008g.getClass();
                    }
                } else {
                    pVar = pVar2;
                }
                ((m9.a) ((r8.a) bVar3.f162f).f9025x).getClass();
                q7.k.e(bVar3, "_context_receiver_0");
                q7.k.e(eVar, "thisDescriptor");
                w8.d dVar = ((r8.a) bVar3.f162f).f9019r;
                boolean zIsEmpty = arrayList2.isEmpty();
                Collection collectionW0 = arrayList2;
                if (zIsEmpty) {
                    boolean zIsAnnotation = cls.isAnnotation();
                    cls.isInterface();
                    if (zIsAnnotation) {
                        r8.a aVar2 = (r8.a) bVar.f162f;
                        i5.l lVar = (i5.l) bVar.f166j;
                        ?? X0 = q8.b.X0(eVar, gVar, true, aVar2.f9011j.c(oVar));
                        if (zIsAnnotation) {
                            List listD2 = oVar.d();
                            arrayList = new ArrayList(listD2.size());
                            t8.a aVarX2 = n7.b.x(2, true, null, 6);
                            ArrayList arrayList5 = new ArrayList();
                            ArrayList arrayList6 = new ArrayList();
                            for (Object obj2 : listD2) {
                                if (q7.k.a(((l8.x) obj2).c(), o8.x.f7859b)) {
                                    arrayList5.add(obj2);
                                } else {
                                    arrayList6.add(obj2);
                                }
                            }
                            arrayList5.size();
                            l8.x xVar = (l8.x) d7.r.P0(arrayList5);
                            if (xVar != null) {
                                l8.b0 b0VarF = xVar.f();
                                if (b0VarF instanceof l8.i) {
                                    l8.i iVar = (l8.i) b0VarF;
                                    jVar = new c7.j(lVar.Q(iVar, aVarX2, true), lVar.R(iVar.f5871b, aVarX2));
                                } else {
                                    jVar = new c7.j(lVar.R(b0VarF, aVarX2), null);
                                }
                                ?? r13 = pVar;
                                r13.x(arrayList, X0, 0, xVar, (v9.v) jVar.f1973f, (v9.v) jVar.f1974g);
                                r12 = r13;
                            } else {
                                r12 = pVar;
                            }
                            int i11 = xVar != null ? 1 : 0;
                            Iterator it4 = arrayList6.iterator();
                            int i12 = 0;
                            while (it4.hasNext()) {
                                l8.x xVar2 = (l8.x) it4.next();
                                r12.x(arrayList, X0, i12 + i11, xVar2, lVar.R(xVar2.f(), aVarX2), null);
                                i12++;
                            }
                        } else {
                            arrayList = Collections.EMPTY_LIST;
                        }
                        X0.P0(false);
                        f8.n nVarC2 = eVar.c();
                        q7.k.d(nVarC2, "classDescriptor.visibility");
                        if (nVarC2.equals(o8.o.f7836b)) {
                            nVarC2 = o8.o.f7837c;
                            q7.k.d(nVarC2, "PROTECTED_AND_PACKAGE");
                        }
                        X0.U0(arrayList, nVarC2);
                        X0.O0(true);
                        X0.Q0(eVar.k());
                        ((r8.a) bVar.f162f).f9008g.getClass();
                        obj = X0;
                    } else {
                        obj = null;
                    }
                    collectionW0 = d7.s.w0(obj);
                }
                return d7.r.m1(dVar.e(bVar3, collectionW0));
            default:
                a3.b bVar4 = this.f9584h;
                m9.e eVar2 = ((r8.a) bVar4.f162f).f9025x;
                f8.e eVar3 = this.f9585i.f9588n;
                ((m9.a) eVar2).getClass();
                q7.k.e(bVar4, "_context_receiver_0");
                q7.k.e(eVar3, "thisDescriptor");
                return d7.r.q1(new ArrayList());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(p pVar, a3.b bVar) {
        super(0);
        this.f9585i = pVar;
        this.f9584h = bVar;
    }
}
