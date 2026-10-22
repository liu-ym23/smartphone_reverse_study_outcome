package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes45.dex */
public final class s implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 f61593a;

    public s(LiveOpenFeatureSearchFragmentV3 r100) {
        this.f61593a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L19;
        EditText r102 = this.f61593a.f61563l;
        if (r102 == null) goto L16;
        Editable r103 = r102.getText();
        if (r103 == null) goto L16;
        if (r103.length() != 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 != true) goto L16;
        ImageView r105 = this.f61593a.f61562k;
        if (r105 == null) goto L23;
        r105.setVisibility(4);
        return;
    L23:
        return;
    L11:
        r104 = false;
    L16:
        ImageView r106 = this.f61593a.f61562k;
        if (r106 == null) goto L25;
        r106.setVisibility(0);
        return;
    L25:
        return;
    L19:
        ImageView r107 = this.f61593a.f61562k;
        if (r107 == null) goto L27;
        r107.setVisibility(4);
        return;
    }
}
