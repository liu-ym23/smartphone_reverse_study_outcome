package z2;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import com.google.android.gms.common.internal.C1667h;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcu;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import r3.C5209c;

/* loaded from: classes2.dex */
public final class B8 {

    /* renamed from: k, reason: collision with root package name */
    public static zzcs f44606k;

    /* renamed from: l, reason: collision with root package name */
    public static final zzcu f44607l = zzcu.d("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* renamed from: a, reason: collision with root package name */
    public final String f44608a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44609b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC6254r8 f44610c;

    /* renamed from: d, reason: collision with root package name */
    public final r3.l f44611d;

    /* renamed from: e, reason: collision with root package name */
    public final D2.i f44612e;

    /* renamed from: f, reason: collision with root package name */
    public final D2.i f44613f;

    /* renamed from: g, reason: collision with root package name */
    public final String f44614g;

    /* renamed from: h, reason: collision with root package name */
    public final int f44615h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f44616i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public final Map f44617j = new HashMap();

    public B8(Context context, final r3.l lVar, InterfaceC6254r8 interfaceC6254r8, String str) {
        this.f44608a = context.getPackageName();
        this.f44609b = C5209c.a(context);
        this.f44611d = lVar;
        this.f44610c = interfaceC6254r8;
        O8.a();
        this.f44614g = str;
        this.f44612e = com.google.mlkit.common.sdkinternal.a.a().b(new Callable() { // from class: z2.x8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f45149a.b();
            }
        });
        com.google.mlkit.common.sdkinternal.a aVarA = com.google.mlkit.common.sdkinternal.a.a();
        Objects.requireNonNull(lVar);
        this.f44613f = aVarA.b(new Callable() { // from class: z2.y8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return lVar.a();
            }
        });
        zzcu zzcuVar = f44607l;
        this.f44615h = zzcuVar.containsKey(str) ? DynamiteModule.b(context, (String) zzcuVar.get(str)) : -1;
    }

    public static long a(List list, double d10) {
        return ((Long) list.get(Math.max(((int) Math.ceil((d10 / 100.0d) * list.size())) - 1, 0))).longValue();
    }

    public static synchronized zzcs i() {
        try {
            zzcs zzcsVar = f44606k;
            if (zzcsVar != null) {
                return zzcsVar;
            }
            x0.g gVarA = x0.e.a(Resources.getSystem().getConfiguration());
            C6315y c6315y = new C6315y();
            for (int i10 = 0; i10 < gVarA.f(); i10++) {
                c6315y.e(C5209c.b(gVarA.c(i10)));
            }
            zzcs zzcsVarG = c6315y.g();
            f44606k = zzcsVarG;
            return zzcsVarG;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final /* synthetic */ String b() throws Exception {
        return C1667h.a().b(this.f44614g);
    }

    public final /* synthetic */ void c(InterfaceC6244q8 interfaceC6244q8, zzrc zzrcVar, String str) {
        interfaceC6244q8.b(zzrcVar);
        String strZzd = interfaceC6244q8.zzd();
        N7 n72 = new N7();
        n72.b(this.f44608a);
        n72.c(this.f44609b);
        n72.h(i());
        n72.g(Boolean.TRUE);
        n72.l(strZzd);
        n72.j(str);
        n72.i(this.f44613f.l() ? (String) this.f44613f.i() : this.f44611d.a());
        n72.d(10);
        n72.k(Integer.valueOf(this.f44615h));
        interfaceC6244q8.c(n72);
        this.f44610c.a(interfaceC6244q8);
    }

    public final void d(InterfaceC6244q8 interfaceC6244q8, zzrc zzrcVar) {
        e(interfaceC6244q8, zzrcVar, j());
    }

    public final void e(final InterfaceC6244q8 interfaceC6244q8, final zzrc zzrcVar, final String str) {
        com.google.mlkit.common.sdkinternal.a.d().execute(new Runnable() { // from class: z2.v8
            @Override // java.lang.Runnable
            public final void run() {
                this.f45125a.c(interfaceC6244q8, zzrcVar, str);
            }
        });
    }

    public final void f(A8 a82, zzrc zzrcVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (k(zzrcVar, jElapsedRealtime, 30L)) {
            this.f44616i.put(zzrcVar, Long.valueOf(jElapsedRealtime));
            e(a82.zza(), zzrcVar, j());
        }
    }

    public final /* synthetic */ void g(zzrc zzrcVar, w3.j jVar) {
        InterfaceC6059C interfaceC6059C = (InterfaceC6059C) this.f44617j.get(zzrcVar);
        if (interfaceC6059C != null) {
            for (Object obj : interfaceC6059C.zzw()) {
                ArrayList arrayList = new ArrayList(interfaceC6059C.a(obj));
                Collections.sort(arrayList);
                C6301w5 c6301w5 = new C6301w5();
                Iterator it = arrayList.iterator();
                long jLongValue = 0;
                while (it.hasNext()) {
                    jLongValue += ((Long) it.next()).longValue();
                }
                c6301w5.a(Long.valueOf(jLongValue / arrayList.size()));
                c6301w5.c(Long.valueOf(a(arrayList, 100.0d)));
                c6301w5.f(Long.valueOf(a(arrayList, 75.0d)));
                c6301w5.d(Long.valueOf(a(arrayList, 50.0d)));
                c6301w5.b(Long.valueOf(a(arrayList, 25.0d)));
                c6301w5.e(Long.valueOf(a(arrayList, 0.0d)));
                e(jVar.a(obj, arrayList.size(), c6301w5.g()), zzrcVar, j());
            }
            this.f44617j.remove(zzrcVar);
        }
    }

    public final /* synthetic */ void h(final zzrc zzrcVar, Object obj, long j10, final w3.j jVar) {
        if (!this.f44617j.containsKey(zzrcVar)) {
            this.f44617j.put(zzrcVar, zzbw.n());
        }
        ((InterfaceC6059C) this.f44617j.get(zzrcVar)).b(obj, Long.valueOf(j10));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (k(zzrcVar, jElapsedRealtime, 30L)) {
            this.f44616i.put(zzrcVar, Long.valueOf(jElapsedRealtime));
            com.google.mlkit.common.sdkinternal.a.d().execute(new Runnable() { // from class: z2.w8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45142a.g(zzrcVar, jVar);
                }
            });
        }
    }

    public final String j() {
        if (this.f44612e.l()) {
            return (String) this.f44612e.i();
        }
        return C1667h.a().b(this.f44614g);
    }

    public final boolean k(zzrc zzrcVar, long j10, long j11) {
        return this.f44616i.get(zzrcVar) == null || j10 - ((Long) this.f44616i.get(zzrcVar)).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }
}
