package com.bytedance.android.live.soloktv.view;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownTextView f101837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownTextView.a f101838b;

    public k(CountDownTextView r100, com.bytedance.android.live.soloktv.fragment.o r101) {
        this.f101837a = r100;
        this.f101838b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        CountDownTextView.a r100 = this.f101838b;
        if (r100 == null) goto L5;
        r100.a(this.f101837a);
    L5:
        Disposable r101 = this.f101837a.f101667a;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }
}
