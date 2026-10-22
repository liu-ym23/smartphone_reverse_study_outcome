package og;

import rx.Completable;
import rx.Observable;
import rx.Single;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.operators.t;
import rx.internal.operators.v;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Action1 f22600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Func1 f22601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Func1 f22602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Func1 f22603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Func2 f22604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile Func2 f22605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile Func2 f22606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile Func1 f22607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile Func1 f22608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile Func1 f22609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile Func1 f22610k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile Func1 f22611l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile Func0 f22612m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile Func1 f22613n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile Func1 f22614o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile Func1 f22615p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile Func1 f22616q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile Func1 f22617r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile Func1 f22618s;

    public static class a implements Func1 {
        public a() {
        }

        public Throwable a(Throwable r10) {
            return og.f.c().g().c(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Throwable) r10);
        }
    }

    public static class b implements Func1 {
        public b() {
        }

        public Observable.Operator a(Observable.Operator r10) {
            return og.f.c().g().b(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Observable.Operator) r10);
        }
    }

    /* JADX INFO: renamed from: og.c$c, reason: collision with other inner class name */
    public static class C0330c implements Func1 {
        public C0330c() {
        }

        public Throwable a(Throwable r10) {
            return og.f.c().a().c(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Throwable) r10);
        }
    }

    public static class d implements Func1 {
        public d() {
        }

        public Completable.Operator a(Completable.Operator r10) {
            return og.f.c().a().b(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Completable.Operator) r10);
        }
    }

    public static class e implements Func1 {
        public e() {
        }

        public Observable.OnSubscribe a(Observable.OnSubscribe r10) {
            return og.f.c().d().a(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Observable.OnSubscribe) r10);
        }
    }

    public static class f implements Func1 {
        public f() {
        }

        public Single.OnSubscribe a(Single.OnSubscribe r10) {
            return og.f.c().g().a(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Single.OnSubscribe) r10);
        }
    }

    public static class g implements Func1 {
        public g() {
        }

        public Completable.OnSubscribe a(Completable.OnSubscribe r10) {
            return og.f.c().a().a(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Completable.OnSubscribe) r10);
        }
    }

    public static class h implements Action1 {
        public h() {
        }

        public void a(Throwable r10) {
            og.f.c().b().a(r10);
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object r10) {
            a((Throwable) r10);
        }
    }

    public static class i implements Func2 {
        public i() {
        }

        public Observable.OnSubscribe a(Observable r10, Observable.OnSubscribe r11) {
            return og.f.c().d().e(r10, r11);
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Object call(Object r10, Object r11) {
            return a((Observable) r10, (Observable.OnSubscribe) r11);
        }
    }

    public static class j implements Func1 {
        public j() {
        }

        public Subscription a(Subscription r10) {
            return og.f.c().d().d(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Subscription) r10);
        }
    }

    public static class k implements Func2 {
        public k() {
        }

        public Single.OnSubscribe a(Single r10, Single.OnSubscribe r11) {
            og.h r12 = og.f.c().g();
            if (r12 != og.i.f()) goto L6;
            return r11;
        L6:
            return new t(r12.e(r10, new v(r11)));
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Object call(Object r10, Object r11) {
            return a((Single) r10, (Single.OnSubscribe) r11);
        }
    }

    public static class l implements Func1 {
        public l() {
        }

        public Subscription a(Subscription r10) {
            return og.f.c().g().d(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Subscription) r10);
        }
    }

    public static class m implements Func2 {
        public m() {
        }

        public Completable.OnSubscribe a(Completable r10, Completable.OnSubscribe r11) {
            return og.f.c().a().d(r10, r11);
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Object call(Object r10, Object r11) {
            return a((Completable) r10, (Completable.OnSubscribe) r11);
        }
    }

    public static class n implements Func1 {
        public n() {
        }

        public Action0 a(Action0 r10) {
            return og.f.c().f().k(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Action0) r10);
        }
    }

    public static class o implements Func1 {
        public o() {
        }

        public Throwable a(Throwable r10) {
            return og.f.c().d().c(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Throwable) r10);
        }
    }

    public static class p implements Func1 {
        public p() {
        }

        public Observable.Operator a(Observable.Operator r10) {
            return og.f.c().d().b(r10);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Observable.Operator) r10);
        }
    }

    static {
        b();
    }

    public static Func0 a() {
        return f22612m;
    }

    public static void b() {
        f22600a = new h();
        f22604e = new i();
        f22610k = new j();
        f22605f = new k();
        f22611l = new l();
        f22606g = new m();
        f22609j = new n();
        f22613n = new o();
        f22616q = new p();
        f22614o = new a();
        f22617r = new b();
        f22615p = new C0330c();
        f22618s = new d();
        c();
    }

    public static void c() {
        f22601b = new e();
        f22602c = new f();
        f22603d = new g();
    }

    public static Throwable d(Throwable r10) {
        Func1 r11 = f22615p;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return (Throwable) r11.call(r10);
    }

    public static Completable.OnSubscribe e(Completable r10, Completable.OnSubscribe r11) {
        Func2 r12 = f22606g;
        if (r12 != null) goto L5;
        return r11;
    L5:
        return (Completable.OnSubscribe) r12.call(r10, r11);
    }

    public static jg.a f(jg.a r10) {
        Func1 r11 = f22607h;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return (jg.a) r11.call(r10);
    }

    public static Completable.OnSubscribe g(Completable.OnSubscribe r10) {
        Func1 r11 = f22603d;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return (Completable.OnSubscribe) r11.call(r10);
    }

    public static Observable.OnSubscribe h(Observable.OnSubscribe r10) {
        Func1 r11 = f22601b;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return (Observable.OnSubscribe) r11.call(r10);
    }

    public static Single.OnSubscribe i(Single.OnSubscribe r10) {
        Func1 r11 = f22602c;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return (Single.OnSubscribe) r11.call(r10);
    }

    public static void j(Throwable r10) {
        Action1 r11 = f22600a;
        if (r11 != null) goto L10;
    L8:
        q(r10);
        return;
    L10:
        r11.call(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        System.err.println("The onError handler threw an Exception. It shouldn't. => " + th.getMessage());
        th.printStackTrace();
        q(th);
        goto L8
    }

    public static jg.a k(jg.a r10) {
        Func1 r11 = f22608i;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return (jg.a) r11.call(r10);
    }

    public static Throwable l(Throwable r10) {
        Func1 r11 = f22613n;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return (Throwable) r11.call(r10);
    }

    public static Observable.Operator m(Observable.Operator r10) {
        Func1 r11 = f22616q;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return (Observable.Operator) r11.call(r10);
    }

    public static Subscription n(Subscription r10) {
        Func1 r11 = f22610k;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return (Subscription) r11.call(r10);
    }

    public static Observable.OnSubscribe o(Observable r10, Observable.OnSubscribe r11) {
        Func2 r12 = f22604e;
        if (r12 != null) goto L5;
        return r11;
    L5:
        return (Observable.OnSubscribe) r12.call(r10, r11);
    }

    public static Action0 p(Action0 r10) {
        Func1 r11 = f22609j;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return (Action0) r11.call(r10);
    }

    public static void q(Throwable r10) {
        Thread r11 = Thread.currentThread();
        r11.getUncaughtExceptionHandler().uncaughtException(r11, r10);
    }
}
