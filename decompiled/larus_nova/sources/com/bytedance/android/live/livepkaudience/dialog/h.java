package com.bytedance.android.live.livepkaudience.dialog;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkApplyPermissionSwitchDialog f81818a;

    public h(PkApplyPermissionSwitchDialog r100) {
        this.f81818a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PkApplyPermissionSwitchDialog.M0(this.f81818a, true);
    }
}
