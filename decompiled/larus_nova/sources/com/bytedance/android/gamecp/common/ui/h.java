package com.bytedance.android.gamecp.common.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i.c f56991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f56992b;

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r110) {
        this.f56991a.getClass();
        View r111 = this.f56992b.findViewById(R.id.live_dialog_loading);
        if (r111 != null) goto L5;
        return;
    L5:
        i r100 = this.f56992b;
        r100.f56997e = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f56992b.f56997e.setInterpolator(new LinearInterpolator());
        this.f56992b.f56997e.setRepeatMode(1);
        this.f56992b.f56997e.setRepeatCount(-1);
        this.f56992b.f56997e.setDuration(1000);
        r111.startAnimation(this.f56992b.f56997e);
    }

    public h(i r100, i.c r101) {
        this.f56992b = r100;
        this.f56991a = r101;
    }
}
