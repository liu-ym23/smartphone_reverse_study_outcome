package com.bytedance.android.live.soloktv.view;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownTextView f101835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownTextView.a f101836b;

    public j(CountDownTextView r100, com.bytedance.android.live.soloktv.fragment.o r101) {
        this.f101835a = r100;
        this.f101836b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        CountDownTextView.a r102 = this.f101836b;
        if (r102 == null) goto L5;
        r102.a(this.f101835a);
    L5:
        Disposable r103 = this.f101835a.f101667a;
        if (r103 == null) goto L9;
        r103.dispose();
        return;
    }
}
