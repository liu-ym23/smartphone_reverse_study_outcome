package com.bytedance.android.livesdk.interactivity.chatchannel.v2.view;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChannelTrayListViewBinder.ItemViewHolder f134421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p62.a f134422b;

    public a(ChannelTrayListViewBinder.ItemViewHolder r100, p62.a r101) {
        this.f134421a = r100;
        this.f134422b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f134421a.f134410j.a(this.f134422b);
    }
}
