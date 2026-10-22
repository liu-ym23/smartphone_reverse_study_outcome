package com.bytedance.android.ec.core.async;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final void b(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$globalScope");
    }

    public static final Disposable a(Disposable r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$addTo");
        Intrinsics.checkNotNullParameter(r101, "disposableScope");
        return r101.add(r100);
    }
}
