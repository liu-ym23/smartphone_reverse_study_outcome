package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class aj {
    public static final void a(d.c.g r3, Throwable r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        CoroutineExceptionHandler r0 = (CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(r5.get((d.c.g.c) ZeusTransformUtils.preCheckCast(CoroutineExceptionHandler.f38768a, d.c.g.c.class, "com.obric.aiagent.plugin")), CoroutineExceptionHandler.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.handleException(r5, r4);     // Catch: Throwable -> L9
        return;
    L7:
        kotlinx.coroutines.internal.j.a(r5, r4);
        return;
    L9:
        th = move-exception;
        kotlinx.coroutines.internal.j.a(r5, a(r4, th));
    }

    public static final Throwable a(Throwable r2, Throwable r3) {
        if (r2 != r3) goto L4;
        return r2;
    L4:
        RuntimeException r0 = new RuntimeException("Exception while trying to handle coroutine exception", r3);
        d.a.a((Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.aiagent.plugin"), r2);
        return (Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.aiagent.plugin");
    }
}
