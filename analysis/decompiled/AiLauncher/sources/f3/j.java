package f3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0;

/* loaded from: classes2.dex */
public final class j extends F0 implements InterfaceC1724i1 {
    private static final j zzb;
    private M0 zzd = F0.t();

    static {
        j jVar = new j();
        zzb = jVar;
        F0.z(j.class, jVar);
    }

    public static i H() {
        return (i) zzb.k();
    }

    public static /* synthetic */ void J(j jVar, g gVar) {
        gVar.getClass();
        M0 m02 = jVar.zzd;
        if (!m02.zzc()) {
            jVar.zzd = F0.u(m02);
        }
        jVar.zzd.add(gVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", g.class});
        }
        if (i11 == 3) {
            return new j();
        }
        h hVar = null;
        if (i11 == 4) {
            return new i(hVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
