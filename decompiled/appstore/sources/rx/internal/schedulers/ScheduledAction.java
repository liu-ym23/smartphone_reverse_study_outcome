package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;

/* JADX INFO: loaded from: classes4.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, Subscription {
    private static final long serialVersionUID = -3962399486978279857L;
    final Action0 action;
    final SubscriptionList cancel;

    public static final class Remover extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        final rx.subscriptions.b parent;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final ScheduledAction f24282s;

        public Remover(ScheduledAction r10, rx.subscriptions.b r11) {
            this.f24282s = r10;
            this.parent = r11;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f24282s.isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.b(this.f24282s);
            return;
        }
    }

    public static final class Remover2 extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        final SubscriptionList parent;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final ScheduledAction f24283s;

        public Remover2(ScheduledAction r10, SubscriptionList r11) {
            this.f24283s = r10;
            this.parent = r11;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f24283s.isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.b(this.f24283s);
            return;
        }
    }

    public final class a implements Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future f24284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScheduledAction f24285b;

        public a(ScheduledAction r10, Future r11) {
            this.f24285b = r10;
            this.f24284a = r11;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f24284a.isCancelled();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.f24285b.get() == Thread.currentThread()) goto L5;
            this.f24284a.cancel(true);
            return;
        L5:
            this.f24284a.cancel(false);
        }
    }

    public ScheduledAction(Action0 r10) {
        this.action = r10;
        this.cancel = new SubscriptionList();
    }

    public void add(Subscription r10) {
        this.cancel.a(r10);
    }

    public void addParent(rx.subscriptions.b r10) {
        this.cancel.a(new Remover(this, r10));
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(Thread.currentThread());     // Catch: Throwable -> L4 OnErrorNotImplementedException -> L6
        this.action.call();     // Catch: Throwable -> L4 OnErrorNotImplementedException -> L6
    L3:
        unsubscribe();
        return;
    L9:
        th = move-exception;
        unsubscribe();
        throw th;
    L6:
        e = move-exception;
        signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e));     // Catch: Throwable -> L9
    L16:
    L4:
        th = move-exception;
        signalError(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th));     // Catch: Throwable -> L9
        goto L16
    }

    public void signalError(Throwable r10) {
        og.c.j(r10);
        Thread r11 = Thread.currentThread();
        r11.getUncaughtExceptionHandler().uncaughtException(r11, r10);
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (this.cancel.isUnsubscribed() == true) goto L6;
        this.cancel.unsubscribe();
        return;
    }

    public void add(Future<?> r10) {
        this.cancel.a(new a(this, r10));
    }

    public void addParent(SubscriptionList r10) {
        this.cancel.a(new Remover2(this, r10));
    }

    public ScheduledAction(Action0 r10, rx.subscriptions.b r11) {
        this.action = r10;
        this.cancel = new SubscriptionList(new Remover(this, r11));
    }

    public ScheduledAction(Action0 r10, SubscriptionList r11) {
        this.action = r10;
        this.cancel = new SubscriptionList(new Remover2(this, r11));
    }
}
