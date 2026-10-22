package O3;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class l extends a implements Callable<Void> {
    public l(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f4349b = Thread.currentThread();
        try {
            this.f4348a.run();
            return null;
        } finally {
            lazySet(a.f4346c);
            this.f4349b = null;
        }
    }
}
