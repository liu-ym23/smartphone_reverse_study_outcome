package com.bytedance.android.livesdk.interactivity;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LeftAvatarWidget f138567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.base.model.user.e f138568b;

    public n(LeftAvatarWidget r100, com.bytedance.android.live.base.model.user.e r101) {
        this.f138567a = r100;
        this.f138568b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LeftAvatarWidget.xq(this.f138567a, this.f138568b);
    }
}
