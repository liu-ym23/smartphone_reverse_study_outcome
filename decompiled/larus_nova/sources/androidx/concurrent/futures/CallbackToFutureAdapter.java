package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes17.dex */
public final class CallbackToFutureAdapter {

    public static final class Completer<T> {
        private boolean attemptedSetting;
        private ResolvableFuture<Void> cancellationFuture;
        SafeFuture<T> future;
        Object tag;

        private void setCompletedNormally() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }

        public void fireCancellationListeners() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture.set(null);
        }

        public boolean setCancelled() {
            boolean r100 = true;
            this.attemptedSetting = true;
            SafeFuture<T> r101 = this.future;
            if (r101 != null) goto L5;
        L7:
            r100 = false;
        L8:
            if (r100 == false) goto L10;
            setCompletedNormally();
        L10:
            return r100;
        L5:
            if (r101.cancelWithoutNotifyingCompleter(true) == false) goto L7;
            goto L7
        }

        public void finalize() {
            SafeFuture<T> r100 = this.future;
            if (r100 == null) goto L8;
            if (r100.isDone() == true) goto L8;
            r100.setException(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
        L8:
            if (this.attemptedSetting == true) goto L13;
            ResolvableFuture<Void> r101 = this.cancellationFuture;
            if (r101 == null) goto L14;
            r101.set(null);
            return;
        L14:
            return;
        }

        public Completer() {
            this.cancellationFuture = ResolvableFuture.create();
        }

        public boolean set(T r100) {
            boolean r101 = true;
            this.attemptedSetting = true;
            SafeFuture<T> r102 = this.future;
            if (r102 != null) goto L5;
        L7:
            r101 = false;
        L8:
            if (r101 == false) goto L10;
            setCompletedNormally();
        L10:
            return r101;
        L5:
            if (r102.set(r100) == false) goto L7;
            goto L7
        }

        public boolean setException(Throwable r100) {
            boolean r101 = true;
            this.attemptedSetting = true;
            SafeFuture<T> r102 = this.future;
            if (r102 != null) goto L5;
        L7:
            r101 = false;
        L8:
            if (r101 == false) goto L10;
            setCompletedNormally();
        L10:
            return r101;
        L5:
            if (r102.setException(r100) == false) goto L7;
            goto L7
        }

        public void addCancellationListener(Runnable r100, Executor r101) {
            ResolvableFuture<Void> r102 = this.cancellationFuture;
            if (r102 == null) goto L6;
            r102.addListener(r100, r101);
            return;
        }
    }

    public static final class FutureGarbageCollectedException extends Throwable {
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            monitor-enter(this);
            monitor-exit(this);
            return this;
        }

        public FutureGarbageCollectedException(String r100) {
            super(r100);
        }
    }

    public interface Resolver<T> {
        Object attachCompleter(Completer<T> r100) throws Exception;
    }

    public static final class SafeFuture<T> implements ListenableFuture<T> {
        final WeakReference<Completer<T>> completerWeakReference;
        private final AbstractResolvableFuture<T> delegate;

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            return this.delegate.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.delegate.isDone();
        }

        public String toString() {
            return this.delegate.toString();
        }

        public SafeFuture(Completer<T> r100) {
            this.delegate = new AnonymousClass1(this);
            this.completerWeakReference = new WeakReference(r100);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean r100) {
            Completer<T> r101 = this.completerWeakReference.get();
            boolean r102 = this.delegate.cancel(r100);
            if (r102 == false) goto L6;
            if (r101 == null) goto L6;
            r101.fireCancellationListeners();
        L6:
            return r102;
        }

        public boolean cancelWithoutNotifyingCompleter(boolean r100) {
            return this.delegate.cancel(r100);
        }

        public boolean set(T r100) {
            return this.delegate.set(r100);
        }

        public boolean setException(Throwable r100) {
            return this.delegate.setException(r100);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable r100, Executor r101) {
            this.delegate.addListener(r100, r101);
        }

        @Override // java.util.concurrent.Future
        public T get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
            return this.delegate.get(r100, r101);
        }
    }

    private CallbackToFutureAdapter() {
    }

    public static <T> ListenableFuture<T> getFuture(Resolver<T> r100) {
        Completer<T> r101 = new Completer();
        SafeFuture<T> r102 = new SafeFuture(r101);
        r101.future = r102;
        r101.tag = r100.getClass();
        Object r103 = r100.attachCompleter(r101);     // Catch: Exception -> L7
        if (r103 == null) goto L9;
        r101.tag = r103;     // Catch: Exception -> L7
    L9:
        return r102;
    L7:
        e = move-exception;
        r102.setException(e);
        goto L9
    }
}
