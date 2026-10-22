package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.l2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1737l2 extends F0 implements InterfaceC1724i1 {
    private static final C1737l2 zzb;
    private int zzd;
    private String zze = "";
    private int zzf = 1;
    private boolean zzg;
    private int zzh;

    static {
        C1737l2 c1737l2 = new C1737l2();
        zzb = c1737l2;
        F0.z(C1737l2.class, c1737l2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", C1733k2.f20106a, "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new C1737l2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new C1729j2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
