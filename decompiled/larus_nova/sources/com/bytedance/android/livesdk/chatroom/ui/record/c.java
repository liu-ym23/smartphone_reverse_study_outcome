package com.bytedance.android.livesdk.chatroom.ui.record;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f113986a;

    public c(b r100) {
        this.f113986a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b r101 = this.f113986a;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    }
}
