package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;

/* renamed from: z3.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6343e extends F0 implements InterfaceC1724i1 {
    private static final C6343e zzb;
    private int zzd;
    private int zze;
    private zzdf zzf = zzdf.f20159b;

    static {
        C6343e c6343e = new C6343e();
        zzb = c6343e;
        F0.z(C6343e.class, c6343e);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new C6343e();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new C6342d(c6340b);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
