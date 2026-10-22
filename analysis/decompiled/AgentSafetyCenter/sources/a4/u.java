package a4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u implements i {

    /* renamed from: a, reason: collision with root package name */
    public Context f201a;

    /* renamed from: b, reason: collision with root package name */
    public k3.c f202b;

    /* renamed from: c, reason: collision with root package name */
    public f7.f f203c;

    /* renamed from: d, reason: collision with root package name */
    public Object f204d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f205e;

    /* renamed from: f, reason: collision with root package name */
    public ThreadPoolExecutor f206f;

    /* renamed from: g, reason: collision with root package name */
    public ThreadPoolExecutor f207g;

    /* renamed from: h, reason: collision with root package name */
    public id.k f208h;

    @Override // a4.i
    public final void a(id.k kVar) {
        synchronized (this.f204d) {
            this.f208h = kVar;
        }
        synchronized (this.f204d) {
            try {
                if (this.f208h == null) {
                    return;
                }
                if (this.f206f == null) {
                    ThreadPoolExecutor threadPoolExecutorU = h5.t.u("emojiCompat");
                    this.f207g = threadPoolExecutorU;
                    this.f206f = threadPoolExecutorU;
                }
                ThreadPoolExecutor threadPoolExecutor = this.f206f;
                t tVar = new t(0);
                tVar.f200f = this;
                VarHandle.storeStoreFence();
                threadPoolExecutor.execute(tVar);
            } finally {
            }
        }
    }

    public final void b() {
        synchronized (this.f204d) {
            try {
                this.f208h = null;
                Handler handler = this.f205e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f205e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f207g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f206f = null;
                this.f207g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final k3.h c() {
        try {
            f7.f fVar = this.f203c;
            Context context = this.f201a;
            k3.c cVar = this.f202b;
            fVar.getClass();
            wd.a aVarA = k3.b.a(context, List.of(cVar));
            int i = aVarA.f15389f;
            if (i != 0) {
                od.f.o(k0.a.k(i, "fetchFonts failed (", ")"));
                return null;
            }
            k3.h[] hVarArr = (k3.h[]) ((List) aVarA.f15390g).get(0);
            if (hVarArr != null && hVarArr.length != 0) {
                return hVarArr[0];
            }
            od.f.o("fetchFonts failed (empty result)");
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            od.f.g("provider not found", e10);
            return null;
        }
    }
}
