package com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view;

import android.view.View;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningMusicControlContainer f70561a;

    public b(TuningMusicControlContainer r100) {
        this.f70561a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TuningMusicControlContainer r101 = this.f70561a;
        ec0.a r102 = r101.f70547a;
        if (r102 == null) goto L6;
        r102.s(r101.getContext());
        return;
    }
}
