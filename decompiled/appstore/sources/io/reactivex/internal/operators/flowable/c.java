package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Subscription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Subscriber f20635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20637c;

    public c(Object r10, Subscriber r11) {
        this.f20636b = r10;
        this.f20635a = r11;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        if (this.f20637c == true) goto L9;
        this.f20637c = true;
        Subscriber r11 = this.f20635a;
        r11.onNext(this.f20636b);
        r11.onComplete();
        return;
    }
}
