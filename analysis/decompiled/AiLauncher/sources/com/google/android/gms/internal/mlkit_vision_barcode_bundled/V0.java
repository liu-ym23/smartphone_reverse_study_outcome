package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class V0 extends F0 implements InterfaceC1724i1 {
    private static final V0 zzb;
    private int zzd;
    private p3 zzi;
    private V0 zzj;
    private C3 zzk;
    private byte zzl = 2;
    private String zze = "";
    private M0 zzf = F0.t();
    private M0 zzg = F0.t();
    private M0 zzh = F0.t();

    static {
        V0 v02 = new V0();
        zzb = v02;
        F0.z(V0.class, v02);
        F0.m(p3.J(), v02, v02, null, 12208774, zzhf.zzk, V0.class);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0007\u0000\u0001\u0002Ǵ\u0007\u0000\u0003\u0004\u0002Л\u0005Л\u0006\u001b\bᐉ\u0001\nဈ\u0000\u000bᐉ\u0002Ǵဉ\u0003", new Object[]{"zzd", "zzf", T2.class, "zzh", T2.class, "zzg", s3.class, "zzi", "zze", "zzj", "zzk"});
        }
        if (i11 == 3) {
            return new V0();
        }
        C1701d0 c1701d0 = null;
        if (i11 == 4) {
            return new C1786y0(c1701d0);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
