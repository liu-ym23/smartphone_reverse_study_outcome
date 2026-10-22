package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.unsafe.e0;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements Observable.Operator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jg.a f24227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f24228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24229c;

    public static final class a extends Subscriber implements Action0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Subscriber f24230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jg.a.AbstractC0284a f24231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f24232c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Queue f24233d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f24234e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile boolean f24235f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicLong f24236g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AtomicLong f24237h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Throwable f24238i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f24239j;

        /* JADX INFO: renamed from: rx.internal.operators.m$a$a, reason: collision with other inner class name */
        public class C0363a implements Producer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f24240a;

            public C0363a(a r10) {
                this.f24240a = r10;
            }

            @Override // rx.Producer
            public void request(long r10) {
                if (r10 <= 0) goto L6;
                rx.internal.operators.a.b(this.f24240a.f24236g, r10);
                this.f24240a.d();
                return;
            }
        }

        public a(jg.a r10, Subscriber r11, boolean r12, int r13) {
            this.f24236g = new AtomicLong();
            this.f24237h = new AtomicLong();
            this.f24230a = r11;
            this.f24231b = r10.createWorker();
            this.f24232c = r12;
            if (r13 > 0) goto L6;
            r13 = rx.internal.util.f.f24424d;
        L6:
            this.f24234e = r13 - (r13 >> 2);
            if (e0.b() == false) goto L9;
            this.f24233d = new rx.internal.util.unsafe.q(r13);
        L10:
            request(r13);
            return;
        L9:
            this.f24233d = new rx.internal.util.atomic.c(r13);
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v10, types: [jg.a$a, rx.Subscription] */
        public boolean b(boolean r10, boolean r11, Subscriber r12, Queue r13) {
            if (r12.isUnsubscribed() == false) goto L6;
            r13.clear();
            return true;
        L6:
            if (r10 == true) goto L8;
            return false;
        L8:
            if (this.f24232c == false) goto L19;
            if (r11 == false) goto L43;
            Throwable r14 = this.f24238i;
            if (r14 == null) goto L15;
            r12.onError(r14);     // Catch: Throwable -> L13
        L16:
            a this = this.f24231b;
            this.unsubscribe();
            return false;
        L15:
            r12.onCompleted();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            this.f24231b.unsubscribe();
            throw th;
        L43:
            return false;
        L19:
            Throwable r15 = this.f24238i;
            if (r15 == null) goto L28;
            r13.clear();
            r12.onError(r15);     // Catch: Throwable -> L25
            this.f24231b.unsubscribe();
            return true;
        L25:
            th = move-exception;
            this.f24231b.unsubscribe();
            throw th;
        L28:
            if (r11 == false) goto L45;
            r12.onCompleted();     // Catch: Throwable -> L32
            this.f24231b.unsubscribe();
            return true;
        L32:
            th = move-exception;
            this.f24231b.unsubscribe();
            throw th;
        L45:
            return false;
        }

        public void c() {
            Subscriber r10 = this.f24230a;
            r10.setProducer(new C0363a(this));
            r10.add(this.f24231b);
            r10.add(this);
        }

        @Override // rx.functions.Action0
        public void call() {
            long r10 = this.f24239j;
            Queue r11 = this.f24233d;
            Subscriber r12 = this.f24230a;
            long r13 = 1;
        L3:
            long r14 = this.f24236g.get();
        L5:
            if (r14 == r10) goto L19;
            boolean r15 = this.f24235f;
            Object r16 = r11.poll();
            if (r16 != null) goto L10;
            boolean r17 = true;
        L9:
            boolean r18 = r17;
            if (b(r15, r18, r12, r11) == true) goto L13;
            if (r18 == true) goto L19;
            r12.onNext(NotificationLite.d(r16));
            r10 = r10 + 1;
            if (r10 != this.f24234e) goto L5;
            r14 = rx.internal.operators.a.c(this.f24236g, r10);
            request(r10);
            r10 = 0;
            goto L5
        L13:
            return;
        L10:
            r17 = false;
        L19:
            if (r14 == r10) goto L21;
        L23:
            this.f24239j = r10;
            r13 = this.f24237h.addAndGet(-r13);
            if (r13 != 0) goto L3;
            return;
        L21:
            if (b(this.f24235f, r11.isEmpty(), r12, r11) == false) goto L23;
        }

        public void d() {
            if (this.f24237h.getAndIncrement() != 0) goto L6;
            this.f24231b.a(this);
            return;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (isUnsubscribed() == false) goto L5;
            return;
        L5:
            if (this.f24235f == true) goto L10;
            this.f24235f = true;
            d();
            return;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            if (isUnsubscribed() == false) goto L5;
        L9:
            og.c.j(r10);
            return;
        L5:
            if (this.f24235f == true) goto L9;
            this.f24238i = r10;
            this.f24235f = true;
            d();
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            if (isUnsubscribed() == false) goto L5;
            return;
        L5:
            if (this.f24235f == false) goto L8;
            return;
        L8:
            if (this.f24233d.offer(NotificationLite.g(r10)) == true) goto L11;
            onError(new MissingBackpressureException());
            return;
        L11:
            d();
        }
    }

    public m(jg.a r10, boolean r11, int r12) {
        this.f24227a = r10;
        this.f24228b = r11;
        if (r12 > 0) goto L6;
        r12 = rx.internal.util.f.f24424d;
    L6:
        this.f24229c = r12;
    }

    public Subscriber a(Subscriber r10) {
        a r11 = new a(this.f24227a, r10, this.f24228b, this.f24229c);
        r11.c();
        return r11;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber r10) {
        return a(r10);
    }
}
