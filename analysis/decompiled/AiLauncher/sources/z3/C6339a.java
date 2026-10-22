package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1758r0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer;
import java.util.List;

/* renamed from: z3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6339a extends F0<C6339a, x> implements InterfaceC1724i1 {
    private static final C6339a zzb;
    private int zzd;
    private int zzf;
    private byte zzi = 2;
    private M0 zze = F0.t();
    private String zzg = "";
    private zzdf zzh = zzdf.f20159b;

    static {
        C6339a c6339a = new C6339a();
        zzb = c6339a;
        F0.z(C6339a.class, c6339a);
    }

    public static C6339a I(byte[] bArr, C1758r0 c1758r0) throws zzer {
        return (C6339a) F0.p(zzb, bArr, c1758r0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0002\u0001Л\u0002ᴌ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzd", "zze", s.class, "zzf", C6349k.f45178a, "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new C6339a();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new x(c6340b);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final List J() {
        return this.zze;
    }
}
