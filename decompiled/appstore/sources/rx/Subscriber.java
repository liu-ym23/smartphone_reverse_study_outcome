package rx;

import rx.internal.util.SubscriptionList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Subscriber implements Observer, Subscription {
    private static final long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber subscriber;
    private final SubscriptionList subscriptions;

    public Subscriber() {
        this(null, false);
    }

    public final void a(long r10) {
        long r11 = this.requested;
        if (r11 != NOT_SET) goto L5;
        this.requested = r10;
        return;
    L5:
        long r12 = r11 + r10;
        if (r12 >= 0) goto L8;
        this.requested = Long.MAX_VALUE;
        return;
    L8:
        this.requested = r12;
    }

    public final void add(Subscription r10) {
        this.subscriptions.a(r10);
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    public final void request(long r10) {
        if (r10 < 0) goto L18;
        monitor-enter(this);
        Producer r11 = this.producer;     // Catch: Throwable -> L10
        if (r11 == null) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        r11.request(r10);
        return;
    L12:
        a(r10);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L18:
        throw new IllegalArgumentException("number requested cannot be negative: " + r10);
    }

    public void setProducer(Producer r10) {
        monitor-enter(this);
        long r11 = this.requested;     // Catch: Throwable -> L17
        this.producer = r10;     // Catch: Throwable -> L17
        Subscriber r12 = this.subscriber;     // Catch: Throwable -> L17
        if (r12 != null) goto L6;
    L8:
        boolean r13 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L17
        if (r13 == false) goto L13;
        r12.setProducer(r10);
        return;
    L13:
        if (r11 != NOT_SET) goto L15;
        r10.request(Long.MAX_VALUE);
        return;
    L15:
        r10.request(r11);
        return;
    L6:
        if (r11 != NOT_SET) goto L8;
        r13 = true;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    public Subscriber(Subscriber r10) {
        this(r10, true);
    }

    public Subscriber(Subscriber r10, boolean r11) {
        this.requested = NOT_SET;
        this.subscriber = r10;
        if (r11 == false) goto L6;
        if (r10 == null) goto L6;
        SubscriptionList r12 = r10.subscriptions;
    L7:
        this.subscriptions = r12;
        return;
    L6:
        r12 = new SubscriptionList();
        goto L7
    }
}
