package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class Q extends F0 implements InterfaceC1724i1 {
    private static final Q zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        Q q10 = new Q();
        zzb = q10;
        F0.z(Q.class, q10);
    }

    public static Q I() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", O.f20046a, "zzf"});
        }
        if (i11 == 3) {
            return new Q();
        }
        G g10 = null;
        if (i11 == 4) {
            return new N(g10);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }

    public final String J() {
        return this.zzf;
    }

    public final int K() {
        int iA = P.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
