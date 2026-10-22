package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class H2 extends F0 implements InterfaceC1724i1 {
    private static final H2 zzb;
    private int zzd;
    private boolean zze;
    private int zzf;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzg = true;
    private String zzl = "";
    private String zzm = "";

    static {
        H2 h22 = new H2();
        zzb = h22;
        F0.z(H2.class, h22);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            J0 j02 = J2.f20035a;
            J0 j03 = F2.f20022a;
            J0 j04 = I2.f20028a;
            return F0.w(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\bဈ\u0007\tဈ\b", new Object[]{"zzd", "zze", "zzf", j02, "zzg", "zzh", j03, "zzi", j04, "zzj", j04, "zzk", j04, "zzl", "zzm"});
        }
        if (i11 == 3) {
            return new H2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new G2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
