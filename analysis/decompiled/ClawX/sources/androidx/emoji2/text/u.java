package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u implements i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f634a;

    /* renamed from: b, reason: collision with root package name */
    public final b0.e f635b;

    /* renamed from: c, reason: collision with root package name */
    public final t1.f f636c;
    public final Object d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public Handler f637e;

    /* renamed from: f, reason: collision with root package name */
    public ThreadPoolExecutor f638f;

    /* renamed from: g, reason: collision with root package name */
    public ThreadPoolExecutor f639g;

    /* renamed from: h, reason: collision with root package name */
    public b8.h f640h;

    public u(Context context, b0.e eVar) {
        a.a.j(context, "Context cannot be null");
        this.f634a = context.getApplicationContext();
        this.f635b = eVar;
        this.f636c = v.d;
    }

    public final void a() {
        synchronized (this.d) {
            try {
                this.f640h = null;
                Handler handler = this.f637e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f637e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f639g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f638f = null;
                this.f639g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final b0.k b() {
        try {
            t1.f fVar = this.f636c;
            Context context = this.f634a;
            b0.e eVar = this.f635b;
            fVar.getClass();
            b0.j jVarA = b0.d.a(context, List.of(eVar));
            int i8 = jVarA.f832a;
            if (i8 != 0) {
                throw new RuntimeException(a8.b.k(i8, "fetchFonts failed (", ")"));
            }
            b0.k[] kVarArr = (b0.k[]) ((List) jVarA.f833b).get(0);
            if (kVarArr == null || kVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return kVarArr[0];
        } catch (PackageManager.NameNotFoundException e9) {
            throw new RuntimeException("provider not found", e9);
        }
    }

    @Override // androidx.emoji2.text.i
    public final void e(b8.h hVar) {
        synchronized (this.d) {
            this.f640h = hVar;
        }
        synchronized (this.d) {
            try {
                if (this.f640h == null) {
                    return;
                }
                if (this.f638f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f639g = threadPoolExecutor;
                    this.f638f = threadPoolExecutor;
                }
                this.f638f.execute(new t(0, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
