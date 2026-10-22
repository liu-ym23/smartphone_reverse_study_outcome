package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class k8 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j8 f113646a;

    public k8(j8 r100) {
        this.f113646a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        j8 r101 = this.f113646a;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    }
}
