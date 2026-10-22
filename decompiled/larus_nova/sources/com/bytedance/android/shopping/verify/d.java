package com.bytedance.android.shopping.verify;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LawHintDialogFragment f187186a;

    public d(LawHintDialogFragment r100) {
        this.f187186a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LawHintDialogFragment r101 = this.f187186a;
        int r102 = LawHintDialogFragment.f187164p;
        r101.S90("cancel");
        this.f187186a.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L12;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
