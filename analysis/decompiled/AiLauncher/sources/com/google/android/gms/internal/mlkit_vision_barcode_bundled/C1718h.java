package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1718h extends F0 implements InterfaceC1724i1 {
    private static final C1718h zzb;
    private int zzd;
    private C3 zzj;
    private p3 zzk;
    private byte zzl = 2;
    private String zze = "";
    private String zzf = "";
    private L0 zzg = F0.s();
    private String zzh = "";
    private String zzi = "";

    static {
        C1718h c1718h = new C1718h();
        zzb = c1718h;
        F0.z(C1718h.class, c1718h);
        F0.m(p3.J(), c1718h, c1718h, null, 308676116, zzhf.zzk, C1718h.class);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0007\u0000\u0001\u0001Ǵ\u0007\u0000\u0001\u0002\u0001ᔈ\u0000\u0002ဈ\u0001\u0003ࠞ\u0005ဈ\u0002\u0006ဈ\u0003\u000fᐉ\u0005Ǵဉ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", C1714g.f20084a, "zzh", "zzi", "zzk", "zzj"});
        }
        if (i11 == 3) {
            return new C1718h();
        }
        C1705e c1705e = null;
        if (i11 == 4) {
            return new C1710f(c1705e);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
