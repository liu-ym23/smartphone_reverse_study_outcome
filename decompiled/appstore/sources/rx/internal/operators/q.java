package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements Observable.OnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jg.a f24252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Observable f24253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f24254c;

    public static final class a extends Subscriber implements Action0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Subscriber f24255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f24256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jg.a.AbstractC0284a f24257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Observable f24258d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Thread f24259e;

        /* JADX INFO: renamed from: rx.internal.operators.q$a$a, reason: collision with other inner class name */
        public class C0364a implements Producer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Producer f24260a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f24261b;

            /* JADX INFO: renamed from: rx.internal.operators.q$a$a$a, reason: collision with other inner class name */
            public class C0365a implements Action0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ long f24262a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ C0364a f24263b;

                public C0365a(C0364a r10, long r11) {
                    this.f24263b = r10;
                    this.f24262a = r11;
                }

                @Override // rx.functions.Action0
                public void call() {
                    this.f24263b.f24260a.request(this.f24262a);
                }
            }

            public C0364a(a r10, Producer r11) {
                this.f24261b = r10;
                this.f24260a = r11;
            }

            @Override // rx.Producer
            public void request(long r10) {
                if (this.f24261b.f24259e == Thread.currentThread()) goto L8;
                a r11 = this.f24261b;
                if (r11.f24256b == false) goto L8;
                r11.f24257c.a(new C0365a(this, r10));
                return;
            L8:
                this.f24260a.request(r10);
            }
        }

        public a(Subscriber r10, boolean r11, jg.a.AbstractC0284a r12, Observable r13) {
            this.f24255a = r10;
            this.f24256b = r11;
            this.f24257c = r12;
            this.f24258d = r13;
        }

        @Override // rx.functions.Action0
        public void call() {
            Observable r10 = this.f24258d;
            this.f24258d = null;
            this.f24259e = Thread.currentThread();
            r10.z(this);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.f24255a.onCompleted();     // Catch: Throwable -> L5
            this.f24257c.unsubscribe();
            return;
        L5:
            th = move-exception;
            this.f24257c.unsubscribe();
            throw th;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.f24255a.onError(r10);     // Catch: Throwable -> L5
            this.f24257c.unsubscribe();
            return;
        L5:
            th = move-exception;
            this.f24257c.unsubscribe();
            throw th;
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            this.f24255a.onNext(r10);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer r10) {
            this.f24255a.setProducer(new C0364a(this, r10));
        }
    }

    public q(Observable r10, jg.a r11, boolean r12) {
        this.f24252a = r11;
        this.f24253b = r10;
        this.f24254c = r12;
    }

    public void a(Subscriber r10) {
        jg.a.AbstractC0284a r11 = this.f24252a.createWorker();
        a r12 = new a(r10, this.f24254c, r11, this.f24253b);
        r10.add(r12);
        r10.add(r11);
        r11.a(r12);
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        a(r10);
    }
}
