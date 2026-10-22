package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends g61.a.C5987a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 f113324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f113325b;

    @Override // g61.a.C5987a, g61.a
    public final boolean b() {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r100 = this.f113324a;
        Object r101 = this.f113325b;
        if ((r101 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == false) goto L10;
        ToolbarButton r102 = ToolbarButton.GAME_CAST_SCREEN;
        if ((r101 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == true) goto L7;
        r101 = null;
    L7:
        r100.d(r102, (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) r101);
        return true;
    L10:
        return true;
    }

    public d(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r100, Object r101) {
        this.f113324a = r100;
        this.f113325b = r101;
    }
}
