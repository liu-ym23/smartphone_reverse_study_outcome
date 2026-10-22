package bk2;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {
    public static final Disposable a(Disposable r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$addTo");
        Intrinsics.checkNotNullParameter(r101, "disposableContext");
        return r101.add(r100);
    }
}
