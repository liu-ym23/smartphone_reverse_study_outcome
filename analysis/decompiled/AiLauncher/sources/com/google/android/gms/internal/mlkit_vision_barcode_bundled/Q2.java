package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class Q2 extends F0 implements InterfaceC1724i1 {
    private static final Q2 zzb;
    private int zzd;
    private int zze;
    private int zzf = 100;
    private int zzg;

    static {
        Q2 q22 = new Q2();
        zzb = q22;
        F0.z(Q2.class, q22);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", O2.f20047a, "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new Q2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new P2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
