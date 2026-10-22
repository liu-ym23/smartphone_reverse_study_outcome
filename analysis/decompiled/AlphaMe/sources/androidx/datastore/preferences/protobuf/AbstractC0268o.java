package androidx.datastore.preferences.protobuf;

import d.C0527a;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: androidx.datastore.preferences.protobuf.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0268o extends X {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f3518d = Logger.getLogger(AbstractC0268o.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f3519e = z0.f3560f;

    /* renamed from: c, reason: collision with root package name */
    public C0527a f3520c;

    public static int A(int i4, String str) {
        return B(str) + C(i4);
    }

    public static int B(String str) {
        int length;
        try {
            length = C0.b(str);
        } catch (B0 unused) {
            length = str.getBytes(D.f3396a).length;
        }
        return E(length) + length;
    }

    public static int C(int i4) {
        return E(i4 << 3);
    }

    public static int D(int i4, int i5) {
        return E(i5) + C(i4);
    }

    public static int E(int i4) {
        if ((i4 & (-128)) == 0) {
            return 1;
        }
        if ((i4 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i4) == 0) {
            return 3;
        }
        return (i4 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int F(int i4, long j4) {
        return G(j4) + C(i4);
    }

    public static int G(long j4) {
        int i4;
        if (((-128) & j4) == 0) {
            return 1;
        }
        if (j4 < 0) {
            return 10;
        }
        if (((-34359738368L) & j4) != 0) {
            j4 >>>= 28;
            i4 = 6;
        } else {
            i4 = 2;
        }
        if (((-2097152) & j4) != 0) {
            i4 += 2;
            j4 >>>= 14;
        }
        return (j4 & (-16384)) != 0 ? i4 + 1 : i4;
    }

    public static int k(int i4) {
        return C(i4) + 1;
    }

    public static int l(int i4, AbstractC0259h abstractC0259h) {
        return m(abstractC0259h) + C(i4);
    }

    public static int m(AbstractC0259h abstractC0259h) {
        int size = abstractC0259h.size();
        return E(size) + size;
    }

    public static int n(int i4) {
        return C(i4) + 8;
    }

    public static int o(int i4, int i5) {
        return u(i5) + C(i4);
    }

    public static int p(int i4) {
        return C(i4) + 4;
    }

    public static int q(int i4) {
        return C(i4) + 8;
    }

    public static int r(int i4) {
        return C(i4) + 4;
    }

    public static int s(int i4, AbstractC0247b abstractC0247b, InterfaceC0262i0 interfaceC0262i0) {
        return abstractC0247b.b(interfaceC0262i0) + (C(i4) * 2);
    }

    public static int t(int i4, int i5) {
        return u(i5) + C(i4);
    }

    public static int u(int i4) {
        if (i4 >= 0) {
            return E(i4);
        }
        return 10;
    }

    public static int v(int i4, long j4) {
        return G(j4) + C(i4);
    }

    public static int w(int i4) {
        return C(i4) + 4;
    }

    public static int x(int i4) {
        return C(i4) + 8;
    }

    public static int y(int i4, int i5) {
        return E((i5 >> 31) ^ (i5 << 1)) + C(i4);
    }

    public static int z(int i4, long j4) {
        return G((j4 >> 63) ^ (j4 << 1)) + C(i4);
    }

    public final void H(String str, B0 b02) throws C0266m {
        f3518d.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) b02);
        byte[] bytes = str.getBytes(D.f3396a);
        try {
            Z(bytes.length);
            j(0, bytes.length, bytes);
        } catch (C0266m e4) {
            throw e4;
        } catch (IndexOutOfBoundsException e5) {
            throw new C0266m(e5);
        }
    }

    public abstract void I(byte b4);

    public abstract void J(int i4, boolean z4);

    public abstract void K(int i4, byte[] bArr);

    public abstract void L(int i4, AbstractC0259h abstractC0259h);

    public abstract void M(AbstractC0259h abstractC0259h);

    public abstract void N(int i4, int i5);

    public abstract void O(int i4);

    public abstract void P(int i4, long j4);

    public abstract void Q(long j4);

    public abstract void R(int i4, int i5);

    public abstract void S(int i4);

    public abstract void T(int i4, AbstractC0247b abstractC0247b, InterfaceC0262i0 interfaceC0262i0);

    public abstract void U(AbstractC0247b abstractC0247b);

    public abstract void V(int i4, String str);

    public abstract void W(String str);

    public abstract void X(int i4, int i5);

    public abstract void Y(int i4, int i5);

    public abstract void Z(int i4);

    public abstract void a0(int i4, long j4);

    public abstract void b0(long j4);
}
