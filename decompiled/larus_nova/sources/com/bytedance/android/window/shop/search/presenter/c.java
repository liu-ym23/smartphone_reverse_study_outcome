package com.bytedance.android.window.shop.search.presenter;

import com.bytedance.android.ec.window.base.search.history.ECWindowHistoryView;
import com.bytedance.android.ec.window.base.search.history.WindowHistoryBanner;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements WindowHistoryBanner.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchHistoryPresenter f189736a;

    @Override // com.bytedance.android.ec.window.base.search.history.WindowHistoryBanner.b
    public final void a() {
        ECWindowHistoryView r100 = this.f189736a.f189688g;
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // com.bytedance.android.ec.window.base.search.history.WindowHistoryBanner.b
    public final void b() {
        ECWindowHistoryView r100 = this.f189736a.f189688g;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.bytedance.android.ec.window.base.search.history.WindowHistoryBanner.b
    public final void c() {
        ECWindowHistoryView r100 = this.f189736a.f189688g;
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    public c(WindowSearchHistoryPresenter r100) {
        this.f189736a = r100;
    }
}
