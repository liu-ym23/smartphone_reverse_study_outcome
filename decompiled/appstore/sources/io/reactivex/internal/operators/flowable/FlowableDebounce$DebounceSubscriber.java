package io.reactivex.internal.operators.flowable;

import androidx.lifecycle.p;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableDebounce$DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 6725975399620862591L;
    final Function<? super T, ? extends Publisher<U>> debounceSelector;
    final AtomicReference<Disposable> debouncer;
    boolean done;
    final Subscriber<? super T> downstream;
    volatile long index;
    Subscription upstream;

    public static final class a extends io.reactivex.subscribers.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FlowableDebounce$DebounceSubscriber f20618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f20619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f20620d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f20621e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicBoolean f20622f;

        public a(FlowableDebounce$DebounceSubscriber r10, long r11, Object r12) {
            this.f20622f = new AtomicBoolean();
            this.f20618b = r10;
            this.f20619c = r11;
            this.f20620d = r12;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void c() {
            if (this.f20622f.compareAndSet(false, true) == false) goto L6;
            this.f20618b.emit(this.f20619c, this.f20620d);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f20621e == false) goto L5;
            return;
        L5:
            this.f20621e = true;
            c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r10) {
            if (this.f20621e == false) goto L6;
            qf.a.e(r10);
            return;
        L6:
            this.f20621e = true;
            this.f20618b.onError(r10);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r10) {
            if (this.f20621e == false) goto L5;
            return;
        L5:
            this.f20621e = true;
            a();
            c();
        }
    }

    public FlowableDebounce$DebounceSubscriber(Subscriber<? super T> r10, Function<? super T, ? extends Publisher<U>> r11) {
        this.debouncer = new AtomicReference();
        this.downstream = r10;
        this.debounceSelector = r11;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.debouncer);
    }

    public void emit(long r10, T r11) {
        if (r10 == this.index) goto L5;
        return;
    L5:
        if (get() == 0) goto L7;
        this.downstream.onNext(r11);
        io.reactivex.internal.util.a.e(this, 1);
        return;
    L7:
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        Disposable r10 = this.debouncer.get();
        if (DisposableHelper.isDisposed(r10) == true) goto L12;
        a r11 = (a) r10;
        if (r11 == null) goto L10;
        r11.c();
    L10:
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onComplete();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        long r11 = this.index + 1;
        this.index = r11;
        Disposable r12 = this.debouncer.get();
        if (r12 == null) goto L16;
        r12.dispose();
    L16:
        Publisher r13 = (Publisher) io.reactivex.internal.functions.a.b(this.debounceSelector.apply(r10), "The publisher supplied is null");     // Catch: Throwable -> L13
        a r14 = new a(this, r11, r10);
        if (p.a(this.debouncer, r12, r14) == false) goto L18;
        r13.subscribe(r14);
        return;
    L18:
        return;
    L13:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        this.downstream.onError(th);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this, r10);
        return;
    }
}
