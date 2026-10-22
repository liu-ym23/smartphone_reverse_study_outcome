package com.ttnet.org.chromium.base.task;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SerialExecutor.java */
/* JADX INFO: loaded from: classes4.dex */
class h implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayDeque<Runnable> f37758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Runnable f37759b;

    h() {
        this.f37758a = new ArrayDeque();
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable r3) {
        monitor-enter(this);
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        this.f37758a.offer(new AnonymousClass1(this, r4));     // Catch: Throwable -> L8
        if (this.f37759b != null) goto L6;
        a();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void a() {
        monitor-enter(this);
        Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(this.f37758a.poll(), Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        this.f37759b = r0;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        a.f37740a.execute(this.f37759b);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
