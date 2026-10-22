package kotlinx.coroutines.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import kotlinx.coroutines.bp;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public class f extends bp {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f39238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f39239e;
    private final long f;
    private final String g;
    private a h;

    public f(int r1, int r2, long r3, String r5) {
        this.f39238d = r1;
        this.f39239e = r2;
        this.f = r3;
        this.g = r5;
        this.h = b();
    }

    @Override // kotlinx.coroutines.bp
    public Executor a() {
        return (Executor) ZeusTransformUtils.preCheckCast(this.h, Executor.class, "com.obric.aiagent.plugin");
    }

    private final a b() {
        return new a(this.f39238d, this.f39239e, this.f, this.g);
    }

    @Override // kotlinx.coroutines.ai
    public void a(d.c.g r7, Runnable r8) {
        d.c.g r9 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r7, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.aiagent.plugin");
        a.a(this.h, r1, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.ai
    public void b(d.c.g r7, Runnable r8) {
        d.c.g r9 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r7, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.aiagent.plugin");
        a.a(this.h, r1, null, true, 2, null);
    }

    public final void a(Runnable r3, i r4, boolean r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        i r7 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.aiagent.plugin");
        this.h.a(r6, r7, r5);
    }

    @Override // kotlinx.coroutines.bp, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.h.close();
    }
}
