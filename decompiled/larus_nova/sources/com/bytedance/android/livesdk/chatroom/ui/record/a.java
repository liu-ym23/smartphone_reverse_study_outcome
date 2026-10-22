package com.bytedance.android.livesdk.chatroom.ui.record;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f113953a;

    public a(b r100) {
        this.f113953a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b r101 = this.f113953a;
        if (r101.f113967n == false) goto L7;
        View.OnClickListener r102 = r101.f113966m;
        if (r102 == null) goto L7;
        r102.onClick(r100);
    L7:
        b r103 = this.f113953a;
        PopupWindowLancet.handleDismissBeforeOrigin(r103);
        r103.dismiss();
    }
}
