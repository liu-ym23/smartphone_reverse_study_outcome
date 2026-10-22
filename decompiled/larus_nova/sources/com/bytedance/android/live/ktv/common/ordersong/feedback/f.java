package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvFeedbackDialog f70166a;

    public f(KtvFeedbackDialog r100) {
        this.f70166a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        KtvFeedbackDialog r101 = this.f70166a;
        int r102 = KtvFeedbackDialog.f70132u;
        r101.T90();
        this.f70166a.dismiss();     // Catch: Exception -> L5
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
