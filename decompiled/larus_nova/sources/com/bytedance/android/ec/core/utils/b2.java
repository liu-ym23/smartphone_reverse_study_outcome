package com.bytedance.android.ec.core.utils;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b2 {

    public static final class a implements com.bytedance.android.ec.opt.asynctask.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f45553a;

        @Override // com.bytedance.android.ec.opt.asynctask.w
        public final com.bytedance.android.ec.opt.asynctask.k r() {
            com.bytedance.android.ec.opt.asynctask.r r100 = new com.bytedance.android.ec.opt.asynctask.r();
            r100.f48047b = true;
            return r100.f48051f;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f45553a.invoke();
        }

        public a(Function0 r100) {
            this.f45553a = r100;
        }
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f45554a;

        public b(Function0 r100) {
            this.f45554a = r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f45554a.invoke();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f45555a = null;

        static {
            f45555a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Unit r101 = (Unit) r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f45556a = null;

        static {
            f45556a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        com.bytedance.android.ec.opt.asynctask.t.b(new a(r100));
    }

    public static final Disposable b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return Single.fromCallable(new b(r100)).subscribeOn(Schedulers.io()).subscribe(c.f45555a, d.f45556a);
    }
}
