package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes45.dex */
public final class u implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 f61595a;

    public u(LiveOpenFeatureSearchFragmentV3 r100) {
        this.f61595a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f61595a.f61569r.f513437a.clear();
        this.f61595a.f61569r.notifyDataSetChanged();
        TextView r101 = this.f61595a.f61555d;
        if (r101 == null) goto L6;
        r101.setVisibility(8);
        return;
    }
}
