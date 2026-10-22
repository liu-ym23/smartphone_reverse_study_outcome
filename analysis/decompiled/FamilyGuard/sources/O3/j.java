package O3;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class j extends AtomicLong implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    final String f4414a;

    /* renamed from: b, reason: collision with root package name */
    final int f4415b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f4416c;

    static final class a extends Thread implements i {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public j(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.f4414a + '-' + incrementAndGet();
        Thread aVar = this.f4416c ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.f4415b);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f4414a + "]";
    }

    public j(String str, int i5) {
        this(str, i5, false);
    }

    public j(String str, int i5, boolean z5) {
        this.f4414a = str;
        this.f4415b = i5;
        this.f4416c = z5;
    }
}
