package com.bytedance.android.livesdk.widget;

import android.content.DialogInterface;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class w0 implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0.d f162217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f162218b;

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r110) {
        DialogInterface.OnShowListener r100 = this.f162217a.f162251j;
        if (r100 == null) goto L5;
        r100.onShow(r110);
    L5:
        View r111 = this.f162218b.findViewById(R.id.live_dialog_loading);
        if (r111 != null) goto L8;
        return;
    L8:
        x0 r101 = this.f162218b;
        r101.f162234h = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f162218b.f162234h.setInterpolator(new LinearInterpolator());
        this.f162218b.f162234h.setRepeatMode(1);
        this.f162218b.f162234h.setRepeatCount(-1);
        this.f162218b.f162234h.setDuration(1000);
        r111.startAnimation(this.f162218b.f162234h);
    }

    public w0(x0 r100, x0.d r101) {
        this.f162218b = r100;
        this.f162217a = r101;
    }
}
