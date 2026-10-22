package rx;

import rx.functions.Action1;
import rx.functions.Func1;
import rx.subscriptions.e;

/* JADX INFO: loaded from: classes4.dex */
public class Completable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Completable f24132b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Completable f24133c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OnSubscribe f24134a;

    public interface OnSubscribe extends Action1<CompletableSubscriber> {
    }

    public interface Operator extends Func1<CompletableSubscriber, CompletableSubscriber> {
    }

    public interface Transformer extends Func1<Completable, Completable> {
    }

    public static class a implements OnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Observable f24135a;

        /* JADX INFO: renamed from: rx.Completable$a$a, reason: collision with other inner class name */
        public class C0361a extends Subscriber {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CompletableSubscriber f24136a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f24137b;

            public C0361a(a r10, CompletableSubscriber r11) {
                this.f24137b = r10;
                this.f24136a = r11;
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.f24136a.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable r10) {
                this.f24136a.onError(r10);
            }

            @Override // rx.Observer
            public void onNext(Object r10) {
            }
        }

        public a(Observable r10) {
            this.f24135a = r10;
        }

        public void a(CompletableSubscriber r10) {
            C0361a r11 = new C0361a(this, r10);
            r10.onSubscribe(r11);
            this.f24135a.z(r11);
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(CompletableSubscriber r10) {
            a(r10);
        }
    }

    public static class b implements OnSubscribe {
        public b() {
        }

        public void a(CompletableSubscriber r10) {
            r10.onSubscribe(e.b());
            r10.onCompleted();
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(CompletableSubscriber r10) {
            a(r10);
        }
    }

    public class c implements CompletableSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rx.subscriptions.c f24138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Completable f24139b;

        public c(Completable r10, rx.subscriptions.c r11) {
            this.f24139b = r10;
            this.f24138a = r11;
        }

        @Override // rx.CompletableSubscriber
        public void onCompleted() {
            this.f24138a.unsubscribe();
        }

        @Override // rx.CompletableSubscriber
        public void onError(Throwable r10) {
            og.c.j(r10);
            this.f24138a.unsubscribe();
            Completable.b(r10);
        }

        @Override // rx.CompletableSubscriber
        public void onSubscribe(Subscription r10) {
            this.f24138a.a(r10);
        }
    }

    public static class d implements OnSubscribe {
        public d() {
        }

        public void a(CompletableSubscriber r10) {
            r10.onSubscribe(e.b());
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(CompletableSubscriber r10) {
            a(r10);
        }
    }

    static {
        f24132b = new Completable(new b(), false);
        f24133c = new Completable(new d(), false);
    }

    public Completable(OnSubscribe r10) {
        this.f24134a = og.c.g(r10);
    }

    public static Completable a(OnSubscribe r10) {
        d(r10);
        return new Completable(r10);
    L7:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        og.c.j(th);
        throw f(th);
    }

    public static void b(Throwable r10) {
        Thread r11 = Thread.currentThread();
        r11.getUncaughtExceptionHandler().uncaughtException(r11, r10);
    }

    public static Completable c(Observable r10) {
        d(r10);
        return a(new a(r10));
    }

    public static Object d(Object r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw null;
    }

    public static NullPointerException f(Throwable r10) {
        NullPointerException r11 = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        r11.initCause(r10);
        return r11;
    }

    public final Subscription e() {
        rx.subscriptions.c r10 = new rx.subscriptions.c();
        g(new c(this, r10));
        return r10;
    }

    public final void g(CompletableSubscriber r10) {
        d(r10);
        og.c.e(this, this.f24134a).call(r10);     // Catch: Throwable -> L5 NullPointerException -> L7
        return;
    L7:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        rx.exceptions.a.e(th);
        Throwable r11 = og.c.d(th);
        og.c.j(r11);
        throw f(r11);
    }

    public Completable(OnSubscribe r10, boolean r11) {
        if (r11 == false) goto L5;
        r10 = og.c.g(r10);
    L5:
        this.f24134a = r10;
    }
}
