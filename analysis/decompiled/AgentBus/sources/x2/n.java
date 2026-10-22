package x2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.lifecycle.a0;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class n implements f {

    /* renamed from: f, reason: collision with root package name */
    public final Context f11131f;

    /* renamed from: g, reason: collision with root package name */
    public final m2.c f11132g;

    /* renamed from: h, reason: collision with root package name */
    public final w4.a f11133h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f11134i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public Handler f11135j;

    /* renamed from: k, reason: collision with root package name */
    public ThreadPoolExecutor f11136k;

    /* renamed from: l, reason: collision with root package name */
    public ThreadPoolExecutor f11137l;

    /* renamed from: m, reason: collision with root package name */
    public n7.a f11138m;

    public n(Context context, m2.c cVar) {
        ib.c.n(context, "Context cannot be null");
        this.f11131f = context.getApplicationContext();
        this.f11132g = cVar;
        this.f11133h = o.f11139d;
    }

    @Override // x2.f
    public final void B(n7.a aVar) {
        synchronized (this.f11134i) {
            this.f11138m = aVar;
        }
        synchronized (this.f11134i) {
            try {
                if (this.f11138m == null) {
                    return;
                }
                if (this.f11136k == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new c6.b(1, "emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f11137l = threadPoolExecutor;
                    this.f11136k = threadPoolExecutor;
                }
                this.f11136k.execute(new a0(8, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        synchronized (this.f11134i) {
            try {
                this.f11138m = null;
                Handler handler = this.f11135j;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f11135j = null;
                ThreadPoolExecutor threadPoolExecutor = this.f11137l;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f11136k = null;
                this.f11137l = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final m2.d b() {
        try {
            w4.a aVar = this.f11133h;
            Context context = this.f11131f;
            m2.c cVar = this.f11132g;
            aVar.getClass();
            d1.b bVarA = m2.b.a(context, List.of(cVar));
            int i2 = bVarA.f2767g;
            if (i2 != 0) {
                throw new RuntimeException(a1.a.f(i2, "fetchFonts failed (", ")"));
            }
            m2.d[] dVarArr = (m2.d[]) ((List) bVarA.f2768h).get(0);
            if (dVarArr == null || dVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return dVarArr[0];
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("provider not found", e10);
        }
    }
}
