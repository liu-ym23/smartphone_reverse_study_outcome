package rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.producers.SingleProducer;

/* JADX INFO: loaded from: classes4.dex */
public final class ScalarSynchronousObservable extends Observable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f24367c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f24368b;

    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements Producer, Action0 {
        private static final long serialVersionUID = -2466317989629281651L;
        final Subscriber actual;
        final Func1<Action0, Subscription> onSchedule;
        final T value;

        public ScalarAsyncProducer(Subscriber r10, T r11, Func1<Action0, Subscription> r12) {
            this.actual = r10;
            this.value = r11;
            this.onSchedule = r12;
        }

        @Override // rx.functions.Action0
        public void call() {
            Subscriber r10 = this.actual;
            if (r10.isUnsubscribed() == false) goto L5;
            return;
        L5:
            T r11 = this.value;
            r10.onNext(r11);     // Catch: Throwable -> L12
            if (r10.isUnsubscribed() == false) goto L10;
            return;
        L10:
            r10.onCompleted();
            return;
        L12:
            th = move-exception;
            rx.exceptions.a.g(th, r10, r11);
        }

        @Override // rx.Producer
        public void request(long r10) {
            if (r10 < 0) goto L10;
            if (r10 != 0) goto L6;
            return;
        L6:
            if (compareAndSet(false, true) == false) goto L12;
            this.actual.add(this.onSchedule.call(this));
            return;
        L12:
            return;
        L10:
            throw new IllegalArgumentException("n >= 0 required but it was " + r10);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + ", " + get() + "]";
        }
    }

    public class a implements Func1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rx.internal.schedulers.b f24369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScalarSynchronousObservable f24370b;

        public a(ScalarSynchronousObservable r10, rx.internal.schedulers.b r11) {
            this.f24370b = r10;
            this.f24369a = r11;
        }

        public Subscription a(Action0 r10) {
            return this.f24369a.a(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Action0) r10);
        }
    }

    public class b implements Func1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jg.a f24371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScalarSynchronousObservable f24372b;

        public class a implements Action0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Action0 f24373a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ jg.a.AbstractC0284a f24374b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f24375c;

            public a(b r10, Action0 r11, jg.a.AbstractC0284a r12) {
                this.f24375c = r10;
                this.f24373a = r11;
                this.f24374b = r12;
            }

            @Override // rx.functions.Action0
            public void call() {
                this.f24373a.call();     // Catch: Throwable -> L5
                this.f24374b.unsubscribe();
                return;
            L5:
                th = move-exception;
                this.f24374b.unsubscribe();
                throw th;
            }
        }

        public b(ScalarSynchronousObservable r10, jg.a r11) {
            this.f24372b = r10;
            this.f24371a = r11;
        }

        public Subscription a(Action0 r10) {
            jg.a.AbstractC0284a r11 = this.f24371a.createWorker();
            r11.a(new a(this, r10, r11));
            return r11;
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Action0) r10);
        }
    }

    public static final class c implements Observable.OnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f24376a;

        public c(Object r10) {
            this.f24376a = r10;
        }

        public void a(Subscriber r10) {
            r10.setProducer(ScalarSynchronousObservable.C(r10, this.f24376a));
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Subscriber r10) {
            a(r10);
        }
    }

    public static final class d implements Observable.OnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f24377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Func1 f24378b;

        public d(Object r10, Func1 r11) {
            this.f24377a = r10;
            this.f24378b = r11;
        }

        public void a(Subscriber r10) {
            r10.setProducer(new ScalarAsyncProducer(r10, this.f24377a, this.f24378b));
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Subscriber r10) {
            a(r10);
        }
    }

    public static final class e implements Producer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Subscriber f24379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f24380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f24381c;

        public e(Subscriber r10, Object r11) {
            this.f24379a = r10;
            this.f24380b = r11;
        }

        @Override // rx.Producer
        public void request(long r10) {
            if (this.f24381c == false) goto L6;
            return;
        L6:
            if (r10 < 0) goto L23;
            if (r10 != 0) goto L9;
            return;
        L9:
            this.f24381c = true;
            Subscriber r11 = this.f24379a;
            if (r11.isUnsubscribed() == false) goto L12;
            return;
        L12:
            Object r12 = this.f24380b;
            r11.onNext(r12);     // Catch: Throwable -> L19
            if (r11.isUnsubscribed() == false) goto L17;
            return;
        L17:
            r11.onCompleted();
            return;
        L19:
            th = move-exception;
            rx.exceptions.a.g(th, r11, r12);
            return;
        L23:
            throw new IllegalStateException("n >= required but it was " + r10);
        }
    }

    static {
        f24367c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    }

    public ScalarSynchronousObservable(Object r10) {
        super(og.c.h(new c(r10)));
        this.f24368b = r10;
    }

    public static ScalarSynchronousObservable B(Object r10) {
        return new ScalarSynchronousObservable(r10);
    }

    public static Producer C(Subscriber r10, Object r11) {
        if (f24367c == false) goto L7;
        return new SingleProducer(r10, r11);
    L7:
        return new e(r10, r11);
    }

    public Observable D(jg.a r10) {
        if ((r10 instanceof rx.internal.schedulers.b) == false) goto L5;
        Func1 r11 = new a(this, (rx.internal.schedulers.b) r10);
    L7:
        return Observable.y(new d(this.f24368b, r11));
    L5:
        r11 = new b(this, r10);
        goto L7
    }
}
