package s2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import r2.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final k f11878a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineDispatcher f11879b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f11880c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    public final a f11881d = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Executor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.this.f11880c.post(runnable);
        }
    }

    public c(ExecutorService executorService) {
        k kVar = new k(executorService);
        this.f11878a = kVar;
        this.f11879b = ExecutorsKt.from(kVar);
    }

    @Override // s2.b
    public final a a() {
        return this.f11881d;
    }

    @Override // s2.b
    public final CoroutineDispatcher b() {
        return this.f11879b;
    }

    @Override // s2.b
    public final k c() {
        return this.f11878a;
    }
}
