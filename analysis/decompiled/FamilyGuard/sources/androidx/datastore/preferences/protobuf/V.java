package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.AbstractC0488h;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.u0;
import androidx.datastore.preferences.protobuf.v0;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class V<T> implements h0<T> {

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f9956r = new int[0];

    /* renamed from: s, reason: collision with root package name */
    private static final Unsafe f9957s = s0.B();

    /* renamed from: a, reason: collision with root package name */
    private final int[] f9958a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f9959b;

    /* renamed from: c, reason: collision with root package name */
    private final int f9960c;

    /* renamed from: d, reason: collision with root package name */
    private final int f9961d;

    /* renamed from: e, reason: collision with root package name */
    private final S f9962e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f9963f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f9964g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f9965h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f9966i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f9967j;

    /* renamed from: k, reason: collision with root package name */
    private final int f9968k;

    /* renamed from: l, reason: collision with root package name */
    private final int f9969l;

    /* renamed from: m, reason: collision with root package name */
    private final X f9970m;

    /* renamed from: n, reason: collision with root package name */
    private final H f9971n;

    /* renamed from: o, reason: collision with root package name */
    private final o0<?, ?> f9972o;

    /* renamed from: p, reason: collision with root package name */
    private final AbstractC0497q<?> f9973p;

    /* renamed from: q, reason: collision with root package name */
    private final M f9974q;

    private V(int[] iArr, Object[] objArr, int i5, int i6, S s5, boolean z5, boolean z6, int[] iArr2, int i7, int i8, X x5, H h5, o0<?, ?> o0Var, AbstractC0497q<?> abstractC0497q, M m5) {
        this.f9958a = iArr;
        this.f9959b = objArr;
        this.f9960c = i5;
        this.f9961d = i6;
        this.f9964g = s5 instanceof AbstractC0504y;
        this.f9965h = z5;
        this.f9963f = abstractC0497q != null && abstractC0497q.e(s5);
        this.f9966i = z6;
        this.f9967j = iArr2;
        this.f9968k = i7;
        this.f9969l = i8;
        this.f9970m = x5;
        this.f9971n = h5;
        this.f9972o = o0Var;
        this.f9973p = abstractC0497q;
        this.f9962e = s5;
        this.f9974q = m5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean A(Object obj, int i5, h0 h0Var) {
        return h0Var.d(s0.A(obj, R(i5)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean B(Object obj, int i5, int i6) {
        List list = (List) s0.A(obj, R(i5));
        if (list.isEmpty()) {
            return true;
        }
        h0 h0VarS = s(i6);
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (!h0VarS.d(list.get(i7))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.datastore.preferences.protobuf.h0] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private boolean C(T t5, int i5, int i6) {
        Map<?, ?> mapH = this.f9974q.h(s0.A(t5, R(i5)));
        if (mapH.isEmpty()) {
            return true;
        }
        if (this.f9974q.c(r(i6)).f9950c.b() != u0.c.MESSAGE) {
            return true;
        }
        ?? D5 = 0;
        for (Object obj : mapH.values()) {
            D5 = D5;
            if (D5 == 0) {
                D5 = d0.a().d(obj.getClass());
            }
            if (!D5.d(obj)) {
                return false;
            }
        }
        return true;
    }

    private boolean D(T t5, T t6, int i5) {
        long jY = Y(i5) & 1048575;
        return s0.x(t5, jY) == s0.x(t6, jY);
    }

    private boolean E(T t5, int i5, int i6) {
        return s0.x(t5, (long) (Y(i6) & 1048575)) == i5;
    }

    private static boolean F(int i5) {
        return (i5 & 268435456) != 0;
    }

    private static List<?> G(Object obj, long j5) {
        return (List) s0.A(obj, j5);
    }

    private static <T> long H(T t5, long j5) {
        return s0.y(t5, j5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:334:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        r0 = r14.f9968k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0087, code lost:
    
        if (r0 >= r14.f9969l) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0089, code lost:
    
        r7 = n(r9, r14.f9967j[r0], r7, r15);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0094, code lost:
    
        if (r7 == null) goto L334;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0638 A[LOOP:3: B:197:0x0634->B:199:0x0638, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x060f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05f4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <UT, UB, ET extends androidx.datastore.preferences.protobuf.C0500u.b<ET>> void I(androidx.datastore.preferences.protobuf.o0<UT, UB> r15, androidx.datastore.preferences.protobuf.AbstractC0497q<ET> r16, T r17, androidx.datastore.preferences.protobuf.g0 r18, androidx.datastore.preferences.protobuf.C0496p r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1752
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.V.I(androidx.datastore.preferences.protobuf.o0, androidx.datastore.preferences.protobuf.q, java.lang.Object, androidx.datastore.preferences.protobuf.g0, androidx.datastore.preferences.protobuf.p):void");
    }

    private final <K, V> void J(Object obj, int i5, Object obj2, C0496p c0496p, g0 g0Var) {
        long jR = R(i0(i5));
        Object objA = s0.A(obj, jR);
        if (objA == null) {
            objA = this.f9974q.e(obj2);
            s0.O(obj, jR, objA);
        } else if (this.f9974q.g(objA)) {
            Object objE = this.f9974q.e(obj2);
            this.f9974q.a(objE, objA);
            s0.O(obj, jR, objE);
            objA = objE;
        }
        g0Var.t(this.f9974q.d(objA), this.f9974q.c(obj2), c0496p);
    }

    private void K(T t5, T t6, int i5) {
        long jR = R(i0(i5));
        if (y(t6, i5)) {
            Object objA = s0.A(t5, jR);
            Object objA2 = s0.A(t6, jR);
            if (objA != null && objA2 != null) {
                s0.O(t5, jR, A.h(objA, objA2));
                e0(t5, i5);
            } else if (objA2 != null) {
                s0.O(t5, jR, objA2);
                e0(t5, i5);
            }
        }
    }

    private void L(T t5, T t6, int i5) {
        int iI0 = i0(i5);
        int iQ = Q(i5);
        long jR = R(iI0);
        if (E(t6, iQ, i5)) {
            Object objA = s0.A(t5, jR);
            Object objA2 = s0.A(t6, jR);
            if (objA != null && objA2 != null) {
                s0.O(t5, jR, A.h(objA, objA2));
                f0(t5, iQ, i5);
            } else if (objA2 != null) {
                s0.O(t5, jR, objA2);
                f0(t5, iQ, i5);
            }
        }
    }

    private void M(T t5, T t6, int i5) {
        int iI0 = i0(i5);
        long jR = R(iI0);
        int iQ = Q(i5);
        switch (h0(iI0)) {
            case 0:
                if (y(t6, i5)) {
                    s0.K(t5, jR, s0.v(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case 1:
                if (y(t6, i5)) {
                    s0.L(t5, jR, s0.w(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case 2:
                if (y(t6, i5)) {
                    s0.N(t5, jR, s0.y(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case 3:
                if (y(t6, i5)) {
                    s0.N(t5, jR, s0.y(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case 4:
                if (y(t6, i5)) {
                    s0.M(t5, jR, s0.x(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case 5:
                if (y(t6, i5)) {
                    s0.N(t5, jR, s0.y(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case 6:
                if (y(t6, i5)) {
                    s0.M(t5, jR, s0.x(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case 7:
                if (y(t6, i5)) {
                    s0.E(t5, jR, s0.p(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case 8:
                if (y(t6, i5)) {
                    s0.O(t5, jR, s0.A(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                K(t5, t6, i5);
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                if (y(t6, i5)) {
                    s0.O(t5, jR, s0.A(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                if (y(t6, i5)) {
                    s0.M(t5, jR, s0.x(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                if (y(t6, i5)) {
                    s0.M(t5, jR, s0.x(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                if (y(t6, i5)) {
                    s0.M(t5, jR, s0.x(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                if (y(t6, i5)) {
                    s0.N(t5, jR, s0.y(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case 15:
                if (y(t6, i5)) {
                    s0.M(t5, jR, s0.x(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case 16:
                if (y(t6, i5)) {
                    s0.N(t5, jR, s0.y(t6, jR));
                    e0(t5, i5);
                    break;
                }
                break;
            case 17:
                K(t5, t6, i5);
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
            case 24:
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
            case 28:
            case 29:
            case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
            case 32:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT /* 33 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
            case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
            case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
            case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f9971n.d(t5, t6, jR);
                break;
            case 50:
                j0.F(this.f9974q, t5, t6, jR);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (E(t6, iQ, i5)) {
                    s0.O(t5, jR, s0.A(t6, jR));
                    f0(t5, iQ, i5);
                    break;
                }
                break;
            case 60:
                L(t5, t6, i5);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (E(t6, iQ, i5)) {
                    s0.O(t5, jR, s0.A(t6, jR));
                    f0(t5, iQ, i5);
                    break;
                }
                break;
            case 68:
                L(t5, t6, i5);
                break;
        }
    }

    static <T> V<T> N(Class<T> cls, P p5, X x5, H h5, o0<?, ?> o0Var, AbstractC0497q<?> abstractC0497q, M m5) {
        return p5 instanceof f0 ? P((f0) p5, x5, h5, o0Var, abstractC0497q, m5) : O((l0) p5, x5, h5, o0Var, abstractC0497q, m5);
    }

    static <T> V<T> O(l0 l0Var, X x5, H h5, o0<?, ?> o0Var, AbstractC0497q<?> abstractC0497q, M m5) {
        boolean z5 = l0Var.c() == c0.PROTO3;
        C0499t[] c0499tArrE = l0Var.e();
        if (c0499tArrE.length != 0) {
            C0499t c0499t = c0499tArrE[0];
            throw null;
        }
        int length = c0499tArrE.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        if (c0499tArrE.length > 0) {
            C0499t c0499t2 = c0499tArrE[0];
            throw null;
        }
        int[] iArrD = l0Var.d();
        if (iArrD == null) {
            iArrD = f9956r;
        }
        if (c0499tArrE.length > 0) {
            C0499t c0499t3 = c0499tArrE[0];
            throw null;
        }
        int[] iArr2 = f9956r;
        int[] iArr3 = f9956r;
        int[] iArr4 = new int[iArrD.length + iArr2.length + iArr3.length];
        System.arraycopy(iArrD, 0, iArr4, 0, iArrD.length);
        System.arraycopy(iArr2, 0, iArr4, iArrD.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, iArrD.length + iArr2.length, iArr3.length);
        return new V<>(iArr, objArr, 0, 0, l0Var.b(), z5, true, iArr4, iArrD.length, iArrD.length + iArr2.length, x5, h5, o0Var, abstractC0497q, m5);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x039f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> androidx.datastore.preferences.protobuf.V<T> P(androidx.datastore.preferences.protobuf.f0 r35, androidx.datastore.preferences.protobuf.X r36, androidx.datastore.preferences.protobuf.H r37, androidx.datastore.preferences.protobuf.o0<?, ?> r38, androidx.datastore.preferences.protobuf.AbstractC0497q<?> r39, androidx.datastore.preferences.protobuf.M r40) {
        /*
            Method dump skipped, instructions count: 1038
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.V.P(androidx.datastore.preferences.protobuf.f0, androidx.datastore.preferences.protobuf.X, androidx.datastore.preferences.protobuf.H, androidx.datastore.preferences.protobuf.o0, androidx.datastore.preferences.protobuf.q, androidx.datastore.preferences.protobuf.M):androidx.datastore.preferences.protobuf.V");
    }

    private int Q(int i5) {
        return this.f9958a[i5];
    }

    private static long R(int i5) {
        return i5 & 1048575;
    }

    private static <T> boolean S(T t5, long j5) {
        return ((Boolean) s0.A(t5, j5)).booleanValue();
    }

    private static <T> double T(T t5, long j5) {
        return ((Double) s0.A(t5, j5)).doubleValue();
    }

    private static <T> float U(T t5, long j5) {
        return ((Float) s0.A(t5, j5)).floatValue();
    }

    private static <T> int V(T t5, long j5) {
        return ((Integer) s0.A(t5, j5)).intValue();
    }

    private static <T> long W(T t5, long j5) {
        return ((Long) s0.A(t5, j5)).longValue();
    }

    private int X(int i5) {
        if (i5 < this.f9960c || i5 > this.f9961d) {
            return -1;
        }
        return g0(i5, 0);
    }

    private int Y(int i5) {
        return this.f9958a[i5 + 2];
    }

    private <E> void Z(Object obj, long j5, g0 g0Var, h0<E> h0Var, C0496p c0496p) {
        g0Var.G(this.f9971n.e(obj, j5), h0Var, c0496p);
    }

    private <E> void a0(Object obj, int i5, g0 g0Var, h0<E> h0Var, C0496p c0496p) {
        g0Var.L(this.f9971n.e(obj, R(i5)), h0Var, c0496p);
    }

    private void b0(Object obj, int i5, g0 g0Var) {
        if (x(i5)) {
            s0.O(obj, R(i5), g0Var.N());
        } else if (this.f9964g) {
            s0.O(obj, R(i5), g0Var.z());
        } else {
            s0.O(obj, R(i5), g0Var.D());
        }
    }

    private void c0(Object obj, int i5, g0 g0Var) {
        if (x(i5)) {
            g0Var.C(this.f9971n.e(obj, R(i5)));
        } else {
            g0Var.B(this.f9971n.e(obj, R(i5)));
        }
    }

    private static Field d0(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void e0(T t5, int i5) {
        if (this.f9965h) {
            return;
        }
        int iY = Y(i5);
        long j5 = iY & 1048575;
        s0.M(t5, j5, s0.x(t5, j5) | (1 << (iY >>> 20)));
    }

    private void f0(T t5, int i5, int i6) {
        s0.M(t5, Y(i6) & 1048575, i5);
    }

    private int g0(int i5, int i6) {
        int length = (this.f9958a.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int iQ = Q(i8);
            if (i5 == iQ) {
                return i8;
            }
            if (i5 < iQ) {
                length = i7 - 1;
            } else {
                i6 = i7 + 1;
            }
        }
        return -1;
    }

    private static int h0(int i5) {
        return (i5 & 267386880) >>> 20;
    }

    private int i0(int i5) {
        return this.f9958a[i5 + 1];
    }

    private boolean j(T t5, T t6, int i5) {
        return y(t5, i5) == y(t6, i5);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j0(T r19, androidx.datastore.preferences.protobuf.v0 r20) {
        /*
            Method dump skipped, instructions count: 1384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.V.j0(java.lang.Object, androidx.datastore.preferences.protobuf.v0):void");
    }

    private static <T> boolean k(T t5, long j5) {
        return s0.p(t5, j5);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void k0(T r13, androidx.datastore.preferences.protobuf.v0 r14) {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.V.k0(java.lang.Object, androidx.datastore.preferences.protobuf.v0):void");
    }

    private static <T> double l(T t5, long j5) {
        return s0.v(t5, j5);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l0(T r11, androidx.datastore.preferences.protobuf.v0 r12) {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.V.l0(java.lang.Object, androidx.datastore.preferences.protobuf.v0):void");
    }

    private boolean m(T t5, T t6, int i5) {
        int iI0 = i0(i5);
        long jR = R(iI0);
        switch (h0(iI0)) {
            case 0:
                if (!j(t5, t6, i5) || Double.doubleToLongBits(s0.v(t5, jR)) != Double.doubleToLongBits(s0.v(t6, jR))) {
                }
                break;
            case 1:
                if (!j(t5, t6, i5) || Float.floatToIntBits(s0.w(t5, jR)) != Float.floatToIntBits(s0.w(t6, jR))) {
                }
                break;
            case 2:
                if (!j(t5, t6, i5) || s0.y(t5, jR) != s0.y(t6, jR)) {
                }
                break;
            case 3:
                if (!j(t5, t6, i5) || s0.y(t5, jR) != s0.y(t6, jR)) {
                }
                break;
            case 4:
                if (!j(t5, t6, i5) || s0.x(t5, jR) != s0.x(t6, jR)) {
                }
                break;
            case 5:
                if (!j(t5, t6, i5) || s0.y(t5, jR) != s0.y(t6, jR)) {
                }
                break;
            case 6:
                if (!j(t5, t6, i5) || s0.x(t5, jR) != s0.x(t6, jR)) {
                }
                break;
            case 7:
                if (!j(t5, t6, i5) || s0.p(t5, jR) != s0.p(t6, jR)) {
                }
                break;
            case 8:
                if (!j(t5, t6, i5) || !j0.K(s0.A(t5, jR), s0.A(t6, jR))) {
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                if (!j(t5, t6, i5) || !j0.K(s0.A(t5, jR), s0.A(t6, jR))) {
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                if (!j(t5, t6, i5) || !j0.K(s0.A(t5, jR), s0.A(t6, jR))) {
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                if (!j(t5, t6, i5) || s0.x(t5, jR) != s0.x(t6, jR)) {
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                if (!j(t5, t6, i5) || s0.x(t5, jR) != s0.x(t6, jR)) {
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                if (!j(t5, t6, i5) || s0.x(t5, jR) != s0.x(t6, jR)) {
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                if (!j(t5, t6, i5) || s0.y(t5, jR) != s0.y(t6, jR)) {
                }
                break;
            case 15:
                if (!j(t5, t6, i5) || s0.x(t5, jR) != s0.x(t6, jR)) {
                }
                break;
            case 16:
                if (!j(t5, t6, i5) || s0.y(t5, jR) != s0.y(t6, jR)) {
                }
                break;
            case 17:
                if (!j(t5, t6, i5) || !j0.K(s0.A(t5, jR), s0.A(t6, jR))) {
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!D(t5, t6, i5) || !j0.K(s0.A(t5, jR), s0.A(t6, jR))) {
                }
                break;
        }
        return true;
    }

    private <K, V> void m0(v0 v0Var, int i5, Object obj, int i6) {
        if (obj != null) {
            v0Var.L(i5, this.f9974q.c(r(i6)), this.f9974q.h(obj));
        }
    }

    private final <UT, UB> UB n(Object obj, int i5, UB ub, o0<UT, UB> o0Var) {
        A.e eVarQ;
        int iQ = Q(i5);
        Object objA = s0.A(obj, R(i0(i5)));
        return (objA == null || (eVarQ = q(i5)) == null) ? ub : (UB) o(i5, iQ, this.f9974q.d(objA), eVarQ, ub, o0Var);
    }

    private void n0(int i5, Object obj, v0 v0Var) {
        if (obj instanceof String) {
            v0Var.m(i5, (String) obj);
        } else {
            v0Var.w(i5, (AbstractC0488h) obj);
        }
    }

    private final <K, V, UT, UB> UB o(int i5, int i6, Map<K, V> map, A.e eVar, UB ub, o0<UT, UB> o0Var) {
        K.a<?, ?> aVarC = this.f9974q.c(r(i5));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!eVar.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = o0Var.n();
                }
                AbstractC0488h.C0127h c0127hS = AbstractC0488h.s(K.b(aVarC, next.getKey(), next.getValue()));
                try {
                    K.e(c0127hS.b(), aVarC, next.getKey(), next.getValue());
                    o0Var.d(ub, i6, c0127hS.a());
                    it.remove();
                } catch (IOException e6) {
                    throw new RuntimeException(e6);
                }
            }
        }
        return ub;
    }

    private <UT, UB> void o0(o0<UT, UB> o0Var, T t5, v0 v0Var) {
        o0Var.t(o0Var.g(t5), v0Var);
    }

    private static <T> float p(T t5, long j5) {
        return s0.w(t5, j5);
    }

    private A.e q(int i5) {
        return (A.e) this.f9959b[((i5 / 3) * 2) + 1];
    }

    private Object r(int i5) {
        return this.f9959b[(i5 / 3) * 2];
    }

    private h0 s(int i5) {
        int i6 = (i5 / 3) * 2;
        h0 h0Var = (h0) this.f9959b[i6];
        if (h0Var != null) {
            return h0Var;
        }
        h0<T> h0VarD = d0.a().d((Class) this.f9959b[i6 + 1]);
        this.f9959b[i6] = h0VarD;
        return h0VarD;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int t(T t5) {
        int i5;
        int i6;
        int i7;
        int iD;
        boolean z5;
        int iF;
        int i8;
        int iV;
        int iX;
        Unsafe unsafe = f9957s;
        int i9 = -1;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < this.f9958a.length) {
            int iI0 = i0(i10);
            int iQ = Q(i10);
            int iH0 = h0(iI0);
            if (iH0 <= 17) {
                i5 = this.f9958a[i10 + 2];
                int i13 = 1048575 & i5;
                int i14 = 1 << (i5 >>> 20);
                if (i13 != i9) {
                    i12 = unsafe.getInt(t5, i13);
                    i9 = i13;
                }
                i6 = i14;
            } else {
                i5 = (!this.f9966i || iH0 < EnumC0501v.f10203R.b() || iH0 > EnumC0501v.f10216e0.b()) ? 0 : this.f9958a[i10 + 2] & 1048575;
                i6 = 0;
            }
            long jR = R(iI0);
            int i15 = i9;
            switch (iH0) {
                case 0:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        i7 = AbstractC0491k.i(iQ, 0.0d);
                        i11 += i7;
                        break;
                    }
                case 1:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        i7 = AbstractC0491k.q(iQ, 0.0f);
                        i11 += i7;
                        break;
                    }
                case 2:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        i7 = AbstractC0491k.x(iQ, unsafe.getLong(t5, jR));
                        i11 += i7;
                        break;
                    }
                case 3:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        i7 = AbstractC0491k.Y(iQ, unsafe.getLong(t5, jR));
                        i11 += i7;
                        break;
                    }
                case 4:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        i7 = AbstractC0491k.v(iQ, unsafe.getInt(t5, jR));
                        i11 += i7;
                        break;
                    }
                case 5:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        i7 = AbstractC0491k.o(iQ, 0L);
                        i11 += i7;
                        break;
                    }
                case 6:
                    if ((i12 & i6) != 0) {
                        i7 = AbstractC0491k.m(iQ, 0);
                        i11 += i7;
                        break;
                    }
                    break;
                case 7:
                    if ((i12 & i6) != 0) {
                        iD = AbstractC0491k.d(iQ, true);
                        i11 += iD;
                    }
                    break;
                case 8:
                    if ((i12 & i6) != 0) {
                        Object object = unsafe.getObject(t5, jR);
                        iD = object instanceof AbstractC0488h ? AbstractC0491k.g(iQ, (AbstractC0488h) object) : AbstractC0491k.T(iQ, (String) object);
                        i11 += iD;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    if ((i12 & i6) != 0) {
                        iD = j0.o(iQ, unsafe.getObject(t5, jR), s(i10));
                        i11 += iD;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    if ((i12 & i6) != 0) {
                        iD = AbstractC0491k.g(iQ, (AbstractC0488h) unsafe.getObject(t5, jR));
                        i11 += iD;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    if ((i12 & i6) != 0) {
                        iD = AbstractC0491k.W(iQ, unsafe.getInt(t5, jR));
                        i11 += iD;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    if ((i12 & i6) != 0) {
                        iD = AbstractC0491k.k(iQ, unsafe.getInt(t5, jR));
                        i11 += iD;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    if ((i12 & i6) != 0) {
                        iD = AbstractC0491k.L(iQ, 0);
                        i11 += iD;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    if ((i12 & i6) != 0) {
                        iD = AbstractC0491k.N(iQ, 0L);
                        i11 += iD;
                    }
                    break;
                case 15:
                    if ((i12 & i6) != 0) {
                        iD = AbstractC0491k.P(iQ, unsafe.getInt(t5, jR));
                        i11 += iD;
                    }
                    break;
                case 16:
                    if ((i12 & i6) != 0) {
                        iD = AbstractC0491k.R(iQ, unsafe.getLong(t5, jR));
                        i11 += iD;
                    }
                    break;
                case 17:
                    if ((i12 & i6) != 0) {
                        iD = AbstractC0491k.s(iQ, (S) unsafe.getObject(t5, jR), s(i10));
                        i11 += iD;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                    iD = j0.h(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iD;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                    z5 = false;
                    iF = j0.f(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                    z5 = false;
                    iF = j0.m(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                    z5 = false;
                    iF = j0.x(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                    z5 = false;
                    iF = j0.k(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                    z5 = false;
                    iF = j0.h(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case 24:
                    z5 = false;
                    iF = j0.f(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                    z5 = false;
                    iF = j0.a(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                    iD = j0.u(iQ, (List) unsafe.getObject(t5, jR));
                    i11 += iD;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                    iD = j0.p(iQ, (List) unsafe.getObject(t5, jR), s(i10));
                    i11 += iD;
                    break;
                case 28:
                    iD = j0.c(iQ, (List) unsafe.getObject(t5, jR));
                    i11 += iD;
                    break;
                case 29:
                    iD = j0.v(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iD;
                    break;
                case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                    z5 = false;
                    iF = j0.d(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                    z5 = false;
                    iF = j0.f(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case 32:
                    z5 = false;
                    iF = j0.h(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT /* 33 */:
                    z5 = false;
                    iF = j0.q(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                    z5 = false;
                    iF = j0.s(iQ, (List) unsafe.getObject(t5, jR), false);
                    i11 += iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                    i8 = j0.i((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                    i8 = j0.g((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                    i8 = j0.n((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                    i8 = j0.y((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                    i8 = j0.l((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                    i8 = j0.i((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                    i8 = j0.g((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
                    i8 = j0.b((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case 43:
                    i8 = j0.w((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case 44:
                    i8 = j0.e((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case 45:
                    i8 = j0.g((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case 46:
                    i8 = j0.i((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case 47:
                    i8 = j0.r((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case 48:
                    i8 = j0.t((List) unsafe.getObject(t5, jR));
                    if (i8 > 0) {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i5, i8);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i8);
                        i11 += iV + iX + i8;
                    }
                    break;
                case 49:
                    iD = j0.j(iQ, (List) unsafe.getObject(t5, jR), s(i10));
                    i11 += iD;
                    break;
                case 50:
                    iD = this.f9974q.f(iQ, unsafe.getObject(t5, jR), r(i10));
                    i11 += iD;
                    break;
                case 51:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.i(iQ, 0.0d);
                        i11 += iD;
                    }
                    break;
                case 52:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.q(iQ, 0.0f);
                        i11 += iD;
                    }
                    break;
                case 53:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.x(iQ, W(t5, jR));
                        i11 += iD;
                    }
                    break;
                case 54:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.Y(iQ, W(t5, jR));
                        i11 += iD;
                    }
                    break;
                case 55:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.v(iQ, V(t5, jR));
                        i11 += iD;
                    }
                    break;
                case 56:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.o(iQ, 0L);
                        i11 += iD;
                    }
                    break;
                case 57:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.m(iQ, 0);
                        i11 += iD;
                    }
                    break;
                case 58:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.d(iQ, true);
                        i11 += iD;
                    }
                    break;
                case 59:
                    if (E(t5, iQ, i10)) {
                        Object object2 = unsafe.getObject(t5, jR);
                        iD = object2 instanceof AbstractC0488h ? AbstractC0491k.g(iQ, (AbstractC0488h) object2) : AbstractC0491k.T(iQ, (String) object2);
                        i11 += iD;
                    }
                    break;
                case 60:
                    if (E(t5, iQ, i10)) {
                        iD = j0.o(iQ, unsafe.getObject(t5, jR), s(i10));
                        i11 += iD;
                    }
                    break;
                case 61:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.g(iQ, (AbstractC0488h) unsafe.getObject(t5, jR));
                        i11 += iD;
                    }
                    break;
                case 62:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.W(iQ, V(t5, jR));
                        i11 += iD;
                    }
                    break;
                case 63:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.k(iQ, V(t5, jR));
                        i11 += iD;
                    }
                    break;
                case 64:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.L(iQ, 0);
                        i11 += iD;
                    }
                    break;
                case 65:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.N(iQ, 0L);
                        i11 += iD;
                    }
                    break;
                case 66:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.P(iQ, V(t5, jR));
                        i11 += iD;
                    }
                    break;
                case 67:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.R(iQ, W(t5, jR));
                        i11 += iD;
                    }
                    break;
                case 68:
                    if (E(t5, iQ, i10)) {
                        iD = AbstractC0491k.s(iQ, (S) unsafe.getObject(t5, jR), s(i10));
                        i11 += iD;
                    }
                    break;
            }
            i10 += 3;
            i9 = i15;
        }
        int iV2 = i11 + v(this.f9972o, t5);
        return this.f9963f ? iV2 + this.f9973p.c(t5).l() : iV2;
    }

    private int u(T t5) {
        int i5;
        int i6;
        int iV;
        int iX;
        Unsafe unsafe = f9957s;
        int i7 = 0;
        for (int i8 = 0; i8 < this.f9958a.length; i8 += 3) {
            int iI0 = i0(i8);
            int iH0 = h0(iI0);
            int iQ = Q(i8);
            long jR = R(iI0);
            int i9 = (iH0 < EnumC0501v.f10203R.b() || iH0 > EnumC0501v.f10216e0.b()) ? 0 : this.f9958a[i8 + 2] & 1048575;
            switch (iH0) {
                case 0:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.i(iQ, 0.0d);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.q(iQ, 0.0f);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.x(iQ, s0.y(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.Y(iQ, s0.y(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.v(iQ, s0.x(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.o(iQ, 0L);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.m(iQ, 0);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.d(iQ, true);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (y(t5, i8)) {
                        Object objA = s0.A(t5, jR);
                        i5 = objA instanceof AbstractC0488h ? AbstractC0491k.g(iQ, (AbstractC0488h) objA) : AbstractC0491k.T(iQ, (String) objA);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    if (y(t5, i8)) {
                        i5 = j0.o(iQ, s0.A(t5, jR), s(i8));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.g(iQ, (AbstractC0488h) s0.A(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.W(iQ, s0.x(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.k(iQ, s0.x(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.L(iQ, 0);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.N(iQ, 0L);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.P(iQ, s0.x(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.R(iQ, s0.y(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (y(t5, i8)) {
                        i5 = AbstractC0491k.s(iQ, (S) s0.A(t5, jR), s(i8));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                    i5 = j0.h(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                    i5 = j0.f(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                    i5 = j0.m(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                    i5 = j0.x(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                    i5 = j0.k(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                    i5 = j0.h(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case 24:
                    i5 = j0.f(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                    i5 = j0.a(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                    i5 = j0.u(iQ, G(t5, jR));
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                    i5 = j0.p(iQ, G(t5, jR), s(i8));
                    i7 += i5;
                    break;
                case 28:
                    i5 = j0.c(iQ, G(t5, jR));
                    i7 += i5;
                    break;
                case 29:
                    i5 = j0.v(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                    i5 = j0.d(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                    i5 = j0.f(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case 32:
                    i5 = j0.h(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT /* 33 */:
                    i5 = j0.q(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                    i5 = j0.s(iQ, G(t5, jR), false);
                    i7 += i5;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                    i6 = j0.i((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                    i6 = j0.g((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                    i6 = j0.n((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                    i6 = j0.y((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                    i6 = j0.l((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                    i6 = j0.i((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                    i6 = j0.g((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
                    i6 = j0.b((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case 43:
                    i6 = j0.w((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case 44:
                    i6 = j0.e((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case 45:
                    i6 = j0.g((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case 46:
                    i6 = j0.i((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case 47:
                    i6 = j0.r((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case 48:
                    i6 = j0.t((List) unsafe.getObject(t5, jR));
                    if (i6 <= 0) {
                        break;
                    } else {
                        if (this.f9966i) {
                            unsafe.putInt(t5, i9, i6);
                        }
                        iV = AbstractC0491k.V(iQ);
                        iX = AbstractC0491k.X(i6);
                        i5 = iV + iX + i6;
                        i7 += i5;
                        break;
                    }
                case 49:
                    i5 = j0.j(iQ, G(t5, jR), s(i8));
                    i7 += i5;
                    break;
                case 50:
                    i5 = this.f9974q.f(iQ, s0.A(t5, jR), r(i8));
                    i7 += i5;
                    break;
                case 51:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.i(iQ, 0.0d);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.q(iQ, 0.0f);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.x(iQ, W(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.Y(iQ, W(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.v(iQ, V(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.o(iQ, 0L);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.m(iQ, 0);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.d(iQ, true);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (E(t5, iQ, i8)) {
                        Object objA2 = s0.A(t5, jR);
                        i5 = objA2 instanceof AbstractC0488h ? AbstractC0491k.g(iQ, (AbstractC0488h) objA2) : AbstractC0491k.T(iQ, (String) objA2);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (E(t5, iQ, i8)) {
                        i5 = j0.o(iQ, s0.A(t5, jR), s(i8));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.g(iQ, (AbstractC0488h) s0.A(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.W(iQ, V(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.k(iQ, V(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.L(iQ, 0);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.N(iQ, 0L);
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.P(iQ, V(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.R(iQ, W(t5, jR));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (E(t5, iQ, i8)) {
                        i5 = AbstractC0491k.s(iQ, (S) s0.A(t5, jR), s(i8));
                        i7 += i5;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i7 + v(this.f9972o, t5);
    }

    private <UT, UB> int v(o0<UT, UB> o0Var, T t5) {
        return o0Var.h(o0Var.g(t5));
    }

    private static <T> int w(T t5, long j5) {
        return s0.x(t5, j5);
    }

    private static boolean x(int i5) {
        return (i5 & 536870912) != 0;
    }

    private boolean y(T t5, int i5) {
        boolean zEquals;
        if (!this.f9965h) {
            int iY = Y(i5);
            return (s0.x(t5, (long) (iY & 1048575)) & (1 << (iY >>> 20))) != 0;
        }
        int iI0 = i0(i5);
        long jR = R(iI0);
        switch (h0(iI0)) {
            case 0:
                return s0.v(t5, jR) != 0.0d;
            case 1:
                return s0.w(t5, jR) != 0.0f;
            case 2:
                return s0.y(t5, jR) != 0;
            case 3:
                return s0.y(t5, jR) != 0;
            case 4:
                return s0.x(t5, jR) != 0;
            case 5:
                return s0.y(t5, jR) != 0;
            case 6:
                return s0.x(t5, jR) != 0;
            case 7:
                return s0.p(t5, jR);
            case 8:
                Object objA = s0.A(t5, jR);
                if (objA instanceof String) {
                    zEquals = ((String) objA).isEmpty();
                    break;
                } else {
                    if (!(objA instanceof AbstractC0488h)) {
                        throw new IllegalArgumentException();
                    }
                    zEquals = AbstractC0488h.f10009b.equals(objA);
                    break;
                }
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return s0.A(t5, jR) != null;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                zEquals = AbstractC0488h.f10009b.equals(s0.A(t5, jR));
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return s0.x(t5, jR) != 0;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                return s0.x(t5, jR) != 0;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                return s0.x(t5, jR) != 0;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                return s0.y(t5, jR) != 0;
            case 15:
                return s0.x(t5, jR) != 0;
            case 16:
                return s0.y(t5, jR) != 0;
            case 17:
                return s0.A(t5, jR) != null;
            default:
                throw new IllegalArgumentException();
        }
        return !zEquals;
    }

    private boolean z(T t5, int i5, int i6, int i7) {
        return this.f9965h ? y(t5, i5) : (i6 & i7) != 0;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void a(T t5, T t6) {
        t6.getClass();
        for (int i5 = 0; i5 < this.f9958a.length; i5 += 3) {
            M(t5, t6, i5);
        }
        if (this.f9965h) {
            return;
        }
        j0.G(this.f9972o, t5, t6);
        if (this.f9963f) {
            j0.E(this.f9973p, t5, t6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void b(T t5, g0 g0Var, C0496p c0496p) throws Throwable {
        c0496p.getClass();
        I(this.f9972o, this.f9973p, t5, g0Var, c0496p);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void c(T t5) {
        int i5;
        int i6 = this.f9968k;
        while (true) {
            i5 = this.f9969l;
            if (i6 >= i5) {
                break;
            }
            long jR = R(i0(this.f9967j[i6]));
            Object objA = s0.A(t5, jR);
            if (objA != null) {
                s0.O(t5, jR, this.f9974q.b(objA));
            }
            i6++;
        }
        int length = this.f9967j.length;
        while (i5 < length) {
            this.f9971n.c(t5, this.f9967j[i5]);
            i5++;
        }
        this.f9972o.j(t5);
        if (this.f9963f) {
            this.f9973p.f(t5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    @Override // androidx.datastore.preferences.protobuf.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(T r13) {
        /*
            r12 = this;
            r0 = -1
            r1 = 0
            r2 = r1
            r3 = r2
        L4:
            int r4 = r12.f9968k
            r5 = 1
            if (r2 >= r4) goto L94
            int[] r4 = r12.f9967j
            r4 = r4[r2]
            int r6 = r12.Q(r4)
            int r7 = r12.i0(r4)
            boolean r8 = r12.f9965h
            if (r8 != 0) goto L31
            int[] r8 = r12.f9958a
            int r9 = r4 + 2
            r8 = r8[r9]
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r8
            int r8 = r8 >>> 20
            int r5 = r5 << r8
            if (r9 == r0) goto L32
            sun.misc.Unsafe r0 = androidx.datastore.preferences.protobuf.V.f9957s
            long r10 = (long) r9
            int r3 = r0.getInt(r13, r10)
            r0 = r9
            goto L32
        L31:
            r5 = r1
        L32:
            boolean r8 = F(r7)
            if (r8 == 0) goto L3f
            boolean r8 = r12.z(r13, r4, r3, r5)
            if (r8 != 0) goto L3f
            return r1
        L3f:
            int r8 = h0(r7)
            r9 = 9
            if (r8 == r9) goto L7f
            r9 = 17
            if (r8 == r9) goto L7f
            r5 = 27
            if (r8 == r5) goto L78
            r5 = 60
            if (r8 == r5) goto L67
            r5 = 68
            if (r8 == r5) goto L67
            r5 = 49
            if (r8 == r5) goto L78
            r5 = 50
            if (r8 == r5) goto L60
            goto L90
        L60:
            boolean r4 = r12.C(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L67:
            boolean r5 = r12.E(r13, r6, r4)
            if (r5 == 0) goto L90
            androidx.datastore.preferences.protobuf.h0 r4 = r12.s(r4)
            boolean r4 = A(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L78:
            boolean r4 = r12.B(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L7f:
            boolean r5 = r12.z(r13, r4, r3, r5)
            if (r5 == 0) goto L90
            androidx.datastore.preferences.protobuf.h0 r4 = r12.s(r4)
            boolean r4 = A(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L90:
            int r2 = r2 + 1
            goto L4
        L94:
            boolean r0 = r12.f9963f
            if (r0 == 0) goto La5
            androidx.datastore.preferences.protobuf.q<?> r12 = r12.f9973p
            androidx.datastore.preferences.protobuf.u r12 = r12.c(r13)
            boolean r12 = r12.p()
            if (r12 != 0) goto La5
            return r1
        La5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.V.d(java.lang.Object):boolean");
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public void e(T t5, v0 v0Var) {
        if (v0Var.i() == v0.a.DESCENDING) {
            l0(t5, v0Var);
        } else if (this.f9965h) {
            k0(t5, v0Var);
        } else {
            j0(t5, v0Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public boolean f(T t5, T t6) {
        int length = this.f9958a.length;
        for (int i5 = 0; i5 < length; i5 += 3) {
            if (!m(t5, t6, i5)) {
                return false;
            }
        }
        if (!this.f9972o.g(t5).equals(this.f9972o.g(t6))) {
            return false;
        }
        if (this.f9963f) {
            return this.f9973p.c(t5).equals(this.f9973p.c(t6));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public int g(T t5) {
        return this.f9965h ? u(t5) : t(t5);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public T h() {
        return (T) this.f9970m.a(this.f9962e);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public int i(T t5) {
        int i5;
        int iF;
        int length = this.f9958a.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7 += 3) {
            int iI0 = i0(i7);
            int iQ = Q(i7);
            long jR = R(iI0);
            int iHashCode = 37;
            switch (h0(iI0)) {
                case 0:
                    i5 = i6 * 53;
                    iF = A.f(Double.doubleToLongBits(s0.v(t5, jR)));
                    i6 = i5 + iF;
                    break;
                case 1:
                    i5 = i6 * 53;
                    iF = Float.floatToIntBits(s0.w(t5, jR));
                    i6 = i5 + iF;
                    break;
                case 2:
                    i5 = i6 * 53;
                    iF = A.f(s0.y(t5, jR));
                    i6 = i5 + iF;
                    break;
                case 3:
                    i5 = i6 * 53;
                    iF = A.f(s0.y(t5, jR));
                    i6 = i5 + iF;
                    break;
                case 4:
                    i5 = i6 * 53;
                    iF = s0.x(t5, jR);
                    i6 = i5 + iF;
                    break;
                case 5:
                    i5 = i6 * 53;
                    iF = A.f(s0.y(t5, jR));
                    i6 = i5 + iF;
                    break;
                case 6:
                    i5 = i6 * 53;
                    iF = s0.x(t5, jR);
                    i6 = i5 + iF;
                    break;
                case 7:
                    i5 = i6 * 53;
                    iF = A.c(s0.p(t5, jR));
                    i6 = i5 + iF;
                    break;
                case 8:
                    i5 = i6 * 53;
                    iF = ((String) s0.A(t5, jR)).hashCode();
                    i6 = i5 + iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    Object objA = s0.A(t5, jR);
                    if (objA != null) {
                        iHashCode = objA.hashCode();
                    }
                    i6 = (i6 * 53) + iHashCode;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    i5 = i6 * 53;
                    iF = s0.A(t5, jR).hashCode();
                    i6 = i5 + iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    i5 = i6 * 53;
                    iF = s0.x(t5, jR);
                    i6 = i5 + iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    i5 = i6 * 53;
                    iF = s0.x(t5, jR);
                    i6 = i5 + iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    i5 = i6 * 53;
                    iF = s0.x(t5, jR);
                    i6 = i5 + iF;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    i5 = i6 * 53;
                    iF = A.f(s0.y(t5, jR));
                    i6 = i5 + iF;
                    break;
                case 15:
                    i5 = i6 * 53;
                    iF = s0.x(t5, jR);
                    i6 = i5 + iF;
                    break;
                case 16:
                    i5 = i6 * 53;
                    iF = A.f(s0.y(t5, jR));
                    i6 = i5 + iF;
                    break;
                case 17:
                    Object objA2 = s0.A(t5, jR);
                    if (objA2 != null) {
                        iHashCode = objA2.hashCode();
                    }
                    i6 = (i6 * 53) + iHashCode;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                case 24:
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                case 28:
                case 29:
                case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                case 32:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT /* 33 */:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i5 = i6 * 53;
                    iF = s0.A(t5, jR).hashCode();
                    i6 = i5 + iF;
                    break;
                case 50:
                    i5 = i6 * 53;
                    iF = s0.A(t5, jR).hashCode();
                    i6 = i5 + iF;
                    break;
                case 51:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = A.f(Double.doubleToLongBits(T(t5, jR)));
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = Float.floatToIntBits(U(t5, jR));
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = A.f(W(t5, jR));
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = A.f(W(t5, jR));
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = V(t5, jR);
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = A.f(W(t5, jR));
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = V(t5, jR);
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = A.c(S(t5, jR));
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = ((String) s0.A(t5, jR)).hashCode();
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = s0.A(t5, jR).hashCode();
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = s0.A(t5, jR).hashCode();
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = V(t5, jR);
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = V(t5, jR);
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = V(t5, jR);
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = A.f(W(t5, jR));
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = V(t5, jR);
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = A.f(W(t5, jR));
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (E(t5, iQ, i7)) {
                        i5 = i6 * 53;
                        iF = s0.A(t5, jR).hashCode();
                        i6 = i5 + iF;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i6 * 53) + this.f9972o.g(t5).hashCode();
        return this.f9963f ? (iHashCode2 * 53) + this.f9973p.c(t5).hashCode() : iHashCode2;
    }
}
