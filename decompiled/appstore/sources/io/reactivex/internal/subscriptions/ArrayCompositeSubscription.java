package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int r10) {
        super(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        int r10 = 0;
        if (get(0) == SubscriptionHelper.CANCELLED) goto L13;
        int r11 = length();
    L5:
        if (r10 >= r11) goto L19;
        Subscription r12 = get(r10);
        SubscriptionHelper r13 = SubscriptionHelper.CANCELLED;
        if (r12 == r13) goto L12;
        Subscription r14 = getAndSet(r10, r13);
        if (r14 == r13) goto L12;
        if (r14 == null) goto L12;
        r14.cancel();
    L12:
        r10 = r10 + 1;
        goto L5
    L19:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get(0) != SubscriptionHelper.CANCELLED) goto L6;
        return true;
    L6:
        return false;
    }

    public Subscription replaceResource(int r10, Subscription r11) {
    L2:
        Subscription r12 = get(r10);
        if (r12 == SubscriptionHelper.CANCELLED) goto L4;
        if (compareAndSet(r10, r12, r11) == false) goto L2;
        return r12;
    L4:
        if (r11 == null) goto L14;
        r11.cancel();
        return null;
    L14:
        return null;
    }

    public boolean setResource(int r10, Subscription r11) {
    L2:
        Subscription r12 = get(r10);
        if (r12 == SubscriptionHelper.CANCELLED) goto L4;
        if (compareAndSet(r10, r12, r11) == false) goto L2;
        if (r12 == null) goto L18;
        r12.cancel();
        return true;
    L18:
        return true;
    L4:
        if (r11 == null) goto L17;
        r11.cancel();
        return false;
    L17:
        return false;
    }
}
