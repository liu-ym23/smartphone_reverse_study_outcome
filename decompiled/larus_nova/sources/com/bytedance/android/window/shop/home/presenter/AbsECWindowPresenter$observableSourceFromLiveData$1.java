package com.bytedance.android.window.shop.home.presenter;

import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class AbsECWindowPresenter$observableSourceFromLiveData$1<T> implements ObservableSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsECWindowPresenter f188249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zn.a f188250b;

    public AbsECWindowPresenter$observableSourceFromLiveData$1(AbsECWindowPresenter r100, zn.b r101) {
        this.f188249a = r100;
        this.f188250b = r101;
    }

    @Override // io.reactivex.ObservableSource
    public final void subscribe(final Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        DeepThinkTopHeaderComponent$runCollapseAnimation$2 r101 = (Object) this.f188250b.getValue();
        if (r101 == null) goto L6;
        r100.onNext(r101);
        r100.onComplete();
        return;
    L6:
        this.f188249a.y().post(new AnonymousClass1(this, r100));
    }
}
