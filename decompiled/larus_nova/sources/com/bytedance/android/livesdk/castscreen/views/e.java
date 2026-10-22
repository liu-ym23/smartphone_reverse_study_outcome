package com.bytedance.android.livesdk.castscreen.views;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TokenLoginDialogFragment f104901a;

    public e(TokenLoginDialogFragment r100) {
        this.f104901a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TokenLoginDialogFragment.b r101 = this.f104901a.f104754e;
        if (r101 == null) goto L13;
        r101.a();
    L13:
        this.f104901a.dismiss();     // Catch: Exception -> L8
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
