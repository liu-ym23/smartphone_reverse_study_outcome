package com.bytedance.android.live.core.utils;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b0 {

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f66116a;

        public a(Function1 r100) {
            this.f66116a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T r100) {
            this.f66116a.invoke(r100);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f66117a;

        public b(Function1 r100) {
            this.f66117a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f66117a.invoke(sh6.c.b((sh6.b) r100));
        }
    }

    public static final <T> Disposable a(com.bytedance.live.datacontext.m<T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$subscribeChangeWithNotify");
        Intrinsics.checkNotNullParameter(r101, "notify");
        r101.invoke(r100.getValue());
        return r100.a().subscribe(new a(r101));
    }

    public static final <T> Disposable b(com.bytedance.live.datacontext.n<T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$subscribeChangeWithNotify");
        Intrinsics.checkNotNullParameter(r101, "notify");
        r101.invoke(r100.getValue());
        return r100.a().subscribe(new b(r101));
    }
}
