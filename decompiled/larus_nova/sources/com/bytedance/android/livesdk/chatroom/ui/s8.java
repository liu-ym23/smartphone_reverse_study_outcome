package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class s8 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResolutionDowngradeView f114062a;

    public s8(ResolutionDowngradeView r100) {
        this.f114062a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f114062a.getOnSelectResolutionDowngrade().invoke();
    }
}
