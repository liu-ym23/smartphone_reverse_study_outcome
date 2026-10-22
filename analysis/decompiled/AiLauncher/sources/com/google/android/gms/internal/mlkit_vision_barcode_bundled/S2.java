package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class S2 extends F0 implements InterfaceC1724i1 {
    private static final S2 zzb;
    private int zzd;
    private int zze;

    static {
        S2 s22 = new S2();
        zzb = s22;
        F0.z(S2.class, s22);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
        }
        if (i11 == 3) {
            return new S2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new R2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
