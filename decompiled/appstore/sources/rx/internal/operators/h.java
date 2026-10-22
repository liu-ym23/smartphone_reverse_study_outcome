package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements Observable.Operator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Func1 f24213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f24214b;

    public class a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f24215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f24216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f24217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Subscriber f24218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ h f24219e;

        public a(h r10, SingleDelayedProducer r11, Subscriber r12) {
            this.f24219e = r10;
            this.f24217c = r11;
            this.f24218d = r12;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.f24216b == true) goto L9;
            this.f24216b = true;
            if (this.f24215a == false) goto L7;
            this.f24217c.setValue(Boolean.FALSE);
            return;
        L7:
            this.f24217c.setValue(Boolean.valueOf(this.f24219e.f24214b));
            return;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            if (this.f24216b == true) goto L5;
            this.f24216b = true;
            this.f24218d.onError(r10);
            return;
        L5:
            og.c.j(r10);
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            if (this.f24216b == false) goto L5;
            return;
        L5:
            this.f24215a = true;
            if (((Boolean) this.f24219e.f24213a.call(r10)).booleanValue() == false) goto L15;
            this.f24216b = true;
            this.f24217c.setValue(Boolean.valueOf(true ^ this.f24219e.f24214b));
            unsubscribe();
            return;
        L15:
            return;
        L10:
            th = move-exception;
            rx.exceptions.a.g(th, this, r10);
        }
    }

    public h(Func1 r10, boolean r11) {
        this.f24213a = r10;
        this.f24214b = r11;
    }

    public Subscriber a(Subscriber r10) {
        SingleDelayedProducer r11 = new SingleDelayedProducer(r10);
        a r12 = new a(this, r11, r10);
        r10.add(r12);
        r10.setProducer(r11);
        return r12;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber r10) {
        return a(r10);
    }
}
