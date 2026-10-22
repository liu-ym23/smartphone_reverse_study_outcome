package h2;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f9253a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f9254b;

    public a(boolean z) {
        this.f9254b = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        kotlin.jvm.internal.g.f(runnable, "runnable");
        StringBuilder sbB = v1.d.b(this.f9254b ? "WM.task-" : "androidx.work-");
        sbB.append(this.f9253a.incrementAndGet());
        return new Thread(runnable, sbB.toString());
    }
}
