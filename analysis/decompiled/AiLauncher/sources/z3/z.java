package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0;

/* loaded from: classes2.dex */
public final class z extends F0 implements InterfaceC1724i1 {
    private static final z zzb;
    private int zzd;
    private String zze = "";
    private M0 zzf = F0.t();

    static {
        z zVar = new z();
        zzb = zVar;
        F0.z(z.class, zVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", N.class});
        }
        if (i11 == 3) {
            return new z();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new y(c6340b);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
