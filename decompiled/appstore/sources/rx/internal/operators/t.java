package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Single;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class t implements Single.OnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observable.OnSubscribe f24276a;

    public static final class a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jg.b f24277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f24278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24279c;

        public a(jg.b r10) {
            this.f24277a = r10;
        }

        @Override // rx.Observer
        public void onCompleted() {
            int r10 = this.f24279c;
            if (r10 != 0) goto L6;
            this.f24277a.b(new NoSuchElementException());
            return;
        L6:
            if (r10 != 1) goto L10;
            this.f24279c = 2;
            Object r11 = this.f24278b;
            this.f24278b = null;
            this.f24277a.c(r11);
            return;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            if (this.f24279c != 2) goto L5;
            og.c.j(r10);
            return;
        L5:
            this.f24278b = null;
            this.f24277a.b(r10);
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            int r11 = this.f24279c;
            if (r11 != 0) goto L5;
            this.f24279c = 1;
            this.f24278b = r10;
            return;
        L5:
            if (r11 != 1) goto L9;
            this.f24279c = 2;
            this.f24277a.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
            return;
        }
    }

    public t(Observable.OnSubscribe r10) {
        this.f24276a = r10;
    }

    public void a(jg.b r10) {
        a r11 = new a(r10);
        r10.a(r11);
        this.f24276a.call(r11);
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(jg.b r10) {
        a(r10);
    }
}
