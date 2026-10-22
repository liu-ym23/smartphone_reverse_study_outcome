package com.bytedance.ai.debugscene;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class v0 extends BottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w0.a f36524a;

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public v0(w0.a r100) {
        this.f36524a = r100;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 != 5) goto L21;
        BottomSheetDialog r102 = this.f36524a.f36541i;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r104 == null) goto L18;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L7:
        if (Looper.myLooper() == r103.getLooper()) goto L9;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    }
}
