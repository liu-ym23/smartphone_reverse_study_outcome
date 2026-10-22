package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements Observable.OnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observable.OnSubscribe f23995a;

    public static class a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Subscriber f23996a;

        public a(Subscriber r10) {
            super(r10);
            this.f23996a = r10;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.f23996a.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.f23996a.onNext(d.a(r10));     // Catch: Throwable -> L5
            this.f23996a.onCompleted();
            return;
        L5:
            th = move-exception;
            this.f23996a.onError(th);     // Catch: Throwable -> L8 Throwable -> L10
        L20:
            return;
        L10:
            e = move-exception;
            og.f.c().b().a(e);
            return;
        L8:
            th = move-exception;
            rx.exceptions.a.e(th);
            CompositeException r11 = new CompositeException(new Throwable[]{th, th});
            og.f.c().b().a(r11);
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((Response) r10);
        }

        public void onNext(Response r10) {
            this.f23996a.onNext(d.b(r10));
        }
    }

    public e(Observable.OnSubscribe r10) {
        this.f23995a = r10;
    }

    public void a(Subscriber r10) {
        this.f23995a.call(new a(r10));
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        a(r10);
    }
}
