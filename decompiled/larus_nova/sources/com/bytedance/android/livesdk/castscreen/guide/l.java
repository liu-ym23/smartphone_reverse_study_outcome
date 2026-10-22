package com.bytedance.android.livesdk.castscreen.guide;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadAndPcPlayGuideNew f104510a;

    public l(PadAndPcPlayGuideNew r100) {
        this.f104510a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PadAndPcPlayGuideNew r101 = this.f104510a;
        View r102 = r101.f104467f;
        if (r102 == null) goto L6;
        PadAndPcPlayGuideNew.b(r101, r102, r101.f104471j, r101.f104469h);
        return;
    }
}
