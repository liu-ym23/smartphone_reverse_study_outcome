package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class s3 extends F0 implements InterfaceC1724i1 {
    private static final s3 zzb;
    private int zzd;
    private M0 zze = F0.t();
    private String zzf = "";

    static {
        s3 s3Var = new s3();
        zzb = s3Var;
        F0.z(s3.class, s3Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new s3();
        }
        q3 q3Var = null;
        if (i11 == 4) {
            return new r3(q3Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
