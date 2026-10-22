package f3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0;

/* loaded from: classes2.dex */
public final class u extends F0 implements InterfaceC1724i1 {
    private static final u zzb;
    private M0 zzd = F0.t();
    private M0 zze = F0.t();

    static {
        u uVar = new u();
        zzb = uVar;
        F0.z(u.class, uVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzd", r.class, "zze", r.class});
        }
        if (i11 == 3) {
            return new u();
        }
        s sVar = null;
        if (i11 == 4) {
            return new t(sVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
