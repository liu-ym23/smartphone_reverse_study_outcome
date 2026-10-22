package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class p3 extends C0 implements InterfaceC1724i1 {
    private static final p3 zzd;
    private byte zze = 2;

    static {
        p3 p3Var = new p3();
        zzd = p3Var;
        F0.z(p3.class, p3Var);
    }

    public static p3 J() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zze);
        }
        n3 n3Var = null;
        if (i11 == 2) {
            return F0.w(zzd, "\u0003\u0000", null);
        }
        if (i11 == 3) {
            return new p3();
        }
        if (i11 == 4) {
            return new o3(n3Var);
        }
        if (i11 == 5) {
            return zzd;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
