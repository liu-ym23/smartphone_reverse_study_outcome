package B3;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class h extends AtomicLong implements ThreadFactory {

    /* renamed from: b, reason: collision with root package name */
    public static final g f228b = new g();

    /* renamed from: a, reason: collision with root package name */
    public final String f229a;

    public h(String str) {
        this.f229a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f229a + incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
