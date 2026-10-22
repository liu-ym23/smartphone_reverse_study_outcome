package com.bytedance.android.live.core.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f66114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f66115b;

    public b(Runnable r100) {
        this.f66114a = "showCountDownView";
        this.f66115b = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        AnchorMainPostOptUtils.b(this.f66114a, this.f66115b);
    }
}
