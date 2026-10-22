package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;

/* JADX INFO: loaded from: classes47.dex */
public final class c0 extends ka0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b0 f86511c;

    @Override // ka0.b
    public final void a(HybridCard r100, String r101) {
    }

    @Override // ka0.b
    public final void b(HybridCard r100, View r101, int r102) {
        ViewGroup r103 = this.f86511c.f86501c;
        if (r103 == null) goto L5;
        r103.removeAllViews();
    L5:
        ViewGroup r104 = this.f86511c.f86501c;
        if (r104 == null) goto L9;
        r104.addView(r100);
        return;
    }

    public c0(b0 r100, Context r101, Uri r102, int r103) {
        this.f86511c = r100;
        super(r101, r102, r103);
    }
}
