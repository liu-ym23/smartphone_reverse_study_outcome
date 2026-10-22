package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes45.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 f61594a;

    public t(LiveOpenFeatureSearchFragmentV3 r100) {
        this.f61594a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        EditText r101 = this.f61594a.f61563l;
        if (r101 == null) goto L6;
        r101.setText("");
        return;
    }
}
