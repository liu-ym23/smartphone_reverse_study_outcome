package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes28.dex */
public class LottieTask<T> {
    public static Executor EXECUTOR;
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;
    private volatile l<T> result;
    private final Set<LottieListener<T>> successListeners;
    private FutureTask<l<T>> task;
    private Thread taskObserver;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieTask f24771a;

        public final void a() {
            if (LottieTask.access$000(this.f24771a) != null) goto L5;
            return;
        L5:
            if (r0.c.a.f535397a == false) goto L7;
        L11:
            l r100 = LottieTask.access$000(this.f24771a);
            V r101 = r100.f24812a;
            if (r101 == 0) goto L14;
            LottieTask.access$200(this.f24771a, r101);
            return;
        L14:
            LottieTask.access$300(this.f24771a, r100.f24813b);
            return;
        L7:
            if (LottieTask.access$100(this.f24771a) == null) goto L11;
            if (LottieTask.access$100(this.f24771a).isCancelled() == false) goto L11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LottieTask r100) {
            this.f24771a = r100;
        }
    }

    public class b extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f24772v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ LottieTask f24773w;

        public final void l() {
        L3:
            if (isInterrupted() == true) goto L16;
            if (this.f24772v == true) goto L24;
            if (LottieTask.access$100(this.f24773w).isDone() == false) goto L3;
            LottieTask r100 = this.f24773w;     // Catch: Throwable -> L11 InterruptedException -> L13
            LottieTask.access$400(r100, (l) LottieTask.access$100(r100).get());     // Catch: Throwable -> L11 InterruptedException -> L13
        L15:
            this.f24772v = true;
            LottieTask.access$500(this.f24773w);
        L11:
            e = move-exception;
            LottieTask.access$400(this.f24773w, new l(e));
            goto L15
        L24:
            return;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(LottieTask r100) {
            this.f24773w = r100;
            super("LottieTaskObserver");
            this.f24772v = false;
        }
    }

    public class c extends FutureTask<l<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieTask f24774a;

        @Override // java.util.concurrent.FutureTask
        public final void done() {
            if (isCancelled() == false) goto L12;
            return;
        L12:
            LottieTask.access$400(this.f24774a, get());     // Catch: ExecutionException -> L7 Throwable -> L9
            return;
        L9:
            e = move-exception;
            LottieTask.access$400(this.f24774a, new l(e));
        }

        public c(LottieTask r100, Callable<l<T>> r101) {
            this.f24774a = r100;
            super(r101);
        }
    }

    private synchronized void startTaskObserverIfNeeded() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (taskObserverAlive() == false) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.result != null) goto L11;
        b r100 = new b(this);     // Catch: Throwable -> L13
        this.taskObserver = r100;     // Catch: Throwable -> L13
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L13
        Set<String> r101 = f.f24776a;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    private synchronized void stopTaskObserverIfNeeded() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (taskObserverAlive() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.successListeners.isEmpty() == false) goto L10;
    L11:
        this.taskObserver.interrupt();     // Catch: Throwable -> L14
        this.taskObserver = null;     // Catch: Throwable -> L14
        Set<String> r100 = f.f24776a;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L10:
        if (this.result == null) goto L12;
        goto L11
    }

    static {
        EXECUTOR = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("ie/LottieTask"));
    }

    private void notifyListeners() {
        this.handler.post(new a(this));
    }

    private boolean taskObserverAlive() {
        Thread r100 = this.taskObserver;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (ThreadMethodProxy.isAlive(r100) == false) goto L7;
        return true;
    }

    public LottieTask(Callable<l<T>> r100) {
        this(r100, false);
    }

    public static /* synthetic */ l access$000(LottieTask r100) {
        return r100.result;
    }

    public static /* synthetic */ FutureTask access$100(LottieTask r100) {
        return r100.task;
    }

    public static /* synthetic */ void access$500(LottieTask r100) {
        r100.stopTaskObserverIfNeeded();
    }

    private synchronized void notifyFailureListeners(Throwable r100) {
        monitor-enter(this);
        ArrayList r101 = new ArrayList(this.failureListeners);     // Catch: Throwable -> L14
        if (r101.isEmpty() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r102 = r101.iterator();     // Catch: Throwable -> L14
    L9:
        if (r102.hasNext() == false) goto L12;
        ((LottieListener) r102.next()).onResult(r100);     // Catch: Throwable -> L14
        goto L9
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private synchronized void notifySuccessListeners(T r100) {
        monitor-enter(this);
        Iterator r101 = new ArrayList(this.successListeners).iterator();     // Catch: Throwable -> L10
    L5:
        if (r101.hasNext() == false) goto L8;
        ((LottieListener) r101.next()).onResult(r100);     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void setResult(l<T> r100) {
        if (this.result != null) goto L7;
        this.result = r100;
        notifyListeners();
        return;
    L7:
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.result != null) goto L6;
    L8:
        this.failureListeners.add(r100);     // Catch: Throwable -> L15
        if (r0.c.a.f535397a == false) goto L11;
    L13:
        monitor-exit(this);
        return this;
    L11:
        if (this.task == null) goto L13;
        startTaskObserverIfNeeded();     // Catch: Throwable -> L15
        goto L13
    L6:
        if (this.result.f24813b == null) goto L8;
        r100.onResult(this.result.f24813b);     // Catch: Throwable -> L15
        goto L8
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.result != null) goto L6;
    L8:
        this.successListeners.add(r100);     // Catch: Throwable -> L15
        if (r0.c.a.f535397a == false) goto L11;
    L13:
        monitor-exit(this);
        return this;
    L11:
        if (this.task == null) goto L13;
        startTaskObserverIfNeeded();     // Catch: Throwable -> L15
        goto L13
    L6:
        if (this.result.f24812a == null) goto L8;
        r100.onResult(this.result.f24812a);     // Catch: Throwable -> L15
        goto L8
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> r100) {
        monitor-enter(this);
        this.failureListeners.remove(r100);     // Catch: Throwable -> L10
        if (r0.c.a.f535397a == false) goto L6;
    L8:
        monitor-exit(this);
        return this;
    L6:
        if (this.task == null) goto L8;
        stopTaskObserverIfNeeded();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> r100) {
        monitor-enter(this);
        this.successListeners.remove(r100);     // Catch: Throwable -> L10
        if (r0.c.a.f535397a == false) goto L6;
    L8:
        monitor-exit(this);
        return this;
    L6:
        if (this.task == null) goto L8;
        stopTaskObserverIfNeeded();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public LottieTask(Callable<l<T>> r100, boolean r101) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (r101 == false) goto L9;
        setResult(r100.call());     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        setResult(new l(th));
        return;
    L9:
        if (r0.c.a.f535397a == false) goto L11;
        EXECUTOR.execute(new c(this, r100));
        return;
    L11:
        FutureTask<l<T>> r102 = new FutureTask(r100);
        this.task = r102;
        EXECUTOR.execute(r102);
        startTaskObserverIfNeeded();
    }

    public static /* synthetic */ void access$200(LottieTask r100, Object r101) {
        r100.notifySuccessListeners(r101);
    }

    public static /* synthetic */ void access$300(LottieTask r100, Throwable r101) {
        r100.notifyFailureListeners(r101);
    }

    public static /* synthetic */ void access$400(LottieTask r100, l r101) {
        r100.setResult(r101);
    }
}
