package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class k0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0.c f135915a;

    public k0(j0.c r100) {
        this.f135915a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        StringBuilder r101 = new StringBuilder("landscape send button click, panelBridge empty?");
        if (this.f135915a.f135911o.f135895a != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        i40.h.c(r101.toString(), true);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r103 = this.f135915a.f135911o.f135895a;
        if (r103 == null) goto L10;
        r103.p0();
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
