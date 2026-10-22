package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Single;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public class g implements Single.OnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observable f24207a;

    public class a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f24208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f24209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f24210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ jg.b f24211d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ g f24212e;

        public a(g r10, jg.b r11) {
            this.f24212e = r10;
            this.f24211d = r11;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.f24208a == false) goto L6;
            return;
        L6:
            if (this.f24209b == false) goto L8;
            this.f24211d.c(this.f24210c);
            return;
        L8:
            this.f24211d.b(new NoSuchElementException("Observable emitted no items"));
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.f24211d.b(r10);
            unsubscribe();
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            if (this.f24209b == false) goto L5;
            this.f24208a = true;
            this.f24211d.b(new IllegalArgumentException("Observable emitted too many elements"));
            unsubscribe();
            return;
        L5:
            this.f24209b = true;
            this.f24210c = r10;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(2);
        }
    }

    public g(Observable r10) {
        this.f24207a = r10;
    }

    public static g b(Observable r10) {
        return new g(r10);
    }

    public void a(jg.b r10) {
        a r11 = new a(this, r10);
        r10.a(r11);
        this.f24207a.z(r11);
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(jg.b r10) {
        a(r10);
    }
}
