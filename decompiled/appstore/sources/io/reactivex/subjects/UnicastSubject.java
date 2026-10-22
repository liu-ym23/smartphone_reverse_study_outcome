package io.reactivex.subjects;

import androidx.lifecycle.p;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import mf.e;

/* JADX INFO: loaded from: classes4.dex */
public final class UnicastSubject extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.internal.queue.a f20745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f20746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f20747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f20748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f20749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f20750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Throwable f20751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f20752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BasicIntQueueDisposable f20753i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f20754j;

    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<Object> {
        private static final long serialVersionUID = 7926949470189395511L;
        final /* synthetic */ UnicastSubject this$0;

        public UnicastQueueDisposable(UnicastSubject r10) {
            this.this$0 = r10;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.this$0.f20745a.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.this$0.f20749e == true) goto L8;
            this.this$0.f20749e = true;
            this.this$0.e();
            this.this$0.f20746b.lazySet(null);
            if (this.this$0.f20753i.getAndIncrement() != 0) goto L9;
            this.this$0.f20746b.lazySet(null);
            this.this$0.f20745a.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.this$0.f20749e;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.this$0.f20745a.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public Object poll() throws Exception {
            return this.this$0.f20745a.poll();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r10) {
            if ((r10 & 2) == 0) goto L6;
            this.this$0.f20754j = true;
            return 2;
        L6:
            return 0;
        }
    }

    public UnicastSubject(int r10, boolean r11) {
        this.f20745a = new io.reactivex.internal.queue.a(io.reactivex.internal.functions.a.c(r10, "capacityHint"));
        this.f20747c = new AtomicReference();
        this.f20748d = r11;
        this.f20746b = new AtomicReference();
        this.f20752h = new AtomicBoolean();
        this.f20753i = new UnicastQueueDisposable(this);
    }

    public static UnicastSubject c() {
        return new UnicastSubject(e.a(), true);
    }

    public static UnicastSubject d(int r10, Runnable r11) {
        return new UnicastSubject(r10, r11, true);
    }

    @Override // mf.e
    public void b(Observer r10) {
        if (this.f20752h.get() == false) goto L5;
    L11:
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), r10);
        return;
    L5:
        if (this.f20752h.compareAndSet(false, true) == false) goto L11;
        r10.onSubscribe(this.f20753i);
        this.f20746b.lazySet(r10);
        if (this.f20749e == false) goto L10;
        this.f20746b.lazySet(null);
        return;
    L10:
        f();
    }

    public void e() {
        Runnable r10 = (Runnable) this.f20747c.get();
        if (r10 != null) goto L5;
        return;
    L5:
        if (p.a(this.f20747c, r10, null) == false) goto L9;
        r10.run();
        return;
    }

    public void f() {
        if (this.f20753i.getAndIncrement() == 0) goto L5;
        return;
    L5:
        Observer r10 = (Observer) this.f20746b.get();
        int r11 = 1;
    L6:
        if (r10 != null) goto L8;
        r11 = this.f20753i.addAndGet(-r11);
        if (r11 == 0) goto L14;
        r10 = (Observer) this.f20746b.get();
        goto L6
    L14:
        return;
    L8:
        if (this.f20754j == false) goto L10;
        g(r10);
        return;
    L10:
        h(r10);
    }

    public void g(Observer r10) {
        io.reactivex.internal.queue.a r11 = this.f20745a;
        boolean r12 = this.f20748d;
        int r13 = 1;
    L4:
        if (this.f20749e == true) goto L5;
        boolean r14 = this.f20750f;
        if (r12 == true) goto L13;
        if (r14 == false) goto L13;
        if (j(r11, r10) == false) goto L13;
        return;
    L13:
        r10.onNext(null);
        if (r14 == true) goto L15;
        r13 = this.f20753i.addAndGet(-r13);
        if (r13 != 0) goto L4;
        return;
    L15:
        i(r10);
        return;
    L5:
        this.f20746b.lazySet(null);
        r11.clear();
    }

    public void h(Observer r10) {
        io.reactivex.internal.queue.a r11 = this.f20745a;
        boolean r12 = this.f20748d;
        boolean r13 = true;
        int r14 = 1;
    L4:
        if (this.f20749e == true) goto L5;
        boolean r15 = this.f20750f;
        Object r16 = this.f20745a.poll();
        if (r16 != null) goto L10;
        boolean r17 = true;
    L11:
        if (r15 == false) goto L21;
        if (r12 == true) goto L18;
        if (r13 == false) goto L18;
        if (j(r11, r10) == true) goto L16;
        r13 = false;
        goto L18
    L16:
        return;
    L18:
        if (r17 == false) goto L21;
        i(r10);
        return;
    L21:
        if (r17 == true) goto L22;
        r10.onNext(r16);
        goto L4
    L22:
        r14 = this.f20753i.addAndGet(-r14);
        if (r14 != 0) goto L4;
        return;
    L10:
        r17 = false;
        goto L11
    L5:
        this.f20746b.lazySet(null);
        r11.clear();
    }

    public void i(Observer r10) {
        this.f20746b.lazySet(null);
        Throwable r11 = this.f20751g;
        if (r11 == null) goto L5;
        r10.onError(r11);
        return;
    L5:
        r10.onComplete();
    }

    public boolean j(SimpleQueue r10, Observer r11) {
        Throwable r12 = this.f20751g;
        if (r12 == null) goto L6;
        this.f20746b.lazySet(null);
        r10.clear();
        r11.onError(r12);
        return true;
    L6:
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f20750f == false) goto L5;
        return;
    L5:
        if (this.f20749e == true) goto L10;
        this.f20750f = true;
        e();
        f();
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        io.reactivex.internal.functions.a.b(r10, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f20750f == false) goto L5;
    L9:
        qf.a.e(r10);
        return;
    L5:
        if (this.f20749e == true) goto L9;
        this.f20751g = r10;
        this.f20750f = true;
        e();
        f();
    }

    @Override // io.reactivex.Observer
    public void onNext(Object r10) {
        io.reactivex.internal.functions.a.b(r10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f20750f == false) goto L5;
        return;
    L5:
        if (this.f20749e == true) goto L10;
        this.f20745a.offer(r10);
        f();
        return;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (this.f20750f == false) goto L5;
    L6:
        r10.dispose();
        return;
    L5:
        if (this.f20749e == true) goto L6;
    }

    public UnicastSubject(int r10, Runnable r11, boolean r12) {
        this.f20745a = new io.reactivex.internal.queue.a(io.reactivex.internal.functions.a.c(r10, "capacityHint"));
        this.f20747c = new AtomicReference(io.reactivex.internal.functions.a.b(r11, "onTerminate"));
        this.f20748d = r12;
        this.f20746b = new AtomicReference();
        this.f20752h = new AtomicBoolean();
        this.f20753i = new UnicastQueueDisposable(this);
    }
}
