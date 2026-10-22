package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Observable.OnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observable.OnSubscribe f23986a;

    /* JADX INFO: renamed from: retrofit2.adapter.rxjava.a$a, reason: collision with other inner class name */
    public static class C0356a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Subscriber f23987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f23988b;

        public C0356a(Subscriber r10) {
            super(r10);
            this.f23987a = r10;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.f23988b == true) goto L6;
            this.f23987a.onCompleted();
            return;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            if (this.f23988b == true) goto L5;
            this.f23987a.onError(r10);
            return;
        L5:
            AssertionError r11 = new AssertionError("This should never happen! Report as a Retrofit bug with the full stacktrace.");
            r11.initCause(r10);
            og.f.c().b().a(r11);
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((Response) r10);
        }

        public void onNext(Response r10) {
            if (r10.f() == false) goto L5;
            this.f23987a.onNext(r10.a());
            return;
        L5:
            this.f23988b = true;
            HttpException r11 = new HttpException(r10);
            this.f23987a.onError(r11);     // Catch: Throwable -> L8 Throwable -> L10
        L19:
            return;
        L10:
            e = move-exception;
            og.f.c().b().a(e);
            return;
        L8:
            th = move-exception;
            rx.exceptions.a.e(th);
            og.f.c().b().a(new CompositeException(new Throwable[]{r11, th}));
        }
    }

    public a(Observable.OnSubscribe r10) {
        this.f23986a = r10;
    }

    public void a(Subscriber r10) {
        this.f23986a.call(new C0356a(r10));
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        a(r10);
    }
}
