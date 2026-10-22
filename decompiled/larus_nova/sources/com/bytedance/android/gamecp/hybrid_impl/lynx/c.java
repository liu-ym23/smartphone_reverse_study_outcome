package com.bytedance.android.gamecp.hybrid_impl.lynx;

import android.content.Context;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f57595a;

    public c(Context r100) {
        this.f57595a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        AtomicBoolean r101 = AnnieXManager.f57562a;
        AnnieXManager.d(this.f57595a);
        r100.onNext(Boolean.TRUE);
        r100.onComplete();
    }
}
