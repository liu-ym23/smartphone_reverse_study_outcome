package com.bytedance.android.gamecp.business.floatwindow.installguide;

import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InstallGuideView f53209a;

    public m(InstallGuideView r100) {
        this.f53209a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b r101 = this.f53209a.f53185e;
        if (r101 == null) goto L6;
        r101.onClose();
        return;
    }
}
