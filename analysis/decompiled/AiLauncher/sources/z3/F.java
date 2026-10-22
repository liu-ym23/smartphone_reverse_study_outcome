package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.Q;
import java.util.List;

/* loaded from: classes2.dex */
public final class F extends F0 implements InterfaceC1724i1 {
    private static final F zzb;
    private int zzd;
    private com.google.android.gms.internal.mlkit_vision_barcode_bundled.M zze;
    private byte zzm = 2;
    private String zzf = "";
    private String zzg = "";
    private M0 zzh = F0.t();
    private M0 zzi = F0.t();
    private M0 zzj = F0.t();
    private M0 zzk = F0.t();
    private String zzl = "";

    static {
        F f10 = new F();
        zzb = f10;
        F0.z(F.class, f10);
    }

    public static F J() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0004\u0001\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004\u001b\u0005\u001b\u0006\u001a\u0007Л\bဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", Q.class, "zzi", L.class, "zzj", "zzk", com.google.android.gms.internal.mlkit_vision_barcode_bundled.K.class, "zzl"});
        }
        if (i11 == 3) {
            return new F();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new E(c6340b);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final com.google.android.gms.internal.mlkit_vision_barcode_bundled.M H() {
        com.google.android.gms.internal.mlkit_vision_barcode_bundled.M m10 = this.zze;
        return m10 == null ? com.google.android.gms.internal.mlkit_vision_barcode_bundled.M.I() : m10;
    }

    public final String K() {
        return this.zzf;
    }

    public final String L() {
        return this.zzg;
    }

    public final List M() {
        return this.zzk;
    }

    public final List N() {
        return this.zzi;
    }

    public final List O() {
        return this.zzh;
    }

    public final List P() {
        return this.zzj;
    }
}
