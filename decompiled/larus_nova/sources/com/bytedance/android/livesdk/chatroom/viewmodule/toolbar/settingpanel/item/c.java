package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.SmallWindowQuestionCircleDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f116755a = null;

    static {
        f116755a = new c();
    }

    public c() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SmallWindowQuestionCircleDialog r101 = new SmallWindowQuestionCircleDialog(r100.getContext());
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r101);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
    }
}
