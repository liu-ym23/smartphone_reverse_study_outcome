package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class m3 extends F0 implements InterfaceC1724i1 {
    private static final m3 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg = "";

    static {
        m3 m3Var = new m3();
        zzb = m3Var;
        F0.z(m3.class, m3Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", k3.f20107a, "zzg"});
        }
        if (i11 == 3) {
            return new m3();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new l3(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
