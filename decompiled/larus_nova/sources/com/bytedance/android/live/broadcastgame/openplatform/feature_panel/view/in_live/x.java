package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class x implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOpenFeatureSearchFragment f61597a;

    public x(LiveOpenFeatureSearchFragment r100) {
        this.f61597a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f61597a.f61496k.f513437a.clear();
        this.f61597a.f61496k.notifyDataSetChanged();
        ((TextView) this.f61597a.S90(R.id.clear_all_histories)).setVisibility(8);
    }
}
