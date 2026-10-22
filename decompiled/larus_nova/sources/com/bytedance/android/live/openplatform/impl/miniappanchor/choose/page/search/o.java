package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchHistoryAdapter.ViewHolder f84289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f84290b;

    public o(SearchHistoryAdapter.ViewHolder r100, String r101) {
        this.f84289a = r100;
        this.f84290b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f84289a.f84270c.invoke(2, this.f84290b);
    }
}
