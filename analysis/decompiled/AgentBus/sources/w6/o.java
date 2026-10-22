package w6;

import com.stepos.cloud.securedata.http.SecureDataHttpClient;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f10813a = new o();

    /* renamed from: b, reason: collision with root package name */
    public static volatile ab.t f10814b;

    public static /* synthetic */ SecureDataHttpClient createHttpClient$default(o oVar, p pVar, p7.k kVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            kVar = null;
        }
        return oVar.a(pVar, kVar);
    }

    public final SecureDataHttpClient a(p pVar, p7.k kVar) {
        q7.k.e(pVar, "runtimeConfig");
        ab.t tVar = f10814b;
        if (tVar == null) {
            synchronized (this) {
                tVar = f10814b;
                if (tVar == null) {
                    ab.s sVar = new ab.s();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    sVar.a(30L, timeUnit);
                    sVar.b(30L, timeUnit);
                    sVar.d(30L, timeUnit);
                    ab.t tVar2 = new ab.t(sVar);
                    f10814b = tVar2;
                    tVar = tVar2;
                }
            }
        }
        return new SecureDataHttpClient(pVar, tVar, kVar);
    }

    public final void b() {
        a7.d dVar;
        i5.f fVar;
        synchronized (this) {
            try {
                ab.t tVar = f10814b;
                if (tVar != null && (fVar = tVar.f627f) != null) {
                    ((ThreadPoolExecutor) fVar.F()).shutdown();
                }
                ab.t tVar2 = f10814b;
                if (tVar2 != null && (dVar = tVar2.f628g) != null) {
                    dVar.j();
                }
                f10814b = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
