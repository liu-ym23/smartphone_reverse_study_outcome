package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.List;

/* loaded from: classes2.dex */
public final class K extends F0 implements InterfaceC1724i1 {
    private static final K zzb;
    private int zzd;
    private int zze;
    private V0 zzg;
    private byte zzh = 2;
    private M0 zzf = F0.t();

    static {
        K k10 = new K();
        zzb = k10;
        F0.z(K.class, k10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001᠌\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"zzd", "zze", I.f20027a, "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new K();
        }
        G g10 = null;
        if (i11 == 4) {
            return new H(g10);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final List I() {
        return this.zzf;
    }

    public final int J() {
        int iA = J.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
