package rx.internal.util;

import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends Subscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Action1 f24384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Action1 f24385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Action0 f24386c;

    public a(Action1 r10, Action1 r11, Action0 r12) {
        this.f24384a = r10;
        this.f24385b = r11;
        this.f24386c = r12;
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.f24386c.call();
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        this.f24385b.call(r10);
    }

    @Override // rx.Observer
    public void onNext(Object r10) {
        this.f24384a.call(r10);
    }
}
