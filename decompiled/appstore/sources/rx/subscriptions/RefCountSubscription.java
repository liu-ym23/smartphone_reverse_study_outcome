package rx.subscriptions;

import androidx.lifecycle.p;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class RefCountSubscription implements Subscription {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f24466c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Subscription f24467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f24468b;

    public static final class InnerSubscription extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription r10) {
            this.parent = r10;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(0, 1) == false) goto L6;
            this.parent.b();
            return;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f24469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f24470b;

        public a(boolean r10, int r11) {
            this.f24469a = r10;
            this.f24470b = r11;
        }

        public a a() {
            return new a(this.f24469a, this.f24470b + 1);
        }

        public a b() {
            return new a(this.f24469a, this.f24470b - 1);
        }

        public a c() {
            return new a(true, this.f24470b);
        }
    }

    static {
        f24466c = new a(false, 0);
    }

    public RefCountSubscription(Subscription r10) {
        this.f24468b = new AtomicReference(f24466c);
        if (r10 == null) goto L7;
        this.f24467a = r10;
        return;
    L7:
        throw new IllegalArgumentException("s");
    }

    public Subscription a() {
        AtomicReference r10 = this.f24468b;
    L3:
        a r11 = (a) r10.get();
        if (r11.f24469a == true) goto L6;
        if (p.a(r10, r11, r11.a()) == false) goto L3;
        return new InnerSubscription(this);
    L6:
        return e.b();
    }

    public void b() {
        AtomicReference r10 = this.f24468b;
    L3:
        a r11 = (a) r10.get();
        a r12 = r11.b();
        if (p.a(r10, r11, r12) == false) goto L3;
        c(r12);
    }

    public final void c(a r10) {
        if (r10.f24469a == true) goto L5;
        return;
    L5:
        if (r10.f24470b != 0) goto L9;
        this.f24467a.unsubscribe();
        return;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return ((a) this.f24468b.get()).f24469a;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        AtomicReference r10 = this.f24468b;
    L3:
        a r11 = (a) r10.get();
        if (r11.f24469a == true) goto L5;
        a r12 = r11.c();
        if (p.a(r10, r11, r12) == false) goto L3;
        c(r12);
        return;
    }
}
