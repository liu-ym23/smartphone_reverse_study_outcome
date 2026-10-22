package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class E2 extends F0 implements InterfaceC1724i1 {
    private static final E2 zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        E2 e22 = new E2();
        zzb = e22;
        F0.z(E2.class, e22);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0002\u0000\u0001\u0005\u0006\u0002\u0000\u0000\u0000\u0005ဇ\u0000\u0006ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new E2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new D2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
