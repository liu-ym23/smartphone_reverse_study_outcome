package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0504y;
import androidx.datastore.preferences.protobuf.u0;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class r extends AbstractC0497q<AbstractC0504y.d> {

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10112a;

        static {
            int[] iArr = new int[u0.b.values().length];
            f10112a = iArr;
            try {
                iArr[u0.b.f10157c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10112a[u0.b.f10158d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10112a[u0.b.f10159e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10112a[u0.b.f10160f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10112a[u0.b.f10161g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10112a[u0.b.f10162h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10112a[u0.b.f10163i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10112a[u0.b.f10164j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10112a[u0.b.f10169o.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10112a[u0.b.f10171q.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10112a[u0.b.f10172r.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10112a[u0.b.f10173s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10112a[u0.b.f10174t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f10112a[u0.b.f10170p.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f10112a[u0.b.f10168n.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f10112a[u0.b.f10165k.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f10112a[u0.b.f10166l.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f10112a[u0.b.f10167m.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    r() {
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0497q
    int a(Map.Entry<?, ?> entry) {
        return ((AbstractC0504y.d) entry.getKey()).a();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0497q
    Object b(C0496p c0496p, S s5, int i5) {
        return c0496p.a(s5, i5);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0497q
    C0500u<AbstractC0504y.d> c(Object obj) {
        return ((AbstractC0504y.c) obj).extensions;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0497q
    C0500u<AbstractC0504y.d> d(Object obj) {
        return ((AbstractC0504y.c) obj).K();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0497q
    boolean e(S s5) {
        return s5 instanceof AbstractC0504y.c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0497q
    void f(Object obj) {
        c(obj).t();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0497q
    <UT, UB> UB g(g0 g0Var, Object obj, C0496p c0496p, C0500u<AbstractC0504y.d> c0500u, UB ub, o0<UT, UB> o0Var) {
        Object objI;
        ArrayList arrayList;
        AbstractC0504y.e eVar = (AbstractC0504y.e) obj;
        int iC = eVar.c();
        Object objH = null;
        if (eVar.f10272b.c() && eVar.f10272b.B()) {
            switch (a.f10112a[eVar.a().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    g0Var.K(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    g0Var.E(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    g0Var.p(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    g0Var.m(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    g0Var.r(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    g0Var.O(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    g0Var.v(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    g0Var.y(arrayList);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    arrayList = new ArrayList();
                    g0Var.i(arrayList);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    arrayList = new ArrayList();
                    g0Var.g(arrayList);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    arrayList = new ArrayList();
                    g0Var.q(arrayList);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    arrayList = new ArrayList();
                    g0Var.c(arrayList);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    arrayList = new ArrayList();
                    g0Var.h(arrayList);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    arrayList = new ArrayList();
                    g0Var.s(arrayList);
                    eVar.f10272b.d();
                    ub = (UB) j0.z(iC, arrayList, null, ub, o0Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.f10272b.f());
            }
            c0500u.x(eVar.f10272b, arrayList);
            return ub;
        }
        if (eVar.a() == u0.b.f10170p) {
            g0Var.F();
            eVar.f10272b.d();
            throw null;
        }
        int[] iArr = a.f10112a;
        switch (iArr[eVar.a().ordinal()]) {
            case 1:
                objH = Double.valueOf(g0Var.readDouble());
                break;
            case 2:
                objH = Float.valueOf(g0Var.readFloat());
                break;
            case 3:
                objH = Long.valueOf(g0Var.M());
                break;
            case 4:
                objH = Long.valueOf(g0Var.d());
                break;
            case 5:
                objH = Integer.valueOf(g0Var.F());
                break;
            case 6:
                objH = Long.valueOf(g0Var.e());
                break;
            case 7:
                objH = Integer.valueOf(g0Var.j());
                break;
            case 8:
                objH = Boolean.valueOf(g0Var.k());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                objH = Integer.valueOf(g0Var.o());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                objH = Integer.valueOf(g0Var.I());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                objH = Long.valueOf(g0Var.l());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                objH = Integer.valueOf(g0Var.w());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                objH = Long.valueOf(g0Var.x());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                throw new IllegalStateException("Shouldn't reach here.");
            case 15:
                objH = g0Var.D();
                break;
            case 16:
                objH = g0Var.z();
                break;
            case 17:
                objH = g0Var.n(eVar.b().getClass(), c0496p);
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                objH = g0Var.f(eVar.b().getClass(), c0496p);
                break;
        }
        if (eVar.d()) {
            c0500u.a(eVar.f10272b, objH);
            return ub;
        }
        int i5 = iArr[eVar.a().ordinal()];
        if ((i5 == 17 || i5 == 18) && (objI = c0500u.i(eVar.f10272b)) != null) {
            objH = A.h(objI, objH);
        }
        c0500u.x(eVar.f10272b, objH);
        return ub;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0497q
    void h(g0 g0Var, Object obj, C0496p c0496p, C0500u<AbstractC0504y.d> c0500u) {
        AbstractC0504y.e eVar = (AbstractC0504y.e) obj;
        c0500u.x(eVar.f10272b, g0Var.f(eVar.b().getClass(), c0496p));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0497q
    void i(AbstractC0488h abstractC0488h, Object obj, C0496p c0496p, C0500u<AbstractC0504y.d> c0500u) throws B {
        AbstractC0504y.e eVar = (AbstractC0504y.e) obj;
        S sR = eVar.b().i().r();
        AbstractC0485e abstractC0485eQ = AbstractC0485e.Q(ByteBuffer.wrap(abstractC0488h.x()), true);
        d0.a().b(sR, abstractC0485eQ, c0496p);
        c0500u.x(eVar.f10272b, sR);
        if (abstractC0485eQ.A() != Integer.MAX_VALUE) {
            throw B.a();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0497q
    void j(v0 v0Var, Map.Entry<?, ?> entry) {
        AbstractC0504y.d dVar = (AbstractC0504y.d) entry.getKey();
        if (!dVar.c()) {
            switch (a.f10112a[dVar.f().ordinal()]) {
                case 1:
                    v0Var.e(dVar.a(), ((Double) entry.getValue()).doubleValue());
                    break;
                case 2:
                    v0Var.E(dVar.a(), ((Float) entry.getValue()).floatValue());
                    break;
                case 3:
                    v0Var.p(dVar.a(), ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    v0Var.n(dVar.a(), ((Long) entry.getValue()).longValue());
                    break;
                case 5:
                    v0Var.t(dVar.a(), ((Integer) entry.getValue()).intValue());
                    break;
                case 6:
                    v0Var.h(dVar.a(), ((Long) entry.getValue()).longValue());
                    break;
                case 7:
                    v0Var.d(dVar.a(), ((Integer) entry.getValue()).intValue());
                    break;
                case 8:
                    v0Var.q(dVar.a(), ((Boolean) entry.getValue()).booleanValue());
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    v0Var.b(dVar.a(), ((Integer) entry.getValue()).intValue());
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    v0Var.r(dVar.a(), ((Integer) entry.getValue()).intValue());
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    v0Var.x(dVar.a(), ((Long) entry.getValue()).longValue());
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    v0Var.M(dVar.a(), ((Integer) entry.getValue()).intValue());
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    v0Var.D(dVar.a(), ((Long) entry.getValue()).longValue());
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    v0Var.t(dVar.a(), ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    v0Var.w(dVar.a(), (AbstractC0488h) entry.getValue());
                    break;
                case 16:
                    v0Var.m(dVar.a(), (String) entry.getValue());
                    break;
                case 17:
                    v0Var.O(dVar.a(), entry.getValue(), d0.a().d(entry.getValue().getClass()));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                    v0Var.z(dVar.a(), entry.getValue(), d0.a().d(entry.getValue().getClass()));
                    break;
            }
        }
        switch (a.f10112a[dVar.f().ordinal()]) {
            case 1:
                j0.P(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case 2:
                j0.T(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case 3:
                j0.W(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case 4:
                j0.e0(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case 5:
                j0.V(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case 6:
                j0.S(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case 7:
                j0.R(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case 8:
                j0.N(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                j0.d0(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                j0.Y(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                j0.Z(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                j0.a0(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                j0.b0(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                j0.V(dVar.a(), (List) entry.getValue(), v0Var, dVar.B());
                break;
            case 15:
                j0.O(dVar.a(), (List) entry.getValue(), v0Var);
                break;
            case 16:
                j0.c0(dVar.a(), (List) entry.getValue(), v0Var);
                break;
            case 17:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    j0.U(dVar.a(), (List) entry.getValue(), v0Var, d0.a().d(list.get(0).getClass()));
                    break;
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    j0.X(dVar.a(), (List) entry.getValue(), v0Var, d0.a().d(list2.get(0).getClass()));
                    break;
                }
                break;
        }
    }
}
