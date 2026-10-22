package com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent.collist;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f54430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f54431b;

    public f(d r100, boolean r101) {
        this.f54430a = r100;
        this.f54431b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Disposable r101 = (Disposable) r100;
        d.g(this.f54430a, !this.f54431b, false);
    }
}
