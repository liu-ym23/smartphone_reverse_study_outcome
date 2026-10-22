package com.bytedance.android.gamecp.common.ui;

import android.content.DialogInterface;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i.c f56989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f56990b;

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f56989a.getClass();
        Animation r101 = this.f56990b.f56997e;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.hasEnded() == true) goto L9;
        this.f56990b.f56997e.cancel();
        return;
    }

    public g(i r100, i.c r101) {
        this.f56990b = r100;
        this.f56989a = r101;
    }
}
