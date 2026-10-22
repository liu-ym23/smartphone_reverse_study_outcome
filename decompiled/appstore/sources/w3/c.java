package w3;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ExecutorService f25358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ExecutorService f25359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f25360d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f25361a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f25362a;

        public a(c r10) {
            this.f25362a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d("ThreadPlus", "thread count: " + c.f25360d.incrementAndGet());
            this.f25362a.run();     // Catch: Exception -> L5
        L7:
            Logger.d("ThreadPlus", "thread count: " + c.f25360d.decrementAndGet());
            return;
        L5:
            e = move-exception;
            Logger.w("ThreadPlus", "Thread crashed!", e);
            goto L7
        }
    }

    static {
        f25358b = w3.a.a();
        f25359c = w3.a.a();
        f25360d = new AtomicInteger();
    }

    public c(String r10) {
        this(false);
    }

    public static void b(Runnable r10) {
        if (r10 == null) goto L5;
        f25358b.submit(r10);
        return;
    }

    public void a() {
        if (Logger.debug() == false) goto L5;
        Runnable r10 = new a(this);
    L7:
        if (this.f25361a == false) goto L9;
        f25359c.submit(r10);
        return;
    L9:
        f25358b.submit(r10);
        return;
    L5:
        r10 = this;
        goto L7
    }

    @Override // java.lang.Runnable
    public abstract void run();

    public c() {
        this(false);
    }

    public c(boolean r10) {
        this.f25361a = r10;
    }
}
