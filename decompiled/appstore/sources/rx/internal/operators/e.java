package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements Observable.OnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observable.OnSubscribe f24200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Observable.Operator f24201b;

    public e(Observable.OnSubscribe r10, Observable.Operator r11) {
        this.f24200a = r10;
        this.f24201b = r11;
    }

    public void a(Subscriber r10) {
        Subscriber r11 = og.c.m(this.f24201b).call(r10);     // Catch: Throwable -> L8
        r11.onStart();     // Catch: Throwable -> L5
        this.f24200a.call(r11);     // Catch: Throwable -> L5
    L15:
        return;
    L5:
        th = move-exception;
        rx.exceptions.a.e(th);     // Catch: Throwable -> L8
        r11.onError(th);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        rx.exceptions.a.e(th);
        r10.onError(th);
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        a(r10);
    }
}
