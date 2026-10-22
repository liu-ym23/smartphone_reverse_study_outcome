package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.u0;
import androidx.datastore.preferences.protobuf.v0;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0492l implements v0 {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC0491k f10086a;

    /* renamed from: androidx.datastore.preferences.protobuf.l$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10087a;

        static {
            int[] iArr = new int[u0.b.values().length];
            f10087a = iArr;
            try {
                iArr[u0.b.f10164j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10087a[u0.b.f10163i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10087a[u0.b.f10161g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10087a[u0.b.f10171q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10087a[u0.b.f10173s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10087a[u0.b.f10169o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10087a[u0.b.f10162h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10087a[u0.b.f10159e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10087a[u0.b.f10172r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10087a[u0.b.f10174t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10087a[u0.b.f10160f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10087a[u0.b.f10165k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private C0492l(AbstractC0491k abstractC0491k) {
        AbstractC0491k abstractC0491k2 = (AbstractC0491k) A.b(abstractC0491k, "output");
        this.f10086a = abstractC0491k2;
        abstractC0491k2.f10054a = this;
    }

    public static C0492l P(AbstractC0491k abstractC0491k) {
        C0492l c0492l = abstractC0491k.f10054a;
        return c0492l != null ? c0492l : new C0492l(abstractC0491k);
    }

    private <V> void Q(int i5, boolean z5, V v5, K.a<Boolean, V> aVar) {
        this.f10086a.W0(i5, 2);
        this.f10086a.Y0(K.b(aVar, Boolean.valueOf(z5), v5));
        K.e(this.f10086a, aVar, Boolean.valueOf(z5), v5);
    }

    private <V> void R(int i5, K.a<Integer, V> aVar, Map<Integer, V> map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            iArr[i6] = it.next().intValue();
            i6++;
        }
        Arrays.sort(iArr);
        for (int i7 = 0; i7 < size; i7++) {
            int i8 = iArr[i7];
            V v5 = map.get(Integer.valueOf(i8));
            this.f10086a.W0(i5, 2);
            this.f10086a.Y0(K.b(aVar, Integer.valueOf(i8), v5));
            K.e(this.f10086a, aVar, Integer.valueOf(i8), v5);
        }
    }

    private <V> void S(int i5, K.a<Long, V> aVar, Map<Long, V> map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            jArr[i6] = it.next().longValue();
            i6++;
        }
        Arrays.sort(jArr);
        for (int i7 = 0; i7 < size; i7++) {
            long j5 = jArr[i7];
            V v5 = map.get(Long.valueOf(j5));
            this.f10086a.W0(i5, 2);
            this.f10086a.Y0(K.b(aVar, Long.valueOf(j5), v5));
            K.e(this.f10086a, aVar, Long.valueOf(j5), v5);
        }
    }

    private <K, V> void T(int i5, K.a<K, V> aVar, Map<K, V> map) {
        switch (a.f10087a[aVar.f9948a.ordinal()]) {
            case 1:
                V v5 = map.get(Boolean.FALSE);
                if (v5 != null) {
                    Q(i5, false, v5, aVar);
                }
                V v6 = map.get(Boolean.TRUE);
                if (v6 != null) {
                    Q(i5, true, v6, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                R(i5, aVar, map);
                return;
            case 7:
            case 8:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                S(i5, aVar, map);
                return;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                U(i5, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f9948a);
        }
    }

    private <V> void U(int i5, K.a<String, V> aVar, Map<String, V> map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            strArr[i6] = it.next();
            i6++;
        }
        Arrays.sort(strArr);
        for (int i7 = 0; i7 < size; i7++) {
            String str = strArr[i7];
            V v5 = map.get(str);
            this.f10086a.W0(i5, 2);
            this.f10086a.Y0(K.b(aVar, str, v5));
            K.e(this.f10086a, aVar, str, v5);
        }
    }

    private void V(int i5, Object obj) {
        if (obj instanceof String) {
            this.f10086a.U0(i5, (String) obj);
        } else {
            this.f10086a.o0(i5, (AbstractC0488h) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void A(int i5, List<Boolean> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.k0(i5, list.get(i6).booleanValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iE = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iE += AbstractC0491k.e(list.get(i7).booleanValue());
        }
        this.f10086a.Y0(iE);
        while (i6 < list.size()) {
            this.f10086a.l0(list.get(i6).booleanValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void B(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.X0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iX = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iX += AbstractC0491k.X(list.get(i7).intValue());
        }
        this.f10086a.Y0(iX);
        while (i6 < list.size()) {
            this.f10086a.Y0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void C(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.S0(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iS = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iS += AbstractC0491k.S(list.get(i7).longValue());
        }
        this.f10086a.Y0(iS);
        while (i6 < list.size()) {
            this.f10086a.T0(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void D(int i5, long j5) {
        this.f10086a.S0(i5, j5);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void E(int i5, float f5) {
        this.f10086a.y0(i5, f5);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void F(int i5) {
        this.f10086a.W0(i5, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void G(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.Q0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iQ = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iQ += AbstractC0491k.Q(list.get(i7).intValue());
        }
        this.f10086a.Y0(iQ);
        while (i6 < list.size()) {
            this.f10086a.R0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void H(int i5, int i6) {
        this.f10086a.s0(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void I(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.G0(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iY = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iY += AbstractC0491k.y(list.get(i7).longValue());
        }
        this.f10086a.Y0(iY);
        while (i6 < list.size()) {
            this.f10086a.H0(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void J(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.s0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iL = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iL += AbstractC0491k.l(list.get(i7).intValue());
        }
        this.f10086a.Y0(iL);
        while (i6 < list.size()) {
            this.f10086a.t0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void K(int i5, List<Double> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.q0(i5, list.get(i6).doubleValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iJ = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iJ += AbstractC0491k.j(list.get(i7).doubleValue());
        }
        this.f10086a.Y0(iJ);
        while (i6 < list.size()) {
            this.f10086a.r0(list.get(i6).doubleValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public <K, V> void L(int i5, K.a<K, V> aVar, Map<K, V> map) {
        if (this.f10086a.e0()) {
            T(i5, aVar, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f10086a.W0(i5, 2);
            this.f10086a.Y0(K.b(aVar, entry.getKey(), entry.getValue()));
            K.e(this.f10086a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void M(int i5, int i6) {
        this.f10086a.Q0(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void N(int i5, List<AbstractC0488h> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.f10086a.o0(i5, list.get(i6));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void O(int i5, Object obj, h0 h0Var) {
        this.f10086a.B0(i5, (S) obj, h0Var);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void a(int i5, List<Float> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.y0(i5, list.get(i6).floatValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iR = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iR += AbstractC0491k.r(list.get(i7).floatValue());
        }
        this.f10086a.Y0(iR);
        while (i6 < list.size()) {
            this.f10086a.z0(list.get(i6).floatValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void b(int i5, int i6) {
        this.f10086a.X0(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void c(int i5, Object obj) {
        if (obj instanceof AbstractC0488h) {
            this.f10086a.L0(i5, (AbstractC0488h) obj);
        } else {
            this.f10086a.K0(i5, (S) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void d(int i5, int i6) {
        this.f10086a.u0(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void e(int i5, double d6) {
        this.f10086a.q0(i5, d6);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void f(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.O0(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iO = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iO += AbstractC0491k.O(list.get(i7).longValue());
        }
        this.f10086a.Y0(iO);
        while (i6 < list.size()) {
            this.f10086a.P0(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void g(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.Z0(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iZ = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iZ += AbstractC0491k.Z(list.get(i7).longValue());
        }
        this.f10086a.Y0(iZ);
        while (i6 < list.size()) {
            this.f10086a.a1(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void h(int i5, long j5) {
        this.f10086a.w0(i5, j5);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public v0.a i() {
        return v0.a.ASCENDING;
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void j(int i5, List<?> list, h0 h0Var) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            z(i5, list.get(i6), h0Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void k(int i5, List<String> list) {
        int i6 = 0;
        if (!(list instanceof G)) {
            while (i6 < list.size()) {
                this.f10086a.U0(i5, list.get(i6));
                i6++;
            }
        } else {
            G g5 = (G) list;
            while (i6 < list.size()) {
                V(i5, g5.k(i6));
                i6++;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void l(int i5, List<?> list, h0 h0Var) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            O(i5, list.get(i6), h0Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void m(int i5, String str) {
        this.f10086a.U0(i5, str);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void n(int i5, long j5) {
        this.f10086a.Z0(i5, j5);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void o(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.E0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iW = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iW += AbstractC0491k.w(list.get(i7).intValue());
        }
        this.f10086a.Y0(iW);
        while (i6 < list.size()) {
            this.f10086a.F0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void p(int i5, long j5) {
        this.f10086a.G0(i5, j5);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void q(int i5, boolean z5) {
        this.f10086a.k0(i5, z5);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void r(int i5, int i6) {
        this.f10086a.M0(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void s(int i5) {
        this.f10086a.W0(i5, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void t(int i5, int i6) {
        this.f10086a.E0(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void u(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.w0(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iP = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iP += AbstractC0491k.p(list.get(i7).longValue());
        }
        this.f10086a.Y0(iP);
        while (i6 < list.size()) {
            this.f10086a.x0(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void v(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.M0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iM = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iM += AbstractC0491k.M(list.get(i7).intValue());
        }
        this.f10086a.Y0(iM);
        while (i6 < list.size()) {
            this.f10086a.N0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void w(int i5, AbstractC0488h abstractC0488h) {
        this.f10086a.o0(i5, abstractC0488h);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void x(int i5, long j5) {
        this.f10086a.O0(i5, j5);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void y(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.f10086a.u0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f10086a.W0(i5, 2);
        int iN = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            iN += AbstractC0491k.n(list.get(i7).intValue());
        }
        this.f10086a.Y0(iN);
        while (i6 < list.size()) {
            this.f10086a.v0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public void z(int i5, Object obj, h0 h0Var) {
        this.f10086a.I0(i5, (S) obj, h0Var);
    }
}
