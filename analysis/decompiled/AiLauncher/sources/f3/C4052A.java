package f3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1698c2;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;

/* renamed from: f3.A, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4052A extends F0 implements InterfaceC1724i1 {
    private static final C4052A zzb;
    private int zzd;
    private C1698c2 zzf;
    private zzdf zze = zzdf.f20159b;
    private int zzg = 1;
    private float zzh = 0.75f;
    private boolean zzi = true;

    static {
        C4052A c4052a = new C4052A();
        zzb = c4052a;
        F0.z(C4052A.class, c4052a);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ည\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ခ\u0003\u0005ဇ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new C4052A();
        }
        y yVar = null;
        if (i11 == 4) {
            return new z(yVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
