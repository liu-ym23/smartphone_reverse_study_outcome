package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;

/* loaded from: classes2.dex */
public final class L extends F0 implements InterfaceC1724i1 {
    private static final L zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        L l10 = new L();
        zzb = l10;
        F0.z(L.class, l10);
    }

    public static L I() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", J.f45177a, "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new L();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new I(c6340b);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }

    public final String J() {
        return this.zzf;
    }

    public final String K() {
        return this.zzh;
    }

    public final String L() {
        return this.zzg;
    }

    public final int M() {
        int iA = K.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
