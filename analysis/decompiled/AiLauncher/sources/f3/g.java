package f3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.K0;

/* loaded from: classes2.dex */
public final class g extends F0 implements InterfaceC1724i1 {
    private static final g zzb;
    private int zzd;
    private K0 zze = F0.q();
    private K0 zzf = F0.q();
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        g gVar = new g();
        zzb = gVar;
        F0.z(g.class, gVar);
    }

    public static f H() {
        return (f) zzb.k();
    }

    public static /* synthetic */ void J(g gVar, int i10) {
        gVar.zzd |= 2;
        gVar.zzh = i10;
    }

    public static /* synthetic */ void K(g gVar, float f10) {
        K0 k02 = gVar.zze;
        if (!k02.zzc()) {
            gVar.zze = F0.r(k02);
        }
        gVar.zze.w(f10);
    }

    public static /* synthetic */ void L(g gVar, float f10) {
        K0 k02 = gVar.zzf;
        if (!k02.zzc()) {
            gVar.zzf = F0.r(k02);
        }
        gVar.zzf.w(f10);
    }

    public static /* synthetic */ void M(g gVar, int i10) {
        gVar.zzd |= 1;
        gVar.zzg = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0013\u0002\u0013\u0003ဋ\u0000\u0004ဋ\u0001\u0005ဋ\u0002\u0006ဋ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i11 == 3) {
            return new g();
        }
        C4054b c4054b = null;
        if (i11 == 4) {
            return new f(c4054b);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
