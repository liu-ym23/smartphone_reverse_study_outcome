package r3;

import com.google.android.gms.common.internal.C1669j;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import y2.AbstractExecutorServiceC5928i;

/* renamed from: r3.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5215i extends AbstractExecutorServiceC5928i {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f38767b = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f38768a;

    public C5215i() {
        final ThreadFactory threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: r3.t
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(final Runnable runnable) {
                return threadFactoryDefaultThreadFactory.newThread(new Runnable() { // from class: r3.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        C5215i.i(runnable);
                    }
                });
            }
        });
        this.f38768a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static /* synthetic */ void i(Runnable runnable) {
        f38767b.set(new ArrayDeque());
        runnable.run();
    }

    public static void m(Deque deque, Runnable runnable) {
        C1669j.k(deque);
        deque.add(runnable);
        if (deque.size() <= 1) {
            do {
                runnable.run();
                deque.removeFirst();
                runnable = (Runnable) deque.peekFirst();
            } while (runnable != null);
        }
    }

    @Override // y2.P
    public final /* synthetic */ Object b() {
        return this.f38768a;
    }

    @Override // y2.AbstractExecutorServiceC5928i
    public final ExecutorService e() {
        return this.f38768a;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(final Runnable runnable) {
        Deque deque = (Deque) f38767b.get();
        if (deque == null || deque.size() > 1) {
            this.f38768a.execute(new Runnable() { // from class: r3.s
                @Override // java.lang.Runnable
                public final void run() {
                    C5215i.m((Deque) C5215i.f38767b.get(), runnable);
                }
            });
        } else {
            m(deque, runnable);
        }
    }
}
