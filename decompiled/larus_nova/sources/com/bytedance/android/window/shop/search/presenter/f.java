package com.bytedance.android.window.shop.search.presenter;

import com.bytedance.android.ec.window.base.search.history.ECWindowHistoryView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchHistoryPresenter f189739a;

    public f(WindowSearchHistoryPresenter r100) {
        this.f189739a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.FALSE) == false) goto L10;
        ECWindowHistoryView r101 = this.f189739a.f189688g;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.f49540c != true) goto L12;
        r101.d();
        return;
    L12:
        return;
    }
}
