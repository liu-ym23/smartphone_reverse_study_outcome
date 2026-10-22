package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.v0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: f, reason: collision with root package name */
    private static final p0 f10106f = new p0(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    private int f10107a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f10108b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f10109c;

    /* renamed from: d, reason: collision with root package name */
    private int f10110d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10111e;

    private p0() {
        this(0, new int[8], new Object[8], true);
    }

    private void b() {
        int i5 = this.f10107a;
        int[] iArr = this.f10108b;
        if (i5 == iArr.length) {
            int i6 = i5 + (i5 < 4 ? 8 : i5 >> 1);
            this.f10108b = Arrays.copyOf(iArr, i6);
            this.f10109c = Arrays.copyOf(this.f10109c, i6);
        }
    }

    private static boolean c(int[] iArr, int[] iArr2, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (iArr[i6] != iArr2[i6]) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(Object[] objArr, Object[] objArr2, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (!objArr[i6].equals(objArr2[i6])) {
                return false;
            }
        }
        return true;
    }

    public static p0 e() {
        return f10106f;
    }

    private static int h(int[] iArr, int i5) {
        int i6 = 17;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 = (i6 * 31) + iArr[i7];
        }
        return i6;
    }

    private static int i(Object[] objArr, int i5) {
        int iHashCode = 17;
        for (int i6 = 0; i6 < i5; i6++) {
            iHashCode = (iHashCode * 31) + objArr[i6].hashCode();
        }
        return iHashCode;
    }

    static p0 k(p0 p0Var, p0 p0Var2) {
        int i5 = p0Var.f10107a + p0Var2.f10107a;
        int[] iArrCopyOf = Arrays.copyOf(p0Var.f10108b, i5);
        System.arraycopy(p0Var2.f10108b, 0, iArrCopyOf, p0Var.f10107a, p0Var2.f10107a);
        Object[] objArrCopyOf = Arrays.copyOf(p0Var.f10109c, i5);
        System.arraycopy(p0Var2.f10109c, 0, objArrCopyOf, p0Var.f10107a, p0Var2.f10107a);
        return new p0(i5, iArrCopyOf, objArrCopyOf, true);
    }

    static p0 l() {
        return new p0();
    }

    private static void p(int i5, Object obj, v0 v0Var) {
        int iA = u0.a(i5);
        int iB = u0.b(i5);
        if (iB == 0) {
            v0Var.p(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            v0Var.h(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            v0Var.w(iA, (AbstractC0488h) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(B.d());
            }
            v0Var.d(iA, ((Integer) obj).intValue());
        } else if (v0Var.i() == v0.a.ASCENDING) {
            v0Var.s(iA);
            ((p0) obj).q(v0Var);
            v0Var.F(iA);
        } else {
            v0Var.F(iA);
            ((p0) obj).q(v0Var);
            v0Var.s(iA);
        }
    }

    void a() {
        if (!this.f10111e) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        int i5 = this.f10107a;
        return i5 == p0Var.f10107a && c(this.f10108b, p0Var.f10108b, i5) && d(this.f10109c, p0Var.f10109c, this.f10107a);
    }

    public int f() {
        int iY;
        int i5 = this.f10110d;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f10107a; i7++) {
            int i8 = this.f10108b[i7];
            int iA = u0.a(i8);
            int iB = u0.b(i8);
            if (iB == 0) {
                iY = AbstractC0491k.Y(iA, ((Long) this.f10109c[i7]).longValue());
            } else if (iB == 1) {
                iY = AbstractC0491k.o(iA, ((Long) this.f10109c[i7]).longValue());
            } else if (iB == 2) {
                iY = AbstractC0491k.g(iA, (AbstractC0488h) this.f10109c[i7]);
            } else if (iB == 3) {
                iY = (AbstractC0491k.V(iA) * 2) + ((p0) this.f10109c[i7]).f();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(B.d());
                }
                iY = AbstractC0491k.m(iA, ((Integer) this.f10109c[i7]).intValue());
            }
            i6 += iY;
        }
        this.f10110d = i6;
        return i6;
    }

    public int g() {
        int i5 = this.f10110d;
        if (i5 != -1) {
            return i5;
        }
        int iJ = 0;
        for (int i6 = 0; i6 < this.f10107a; i6++) {
            iJ += AbstractC0491k.J(u0.a(this.f10108b[i6]), (AbstractC0488h) this.f10109c[i6]);
        }
        this.f10110d = iJ;
        return iJ;
    }

    public int hashCode() {
        int i5 = this.f10107a;
        return ((((527 + i5) * 31) + h(this.f10108b, i5)) * 31) + i(this.f10109c, this.f10107a);
    }

    public void j() {
        this.f10111e = false;
    }

    final void m(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < this.f10107a; i6++) {
            U.c(sb, i5, String.valueOf(u0.a(this.f10108b[i6])), this.f10109c[i6]);
        }
    }

    void n(int i5, Object obj) {
        a();
        b();
        int[] iArr = this.f10108b;
        int i6 = this.f10107a;
        iArr[i6] = i5;
        this.f10109c[i6] = obj;
        this.f10107a = i6 + 1;
    }

    void o(v0 v0Var) {
        if (v0Var.i() == v0.a.DESCENDING) {
            for (int i5 = this.f10107a - 1; i5 >= 0; i5--) {
                v0Var.c(u0.a(this.f10108b[i5]), this.f10109c[i5]);
            }
            return;
        }
        for (int i6 = 0; i6 < this.f10107a; i6++) {
            v0Var.c(u0.a(this.f10108b[i6]), this.f10109c[i6]);
        }
    }

    public void q(v0 v0Var) {
        if (this.f10107a == 0) {
            return;
        }
        if (v0Var.i() == v0.a.ASCENDING) {
            for (int i5 = 0; i5 < this.f10107a; i5++) {
                p(this.f10108b[i5], this.f10109c[i5], v0Var);
            }
            return;
        }
        for (int i6 = this.f10107a - 1; i6 >= 0; i6--) {
            p(this.f10108b[i6], this.f10109c[i6], v0Var);
        }
    }

    private p0(int i5, int[] iArr, Object[] objArr, boolean z5) {
        this.f10110d = -1;
        this.f10107a = i5;
        this.f10108b = iArr;
        this.f10109c = objArr;
        this.f10111e = z5;
    }
}
