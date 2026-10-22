package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public class s implements Observable.Operator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jg.a f24269a;

    public class a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Subscriber f24270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f24271b;

        public a(s r10, Subscriber r11) {
            this.f24271b = r10;
            this.f24270a = r11;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.f24270a.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.f24270a.onError(r10);
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            this.f24270a.onNext(r10);
        }
    }

    public class b implements Action0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Subscriber f24272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f24273b;

        public class a implements Action0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ jg.a.AbstractC0284a f24274a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f24275b;

            public a(b r10, jg.a.AbstractC0284a r11) {
                this.f24275b = r10;
                this.f24274a = r11;
            }

            @Override // rx.functions.Action0
            public void call() {
                this.f24275b.f24272a.unsubscribe();
                this.f24274a.unsubscribe();
            }
        }

        public b(s r10, Subscriber r11) {
            this.f24273b = r10;
            this.f24272a = r11;
        }

        @Override // rx.functions.Action0
        public void call() {
            jg.a.AbstractC0284a r10 = this.f24273b.f24269a.createWorker();
            r10.a(new a(this, r10));
        }
    }

    public s(jg.a r10) {
        this.f24269a = r10;
    }

    public Subscriber a(Subscriber r10) {
        a r11 = new a(this, r10);
        r10.add(rx.subscriptions.e.a(new b(this, r11)));
        return r11;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber r10) {
        return a(r10);
    }
}
