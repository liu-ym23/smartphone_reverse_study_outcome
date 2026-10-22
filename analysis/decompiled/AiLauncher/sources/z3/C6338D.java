package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;

/* renamed from: z3.D, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6338D extends F0 implements InterfaceC1724i1 {
    private static final C6338D zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private C6336B zzj;
    private C6336B zzk;

    static {
        C6338D c6338d = new C6338D();
        zzb = c6338d;
        F0.z(C6338D.class, c6338d);
    }

    public static C6338D K() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i11 == 3) {
            return new C6338D();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new C6337C(c6340b);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }

    public final C6336B H() {
        C6336B c6336b = this.zzk;
        return c6336b == null ? C6336B.O() : c6336b;
    }

    public final C6336B I() {
        C6336B c6336b = this.zzj;
        return c6336b == null ? C6336B.O() : c6336b;
    }

    public final String L() {
        return this.zzf;
    }

    public final String M() {
        return this.zzg;
    }

    public final String N() {
        return this.zzh;
    }

    public final String O() {
        return this.zzi;
    }

    public final String P() {
        return this.zze;
    }
}
