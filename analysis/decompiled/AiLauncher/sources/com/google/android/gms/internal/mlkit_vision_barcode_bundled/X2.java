package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class X2 extends F0 implements InterfaceC1724i1 {
    private static final X2 zzb;
    private int zzd;
    private M0 zze = F0.t();
    private Z2 zzf;
    private C1708e2 zzg;

    static {
        X2 x22 = new X2();
        zzb = x22;
        F0.z(X2.class, x22);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", j3.class, "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new X2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new W2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
