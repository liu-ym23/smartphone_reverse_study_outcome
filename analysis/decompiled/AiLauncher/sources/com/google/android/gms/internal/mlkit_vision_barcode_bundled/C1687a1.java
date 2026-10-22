package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.a1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1687a1 implements A1 {

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC1712f1 f20076b = new Y0();

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1712f1 f20077a;

    public C1687a1() {
        C1790z0 c1790z0C = C1790z0.c();
        C1752p1 c1752p1 = C1752p1.f20120c;
        Z0 z02 = new Z0(c1790z0C, f20076b);
        Charset charset = N0.f20038a;
        this.f20077a = z02;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.A1
    public final InterfaceC1791z1 a(Class cls) {
        M1 m12 = B1.f20009a;
        if (!F0.class.isAssignableFrom(cls)) {
            C1752p1 c1752p1 = C1752p1.f20120c;
        }
        InterfaceC1707e1 interfaceC1707e1A = this.f20077a.a(cls);
        if (interfaceC1707e1A.zzb()) {
            C1752p1 c1752p12 = C1752p1.f20120c;
            return C1736l1.i(B1.r(), C1770u0.a(), interfaceC1707e1A.zza());
        }
        C1752p1 c1752p13 = C1752p1.f20120c;
        return C1732k1.z(cls, interfaceC1707e1A, C1748o1.a(), W0.a(), B1.r(), interfaceC1707e1A.zzc() + (-1) != 1 ? C1770u0.a() : null, C1702d1.a());
    }
}
