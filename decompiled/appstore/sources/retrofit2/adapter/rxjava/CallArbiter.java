package retrofit2.adapter.rxjava;

import java.util.concurrent.atomic.AtomicInteger;
import retrofit2.Call;
import retrofit2.Response;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;

/* JADX INFO: loaded from: classes4.dex */
final class CallArbiter<T> extends AtomicInteger implements Subscription, Producer {
    private static final int STATE_HAS_RESPONSE = 2;
    private static final int STATE_REQUESTED = 1;
    private static final int STATE_TERMINATED = 3;
    private static final int STATE_WAITING = 0;
    private final Call<T> call;
    private volatile Response<T> response;
    private final Subscriber subscriber;

    public CallArbiter(Call<T> r10, Subscriber r11) {
        super(0);
        this.call = r10;
        this.subscriber = r11;
    }

    private void deliverResponse(Response<T> r10) {
    L8:
        e = move-exception;
        og.f.c().b().a(e);
        return;
    L6:
        th = move-exception;
        rx.exceptions.a.e(th);
        this.subscriber.onError(th);     // Catch: Throwable -> L24 Throwable -> L26
    L43:
        return;
    L26:
        e = move-exception;
        og.f.c().b().a(e);
        return;
    L24:
        th = move-exception;
        rx.exceptions.a.e(th);
        CompositeException r11 = new CompositeException(new Throwable[]{th, th});
        og.f.c().b().a(r11);
        return;
    L3:
        if (isUnsubscribed() == true) goto L35;
        this.subscriber.onNext(r10);     // Catch: Throwable -> L6 Throwable -> L8
    L35:
    L16:
        e = move-exception;
        og.f.c().b().a(e);
        return;
    L14:
        th = move-exception;
        rx.exceptions.a.e(th);
        og.f.c().b().a(th);
        return;
    L11:
        if (isUnsubscribed() == true) goto L39;
        this.subscriber.onCompleted();     // Catch: Throwable -> L14 Throwable -> L16
    L41:
        return;
    }

    public void emitError(Throwable r10) {
        set(3);
        if (isUnsubscribed() == true) goto L15;
        this.subscriber.onError(r10);     // Catch: Throwable -> L6 Throwable -> L8
    L17:
        return;
    L8:
        e = move-exception;
        og.f.c().b().a(e);
        return;
    L6:
        th = move-exception;
        rx.exceptions.a.e(th);
        CompositeException r11 = new CompositeException(new Throwable[]{r10, th});
        og.f.c().b().a(r11);
        return;
    }

    public void emitResponse(Response<T> r10) {
    L2:
        int r11 = get();
        if (r11 != 0) goto L5;
        this.response = r10;
        if (compareAndSet(0, 2) == false) goto L2;
        return;
    L5:
        if (r11 != 1) goto L6;
        if (compareAndSet(1, 3) == false) goto L2;
        deliverResponse(r10);
        return;
    L6:
        if (r11 == 2) goto L11;
        if (r11 == 3) goto L11;
        throw new IllegalStateException("Unknown state: " + r11);
    L11:
        throw new AssertionError();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.call.isCanceled();
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 != 0) goto L5;
        return;
    L5:
        int r11 = get();
        if (r11 != 0) goto L7;
        if (compareAndSet(0, 1) == false) goto L5;
        return;
    L7:
        if (r11 == 1) goto L31;
        if (r11 != 2) goto L10;
        if (compareAndSet(2, 3) == false) goto L5;
        deliverResponse(this.response);
        return;
    L10:
        if (r11 != 3) goto L13;
        return;
    L13:
        throw new IllegalStateException("Unknown state: " + r11);
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.call.cancel();
    }
}
