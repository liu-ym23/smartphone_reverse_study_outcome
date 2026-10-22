package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class N2 extends F0 implements InterfaceC1724i1 {
    private static final N2 zzb;
    private int zzd;
    private boolean zzf;
    private int zzg;
    private boolean zzj;
    private int zzm;
    private int zzn;
    private boolean zzo;
    private int zze = -1;
    private zzdf zzh = zzdf.f20159b;
    private String zzi = "";
    private boolean zzk = true;
    private boolean zzl = true;

    static {
        N2 n22 = new N2();
        zzb = n22;
        F0.z(N2.class, n22);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            J0 j02 = L2.f20036a;
            J0 j03 = M2.f20037a;
            return F0.w(zzb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003᠌\u0002\u0004ည\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\t᠌\b\n᠌\t\u000bဇ\n", new Object[]{"zzd", "zze", "zzf", "zzg", j02, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", j03, "zzn", j03, "zzo"});
        }
        if (i11 == 3) {
            return new N2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new K2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
