package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;

/* loaded from: classes2.dex */
public final class P extends F0 implements InterfaceC1724i1 {
    private static final P zzb;
    private int zzd;
    private double zze;
    private double zzf;
    private byte zzg = 2;

    static {
        P p10 = new P();
        zzb = p10;
        F0.z(P.class, p10);
    }

    public static P K() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔀ\u0000\u0002ᔀ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new P();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new O(c6340b);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final double H() {
        return this.zze;
    }

    public final double I() {
        return this.zzf;
    }
}
