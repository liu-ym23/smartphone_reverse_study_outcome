package com.bytedance.android.live.ktv.common.ordersong.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends ka0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ KtvLabelBannerViewBinder.VH f70128c;

    @Override // ka0.b
    public final void a(HybridCard r100, String r101) {
    }

    @Override // ka0.b
    public final void b(HybridCard r100, View r101, int r102) {
        ViewGroup r103 = this.f70128c.f70123a;
        if (r103 == null) goto L5;
        r103.removeAllViews();
    L5:
        ViewGroup r104 = this.f70128c.f70123a;
        if (r104 == null) goto L8;
        r104.addView(r100);
    L8:
        KtvLabelBannerViewBinder.VH r105 = this.f70128c;
        r105.f70126d = true;
        r105.f70127e = false;
    }

    public a(KtvLabelBannerViewBinder.VH r100, Context r101, Uri r102, int r103) {
        this.f70128c = r100;
        super(r101, r102, r103);
    }
}
