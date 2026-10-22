package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class r implements Observable.Operator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jg.a f24265b;

    public class a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f24266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Subscriber f24267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r f24268c;

        public a(r r10, Subscriber r11, Subscriber r12) {
            this.f24268c = r10;
            this.f24267b = r12;
            super(r11);
            this.f24266a = -1;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.f24267b.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.f24267b.onError(r10);
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            long r11 = this.f24268c.f24265b.now();
            long r12 = this.f24266a;
            if (r12 != (-1)) goto L5;
        L8:
            this.f24266a = r11;
            this.f24267b.onNext(r10);
            return;
        L5:
            if (r11 < r12) goto L8;
            if ((r11 - r12) >= this.f24268c.f24264a) goto L8;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public r(long r10, TimeUnit r11, jg.a r12) {
        this.f24264a = r11.toMillis(r10);
        this.f24265b = r12;
    }

    public Subscriber a(Subscriber r10) {
        return new a(this, r10, r10);
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber r10) {
        return a(r10);
    }
}
