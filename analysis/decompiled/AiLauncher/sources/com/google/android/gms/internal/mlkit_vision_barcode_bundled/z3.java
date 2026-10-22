package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class z3 extends F0 implements InterfaceC1724i1 {
    private static final z3 zzb;
    private int zzd;
    private long zze;
    private long zzf;
    private p3 zzg;
    private byte zzh = 2;

    static {
        z3 z3Var = new z3();
        zzb = z3Var;
        F0.z(z3.class, z3Var);
        F0.m(p3.J(), z3Var, z3Var, null, 13258261, zzhf.zzk, z3.class);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔅ\u0000\u0002ᔅ\u0001\u0003ᐉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new z3();
        }
        x3 x3Var = null;
        if (i11 == 4) {
            return new y3(x3Var);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
