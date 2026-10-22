package com.bytedance.android.ec.core.imagex;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f44542a;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Disposable r100 = this.f44542a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Disposable r100 = this.f44542a;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.isDisposed();
    }

    public b(int r100) {
        this.f44542a = null;
    }

    public final void b(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, RNParamRegisterEventHandler.SRC_INNER);
        if (Intrinsics.areEqual(r100, this) == false) goto L5;
        return;
    L5:
        this.f44542a = r100;
    }
}
