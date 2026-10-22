package com.bytedance.android.livesdk.chatroom.tetris.vr;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VrAudienceControlDialogLandscape f111933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f111934b;

    public l(VrAudienceControlDialogLandscape r100, boolean r101) {
        this.f111933a = r100;
        this.f111934b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r101 = this.f111933a.f111854d;
        if (r101 == null) goto L5;
        r101.notifyRecenter();
    L5:
        VrAudienceControlDialogLandscape.U90(this.f111933a, "restting", !this.f111934b);
        this.f111933a.dismiss();     // Catch: Exception -> L8
    L12:
        int r102 = r.f111945b;
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r103 = this.f111933a.f111854d;
        boolean r104 = false;
        if (r103 == null) goto L19;
        com.bytedance.live.datacontext.m<? extends Boolean> r105 = r103.isVrSensorOpen();
        if (r105 == null) goto L19;
        Boolean r106 = r105.getValue();
        if (r106 == null) goto L19;
        boolean r107 = r106.booleanValue();
    L20:
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r108 = this.f111933a.f111854d;
        if (r108 == null) goto L27;
        com.bytedance.live.datacontext.m<? extends Boolean> r109 = r108.isVrMode();
        if (r109 == null) goto L27;
        Boolean r110 = r109.getValue();
        if (r110 == null) goto L27;
        r104 = r110.booleanValue();
    L27:
        r.b("restting", r107, r104);
        return;
    L19:
        r107 = false;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r111 = DialogFragmentLancet.sLastShowStack;
        if (r111 == null) goto L12;
        com.bytedance.crash.d.d(r111, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }
}
