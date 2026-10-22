package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
import rx.subscriptions.e;

/* JADX INFO: loaded from: classes4.dex */
public class SchedulerWhen extends jg.a implements Subscription {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Subscription f24286d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Subscription f24287e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jg.a f24288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Observer f24289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Subscription f24290c;

    public static class DelayedAction extends ScheduledAction {
        private final Action0 action;
        private final long delayTime;
        private final TimeUnit unit;

        public DelayedAction(Action0 r10, long r11, TimeUnit r12) {
            this.action = r10;
            this.delayTime = r11;
            this.unit = r12;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public Subscription callActual(jg.a.AbstractC0284a r10, CompletableSubscriber r11) {
            return r10.b(new d(this.action, r11), this.delayTime, this.unit);
        }
    }

    public static class ImmediateAction extends ScheduledAction {
        private final Action0 action;

        public ImmediateAction(Action0 r10) {
            this.action = r10;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public Subscription callActual(jg.a.AbstractC0284a r10, CompletableSubscriber r11) {
            return r10.a(new d(this.action, r11));
        }
    }

    public static abstract class ScheduledAction extends AtomicReference<Subscription> implements Subscription {
        public ScheduledAction() {
            super(SchedulerWhen.f24286d);
        }

        public static /* synthetic */ void access$000(ScheduledAction r10, jg.a.AbstractC0284a r11, CompletableSubscriber r12) {
            r10.call(r11, r12);
        }

        private void call(jg.a.AbstractC0284a r10, CompletableSubscriber r11) {
            Subscription r12 = get();
            if (r12 != SchedulerWhen.f24287e) goto L5;
            return;
        L5:
            Subscription r13 = SchedulerWhen.f24286d;
            if (r12 == r13) goto L8;
            return;
        L8:
            Subscription r14 = callActual(r10, r11);
            if (compareAndSet(r13, r14) == true) goto L12;
            r14.unsubscribe();
            return;
        }

        public abstract Subscription callActual(jg.a.AbstractC0284a r10, CompletableSubscriber r11);

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            Subscription r10 = SchedulerWhen.f24287e;
        L3:
            Subscription r11 = get();
            if (r11 == SchedulerWhen.f24287e) goto L5;
            if (compareAndSet(r11, r10) == false) goto L3;
            if (r11 == SchedulerWhen.f24286d) goto L15;
            r11.unsubscribe();
            return;
        L15:
            return;
        }
    }

    public class a implements Func1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jg.a.AbstractC0284a f24291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SchedulerWhen f24292b;

        /* JADX INFO: renamed from: rx.internal.schedulers.SchedulerWhen$a$a, reason: collision with other inner class name */
        public class C0366a implements Completable.OnSubscribe {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ScheduledAction f24293a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f24294b;

            public C0366a(a r10, ScheduledAction r11) {
                this.f24294b = r10;
                this.f24293a = r11;
            }

            public void a(CompletableSubscriber r10) {
                r10.onSubscribe(this.f24293a);
                ScheduledAction.access$000(this.f24293a, this.f24294b.f24291a, r10);
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(CompletableSubscriber r10) {
                a(r10);
            }
        }

        public a(SchedulerWhen r10, jg.a.AbstractC0284a r11) {
            this.f24292b = r10;
            this.f24291a = r11;
        }

        public Completable a(ScheduledAction r10) {
            return Completable.a(new C0366a(this, r10));
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((ScheduledAction) r10);
        }
    }

    public class b extends jg.a.AbstractC0284a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f24295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jg.a.AbstractC0284a f24296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Observer f24297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SchedulerWhen f24298d;

        public b(SchedulerWhen r10, jg.a.AbstractC0284a r11, Observer r12) {
            this.f24298d = r10;
            this.f24296b = r11;
            this.f24297c = r12;
            this.f24295a = new AtomicBoolean();
        }

        @Override // jg.a.AbstractC0284a
        public Subscription a(Action0 r10) {
            ImmediateAction r11 = new ImmediateAction(r10);
            this.f24297c.onNext(r11);
            return r11;
        }

        @Override // jg.a.AbstractC0284a
        public Subscription b(Action0 r10, long r11, TimeUnit r12) {
            DelayedAction r13 = new DelayedAction(r10, r11, r12);
            this.f24297c.onNext(r13);
            return r13;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f24295a.get();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.f24295a.compareAndSet(false, true) == false) goto L6;
            this.f24296b.unsubscribe();
            this.f24297c.onCompleted();
            return;
        }
    }

    public static class c implements Subscription {
        public c() {
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        }
    }

    public static class d implements Action0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CompletableSubscriber f24299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Action0 f24300b;

        public d(Action0 r10, CompletableSubscriber r11) {
            this.f24300b = r10;
            this.f24299a = r11;
        }

        @Override // rx.functions.Action0
        public void call() {
            this.f24300b.call();     // Catch: Throwable -> L5
            this.f24299a.onCompleted();
            return;
        L5:
            th = move-exception;
            this.f24299a.onCompleted();
            throw th;
        }
    }

    static {
        f24286d = new c();
        f24287e = e.b();
    }

    public SchedulerWhen(Func1 r10, jg.a r11) {
        this.f24288a = r11;
        PublishSubject r12 = PublishSubject.B();
        this.f24289b = new ng.b(r12);
        this.f24290c = ((Completable) r10.call(r12.j())).e();
    }

    @Override // jg.a
    public jg.a.AbstractC0284a createWorker() {
        jg.a.AbstractC0284a r10 = this.f24288a.createWorker();
        BufferUntilSubscriber r11 = BufferUntilSubscriber.B();
        ng.b r12 = new ng.b(r11);
        Observable r13 = r11.f(new a(this, r10));
        b r14 = new b(this, r10, r12);
        this.f24289b.onNext(r13);
        return r14;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.f24290c.isUnsubscribed();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.f24290c.unsubscribe();
    }
}
