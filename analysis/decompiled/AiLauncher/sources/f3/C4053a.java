package f3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;

/* renamed from: f3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4053a extends F0<C4053a, o> implements InterfaceC1724i1 {
    private static final C4053a zzb;
    private int zzd;
    private m zze;
    private e zzf;
    private u zzg;

    static {
        C4053a c4053a = new C4053a();
        zzb = c4053a;
        F0.z(C4053a.class, c4053a);
    }

    public static o H() {
        return (o) zzb.k();
    }

    public static /* synthetic */ void J(C4053a c4053a, m mVar) {
        mVar.getClass();
        c4053a.zze = mVar;
        c4053a.zzd |= 1;
    }

    public static /* synthetic */ void K(C4053a c4053a, e eVar) {
        eVar.getClass();
        c4053a.zzf = eVar;
        c4053a.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new C4053a();
        }
        n nVar = null;
        if (i11 == 4) {
            return new o(nVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
