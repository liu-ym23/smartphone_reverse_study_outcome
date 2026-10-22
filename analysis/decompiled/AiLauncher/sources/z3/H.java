package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;

/* loaded from: classes2.dex */
public final class H extends F0 implements InterfaceC1724i1 {
    private static final H zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";

    static {
        H h10 = new H();
        zzb = h10;
        F0.z(H.class, h10);
    }

    public static H I() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t\u000bဈ\n\fဈ\u000b\rဈ\f\u000eဈ\r", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        }
        if (i11 == 3) {
            return new H();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new G(c6340b);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }

    public final String J() {
        return this.zzk;
    }

    public final String K() {
        return this.zzl;
    }

    public final String L() {
        return this.zzj;
    }

    public final String M() {
        return this.zzm;
    }

    public final String N() {
        return this.zzq;
    }

    public final String O() {
        return this.zze;
    }

    public final String P() {
        return this.zzp;
    }

    public final String Q() {
        return this.zzf;
    }

    public final String R() {
        return this.zzi;
    }

    public final String S() {
        return this.zzo;
    }

    public final String T() {
        return this.zzr;
    }

    public final String U() {
        return this.zzh;
    }

    public final String V() {
        return this.zzn;
    }

    public final String W() {
        return this.zzg;
    }
}
