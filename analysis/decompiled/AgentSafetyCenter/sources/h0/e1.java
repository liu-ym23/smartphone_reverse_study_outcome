package h0;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e1 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4954c = 0;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4955f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s0.c f4956g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f4957h;
    public final /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4958j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4959k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f4960l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(int i, xb.p pVar, s0.c cVar, xb.p pVar2, xb.p pVar3, i0.c cVar2, xb.p pVar4) {
        super(2);
        this.f4955f = i;
        this.f4957h = pVar;
        this.f4956g = cVar;
        this.i = pVar2;
        this.f4958j = pVar3;
        this.f4960l = cVar2;
        this.f4959k = pVar4;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        Integer num;
        Object obj3;
        int i;
        Object obj4;
        Object obj5;
        int i3;
        l0 l0Var;
        Object obj6;
        ArrayList arrayList;
        Integer numValueOf;
        int iE0;
        int iD;
        Object obj7;
        Object obj8;
        int i10;
        int iE02;
        int iE03;
        int i11 = this.f4954c;
        jb.v vVar = jb.v.f6774a;
        int i12 = this.f4955f;
        Object obj9 = this.f4959k;
        Object obj10 = this.f4958j;
        Object obj11 = this.i;
        Object obj12 = this.f4957h;
        Object obj13 = this.f4960l;
        switch (i11) {
            case 0:
                k0.s sVar = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && sVar.B()) {
                    sVar.S();
                } else {
                    i1.b(this.f4955f, (xb.p) obj12, this.f4956g, (xb.p) obj11, (xb.p) obj10, (i0.c) obj13, (xb.p) obj9, sVar, 0);
                }
                return vVar;
            case 1:
                k0.s sVar2 = (k0.s) obj;
                s1.z0 z0Var = (s1.z0) obj11;
                if ((((Number) obj2).intValue() & 3) == 2 && sVar2.B()) {
                    sVar2.S();
                } else {
                    w.y0 y0Var = (w.y0) obj12;
                    float fJ = ((ArrayList) obj10).isEmpty() ? z0Var.J(y0Var.c(z0Var)) : z0Var.J(i12);
                    float fJ2 = (((ArrayList) obj9).isEmpty() || (num = (Integer) obj13) == null) ? z0Var.J(y0Var.d(z0Var)) : z0Var.J(num.intValue());
                    o2.l layoutDirection = z0Var.getLayoutDirection();
                    o2.l lVar = o2.l.f9123c;
                    float fJ3 = layoutDirection == lVar ? z0Var.J(y0Var.b(z0Var, layoutDirection)) : z0Var.J(y0Var.a(z0Var, layoutDirection));
                    o2.l layoutDirection2 = z0Var.getLayoutDirection();
                    this.f4956g.invoke(new w.l0(fJ3, fJ, layoutDirection2 == lVar ? z0Var.J(y0Var.a(z0Var, layoutDirection2)) : z0Var.J(y0Var.b(z0Var, layoutDirection2)), fJ2), sVar2, 0);
                }
                return vVar;
            default:
                s1.z0 z0Var2 = (s1.z0) obj;
                long j10 = ((o2.a) obj2).f9108a;
                w.y0 y0Var2 = (w.y0) obj13;
                int i13 = o2.a.i(j10);
                int iH = o2.a.h(j10);
                long jB = o2.a.b(j10, 0, 0, 0, 0, 10);
                List listW = z0Var2.W(j1.f5031c, (xb.p) obj12);
                ArrayList arrayList2 = new ArrayList(listW.size());
                int size = listW.size();
                for (int i14 = 0; i14 < size; i14++) {
                    arrayList2.add(((s1.e0) listW.get(i14)).q(jB));
                }
                int i15 = 1;
                if (arrayList2.isEmpty()) {
                    i = 1;
                    obj3 = null;
                } else {
                    obj3 = arrayList2.get(0);
                    int i16 = ((s1.o0) obj3).f11278f;
                    int size2 = arrayList2.size() - 1;
                    i = 1;
                    if (1 <= size2) {
                        while (true) {
                            Object obj14 = arrayList2.get(i15);
                            int i17 = ((s1.o0) obj14).f11278f;
                            if (i16 < i17) {
                                i16 = i17;
                                obj3 = obj14;
                            }
                            if (i15 != size2) {
                                i15++;
                            }
                        }
                    }
                }
                s1.o0 o0Var = (s1.o0) obj3;
                int i18 = o0Var != null ? o0Var.f11278f : 0;
                List listW2 = z0Var2.W(j1.f5033g, (xb.p) obj11);
                ArrayList arrayList3 = new ArrayList(listW2.size());
                int size3 = listW2.size();
                int i19 = 0;
                while (i19 < size3) {
                    arrayList3.add(((s1.e0) listW2.get(i19)).q(o2.b.h(jB, (-y0Var2.b(z0Var2, z0Var2.getLayoutDirection())) - y0Var2.a(z0Var2, z0Var2.getLayoutDirection()), -y0Var2.d(z0Var2))));
                    i19++;
                    i18 = i18;
                    obj9 = obj9;
                    obj10 = obj10;
                }
                int i20 = i18;
                Object obj15 = obj9;
                Object obj16 = obj10;
                if (arrayList3.isEmpty()) {
                    obj4 = null;
                } else {
                    obj4 = arrayList3.get(0);
                    int i21 = ((s1.o0) obj4).f11278f;
                    int size4 = arrayList3.size() - 1;
                    if (i <= size4) {
                        Object obj17 = obj4;
                        int i22 = i21;
                        int i23 = 1;
                        while (true) {
                            Object obj18 = arrayList3.get(i23);
                            int i24 = ((s1.o0) obj18).f11278f;
                            if (i22 < i24) {
                                obj17 = obj18;
                                i22 = i24;
                            }
                            if (i23 != size4) {
                                i23++;
                            } else {
                                obj4 = obj17;
                            }
                        }
                    }
                }
                s1.o0 o0Var2 = (s1.o0) obj4;
                int i25 = o0Var2 != null ? o0Var2.f11278f : 0;
                if (arrayList3.isEmpty()) {
                    obj5 = null;
                } else {
                    obj5 = arrayList3.get(0);
                    int i26 = ((s1.o0) obj5).f11277c;
                    int size5 = arrayList3.size() - 1;
                    if (1 <= size5) {
                        Object obj19 = obj5;
                        int i27 = i26;
                        int i28 = 1;
                        while (true) {
                            Object obj20 = arrayList3.get(i28);
                            int i29 = ((s1.o0) obj20).f11277c;
                            if (i27 < i29) {
                                obj19 = obj20;
                                i27 = i29;
                            }
                            if (i28 != size5) {
                                i28++;
                            } else {
                                obj5 = obj19;
                            }
                        }
                    }
                }
                s1.o0 o0Var3 = (s1.o0) obj5;
                int i30 = o0Var3 != null ? o0Var3.f11277c : 0;
                List listW3 = z0Var2.W(j1.f5034h, (xb.p) obj16);
                ArrayList arrayList4 = new ArrayList(listW3.size());
                int size6 = listW3.size();
                int i31 = 0;
                while (i31 < size6) {
                    int i32 = i25;
                    int i33 = i30;
                    List list = listW3;
                    s1.o0 o0VarQ = ((s1.e0) listW3.get(i31)).q(o2.b.h(jB, (-y0Var2.b(z0Var2, z0Var2.getLayoutDirection())) - y0Var2.a(z0Var2, z0Var2.getLayoutDirection()), -y0Var2.d(z0Var2)));
                    if (o0VarQ.f11278f == 0 || o0VarQ.f11277c == 0) {
                        o0VarQ = null;
                    }
                    if (o0VarQ != null) {
                        arrayList4.add(o0VarQ);
                    }
                    i31++;
                    listW3 = list;
                    i25 = i32;
                    i30 = i33;
                }
                int i34 = i25;
                int i35 = i30;
                if (arrayList4.isEmpty()) {
                    i3 = 2;
                    l0Var = null;
                } else {
                    if (arrayList4.isEmpty()) {
                        obj7 = null;
                    } else {
                        obj7 = arrayList4.get(0);
                        int i36 = ((s1.o0) obj7).f11277c;
                        int size7 = arrayList4.size() - 1;
                        if (1 <= size7) {
                            Object obj21 = obj7;
                            int i37 = i36;
                            int i38 = 1;
                            while (true) {
                                Object obj22 = arrayList4.get(i38);
                                int i39 = ((s1.o0) obj22).f11277c;
                                if (i37 < i39) {
                                    obj21 = obj22;
                                    i37 = i39;
                                }
                                if (i38 != size7) {
                                    i38++;
                                } else {
                                    obj7 = obj21;
                                }
                            }
                        }
                    }
                    obj7.getClass();
                    int i40 = ((s1.o0) obj7).f11277c;
                    if (arrayList4.isEmpty()) {
                        i10 = i40;
                        obj8 = null;
                    } else {
                        obj8 = arrayList4.get(0);
                        int i41 = ((s1.o0) obj8).f11278f;
                        int size8 = arrayList4.size() - 1;
                        if (1 <= size8) {
                            Object obj23 = obj8;
                            int i42 = i41;
                            int i43 = 1;
                            while (true) {
                                Object obj24 = arrayList4.get(i43);
                                i10 = i40;
                                int i44 = ((s1.o0) obj24).f11278f;
                                if (i42 < i44) {
                                    i42 = i44;
                                    obj23 = obj24;
                                }
                                if (i43 != size8) {
                                    i43++;
                                    i40 = i10;
                                } else {
                                    obj8 = obj23;
                                }
                            }
                        } else {
                            i10 = i40;
                        }
                    }
                    obj8.getClass();
                    int i45 = ((s1.o0) obj8).f11278f;
                    if (i12 == 0) {
                        if (z0Var2.getLayoutDirection() == o2.l.f9123c) {
                            iE02 = z0Var2.e0(i1.f5014a);
                            i3 = 2;
                            l0Var = new l0();
                            l0Var.f5052a = iE02;
                            l0Var.f5053b = i45;
                            VarHandle.storeStoreFence();
                        } else {
                            iE03 = z0Var2.e0(i1.f5014a);
                            iE02 = (i13 - iE03) - i10;
                            i3 = 2;
                            l0Var = new l0();
                            l0Var.f5052a = iE02;
                            l0Var.f5053b = i45;
                            VarHandle.storeStoreFence();
                        }
                    } else if (i12 != 2 && i12 != 3) {
                        i3 = 2;
                        iE02 = (i13 - i10) / 2;
                        l0Var = new l0();
                        l0Var.f5052a = iE02;
                        l0Var.f5053b = i45;
                        VarHandle.storeStoreFence();
                    } else if (z0Var2.getLayoutDirection() == o2.l.f9123c) {
                        iE03 = z0Var2.e0(i1.f5014a);
                        iE02 = (i13 - iE03) - i10;
                        i3 = 2;
                        l0Var = new l0();
                        l0Var.f5052a = iE02;
                        l0Var.f5053b = i45;
                        VarHandle.storeStoreFence();
                    } else {
                        iE02 = z0Var2.e0(i1.f5014a);
                        i3 = 2;
                        l0Var = new l0();
                        l0Var.f5052a = iE02;
                        l0Var.f5053b = i45;
                        VarHandle.storeStoreFence();
                    }
                }
                List listW4 = z0Var2.W(j1.i, new s0.c(-2146438447, true, new b(i3, (xb.p) obj15)));
                ArrayList arrayList5 = new ArrayList(listW4.size());
                int size9 = listW4.size();
                for (int i46 = 0; i46 < size9; i46++) {
                    arrayList5.add(((s1.e0) listW4.get(i46)).q(jB));
                }
                if (arrayList5.isEmpty()) {
                    arrayList = arrayList5;
                    obj6 = null;
                } else {
                    obj6 = arrayList5.get(0);
                    int i47 = ((s1.o0) obj6).f11278f;
                    int size10 = arrayList5.size() - 1;
                    if (1 <= size10) {
                        int i48 = 1;
                        while (true) {
                            Object obj25 = arrayList5.get(i48);
                            arrayList = arrayList5;
                            int i49 = ((s1.o0) obj25).f11278f;
                            if (i47 < i49) {
                                i47 = i49;
                                obj6 = obj25;
                            }
                            if (i48 != size10) {
                                i48++;
                                arrayList5 = arrayList;
                            }
                        }
                    } else {
                        arrayList = arrayList5;
                    }
                }
                s1.o0 o0Var4 = (s1.o0) obj6;
                Integer numValueOf2 = o0Var4 != null ? Integer.valueOf(o0Var4.f11278f) : null;
                if (l0Var != null) {
                    int i50 = l0Var.f5053b;
                    if (numValueOf2 == null || i12 == 3) {
                        iE0 = z0Var2.e0(i1.f5014a) + i50;
                        iD = y0Var2.d(z0Var2);
                    } else {
                        iE0 = numValueOf2.intValue() + i50;
                        iD = z0Var2.e0(i1.f5014a);
                    }
                    numValueOf = Integer.valueOf(iD + iE0);
                } else {
                    numValueOf = null;
                }
                int iIntValue = i34 != 0 ? i34 + (numValueOf != null ? numValueOf.intValue() : numValueOf2 != null ? numValueOf2.intValue() : y0Var2.d(z0Var2)) : 0;
                ArrayList arrayList6 = arrayList;
                List listW5 = z0Var2.W(j1.f5032f, new s0.c(-1213360416, true, new e1((w.y0) obj13, z0Var2, arrayList2, i20, arrayList6, numValueOf2, this.f4956g)));
                ArrayList arrayList7 = new ArrayList(listW5.size());
                int size11 = listW5.size();
                for (int i51 = 0; i51 < size11; i51++) {
                    arrayList7.add(((s1.e0) listW5.get(i51)).q(jB));
                }
                return z0Var2.Y(i13, iH, kb.t.f7405c, new g1(arrayList7, arrayList2, arrayList3, arrayList6, l0Var, i13, i35, (w.y0) obj13, z0Var2, iH, iIntValue, numValueOf2, arrayList4, numValueOf));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(w.y0 y0Var, s1.z0 z0Var, ArrayList arrayList, int i, ArrayList arrayList2, Integer num, s0.c cVar) {
        super(2);
        this.f4957h = y0Var;
        this.i = z0Var;
        this.f4958j = arrayList;
        this.f4955f = i;
        this.f4959k = arrayList2;
        this.f4960l = num;
        this.f4956g = cVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(xb.p pVar, xb.p pVar2, xb.p pVar3, int i, w.y0 y0Var, xb.p pVar4, s0.c cVar) {
        super(2);
        this.f4957h = pVar;
        this.i = pVar2;
        this.f4958j = pVar3;
        this.f4955f = i;
        this.f4960l = y0Var;
        this.f4959k = pVar4;
        this.f4956g = cVar;
    }
}
