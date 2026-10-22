package g3;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class q implements Executor {

    /* renamed from: g, reason: collision with root package name */
    public Runnable f3836g;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f3835f = new ArrayDeque();

    /* renamed from: h, reason: collision with root package name */
    public final Object f3837h = new Object();

    public final void a() {
        synchronized (this.f3837h) {
            Object objPoll = this.f3835f.poll();
            Runnable runnable = (Runnable) objPoll;
            this.f3836g = runnable;
            if (objPoll != null) {
                i.a.S().f4389c.f4392d.execute(runnable);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        q7.k.e(runnable, "command");
        synchronized (this.f3837h) {
            this.f3835f.offer(new c.b(1, runnable, this));
            if (this.f3836g == null) {
                a();
            }
        }
    }
}
