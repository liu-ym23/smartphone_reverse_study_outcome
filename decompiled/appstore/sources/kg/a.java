package kg;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements Subscription {
    private final AtomicBoolean unsubscribed;

    /* JADX INFO: renamed from: kg.a$a, reason: collision with other inner class name */
    public class C0290a implements Action0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f21063a;

        public C0290a(a r10) {
            this.f21063a = r10;
        }

        @Override // rx.functions.Action0
        public void call() {
            this.f21063a.onUnsubscribe();
        }
    }

    public a() {
        this.unsubscribed = new AtomicBoolean();
    }

    public static void verifyMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.unsubscribed.get();
    }

    public abstract void onUnsubscribe();

    @Override // rx.Subscription
    public final void unsubscribe() {
        if (this.unsubscribed.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        onUnsubscribe();
        return;
    L7:
        mg.a.b().createWorker().a(new C0290a(this));
    }
}
