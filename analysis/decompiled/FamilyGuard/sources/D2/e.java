package D2;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
abstract class e<K, V> extends g<K, V> {

    /* renamed from: e, reason: collision with root package name */
    private static final ThreadFactory f1175e = new a();

    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f1176a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Loader task #" + this.f1176a.getAndIncrement());
        }
    }

    public e(i<K, V> iVar) {
        super(iVar);
    }

    @Override // D2.g, D2.r
    public void a() {
        super.a();
    }
}
