package ng;

import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    public static class a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Subscriber f22461a;

        public a(Subscriber r10, Subscriber r11) {
            this.f22461a = r11;
            super(r10);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.f22461a.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.f22461a.onError(r10);
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            this.f22461a.onNext(r10);
        }
    }

    public static Subscriber a(Subscriber r10) {
        return new a(r10, r10);
    }
}
