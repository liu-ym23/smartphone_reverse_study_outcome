package com.bytedance.android.livesdk.widget;

import android.content.DialogInterface;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes11.dex */
public final class v0 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0.d f162209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f162210b;

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        DialogInterface.OnDismissListener r101 = this.f162209a.f162250i;
        if (r101 == null) goto L5;
        r101.onDismiss(r100);
    L5:
        Animation r102 = this.f162210b.f162234h;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.hasEnded() == true) goto L12;
        this.f162210b.f162234h.cancel();
        return;
    }

    public v0(x0 r100, x0.d r101) {
        this.f162210b = r100;
        this.f162209a = r101;
    }
}
