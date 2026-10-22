package f3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1698c2;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;

/* loaded from: classes2.dex */
public final class m extends F0 implements InterfaceC1724i1 {
    private static final m zzb;
    private int zzd;
    private j zzj;
    private C1698c2 zzl;
    private String zze = "";
    private zzdf zzf = zzdf.f20159b;
    private int zzg = 10;
    private float zzh = 0.5f;
    private float zzi = 0.05f;
    private int zzk = 1;
    private int zzm = 320;
    private int zzn = 4;
    private int zzo = 2;

    static {
        m mVar = new m();
        zzb = mVar;
        F0.z(m.class, mVar);
    }

    public static l H() {
        return (l) zzb.k();
    }

    public static /* synthetic */ void J(m mVar, j jVar) {
        jVar.getClass();
        mVar.zzj = jVar;
        mVar.zzd |= 32;
    }

    public static /* synthetic */ void K(m mVar, zzdf zzdfVar) {
        zzdfVar.getClass();
        mVar.zzd |= 2;
        mVar.zzf = zzdfVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u000b\u0000\u0001\u0001\f\u000b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဋ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ဉ\u0005\bင\u0006\tဉ\u0007\nင\b\u000bင\t\fင\n", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo"});
        }
        if (i11 == 3) {
            return new m();
        }
        k kVar = null;
        if (i11 == 4) {
            return new l(kVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
