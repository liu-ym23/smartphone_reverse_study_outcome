package rx.internal.util;

import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;

/* JADX INFO: loaded from: classes4.dex */
public final enum InternalObservableUtils extends Enum<InternalObservableUtils> {
    private static final /* synthetic */ InternalObservableUtils[] $VALUES = null;
    public static final g COUNTER = null;
    static final e ERROR_EXTRACTOR = null;
    public static final Action1<Throwable> ERROR_NOT_IMPLEMENTED = null;
    public static final Observable.Operator<Boolean, Object> IS_EMPTY = null;
    public static final h LONG_COUNTER = null;
    public static final f OBJECT_EQUALS = null;
    static final o RETURNS_VOID = null;
    public static final q TO_ARRAY = null;

    public static final class a implements Func2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Action2 f24348a;

        public a(Action2 r10) {
            this.f24348a = r10;
        }

        @Override // rx.functions.Func2
        public Object call(Object r10, Object r11) {
            this.f24348a.call(r10, r11);
            return r10;
        }
    }

    public static final class b implements Func1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f24349a;

        public b(Object r10) {
            this.f24349a = r10;
        }

        public Boolean a(Object r10) {
            Object r11 = this.f24349a;
            if (r10 == r11) goto L9;
            if (r10 != null) goto L6;
        L8:
            boolean r12 = false;
        L11:
            return Boolean.valueOf(r12);
        L6:
            if (r10.equals(r11) == false) goto L8;
        L9:
            r12 = true;
            goto L11
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a(r10);
        }
    }

    public static final class d implements Func1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f24350a;

        public d(Class r10) {
            this.f24350a = r10;
        }

        public Boolean a(Object r10) {
            return Boolean.valueOf(this.f24350a.isInstance(r10));
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a(r10);
        }
    }

    public static final class e implements Func1 {
        public e() {
        }

        public Throwable a(Notification r10) {
            throw null;
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            androidx.appcompat.widget.p.a(r10);
            return a(null);
        }
    }

    public static final class i implements Func1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Func1 f24351a;

        public i(Func1 r10) {
            this.f24351a = r10;
        }

        public Observable a(Observable r10) {
            return (Observable) this.f24351a.call(r10.f(InternalObservableUtils.RETURNS_VOID));
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Observable) r10);
        }
    }

    public static final class j implements Func0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observable f24352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f24353b;

        public j(Observable r10, int r11) {
            this.f24352a = r10;
            this.f24353b = r11;
        }

        public rx.observables.a a() {
            return this.f24352a.l(this.f24353b);
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public static final class k implements Func0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TimeUnit f24354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Observable f24355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f24356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final jg.a f24357d;

        public k(Observable r10, long r11, TimeUnit r12, jg.a r13) {
            this.f24354a = r12;
            this.f24355b = r10;
            this.f24356c = r11;
            this.f24357d = r13;
        }

        public rx.observables.a a() {
            return this.f24355b.n(this.f24356c, this.f24354a, this.f24357d);
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public static final class l implements Func0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observable f24358a;

        public l(Observable r10) {
            this.f24358a = r10;
        }

        public rx.observables.a a() {
            return this.f24358a.k();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public static final class m implements Func0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f24359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TimeUnit f24360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jg.a f24361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f24362d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Observable f24363e;

        public m(Observable r10, int r11, long r12, TimeUnit r13, jg.a r14) {
            this.f24359a = r12;
            this.f24360b = r13;
            this.f24361c = r14;
            this.f24362d = r11;
            this.f24363e = r10;
        }

        public rx.observables.a a() {
            return this.f24363e.m(this.f24362d, this.f24359a, this.f24360b, this.f24361c);
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public static final class n implements Func1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Func1 f24364a;

        public n(Func1 r10) {
            this.f24364a = r10;
        }

        public Observable a(Observable r10) {
            return (Observable) this.f24364a.call(r10.f(InternalObservableUtils.ERROR_EXTRACTOR));
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Observable) r10);
        }
    }

    public static final class o implements Func1 {
        public o() {
        }

        public Void a(Object r10) {
            return null;
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a(r10);
        }
    }

    public static final class p implements Func1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Func1 f24365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jg.a f24366b;

        public p(Func1 r10, jg.a r11) {
            this.f24365a = r10;
            this.f24366b = r11;
        }

        public Observable a(Observable r10) {
            return ((Observable) this.f24365a.call(r10)).g(this.f24366b);
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object r10) {
            return a((Observable) r10);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [rx.internal.util.InternalObservableUtils$h] */
    /* JADX WARN: Type inference failed for: r0v3, types: [rx.internal.util.InternalObservableUtils$f] */
    /* JADX WARN: Type inference failed for: r0v4, types: [rx.internal.util.InternalObservableUtils$q] */
    /* JADX WARN: Type inference failed for: r0v6, types: [rx.internal.util.InternalObservableUtils$g] */
    static {
        $VALUES = new InternalObservableUtils[0];
        LONG_COUNTER = new h();
        OBJECT_EQUALS = new f();
        TO_ARRAY = new q();
        RETURNS_VOID = new o();
        COUNTER = new g();
        ERROR_EXTRACTOR = new e();
        ERROR_NOT_IMPLEMENTED = new c();
        IS_EMPTY = new rx.internal.operators.h(UtilityFunctions.a(), true);
    }

    private InternalObservableUtils(String r10, int r11) {
        super(r10, r11);
    }

    public static <T, R> Func2<R, T, R> createCollectorCaller(Action2<R, ? super T> r10) {
        return new a(r10);
    }

    public static Func1<Observable, Observable> createRepeatDematerializer(Func1<? super Observable, ? extends Observable> r10) {
        return new i(r10);
    }

    public static <T, R> Func1<Observable, Observable> createReplaySelectorAndObserveOn(Func1<? super Observable, ? extends Observable> r10, jg.a r11) {
        return new p(r10, r11);
    }

    public static <T> Func0<rx.observables.a> createReplaySupplier(Observable r10) {
        return new l(r10);
    }

    public static Func1<Observable, Observable> createRetryDematerializer(Func1<? super Observable, ? extends Observable> r10) {
        return new n(r10);
    }

    public static Func1<Object, Boolean> equalsWith(Object r10) {
        return new b(r10);
    }

    public static Func1<Object, Boolean> isInstanceOf(Class<?> r10) {
        return new d(r10);
    }

    public static InternalObservableUtils valueOf(String r10) {
        return (InternalObservableUtils) Enum.valueOf(InternalObservableUtils.class, r10);
    }

    public static InternalObservableUtils[] values() {
        return (InternalObservableUtils[]) $VALUES.clone();
    }

    public static <T> Func0<rx.observables.a> createReplaySupplier(Observable r10, int r11) {
        return new j(r10, r11);
    }

    public static <T> Func0<rx.observables.a> createReplaySupplier(Observable r10, long r11, TimeUnit r12, jg.a r13) {
        return new k(r10, r11, r12, r13);
    }

    public static <T> Func0<rx.observables.a> createReplaySupplier(Observable r10, int r11, long r12, TimeUnit r13, jg.a r14) {
        return new m(r10, r11, r12, r13, r14);
    }
}
