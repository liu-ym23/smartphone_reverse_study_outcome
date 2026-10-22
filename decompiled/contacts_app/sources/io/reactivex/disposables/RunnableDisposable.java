package io.reactivex.disposables;

/* JADX INFO: loaded from: classes4.dex */
final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    @Override // io.reactivex.disposables.ReferenceDisposable
    protected /* bridge */ /* synthetic */ void onDisposed(Runnable r1) {
        onDisposed2(r1);
    }

    RunnableDisposable(Runnable r1) {
        super(r1);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    protected void onDisposed2(Runnable r1) {
        r1.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
