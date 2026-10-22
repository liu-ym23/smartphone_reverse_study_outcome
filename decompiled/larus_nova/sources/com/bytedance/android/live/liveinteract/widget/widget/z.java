package com.bytedance.android.live.liveinteract.widget.widget;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: classes46.dex */
public final class z implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectPairRankAdapter.SelectPairRankItemViewHolder f81106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBaseUser f81107b;

    public z(SelectPairRankAdapter.SelectPairRankItemViewHolder r100, IBaseUser r101) {
        this.f81106a = r100;
        this.f81107b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        IBaseUser r101 = this.f81107b;
        if (r101 == null) goto L6;
        this.f81106a.f81023i.a0(r101);
        return;
    }
}
