package com.bytedance.android.live.ktv.common.ordersong.feedback;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvFeedbackDialog f70165a;

    public e(KtvFeedbackDialog r100) {
        this.f70165a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f70165a.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L12;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
