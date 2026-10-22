package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public final class y0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f4715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque f4716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f4717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4718d;

    public y0(Executor r10) {
        kotlin.jvm.internal.q.g(r10, "executor");
        this.f4715a = r10;
        this.f4716b = new ArrayDeque();
        this.f4718d = new Object();
    }

    public static /* synthetic */ void a(Runnable r10, y0 r11) {
        b(r10, r11);
    }

    public static final void b(Runnable r10, y0 r11) {
        kotlin.jvm.internal.q.g(r10, "$command");
        kotlin.jvm.internal.q.g(r11, "this$0");
        r10.run();     // Catch: Throwable -> L6
        r11.c();
        return;
    L6:
        th = move-exception;
        r11.c();
        throw th;
    }

    public final void c() {
        Object r10 = this.f4718d;
        monitor-enter(r10);
        Object r11 = this.f4716b.poll();     // Catch: Throwable -> L7
        Runnable r12 = (Runnable) r11;     // Catch: Throwable -> L7
        this.f4717c = r12;     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        this.f4715a.execute(r12);     // Catch: Throwable -> L7
    L9:
        Unit r13 = Unit.f21064a;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable r10) {
        kotlin.jvm.internal.q.g(r10, "command");
        Object r11 = this.f4718d;
        monitor-enter(r11);
        this.f4716b.offer(new x0(r10, this));     // Catch: Throwable -> L7
        if (this.f4717c != null) goto L9;
        c();     // Catch: Throwable -> L7
    L9:
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
