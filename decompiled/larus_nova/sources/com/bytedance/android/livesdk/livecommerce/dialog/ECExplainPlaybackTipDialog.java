package com.bytedance.android.livesdk.livecommerce.dialog;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/dialog/ECExplainPlaybackTipDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECExplainPlaybackTipDialog extends AppCompatDialog implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (Intrinsics.areEqual(r100, null) == false) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L14:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(this));
        return;
    }
}
