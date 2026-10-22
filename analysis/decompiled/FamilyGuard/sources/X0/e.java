package X0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Executor f5787a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final Executor f5788b = new b();

    class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f5789a = new Handler(Looper.getMainLooper());

        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f5789a.post(runnable);
        }
    }

    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f5788b;
    }

    public static Executor b() {
        return f5787a;
    }
}
