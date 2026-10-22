package wa;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f6861a = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final ExecutorService[] c;

    public e() {
        ExecutorService[] executorServiceArr = new ExecutorService[4];
        for (final int i = 0; i < 4; i++) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: wa.c
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable, B7.a.h(i, "TaskEventDispatcher-"));
                    thread.setDaemon(true);
                    return thread;
                }
            });
            k.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
            executorServiceArr[i] = executorServiceNewSingleThreadExecutor;
        }
        this.c = executorServiceArr;
    }

    public final ExecutorService a(String str) {
        ExecutorService[] executorServiceArr = this.c;
        return (str == null || str.length() == 0) ? executorServiceArr[0] : executorServiceArr[(str.hashCode() & Integer.MAX_VALUE) % 4];
    }
}
