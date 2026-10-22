package com.bytedance.android.live.livepkaudience.dialog;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes46.dex */
public final class u implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkWithAudienceFeedbackDialog f81850a;

    public u(PkWithAudienceFeedbackDialog r100) {
        this.f81850a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gd0.c r101 = this.f81850a.f81751k;
        if (r101 == null) goto L5;
        r101.onCancelClick();
    L5:
        this.f81850a.W90();
        this.f81850a.dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L15;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
