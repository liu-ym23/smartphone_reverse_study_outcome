package pc;

import O6.l;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class d implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadFactory f38461a = Executors.defaultThreadFactory();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f38462b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    public final String f38463c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f38464d;

    public d(String str, boolean z10) {
        this.f38463c = str;
        this.f38464d = z10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f38461a.newThread(runnable);
        threadNewThread.setDaemon(this.f38464d);
        threadNewThread.setName(this.f38463c + l.DATE_SEPARATOR + this.f38462b);
        return threadNewThread;
    }
}
