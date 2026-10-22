package z3;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.L0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.Q;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import java.util.List;

/* loaded from: classes2.dex */
public final class s extends F0 implements InterfaceC1724i1 {
    private static final s zzb;
    private byte zzA = 2;
    private int zzd;
    private int zze;
    private zzdf zzf;
    private String zzg;
    private C6344f zzh;
    private int zzi;
    private F zzj;
    private L zzk;
    private Q zzl;
    private C6348j zzm;
    private q zzn;
    private C6351m zzo;
    private P zzp;
    private C6338D zzq;
    private H zzr;
    private z zzs;
    private M0 zzt;
    private L0 zzu;
    private String zzv;
    private M0 zzw;
    private boolean zzx;
    private double zzy;
    private zzdf zzz;

    static {
        s sVar = new s();
        zzb = sVar;
        F0.z(s.class, sVar);
    }

    public s() {
        zzdf zzdfVar = zzdf.f20159b;
        this.zzf = zzdfVar;
        this.zzg = "";
        this.zzt = F0.t();
        this.zzu = F0.s();
        this.zzv = "";
        this.zzw = F0.t();
        this.zzx = true;
        this.zzz = zzdfVar;
    }

    public static /* synthetic */ void W(s sVar, int i10, C6346h c6346h) {
        c6346h.getClass();
        M0 m02 = sVar.zzt;
        if (!m02.zzc()) {
            sVar.zzt = F0.u(m02);
        }
        sVar.zzt.set(i10, c6346h);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
    public final Object F(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzA);
        }
        if (i11 == 2) {
            return F0.w(zzb, "\u0004\u0016\u0000\u0001\u0001\u0017\u0016\u0000\u0003\u000b\u0001ᴌ\u0000\u0002ᔊ\u0001\u0003ᔈ\u0002\u0004ᴌ\u0004\u0005ᐉ\u0005\u0006ဉ\u0006\u0007ဉ\u0007\bᐉ\b\tᐉ\t\nᐉ\n\u000bЛ\fဈ\u000f\rЛ\u000eည\u0012\u000fᐉ\u000b\u0010ဉ\f\u0011ဉ\r\u0012\u0016\u0013ဉ\u000e\u0014ဇ\u0010\u0015က\u0011\u0017ဉ\u0003", new Object[]{"zzd", "zze", t.f45180a, "zzf", "zzg", "zzi", v.f45181a, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzt", C6346h.class, "zzv", "zzw", C6346h.class, "zzz", "zzp", "zzq", "zzr", "zzu", "zzs", "zzx", "zzy", "zzh"});
        }
        if (i11 == 3) {
            return new s();
        }
        C6340b c6340b = null;
        if (i11 == 4) {
            return new r(c6340b);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzA = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final int H() {
        int iA = w.a(this.zzi);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    public final int I() {
        return this.zzt.size();
    }

    public final Q J() {
        Q q10 = this.zzl;
        return q10 == null ? Q.I() : q10;
    }

    public final C6338D L() {
        C6338D c6338d = this.zzq;
        return c6338d == null ? C6338D.K() : c6338d;
    }

    public final F M() {
        F f10 = this.zzj;
        return f10 == null ? F.J() : f10;
    }

    public final H N() {
        H h10 = this.zzr;
        return h10 == null ? H.I() : h10;
    }

    public final L O() {
        L l10 = this.zzk;
        return l10 == null ? L.I() : l10;
    }

    public final P P() {
        P p10 = this.zzp;
        return p10 == null ? P.K() : p10;
    }

    public final C6348j Q() {
        C6348j c6348j = this.zzm;
        return c6348j == null ? C6348j.I() : c6348j;
    }

    public final C6351m R() {
        C6351m c6351m = this.zzo;
        return c6351m == null ? C6351m.I() : c6351m;
    }

    public final q S() {
        q qVar = this.zzn;
        return qVar == null ? q.I() : qVar;
    }

    public final zzdf T() {
        return this.zzf;
    }

    public final String U() {
        return this.zzg;
    }

    public final List V() {
        return this.zzt;
    }

    public final boolean X() {
        return (this.zzd & 4096) != 0;
    }

    public final boolean Y() {
        return (this.zzd & 32) != 0;
    }

    public final boolean Z() {
        return (this.zzd & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0;
    }

    public final boolean a0() {
        return (this.zzd & 64) != 0;
    }

    public final boolean b0() {
        return (this.zzd & 2048) != 0;
    }

    public final boolean c0() {
        return (this.zzd & 128) != 0;
    }

    public final boolean d0() {
        return (this.zzd & 256) != 0;
    }

    public final boolean e0() {
        return (this.zzd & 1024) != 0;
    }

    public final boolean f0() {
        return (this.zzd & 512) != 0;
    }

    public final int g0() {
        int iA = u.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
