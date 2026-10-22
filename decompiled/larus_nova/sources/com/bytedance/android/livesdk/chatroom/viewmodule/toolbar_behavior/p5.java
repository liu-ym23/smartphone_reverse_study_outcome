package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class p5 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolbarTransformWidgetBehavior f117335a;

    public p5(ToolbarTransformWidgetBehavior r100) {
        this.f117335a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ToolbarTransformWidgetBehavior r101 = this.f117335a;
        yo2.e r102 = r101.f117043d;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.h() != true) goto L11;
        yo2.e r103 = r101.f117043d;
        if (r103 == null) goto L12;
        r103.d();
        return;
    L12:
        return;
    }
}
