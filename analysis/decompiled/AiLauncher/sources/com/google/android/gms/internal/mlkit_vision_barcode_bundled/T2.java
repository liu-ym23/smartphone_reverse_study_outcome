package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class T2 extends F0 implements InterfaceC1724i1 {
    private static final T2 zzb;
    private int zzd;
    private int zzg;
    private z3 zzh;
    private v3 zzi;
    private p3 zzj;
    private int zzk;
    private byte zzm = 2;
    private int zze = 17;
    private M0 zzf = F0.t();
    private M0 zzl = F0.t();

    static {
        T2 t22 = new T2();
        zzb = t22;
        F0.z(T2.class, t22);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\b\u0000\u0001\u0001\u000f\b\u0000\u0002\u0004\u0001᠌\u0000\u0003Л\u0004င\u0001\u0005ᐉ\u0002\u0006ᐉ\u0003\u0007င\u0005\b\u001b\u000fᐉ\u0004", new Object[]{"zzd", "zze", C1764s2.f20139a, "zzf", C1718h.class, "zzg", "zzh", "zzi", "zzk", "zzl", C1730k.class, "zzj"});
        }
        if (i11 == 3) {
            return new T2();
        }
        C1775v1 c1775v1 = null;
        if (i11 == 4) {
            return new U1(c1775v1);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
