package com.bytedance.android.live.core.utils.rxutils;

import android.animation.Animator;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class RxUtilKt {

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator f66269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f66270b;

        public a(Animator r100, boolean r101) {
            this.f66269a = r100;
            this.f66270b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            if (this.f66270b == false) goto L5;
            this.f66269a.cancel();
            return;
        L5:
            this.f66269a.end();
        }
    }

    public static final class b<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f66271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f66272b;

        public static final class a implements ttc.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CountDownTimerC1097b f66273a;

            public a(CountDownTimerC1097b r100) {
                this.f66273a = r100;
            }

            @Override // ttc.c
            public final void cancel() {
                this.f66273a.cancel();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.core.utils.rxutils.RxUtilKt$b$b, reason: collision with other inner class name */
        public static final class CountDownTimerC1097b extends CountDownTimer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ObservableEmitter f66274a;

            @Override // android.os.CountDownTimer
            public final void onFinish() {
                this.f66274a.onNext(0L);
                this.f66274a.onComplete();
            }

            @Override // android.os.CountDownTimer
            public final void onTick(long r100) {
                this.f66274a.onNext(Long.valueOf(r100));
            }

            public CountDownTimerC1097b(ObservableEmitter r100, long r101, long r102) {
                this.f66274a = r100;
                super(r101, r102);
            }
        }

        public b(long r100, long r101) {
            this.f66271a = r100;
            this.f66272b = r101;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Long> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            CountDownTimerC1097b r101 = new CountDownTimerC1097b(r100, this.f66271a, this.f66272b);
            r100.setCancellable(new a(r101));
            r101.start();
        }
    }

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Observable f66275a;

        public static final class a<T, R> implements Function {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f66276a;

            public a(Ref.ObjectRef r100) {
                this.f66276a = r100;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.functions.Function
            public final Object apply(Object r100) {
                Pair r101 = TuplesKt.to(this.f66276a.element, r100);
                this.f66276a.element = r100;
                return r101;
            }
        }

        public c(Observable r100) {
            this.f66275a = r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // java.util.concurrent.Callable
        public final ObservableSource<? extends Pair<T, T>> call() {
            Ref.ObjectRef r100 = new Ref.ObjectRef();
            r100.element = null;
            return this.f66275a.map(new a(r100));
        }
    }

    public static final class d<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f66277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f66278b;

        public static final class a implements ttc.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Disposable f66279a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f66280b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f66281c;

            public a(Disposable r100, Ref.ObjectRef r101, c r102) {
                this.f66279a = r100;
                this.f66280b = r101;
                this.f66281c = r102;
            }

            @Override // ttc.c
            public final void cancel() {
                this.f66279a.dispose();
                ViewTreeObserver r100 = (ViewTreeObserver) this.f66280b.element;
                if (r100 == null) goto L6;
                r100.removeOnGlobalLayoutListener(this.f66281c);
                return;
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f66282a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f66283b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f66284c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ObservableEmitter f66285d;

            public b(d r100, Ref.ObjectRef r101, c r102, ObservableEmitter r103) {
                this.f66282a = r100;
                this.f66283b = r101;
                this.f66284c = r102;
                this.f66285d = r103;
            }

            /* JADX WARN: Type inference failed for: r3v10, types: [T] */
            /* JADX WARN: Type inference failed for: r3v18 */
            /* JADX WARN: Type inference failed for: r3v19 */
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Ref.ObjectRef r101 = this.f66283b;
                if (((Boolean) r100).booleanValue() == false) goto L5;
                ViewTreeObserver r102 = (T) this.f66282a.f66277a.getViewTreeObserver();
                r102.addOnGlobalLayoutListener(this.f66284c);
                ?? r103 = r102;
            L12:
                r101.element = (T) r103;
                return;
            L5:
                ViewTreeObserver r104 = (ViewTreeObserver) this.f66283b.element;
                if (r104 == null) goto L9;
                r104.removeOnGlobalLayoutListener(this.f66284c);
            L9:
                if (this.f66282a.f66278b == false) goto L11;
                this.f66285d.onComplete();
            L11:
                r103 = (T) null;
                goto L12
            }
        }

        public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ObservableEmitter f66286a;

            public c(ObservableEmitter r100) {
                this.f66286a = r100;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f66286a.onNext(Unit.INSTANCE);
            }
        }

        public d(View r100, boolean r101) {
            this.f66277a = r100;
            this.f66278b = r101;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            c r101 = new c(r100);
            Ref.ObjectRef r102 = new Ref.ObjectRef();
            r102.element = null;
            View r103 = this.f66277a;
            Intrinsics.checkNotNullParameter(r103, "$this$getOnAttachStateChangeObservable");
            r100.setCancellable(new a(Observable.create(new s(r103)).subscribe(new b(this, r102, r101, r100)), r102, r101));
        }
    }

    public final class e implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f66287a;

        public e(Function0 r100) {
            this.f66287a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final /* synthetic */ void run() {
            this.f66287a.invoke();
        }
    }

    public static final <T> Observable<Pair<T, T>> e(Observable<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$diff");
        return Observable.defer(new c(r100));
    }

    public static final Function1<Throwable, Unit> f(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return new RxUtilKt$getOnErrorTrace$1(r100);
    }

    public static final <T> Observable<T> h(Observable<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$observeOnUi");
        return r100.observeOn(AndroidSchedulers.mainThread());
    }

    public static final <T> Single<T> i(Single<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$observeOnUi");
        return r100.observeOn(AndroidSchedulers.mainThread());
    }

    public static final t j(final TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Function1<CharSequence, Unit> r101 = new RxUtilKt$observerOf$3(r100);
        Intrinsics.checkNotNullParameter(r101, "f");
        return new t(r101);
    }

    public static void s(Completable r100) {
        RxUtilKt$subscribeOnErrorTrace$4 r101 = RxUtilKt$subscribeOnErrorTrace$4.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "$this$subscribeOnErrorTrace");
        Intrinsics.checkNotNullParameter("StreamCaptureService", "tag");
        Intrinsics.checkNotNullParameter(r101, "onComplete");
        r100.subscribe(new e(r101), new u(f("StreamCaptureService")));
    }

    public static final <T extends Animator> Disposable a(T r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$asDisposable");
        return Disposables.fromAction(new a(r100, r101));
    }

    public static final void c(Disposable r100, CompositeDisposable r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$bind");
        if (r101 == null) goto L6;
        r101.add(r100);
        return;
    }

    public static final Observable<Long> d(long r100, long r101) {
        return Observable.create(new b(r100, r101));
    }

    public static final Observable<Unit> g(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getOnGlobalLayoutObservable");
        return Observable.create(new d(r100, r101));
    }

    public static final void l(SingleEmitter r100, com.bytedance.android.live.profit.player.s r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeOnSuccess");
        Intrinsics.checkNotNullParameter(r101, "t");
        if (r100.isDisposed() == true) goto L6;
        r100.onSuccess(r101);
        return;
    }

    public static final Disposable m(Completable r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$subscribeOnErrorNoOp");
        Intrinsics.checkNotNullParameter(r101, "onComplete");
        e r102 = new e(r101);
        RxUtilKt$getOnErrorNoOp$1 r103 = RxUtilKt$getOnErrorNoOp$1.INSTANCE;
        Object r104 = r103;
        if (r103 == null) goto L6;
        r104 = new u(r103);
    L6:
        return r100.subscribe(r102, (Consumer) r104);
    }

    public static final <T> Disposable n(Observable<T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$subscribeOnErrorNoOp");
        Intrinsics.checkNotNullParameter(r101, "onNext");
        u r102 = new u(r101);
        RxUtilKt$getOnErrorNoOp$1 r103 = RxUtilKt$getOnErrorNoOp$1.INSTANCE;
        Object r104 = r103;
        if (r103 == null) goto L6;
        r104 = new u(r103);
    L6:
        return r100.subscribe(r102, (Consumer) r104);
    }

    public static final <T> Disposable o(Single<T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$subscribeOnErrorNoOp");
        Intrinsics.checkNotNullParameter(r101, "onNext");
        u r102 = new u(r101);
        RxUtilKt$getOnErrorNoOp$1 r103 = RxUtilKt$getOnErrorNoOp$1.INSTANCE;
        Object r104 = r103;
        if (r103 == null) goto L6;
        r104 = new u(r103);
    L6:
        return r100.subscribe(r102, (Consumer) r104);
    }

    public static /* synthetic */ Disposable r(Single r100, String r101) {
        return q(r100, r101, RxUtilKt$subscribeOnErrorTrace$2.INSTANCE);
    }

    public static final <T> Observable<T> b(DataCenter r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$asObservable");
        Intrinsics.checkNotNullParameter(r101, "key");
        return Observable.create(new r(r100, RxUtilKt$asObservable$1.INSTANCE, r101, r102));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Disposable k(Observable r100, t r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "transformer");
        return (Disposable) r100.map(new v(r102)).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserverDelegate(r101, null, 2, 0 == true ? 1 : 0));
    }

    public static final <T> Disposable p(Observable<T> r100, String r101, Function1<? super T, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$subscribeOnErrorTrace");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "onNext");
        return r100.subscribe(new u(r102), new u(f(r101)));
    }

    public static final <T> Disposable q(Single<T> r100, String r101, Function1<? super T, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$subscribeOnErrorTrace");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "onNext");
        return r100.subscribe(new u(r102), new u(f(r101)));
    }
}
