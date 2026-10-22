package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaAnchorInteractContainerFragment f138104a;

    public b(MediaAnchorInteractContainerFragment r100) {
        this.f138104a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        MediaAnchorInteractContainerFragment r101 = this.f138104a;
        int r102 = MediaAnchorInteractContainerFragment.f138007h;
        t82.f r103 = r101.f138106d;
        MediaAnchorInteractSettingFragment r104 = new MediaAnchorInteractSettingFragment();
        r104.f138108f = new u82.a(r104);
        r104.f138106d = r103;
        r103.v20(r104);
    }
}
