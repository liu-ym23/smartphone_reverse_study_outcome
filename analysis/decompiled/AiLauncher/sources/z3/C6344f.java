package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0;

/* renamed from: z3.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6344f extends F0 implements InterfaceC1724i1 {
    private static final C6344f zzb;
    private M0 zzd = F0.t();

    static {
        C6344f c6344f = new C6344f();
        zzb = c6344f;
        F0.z(C6344f.class, c6344f);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", C6343e.class});
        }
        if (i11 == 3) {
            return new C6344f();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new C6341c(c6340b);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
