package com.byted.cast.common.async;

import com.byted.cast.common.Logger;
import com.byted.cast.common.threadpool.CastThreadFactory;
import com.byted.cast.common.threadpool.CastThreadPoolExecutor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class ConcurrentSubject<T> implements Subject<T> {
    private static final String TAG = "ConcurrentSubject";
    private List<Callable<Void>> callables;
    private ExecutorService executor;
    private volatile boolean isDestroy;
    private List<Observer> observers;
    private long timeout;
    private List<Callable<Void>> timeoutCallables;
    private ExecutorService timeoutExecutor;
    private TimerTask timeoutTask;
    private Timer timer;
    private TimeUnit unit;

    /* JADX INFO: renamed from: com.byted.cast.common.async.ConcurrentSubject$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class TimeoutTask extends TimerTask {
        final /* synthetic */ ConcurrentSubject this$0;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com_byted_cast_common_async_ConcurrentSubject$TimeoutTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_byted_cast_common_async_ConcurrentSubject$TimeoutTask__run$___twin___() {
            ConcurrentSubject r100 = this.this$0;
            monitor-enter(r100);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (ConcurrentSubject.access$000(this.this$0) == false) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L14
            return;
        L8:
            this.this$0.notifyException(new TimeoutException());     // Catch: Throwable -> L14
            if (ConcurrentSubject.access$100(this.this$0) == null) goto L11;
            ConcurrentSubject.access$100(this.this$0).clear();     // Catch: Throwable -> L14
            Logger.i(ConcurrentSubject.TAG, "timeout, observers is clear, observers.size" + ConcurrentSubject.access$100(this.this$0).size());     // Catch: Throwable -> L14
        L12:
            monitor-exit(r100);     // Catch: Throwable -> L14
            return;
        L11:
            Logger.i(ConcurrentSubject.TAG, "timeout, observers is null");     // Catch: Throwable -> L14
            goto L12
        }

        private TimeoutTask(ConcurrentSubject r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_byted_cast_common_async_ConcurrentSubject$TimeoutTask_com_larus_apm_impl_protector_RunnableLancet_run(TimeoutTask r100) {
            r100.com_byted_cast_common_async_ConcurrentSubject$TimeoutTask__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ TimeoutTask(ConcurrentSubject r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static /* synthetic */ Void a(Observer r100, Exception r101) {
        return lambda$notifyException$1(r100, r101);
    }

    public static /* synthetic */ Void b(Observer r100, Object r101) {
        return lambda$notifyObserver$0(r100, r101);
    }

    public synchronized void destroy() {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (this.isDestroy == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.isDestroy = true;     // Catch: Throwable -> L28
        List<Observer> r100 = this.observers;     // Catch: Throwable -> L28
        if (r100 == null) goto L11;
        r100.clear();     // Catch: Throwable -> L28
        this.observers = null;     // Catch: Throwable -> L28
    L11:
        ExecutorService r101 = this.executor;     // Catch: Throwable -> L28
        if (r101 == null) goto L14;
        r101.shutdownNow();     // Catch: Throwable -> L28
        this.executor = null;     // Catch: Throwable -> L28
    L14:
        ExecutorService r102 = this.timeoutExecutor;     // Catch: Throwable -> L28
        if (r102 == null) goto L17;
        r102.shutdownNow();     // Catch: Throwable -> L28
        this.timeoutExecutor = null;     // Catch: Throwable -> L28
    L17:
        List<Callable<Void>> r103 = this.callables;     // Catch: Throwable -> L28
        if (r103 == null) goto L20;
        r103.clear();     // Catch: Throwable -> L28
        this.callables = null;     // Catch: Throwable -> L28
    L20:
        List<Callable<Void>> r104 = this.timeoutCallables;     // Catch: Throwable -> L28
        if (r104 == null) goto L23;
        r104.clear();     // Catch: Throwable -> L28
        this.timeoutCallables = null;     // Catch: Throwable -> L28
    L23:
        Timer r105 = this.timer;     // Catch: Throwable -> L28
        if (r105 == null) goto L26;
        r105.cancel();     // Catch: Throwable -> L28
        this.timer = null;     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
    }

    @Override // com.byted.cast.common.async.Subject
    public void clearObservers() {
        Logger.d(TAG, "clearObservers:");
        if (this.isDestroy == false) goto L5;
        return;
    L5:
        this.observers.clear();
    }

    @Override // com.byted.cast.common.async.Subject
    public void dispose() {
        if (this.isDestroy == false) goto L5;
        return;
    L5:
        TimerTask r100 = this.timeoutTask;
        if (r100 == null) goto L8;
        r100.cancel();
    L8:
        this.timeoutCallables.clear();
    }

    public int getObserverSize() {
        return this.observers.size();
    }

    public ConcurrentSubject() {
        this.timeout = -1;
        TimeUnit r100 = TimeUnit.SECONDS;
        this.unit = r100;
        this.isDestroy = false;
        Logger.i(TAG, "ConcurrentSubject ctor");
        this.observers = new CopyOnWriteArrayList();
        this.timer = new PthreadTimer(TAG);
        this.executor = new CastThreadPoolExecutor(4, 32, 10, r100, new LinkedBlockingQueue(64), new CastThreadFactory(TAG));
        this.timeoutExecutor = new CastThreadPoolExecutor(4, 32, 10, r100, new LinkedBlockingQueue(64), new CastThreadFactory(TAG));
        this.callables = new CopyOnWriteArrayList();
        this.timeoutCallables = new CopyOnWriteArrayList();
    }

    public static /* synthetic */ boolean access$000(ConcurrentSubject r100) {
        return r100.isDestroy;
    }

    public static /* synthetic */ List access$100(ConcurrentSubject r100) {
        return r100.observers;
    }

    private void awaitAfterShutdown(ExecutorService r100) {
        if (r100 == null) goto L12;
        r100.shutdown();
    L8:
        r100.shutdownNow();
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L5:
        if (r100.awaitTermination(60, TimeUnit.SECONDS) == true) goto L13;
        r100.shutdownNow();     // Catch: InterruptedException -> L8
        return;
    L13:
        return;
    }

    @Override // com.byted.cast.common.async.Subject
    public Subject addObserver(Observer r100) {
        this.observers.add(r100);
        Logger.i(TAG, "addObserver, size:" + this.observers.size());
        return this;
    }

    @Override // com.byted.cast.common.async.Subject
    public void notifyException(final Exception r100) {
        Logger.d(TAG, "notifyException in");
        if (this.isDestroy == false) goto L5;
        return;
    L5:
        Iterator<Observer> r101 = this.observers.iterator();
    L7:
        if (r101.hasNext() == false) goto L25;
        final Observer r102 = r101.next();
        List<Callable<Void>> r103 = this.timeoutCallables;
        if (r103 == null) goto L10;
        r103.add(new a(r102, r100));
        goto L7
    L10:
        Logger.d(TAG, "notifyException timeoutCallables is null");
        return;
    L25:
        ExecutorService r104 = this.timeoutExecutor;     // Catch: InterruptedException -> L21
        if (r104 == null) goto L19;
        List<Callable<Void>> r105 = this.timeoutCallables;     // Catch: InterruptedException -> L21
        if (r105 == null) goto L19;
        r104.invokeAll(r105);     // Catch: InterruptedException -> L21
    L23:
        Logger.d(TAG, "notifyException out");
        return;
    L19:
        Logger.d(TAG, "notifyException timeoutExecutor or timeoutCallables is null");     // Catch: InterruptedException -> L21
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    @Override // com.byted.cast.common.async.Subject
    public void notifyObserver(final T r100) {
        Logger.d(TAG, "notifyObserver in, content:" + r100);
        if (this.isDestroy == false) goto L5;
        return;
    L5:
        long r101 = System.currentTimeMillis();
        if (r100 == null) goto L26;
        ArrayList r102 = new ArrayList();
        Iterator<Observer> r103 = this.observers.iterator();
    L9:
        if (r103.hasNext() == false) goto L15;
        final Observer r104 = r103.next();
        r102.add(this.executor.submit(new b(r104, r100)));     // Catch: RejectedExecutionException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L15:
        Logger.d(TAG, "notifyObserver, observers.size:" + this.observers.size() + ", futures:" + r102.size());
        Iterator r105 = r102.iterator();     // Catch: InterruptedException -> L21 ExecutionException -> L23
    L18:
        if (r105.hasNext() == false) goto L25;
        ((Future) r105.next()).get();     // Catch: InterruptedException -> L21 ExecutionException -> L23
    L25:
        Logger.d(TAG, "notifyObserver out");
    L21:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = move-exception;
        e.printStackTrace();
    L26:
        System.out.println(System.currentTimeMillis() - r101);
    }

    @Override // com.byted.cast.common.async.Subject
    public void removeObserver(Observer r100) {
        Logger.d(TAG, "removeObserver:");
        if (this.isDestroy == false) goto L5;
        return;
    L5:
        int r101 = this.observers.indexOf(r100);
        if (r101 < 0) goto L9;
        ListProtector.remove(this.observers, r101);
        return;
    }

    @Override // com.byted.cast.common.async.Subject
    public Subject setExecutor(ExecutorService r100) {
        this.executor = r100;
        return this;
    }

    private static /* synthetic */ Void lambda$notifyException$1(Observer r100, Exception r101) throws Exception {
        r100.exception(r101);
        return null;
    }

    private static /* synthetic */ Void lambda$notifyObserver$0(Observer r100, Object r101) throws Exception {
        r100.call(r101);
        return null;
    }

    @Override // com.byted.cast.common.async.Subject
    public Subject setTimeout(long r100, TimeUnit r101) {
        this.timeout = r100;
        this.unit = r101;
        Logger.d(TAG, "setTimeout:" + r101.toMillis(r100) + " ms");
        TimerTask r102 = this.timeoutTask;
        if (r102 == null) goto L6;
        r102.cancel();
    L6:
        if (r100 == 0) goto L14;
        TimerTask r103 = this.timeoutTask;
        if (r103 == null) goto L10;
        r103.cancel();
    L10:
        Timer r104 = this.timer;
        if (r104 == null) goto L13;
        r104.cancel();
        this.timer.purge();
    L13:
        this.timer = new PthreadTimer(TAG);
        TimeoutTask r105 = new TimeoutTask(this, null);
        this.timeoutTask = r105;
        this.timer.schedule(r105, r101.toMillis(r100));
    L14:
        return this;
    }
}
