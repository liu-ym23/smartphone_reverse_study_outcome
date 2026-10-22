package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.m0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1739m0 extends C1686a0 {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f20112b = Logger.getLogger(AbstractC1739m0.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f20113c = T1.C();

    /* renamed from: a, reason: collision with root package name */
    public C1743n0 f20114a;

    public AbstractC1739m0() {
        throw null;
    }

    public static int A(InterfaceC1720h1 interfaceC1720h1) {
        int iA = interfaceC1720h1.a();
        return a(iA) + iA;
    }

    public static int B(InterfaceC1720h1 interfaceC1720h1, InterfaceC1791z1 interfaceC1791z1) {
        int iB = ((T) interfaceC1720h1).b(interfaceC1791z1);
        return a(iB) + iB;
    }

    public static int C(String str) {
        int length;
        try {
            length = Y1.e(str);
        } catch (zzhd unused) {
            length = str.getBytes(N0.f20038a).length;
        }
        return a(length) + length;
    }

    public static int a(int i10) {
        return (352 - (Integer.numberOfLeadingZeros(i10) * 9)) >>> 6;
    }

    public static int b(long j10) {
        return (640 - (Long.numberOfLeadingZeros(j10) * 9)) >>> 6;
    }

    @Deprecated
    public static int z(int i10, InterfaceC1720h1 interfaceC1720h1, InterfaceC1791z1 interfaceC1791z1) {
        int iA = a(i10 << 3);
        return iA + iA + ((T) interfaceC1720h1).b(interfaceC1791z1);
    }

    public final void c() {
        if (f() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void d(String str, zzhd zzhdVar) throws IOException {
        f20112b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhdVar);
        byte[] bytes = str.getBytes(N0.f20038a);
        try {
            int length = bytes.length;
            w(length);
            p(bytes, 0, length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzdl(e10);
        }
    }

    public abstract int f();

    public abstract void g(byte b10) throws IOException;

    public abstract void h(int i10, boolean z10) throws IOException;

    public abstract void i(int i10, zzdf zzdfVar) throws IOException;

    public abstract void j(int i10, int i11) throws IOException;

    public abstract void k(int i10) throws IOException;

    public abstract void l(int i10, long j10) throws IOException;

    public abstract void m(long j10) throws IOException;

    public abstract void n(int i10, int i11) throws IOException;

    public abstract void o(int i10) throws IOException;

    public abstract void p(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void q(int i10, InterfaceC1720h1 interfaceC1720h1, InterfaceC1791z1 interfaceC1791z1) throws IOException;

    public abstract void r(int i10, InterfaceC1720h1 interfaceC1720h1) throws IOException;

    public abstract void s(int i10, zzdf zzdfVar) throws IOException;

    public abstract void t(int i10, String str) throws IOException;

    public abstract void u(int i10, int i11) throws IOException;

    public abstract void v(int i10, int i11) throws IOException;

    public abstract void w(int i10) throws IOException;

    public abstract void x(int i10, long j10) throws IOException;

    public abstract void y(long j10) throws IOException;

    public /* synthetic */ AbstractC1739m0(C1735l0 c1735l0) {
    }
}
