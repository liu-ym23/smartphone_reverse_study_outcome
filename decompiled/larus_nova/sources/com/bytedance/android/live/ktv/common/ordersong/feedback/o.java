package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes45.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMusicFeedbackDialog f70175a;

    public o(KtvMusicFeedbackDialog r100) {
        this.f70175a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        KtvMusicFeedbackDialog r101 = this.f70175a;
        int r102 = KtvMusicFeedbackDialog.f70149o;
        r101.T90();
        KtvMusicFeedbackDialog r103 = this.f70175a;
        r103.f70705d = null;
        r103.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L12;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
