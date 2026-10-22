package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.c2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1698c2 extends F0 implements InterfaceC1724i1 {
    private static final C1698c2 zzb;
    private int zzd;
    private int zze;
    private j3 zzf;
    private V2 zzg;
    private X2 zzh;

    static {
        C1698c2 c1698c2 = new C1698c2();
        zzb = c1698c2;
        F0.z(C1698c2.class, c1698c2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0005ဉ\u0003", new Object[]{"zzd", "zze", C2.f20010a, "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new C1698c2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new C1693b2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
