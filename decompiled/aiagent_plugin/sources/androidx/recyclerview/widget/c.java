package androidx.recyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: AsyncDifferConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f2452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f2453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j.e<T> f2454c;

    /* JADX INFO: compiled from: AsyncDifferConfig.java */
    public static final class a<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Object f2455d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Executor f2456e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Executor f2457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Executor f2458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final j.e<T> f2459c;

        public a(j.e<T> r1) {
            this.f2459c = r1;
        }

        public c<T> a() {
            if (this.f2458b != null) goto L15;
            Object r0 = f2455d;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (f2456e != null) goto L9;
            f2456e = Executors.newFixedThreadPool(2);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.f2458b = f2456e;
        L15:
            return new c(this.f2457a, this.f2458b, this.f2459c);
        }

        static {
            f2455d = new Object();
        }
    }

    c(Executor r3, Executor r4, j.e<T> r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        this.f2452a = r6;
        this.f2453b = r7;
        this.f2454c = r5;
    }

    public Executor a() {
        return this.f2452a;
    }

    public Executor b() {
        return this.f2453b;
    }

    public j.e<T> c() {
        return this.f2454c;
    }
}
