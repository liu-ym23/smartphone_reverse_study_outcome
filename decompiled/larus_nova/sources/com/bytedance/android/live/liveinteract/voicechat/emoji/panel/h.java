package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes46.dex */
public final class h extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatRoomPanelLynxItemVH f80223a;

    public h(ChatRoomPanelLynxItemVH r100) {
        this.f80223a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        FrameLayout r101 = this.f80223a.f80184a;
        if (r101 == null) goto L5;
        int r102 = r101.getChildCount();
    L6:
        if (r102 <= 0) goto L19;
        FrameLayout r103 = this.f80223a.f80184a;
        View r104 = null;
        if (r103 == null) goto L10;
        View r105 = r103.getChildAt(0);
    L12:
        if ((r105 instanceof ViewGroup) == false) goto L15;
        r104 = r105;
    L15:
        ViewGroup r106 = (ViewGroup) r104;
        if (r106 == null) goto L20;
        r106.setClipChildren(false);
        return;
    L20:
        return;
    L10:
        r105 = null;
        goto L12
    L19:
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
