package androidx.lifecycle;

import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.o1;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue f3537d;

    public h() {
        this.f3534a = true;
        this.f3537d = new ArrayDeque();
    }

    public static /* synthetic */ void a(h r10, Runnable r11) {
        d(r10, r11);
    }

    public static final void d(h r10, Runnable r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$runnable");
        r10.f(r11);
    }

    public final boolean b() {
        if (this.f3535b == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f3534a == false) goto L8;
        return false;
    }

    public final void c(CoroutineContext r10, final Runnable r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "runnable");
        o1 r12 = kotlinx.coroutines.l0.c().e();
        if (r12.c(r10) == false) goto L5;
    L8:
        r12.a(r10, new g(this, r11));
        return;
    L5:
        if (b() == true) goto L8;
        f(r11);
    }

    public final void e() {
        if (this.f3536c == false) goto L22;
        return;
    L22:
        this.f3536c = true;     // Catch: Throwable -> L16
    L8:
        if (this.f3537d.isEmpty() == true) goto L18;
        if (b() == false) goto L18;
        Runnable r10 = (Runnable) this.f3537d.poll();     // Catch: Throwable -> L16
        if (r10 == null) goto L8;
        r10.run();     // Catch: Throwable -> L16
    L18:
        this.f3536c = false;
        return;
    L16:
        th = move-exception;
        this.f3536c = false;
        throw th;
    }

    public final void f(Runnable r10) {
        if (this.f3537d.offer(r10) == false) goto L7;
        e();
        return;
    L7:
        throw new IllegalStateException("cannot enqueue any more runnables");
    }

    public final void g() {
        this.f3535b = true;
        e();
    }

    public final void h() {
        this.f3534a = true;
    }

    public final void i() {
        if (this.f3534a == true) goto L6;
        return;
    L6:
        if (this.f3535b == true) goto L10;
        this.f3534a = false;
        e();
        return;
    L10:
        throw new IllegalStateException("Cannot resume a finished dispatcher");
    }
}
