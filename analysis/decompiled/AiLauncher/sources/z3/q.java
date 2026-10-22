package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;

/* loaded from: classes2.dex */
public final class q extends F0 implements InterfaceC1724i1 {
    private static final q zzb;
    private int zzd;
    private int zzf;
    private boolean zzh;
    private byte zzi = 2;
    private String zze = "";
    private String zzg = "";

    static {
        q qVar = new q();
        zzb = qVar;
        F0.z(q.class, qVar);
    }

    public static q I() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ᔈ\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", C6353o.f45179a, "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new q();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new C6352n(c6340b);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final String J() {
        return this.zzg;
    }

    public final String K() {
        return this.zze;
    }

    public final int L() {
        int iA = C6354p.a(this.zzf);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
