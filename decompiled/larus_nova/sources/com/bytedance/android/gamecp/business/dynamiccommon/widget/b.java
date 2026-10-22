package com.bytedance.android.gamecp.business.dynamiccommon.widget;

import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageLoadingWidgetV2 f53155a;

    public b(PageLoadingWidgetV2 r100) {
        this.f53155a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f53155a.Wo(new d());
    }
}
