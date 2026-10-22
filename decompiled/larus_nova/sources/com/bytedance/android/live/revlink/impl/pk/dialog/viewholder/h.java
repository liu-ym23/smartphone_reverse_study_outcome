package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import com.bytedance.android.livesdk.link.model.u0;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PKBanViewHolder f96297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u0 f96298b;

    public h(PKBanViewHolder r100, u0 r101) {
        this.f96297a = r100;
        this.f96298b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PKBanViewHolder r101 = this.f96297a;
        x31.s r102 = r101.f96158a;
        if (r102 == null) goto L6;
        r102.rd(r101.getAdapterPosition(), this.f96298b);
        return;
    }
}
