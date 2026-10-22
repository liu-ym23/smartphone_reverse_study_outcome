package Z7;

import V7.a;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.a;
import com.tencent.bugly.proguard.as;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class r {

    /* renamed from: j, reason: collision with root package name */
    public static int f7580j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f7581k = false;

    /* renamed from: l, reason: collision with root package name */
    public static int f7582l = 2;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f7583m = false;

    /* renamed from: n, reason: collision with root package name */
    public static int f7584n = 20480;

    /* renamed from: o, reason: collision with root package name */
    public static int f7585o = 20480;

    /* renamed from: p, reason: collision with root package name */
    public static long f7586p = 209715200;

    /* renamed from: q, reason: collision with root package name */
    public static long f7587q = 604800000;

    /* renamed from: r, reason: collision with root package name */
    public static String f7588r = null;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f7589s = false;

    /* renamed from: t, reason: collision with root package name */
    public static String f7590t = null;

    /* renamed from: u, reason: collision with root package name */
    public static int f7591u = 5000;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f7592v = true;

    /* renamed from: w, reason: collision with root package name */
    public static boolean f7593w = false;

    /* renamed from: x, reason: collision with root package name */
    public static String f7594x;

    /* renamed from: y, reason: collision with root package name */
    public static String f7595y;

    /* renamed from: z, reason: collision with root package name */
    public static r f7596z;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7597a;

    /* renamed from: b, reason: collision with root package name */
    public final as f7598b;

    /* renamed from: c, reason: collision with root package name */
    public final C1147t f7599c;

    /* renamed from: d, reason: collision with root package name */
    public final NativeCrashHandler f7600d;

    /* renamed from: e, reason: collision with root package name */
    public final C1131c f7601e;

    /* renamed from: f, reason: collision with root package name */
    public final C1138j f7602f;

    /* renamed from: g, reason: collision with root package name */
    public final C1149v f7603g;

    /* renamed from: h, reason: collision with root package name */
    public int f7604h = 31;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7605i = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeCrashHandler.r().G(true);
        }
    }

    public class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            List<CrashDetailBean> list;
            if (!C1143o.t(r.this.f7597a, "local_crash_lock")) {
                C1139k.h("Failed to lock file for uploading local crash.", new Object[0]);
                return;
            }
            com.tencent.bugly.proguard.a aVar = a.b.f31543a;
            List<a.c> listB = com.tencent.bugly.proguard.a.b();
            if (listB == null || listB.isEmpty()) {
                C1139k.h("sla local data is null", new Object[0]);
            } else {
                C1139k.h("sla load local data list size:%s", Integer.valueOf(listB.size()));
                Iterator<a.c> it = listB.iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    a.c next = it.next();
                    if (next.f31545b < C1143o.z() - 604800000) {
                        C1139k.h("sla local data is expired:%s", next.f31546c);
                        arrayList.add(next);
                        it.remove();
                    }
                }
                com.tencent.bugly.proguard.a.h(arrayList);
                aVar.f(listB);
            }
            List<CrashDetailBean> listF = as.f();
            if (listF == null || listF.size() <= 0) {
                C1139k.h("no crash need to be uploaded at this start", new Object[0]);
            } else {
                C1139k.h("Size of crash list: %s", Integer.valueOf(listF.size()));
                int size = listF.size();
                if (size > 20) {
                    ArrayList arrayList2 = new ArrayList();
                    Collections.sort(listF);
                    for (int i10 = 0; i10 < 20; i10++) {
                        arrayList2.add(listF.get((size - 1) - i10));
                    }
                    list = arrayList2;
                } else {
                    list = listF;
                }
                r.this.f7598b.r(list, 0L, false, false, false);
            }
            C1143o.E(r.this.f7597a, "local_crash_lock");
        }
    }

    public r(Context context, C1138j c1138j, boolean z10, a.C0112a c0112a) {
        f7580j = 1004;
        Context contextA = C1143o.a(context);
        this.f7597a = contextA;
        C1131c c1131cA = C1131c.a();
        this.f7601e = c1131cA;
        this.f7602f = c1138j;
        as asVar = new as(contextA, C1136h.c(), V.f(), c1131cA, c0112a);
        this.f7598b = asVar;
        C1130b c1130bH = C1130b.h(contextA);
        this.f7599c = new C1147t(contextA, asVar, c1131cA, c1130bH);
        NativeCrashHandler nativeCrashHandlerS = NativeCrashHandler.s(contextA, c1130bH, asVar, c1131cA, c1138j, z10, null);
        this.f7600d = nativeCrashHandlerS;
        c1130bH.f7464j0 = nativeCrashHandlerS;
        if (C1149v.f7631o == null) {
            C1149v.f7631o = new C1149v(contextA, c1131cA, c1130bH, c1138j, asVar);
        }
        this.f7603g = C1149v.f7631o;
    }

    public static synchronized r a() {
        return f7596z;
    }

    public static synchronized r b(Context context, boolean z10, a.C0112a c0112a) {
        try {
            if (f7596z == null) {
                f7596z = new r(context, C1138j.a(), z10, c0112a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7596z;
    }

    public final void c(long j10) {
        C1138j.a().c(new b(), j10);
    }

    public final void d(CrashDetailBean crashDetailBean) {
        this.f7598b.A(crashDetailBean);
    }

    public final void f() {
        this.f7600d.E(true);
    }

    public final void g() {
        new Handler(Looper.getMainLooper()).post(new a());
        this.f7603g.i(true);
    }

    public final boolean h() {
        return this.f7603g.f7632a.get();
    }

    public final boolean i() {
        return (this.f7604h & 16) > 0;
    }

    public final boolean j() {
        return (this.f7604h & 8) > 0;
    }
}
