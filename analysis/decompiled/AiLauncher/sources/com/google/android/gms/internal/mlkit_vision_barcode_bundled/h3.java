package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class h3 extends F0 implements InterfaceC1724i1 {
    private static final h3 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        h3 h3Var = new h3();
        zzb = h3Var;
        F0.z(h3.class, h3Var);
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
            return new h3();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new g3(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
