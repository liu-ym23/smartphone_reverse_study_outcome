package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.FuncN;

/* JADX INFO: loaded from: classes4.dex */
final class OperatorZip$Zip<R> extends AtomicLong {
    static final int THRESHOLD = 0;
    private static final long serialVersionUID = 5995274816189928317L;
    final Observer<? super R> child;
    private final rx.subscriptions.b childSubscription;
    int emitted;
    private AtomicLong requested;
    private volatile Object[] subscribers;
    private final FuncN<? extends R> zipFunction;

    public final class a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rx.internal.util.f f24195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OperatorZip$Zip f24196b;

        public a(OperatorZip$Zip r10) {
            this.f24196b = r10;
            this.f24195a = rx.internal.util.f.a();
        }

        public void b(long r10) {
            request(r10);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.f24195a.d();
            this.f24196b.tick();
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.f24196b.child.onError(r10);
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            this.f24195a.e(r10);     // Catch: MissingBackpressureException -> L4
        L6:
            this.f24196b.tick();
            return;
        L4:
            e = move-exception;
            onError(e);
            goto L6
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(rx.internal.util.f.f24424d);
        }
    }

    static {
        THRESHOLD = (int) (((double) rx.internal.util.f.f24424d) * 0.7d);
    }

    public OperatorZip$Zip(Subscriber r10, FuncN<? extends R> r11) {
        rx.subscriptions.b r12 = new rx.subscriptions.b();
        this.childSubscription = r12;
        this.child = r10;
        this.zipFunction = r11;
        r10.add(r12);
    }

    public void start(Observable[] r10, AtomicLong r11) {
        Object[] r12 = new Object[r10.length];
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r14 >= r10.length) goto L6;
        a r15 = new a(this);
        r12[r14] = r15;
        this.childSubscription.a(r15);
        r14 = r14 + 1;
        goto L4
    L6:
        this.requested = r11;
        this.subscribers = r12;
    L8:
        if (r13 >= r10.length) goto L10;
        r10[r13].z((a) r12[r13]);
        r13 = r13 + 1;
        goto L8
    }

    public void tick() {
        Object[] r10 = this.subscribers;
        if (r10 != null) goto L6;
        return;
    L6:
        if (getAndIncrement() != 0) goto L41;
        int r11 = r10.length;
        Observer<? super R> r12 = this.child;
        AtomicLong r13 = this.requested;
    L8:
        Object[] r14 = new Object[r11];
        int r15 = 0;
        boolean r16 = true;
    L9:
        if (r15 >= r11) goto L19;
        rx.internal.util.f r17 = ((a) r10[r15]).f24195a;
        Object r18 = r17.f();
        if (r18 != null) goto L14;
        r16 = false;
    L18:
        r15 = r15 + 1;
        goto L9
    L14:
        if (r17.c(r18) == true) goto L15;
        r14[r15] = r17.b(r18);
        goto L18
    L15:
        r12.onCompleted();
        this.childSubscription.unsubscribe();
        return;
    L19:
        if (r16 == false) goto L40;
        if (r13.get() <= 0) goto L40;
        r12.onNext(this.zipFunction.call(r14));     // Catch: Throwable -> L36
        r13.decrementAndGet();     // Catch: Throwable -> L36
        this.emitted++;     // Catch: Throwable -> L36
        int r19 = r10.length;
        int r20 = 0;
    L24:
        if (r20 >= r19) goto L31;
        rx.internal.util.f r21 = ((a) r10[r20]).f24195a;
        r21.g();
        if (r21.c(r21.f()) == true) goto L27;
        r20 = r20 + 1;
        goto L24
    L27:
        r12.onCompleted();
        this.childSubscription.unsubscribe();
        return;
    L31:
        if (this.emitted <= THRESHOLD) goto L8;
        int r22 = r10.length;
        int r23 = 0;
    L33:
        if (r23 >= r22) goto L35;
        ((a) r10[r23]).b(this.emitted);
        r23 = r23 + 1;
        goto L33
    L35:
        this.emitted = 0;
    L36:
        th = move-exception;
        rx.exceptions.a.g(th, r12, r14);
        return;
    L40:
        if (decrementAndGet() > 0) goto L8;
        return;
    }
}
