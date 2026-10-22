package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayLandscapeToolbarMoreBehavior f110014a;

    public f(ReplayLandscapeToolbarMoreBehavior r100) {
        this.f110014a = r100;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        mq1.v r101 = this.f110014a.f109977h;
        if (r101 == null) goto L6;
        r101.setVisibilityStatus(false);
        return;
    }
}
