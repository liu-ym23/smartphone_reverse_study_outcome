package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class C3 extends F0 implements InterfaceC1724i1 {
    private static final C3 zzb;
    private int zzd;
    private C1685a zze;

    static {
        C3 c32 = new C3();
        zzb = c32;
        F0.z(C3.class, c32);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0001\u0000\u0001\u000f\u000f\u0001\u0000\u0000\u0000\u000fဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i11 == 3) {
            return new C3();
        }
        A3 a32 = null;
        if (i11 == 4) {
            return new B3(a32);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
