package com.bytedance.android.shopping.mall.homepage.card.loadview;

import android.view.View;
import com.bytedance.android.shopping.mall.feed.n;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoadingViewCardVH.b f178010a;

    public a(n.a r100) {
        this.f178010a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LoadingViewCardVH.b r101 = this.f178010a;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
