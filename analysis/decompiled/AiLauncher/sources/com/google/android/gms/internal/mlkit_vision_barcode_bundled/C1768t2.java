package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.t2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1768t2 extends F0 implements InterfaceC1724i1 {
    private static final C1768t2 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private M0 zzg = F0.t();
    private int zzh;

    static {
        C1768t2 c1768t2 = new C1768t2();
        zzb = c1768t2;
        F0.z(C1768t2.class, c1768t2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002င\u0001\u0003\u001a\u0004င\u0002", new Object[]{"zzd", "zze", C1760r2.f20135a, "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new C1768t2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new C1757q2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
