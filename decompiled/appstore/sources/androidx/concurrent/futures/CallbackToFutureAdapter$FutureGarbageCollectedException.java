package androidx.concurrent.futures;

/* JADX INFO: loaded from: classes.dex */
final class CallbackToFutureAdapter$FutureGarbageCollectedException extends Throwable {
    public CallbackToFutureAdapter$FutureGarbageCollectedException(String r10) {
        super(r10);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }
}
