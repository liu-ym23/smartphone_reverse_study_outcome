package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f2581a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque<Runnable> f2582b;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f2583c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2584d;

    public p(Executor executor) {
        kotlin.jvm.internal.g.f(executor, "executor");
        this.f2581a = executor;
        this.f2582b = new ArrayDeque<>();
        this.f2584d = new Object();
    }

    public final void b() {
        synchronized (this.f2584d) {
            try {
                Runnable runnablePoll = this.f2582b.poll();
                Runnable runnable = runnablePoll;
                this.f2583c = runnable;
                if (runnablePoll != null) {
                    this.f2581a.execute(runnable);
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable command) {
        kotlin.jvm.internal.g.f(command, "command");
        synchronized (this.f2584d) {
            try {
                this.f2582b.offer(new o(0, command, this));
                if (this.f2583c == null) {
                    b();
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
