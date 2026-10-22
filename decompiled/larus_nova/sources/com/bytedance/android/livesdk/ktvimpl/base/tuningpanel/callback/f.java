package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view.TuningMusicControlContainer;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f143486a;

    public f(j r100) {
        this.f143486a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TuningMusicControlContainer r101 = this.f143486a.f143493d;
        if (r101 == null) goto L10;
        Context r102 = r101.getContext();
        if (r102 == null) goto L11;
        ec0.a r103 = this.f143486a.f143492c;
        if (r103 == null) goto L12;
        r103.s(r102);
        return;
    L12:
        return;
    L11:
        return;
    }
}
