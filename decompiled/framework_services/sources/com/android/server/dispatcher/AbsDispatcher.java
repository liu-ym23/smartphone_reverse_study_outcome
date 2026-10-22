package com.android.server.dispatcher;

import android.os.Handler;
import com.android.server.dispatcher.AbsDispatcher.IObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class AbsDispatcher<U extends IObserver> {
    protected Handler mHandler;
    protected final List<U> mObservers;

    public interface IObserver {
    }

    protected static class Lazy<T extends AbsDispatcher<?>> implements Supplier<T> {
        private volatile T mInstance;
        private final Supplier<T> mSupplier;

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        public Lazy(Supplier<T> supplier) {
            this.mSupplier = supplier;
        }

        @Override // java.util.function.Supplier
        public final T get() {
            if (this.mInstance != null) goto L16;
            monitor-enter(AbsDispatcher.class);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (this.mInstance != null) goto L11;
            this.mInstance = this.mSupplier.get();     // Catch: Throwable -> L9
        L11:
            monitor-exit(AbsDispatcher.class);     // Catch: Throwable -> L9
        L16:
            return this.mInstance;
        }
    }

    public AbsDispatcher() {
        this.mObservers = new ArrayList();
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    protected boolean switchThreads(Runnable runnable) {
        Handler handler = this.mHandler;
        if (runnable == null) goto L9;
        if (handler != null) goto L6;
        return false;
    L6:
        if (handler.getLooper().isCurrentThread() == true) goto L12;
        handler.post(runnable);
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    public void registerObserver(U observer) {
        List<U> r0 = this.mObservers;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.contains(observer) == true) goto L9;
        this.mObservers.add(observer);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void unregisterObserver(U observer) {
        List<U> r0 = this.mObservers;
        monitor-enter(r0);
        this.mObservers.remove(observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyObserver(Consumer<U> consumer) {
        List<U> r0 = this.mObservers;
        monitor-enter(r0);
        Iterator<U> r1 = this.mObservers.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        U observer = r1.next();     // Catch: Throwable -> L8
        consumer.accept(observer);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
