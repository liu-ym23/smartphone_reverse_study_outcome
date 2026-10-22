package com.bytedance.android.live.revlink.impl.behavior;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements Runnable, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f92136a;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f92136a = null;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f92136a != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0<Unit> r100 = this.f92136a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        Unit r101 = r100.invoke();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f92136a = r100;
    }
}
