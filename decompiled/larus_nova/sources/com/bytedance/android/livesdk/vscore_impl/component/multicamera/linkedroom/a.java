package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements MultiCameraLinkedRoomDialogWidget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeCameraLinkRoomDialog f159627a;

    @Override // com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.MultiCameraLinkedRoomDialogWidget.a
    public final void dismiss() {
        this.f159627a.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public a(LandscapeCameraLinkRoomDialog r100) {
        this.f159627a = r100;
    }
}
