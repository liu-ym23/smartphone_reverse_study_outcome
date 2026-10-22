package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.e2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1708e2 extends F0 implements InterfaceC1724i1 {
    private static final C1708e2 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        C1708e2 c1708e2 = new C1708e2();
        zzb = c1708e2;
        F0.z(C1708e2.class, c1708e2);
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
            return new C1708e2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new C1703d2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
