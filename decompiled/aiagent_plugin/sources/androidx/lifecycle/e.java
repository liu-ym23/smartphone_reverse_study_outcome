package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cm;

/* JADX INFO: compiled from: DispatchQueue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue<Runnable> f2049d;

    /* JADX INFO: renamed from: lambda$h_yNuUA2ASgUlXo5A3Rusw2-0a8, reason: not valid java name */
    public static /* synthetic */ void m4lambda$h_yNuUA2ASgUlXo5A3Rusw20a8(e r0, Runnable r1) {
        a(r0, r1);
    }

    public e() {
        this.f2046a = true;
        this.f2049d = (Queue) ZeusTransformUtils.preCheckCast(new ArrayDeque(), Queue.class, "com.obric.aiagent.plugin");
    }

    public final void a() {
        this.f2046a = true;
    }

    public final void b() {
        if (this.f2046a == true) goto L6;
        return;
    L6:
        if ((!this.f2047b) == false) goto L10;
        this.f2046a = false;
        d();
        return;
    L10:
        throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
    }

    public final void c() {
        this.f2047b = true;
        d();
    }

    public final void d() {
        if (this.f2048c == false) goto L21;
        return;
    L21:
        this.f2048c = true;     // Catch: Throwable -> L18
    L8:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f2049d, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L16;
        if (e() == false) goto L16;
        Runnable r3 = (Runnable) ZeusTransformUtils.preCheckCast(this.f2049d.poll(), Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r3 == null) goto L8;
        r3.run();     // Catch: Throwable -> L18
    L16:
        this.f2048c = false;
        return;
    L18:
        th = move-exception;
        this.f2048c = false;
        throw th;
    }

    public final boolean e() {
        if (this.f2047b == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f2046a == false) goto L8;
        return false;
    }

    public final void a(d.c.g r3, Runnable r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        final Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        d.h.b.o.e(r6, "runnable");
        cm r0 = bd.b().a();
        if (r0.a(r5) == false) goto L5;
    L8:
        r0.a(r5, new $$Lambda$e$h_yNuUA2ASgUlXo5A3Rusw20a8(this, r6));
        return;
    L5:
        if (e() == true) goto L8;
        a(r6);
    }

    private static final void a(e r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "this$0");
        d.h.b.o.e(r4, "$runnable");
        r2.a(r4);
    }

    private final void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.f2049d.offer(r4) == false) goto L7;
        d();
        return;
    L7:
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }
}
