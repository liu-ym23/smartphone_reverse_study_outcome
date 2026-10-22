package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1730k extends F0 implements InterfaceC1724i1 {
    private static final C1730k zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        C1730k c1730k = new C1730k();
        zzb = c1730k;
        F0.z(C1730k.class, c1730k);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new C1730k();
        }
        C1722i c1722i = null;
        if (i11 == 4) {
            return new C1726j(c1722i);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
