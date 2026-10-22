package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenPlatformDebugFloatBall f84367a;

    public g(OpenPlatformDebugFloatBall r100) {
        this.f84367a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OpenPlatformDebugFloatBall r101 = this.f84367a;
        int r102 = OpenPlatformDebugFloatBall.f84358b;
        r101.getClass();
        DebugMenuDialog r103 = new DebugMenuDialog(r101.getContext(), r101.f84359a);
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
    }
}
