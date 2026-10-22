package rx.subjects;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: loaded from: classes4.dex */
public final class PublishSubject extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubjectState f24456b;

    public static final class PublishSubjectProducer<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        private static final long serialVersionUID = 6451806817170721536L;
        final Subscriber actual;
        final PublishSubjectState<T> parent;
        long produced;

        public PublishSubjectProducer(PublishSubjectState<T> r10, Subscriber r11) {
            this.parent = r10;
            this.actual = r11;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() != Long.MIN_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (get() == Long.MIN_VALUE) goto L6;
            this.actual.onCompleted();
            return;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            if (get() == Long.MIN_VALUE) goto L6;
            this.actual.onError(r10);
            return;
        }

        @Override // rx.Observer
        public void onNext(T r10) {
            long r11 = get();
            if (r11 == Long.MIN_VALUE) goto L9;
            long r12 = this.produced;
            if (r11 == r12) goto L7;
            this.produced = r12 + 1;
            this.actual.onNext(r10);
            return;
        L7:
            unsubscribe();
            this.actual.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
            return;
        }

        @Override // rx.Producer
        public void request(long r10) {
            if (rx.internal.operators.a.d(r10) == false) goto L9;
        L4:
            long r11 = get();
            if (r11 == Long.MIN_VALUE) goto L6;
            if (compareAndSet(r11, rx.internal.operators.a.a(r11, r10)) == false) goto L4;
            return;
        L6:
            return;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.remove(this);
            return;
        }
    }

    public static final class PublishSubjectState<T> extends AtomicReference<PublishSubjectProducer<T>[]> implements Observable.OnSubscribe<T>, Observer<T> {
        static final PublishSubjectProducer[] EMPTY = null;
        static final PublishSubjectProducer[] TERMINATED = null;
        private static final long serialVersionUID = -7568940796666027140L;
        Throwable error;

        static {
            EMPTY = new PublishSubjectProducer[0];
            TERMINATED = new PublishSubjectProducer[0];
        }

        public PublishSubjectState() {
            lazySet(EMPTY);
        }

        public boolean add(PublishSubjectProducer<T> r10) {
        L2:
            PublishSubjectProducer<T>[] r11 = get();
            if (r11 == TERMINATED) goto L4;
            int r12 = r11.length;
            PublishSubjectProducer[] r13 = new PublishSubjectProducer[r12 + 1];
            System.arraycopy(r11, 0, r13, 0, r12);
            r13[r12] = r10;
            if (compareAndSet(r11, r13) == false) goto L2;
            return true;
        L4:
            return false;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Subscriber r10) {
            call2(r10);
        }

        @Override // rx.Observer
        public void onCompleted() {
            PublishSubjectProducer<T>[] r10 = getAndSet(TERMINATED);
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            r10[r12].onCompleted();
            r12 = r12 + 1;
            goto L3
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.error = r10;
            PublishSubjectProducer<T>[] r11 = getAndSet(TERMINATED);
            int r12 = r11.length;
            ArrayList r13 = null;
            int r14 = 0;
        L3:
            if (r14 >= r12) goto L12;
            r11[r14].onError(r10);     // Catch: Throwable -> L7
        L11:
            r14 = r14 + 1;
        L7:
            th = move-exception;
            if (r13 != null) goto L10;
            r13 = new ArrayList(1);
        L10:
            r13.add(th);
            goto L11
        L12:
            rx.exceptions.a.d(r13);
        }

        @Override // rx.Observer
        public void onNext(T r10) {
            PublishSubjectProducer<T>[] r11 = get();
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r11[r13].onNext(r10);
            r13 = r13 + 1;
            goto L3
        }

        public void remove(PublishSubjectProducer<T> r10) {
        L2:
            PublishSubjectProducer<T>[] r11 = get();
            if (r11 == TERMINATED) goto L22;
            if (r11 == EMPTY) goto L30;
            int r12 = r11.length;
            int r13 = 0;
        L8:
            if (r13 >= r12) goto L13;
            if (r11[r13] == r10) goto L14;
            r13 = r13 + 1;
        L14:
            if (r13 < 0) goto L15;
            if (r12 != 1) goto L19;
            PublishSubjectProducer[] r14 = EMPTY;
        L21:
            if (compareAndSet(r11, r14) == false) goto L2;
            return;
        L19:
            PublishSubjectProducer[] r15 = new PublishSubjectProducer[r12 - 1];
            System.arraycopy(r11, 0, r15, 0, r13);
            System.arraycopy(r11, r13 + 1, r15, r13, (r12 - r13) - 1);
            r14 = r15;
            goto L21
        L15:
            return;
        L13:
            r13 = -1;
            goto L14
        L30:
            return;
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public void call2(Subscriber r10) {
            PublishSubjectProducer<T> r11 = new PublishSubjectProducer(this, r10);
            r10.add(r11);
            r10.setProducer(r11);
            if (add(r11) == true) goto L5;
            Throwable r12 = this.error;
            if (r12 == null) goto L10;
            r10.onError(r12);
            return;
        L10:
            r10.onCompleted();
            return;
        L5:
            if (r11.isUnsubscribed() == false) goto L12;
            remove(r11);
            return;
        }
    }

    public PublishSubject(PublishSubjectState r10) {
        super(r10);
        this.f24456b = r10;
    }

    public static PublishSubject B() {
        return new PublishSubject(new PublishSubjectState());
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.f24456b.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        this.f24456b.onError(r10);
    }

    @Override // rx.Observer
    public void onNext(Object r10) {
        this.f24456b.onNext(r10);
    }
}
