package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.subscriptions.e;

/* JADX INFO: loaded from: classes4.dex */
public final class SequentialSubscription extends AtomicReference<Subscription> implements Subscription {
    private static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public Subscription current() {
        Subscription r10 = (Subscription) super.get();
        if (r10 == Unsubscribed.INSTANCE) goto L5;
        return r10;
    L5:
        return e.b();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        if (get() != Unsubscribed.INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean replace(Subscription r10) {
    L2:
        Subscription r11 = get();
        if (r11 == Unsubscribed.INSTANCE) goto L4;
        if (compareAndSet(r11, r10) == false) goto L2;
        return true;
    L4:
        if (r10 == null) goto L15;
        r10.unsubscribe();
        return false;
    L15:
        return false;
    }

    public boolean replaceWeak(Subscription r10) {
        Subscription r11 = get();
        Unsubscribed r12 = Unsubscribed.INSTANCE;
        if (r11 != r12) goto L8;
        if (r10 == null) goto L6;
        r10.unsubscribe();
    L6:
        return false;
    L8:
        if (compareAndSet(r11, r10) == false) goto L11;
        return true;
    L11:
        if (get() != r12) goto L15;
        if (r10 == null) goto L14;
        r10.unsubscribe();
    L14:
        return false;
    L15:
        return true;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        Subscription r10 = get();
        Unsubscribed r11 = Unsubscribed.INSTANCE;
        if (r10 == r11) goto L9;
        Subscription r12 = getAndSet(r11);
        if (r12 == null) goto L10;
        if (r12 == r11) goto L11;
        r12.unsubscribe();
        return;
    L11:
        return;
    L10:
        return;
    }

    public boolean update(Subscription r10) {
    L2:
        Subscription r11 = get();
        if (r11 == Unsubscribed.INSTANCE) goto L4;
        if (compareAndSet(r11, r10) == false) goto L2;
        if (r11 == null) goto L18;
        r11.unsubscribe();
        return true;
    L18:
        return true;
    L4:
        if (r10 == null) goto L17;
        r10.unsubscribe();
        return false;
    L17:
        return false;
    }

    public boolean updateWeak(Subscription r10) {
        Subscription r11 = get();
        Unsubscribed r12 = Unsubscribed.INSTANCE;
        if (r11 != r12) goto L8;
        if (r10 == null) goto L6;
        r10.unsubscribe();
    L6:
        return false;
    L8:
        if (compareAndSet(r11, r10) == false) goto L10;
        return true;
    L10:
        Subscription r13 = get();
        if (r10 == null) goto L13;
        r10.unsubscribe();
    L13:
        if (r13 == r12) goto L15;
        return false;
    L15:
        return true;
    }

    public SequentialSubscription(Subscription r10) {
        lazySet(r10);
    }
}
