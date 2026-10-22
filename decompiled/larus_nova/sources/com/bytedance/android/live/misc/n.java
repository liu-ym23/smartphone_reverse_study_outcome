package com.bytedance.android.live.misc;

import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n<T> implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<T> f83237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, Unit> f83238b;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        T r100 = this.f83237a.get();
        if (r100 == null) goto L5;
        this.f83238b.invoke(r100);
    L5:
        this.f83237a.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f83237a.get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(T r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onDispose");
        this.f83238b = r101;
        this.f83237a = new WeakReference(r100);
    }
}
