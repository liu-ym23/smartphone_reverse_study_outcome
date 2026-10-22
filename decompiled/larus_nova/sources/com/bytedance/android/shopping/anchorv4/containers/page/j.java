package com.bytedance.android.shopping.anchorv4.containers.page;

import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public final class j implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfScreenProductDetailPage f166296a;

    public j(HalfScreenProductDetailPage r100) {
        this.f166296a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        HalfScreenProductDetailPage.D(this.f166296a, r100.getHeight());
    }
}
