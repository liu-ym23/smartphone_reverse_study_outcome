package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchHistoryAdapter.ViewHolder f84287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f84288b;

    public n(SearchHistoryAdapter.ViewHolder r100, String r101) {
        this.f84287a = r100;
        this.f84288b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f84287a.f84270c.invoke(1, this.f84288b);
    }
}
