package io.reactivex.processors;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mf.b;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class UnicastProcessor extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.a f20734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f20735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f20736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f20737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Throwable f20738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f20739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f20740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f20741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BasicIntQueueSubscription f20742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicLong f20743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f20744l;

    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<Object> {
        private static final long serialVersionUID = -4896760517184205454L;
        final /* synthetic */ UnicastProcessor this$0;

        public UnicastQueueSubscription(UnicastProcessor r10) {
            this.this$0 = r10;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.this$0.f20740h == false) goto L5;
            return;
        L5:
            this.this$0.f20740h = true;
            this.this$0.g();
            UnicastProcessor r10 = this.this$0;
            if (r10.f20744l == false) goto L8;
            return;
        L8:
            if (r10.f20742j.getAndIncrement() != 0) goto L12;
            this.this$0.f20734b.clear();
            this.this$0.f20739g.lazySet(null);
            return;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.this$0.f20734b.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.this$0.f20734b.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public Object poll() {
            return this.this$0.f20734b.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == false) goto L6;
            io.reactivex.internal.util.a.a(this.this$0.f20743k, r10);
            this.this$0.h();
            return;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r10) {
            if ((r10 & 2) == 0) goto L6;
            this.this$0.f20744l = true;
            return 2;
        L6:
            return 0;
        }
    }

    public UnicastProcessor(int r10) {
        this(r10, null, true);
    }

    public static UnicastProcessor e() {
        return new UnicastProcessor(b.a());
    }

    public static UnicastProcessor f(int r10, Runnable r11) {
        io.reactivex.internal.functions.a.b(r11, "onTerminate");
        return new UnicastProcessor(r10, r11);
    }

    @Override // mf.b
    public void c(Subscriber r10) {
        if (this.f20741i.get() == false) goto L5;
    L10:
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), r10);
        return;
    L5:
        if (this.f20741i.compareAndSet(false, true) == false) goto L10;
        r10.onSubscribe(this.f20742j);
        this.f20739g.set(r10);
        if (this.f20740h == false) goto L9;
        this.f20739g.lazySet(null);
        return;
    L9:
        h();
    }

    public boolean d(boolean r10, boolean r11, boolean r12, Subscriber r13, io.reactivex.internal.queue.a r14) {
        if (this.f20740h == false) goto L6;
        r14.clear();
        this.f20739g.lazySet(null);
        return true;
    L6:
        if (r11 == false) goto L18;
        if (r10 == true) goto L9;
    L12:
        if (r12 == false) goto L20;
        Throwable r15 = this.f20738f;
        this.f20739g.lazySet(null);
        if (r15 == null) goto L16;
        r13.onError(r15);
    L17:
        return true;
    L16:
        r13.onComplete();
        goto L17
    L20:
        return false;
    L9:
        if (this.f20738f == null) goto L12;
        r14.clear();
        this.f20739g.lazySet(null);
        r13.onError(this.f20738f);
        return true;
    L18:
        return false;
    }

    public void g() {
        Runnable r10 = (Runnable) this.f20735c.getAndSet(null);
        if (r10 == null) goto L6;
        r10.run();
        return;
    }

    public void h() {
        if (this.f20742j.getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber r10 = (Subscriber) this.f20739g.get();
        int r11 = 1;
    L6:
        if (r10 != null) goto L8;
        r11 = this.f20742j.addAndGet(-r11);
        if (r11 == 0) goto L14;
        r10 = (Subscriber) this.f20739g.get();
        goto L6
    L14:
        return;
    L8:
        if (this.f20744l == false) goto L10;
        i(r10);
        return;
    L10:
        j(r10);
    }

    public void i(Subscriber r10) {
        io.reactivex.internal.queue.a r11 = this.f20734b;
        boolean r12 = this.f20736d;
        int r13 = 1;
    L4:
        if (this.f20740h == true) goto L5;
        boolean r14 = this.f20737e;
        if (r12 == true) goto L14;
        if (r14 == false) goto L14;
        if (this.f20738f == null) goto L14;
        r11.clear();
        this.f20739g.lazySet(null);
        r10.onError(this.f20738f);
        return;
    L14:
        r10.onNext(null);
        if (r14 == true) goto L16;
        r13 = this.f20742j.addAndGet(-r13);
        if (r13 != 0) goto L4;
        return;
    L16:
        this.f20739g.lazySet(null);
        Throwable r15 = this.f20738f;
        if (r15 == null) goto L19;
        r10.onError(r15);
        return;
    L19:
        r10.onComplete();
        return;
    L5:
        r11.clear();
        this.f20739g.lazySet(null);
    }

    public void j(Subscriber r18) {
        io.reactivex.internal.queue.a r10 = this.f20734b;
        boolean r11 = true;
        boolean r12 = !this.f20736d;
        int r13 = 1;
    L3:
        long r14 = this.f20743k.get();
        long r15 = 0;
    L5:
        if (r14 == r15) goto L16;
        boolean r16 = this.f20737e;
        Object r17 = r10.poll();
        if (r17 != null) goto L9;
        boolean r19 = r11;
    L10:
        long r110 = r15;
        if (d(r12, r16, r19, r18, r10) == true) goto L12;
        if (r19 == true) goto L17;
        r18.onNext(r17);
        r15 = 1 + r110;
        r11 = true;
    L17:
        if (r14 != r15) goto L22;
        if (d(r12, this.f20737e, r10.isEmpty(), r18, r10) == false) goto L22;
        return;
    L22:
        if (r110 != 0) goto L24;
    L26:
        r13 = this.f20742j.addAndGet(-r13);
        if (r13 == 0) goto L28;
        r11 = true;
        goto L3
    L28:
        return;
    L24:
        if (r14 == Long.MAX_VALUE) goto L26;
        this.f20743k.addAndGet(-r110);
        goto L26
    L12:
        return;
    L9:
        r19 = false;
        goto L10
    L16:
        r110 = r15;
        goto L17
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f20737e == false) goto L5;
        return;
    L5:
        if (this.f20740h == true) goto L10;
        this.f20737e = true;
        g();
        h();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        io.reactivex.internal.functions.a.b(r10, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f20737e == false) goto L5;
    L9:
        qf.a.e(r10);
        return;
    L5:
        if (this.f20740h == true) goto L9;
        this.f20738f = r10;
        this.f20737e = true;
        g();
        h();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        io.reactivex.internal.functions.a.b(r10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f20737e == false) goto L5;
        return;
    L5:
        if (this.f20740h == true) goto L10;
        this.f20734b.offer(r10);
        h();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (this.f20737e == false) goto L5;
    L8:
        r10.cancel();
        return;
    L5:
        if (this.f20740h == true) goto L8;
        r10.request(Long.MAX_VALUE);
    }

    public UnicastProcessor(int r10, Runnable r11) {
        this(r10, r11, true);
    }

    public UnicastProcessor(int r10, Runnable r11, boolean r12) {
        this.f20734b = new io.reactivex.internal.queue.a(io.reactivex.internal.functions.a.c(r10, "capacityHint"));
        this.f20735c = new AtomicReference(r11);
        this.f20736d = r12;
        this.f20739g = new AtomicReference();
        this.f20741i = new AtomicBoolean();
        this.f20742j = new UnicastQueueSubscription(this);
        this.f20743k = new AtomicLong();
    }
}
