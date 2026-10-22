package og;

import rx.Observable;
import rx.Single;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {
    public h() {
    }

    public Single.OnSubscribe a(Single.OnSubscribe r10) {
        return r10;
    }

    public Observable.Operator b(Observable.Operator r10) {
        return r10;
    }

    public Throwable c(Throwable r10) {
        return r10;
    }

    public Subscription d(Subscription r10) {
        return r10;
    }

    public Observable.OnSubscribe e(Single r10, Observable.OnSubscribe r11) {
        return r11;
    }
}
