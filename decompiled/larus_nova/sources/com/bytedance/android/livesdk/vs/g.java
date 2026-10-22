package com.bytedance.android.livesdk.vs;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSMessageHandlePopup f159377a;

    public g(VSMessageHandlePopup r100) {
        this.f159377a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        VSMessageHandlePopup r102 = this.f159377a;
        Disposable r103 = r102.f159368a;
        if (r103 == null) goto L5;
        r103.dispose();
    L5:
        r102.f159368a = null;
        throw null;
    }
}
