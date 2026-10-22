package com.bytedance.android.live.revenue.common.reactive;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<f<T>> f90980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile T f90981b;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f90982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f90983b;

        public a(c r100, f r101) {
            this.f90982a = r100;
            this.f90983b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f90982a.f90980a.remove(this.f90983b);
        }
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.b, com.bytedance.android.live.revenue.common.reactive.e
    public final T getValue() {
        return this.f90981b;
    }

    public c(T r100) {
        this.f90980a = new CopyOnWriteArrayList();
        this.f90981b = r100;
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.e
    public final Disposable a(f<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f90980a.add(r100);
        return Disposables.fromAction(new a(this, r100));
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.b
    public final void setValue(T r100) {
        this.f90981b = r100;
        Iterator<f<T>> r101 = this.f90980a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a(r100);
        goto L4
    }
}
