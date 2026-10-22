package kotlinx.coroutines.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.internal.am;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends bp implements Executor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f39234d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ai f39235e = null;

    @Override // kotlinx.coroutines.ai
    public String toString() {
        return "Dispatchers.IO";
    }

    private b() {
    }

    static {
        f39234d = new b();
        f39235e = m.f39247a.a(am.a("kotlinx.coroutines.io.parallelism", d.l.n.c(64, am.a()), 0, 0, 12, null));
    }

    @Override // kotlinx.coroutines.bp
    public Executor a() {
        return (Executor) ZeusTransformUtils.preCheckCast(this, Executor.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        a((d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // kotlinx.coroutines.ai
    public ai a(int r1) {
        return m.f39247a.a(r1);
    }

    @Override // kotlinx.coroutines.ai
    public void a(d.c.g r2, Runnable r3) {
        d.c.g r1 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        f39235e.a(r1, r4);
    }

    @Override // kotlinx.coroutines.ai
    public void b(d.c.g r2, Runnable r3) {
        d.c.g r1 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        f39235e.b(r1, r4);
    }

    @Override // kotlinx.coroutines.bp, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }
}
