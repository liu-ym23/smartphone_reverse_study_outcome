package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkCancelMatchDialog f95525a;

    public c(PkCancelMatchDialog r100) {
        this.f95525a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PkCancelMatchDialog.T90(this.f95525a, "wait");
        this.f95525a.dismiss();     // Catch: Exception -> L5
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
