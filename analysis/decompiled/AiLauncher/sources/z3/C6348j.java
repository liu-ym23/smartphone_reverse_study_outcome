package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;

/* renamed from: z3.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6348j extends F0 implements InterfaceC1724i1 {
    private static final C6348j zzb;
    private int zzd;
    private byte zzg = 2;
    private String zze = "";
    private String zzf = "";

    static {
        C6348j c6348j = new C6348j();
        zzb = c6348j;
        F0.z(C6348j.class, c6348j);
    }

    public static C6348j I() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᔈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new C6348j();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new C6347i(c6340b);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final String J() {
        return this.zze;
    }

    public final String K() {
        return this.zzf;
    }
}
