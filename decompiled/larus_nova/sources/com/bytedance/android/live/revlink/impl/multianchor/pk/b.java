package com.bytedance.android.live.revlink.impl.multianchor.pk;

import android.view.View;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiAnchorLinkInfoTopSelectSubView f94499a;

    public b(MultiAnchorLinkInfoTopSelectSubView r100) {
        this.f94499a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        MultiAnchorLinkInfoTopSelectSubView r101 = this.f94499a;
        r101.setSelected(!r101.isSelected());
    }
}
