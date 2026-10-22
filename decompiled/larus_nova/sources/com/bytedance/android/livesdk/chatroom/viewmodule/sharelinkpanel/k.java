package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLinkShareToThirdDialogFragment f115500a;

    public k(LiveLinkShareToThirdDialogFragment r100) {
        this.f115500a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LiveLinkShareToThirdDialogFragment.T90(this.f115500a, "cancel");
        this.f115500a.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
