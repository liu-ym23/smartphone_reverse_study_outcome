package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.v2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1776v2 extends F0 implements InterfaceC1724i1 {
    private static final C1776v2 zzb;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        C1776v2 c1776v2 = new C1776v2();
        zzb = c1776v2;
        F0.z(C1776v2.class, c1776v2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", C1780w2.f20146a, "zzf"});
        }
        if (i11 == 3) {
            return new C1776v2();
        }
        C1688a2 c1688a2 = null;
        if (i11 == 4) {
            return new C1772u2(c1688a2);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
