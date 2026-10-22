package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import android.content.Context;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayMessageHandlePopup f109015a;

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        this.f109015a.a();
    }

    public final void a() {
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
    }

    public i(ReplayMessageHandlePopup r100, Context r101) {
        this.f109015a = r100;
        super(r101);
    }
}
