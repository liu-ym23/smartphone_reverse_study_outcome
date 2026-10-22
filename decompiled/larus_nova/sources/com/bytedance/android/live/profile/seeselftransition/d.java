package com.bytedance.android.live.profile.seeselftransition;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Disposable f86163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Disposable f86164b;

    public d(Disposable r100, Disposable r101) {
        this.f86163a = r100;
        this.f86164b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f86163a.dispose();
        this.f86164b.dispose();
    }
}
