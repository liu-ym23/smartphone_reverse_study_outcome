package rx.internal.operators;

import rx.Observable;
import rx.Single;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements Observable.OnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Single.OnSubscribe f24281a;

    public v(Single.OnSubscribe r10) {
        this.f24281a = r10;
    }

    public void a(Subscriber r10) {
        u r11 = new u(r10);
        r10.add(r11);
        this.f24281a.call(r11);
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        a(r10);
    }
}
