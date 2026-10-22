package com.bytedance.android.live.core.arch.mvvm;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class StateBuffer<T> extends Observable<T> implements Observer<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f64755d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super T, Unit> f64756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject<T> f64757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a<T> f64758c;

    public static final class Companion {
        public static StateBuffer a(final Function2 r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            final StateBuffer r101 = new StateBuffer();
            Function1<T, Unit> r102 = new StateBuffer$Companion$create$1(r100, r101);
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f64756a = r102;
            return r101;
        }
    }

    public static abstract class a<T> {

        /* JADX INFO: renamed from: com.bytedance.android.live.core.arch.mvvm.StateBuffer$a$a, reason: collision with other inner class name */
        public static final class C1062a<T> extends a<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public h80.c<T> f64759a;

            public C1062a() {
            }

            @Override // com.bytedance.android.live.core.arch.mvvm.StateBuffer.a
            public final void a(Function1<? super T, Unit> r100) {
                Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
                h80.c<T> r101 = this.f64759a;
                if (r101 == null) goto L10;
                DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r102 = r101.f484055a;
                if (r102 != null) goto L8;
                r102 = null;
            L8:
                r100.invoke(r102);
                this.f64759a = null;
                return;
            }

            @Override // com.bytedance.android.live.core.arch.mvvm.StateBuffer.a
            public final void b(T r100, Function1<? super T, Unit> r101) {
                Intrinsics.checkNotNullParameter(r101, TeaEventTrack.ACTION_DRAMA_NEXT);
                this.f64759a = h80.c.c(r100);
            }
        }

        public static final class b<T> extends a<T> {
            @Override // com.bytedance.android.live.core.arch.mvvm.StateBuffer.a
            public final void a(Function1<? super T, Unit> r100) {
                Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
            }

            public b() {
            }

            @Override // com.bytedance.android.live.core.arch.mvvm.StateBuffer.a
            public final void b(T r100, Function1<? super T, Unit> r101) {
                Intrinsics.checkNotNullParameter(r101, TeaEventTrack.ACTION_DRAMA_NEXT);
                r101.invoke(r100);
            }
        }

        public a() {
        }

        public abstract void a(Function1<? super T, Unit> r100);

        public abstract void b(T r100, Function1<? super T, Unit> r101);
    }

    static {
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        this.f64757b.onComplete();
    }

    public StateBuffer() {
        this.f64756a = StateBuffer$onEnterState$1.INSTANCE;
        this.f64757b = PublishSubject.create();
        this.f64758c = new a.b();
    }

    public final void a(a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        a<T> r101 = this.f64758c;
        this.f64758c = r100;
        r101.a(new StateBuffer$curStrategy$1(this));
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        this.f64757b.onError(r100);
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        this.f64758c.b(r100, new StateBuffer$sendState$1(this));
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f64757b.onSubscribe(r100);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f64757b.subscribe(r100);
    }
}
