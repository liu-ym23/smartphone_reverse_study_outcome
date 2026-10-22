package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1700d extends F0 implements InterfaceC1724i1 {
    private static final C1700d zzb;
    private int zzd;
    private int zze = 4369;
    private String zzf = "";

    static {
        C1700d c1700d = new C1700d();
        zzb = c1700d;
        F0.z(C1700d.class, c1700d);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", w3.f20147a, "zzf"});
        }
        if (i11 == 3) {
            return new C1700d();
        }
        C1690b c1690b = null;
        if (i11 == 4) {
            return new C1695c(c1690b);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
