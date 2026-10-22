package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.A0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class F0<MessageType extends F0<MessageType, BuilderType>, BuilderType extends A0<MessageType, BuilderType>> extends T<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected N1 zzc = N1.c();

    public static final boolean B(F0 f02, boolean z10) {
        byte bByteValue = ((Byte) f02.F(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zH = C1752p1.a().b(f02.getClass()).h(f02);
        if (z10) {
            f02.F(2, true != zH ? null : f02, null);
        }
        return zH;
    }

    public static F0 E(F0 f02, byte[] bArr, int i10, int i11, C1758r0 c1758r0) throws zzer {
        if (i11 == 0) {
            return f02;
        }
        F0 f0O = f02.o();
        try {
            InterfaceC1791z1 interfaceC1791z1B = C1752p1.a().b(f0O.getClass());
            interfaceC1791z1B.g(f0O, bArr, 0, i11, new X(c1758r0));
            interfaceC1791z1B.a(f0O);
            return f0O;
        } catch (zzer e10) {
            throw e10;
        } catch (zzgr e11) {
            throw e11.a();
        } catch (IOException e12) {
            if (e12.getCause() instanceof zzer) {
                throw ((zzer) e12.getCause());
            }
            throw new zzer(e12);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static E0 m(InterfaceC1720h1 interfaceC1720h1, Object obj, InterfaceC1720h1 interfaceC1720h12, I0 i02, int i10, zzhf zzhfVar, Class cls) {
        return new E0(interfaceC1720h1, obj, interfaceC1720h12, new D0(null, i10, zzhfVar, false, false), cls);
    }

    public static F0 n(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        F0 f02 = (F0) map.get(cls);
        if (f02 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                f02 = (F0) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (f02 != null) {
            return f02;
        }
        F0 f03 = (F0) ((F0) T1.j(cls)).F(6, null, null);
        if (f03 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, f03);
        return f03;
    }

    public static F0 p(F0 f02, byte[] bArr, C1758r0 c1758r0) throws zzer {
        F0 f0E = E(f02, bArr, 0, bArr.length, c1758r0);
        if (f0E == null || B(f0E, true)) {
            return f0E;
        }
        throw new zzgr(f0E).a();
    }

    public static K0 q() {
        return C1782x0.e();
    }

    public static K0 r(K0 k02) {
        int size = k02.size();
        return k02.g(size == 0 ? 10 : size + size);
    }

    public static L0 s() {
        return G0.e();
    }

    public static M0 t() {
        return C1756q1.c();
    }

    public static M0 u(M0 m02) {
        int size = m02.size();
        return m02.g(size == 0 ? 10 : size + size);
    }

    public static Object v(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object w(InterfaceC1720h1 interfaceC1720h1, String str, Object[] objArr) {
        return new C1759r1(interfaceC1720h1, str, objArr);
    }

    public static void z(Class cls, F0 f02) {
        f02.y();
        zzb.put(cls, f02);
    }

    public final void A(int i10) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean C() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final int D(InterfaceC1791z1 interfaceC1791z1) {
        return C1752p1.a().b(getClass()).d(this);
    }

    public abstract Object F(int i10, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1720h1
    public final int a() {
        if (C()) {
            int iD = D(null);
            if (iD >= 0) {
                return iD;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iD);
        }
        int i10 = this.zzd & Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int iD2 = D(null);
        if (iD2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iD2;
            return iD2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iD2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.T
    public final int b(InterfaceC1791z1 interfaceC1791z1) {
        if (C()) {
            int iD = interfaceC1791z1.d(this);
            if (iD >= 0) {
                return iD;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iD);
        }
        int i10 = this.zzd & Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int iD2 = interfaceC1791z1.d(this);
        if (iD2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iD2;
            return iD2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iD2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1720h1
    public final void d(AbstractC1739m0 abstractC1739m0) throws IOException {
        C1752p1.a().b(getClass()).b(this, C1743n0.L(abstractC1739m0));
    }

    public final int e() {
        return C1752p1.a().b(getClass()).c(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return C1752p1.a().b(getClass()).f(this, (F0) obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1720h1
    public final /* synthetic */ InterfaceC1716g1 f() {
        return (A0) F(5, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1
    public final /* synthetic */ InterfaceC1720h1 g() {
        return (F0) F(6, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1
    public final boolean h() {
        return B(this, true);
    }

    public final int hashCode() {
        if (C()) {
            return e();
        }
        int i10 = this.zza;
        if (i10 != 0) {
            return i10;
        }
        int iE = e();
        this.zza = iE;
        return iE;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1720h1
    public final /* synthetic */ InterfaceC1716g1 j() {
        A0 a02 = (A0) F(5, null, null);
        a02.o(this);
        return a02;
    }

    public final A0 k() {
        return (A0) F(5, null, null);
    }

    public final A0 l() {
        A0 a02 = (A0) F(5, null, null);
        a02.o(this);
        return a02;
    }

    public final F0 o() {
        return (F0) F(4, null, null);
    }

    public final String toString() {
        return C1728j1.a(this, super.toString());
    }

    public final void x() {
        C1752p1.a().b(getClass()).a(this);
        y();
    }

    public final void y() {
        this.zzd &= Integer.MAX_VALUE;
    }
}
