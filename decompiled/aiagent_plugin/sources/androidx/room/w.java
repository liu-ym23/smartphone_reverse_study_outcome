package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: TransactionExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class w implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f2708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque<Runnable> f2709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f2710c;

    w(Executor r3) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
        this.f2709b = new ArrayDeque();
        this.f2708a = r4;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable r3) {
        monitor-enter(this);
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        this.f2709b.offer(new AnonymousClass1(this, r4));     // Catch: Throwable -> L8
        if (this.f2710c != null) goto L6;
        a();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized void a() {
        monitor-enter(this);
        Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(this.f2709b.poll(), Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        this.f2710c = r0;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        this.f2708a.execute(r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
