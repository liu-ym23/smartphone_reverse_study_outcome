package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class n0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0.c f135934a;

    public n0(j0.c r100) {
        this.f135934a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101 = this.f135934a.f135911o.f135895a;
        if (r101 == null) goto L5;
        r101.D0();
    L5:
        i40.h.a("V3 landscape on keyboard click");
        this.f135934a.h(true);
    }
}
