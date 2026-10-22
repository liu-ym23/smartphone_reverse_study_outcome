package r2;

import B0.f;
import D7.N;
import M0.i;
import N9.j;
import a.AbstractC0291a;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.g;
import com.apm.insight.nativecrash.NativeImpl;
import h2.C1483a;
import h2.RunnableC1484b;
import java.io.File;
import java.util.HashMap;
import k2.C1621a;
import o2.RunnableC1757b;
import org.json.JSONObject;
import t2.AbstractC2013b;
import w2.AbstractC2095a;
import z2.d;
import z2.k;
import z2.l;
import z2.r;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5672a = 0;
    public boolean b;

    public /* synthetic */ b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strA;
        String str;
        d dVar;
        JSONObject jSONObject;
        r rVarI;
        RunnableC1757b runnableC1757b;
        switch (this.f5672a) {
            case 0:
                if (AbstractC0291a.f1623j == null) {
                    AbstractC0291a.f1623j = new HashMap();
                    File file = new File(g.f2160a.getFilesDir(), "/apminsight/selflib/");
                    String[] list = file.list();
                    if (list != null) {
                        for (String str2 : list) {
                            if (str2.endsWith(".ver")) {
                                try {
                                    AbstractC0291a.f1623j.put(str2.substring(0, str2.length() - 4), M.a.w(file.getAbsolutePath() + "/" + str2));
                                } catch (Throwable th) {
                                    int i = com.apm.insight.b.f2156a;
                                    i.k("NPTH_CATCH", th);
                                }
                            } else if (!str2.endsWith(".so")) {
                                M.a.u(new File(file, str2));
                            }
                        }
                    }
                }
                if (!"1.5.0".equals((String) AbstractC0291a.f1623j.get("apminsightb")) || !new File(AbstractC0291a.d()).exists()) {
                    j.i("updateSo", "apminsightb");
                    File file2 = new File(AbstractC0291a.d());
                    file2.getParentFile().mkdirs();
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (g.g.isDebugMode()) {
                        Log.w("npth", "doUnpackLibrary: apminsightb");
                    }
                    try {
                        strA = c.a(g.f2160a, file2);
                    } catch (Throwable th2) {
                        j.i("updateSoError", "apminsightb");
                        int i6 = com.apm.insight.b.f2156a;
                        i.k("NPTH_CATCH", th2);
                        strA = null;
                    }
                    if (strA == null) {
                        AbstractC0291a.f1623j.put(file2.getName(), "1.5.0");
                        try {
                            M.a.t("1.5.0", new File(g.f2160a.getFilesDir() + "/apminsight/selflib/apminsightb.ver"), false);
                        } catch (Throwable unused) {
                        }
                        str = "updateSoSuccess";
                    } else if (!this.b) {
                        this.b = true;
                        j.i("updateSoPostRetry", "apminsightb");
                        l.i().b(this, 3000L);
                        break;
                    } else {
                        str = "updateSoFailed";
                    }
                    j.i(str, "apminsightb");
                    break;
                }
                break;
            default:
                if (this.b && !k.g) {
                    new Handler(Looper.getMainLooper()).post(new A1.a(24));
                }
                boolean z10 = this.b;
                Context context = g.f2160a;
                u1.d.s();
                z2.i.a();
                int iH = NativeImpl.h();
                NativeImpl.n();
                try {
                    if (k.e) {
                        int i10 = com.apm.insight.b.f2156a;
                        if (g.g.isEnsureEnable()) {
                            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                            rVarI = l.i();
                            runnableC1757b = new RunnableC1757b(stackTrace, 5, "NativeLibraryLoad faild", "EnsureNotReachHere", null);
                            rVarI.a(runnableC1757b);
                        }
                    } else if (iH < 0) {
                        int i11 = com.apm.insight.b.f2156a;
                        if (g.g.isEnsureEnable()) {
                            StackTraceElement[] stackTrace2 = Thread.currentThread().getStackTrace();
                            rVarI = l.i();
                            runnableC1757b = new RunnableC1757b(stackTrace2, 5, "createCallbackThread faild", "EnsureNotReachHere", null);
                            rVarI.a(runnableC1757b);
                        }
                    }
                } catch (Throwable unused2) {
                }
                C1621a.a().b(context);
                int i12 = com.apm.insight.b.f2156a;
                r rVarI2 = l.i();
                V1.a aVar = new V1.a();
                aVar.b = context;
                rVarI2.b(aVar, 0);
                if (z10) {
                    C1483a c1483a = (C1483a) h2.d.m(context).f4555a;
                    if (!c1483a.c) {
                        c1483a.f4543a = new f(c1483a);
                        c1483a.d = g.c;
                        c1483a.c = true;
                    }
                    k.c = z10;
                }
                w2.l lVarA = w2.l.a();
                RunnableC1484b runnableC1484b = lVarA.c;
                r rVar = lVarA.f6839a;
                if (w2.l.d.isEmpty()) {
                    rVar.b(runnableC1484b, 30000L);
                } else {
                    rVar.a(runnableC1484b);
                }
                if (z10) {
                    new Thread(new A1.a(22), "NPTH-AnrMonitor").start();
                    try {
                        File externalFilesDir = context.getExternalFilesDir("fastbot");
                        if (com.stepos.statsrpk.d.l(g.f2160a) && externalFilesDir != null && externalFilesDir.exists()) {
                            String absolutePath = externalFilesDir.getAbsolutePath();
                            F.i iVar = new F.i();
                            h2.c cVar = l.g;
                            if (cVar != null) {
                                cVar.stopWatching();
                            }
                            h2.c cVar2 = new h2.c(absolutePath, iVar, absolutePath);
                            l.g = cVar2;
                            cVar2.startWatching();
                        }
                    } catch (Throwable unused3) {
                    }
                }
                AbstractC2095a.j();
                if (AbstractC2095a.e()) {
                    AbstractC2095a.b = 40;
                    l.i().a(AbstractC2095a.f6830a);
                }
                NativeImpl.z();
                j.i("afterNpthInitAsync", "noValue");
                if (g.f2168x) {
                    try {
                        String strJ = com.apm.insight.f.j();
                        if (TextUtils.isEmpty(strJ)) {
                            break;
                        } else {
                            int i13 = z2.b.f6926a;
                            if (d.d(strJ) && (dVar = (d) d.c.get(strJ)) != null && (jSONObject = dVar.f6928a) != null) {
                                if (jSONObject.has("crash_optimizer_module") && 1 != N.b(dVar.f6928a, 0, "crash_optimizer_module", "switcher")) {
                                }
                                if (dVar.e()) {
                                    Application application = g.b;
                                    if (AbstractC2013b.f6654a) {
                                        break;
                                    } else {
                                        AbstractC2013b.f6654a = true;
                                        application.registerActivityLifecycleCallbacks(AbstractC2013b.c);
                                        break;
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused4) {
                        return;
                    }
                }
                break;
        }
    }

    public b(boolean z10) {
        this.b = z10;
    }
}
