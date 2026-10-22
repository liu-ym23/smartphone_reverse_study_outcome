package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkControlViewHolder f82090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkPlayerInfo f82091b;

    public d(PkControlViewHolder r100) {
        this.f82090a = r100;
        this.f82091b = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        xk0.c r101 = this.f82090a.f82027d;
        if (r101 == null) goto L6;
        r101.a(this.f82091b);
        return;
    }
}
