package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.DialogInterface;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes9.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UgcGiftSaleDialog f131101a;

    public n(UgcGiftSaleDialog r100) {
        this.f131101a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f131101a.dismissAllowingStateLoss();     // Catch: Exception -> L5
    L9:
        DialogInterface.OnDismissListener r101 = this.f131101a.f131014n;
        if (r101 == null) goto L15;
        r101.onDismiss(null);
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L9;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
