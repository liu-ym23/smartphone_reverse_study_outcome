package com.bytedance.android.livesdk.common;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import androidx.core.view.GravityCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public class b extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f119691a;

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        com.bytedance.android.livesdk.f.d().f();
        com.bytedance.android.livesdk.e.b().d();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        Window r100 = getWindow();
        if (r100 == null) goto L9;
        r100.setBackgroundDrawable(new ColorDrawable(0));
        if (this.f119691a == false) goto L7;
        r100.setLayout(-1, -2);
        return;
    L7:
        r100.setLayout(-2, -1);
        return;
    }

    @Override // android.app.Dialog
    public void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.f.d().a();
        com.bytedance.android.livesdk.e.b().a();
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public b(Context r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = R.style.ttlive_CommonBottomDialog;
    L5:
        super(r100, r102);
        Window r103 = getWindow();
        if (r103 == null) goto L11;
        getWindow().requestFeature(1);
        if (r101 == false) goto L10;
        r103.setGravity(80);
        goto L11
    L10:
        r103.setGravity(GravityCompat.END);
    L11:
        this.f119691a = r101;
        return;
    L4:
        r102 = R.style.ttlive_CommonRightDialog;
        goto L5
    }
}
