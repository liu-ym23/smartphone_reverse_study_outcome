package w3;

import android.os.SystemClock;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.mlkit.common.MlKitException;
import java.util.Iterator;
import java.util.List;
import r3.AbstractC5212f;
import r3.C5214h;
import t3.C5506b;
import u3.C5573a;
import x3.C5846a;
import y3.C5937a;
import z2.A8;
import z2.B8;
import z2.C5;
import z2.C6122e6;
import z2.C6176k0;
import z2.C6186l0;
import z2.C6206n0;
import z2.C6315y;
import z2.C6321y5;
import z2.D8;
import z2.E8;
import z2.I5;
import z2.InterfaceC6244q8;
import z2.U5;

/* loaded from: classes2.dex */
public final class k extends AbstractC5212f {

    /* renamed from: j, reason: collision with root package name */
    public static final y3.d f43080j = y3.d.b();

    /* renamed from: k, reason: collision with root package name */
    public static boolean f43081k = true;

    /* renamed from: d, reason: collision with root package name */
    public final C5506b f43082d;

    /* renamed from: e, reason: collision with root package name */
    public final l f43083e;

    /* renamed from: f, reason: collision with root package name */
    public final B8 f43084f;

    /* renamed from: g, reason: collision with root package name */
    public final D8 f43085g;

    /* renamed from: h, reason: collision with root package name */
    public final C5937a f43086h = new C5937a();

    /* renamed from: i, reason: collision with root package name */
    public boolean f43087i;

    public k(C5214h c5214h, C5506b c5506b, l lVar, B8 b82) {
        C1669j.l(c5214h, "MlKitContext can not be null");
        C1669j.l(c5506b, "BarcodeScannerOptions can not be null");
        this.f43082d = c5506b;
        this.f43083e = lVar;
        this.f43084f = b82;
        this.f43085g = D8.a(c5214h.b());
    }

    @Override // r3.AbstractC5216j
    public final synchronized void b() throws MlKitException {
        this.f43087i = this.f43083e.zzc();
    }

    @Override // r3.AbstractC5216j
    public final synchronized void d() {
        try {
            this.f43083e.zzb();
            f43081k = true;
            U5 u52 = new U5();
            zzra zzraVar = this.f43087i ? zzra.TYPE_THICK : zzra.TYPE_THIN;
            B8 b82 = this.f43084f;
            u52.e(zzraVar);
            C6122e6 c6122e6 = new C6122e6();
            c6122e6.i(C5725b.c(this.f43082d));
            u52.g(c6122e6.j());
            b82.d(E8.d(u52), zzrc.ON_DEVICE_BARCODE_CLOSE);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final /* synthetic */ InterfaceC6244q8 j(long j10, zzrb zzrbVar, C6315y c6315y, C6315y c6315y2, C5846a c5846a) {
        C6122e6 c6122e6 = new C6122e6();
        I5 i52 = new I5();
        i52.c(Long.valueOf(j10));
        i52.d(zzrbVar);
        i52.e(Boolean.valueOf(f43081k));
        Boolean bool = Boolean.TRUE;
        i52.a(bool);
        i52.b(bool);
        c6122e6.h(i52.f());
        c6122e6.i(C5725b.c(this.f43082d));
        c6122e6.e(c6315y.g());
        c6122e6.f(c6315y2.g());
        int iE = c5846a.e();
        int iC = f43080j.c(c5846a);
        C5 c52 = new C5();
        c52.a(iE != -1 ? iE != 35 ? iE != 842094169 ? iE != 16 ? iE != 17 ? zzqi.UNKNOWN_FORMAT : zzqi.NV21 : zzqi.NV16 : zzqi.YV12 : zzqi.YUV_420_888 : zzqi.BITMAP);
        c52.b(Integer.valueOf(iC));
        c6122e6.g(c52.d());
        U5 u52 = new U5();
        u52.e(this.f43087i ? zzra.TYPE_THICK : zzra.TYPE_THIN);
        u52.g(c6122e6.j());
        return E8.d(u52);
    }

    public final /* synthetic */ InterfaceC6244q8 k(C6206n0 c6206n0, int i10, C6321y5 c6321y5) {
        U5 u52 = new U5();
        u52.e(this.f43087i ? zzra.TYPE_THICK : zzra.TYPE_THIN);
        C6176k0 c6176k0 = new C6176k0();
        c6176k0.a(Integer.valueOf(i10));
        c6176k0.c(c6206n0);
        c6176k0.b(c6321y5);
        u52.d(c6176k0.e());
        return E8.d(u52);
    }

    @Override // r3.AbstractC5212f
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final synchronized List i(C5846a c5846a) throws Throwable {
        k kVar;
        C5846a c5846a2;
        try {
            try {
                C5937a c5937a = this.f43086h;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                c5937a.a(c5846a);
                try {
                    List listA = this.f43083e.a(c5846a);
                    kVar = this;
                    c5846a2 = c5846a;
                    try {
                        kVar.m(zzrb.NO_ERROR, jElapsedRealtime, c5846a2, listA);
                        f43081k = false;
                        return listA;
                    } catch (MlKitException e10) {
                        e = e10;
                        MlKitException mlKitException = e;
                        kVar.m(mlKitException.a() == 14 ? zzrb.MODEL_NOT_DOWNLOADED : zzrb.UNKNOWN_ERROR, jElapsedRealtime, c5846a2, null);
                        throw mlKitException;
                    }
                } catch (MlKitException e11) {
                    e = e11;
                    kVar = this;
                    c5846a2 = c5846a;
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    public final void m(final zzrb zzrbVar, long j10, final C5846a c5846a, List list) {
        final C6315y c6315y = new C6315y();
        final C6315y c6315y2 = new C6315y();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C5573a c5573a = (C5573a) it.next();
                c6315y.e(C5725b.a(c5573a.b()));
                c6315y2.e(C5725b.b(c5573a.d()));
            }
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j10;
        this.f43084f.f(new A8() { // from class: w3.i
            @Override // z2.A8
            public final InterfaceC6244q8 zza() {
                return this.f43073a.j(jElapsedRealtime, zzrbVar, c6315y, c6315y2, c5846a);
            }
        }, zzrc.ON_DEVICE_BARCODE_DETECT);
        C6186l0 c6186l0 = new C6186l0();
        c6186l0.e(zzrbVar);
        c6186l0.f(Boolean.valueOf(f43081k));
        c6186l0.g(C5725b.c(this.f43082d));
        c6186l0.c(c6315y.g());
        c6186l0.d(c6315y2.g());
        final C6206n0 c6206n0H = c6186l0.h();
        final j jVar = new j(this);
        final B8 b82 = this.f43084f;
        final zzrc zzrcVar = zzrc.AGGREGATED_ON_DEVICE_BARCODE_DETECTION;
        com.google.mlkit.common.sdkinternal.a.d().execute(new Runnable() { // from class: z2.z8
            @Override // java.lang.Runnable
            public final void run() {
                b82.h(zzrcVar, c6206n0H, jElapsedRealtime, jVar);
            }
        });
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f43085g.c(true != this.f43087i ? 24301 : 24302, zzrbVar.zza(), jCurrentTimeMillis - jElapsedRealtime, jCurrentTimeMillis);
    }
}
