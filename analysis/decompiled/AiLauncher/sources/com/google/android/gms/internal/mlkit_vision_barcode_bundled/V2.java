package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class V2 extends F0 implements InterfaceC1724i1 {
    private static final V2 zzb;
    private int zzd;
    private String zze = "";
    private C1694b3 zzf;

    static {
        V2 v22 = new V2();
        zzb = v22;
        F0.z(V2.class, v22);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new V2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new U2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
