package f3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;

/* loaded from: classes2.dex */
public final class x extends F0 implements InterfaceC1724i1 {
    private static final x zzb;

    static {
        x xVar = new x();
        zzb = xVar;
        F0.z(x.class, xVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        v vVar = null;
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0000", null);
        }
        if (i11 == 3) {
            return new x();
        }
        if (i11 == 4) {
            return new w(vVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
