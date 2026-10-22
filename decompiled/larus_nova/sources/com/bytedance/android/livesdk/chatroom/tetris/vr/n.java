package com.bytedance.android.livesdk.chatroom.tetris.vr;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VrAudienceControlDialogLandscape f111937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f111938b;

    public n(VrAudienceControlDialogLandscape r100, boolean r101) {
        this.f111937a = r100;
        this.f111938b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        VrAudienceControlDialogLandscape r101 = this.f111937a;
        r101.f111864n = true;
        r101.T90("landscape", true ^ this.f111938b, MapsKt.mapOf(TuplesKt.to("landscape_type", "2")));
        this.f111937a.dismiss();     // Catch: Exception -> L5
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
