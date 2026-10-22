package g5;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements ThreadFactory {

    /* renamed from: c, reason: collision with root package name */
    public AtomicInteger f4280c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ boolean f4281f;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        runnable.getClass();
        StringBuilder sbC = w2.c.c(this.f4281f ? "WM.task-" : "androidx.work-");
        sbC.append(this.f4280c.incrementAndGet());
        return new Thread(runnable, sbC.toString());
    }
}
