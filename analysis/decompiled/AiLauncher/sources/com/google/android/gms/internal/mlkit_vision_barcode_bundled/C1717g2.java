package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.g2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1717g2 extends F0 implements InterfaceC1724i1 {
    private static final C1717g2 zzb;
    private int zzd;
    private int zze = -1;

    static {
        C1717g2 c1717g2 = new C1717g2();
        zzb = c1717g2;
        F0.z(C1717g2.class, c1717g2);
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
            return new C1717g2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new C1713f2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
