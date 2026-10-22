package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;

/* renamed from: z3.B, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6336B extends F0 implements InterfaceC1724i1 {
    private static final C6336B zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    static {
        C6336B c6336b = new C6336B();
        zzb = c6336b;
        F0.z(C6336B.class, c6336b);
    }

    public static C6336B O() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i11 == 3) {
            return new C6336B();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new C6335A(c6340b);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }

    public final int H() {
        return this.zzg;
    }

    public final int I() {
        return this.zzh;
    }

    public final int J() {
        return this.zzi;
    }

    public final int K() {
        return this.zzf;
    }

    public final int L() {
        return this.zzj;
    }

    public final int M() {
        return this.zze;
    }

    public final boolean P() {
        return this.zzk;
    }
}
