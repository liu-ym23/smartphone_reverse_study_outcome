package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: DefaultTaskExecutor.java */
/* JADX INFO: loaded from: classes4.dex */
class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<n, k> f37755a;

    public static /* synthetic */ c lambda$X3jQah5LQ9VnCWjXqO7GbhtBi90() {
        return b();
    }

    e() {
        this.f37755a = new HashMap();
    }

    public k a(n r2) {
        if (r2.q == false) goto L7;
        return a();
    L7:
        return new l(r2);
    }

    @Override // com.ttnet.org.chromium.base.task.j
    public synchronized void a(n r4, Runnable r5, long r6) {
        monitor-enter(this);
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r4.c() == false) goto L6;
        a(r4).a(r7, r6);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        k r0 = (k) ZeusTransformUtils.preCheckCast(this.f37755a.get(r4), k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r0 != null) goto L9;
        r0 = a(r4);     // Catch: Throwable -> L12
        this.f37755a.put(r4, r0);     // Catch: Throwable -> L12
    L9:
        r0.a(r7, r6);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private synchronized c a() {
        monitor-enter(this);
        c r0 = (c) ZeusTransformUtils.preCheckCast(ThreadUtils.a($$Lambda$e$X3jQah5LQ9VnCWjXqO7GbhtBi90.INSTANCE), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ c b() {
        return new c(Choreographer.getInstance());
    }
}
