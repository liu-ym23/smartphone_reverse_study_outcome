package f3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;

/* loaded from: classes2.dex */
public final class r extends F0 implements InterfaceC1724i1 {
    private static final r zzb;
    private int zzd = 0;
    private Object zze;

    static {
        r rVar = new r();
        zzb = rVar;
        F0.z(r.class, rVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zze", "zzd", x.class, D.class, C4052A.class});
        }
        if (i11 == 3) {
            return new r();
        }
        p pVar = null;
        if (i11 == 4) {
            return new q(pVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
