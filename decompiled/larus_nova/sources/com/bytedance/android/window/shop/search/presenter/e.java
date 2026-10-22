package com.bytedance.android.window.shop.search.presenter;

import com.bytedance.android.ec.window.base.search.history.ECWindowHistoryView;
import com.bytedance.android.ec.window.base.search.history.WindowHistoryBanner;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchHistoryPresenter f189738a;

    public e(WindowSearchHistoryPresenter r100) {
        this.f189738a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        if (r101 == null) goto L16;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L22;
        cp.a r103 = (cp.a) r102.next();
        WindowSearchHistoryPresenter r104 = this.f189738a;
        ECWindowHistoryView r105 = r104.f189688g;
        if (r105 == null) goto L10;
        r105.c(r103);
    L10:
        WindowHistoryBanner r106 = r104.f189689h;
        if (r106 == null) goto L13;
        r106.setVisibility(0);
    L13:
        ECWindowHistoryView r107 = r104.f189688g;
        if (r107 == null) goto L6;
        r107.setVisibility(0);
        goto L6
    L22:
        return;
    }
}
