package r2;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k implements s2.a {

    /* renamed from: b, reason: collision with root package name */
    public final Executor f11697b;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f11698c;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque<a> f11696a = new ArrayDeque<>();

    /* renamed from: d, reason: collision with root package name */
    public final Object f11699d = new Object();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final k f11700a;

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f11701b;

        public a(k kVar, Runnable runnable) {
            this.f11700a = kVar;
            this.f11701b = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f11701b.run();
                synchronized (this.f11700a.f11699d) {
                    this.f11700a.b();
                }
            } catch (Throwable th) {
                synchronized (this.f11700a.f11699d) {
                    this.f11700a.b();
                    throw th;
                }
            }
        }
    }

    public k(Executor executor) {
        this.f11697b = executor;
    }

    public final void b() {
        a aVarPoll = this.f11696a.poll();
        this.f11698c = aVarPoll;
        if (aVarPoll != null) {
            this.f11697b.execute(aVarPoll);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f11699d) {
            try {
                this.f11696a.add(new a(this, runnable));
                if (this.f11698c == null) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
