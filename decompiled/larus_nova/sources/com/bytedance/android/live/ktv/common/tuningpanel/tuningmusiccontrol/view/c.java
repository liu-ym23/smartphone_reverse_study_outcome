package com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view;

import android.view.View;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningMusicControlContainer f70562a;

    public c(TuningMusicControlContainer r100) {
        this.f70562a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ec0.a r101 = this.f70562a.f70547a;
        if (r101 == null) goto L6;
        r101.i();
        return;
    }
}
