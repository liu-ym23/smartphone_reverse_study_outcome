package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.C0500u.b;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.u0;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0500u<T extends b<T>> {

    /* renamed from: d, reason: collision with root package name */
    private static final C0500u f10147d = new C0500u(true);

    /* renamed from: a, reason: collision with root package name */
    private final k0<T, Object> f10148a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f10149b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10150c;

    /* renamed from: androidx.datastore.preferences.protobuf.u$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10151a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f10152b;

        static {
            int[] iArr = new int[u0.b.values().length];
            f10152b = iArr;
            try {
                iArr[u0.b.f10157c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10152b[u0.b.f10158d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10152b[u0.b.f10159e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10152b[u0.b.f10160f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10152b[u0.b.f10161g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10152b[u0.b.f10162h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10152b[u0.b.f10163i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10152b[u0.b.f10164j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10152b[u0.b.f10166l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10152b[u0.b.f10167m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10152b[u0.b.f10165k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10152b[u0.b.f10168n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10152b[u0.b.f10169o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f10152b[u0.b.f10171q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f10152b[u0.b.f10172r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f10152b[u0.b.f10173s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f10152b[u0.b.f10174t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f10152b[u0.b.f10170p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[u0.c.values().length];
            f10151a = iArr2;
            try {
                iArr2[u0.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f10151a[u0.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f10151a[u0.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f10151a[u0.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f10151a[u0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f10151a[u0.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f10151a[u0.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f10151a[u0.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f10151a[u0.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.u$b */
    public interface b<T extends b<T>> extends Comparable<T> {
        u0.c A();

        boolean B();

        S.a D(S.a aVar, S s5);

        int a();

        boolean c();

        u0.b f();
    }

    private C0500u() {
        this.f10148a = k0.q(16);
    }

    static void A(AbstractC0491k abstractC0491k, u0.b bVar, Object obj) {
        switch (a.f10152b[bVar.ordinal()]) {
            case 1:
                abstractC0491k.r0(((Double) obj).doubleValue());
                break;
            case 2:
                abstractC0491k.z0(((Float) obj).floatValue());
                break;
            case 3:
                abstractC0491k.H0(((Long) obj).longValue());
                break;
            case 4:
                abstractC0491k.a1(((Long) obj).longValue());
                break;
            case 5:
                abstractC0491k.F0(((Integer) obj).intValue());
                break;
            case 6:
                abstractC0491k.x0(((Long) obj).longValue());
                break;
            case 7:
                abstractC0491k.v0(((Integer) obj).intValue());
                break;
            case 8:
                abstractC0491k.l0(((Boolean) obj).booleanValue());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                abstractC0491k.C0((S) obj);
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                abstractC0491k.J0((S) obj);
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                if (!(obj instanceof AbstractC0488h)) {
                    abstractC0491k.V0((String) obj);
                    break;
                } else {
                    abstractC0491k.p0((AbstractC0488h) obj);
                    break;
                }
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                if (!(obj instanceof AbstractC0488h)) {
                    abstractC0491k.m0((byte[]) obj);
                    break;
                } else {
                    abstractC0491k.p0((AbstractC0488h) obj);
                    break;
                }
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                abstractC0491k.Y0(((Integer) obj).intValue());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                abstractC0491k.N0(((Integer) obj).intValue());
                break;
            case 15:
                abstractC0491k.P0(((Long) obj).longValue());
                break;
            case 16:
                abstractC0491k.R0(((Integer) obj).intValue());
                break;
            case 17:
                abstractC0491k.T0(((Long) obj).longValue());
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                if (!(obj instanceof A.c)) {
                    abstractC0491k.t0(((Integer) obj).intValue());
                    break;
                } else {
                    abstractC0491k.t0(((A.c) obj).a());
                    break;
                }
        }
    }

    private static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    static int d(u0.b bVar, int i5, Object obj) {
        int iV = AbstractC0491k.V(i5);
        if (bVar == u0.b.f10166l) {
            iV *= 2;
        }
        return iV + e(bVar, obj);
    }

    static int e(u0.b bVar, Object obj) {
        switch (a.f10152b[bVar.ordinal()]) {
            case 1:
                return AbstractC0491k.j(((Double) obj).doubleValue());
            case 2:
                return AbstractC0491k.r(((Float) obj).floatValue());
            case 3:
                return AbstractC0491k.y(((Long) obj).longValue());
            case 4:
                return AbstractC0491k.Z(((Long) obj).longValue());
            case 5:
                return AbstractC0491k.w(((Integer) obj).intValue());
            case 6:
                return AbstractC0491k.p(((Long) obj).longValue());
            case 7:
                return AbstractC0491k.n(((Integer) obj).intValue());
            case 8:
                return AbstractC0491k.e(((Boolean) obj).booleanValue());
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return AbstractC0491k.t((S) obj);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                return obj instanceof D ? AbstractC0491k.B((D) obj) : AbstractC0491k.G((S) obj);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return obj instanceof AbstractC0488h ? AbstractC0491k.h((AbstractC0488h) obj) : AbstractC0491k.U((String) obj);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                return obj instanceof AbstractC0488h ? AbstractC0491k.h((AbstractC0488h) obj) : AbstractC0491k.f((byte[]) obj);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                return AbstractC0491k.X(((Integer) obj).intValue());
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                return AbstractC0491k.M(((Integer) obj).intValue());
            case 15:
                return AbstractC0491k.O(((Long) obj).longValue());
            case 16:
                return AbstractC0491k.Q(((Integer) obj).intValue());
            case 17:
                return AbstractC0491k.S(((Long) obj).longValue());
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                return obj instanceof A.c ? AbstractC0491k.l(((A.c) obj).a()) : AbstractC0491k.l(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b<?> bVar, Object obj) {
        u0.b bVarF = bVar.f();
        int iA = bVar.a();
        if (!bVar.c()) {
            return d(bVarF, iA, obj);
        }
        int iD = 0;
        if (bVar.B()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iD += e(bVarF, it.next());
            }
            return AbstractC0491k.V(iA) + iD + AbstractC0491k.K(iD);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iD += d(bVarF, iA, it2.next());
        }
        return iD;
    }

    public static <T extends b<T>> C0500u<T> h() {
        return f10147d;
    }

    private int k(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        return (key.A() != u0.c.MESSAGE || key.c() || key.B()) ? f(key, value) : value instanceof D ? AbstractC0491k.z(entry.getKey().a(), (D) value) : AbstractC0491k.D(entry.getKey().a(), (S) value);
    }

    static int m(u0.b bVar, boolean z5) {
        if (z5) {
            return 2;
        }
        return bVar.d();
    }

    private static <T extends b<T>> boolean q(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.A() == u0.c.MESSAGE) {
            if (key.c()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((S) it.next()).k()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof S)) {
                    if (value instanceof D) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((S) value).k()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean r(u0.b bVar, Object obj) {
        A.a(obj);
        switch (a.f10151a[bVar.b().ordinal()]) {
            case 7:
                if ((obj instanceof AbstractC0488h) || (obj instanceof byte[])) {
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof A.c)) {
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                if ((obj instanceof S) || (obj instanceof D)) {
                }
                break;
        }
        return false;
    }

    private void v(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof D) {
            value = ((D) value).f();
        }
        if (key.c()) {
            Object objI = i(key);
            if (objI == null) {
                objI = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objI).add(c(it.next()));
            }
            this.f10148a.put(key, objI);
            return;
        }
        if (key.A() != u0.c.MESSAGE) {
            this.f10148a.put(key, c(value));
            return;
        }
        Object objI2 = i(key);
        if (objI2 == null) {
            this.f10148a.put(key, c(value));
        } else {
            this.f10148a.put(key, key.D(((S) objI2).d(), (S) value).build());
        }
    }

    public static <T extends b<T>> C0500u<T> w() {
        return new C0500u<>();
    }

    private void y(u0.b bVar, Object obj) {
        if (!r(bVar, obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    static void z(AbstractC0491k abstractC0491k, u0.b bVar, int i5, Object obj) {
        if (bVar == u0.b.f10166l) {
            abstractC0491k.A0(i5, (S) obj);
        } else {
            abstractC0491k.W0(i5, m(bVar, false));
            A(abstractC0491k, bVar, obj);
        }
    }

    public void a(T t5, Object obj) {
        List arrayList;
        if (!t5.c()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        y(t5.f(), obj);
        Object objI = i(t5);
        if (objI == null) {
            arrayList = new ArrayList();
            this.f10148a.put(t5, arrayList);
        } else {
            arrayList = (List) objI;
        }
        arrayList.add(obj);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0500u<T> clone() {
        C0500u<T> c0500uW = w();
        for (int i5 = 0; i5 < this.f10148a.k(); i5++) {
            Map.Entry<K, Object> entryJ = this.f10148a.j(i5);
            c0500uW.x((b) entryJ.getKey(), entryJ.getValue());
        }
        Iterator it = this.f10148a.m().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            c0500uW.x((b) entry.getKey(), entry.getValue());
        }
        c0500uW.f10150c = this.f10150c;
        return c0500uW;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0500u) {
            return this.f10148a.equals(((C0500u) obj).f10148a);
        }
        return false;
    }

    Iterator<Map.Entry<T, Object>> g() {
        return this.f10150c ? new D.c(this.f10148a.h().iterator()) : this.f10148a.h().iterator();
    }

    public int hashCode() {
        return this.f10148a.hashCode();
    }

    public Object i(T t5) {
        Object obj = this.f10148a.get(t5);
        return obj instanceof D ? ((D) obj).f() : obj;
    }

    public int j() {
        int iK = 0;
        for (int i5 = 0; i5 < this.f10148a.k(); i5++) {
            iK += k(this.f10148a.j(i5));
        }
        Iterator it = this.f10148a.m().iterator();
        while (it.hasNext()) {
            iK += k((Map.Entry) it.next());
        }
        return iK;
    }

    public int l() {
        int iF = 0;
        for (int i5 = 0; i5 < this.f10148a.k(); i5++) {
            Map.Entry<K, Object> entryJ = this.f10148a.j(i5);
            iF += f((b) entryJ.getKey(), entryJ.getValue());
        }
        Iterator it = this.f10148a.m().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iF += f((b) entry.getKey(), entry.getValue());
        }
        return iF;
    }

    boolean n() {
        return this.f10148a.isEmpty();
    }

    public boolean o() {
        return this.f10149b;
    }

    public boolean p() {
        for (int i5 = 0; i5 < this.f10148a.k(); i5++) {
            if (!q(this.f10148a.j(i5))) {
                return false;
            }
        }
        Iterator it = this.f10148a.m().iterator();
        while (it.hasNext()) {
            if (!q((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> s() {
        return this.f10150c ? new D.c(this.f10148a.entrySet().iterator()) : this.f10148a.entrySet().iterator();
    }

    public void t() {
        if (this.f10149b) {
            return;
        }
        this.f10148a.p();
        this.f10149b = true;
    }

    public void u(C0500u<T> c0500u) {
        for (int i5 = 0; i5 < c0500u.f10148a.k(); i5++) {
            v(c0500u.f10148a.j(i5));
        }
        Iterator it = c0500u.f10148a.m().iterator();
        while (it.hasNext()) {
            v((Map.Entry) it.next());
        }
    }

    public void x(T t5, Object obj) {
        if (!t5.c()) {
            y(t5.f(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj2 = arrayList.get(i5);
                i5++;
                y(t5.f(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof D) {
            this.f10150c = true;
        }
        this.f10148a.put(t5, obj);
    }

    private C0500u(boolean z5) {
        this(k0.q(0));
        t();
    }

    private C0500u(k0<T, Object> k0Var) {
        this.f10148a = k0Var;
        t();
    }
}
