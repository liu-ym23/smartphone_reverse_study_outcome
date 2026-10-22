package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Disposable f133004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Disposable f133005b;

    public m(Disposable r100, Disposable r101) {
        this.f133004a = r100;
        this.f133005b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f133004a.dispose();
        Disposable r100 = this.f133005b;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }
}
