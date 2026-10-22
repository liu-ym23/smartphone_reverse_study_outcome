package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Subscription {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Action0 f24471b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f24472a;

    /* JADX INFO: renamed from: rx.subscriptions.a$a, reason: collision with other inner class name */
    public static class C0373a implements Action0 {
        public C0373a() {
        }

        @Override // rx.functions.Action0
        public void call() {
        }
    }

    static {
        f24471b = new C0373a();
    }

    public a(Action0 r10) {
        this.f24472a = new AtomicReference(r10);
    }

    public static a a(Action0 r10) {
        return new a(r10);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        if (this.f24472a.get() != f24471b) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        Action0 r10 = (Action0) this.f24472a.get();
        Action0 r11 = f24471b;
        if (r10 == r11) goto L9;
        Action0 r12 = (Action0) this.f24472a.getAndSet(r11);
        if (r12 == null) goto L10;
        if (r12 == r11) goto L11;
        r12.call();
        return;
    L11:
        return;
    L10:
        return;
    }
}
