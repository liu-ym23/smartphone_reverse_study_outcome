package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes45.dex */
public final class q implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 f61591a;

    public q(LiveOpenFeatureSearchFragmentV3 r100) {
        this.f61591a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 3) goto L5;
    L16:
        LiveOpenFeatureSearchFragmentV3 r103 = this.f61591a;
        int r104 = LiveOpenFeatureSearchFragmentV3.f61554s;
        r103.T90();
        return true;
    L5:
        if (r101 == 4) goto L16;
        if (r101 == 6) goto L16;
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r102.getAction() == 0) goto L12;
        return false;
    L12:
        if (r102.getKeyCode() == 66) goto L16;
        return false;
    }
}
