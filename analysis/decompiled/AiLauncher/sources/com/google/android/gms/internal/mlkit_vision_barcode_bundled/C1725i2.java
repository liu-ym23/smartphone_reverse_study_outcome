package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.i2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1725i2 extends F0 implements InterfaceC1724i1 {
    private static final C1725i2 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        C1725i2 c1725i2 = new C1725i2();
        zzb = c1725i2;
        F0.z(C1725i2.class, c1725i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new C1725i2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new C1721h2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
