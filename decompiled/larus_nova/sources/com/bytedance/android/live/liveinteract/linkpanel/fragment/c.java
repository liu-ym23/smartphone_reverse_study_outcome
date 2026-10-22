package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ApplyPermissionSwitchFragment f74686a;

    public c(ApplyPermissionSwitchFragment r100) {
        this.f74686a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ApplyPermissionSwitchFragment.ba0(this.f74686a, false);
    }
}
