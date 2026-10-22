package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;

/* renamed from: z3.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6346h extends F0 implements InterfaceC1724i1 {
    private static final C6346h zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private byte zzg = 2;

    static {
        C6346h c6346h = new C6346h();
        zzb = c6346h;
        F0.z(C6346h.class, c6346h);
    }

    public static C6345g J() {
        return (C6345g) zzb.k();
    }

    public static /* synthetic */ void L(C6346h c6346h, int i10) {
        c6346h.zzd |= 1;
        c6346h.zze = i10;
    }

    public static /* synthetic */ void M(C6346h c6346h, int i10) {
        c6346h.zzd |= 2;
        c6346h.zzf = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new C6346h();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new C6345g(c6340b);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final int H() {
        return this.zze;
    }

    public final int I() {
        return this.zzf;
    }
}
