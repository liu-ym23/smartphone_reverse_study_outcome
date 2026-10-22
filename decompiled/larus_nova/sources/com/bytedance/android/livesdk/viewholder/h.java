package com.bytedance.android.livesdk.viewholder;

import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputSubButtonViewBinder.SubButtonViewHolder f159295a;

    public h(InputSubButtonViewBinder.SubButtonViewHolder r100) {
        this.f159295a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        InputSubButtonViewBinder.SubButtonViewHolder r101 = this.f159295a;
        r101.f159272d.f159268b.invoke(r101.itemView);
    }
}
