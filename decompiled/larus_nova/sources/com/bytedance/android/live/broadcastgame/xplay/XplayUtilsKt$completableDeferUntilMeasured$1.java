package com.bytedance.android.live.broadcastgame.xplay;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class XplayUtilsKt$completableDeferUntilMeasured$1 implements CompletableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f62015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f62016b;

    public XplayUtilsKt$completableDeferUntilMeasured$1(Function0 r100, View r101) {
        this.f62015a = r100;
        this.f62016b = r101;
    }

    @Override // io.reactivex.CompletableOnSubscribe
    public final void subscribe(final CompletableEmitter r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        final CompositeDisposable r101 = new CompositeDisposable();
        r100.setDisposable(r101);
        a r102 = new a(new XplayUtilsKt$completableDeferUntilMeasured$1$runnable$1(this, r101, r100));
        RxUtilKt.c(r102, r101);
        this.f62016b.post(r102);
    }
}
