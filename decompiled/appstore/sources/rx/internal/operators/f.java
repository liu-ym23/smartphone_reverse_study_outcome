package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements Observable.OnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observable f24202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Func1 f24203b;

    public static final class a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Subscriber f24204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Func1 f24205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f24206c;

        public a(Subscriber r10, Func1 r11) {
            this.f24204a = r10;
            this.f24205b = r11;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.f24206c == false) goto L5;
            return;
        L5:
            this.f24204a.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            if (this.f24206c == false) goto L6;
            og.c.j(r10);
            return;
        L6:
            this.f24206c = true;
            this.f24204a.onError(r10);
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            Object r11 = this.f24205b.call(r10);     // Catch: Throwable -> L5
            this.f24204a.onNext(r11);
            return;
        L5:
            th = move-exception;
            rx.exceptions.a.e(th);
            unsubscribe();
            onError(OnErrorThrowable.addValueAsLastCause(th, r10));
        }

        @Override // rx.Subscriber
        public void setProducer(Producer r10) {
            this.f24204a.setProducer(r10);
        }
    }

    public f(Observable r10, Func1 r11) {
        this.f24202a = r10;
        this.f24203b = r11;
    }

    public void a(Subscriber r10) {
        a r11 = new a(r10, this.f24203b);
        r10.add(r11);
        this.f24202a.z(r11);
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        a(r10);
    }
}
