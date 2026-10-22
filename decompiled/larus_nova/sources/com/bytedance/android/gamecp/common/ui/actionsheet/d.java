package com.bytedance.android.gamecp.common.ui.actionsheet;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f56970a;

    public d(e r100) {
        this.f56970a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        bv.a r101 = this.f56970a.f56972b;
        if (r101 == null) goto L5;
        r101.a(r100, true);
    L5:
        e r102 = this.f56970a;
        r102.f56976f = true;
        Dialog r103 = r102.f56975e;
        if (r103 == null) goto L9;
        e.a(r103);
        return;
    }
}
