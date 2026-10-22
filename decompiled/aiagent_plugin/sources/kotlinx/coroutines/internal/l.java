package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient d.c.g f39396a;

    public l(d.c.g r3) {
        this.f39396a = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f39396a.toString();
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return (Throwable) ZeusTransformUtils.preCheckCast(this, Throwable.class, "com.obric.aiagent.plugin");
    }
}
