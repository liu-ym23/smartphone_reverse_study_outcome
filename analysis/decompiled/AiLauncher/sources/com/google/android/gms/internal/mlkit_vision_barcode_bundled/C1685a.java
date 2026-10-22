package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1685a extends F0 implements InterfaceC1724i1 {
    private static final C1685a zzb;
    private int zzd;
    private C1700d zze;
    private boolean zzf;

    static {
        C1685a c1685a = new C1685a();
        zzb = c1685a;
        F0.z(C1685a.class, c1685a);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new C1685a();
        }
        D3 d32 = null;
        if (i11 == 4) {
            return new E3(d32);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
