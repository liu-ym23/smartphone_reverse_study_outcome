package A2;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import com.google.android.gms.common.internal.C1667h;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_common.zzii;
import com.google.android.gms.internal.mlkit_vision_common.zzio;
import com.google.android.gms.internal.mlkit_vision_common.zziv;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import com.google.android.gms.internal.mlkit_vision_common.zzr;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import r3.C5209c;

/* loaded from: classes2.dex */
public final class s5 {

    /* renamed from: k, reason: collision with root package name */
    public static zzp f892k;

    /* renamed from: l, reason: collision with root package name */
    public static final zzr f893l = zzr.d("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* renamed from: a, reason: collision with root package name */
    public final String f894a;

    /* renamed from: b, reason: collision with root package name */
    public final String f895b;

    /* renamed from: c, reason: collision with root package name */
    public final l5 f896c;

    /* renamed from: d, reason: collision with root package name */
    public final r3.l f897d;

    /* renamed from: e, reason: collision with root package name */
    public final D2.i f898e;

    /* renamed from: f, reason: collision with root package name */
    public final D2.i f899f;

    /* renamed from: g, reason: collision with root package name */
    public final String f900g;

    /* renamed from: h, reason: collision with root package name */
    public final int f901h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f902i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public final Map f903j = new HashMap();

    public s5(Context context, final r3.l lVar, l5 l5Var, String str) {
        this.f894a = context.getPackageName();
        this.f895b = C5209c.a(context);
        this.f897d = lVar;
        this.f896c = l5Var;
        F5.a();
        this.f900g = str;
        this.f898e = com.google.mlkit.common.sdkinternal.a.a().b(new Callable() { // from class: A2.p5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f844a.a();
            }
        });
        com.google.mlkit.common.sdkinternal.a aVarA = com.google.mlkit.common.sdkinternal.a.a();
        lVar.getClass();
        this.f899f = aVarA.b(new Callable() { // from class: A2.q5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return lVar.a();
            }
        });
        zzr zzrVar = f893l;
        this.f901h = zzrVar.containsKey(str) ? DynamiteModule.b(context, (String) zzrVar.get(str)) : -1;
    }

    public static synchronized zzp d() {
        try {
            zzp zzpVar = f892k;
            if (zzpVar != null) {
                return zzpVar;
            }
            x0.g gVarA = x0.e.a(Resources.getSystem().getConfiguration());
            C0631i5 c0631i5 = new C0631i5();
            for (int i10 = 0; i10 < gVarA.f(); i10++) {
                c0631i5.c(C5209c.b(gVarA.c(i10)));
            }
            zzp zzpVarD = c0631i5.d();
            f892k = zzpVarD;
            return zzpVarD;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final /* synthetic */ String a() throws Exception {
        return C1667h.a().b(this.f900g);
    }

    public final /* synthetic */ void b(k5 k5Var, zziv zzivVar, String str) {
        k5Var.a(zzivVar);
        String strZzc = k5Var.zzc();
        G4 g42 = new G4();
        g42.b(this.f894a);
        g42.c(this.f895b);
        g42.h(d());
        g42.g(Boolean.TRUE);
        g42.l(strZzc);
        g42.j(str);
        g42.i(this.f899f.l() ? (String) this.f899f.i() : this.f897d.a());
        g42.d(10);
        g42.k(Integer.valueOf(this.f901h));
        k5Var.b(g42);
        this.f896c.a(k5Var);
    }

    public final void c(C5 c52, final zziv zzivVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f902i.get(zzivVar) != null && jElapsedRealtime - ((Long) this.f902i.get(zzivVar)).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            return;
        }
        this.f902i.put(zzivVar, Long.valueOf(jElapsedRealtime));
        int i10 = c52.f317a;
        int i11 = c52.f318b;
        int i12 = c52.f319c;
        int i13 = c52.f320d;
        int i14 = c52.f321e;
        long j10 = c52.f322f;
        int i15 = c52.f323g;
        C0707v3 c0707v3 = new C0707v3();
        c0707v3.d(i10 != -1 ? i10 != 35 ? i10 != 842094169 ? i10 != 16 ? i10 != 17 ? zzii.UNKNOWN_FORMAT : zzii.NV21 : zzii.NV16 : zzii.YV12 : zzii.YUV_420_888 : zzii.BITMAP);
        c0707v3.f(i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? zzio.ANDROID_MEDIA_IMAGE : zzio.FILEPATH : zzio.BYTEBUFFER : zzio.BYTEARRAY : zzio.BITMAP);
        c0707v3.c(Integer.valueOf(i12));
        c0707v3.e(Integer.valueOf(i13));
        c0707v3.g(Integer.valueOf(i14));
        c0707v3.b(Long.valueOf(j10));
        c0707v3.h(Integer.valueOf(i15));
        C0719x3 c0719x3J = c0707v3.j();
        C3 c32 = new C3();
        c32.d(c0719x3J);
        final k5 k5VarD = t5.d(c32);
        final String strB = this.f898e.l() ? (String) this.f898e.i() : C1667h.a().b(this.f900g);
        com.google.mlkit.common.sdkinternal.a.d().execute(new Runnable() { // from class: A2.r5
            @Override // java.lang.Runnable
            public final void run() {
                this.f872a.b(k5VarD, zzivVar, strB);
            }
        });
    }
}
