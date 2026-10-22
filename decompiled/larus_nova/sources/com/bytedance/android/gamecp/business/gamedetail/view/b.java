package com.bytedance.android.gamecp.business.gamedetail.view;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseGamePromoteDetailDialogFragment f55751a;

    public b(BaseGamePromoteDetailDialogFragment r100) {
        this.f55751a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        du.a r101 = (du.a) r100;
        this.f55751a.dismiss();     // Catch: Exception -> L5
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
