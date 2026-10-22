package com.google.protobuf;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class r extends ib.c {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f2504b = Logger.getLogger(r.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f2505c = i4.f2402e;

    /* renamed from: a, reason: collision with root package name */
    public z2 f2506a;

    public static int Q(int i2, l lVar) {
        int iU = U(i2);
        int size = lVar.size();
        return V(size) + size + iU;
    }

    public static int R(int i2) {
        return V((i2 >> 31) ^ (i2 << 1));
    }

    public static int S(long j2) {
        return W((j2 >> 63) ^ (j2 << 1));
    }

    public static int T(String str) {
        int length;
        try {
            length = l4.b(str);
        } catch (k4 unused) {
            length = str.getBytes(p2.f2495a).length;
        }
        return V(length) + length;
    }

    public static int U(int i2) {
        return V(i2 << 3);
    }

    public static int V(int i2) {
        return (352 - (Integer.numberOfLeadingZeros(i2) * 9)) >>> 6;
    }

    public static int W(long j2) {
        return (640 - (Long.numberOfLeadingZeros(j2) * 9)) >>> 6;
    }

    public final void X(String str, k4 k4Var) throws androidx.datastore.preferences.protobuf.l {
        f2504b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) k4Var);
        byte[] bytes = str.getBytes(p2.f2495a);
        try {
            r0(bytes.length);
            P(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e10) {
            throw new androidx.datastore.preferences.protobuf.l(e10);
        }
    }

    public abstract void Y(byte b10);

    public abstract void Z(int i2, boolean z4);

    public abstract void a0(int i2, byte[] bArr);

    public abstract void b0(int i2, l lVar);

    public abstract void c0(l lVar);

    public abstract void d0(int i2, int i10);

    public abstract void e0(int i2);

    public abstract void f0(int i2, long j2);

    public abstract void g0(long j2);

    public abstract void h0(int i2, int i10);

    public abstract void i0(int i2);

    public abstract void j0(int i2, MessageLite messageLite, t3 t3Var);

    public abstract void k0(MessageLite messageLite);

    public abstract void l0(int i2, MessageLite messageLite);

    public abstract void m0(int i2, l lVar);

    public abstract void n0(int i2, String str);

    public abstract void o0(String str);

    public abstract void p0(int i2, int i10);

    public abstract void q0(int i2, int i10);

    public abstract void r0(int i2);

    public abstract void s0(int i2, long j2);

    public abstract void t0(long j2);
}
