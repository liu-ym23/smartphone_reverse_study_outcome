package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public final class BufferUntilSubscriber extends rx.subjects.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Observer f24146d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final State f24147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24148c;

    public static final class State<T> extends AtomicReference<Observer<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;
        final ConcurrentLinkedQueue<Object> buffer;
        boolean emitting;
        final Object guard;

        public State() {
            this.guard = new Object();
            this.buffer = new ConcurrentLinkedQueue();
        }

        public boolean casObserverRef(Observer<? super T> r10, Observer<? super T> r11) {
            return compareAndSet(r10, r11);
        }
    }

    public static class a implements Observer {
        public a() {
        }

        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
        }
    }

    public static final class b implements Observable.OnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final State f24149a;

        public class a implements Action0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f24150a;

            public a(b r10) {
                this.f24150a = r10;
            }

            @Override // rx.functions.Action0
            public void call() {
                this.f24150a.f24149a.set(BufferUntilSubscriber.f24146d);
            }
        }

        public b(State r10) {
            this.f24149a = r10;
        }

        public void a(Subscriber r10) {
            if (this.f24149a.casObserverRef(null, r10) == false) goto L32;
            r10.add(rx.subscriptions.e.a(new a(this)));
            Object r11 = this.f24149a.guard;
            monitor-enter(r11);
            State r12 = this.f24149a;     // Catch: Throwable -> L9
            if (r12.emitting == true) goto L11;
            boolean r13 = true;
            r12.emitting = true;     // Catch: Throwable -> L9
        L12:
            monitor-exit(r11);     // Catch: Throwable -> L9
            if (r13 == false) goto L44;
        L14:
            Object r14 = this.f24149a.buffer.poll();
            if (r14 != null) goto L16;
            Object r15 = this.f24149a.guard;
            monitor-enter(r15);
        L24:
            th = move-exception;
            throw th;
        L20:
            if (this.f24149a.buffer.isEmpty() == true) goto L21;
            monitor-exit(r15);     // Catch: Throwable -> L24
            goto L14
        L21:
            this.f24149a.emitting = false;     // Catch: Throwable -> L24
            monitor-exit(r15);     // Catch: Throwable -> L24
            return;
        L16:
            NotificationLite.a(this.f24149a.get(), r14);
            goto L14
        L44:
            return;
        L11:
            r13 = false;
        L9:
            th = move-exception;
            throw th;
        L32:
            r10.onError(new IllegalStateException("Only one subscriber allowed!"));
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Subscriber r10) {
            a(r10);
        }
    }

    static {
        f24146d = new a();
    }

    public BufferUntilSubscriber(State r10) {
        super(new b(r10));
        this.f24147b = r10;
    }

    public static BufferUntilSubscriber B() {
        return new BufferUntilSubscriber(new State());
    }

    public final void C(Object r10) {
        Object r11 = this.f24147b.guard;
        monitor-enter(r11);
        this.f24147b.buffer.add(r10);     // Catch: Throwable -> L9
        if (this.f24147b.get() == null) goto L11;
        State r12 = this.f24147b;     // Catch: Throwable -> L9
        if (r12.emitting == true) goto L11;
        this.f24148c = true;     // Catch: Throwable -> L9
        r12.emitting = true;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L9
        if (this.f24148c == false) goto L17;
    L14:
        Object r13 = this.f24147b.buffer.poll();
        if (r13 == null) goto L23;
        NotificationLite.a(this.f24147b.get(), r13);
        goto L14
    L23:
        return;
    L17:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.f24148c == false) goto L5;
        this.f24147b.get().onCompleted();
        return;
    L5:
        C(NotificationLite.b());
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        if (this.f24148c == false) goto L5;
        this.f24147b.get().onError(r10);
        return;
    L5:
        C(NotificationLite.c(r10));
    }

    @Override // rx.Observer
    public void onNext(Object r10) {
        if (this.f24148c == false) goto L5;
        this.f24147b.get().onNext(r10);
        return;
    L5:
        C(NotificationLite.g(r10));
    }
}
