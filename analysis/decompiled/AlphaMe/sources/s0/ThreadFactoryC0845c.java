package s0;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: s0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ThreadFactoryC0845c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f14180a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f14181b;

    public ThreadFactoryC0845c(boolean z4) {
        this.f14181b = z4;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        StringBuilder sbS = B0.g.s(this.f14181b ? "WM.task-" : "androidx.work-");
        sbS.append(this.f14180a.incrementAndGet());
        return new Thread(runnable, sbS.toString());
    }
}
