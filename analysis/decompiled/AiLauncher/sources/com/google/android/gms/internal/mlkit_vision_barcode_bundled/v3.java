package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class v3 extends F0 implements InterfaceC1724i1 {
    private static final v3 zzb;
    private int zzd;
    private p3 zzj;
    private byte zzk = 2;
    private L0 zze = F0.s();
    private K0 zzf = F0.q();
    private boolean zzg = true;
    private String zzh = "";
    private String zzi = "";

    static {
        v3 v3Var = new v3();
        zzb = v3Var;
        F0.z(v3.class, v3Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0006\u0000\u0001\u0001\u000f\u0006\u0000\u0002\u0001\u0001\u0016\u0002\u0013\u0003ဇ\u0000\u0004ဈ\u0001\u0005ဈ\u0002\u000fᐉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i11 == 3) {
            return new v3();
        }
        t3 t3Var = null;
        if (i11 == 4) {
            return new u3(t3Var);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
