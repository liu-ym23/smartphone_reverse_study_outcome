package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.B;
import androidx.datastore.preferences.protobuf.u0;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.util.List;

/* renamed from: androidx.datastore.preferences.protobuf.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0490j implements g0 {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC0489i f10043a;

    /* renamed from: b, reason: collision with root package name */
    private int f10044b;

    /* renamed from: c, reason: collision with root package name */
    private int f10045c;

    /* renamed from: d, reason: collision with root package name */
    private int f10046d = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.j$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10047a;

        static {
            int[] iArr = new int[u0.b.values().length];
            f10047a = iArr;
            try {
                iArr[u0.b.f10164j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10047a[u0.b.f10168n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10047a[u0.b.f10157c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10047a[u0.b.f10170p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10047a[u0.b.f10163i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10047a[u0.b.f10162h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10047a[u0.b.f10158d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10047a[u0.b.f10161g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10047a[u0.b.f10159e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10047a[u0.b.f10167m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10047a[u0.b.f10171q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10047a[u0.b.f10172r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10047a[u0.b.f10173s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f10047a[u0.b.f10174t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f10047a[u0.b.f10165k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f10047a[u0.b.f10169o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f10047a[u0.b.f10160f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private C0490j(AbstractC0489i abstractC0489i) {
        AbstractC0489i abstractC0489i2 = (AbstractC0489i) A.b(abstractC0489i, "input");
        this.f10043a = abstractC0489i2;
        abstractC0489i2.f10024d = this;
    }

    public static C0490j Q(AbstractC0489i abstractC0489i) {
        C0490j c0490j = abstractC0489i.f10024d;
        return c0490j != null ? c0490j : new C0490j(abstractC0489i);
    }

    private Object R(u0.b bVar, Class<?> cls, C0496p c0496p) {
        switch (a.f10047a[bVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(k());
            case 2:
                return D();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(u());
            case 5:
                return Integer.valueOf(j());
            case 6:
                return Long.valueOf(e());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(F());
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return Long.valueOf(M());
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                return f(cls, c0496p);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return Integer.valueOf(I());
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                return Long.valueOf(l());
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                return Integer.valueOf(w());
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                return Long.valueOf(x());
            case 15:
                return N();
            case 16:
                return Integer.valueOf(o());
            case 17:
                return Long.valueOf(d());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private <T> T S(h0<T> h0Var, C0496p c0496p) {
        int i5 = this.f10045c;
        this.f10045c = u0.c(u0.a(this.f10044b), 4);
        try {
            T tH = h0Var.h();
            h0Var.b(tH, this, c0496p);
            h0Var.c(tH);
            if (this.f10044b == this.f10045c) {
                return tH;
            }
            throw B.g();
        } finally {
            this.f10045c = i5;
        }
    }

    private <T> T T(h0<T> h0Var, C0496p c0496p) throws B {
        int iC = this.f10043a.C();
        AbstractC0489i abstractC0489i = this.f10043a;
        if (abstractC0489i.f10021a >= abstractC0489i.f10022b) {
            throw B.h();
        }
        int iL = abstractC0489i.l(iC);
        T tH = h0Var.h();
        this.f10043a.f10021a++;
        h0Var.b(tH, this, c0496p);
        h0Var.c(tH);
        this.f10043a.a(0);
        r4.f10021a--;
        this.f10043a.k(iL);
        return tH;
    }

    private void V(int i5) throws B {
        if (this.f10043a.d() != i5) {
            throw B.k();
        }
    }

    private void W(int i5) throws B.a {
        if (u0.b(this.f10044b) != i5) {
            throw B.d();
        }
    }

    private void X(int i5) throws B {
        if ((i5 & 3) != 0) {
            throw B.g();
        }
    }

    private void Y(int i5) throws B {
        if ((i5 & 7) != 0) {
            throw B.g();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public int A() {
        int i5 = this.f10046d;
        if (i5 != 0) {
            this.f10044b = i5;
            this.f10046d = 0;
        } else {
            this.f10044b = this.f10043a.B();
        }
        int i6 = this.f10044b;
        if (i6 == 0 || i6 == this.f10045c) {
            return Integer.MAX_VALUE;
        }
        return u0.a(i6);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void B(List<String> list) throws B.a {
        U(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void C(List<String> list) throws B.a {
        U(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public AbstractC0488h D() throws B.a {
        W(2);
        return this.f10043a.n();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void E(List<Float> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof C0502w)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 2) {
                int iC = this.f10043a.C();
                X(iC);
                int iD = this.f10043a.d() + iC;
                do {
                    list.add(Float.valueOf(this.f10043a.s()));
                } while (this.f10043a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw B.d();
            }
            do {
                list.add(Float.valueOf(this.f10043a.s()));
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB = this.f10043a.B();
                }
            } while (iB == this.f10044b);
            this.f10046d = iB;
            return;
        }
        C0502w c0502w = (C0502w) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 2) {
            int iC2 = this.f10043a.C();
            X(iC2);
            int iD2 = this.f10043a.d() + iC2;
            do {
                c0502w.h(this.f10043a.s());
            } while (this.f10043a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw B.d();
        }
        do {
            c0502w.h(this.f10043a.s());
            if (this.f10043a.e()) {
                return;
            } else {
                iB2 = this.f10043a.B();
            }
        } while (iB2 == this.f10044b);
        this.f10046d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public int F() throws B.a {
        W(0);
        return this.f10043a.t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.g0
    public <T> void G(List<T> list, h0<T> h0Var, C0496p c0496p) throws B.a {
        int iB;
        if (u0.b(this.f10044b) != 3) {
            throw B.d();
        }
        int i5 = this.f10044b;
        do {
            list.add(S(h0Var, c0496p));
            if (this.f10043a.e() || this.f10046d != 0) {
                return;
            } else {
                iB = this.f10043a.B();
            }
        } while (iB == i5);
        this.f10046d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public boolean H() {
        int i5;
        if (this.f10043a.e() || (i5 = this.f10044b) == this.f10045c) {
            return false;
        }
        return this.f10043a.E(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public int I() throws B.a {
        W(5);
        return this.f10043a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void J(List<AbstractC0488h> list) throws B.a {
        int iB;
        if (u0.b(this.f10044b) != 2) {
            throw B.d();
        }
        do {
            list.add(D());
            if (this.f10043a.e()) {
                return;
            } else {
                iB = this.f10043a.B();
            }
        } while (iB == this.f10044b);
        this.f10046d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void K(List<Double> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof C0493m)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 1) {
                do {
                    list.add(Double.valueOf(this.f10043a.o()));
                    if (this.f10043a.e()) {
                        return;
                    } else {
                        iB = this.f10043a.B();
                    }
                } while (iB == this.f10044b);
                this.f10046d = iB;
                return;
            }
            if (iB3 != 2) {
                throw B.d();
            }
            int iC = this.f10043a.C();
            Y(iC);
            int iD = this.f10043a.d() + iC;
            do {
                list.add(Double.valueOf(this.f10043a.o()));
            } while (this.f10043a.d() < iD);
            return;
        }
        C0493m c0493m = (C0493m) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 1) {
            do {
                c0493m.h(this.f10043a.o());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB2 = this.f10043a.B();
                }
            } while (iB2 == this.f10044b);
            this.f10046d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw B.d();
        }
        int iC2 = this.f10043a.C();
        Y(iC2);
        int iD2 = this.f10043a.d() + iC2;
        do {
            c0493m.h(this.f10043a.o());
        } while (this.f10043a.d() < iD2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.g0
    public <T> void L(List<T> list, h0<T> h0Var, C0496p c0496p) throws B.a {
        int iB;
        if (u0.b(this.f10044b) != 2) {
            throw B.d();
        }
        int i5 = this.f10044b;
        do {
            list.add(T(h0Var, c0496p));
            if (this.f10043a.e() || this.f10046d != 0) {
                return;
            } else {
                iB = this.f10043a.B();
            }
        } while (iB == i5);
        this.f10046d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public long M() throws B.a {
        W(0);
        return this.f10043a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public String N() throws B.a {
        W(2);
        return this.f10043a.A();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void O(List<Long> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof I)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 1) {
                do {
                    list.add(Long.valueOf(this.f10043a.r()));
                    if (this.f10043a.e()) {
                        return;
                    } else {
                        iB = this.f10043a.B();
                    }
                } while (iB == this.f10044b);
                this.f10046d = iB;
                return;
            }
            if (iB3 != 2) {
                throw B.d();
            }
            int iC = this.f10043a.C();
            Y(iC);
            int iD = this.f10043a.d() + iC;
            do {
                list.add(Long.valueOf(this.f10043a.r()));
            } while (this.f10043a.d() < iD);
            return;
        }
        I i5 = (I) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 1) {
            do {
                i5.i(this.f10043a.r());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB2 = this.f10043a.B();
                }
            } while (iB2 == this.f10044b);
            this.f10046d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw B.d();
        }
        int iC2 = this.f10043a.C();
        Y(iC2);
        int iD2 = this.f10043a.d() + iC2;
        do {
            i5.i(this.f10043a.r());
        } while (this.f10043a.d() < iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public <T> T P(h0<T> h0Var, C0496p c0496p) throws B.a {
        W(3);
        return (T) S(h0Var, c0496p);
    }

    public void U(List<String> list, boolean z5) throws B.a {
        int iB;
        int iB2;
        if (u0.b(this.f10044b) != 2) {
            throw B.d();
        }
        if (!(list instanceof G) || z5) {
            do {
                list.add(z5 ? N() : z());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB = this.f10043a.B();
                }
            } while (iB == this.f10044b);
            this.f10046d = iB;
            return;
        }
        G g5 = (G) list;
        do {
            g5.e(D());
            if (this.f10043a.e()) {
                return;
            } else {
                iB2 = this.f10043a.B();
            }
        } while (iB2 == this.f10044b);
        this.f10046d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public int a() {
        return this.f10044b;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public <T> T b(h0<T> h0Var, C0496p c0496p) throws B.a {
        W(2);
        return (T) T(h0Var, c0496p);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void c(List<Integer> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof C0505z)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f10043a.x()));
                    if (this.f10043a.e()) {
                        return;
                    } else {
                        iB = this.f10043a.B();
                    }
                } while (iB == this.f10044b);
                this.f10046d = iB;
                return;
            }
            if (iB3 != 2) {
                throw B.d();
            }
            int iD = this.f10043a.d() + this.f10043a.C();
            do {
                list.add(Integer.valueOf(this.f10043a.x()));
            } while (this.f10043a.d() < iD);
            V(iD);
            return;
        }
        C0505z c0505z = (C0505z) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 0) {
            do {
                c0505z.h(this.f10043a.x());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB2 = this.f10043a.B();
                }
            } while (iB2 == this.f10044b);
            this.f10046d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw B.d();
        }
        int iD2 = this.f10043a.d() + this.f10043a.C();
        do {
            c0505z.h(this.f10043a.x());
        } while (this.f10043a.d() < iD2);
        V(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public long d() throws B.a {
        W(0);
        return this.f10043a.D();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public long e() throws B.a {
        W(1);
        return this.f10043a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public <T> T f(Class<T> cls, C0496p c0496p) throws B.a {
        W(2);
        return (T) T(d0.a().d(cls), c0496p);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void g(List<Integer> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof C0505z)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 2) {
                int iC = this.f10043a.C();
                X(iC);
                int iD = this.f10043a.d() + iC;
                do {
                    list.add(Integer.valueOf(this.f10043a.v()));
                } while (this.f10043a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw B.d();
            }
            do {
                list.add(Integer.valueOf(this.f10043a.v()));
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB = this.f10043a.B();
                }
            } while (iB == this.f10044b);
            this.f10046d = iB;
            return;
        }
        C0505z c0505z = (C0505z) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 2) {
            int iC2 = this.f10043a.C();
            X(iC2);
            int iD2 = this.f10043a.d() + iC2;
            do {
                c0505z.h(this.f10043a.v());
            } while (this.f10043a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw B.d();
        }
        do {
            c0505z.h(this.f10043a.v());
            if (this.f10043a.e()) {
                return;
            } else {
                iB2 = this.f10043a.B();
            }
        } while (iB2 == this.f10044b);
        this.f10046d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void h(List<Long> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof I)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.f10043a.y()));
                    if (this.f10043a.e()) {
                        return;
                    } else {
                        iB = this.f10043a.B();
                    }
                } while (iB == this.f10044b);
                this.f10046d = iB;
                return;
            }
            if (iB3 != 2) {
                throw B.d();
            }
            int iD = this.f10043a.d() + this.f10043a.C();
            do {
                list.add(Long.valueOf(this.f10043a.y()));
            } while (this.f10043a.d() < iD);
            V(iD);
            return;
        }
        I i5 = (I) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 0) {
            do {
                i5.i(this.f10043a.y());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB2 = this.f10043a.B();
                }
            } while (iB2 == this.f10044b);
            this.f10046d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw B.d();
        }
        int iD2 = this.f10043a.d() + this.f10043a.C();
        do {
            i5.i(this.f10043a.y());
        } while (this.f10043a.d() < iD2);
        V(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void i(List<Integer> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof C0505z)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f10043a.C()));
                    if (this.f10043a.e()) {
                        return;
                    } else {
                        iB = this.f10043a.B();
                    }
                } while (iB == this.f10044b);
                this.f10046d = iB;
                return;
            }
            if (iB3 != 2) {
                throw B.d();
            }
            int iD = this.f10043a.d() + this.f10043a.C();
            do {
                list.add(Integer.valueOf(this.f10043a.C()));
            } while (this.f10043a.d() < iD);
            V(iD);
            return;
        }
        C0505z c0505z = (C0505z) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 0) {
            do {
                c0505z.h(this.f10043a.C());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB2 = this.f10043a.B();
                }
            } while (iB2 == this.f10044b);
            this.f10046d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw B.d();
        }
        int iD2 = this.f10043a.d() + this.f10043a.C();
        do {
            c0505z.h(this.f10043a.C());
        } while (this.f10043a.d() < iD2);
        V(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public int j() throws B.a {
        W(5);
        return this.f10043a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public boolean k() throws B.a {
        W(0);
        return this.f10043a.m();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public long l() throws B.a {
        W(1);
        return this.f10043a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void m(List<Long> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof I)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.f10043a.D()));
                    if (this.f10043a.e()) {
                        return;
                    } else {
                        iB = this.f10043a.B();
                    }
                } while (iB == this.f10044b);
                this.f10046d = iB;
                return;
            }
            if (iB3 != 2) {
                throw B.d();
            }
            int iD = this.f10043a.d() + this.f10043a.C();
            do {
                list.add(Long.valueOf(this.f10043a.D()));
            } while (this.f10043a.d() < iD);
            V(iD);
            return;
        }
        I i5 = (I) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 0) {
            do {
                i5.i(this.f10043a.D());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB2 = this.f10043a.B();
                }
            } while (iB2 == this.f10044b);
            this.f10046d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw B.d();
        }
        int iD2 = this.f10043a.d() + this.f10043a.C();
        do {
            i5.i(this.f10043a.D());
        } while (this.f10043a.d() < iD2);
        V(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public <T> T n(Class<T> cls, C0496p c0496p) throws B.a {
        W(3);
        return (T) S(d0.a().d(cls), c0496p);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public int o() throws B.a {
        W(0);
        return this.f10043a.C();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void p(List<Long> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof I)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.f10043a.u()));
                    if (this.f10043a.e()) {
                        return;
                    } else {
                        iB = this.f10043a.B();
                    }
                } while (iB == this.f10044b);
                this.f10046d = iB;
                return;
            }
            if (iB3 != 2) {
                throw B.d();
            }
            int iD = this.f10043a.d() + this.f10043a.C();
            do {
                list.add(Long.valueOf(this.f10043a.u()));
            } while (this.f10043a.d() < iD);
            V(iD);
            return;
        }
        I i5 = (I) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 0) {
            do {
                i5.i(this.f10043a.u());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB2 = this.f10043a.B();
                }
            } while (iB2 == this.f10044b);
            this.f10046d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw B.d();
        }
        int iD2 = this.f10043a.d() + this.f10043a.C();
        do {
            i5.i(this.f10043a.u());
        } while (this.f10043a.d() < iD2);
        V(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void q(List<Long> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof I)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 1) {
                do {
                    list.add(Long.valueOf(this.f10043a.w()));
                    if (this.f10043a.e()) {
                        return;
                    } else {
                        iB = this.f10043a.B();
                    }
                } while (iB == this.f10044b);
                this.f10046d = iB;
                return;
            }
            if (iB3 != 2) {
                throw B.d();
            }
            int iC = this.f10043a.C();
            Y(iC);
            int iD = this.f10043a.d() + iC;
            do {
                list.add(Long.valueOf(this.f10043a.w()));
            } while (this.f10043a.d() < iD);
            return;
        }
        I i5 = (I) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 1) {
            do {
                i5.i(this.f10043a.w());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB2 = this.f10043a.B();
                }
            } while (iB2 == this.f10044b);
            this.f10046d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw B.d();
        }
        int iC2 = this.f10043a.C();
        Y(iC2);
        int iD2 = this.f10043a.d() + iC2;
        do {
            i5.i(this.f10043a.w());
        } while (this.f10043a.d() < iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void r(List<Integer> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof C0505z)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f10043a.t()));
                    if (this.f10043a.e()) {
                        return;
                    } else {
                        iB = this.f10043a.B();
                    }
                } while (iB == this.f10044b);
                this.f10046d = iB;
                return;
            }
            if (iB3 != 2) {
                throw B.d();
            }
            int iD = this.f10043a.d() + this.f10043a.C();
            do {
                list.add(Integer.valueOf(this.f10043a.t()));
            } while (this.f10043a.d() < iD);
            V(iD);
            return;
        }
        C0505z c0505z = (C0505z) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 0) {
            do {
                c0505z.h(this.f10043a.t());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB2 = this.f10043a.B();
                }
            } while (iB2 == this.f10044b);
            this.f10046d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw B.d();
        }
        int iD2 = this.f10043a.d() + this.f10043a.C();
        do {
            c0505z.h(this.f10043a.t());
        } while (this.f10043a.d() < iD2);
        V(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public double readDouble() throws B.a {
        W(1);
        return this.f10043a.o();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public float readFloat() throws B.a {
        W(5);
        return this.f10043a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void s(List<Integer> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof C0505z)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f10043a.p()));
                    if (this.f10043a.e()) {
                        return;
                    } else {
                        iB = this.f10043a.B();
                    }
                } while (iB == this.f10044b);
                this.f10046d = iB;
                return;
            }
            if (iB3 != 2) {
                throw B.d();
            }
            int iD = this.f10043a.d() + this.f10043a.C();
            do {
                list.add(Integer.valueOf(this.f10043a.p()));
            } while (this.f10043a.d() < iD);
            V(iD);
            return;
        }
        C0505z c0505z = (C0505z) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 0) {
            do {
                c0505z.h(this.f10043a.p());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB2 = this.f10043a.B();
                }
            } while (iB2 == this.f10044b);
            this.f10046d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw B.d();
        }
        int iD2 = this.f10043a.d() + this.f10043a.C();
        do {
            c0505z.h(this.f10043a.p());
        } while (this.f10043a.d() < iD2);
        V(iD2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f10043a.k(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <K, V> void t(java.util.Map<K, V> r8, androidx.datastore.preferences.protobuf.K.a<K, V> r9, androidx.datastore.preferences.protobuf.C0496p r10) throws androidx.datastore.preferences.protobuf.B.a {
        /*
            r7 = this;
            r0 = 2
            r7.W(r0)
            androidx.datastore.preferences.protobuf.i r1 = r7.f10043a
            int r1 = r1.C()
            androidx.datastore.preferences.protobuf.i r2 = r7.f10043a
            int r1 = r2.l(r1)
            K r2 = r9.f9949b
            V r3 = r9.f9951d
        L14:
            int r4 = r7.A()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            androidx.datastore.preferences.protobuf.i r5 = r7.f10043a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.e()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.H()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.B.a -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            androidx.datastore.preferences.protobuf.B r4 = new androidx.datastore.preferences.protobuf.B     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.B.a -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.B.a -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.B.a -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            androidx.datastore.preferences.protobuf.u0$b r4 = r9.f9950c     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.B.a -> L51
            V r5 = r9.f9951d     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.B.a -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.B.a -> L51
            java.lang.Object r3 = r7.R(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.B.a -> L51
            goto L14
        L49:
            androidx.datastore.preferences.protobuf.u0$b r4 = r9.f9948a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.B.a -> L51
            r5 = 0
            java.lang.Object r2 = r7.R(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.B.a -> L51
            goto L14
        L51:
            boolean r4 = r7.H()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            androidx.datastore.preferences.protobuf.B r8 = new androidx.datastore.preferences.protobuf.B     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            androidx.datastore.preferences.protobuf.i r7 = r7.f10043a
            r7.k(r1)
            return
        L67:
            androidx.datastore.preferences.protobuf.i r7 = r7.f10043a
            r7.k(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C0490j.t(java.util.Map, androidx.datastore.preferences.protobuf.K$a, androidx.datastore.preferences.protobuf.p):void");
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public int u() throws B.a {
        W(0);
        return this.f10043a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void v(List<Integer> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof C0505z)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 2) {
                int iC = this.f10043a.C();
                X(iC);
                int iD = this.f10043a.d() + iC;
                do {
                    list.add(Integer.valueOf(this.f10043a.q()));
                } while (this.f10043a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw B.d();
            }
            do {
                list.add(Integer.valueOf(this.f10043a.q()));
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB = this.f10043a.B();
                }
            } while (iB == this.f10044b);
            this.f10046d = iB;
            return;
        }
        C0505z c0505z = (C0505z) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 2) {
            int iC2 = this.f10043a.C();
            X(iC2);
            int iD2 = this.f10043a.d() + iC2;
            do {
                c0505z.h(this.f10043a.q());
            } while (this.f10043a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw B.d();
        }
        do {
            c0505z.h(this.f10043a.q());
            if (this.f10043a.e()) {
                return;
            } else {
                iB2 = this.f10043a.B();
            }
        } while (iB2 == this.f10044b);
        this.f10046d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public int w() throws B.a {
        W(0);
        return this.f10043a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public long x() throws B.a {
        W(0);
        return this.f10043a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public void y(List<Boolean> list) throws B {
        int iB;
        int iB2;
        if (!(list instanceof C0486f)) {
            int iB3 = u0.b(this.f10044b);
            if (iB3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f10043a.m()));
                    if (this.f10043a.e()) {
                        return;
                    } else {
                        iB = this.f10043a.B();
                    }
                } while (iB == this.f10044b);
                this.f10046d = iB;
                return;
            }
            if (iB3 != 2) {
                throw B.d();
            }
            int iD = this.f10043a.d() + this.f10043a.C();
            do {
                list.add(Boolean.valueOf(this.f10043a.m()));
            } while (this.f10043a.d() < iD);
            V(iD);
            return;
        }
        C0486f c0486f = (C0486f) list;
        int iB4 = u0.b(this.f10044b);
        if (iB4 == 0) {
            do {
                c0486f.i(this.f10043a.m());
                if (this.f10043a.e()) {
                    return;
                } else {
                    iB2 = this.f10043a.B();
                }
            } while (iB2 == this.f10044b);
            this.f10046d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw B.d();
        }
        int iD2 = this.f10043a.d() + this.f10043a.C();
        do {
            c0486f.i(this.f10043a.m());
        } while (this.f10043a.d() < iD2);
        V(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public String z() throws B.a {
        W(2);
        return this.f10043a.z();
    }
}
