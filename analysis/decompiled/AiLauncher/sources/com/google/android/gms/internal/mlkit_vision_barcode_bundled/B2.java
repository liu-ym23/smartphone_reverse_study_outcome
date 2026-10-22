package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class B2 extends F0 implements InterfaceC1724i1 {
    private static final B2 zzb;
    private int zzd;
    private int zze;
    private C1768t2 zzh;
    private int zzj;
    private int zzk;
    private int zzn;
    private M0 zzf = F0.t();
    private int zzg = -1;
    private String zzi = "";
    private L0 zzl = F0.s();
    private String zzm = "";

    static {
        B2 b22 = new B2();
        zzb = b22;
        F0.z(B2.class, b22);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001b\u0003င\u0001\u0004ဉ\u0002\u0005ဈ\u0003\u0006᠌\u0004\u0007᠌\u0005\b'\tဈ\u0006\n᠌\u0007", new Object[]{"zzd", "zze", C1780w2.f20146a, "zzf", C1776v2.class, "zzg", "zzh", "zzi", "zzj", C1788y2.f20153a, "zzk", C1792z2.f20155a, "zzl", "zzm", "zzn", A2.f20008a});
        }
        if (i11 == 3) {
            return new B2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new C1784x2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
