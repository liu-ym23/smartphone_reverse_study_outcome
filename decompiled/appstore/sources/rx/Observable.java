package rx;

import java.util.concurrent.TimeUnit;
import ng.a;
import og.c;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func1;
import rx.internal.operators.OperatorReplay;
import rx.internal.operators.f;
import rx.internal.operators.g;
import rx.internal.operators.i;
import rx.internal.operators.m;
import rx.internal.operators.n;
import rx.internal.operators.q;
import rx.internal.operators.r;
import rx.internal.operators.s;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.subscriptions.e;

/* JADX INFO: loaded from: classes4.dex */
public class Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OnSubscribe f24140a;

    public interface OnSubscribe<T> extends Action1<Subscriber> {
    }

    public interface Operator<R, T> extends Func1<Subscriber, Subscriber> {
    }

    public interface Transformer<T, R> extends Func1<Observable, Observable> {
    }

    public Observable(OnSubscribe r10) {
        this.f24140a = r10;
    }

    public static Observable b(OnSubscribe r10) {
        return new Observable(c.h(r10));
    }

    public static Observable d(Object r10) {
        return ScalarSynchronousObservable.B(r10);
    }

    public static Subscription r(Subscriber r10, Observable r11) {
        if (r10 == null) goto L23;
        if (r11.f24140a == null) goto L21;
        r10.onStart();
        if ((r10 instanceof a) == true) goto L24;
        r10 = new a(r10);
    L24:
        c.o(r11, r11.f24140a).call(r10);     // Catch: Throwable -> L10
        return c.n(r10);
    L10:
        th = move-exception;
        rx.exceptions.a.e(th);
        if (r10.isUnsubscribed() == false) goto L26;
        c.j(c.l(th));
    L16:
        return e.b();
    L26:
        r10.onError(c.l(th));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        rx.exceptions.a.e(th);
        OnErrorFailedException r12 = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th);
        c.l(r12);
        throw r12;
    L21:
        throw new IllegalStateException("onSubscribe function can not be null.");
    L23:
        throw new IllegalArgumentException("subscriber can not be null");
    }

    public static Observable y(OnSubscribe r10) {
        return new Observable(c.h(r10));
    }

    public final Observable A(jg.a r10) {
        return e(new s(r10));
    }

    public Observable a(Transformer r10) {
        return r10.call(this);
    }

    public final Observable c() {
        return e(i.c());
    }

    public final Observable e(Operator r10) {
        return y(new rx.internal.operators.e(this.f24140a, r10));
    }

    public final Observable f(Func1 r10) {
        return y(new f(this, r10));
    }

    public final Observable g(jg.a r10) {
        return h(r10, rx.internal.util.f.f24424d);
    }

    public final Observable h(jg.a r10, int r11) {
        return i(r10, false, r11);
    }

    public final Observable i(jg.a r10, boolean r11, int r12) {
        if ((this instanceof ScalarSynchronousObservable) == false) goto L7;
        return ((ScalarSynchronousObservable) this).D(r10);
    L7:
        return e(new m(r10, r11, r12));
    }

    public final Observable j() {
        return e(n.b());
    }

    public final rx.observables.a k() {
        return OperatorReplay.C(this);
    }

    public final rx.observables.a l(int r10) {
        return OperatorReplay.D(this, r10);
    }

    public final rx.observables.a m(int r10, long r11, TimeUnit r12, jg.a r13) {
        if (r10 < 0) goto L6;
        return OperatorReplay.F(this, r11, r12, r13, r10);
    L6:
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final rx.observables.a n(long r10, TimeUnit r11, jg.a r12) {
        return OperatorReplay.E(this, r10, r11, r12);
    }

    public final Subscription o() {
        return q(new rx.internal.util.a(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
    }

    public final Subscription p(Observer r10) {
        if ((r10 instanceof Subscriber) == true) goto L5;
        if (r10 == null) goto L10;
        return q(new rx.internal.util.c(r10));
    L10:
        throw new NullPointerException("observer is null");
    L5:
        return q((Subscriber) r10);
    }

    public final Subscription q(Subscriber r10) {
        return r(r10, this);
    }

    public final Observable s(jg.a r10) {
        return t(r10, true);
    }

    public final Observable t(jg.a r10, boolean r11) {
        if ((this instanceof ScalarSynchronousObservable) == false) goto L7;
        return ((ScalarSynchronousObservable) this).D(r10);
    L7:
        return y(new q(this, r10, r11));
    }

    public final Observable u(long r10, TimeUnit r11) {
        return v(r10, r11, pg.a.a());
    }

    public final Observable v(long r10, TimeUnit r11, jg.a r12) {
        return e(new r(r10, r11, r12));
    }

    public Completable w() {
        return Completable.c(this);
    }

    public Single x() {
        return new Single(g.b(this));
    }

    public final Subscription z(Subscriber r10) {
        r10.onStart();     // Catch: Throwable -> L4
        c.o(this, this.f24140a).call(r10);     // Catch: Throwable -> L4
        return c.n(r10);
    L4:
        th = move-exception;
        rx.exceptions.a.e(th);
        r10.onError(c.l(th));     // Catch: Throwable -> L9
        return e.b();
    L9:
        th = move-exception;
        rx.exceptions.a.e(th);
        OnErrorFailedException r11 = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th);
        c.l(r11);
        throw r11;
    }
}
