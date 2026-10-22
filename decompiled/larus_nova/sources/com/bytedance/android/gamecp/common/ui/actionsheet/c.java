package com.bytedance.android.gamecp.common.ui.actionsheet;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f56968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f56969b;

    public c(a r100, e r101) {
        this.f56968a = r100;
        this.f56969b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        e r101 = this.f56969b;
        Dialog r102 = r101.f56975e;
        if (r102 == null) goto L8;
        bv.b r103 = r101.f56971a;
        if (r103 == null) goto L9;
        r103.a(r102, r100, this.f56968a);
        return;
    L9:
        return;
    }
}
