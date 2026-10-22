package com.bytedance.android.livesdk.chatroom.tetris.vr;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes7.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VrAudienceControlDialogLandscape f111935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f111936b;

    public m(VrAudienceControlDialogLandscape r100, boolean r101) {
        this.f111935a = r100;
        this.f111936b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r101 = this.f111935a.f111854d;
        if (r101 == null) goto L14;
        r101.enterVrMode();
    L14:
        this.f111935a.dismiss();     // Catch: Exception -> L8
    L12:
        VrAudienceControlDialogLandscape.U90(this.f111935a, "immersion", !this.f111936b);
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L12;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }
}
