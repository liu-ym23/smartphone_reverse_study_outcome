package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class M extends F0 implements InterfaceC1724i1 {
    private static final M zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        M m10 = new M();
        zzb = m10;
        F0.z(M.class, m10);
    }

    public static M I() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i11 == 3) {
            return new M();
        }
        G g10 = null;
        if (i11 == 4) {
            return new L(g10);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }

    public final String J() {
        return this.zzh;
    }

    public final String K() {
        return this.zze;
    }

    public final String L() {
        return this.zzj;
    }

    public final String M() {
        return this.zzi;
    }

    public final String N() {
        return this.zzg;
    }

    public final String O() {
        return this.zzf;
    }

    public final String P() {
        return this.zzk;
    }
}
