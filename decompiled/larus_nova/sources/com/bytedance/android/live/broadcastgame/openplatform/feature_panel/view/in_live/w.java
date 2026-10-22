package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.view.View;
import android.widget.EditText;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class w implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOpenFeatureSearchFragment f61596a;

    public w(LiveOpenFeatureSearchFragment r100) {
        this.f61596a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((EditText) this.f61596a.S90(R.id.search_edit)).setText("");
    }
}
